package com.forexcrunch.forexcrunch.gui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.forexcrunch.forexcrunch.C0089R;
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
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import java.util.ArrayList;
import java.util.Stack;

@SuppressLint({"SetJavaScriptEnabled"})
public class NewsContentActivity extends SlidingFragmentActivity implements View.OnClickListener, AdListener, PullToRefreshBase.OnRefreshListener<WebView> {
    private LinearLayout aboutCont;
    private DfpAdView adView;
    private boolean addcreated = false;
    boolean big = false;
    private ImageButton btnComments;
    private ImageButton btnSave;
    private ImageButton btnShare;
    private ImageButton btnSideMenu;
    private TextView commentCount;
    String content;
    private EditText editText;
    ImageButton ib_bigger;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public PullToRefreshWebView mPullRefreshWebView;
    /* access modifiers changed from: private */
    public Post post;
    private LinearLayout savedArticlesCont;
    private LinearLayout settingsCont;
    private LinearLayout subscribeCont;
    TextView txtTime;
    TextView txtTitle;
    TextView txtWritter;
    /* access modifiers changed from: private */
    public Stack<String> urlStack = new Stack<>();
    /* access modifiers changed from: private */
    public boolean videoPlaying = false;
    WebView wvContent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0089R.layout.news_content_fragment);
        setBehindContentView((int) C0089R.layout.side_menu);
        this.post = NewsController.getInstance(this).getSelectedPost();
        initComponents();
        initMenuComponents();
        fillNewsInfo();
        setHTMLContent();
        setCommentCount();
        createAd();
    }

    /* access modifiers changed from: private */
    public void createAd() {
        if (!this.addcreated) {
            this.adView = new DfpAdView((Activity) this, new AdSize(320, 50), "/16866187/mobapp_320x50");
            ((LinearLayout) findViewById(C0089R.C0090id.f51ad)).addView(this.adView);
            this.adView.loadAd(new AdRequest());
            this.adView.setAdListener(this);
            this.addcreated = true;
        }
    }

    /* access modifiers changed from: private */
    public void setCommentCount() {
        if (this.post.getComments() == null || this.post.getComments().isEmpty()) {
            this.commentCount.setVisibility(8);
            this.btnComments.setEnabled(false);
            this.btnComments.setOnClickListener((View.OnClickListener) null);
            this.commentCount.setText("0");
            return;
        }
        this.commentCount.setText(new StringBuilder().append(this.post.getComments().size()).toString());
    }

    /* access modifiers changed from: private */
    public void setHTMLContent() {
        this.content = "<html><head><style type='text/css'>img {width:" + getResources().getInteger(C0089R.integer.html_image_width) + "px; height:auto;} * {width:" + getResources().getInteger(C0089R.integer.html_image_width) + "px; height:auto;} .printfriendly img{width:auto; height:auto;}</style><body>" + this.content + "</body></html>";
        if (Build.VERSION.SDK_INT >= 8) {
            this.wvContent.loadData(Base64.encodeToString(this.content.getBytes(), 0), "text/html; charset=utf-8", "base64");
            return;
        }
        this.wvContent.loadData(String.valueOf("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>") + this.content, "text/html; chartset=UTF-8", (String) null);
    }

    /* access modifiers changed from: private */
    public void fillNewsInfo() {
        String title = this.post.getTitle();
        String date = this.post.getModified();
        String writter = this.post.getAuthor().getName();
        this.content = this.post.getContent();
        this.txtTime.setText("last edited " + date.substring(0, date.length() - 3));
        Log.v("title", title);
        this.txtTitle.setText(title);
        if (this.txtTitle.getText().toString().contains("&#8211")) {
            this.txtTitle.setText(this.txtTitle.getText().toString().replace("&#8211;", "-"));
        }
        this.txtWritter.setText("Written by " + writter);
    }

    /* access modifiers changed from: private */
    public void initComponents() {
        this.txtTitle = (TextView) findViewById(C0089R.C0090id.NewsContentFragment_txt_title);
        this.commentCount = (TextView) findViewById(C0089R.C0090id.NewsContentFragment_commentCount);
        this.ib_bigger = (ImageButton) findViewById(C0089R.C0090id.NewsContentFragment_bigger);
        this.ib_bigger.setOnClickListener(this);
        this.txtTime = (TextView) findViewById(C0089R.C0090id.NewsContentFragment_txt_time);
        this.txtWritter = (TextView) findViewById(C0089R.C0090id.NewsContentFragment_txt_writter);
        this.mPullRefreshWebView = (PullToRefreshWebView) findViewById(C0089R.C0090id.NewsContentFragment_webkit);
        this.mPullRefreshWebView.setOnRefreshListener(this);
        this.wvContent = (WebView) this.mPullRefreshWebView.getRefreshableView();
        this.wvContent.getSettings().setDefaultTextEncodingName("utf-8");
        this.wvContent.getSettings().setJavaScriptEnabled(true);
        this.wvContent.setBackgroundColor(getResources().getColor(C0089R.color.bg_lectura));
        this.wvContent.setWebViewClient(new CustomWebViewClient(this, (CustomWebViewClient) null));
        this.wvContent.setWebChromeClient(new WebChromeClient() {
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
                NewsContentActivity.this.videoPlaying = true;
                if (view instanceof FrameLayout) {
                    FrameLayout frame = (FrameLayout) view;
                    if (frame.getFocusedChild() instanceof VideoView) {
                        VideoView video = (VideoView) frame.getFocusedChild();
                        frame.removeView(video);
                        NewsContentActivity.this.videoPlaying = true;
                        video.start();
                    }
                }
            }
        });
        this.btnSideMenu = (ImageButton) findViewById(C0089R.C0090id.NewsContentFragment_menu);
        this.btnSideMenu.setOnClickListener(this);
        this.btnSave = (ImageButton) findViewById(C0089R.C0090id.NewsContentFragment_save);
        this.btnSave.setOnClickListener(this);
        this.btnShare = (ImageButton) findViewById(C0089R.C0090id.NewsContentFragment_share);
        this.btnShare.setOnClickListener(this);
        this.btnComments = (ImageButton) findViewById(C0089R.C0090id.NewsContentFragment_comments);
        this.btnComments.setOnClickListener(this);
        this.editText = (EditText) findViewById(C0089R.idSideMenu.search);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 3) {
                    return false;
                }
                NewsContentActivity.this.performSearch(v.getText().toString());
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void performSearch(String searchFor) {
        new SearchNewsTask(searchFor).execute(new String[0]);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.C0090id.NewsContentFragment_menu:
                toggle();
                return;
            case C0089R.C0090id.NewsContentFragment_bigger:
                changeFontSize();
                return;
            case C0089R.C0090id.NewsContentFragment_comments:
                showComments();
                return;
            case C0089R.C0090id.NewsContentFragment_share:
                showSharePostDialog();
                return;
            case C0089R.C0090id.NewsContentFragment_save:
                if (!isAlreadySaved()) {
                    savePostInPreferences();
                    return;
                }
                return;
            default:
                onClickMenuItems(v);
                return;
        }
    }

    private void showComments() {
        startActivity(new Intent(this, CommentsActivity.class));
    }

    private void changeFontSize() {
        if (!this.big) {
            this.wvContent.getSettings().setDefaultFontSize(22);
            this.big = true;
            this.wvContent.reload();
            return;
        }
        this.wvContent.getSettings().setDefaultFontSize(16);
        this.big = false;
        this.wvContent.reload();
    }

    private void savePostInPreferences() {
        String savedArticles;
        Gson gson = new Gson();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String savedArticles2 = pref.getString(getString(C0089R.string.saved_articles_preferences), "");
        if (savedArticles2.equals("")) {
            savedArticles = "[" + gson.toJson((Object) this.post) + "]";
        } else {
            savedArticles = String.valueOf(savedArticles2.substring(0, savedArticles2.length() - 2)) + "} , " + gson.toJson((Object) this.post) + "]";
        }
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(getString(C0089R.string.saved_articles_preferences), savedArticles);
        editor.commit();
        Toast.makeText(this, getString(C0089R.string.article_saved), 0).show();
    }

    /* access modifiers changed from: private */
    public void initMenuComponents() {
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
    }

    public void onClickMenuItems(View view) {
        switch (view.getId()) {
            case C0089R.idSideMenu.savedArticlesContainer:
                startActivity(new Intent(this, SavedArticlesActivity.class));
                return;
            case C0089R.idSideMenu.settingsContainer:
                startActivity(new Intent(this, SettingsActivity.class));
                return;
            case C0089R.idSideMenu.subscribeContainer:
                startActivity(new Intent(this, SubscribeActivity.class));
                return;
            case C0089R.idSideMenu.aboutContainer:
                startActivity(new Intent(this, AboutActivity.class));
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
            this.dialog = ProgressDialog.show(NewsContentActivity.this, (CharSequence) null, "Loading");
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                this.searchResults = WSController.requestSearch(NewsContentActivity.this, this.searchFor);
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
            Dialog dialog2 = GuiUtil.showErrorDialog(NewsContentActivity.this, NewsContentActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!NewsContentActivity.this.isDialogShowing) {
                    dialog2.show();
                    NewsContentActivity.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    NewsContentActivity.this.isDialogShowing = false;
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
                Dialog dialog2 = GuiUtil.showErrorDialog(NewsContentActivity.this, NewsContentActivity.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!NewsContentActivity.this.isDialogShowing) {
                        dialog2.show();
                        NewsContentActivity.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        NewsContentActivity.this.isDialogShowing = false;
                    }
                });
            } else if (this.searchResults != null && !this.searchResults.isEmptyOrNullPostList()) {
                NewsController.getInstance(NewsContentActivity.this).setSearchResults(this.searchResults);
                GuiUtil.showSearchResultsActivity(NewsContentActivity.this, this.searchFor);
            }
        }
    }

    private void showSharePostDialog() {
        Dialog dialog = GuiUtil.showShareDialog(this, this.post.getUrl(), this.post.getTitle(), false);
        synchronized (this) {
            if (!this.isDialogShowing) {
                dialog.show();
                this.isDialogShowing = true;
            }
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    NewsContentActivity.this.isDialogShowing = false;
                }
            });
        }
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

    private boolean isAlreadySaved() {
        ArrayList<Post> savedArticles = Utils.getSavedArticlesFromPreferences(this);
        if (savedArticles != null) {
            for (int i = 0; i < savedArticles.size(); i++) {
                if (savedArticles.get(i).getId() == this.post.getId()) {
                    Toast.makeText(this, getString(C0089R.string.article_already_saved), 0).show();
                    return true;
                }
            }
        }
        return false;
    }

    private class CustomWebViewClient extends WebViewClient {
        private CustomWebViewClient() {
        }

        /* synthetic */ CustomWebViewClient(NewsContentActivity newsContentActivity, CustomWebViewClient customWebViewClient) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
            Log.i("shouldOverrideUrlLoading", url);
            if (!url.contains("forexcrunch.com") || url.contains("/category")) {
                Intent linkIntent = new Intent(NewsContentActivity.this.getApplicationContext(), WebViewActivity.class);
                linkIntent.putExtra("url", url);
                NewsContentActivity.this.startActivity(linkIntent);
                return true;
            }
            NewsContentActivity.this.urlStack.push(NewsContentActivity.this.post.getUrl());
            new RequestPostTask(String.valueOf(url) + "?json=1").execute(new Void[0]);
            return true;
        }
    }

    public void onDestroy() {
        if (this.adView != null) {
            this.adView.destroy();
        }
        super.onDestroy();
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

    class RequestPostTask extends AsyncTask<Void, Void, Void> {
        Post auxPost;
        ProgressDialog dialog;
        String url;

        public RequestPostTask(String url2) {
            this.url = url2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(NewsContentActivity.this, (CharSequence) null, "Loading");
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... arg0) {
            try {
                this.auxPost = WSController.getPost(this.url);
                return null;
            } catch (Exception e) {
                if (this.dialog != null && this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
                cancel(true);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Dialog dialog2 = GuiUtil.showErrorDialog(NewsContentActivity.this, NewsContentActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!NewsContentActivity.this.isDialogShowing) {
                    dialog2.show();
                    NewsContentActivity.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    NewsContentActivity.this.isDialogShowing = false;
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
                Dialog dialog2 = GuiUtil.showErrorDialog(NewsContentActivity.this, NewsContentActivity.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!NewsContentActivity.this.isDialogShowing) {
                        dialog2.show();
                        NewsContentActivity.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        NewsContentActivity.this.isDialogShowing = false;
                    }
                });
            } else if (this.auxPost != null) {
                NewsContentActivity.this.post = this.auxPost;
                NewsContentActivity.this.initComponents();
                NewsContentActivity.this.initMenuComponents();
                NewsContentActivity.this.fillNewsInfo();
                NewsContentActivity.this.setHTMLContent();
                NewsContentActivity.this.setCommentCount();
                NewsContentActivity.this.createAd();
            }
        }
    }

    public void onBackPressed() {
        if (!this.urlStack.empty()) {
            new RequestPostTask(String.valueOf(this.urlStack.pop()) + "?json=1").execute(new Void[0]);
            return;
        }
        this.wvContent.loadUrl("file:///android_asset/nonexistent.html");
        super.onBackPressed();
    }

    public void onRefresh(PullToRefreshBase<WebView> pullToRefreshBase) {
        new RequestRefreshPostTask(this.post.getUrl()).execute(new Void[0]);
    }

    class RequestRefreshPostTask extends AsyncTask<Void, Void, Void> {
        Post auxPost;
        ProgressDialog dialog;
        String url;

        public RequestRefreshPostTask(String url2) {
            this.url = url2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... arg0) {
            try {
                this.auxPost = WSController.getPost(String.valueOf(this.url) + "?json=1");
                return null;
            } catch (Exception e) {
                Log.e("refresh", "ERROR" + e.toString());
                e.printStackTrace();
                cancel(true);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            Log.e("refresh", "ERROR");
            NewsContentActivity.this.mPullRefreshWebView.onRefreshComplete();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            Log.i("refresh", this.auxPost.getUrl());
            if (this.auxPost != null) {
                NewsContentActivity.this.post = this.auxPost;
                NewsContentActivity.this.setHTMLContent();
                NewsContentActivity.this.setCommentCount();
            }
            NewsContentActivity.this.mPullRefreshWebView.onRefreshComplete();
            super.onPostExecute(result);
        }
    }
}
