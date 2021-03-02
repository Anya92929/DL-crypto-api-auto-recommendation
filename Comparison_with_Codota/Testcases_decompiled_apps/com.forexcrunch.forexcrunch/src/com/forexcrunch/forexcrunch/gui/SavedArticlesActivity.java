package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.NewsSimpleListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.Category;
import com.forexcrunch.forexcrunch.model.DropDownIconItem;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import java.util.ArrayList;
import java.util.Iterator;

public class SavedArticlesActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener, AdListener {
    private DfpAdView adView;
    private NewsSimpleListAdapter adapter;
    /* access modifiers changed from: private */
    public int lastSelectedOption = 0;
    private ListView list;
    private LinearLayout optContainer;
    private ImageView optIcon;
    private DisplayImageOptions options;
    private ArrayList<DropDownIconItem> optionsList;
    private ArrayList<Post> posts;
    private TextView tvOptionName;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.saved_articles_activity);
        initComponents();
        this.posts = getSavedArticlesFromPreferences();
        this.list = (ListView) findViewById(C0089R.idSavedArticles.list);
        this.list.setOnItemClickListener(this);
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        if (checkPosts()) {
            setOptionImageAndText(0);
        }
        createAd();
    }

    private void initComponents() {
        this.tvOptionName = (TextView) findViewById(C0089R.idSavedArticles.optName);
        this.optIcon = (ImageView) findViewById(C0089R.idSavedArticles.optionIcon);
        this.optContainer = (LinearLayout) findViewById(C0089R.idSavedArticles.optionContainer);
        this.optContainer.setOnClickListener(this);
    }

    public boolean checkPosts() {
        if (this.posts != null) {
            return true;
        }
        this.list.setVisibility(8);
        ((TextView) findViewById(C0089R.idSavedArticles.errNoSavedNews)).setVisibility(0);
        this.optContainer.setEnabled(false);
        return false;
    }

    public ArrayList<Post> getSavedArticlesFromPreferences() {
        return Utils.getSavedArticlesFromPreferences(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        NewsController.getInstance(this).setSelectedPost(((NewsSimpleListAdapter) this.list.getAdapter()).getItems().get(position));
        startActivity(new Intent(this, NewsContentActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }

    private void showOptionsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, C0089R.style.AlertDialogCustom));
        builder.setTitle(C0089R.string.select).setSingleChoiceItems(C0089R.array.saved_articles_categories, this.lastSelectedOption, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                SavedArticlesActivity.this.setOptionImageAndText(which);
                SavedArticlesActivity.this.lastSelectedOption = which;
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void setOptionImageAndText(int position) {
        String name = "All";
        int id = C0089R.drawable.all_svd_art;
        switch (position) {
            case 1:
                name = getString(C0089R.string.menu_daily);
                id = C0089R.drawable.daily_svd_art;
                break;
            case 2:
                name = getString(C0089R.string.menu_weekly);
                id = C0089R.drawable.week_svd_art;
                break;
            case 3:
                name = getString(C0089R.string.menu_news);
                id = C0089R.drawable.news_svd_art;
                break;
            case 4:
                name = getString(C0089R.string.major);
                id = C0089R.drawable.major_svd_art;
                break;
            case 5:
                name = getString(C0089R.string.minor);
                id = C0089R.drawable.major_svd_art;
                break;
            case 6:
                name = getString(C0089R.string.basic);
                id = C0089R.drawable.major_svd_art;
                break;
        }
        this.tvOptionName.setText(name);
        this.optIcon.setImageResource(id);
        filterItems(getCategoryIdByOptionIndex(position));
    }

    private void filterItems(ArrayList<Integer> categoryList) {
        if (!categoryList.isEmpty()) {
            ArrayList<Post> filteredList = getPostsByCategory(categoryList);
            if (this.adapter == null) {
                this.adapter = new NewsSimpleListAdapter(this, C0089R.layout.news_simple_list_item, filteredList, this.options, -1, true);
                this.list.setAdapter(this.adapter);
                return;
            }
            this.adapter.setItems(filteredList);
            this.list.setAdapter(this.adapter);
            this.adapter.notifyDataSetChanged();
        } else if (this.adapter == null) {
            this.adapter = new NewsSimpleListAdapter(this, C0089R.layout.news_simple_list_item, this.posts, this.options, -1, true);
            this.list.setAdapter(this.adapter);
        } else {
            this.adapter.setItems(this.posts);
            this.list.setAdapter(this.adapter);
            this.adapter.notifyDataSetChanged();
        }
    }

    private ArrayList<Post> getPostsByCategory(ArrayList<Integer> categories) {
        ArrayList<Post> filtered = new ArrayList<>();
        Iterator<Post> it = this.posts.iterator();
        while (it.hasNext()) {
            Post current = it.next();
            if (current.getCategories() != null && !current.getCategories().isEmpty()) {
                Iterator<Category> it2 = current.getCategories().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (categories.contains(Integer.valueOf(it2.next().getId()))) {
                            filtered.add(current);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return filtered;
    }

    private ArrayList<Integer> getCategoryIdByOptionIndex(int position) {
        ArrayList<Integer> categoryIds = new ArrayList<>();
        switch (position) {
            case 1:
                categoryIds.add(21);
                categoryIds.add(Integer.valueOf(News.EUR_USD_DAILY));
                break;
            case 2:
                categoryIds.add(Integer.valueOf(News.WEEKLY_FOREX_FORECAST));
                categoryIds.add(512);
                categoryIds.add(Integer.valueOf(News.EUR_USD_FORECAST));
                categoryIds.add(Integer.valueOf(News.CANADIAN_DOLAR));
                categoryIds.add(Integer.valueOf(News.NZR_USD_FORECAST));
                categoryIds.add(Integer.valueOf(News.USD_CHF_FORECAST));
                categoryIds.add(Integer.valueOf(News.MAJORS));
                categoryIds.add(Integer.valueOf(News.USD_JPY_FORECAST));
                categoryIds.add(Integer.valueOf(News.AUD_USD_DAILY));
                break;
            case 3:
                categoryIds.add(53);
                categoryIds.add(Integer.valueOf(News.FOREX_BITS));
                categoryIds.add(Integer.valueOf(News.FOREX_INDUSTRY));
                categoryIds.add(38);
                break;
            case 4:
                categoryIds.add(Integer.valueOf(News.MAJORS));
                break;
            case 5:
                categoryIds.add(Integer.valueOf(News.MINORS));
                break;
            case 6:
                categoryIds.add(Integer.valueOf(News.BASICS_INDUSTRY));
                break;
        }
        return categoryIds;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0089R.idSavedArticles.optionContainer:
                showOptionsAlert();
                return;
            default:
                return;
        }
    }

    private void createAd() {
        this.adView = new DfpAdView((Activity) this, new AdSize(320, 50), "/16866187/mobapp_320x50");
        ((LinearLayout) findViewById(C0089R.idSavedArticles.f55ad)).addView(this.adView);
        this.adView.loadAd(new AdRequest());
        this.adView.setAdListener(this);
    }

    public void onDismissScreen(C0165Ad arg0) {
    }

    public void onFailedToReceiveAd(C0165Ad arg0, AdRequest.ErrorCode arg1) {
    }

    public void onLeaveApplication(C0165Ad arg0) {
    }

    public void onPresentScreen(C0165Ad arg0) {
    }

    public void onReceiveAd(C0165Ad arg0) {
    }
}
