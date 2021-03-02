package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.NewsSimpleListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import p006eu.erikw.PullToRefreshListView;

public class TrendingActivity extends SlidingFragmentActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdListener {
    private LinearLayout aboutCont;
    private DfpAdView adView;
    private ImageButton btnSideMenu;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private Intent intent;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public PullToRefreshListView list;
    /* access modifiers changed from: private */
    public News newsEURUSD;
    /* access modifiers changed from: private */
    public News newsList;
    /* access modifiers changed from: private */
    public News newsListOpinions;
    private DisplayImageOptions options;
    private LinearLayout savedArticlesCont;
    private EditText searchEditText;
    private LinearLayout settingsCont;
    private LinearLayout subscribeCont;
    private News trendingNewsList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0089R.layout.trending_activity);
        setBehindContentView((int) C0089R.layout.side_menu);
        initSideMenu();
        this.list = (PullToRefreshListView) findViewById(C0089R.C0090id.TrendingActivity_listview);
        this.list.setOnItemClickListener(this);
        this.list.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            public void onRefresh() {
                new FetchNewsTask().execute(new String[0]);
            }
        });
        this.btnSideMenu = (ImageButton) findViewById(C0089R.C0090id.TrendingActivity_sideMenuBtn);
        this.btnSideMenu.setOnClickListener(this);
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        initTrendingList();
        createAd();
    }

    private void initSideMenu() {
        SlidingMenu sm = getSlidingMenu();
        sm.setTouchModeAbove(2);
        sm.setShadowWidthRes(C0089R.dimen.shadow_width);
        sm.setShadowDrawable((int) C0089R.drawable.shadow);
        sm.setBehindOffsetRes(C0089R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        this.savedArticlesCont = (LinearLayout) findViewById(C0089R.idSideMenu.savedArticlesContainer);
        this.savedArticlesCont.setOnClickListener(this);
        this.settingsCont = (LinearLayout) findViewById(C0089R.idSideMenu.settingsContainer);
        this.settingsCont.setOnClickListener(this);
        this.aboutCont = (LinearLayout) findViewById(C0089R.idSideMenu.aboutContainer);
        this.aboutCont.setOnClickListener(this);
        this.subscribeCont = (LinearLayout) findViewById(C0089R.idSideMenu.subscribeContainer);
        this.subscribeCont.setOnClickListener(this);
        this.searchEditText = (EditText) findViewById(C0089R.idSideMenu.search);
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 3) {
                    return false;
                }
                TrendingActivity.this.performSearch(v.getText().toString());
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void performSearch(String searchFor) {
        new SearchNewsTask(searchFor).execute(new String[0]);
    }

    private void initTrendingList() {
        this.newsList = NewsController.getInstance(this).getNewsNews();
        this.newsListOpinions = NewsController.getInstance(this).getOpinionsNews();
        this.newsEURUSD = NewsController.getInstance(this).getEurusdNews();
        ArrayList<Post> temp = new ArrayList<>();
        temp.add(this.newsEURUSD.getPostsList().get(0));
        this.newsEURUSD.setPostsList(temp);
        createTrendingNews();
        sortByComments();
    }

    public void createTrendingNews() {
        this.trendingNewsList = new News();
        News temp = new News();
        temp.setPostsList(GuiUtil.mergePosts(this.newsList.getPostsList(), this.newsListOpinions.getPostsList()));
        this.trendingNewsList.setPostsList(GuiUtil.mergePosts(temp.getPostsList(), this.newsEURUSD.getPostsList()));
    }

    public void sortByComments() {
        Collections.sort(this.trendingNewsList.getPostsList(), new Comparator<Post>() {
            public int compare(Post p1, Post p2) {
                return -(p1.getComment_count() - p2.getComment_count());
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        Post item = ((NewsSimpleListAdapter) this.list.getAdapter()).getItems().get(position);
        addReadPostToPreferences(item.getId());
        NewsController.getInstance(this).setSelectedPost(item);
        startActivity(new Intent(this, NewsContentActivity.class));
    }

    private void addReadPostToPreferences(int id) {
        int category = ((NewsSimpleListAdapter) this.list.getAdapter()).getCategory();
        ArrayList<Integer> readMsgIds = Utils.createIdsList(this, category);
        if (readMsgIds.isEmpty()) {
            readMsgIds.add(Integer.valueOf(id));
        } else if (!readMsgIds.contains(Integer.valueOf(id))) {
            readMsgIds.add(Integer.valueOf(id));
        }
        Utils.idListToPreferences(this, readMsgIds, category);
    }

    public void onResume() {
        if (this.list.getAdapter() != null || this.trendingNewsList == null) {
            ((NewsSimpleListAdapter) this.list.getAdapter()).notifyDataSetChanged();
        } else {
            this.list.setAdapter(new NewsSimpleListAdapter(this, C0089R.layout.news_simple_list_item, this.trendingNewsList.getPostsList(), this.options, News.TRENDING));
        }
        super.onResume();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0089R.C0090id.TrendingActivity_sideMenuBtn:
                toggle();
                return;
            case C0089R.idSideMenu.savedArticlesContainer:
                this.intent = new Intent(this, SavedArticlesActivity.class);
                startActivity(this.intent);
                return;
            case C0089R.idSideMenu.settingsContainer:
                this.intent = new Intent(this, SettingsActivity.class);
                startActivity(this.intent);
                return;
            case C0089R.idSideMenu.subscribeContainer:
                this.intent = new Intent(this, SubscribeActivity.class);
                startActivity(this.intent);
                return;
            case C0089R.idSideMenu.aboutContainer:
                this.intent = new Intent(this, AboutActivity.class);
                startActivity(this.intent);
                return;
            default:
                return;
        }
    }

    class SearchNewsTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        Dialog errDialog;
        String response;
        String searchFor;
        News searchResults;

        public SearchNewsTask(String searchFor2) {
            this.searchFor = searchFor2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(TrendingActivity.this, (CharSequence) null, TrendingActivity.this.getString(C0089R.string.loading));
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                this.searchResults = WSController.requestSearch(TrendingActivity.this, this.searchFor);
                return null;
            } catch (Exception e) {
                if (this.dialog != null && this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Dialog dialog2 = GuiUtil.showErrorDialog(TrendingActivity.this, TrendingActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!TrendingActivity.this.isDialogShowing) {
                    dialog2.show();
                    TrendingActivity.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    TrendingActivity.this.isDialogShowing = false;
                }
            });
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (isCancelled()) {
                Dialog dialog2 = GuiUtil.showErrorDialog(TrendingActivity.this, TrendingActivity.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!TrendingActivity.this.isDialogShowing) {
                        dialog2.show();
                        TrendingActivity.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        TrendingActivity.this.isDialogShowing = false;
                    }
                });
            } else if (this.searchResults != null && !this.searchResults.isEmptyOrNullPostList()) {
                NewsController.getInstance(TrendingActivity.this).setSearchResults(this.searchResults);
                GuiUtil.showSearchResultsActivity(TrendingActivity.this, this.searchFor);
            }
        }
    }

    private void createAd() {
        this.adView = new DfpAdView((Activity) this, new AdSize(320, 50), "/16866187/mobapp_320x50");
        ((LinearLayout) findViewById(C0089R.C0090id.TrendingActivity_ad)).addView(this.adView);
        this.adView.loadAd(new AdRequest());
        this.adView.setAdListener(this);
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

    class FetchNewsTask extends AsyncTask<String, Void, Void> {
        NewsController controller;

        FetchNewsTask() {
            this.controller = NewsController.getInstance(TrendingActivity.this.getApplicationContext());
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                TrendingActivity.this.newsList = WSController.getNewsFromJson(TrendingActivity.this.getApplicationContext(), 53);
                TrendingActivity.this.newsListOpinions = WSController.getNewsFromJson(TrendingActivity.this.getApplicationContext(), 38);
                TrendingActivity.this.newsEURUSD = WSController.getNewsFromJson(TrendingActivity.this.getApplicationContext(), News.EUR_USD_DAILY, 1);
            } catch (Exception e) {
                e.printStackTrace();
                cancel(true);
            }
            NewsController.getInstance(TrendingActivity.this.getApplicationContext()).setNewsNews(TrendingActivity.this.newsList);
            NewsController.getInstance(TrendingActivity.this.getApplicationContext()).setOpinionsNews(TrendingActivity.this.newsListOpinions);
            NewsController.getInstance(TrendingActivity.this.getApplicationContext()).setFirstEURUSD(TrendingActivity.this.newsEURUSD);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            TrendingActivity.this.createTrendingNews();
            TrendingActivity.this.sortByComments();
            TrendingActivity.this.list.onRefreshComplete();
            super.onPostExecute(result);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            TrendingActivity.this.list.onRefreshComplete();
            Dialog dialog = GuiUtil.showErrorDialog((FragmentActivity) TrendingActivity.this.getApplicationContext(), TrendingActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!TrendingActivity.this.isDialogShowing) {
                    dialog.show();
                    TrendingActivity.this.isDialogShowing = true;
                }
            }
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    TrendingActivity.this.isDialogShowing = false;
                }
            });
            super.onCancelled();
        }
    }
}
