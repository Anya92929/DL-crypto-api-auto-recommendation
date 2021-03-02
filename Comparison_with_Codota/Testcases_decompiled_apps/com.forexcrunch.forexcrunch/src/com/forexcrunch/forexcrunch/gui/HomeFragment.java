package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.content.AsyncTaskLoader;
import android.support.p000v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.ImagePagerAdapter;
import com.forexcrunch.forexcrunch.custom.NewsSimpleListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.forexcrunch.forexcrunch.p003ga.GaTask;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.C0165Ad;
import com.google.ads.InterstitialAd;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import p006eu.erikw.PullToRefreshListView;

public class HomeFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, AdListener {
    private static final int LATEST = 0;
    private static final int NEWS = 1;
    private static final int OPINIONS = 2;
    private long SCROLL_DELAY = 5000;
    /* access modifiers changed from: private */
    public Activity activity;
    private ImagePagerAdapter adapter;
    private Button buttonPager;
    private LinearLayout contBasic;
    private LinearLayout contMajors;
    private LinearLayout contMinors;
    /* access modifiers changed from: private */
    public AutoPlayPagerTask currentTask;
    /* access modifiers changed from: private */
    public Handler handler;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private InterstitialAd interstitialAd;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    private boolean itemClicked;
    /* access modifiers changed from: private */
    public PullToRefreshListView list;
    private FrameLayout listContainer;
    private CirclePageIndicator mIndicator;
    private AsyncTaskLoader moreTask;
    /* access modifiers changed from: private */
    public News newsLatest;
    /* access modifiers changed from: private */
    public News newsNews;
    /* access modifiers changed from: private */
    public News newsOpinions;
    /* access modifiers changed from: private */
    public int newsType = 0;
    /* access modifiers changed from: private */
    public DisplayImageOptions options;
    public ViewPager pager;
    private FrameLayout pagerContainer;
    private int position;
    /* access modifiers changed from: private */
    public boolean refreshCancelled = false;
    private ImageButton tabLatest;
    private ImageButton tabMore;
    private ImageButton tabNews;
    private ImageButton tabOpinions;
    /* access modifiers changed from: private */
    public AsyncTask taskRefresh;
    private Timer timer;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.interstitialAd = new InterstitialAd(getActivity(), "/16866187/mobAPP_interstitial_smartbanner");
        this.interstitialAd.setAdListener(this);
        this.interstitialAd.loadAd(new AdRequest());
        this.interstitialAd.setAdListener(this);
        return inflater.inflate(C0089R.layout.home_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.activity = getActivity();
        initComponents();
        this.tabLatest.setSelected(true);
        NewsController controller = NewsController.getInstance(getActivity());
        this.newsLatest = controller.getLatestNews();
        this.newsNews = controller.getNewsNews();
        this.newsOpinions = controller.getOpinionsNews();
        if (this.newsLatest == null || this.newsNews == null || this.newsOpinions == null) {
            new FetchNewsTask(5).execute(new String[0]);
        } else {
            initPager();
        }
        this.moreTask = new FetchMoreNewsDataTask(getActivity());
        this.moreTask.forceLoad();
    }

    public void onResume() {
        if (this.list.getAdapter() == null && this.newsLatest != null && this.newsLatest.getPostsList() != null) {
            this.list.setAdapter(new NewsSimpleListAdapter(getActivity(), C0089R.layout.news_simple_list_item, this.newsLatest.getPostsList(), this.options, 0));
        } else if (!(this.list == null || this.list.getAdapter() == null)) {
            ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        }
        super.onResume();
    }

    private void initComponents() {
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        this.tabLatest = (ImageButton) getView().findViewById(C0089R.C0090id.HomeActivity_tabLatest);
        this.tabLatest.setOnClickListener(this);
        this.tabMore = (ImageButton) getView().findViewById(C0089R.C0090id.HomeActivity_tabMore);
        this.tabMore.setOnClickListener(this);
        this.tabNews = (ImageButton) getView().findViewById(C0089R.C0090id.HomeActivity_tabNews);
        this.tabNews.setOnClickListener(this);
        this.tabOpinions = (ImageButton) getView().findViewById(C0089R.C0090id.HomeActivity_tabOpinions);
        this.tabOpinions.setOnClickListener(this);
        this.contMajors = (LinearLayout) getView().findViewById(C0089R.idMoreItem.majorCont);
        this.contMajors.setOnClickListener(this);
        this.contMinors = (LinearLayout) getView().findViewById(C0089R.idMoreItem.minorCont);
        this.contMinors.setOnClickListener(this);
        this.contBasic = (LinearLayout) getView().findViewById(C0089R.idMoreItem.basicCont);
        this.contBasic.setOnClickListener(this);
        this.listContainer = (FrameLayout) getView().findViewById(C0089R.C0090id.HomeActivity_list_container);
        this.list = (PullToRefreshListView) getView().findViewById(C0089R.C0090id.HomeActivity_list);
        this.list.setOnItemClickListener(this);
        this.list.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            public void onRefresh() {
                HomeFragment.this.taskRefresh = new FetchNewsTask(6).execute(new String[0]);
            }
        });
        this.pager = (ViewPager) getView().findViewById(C0089R.C0090id.HomeActivity_pager);
        this.mIndicator = (CirclePageIndicator) getView().findViewById(C0089R.C0090id.indicator);
        this.pagerContainer = (FrameLayout) getView().findViewById(C0089R.C0090id.HomeActivity_pagerContainer);
        this.itemClicked = false;
    }

    /* access modifiers changed from: private */
    public void initPager() {
        ArrayList<Post> pagerItems = new ArrayList<>();
        pagerItems.add(this.newsNews.getPostsList().get(0));
        pagerItems.add(this.newsOpinions.getPostsList().get(0));
        pagerItems.add(NewsController.getInstance(getActivity()).getEurusdNews().getPostsList().get(0));
        if (this.adapter == null) {
            this.adapter = new ImagePagerAdapter(pagerItems, this.activity, this.imageLoader, this.options);
        }
        this.pager.setAdapter(this.adapter);
        this.mIndicator.setViewPager(this.pager);
        if (this.handler == null) {
            this.handler = new Handler();
        }
        if (this.timer == null) {
            this.timer = new Timer();
            this.timer.schedule(new MyTimerTask(), this.SCROLL_DELAY, this.SCROLL_DELAY);
        }
    }

    public boolean checkListLoaded(News news) {
        if (news == null) {
            return false;
        }
        return true;
    }

    public void onClick(View v) {
        if (v.getId() == C0089R.idMoreItem.majorCont) {
            if (this.moreTask != null) {
                this.moreTask.cancelLoad();
            }
            new FetchNewsTask(News.MAJORS).execute(new String[0]);
        } else if (v.getId() == C0089R.idMoreItem.minorCont) {
            if (this.moreTask != null) {
                this.moreTask.cancelLoad();
            }
            new FetchNewsTask(News.MINORS).execute(new String[0]);
        } else if (v.getId() == C0089R.idMoreItem.basicCont) {
            if (this.moreTask != null) {
                this.moreTask.cancelLoad();
            }
            new FetchNewsTask(News.BASICS_INDUSTRY).execute(new String[0]);
        } else {
            diselectAllTabs();
            v.setSelected(true);
            checkTask();
            switch (v.getId()) {
                case C0089R.C0090id.HomeActivity_tabLatest:
                    new GaTask(getActivity(), 0, "ui_action", "Latest Button Tap", "Latest Button Tap,View: Home").execute(new Void[0]);
                    this.listContainer.setVisibility(0);
                    this.list.setVisibility(0);
                    showLatestNews();
                    this.newsType = 0;
                    return;
                case C0089R.C0090id.HomeActivity_tabNews:
                    new GaTask(getActivity(), 0, "ui_action", "News Button Tap", "News Button Tap,View: Home").execute(new Void[0]);
                    this.listContainer.setVisibility(0);
                    this.list.setVisibility(0);
                    showNews();
                    this.newsType = 1;
                    return;
                case C0089R.C0090id.HomeActivity_tabOpinions:
                    new GaTask(getActivity(), 0, "ui_action", "Opinions Button Tap", "Opinions Button Tap,View: Home").execute(new Void[0]);
                    this.listContainer.setVisibility(0);
                    this.list.setVisibility(0);
                    showOpnions();
                    this.newsType = 2;
                    return;
                case C0089R.C0090id.HomeActivity_tabMore:
                    new GaTask(getActivity(), 0, "ui_action", "More Button Tap", "More Button Tap,View: Home").execute(new Void[0]);
                    this.list.setVisibility(8);
                    this.listContainer.setVisibility(8);
                    showMore();
                    return;
                default:
                    return;
            }
        }
    }

    private void checkTask() {
        if (this.taskRefresh != null && this.taskRefresh.getStatus() == AsyncTask.Status.RUNNING) {
            this.refreshCancelled = true;
            this.taskRefresh.cancel(true);
            this.list.onRefreshComplete();
        }
    }

    private void showOpnions() {
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).setItems(this.newsOpinions.getPostsList());
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).setCategory(38);
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        this.list.setSelection(0);
    }

    private void showNews() {
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).setItems(this.newsNews.getPostsList());
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).setCategory(53);
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        this.list.setSelection(0);
    }

    private void showMore() {
        getView().findViewById(C0089R.C0090id.HomeActivity_moreContainer).setVisibility(0);
    }

    private void showLatestNews() {
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).setItems(this.newsLatest.getPostsList());
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).setCategory(0);
        ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        this.list.setSelection(0);
    }

    private void diselectAllTabs() {
        this.tabLatest.setSelected(false);
        this.tabMore.setSelected(false);
        this.tabNews.setSelected(false);
        this.tabOpinions.setSelected(false);
    }

    public String[] getImageUrls() {
        return new String[]{this.newsLatest.getPostsList().get(0).getThumbnail(), this.newsOpinions.getPostsList().get(0).getThumbnail(), NewsController.getInstance(getActivity()).getFirstEURUSD().getPostsList().get(0).getThumbnail()};
    }

    class FetchNewsTask extends AsyncTask<String, Void, Void> {
        NewsController controller;
        int count;
        ProgressDialog dialog;
        Dialog errDialog;
        int option;
        boolean previouslyLoaded = false;
        String response;
        String title;

        FetchNewsTask(int option2) {
            this.option = option2;
            this.controller = NewsController.getInstance(HomeFragment.this.activity);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            switch (this.option) {
                case News.MAJORS /*1102*/:
                    if (this.controller.getMajorsNews() != null && this.controller.getMajorsNews().getPostsList().size() >= 1) {
                        this.previouslyLoaded = true;
                        break;
                    }
                case News.MINORS /*1103*/:
                    if (this.controller.getMinorsNews() != null && this.controller.getMinorsNews().getPostsList().size() >= 0) {
                        this.previouslyLoaded = true;
                        break;
                    }
                case News.BASICS_INDUSTRY /*1117*/:
                    if (this.controller.getBasicNews() != null && this.controller.getBasicNews().getPostsList().size() >= 0) {
                        this.previouslyLoaded = true;
                        break;
                    }
            }
            if (this.option != 6 && !this.previouslyLoaded) {
                this.dialog = ProgressDialog.show(HomeFragment.this.activity, (CharSequence) null, HomeFragment.this.getString(C0089R.string.loading));
                this.dialog.show();
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            HomeFragment.this.refreshCancelled = false;
            try {
                switch (this.option) {
                    case 5:
                        reloadNews();
                        return null;
                    case 6:
                        reloadNews();
                        return null;
                    case News.MAJORS /*1102*/:
                        this.title = "Majors";
                        loadMajorsNews();
                        return null;
                    case News.MINORS /*1103*/:
                        this.title = "Minors";
                        loadMinorsNews();
                        return null;
                    case News.BASICS_INDUSTRY /*1117*/:
                        this.title = "Basic & Industry";
                        loadBasicIndustryNews();
                        return null;
                    default:
                        return null;
                }
            } catch (Exception e) {
                this.dialog.dismiss();
                cancel(true);
                e.printStackTrace();
                return null;
            }
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            cancel(true);
            e.printStackTrace();
            return null;
        }

        private void reloadNews() throws Exception {
            if (this.option == 5 || HomeFragment.this.newsType == 1) {
                HomeFragment.this.newsNews = WSController.getNewsFromJson(HomeFragment.this.activity, 53);
                NewsController.getInstance(HomeFragment.this.activity).setNewsNews(HomeFragment.this.newsNews);
            }
            if (this.option == 5 || HomeFragment.this.newsType == 2) {
                HomeFragment.this.newsOpinions = WSController.getNewsFromJson(HomeFragment.this.activity, 38);
                NewsController.getInstance(HomeFragment.this.activity).setOpinionsNews(HomeFragment.this.newsOpinions);
            }
            if (this.option == 5 || HomeFragment.this.newsType == 0) {
                HomeFragment.this.newsLatest = WSController.getLatestNewsFromJson(HomeFragment.this.activity);
                NewsController.getInstance(HomeFragment.this.activity).setLatestNews(HomeFragment.this.newsLatest);
            }
            if (this.option == 5) {
                NewsController.getInstance(HomeFragment.this.activity).setFirstEURUSD(WSController.getNewsFromJson(HomeFragment.this.activity, News.EUR_USD_DAILY, 1));
                NewsController.getInstance(HomeFragment.this.activity).setEurusdNews(WSController.getNewsFromJson(HomeFragment.this.activity, News.EUR_USD_FORECAST, 1));
                NewsController.getInstance(HomeFragment.this.activity).setGbpNews(WSController.getNewsFromJson(HomeFragment.this.activity, 512, 1));
                NewsController.getInstance(HomeFragment.this.activity).setAudNews(WSController.getNewsFromJson(HomeFragment.this.activity, News.AUD_USD_DAILY, 1));
                NewsController.getInstance(HomeFragment.this.activity).setMajorsNews(WSController.getNewsFromJson(HomeFragment.this.activity, 1132, 1));
                NewsController.getInstance(HomeFragment.this.activity).setJpyNews(WSController.getNewsFromJson(HomeFragment.this.activity, News.USD_JPY_FORECAST, 1));
                NewsController.getInstance(HomeFragment.this.activity).setChfNews(WSController.getNewsFromJson(HomeFragment.this.activity, News.USD_CHF_FORECAST, 1));
                NewsController.getInstance(HomeFragment.this.activity).setCadNews(WSController.getNewsFromJson(HomeFragment.this.activity, News.CANADIAN_DOLAR, 1));
                NewsController.getInstance(HomeFragment.this.activity).setNzdNews(WSController.getNewsFromJson(HomeFragment.this.activity, News.NZR_USD_FORECAST, 1));
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Dialog dialog2 = GuiUtil.showErrorDialog((FragmentActivity) HomeFragment.this.activity, HomeFragment.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!HomeFragment.this.refreshCancelled && !HomeFragment.this.isDialogShowing) {
                    dialog2.show();
                    HomeFragment.this.isDialogShowing = true;
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        HomeFragment.this.isDialogShowing = false;
                    }
                });
            }
            HomeFragment.this.refreshCancelled = false;
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (isCancelled()) {
                Dialog dialog2 = GuiUtil.showErrorDialog((FragmentActivity) HomeFragment.this.activity, HomeFragment.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!HomeFragment.this.isDialogShowing) {
                        dialog2.show();
                        HomeFragment.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        HomeFragment.this.isDialogShowing = false;
                    }
                });
            } else if (this.option == 5) {
                HomeFragment.this.initPager();
                if (HomeFragment.this.list.getAdapter() == null && HomeFragment.this.newsLatest != null && HomeFragment.this.newsLatest.getPostsList() != null) {
                    HomeFragment.this.list.setAdapter(new NewsSimpleListAdapter(HomeFragment.this.getActivity(), C0089R.layout.news_simple_list_item, HomeFragment.this.newsLatest.getPostsList(), HomeFragment.this.options, 0));
                } else if (HomeFragment.this.list != null && HomeFragment.this.list.getAdapter() != null) {
                    ((NewsSimpleListAdapter) ((HeaderViewListAdapter) HomeFragment.this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
                }
            } else if (this.option == 6) {
                switch (HomeFragment.this.newsType) {
                    case 0:
                        if (HomeFragment.this.list.getAdapter() != null && HomeFragment.this.newsLatest != null && HomeFragment.this.newsLatest.getPostsList() != null) {
                            HomeFragment.this.list.setAdapter(new NewsSimpleListAdapter(HomeFragment.this.getActivity(), C0089R.layout.news_simple_list_item, HomeFragment.this.newsLatest.getPostsList(), HomeFragment.this.options, 0));
                            HomeFragment.this.list.onRefreshComplete();
                            return;
                        } else if (HomeFragment.this.list != null && HomeFragment.this.list.getAdapter() != null) {
                            ((NewsSimpleListAdapter) ((HeaderViewListAdapter) HomeFragment.this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
                            HomeFragment.this.list.onRefreshComplete();
                            return;
                        } else {
                            return;
                        }
                    case 1:
                        if (HomeFragment.this.list.getAdapter() != null && HomeFragment.this.newsLatest != null && HomeFragment.this.newsLatest.getPostsList() != null) {
                            HomeFragment.this.list.setAdapter(new NewsSimpleListAdapter(HomeFragment.this.getActivity(), C0089R.layout.news_simple_list_item, HomeFragment.this.newsNews.getPostsList(), HomeFragment.this.options, 53));
                            HomeFragment.this.list.onRefreshComplete();
                            return;
                        } else if (HomeFragment.this.list != null && HomeFragment.this.list.getAdapter() != null) {
                            ((NewsSimpleListAdapter) ((HeaderViewListAdapter) HomeFragment.this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
                            HomeFragment.this.list.onRefreshComplete();
                            return;
                        } else {
                            return;
                        }
                    case 2:
                        if (HomeFragment.this.list.getAdapter() != null && HomeFragment.this.newsLatest != null && HomeFragment.this.newsLatest.getPostsList() != null) {
                            HomeFragment.this.list.setAdapter(new NewsSimpleListAdapter(HomeFragment.this.getActivity(), C0089R.layout.news_simple_list_item, HomeFragment.this.newsOpinions.getPostsList(), HomeFragment.this.options, 38));
                            HomeFragment.this.list.onRefreshComplete();
                            return;
                        } else if (HomeFragment.this.list != null && HomeFragment.this.list.getAdapter() != null) {
                            ((NewsSimpleListAdapter) ((HeaderViewListAdapter) HomeFragment.this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
                            HomeFragment.this.list.onRefreshComplete();
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } else {
                HomeFragment.this.showMoreFragment(this.title, this.option);
            }
        }

        private void loadBasicIndustryNews() throws Exception {
            if (this.controller.getBasicNews() == null) {
                News newsListBasic = WSController.getNewsFromJson(HomeFragment.this.activity, News.BASICS_INDUSTRY);
                if (newsListBasic.getPostsList() != null && !newsListBasic.getPostsList().isEmpty()) {
                    this.controller.setBasicNews(newsListBasic);
                }
            }
        }

        private void loadMinorsNews() throws Exception {
            if (this.controller.getMinorsNews() == null) {
                News newsListMinors = WSController.getNewsFromJson(HomeFragment.this.activity, News.MINORS);
                if (newsListMinors.getPostsList() != null && !newsListMinors.getPostsList().isEmpty()) {
                    this.controller.setMinorsNews(newsListMinors);
                }
            }
        }

        private void loadMajorsNews() throws Exception {
            if (this.controller.getMajorsNews() == null || this.controller.getMajorsNews().getPostsList().size() <= 1) {
                News newsListMajors = WSController.getNewsFromJson(HomeFragment.this.activity, News.MAJORS);
                if (newsListMajors.getPostsList() != null && !newsListMajors.getPostsList().isEmpty()) {
                    this.controller.setMajorsNews(newsListMajors);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void showMoreFragment(String title, int option) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("option", option);
        Intent intent = new Intent(getActivity(), MoreActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position2, long arg3) {
        this.itemClicked = true;
        this.position = position2;
        if (this.interstitialAd.isReady()) {
            this.interstitialAd.show();
            return;
        }
        Log.d("Intersticial error", "Interstitial ad was not ready to be shown.");
        Post item = ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position2);
        addReadPostToPreferences(item.getId());
        NewsController.getInstance(this.activity).setSelectedPost(item);
        startActivity(new Intent(getActivity(), NewsContentActivity.class));
    }

    private void addReadPostToPreferences(int id) {
        int category = ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getCategory();
        ArrayList<Integer> readMsgIds = Utils.createIdsList(this.activity, category);
        if (readMsgIds.isEmpty()) {
            readMsgIds.add(Integer.valueOf(id));
        } else if (!readMsgIds.contains(Integer.valueOf(id))) {
            readMsgIds.add(Integer.valueOf(id));
        }
        Utils.idListToPreferences(this.activity, readMsgIds, category);
    }

    private class AutoPlayPagerTask extends AsyncTask<Void, Void, Void> {
        int currentPage;

        private AutoPlayPagerTask() {
        }

        /* synthetic */ AutoPlayPagerTask(HomeFragment homeFragment, AutoPlayPagerTask autoPlayPagerTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            this.currentPage = HomeFragment.this.pager.getCurrentItem();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.currentPage == 2) {
                HomeFragment.this.pager.setCurrentItem(0, true);
            } else {
                HomeFragment.this.pager.setCurrentItem(this.currentPage + 1, true);
            }
        }
    }

    public class MyTimerTask extends TimerTask {
        private Runnable runnable = new Runnable() {
            public void run() {
                if (HomeFragment.this.currentTask == null || HomeFragment.this.currentTask.getStatus() != AsyncTask.Status.RUNNING) {
                    HomeFragment.this.currentTask = new AutoPlayPagerTask(HomeFragment.this, (AutoPlayPagerTask) null);
                    HomeFragment.this.currentTask.execute(new Void[0]);
                    return;
                }
                HomeFragment.this.currentTask.cancel(true);
                HomeFragment.this.currentTask = null;
            }
        };

        public MyTimerTask() {
        }

        public void run() {
            HomeFragment.this.handler.post(this.runnable);
        }
    }

    public void onStart() {
        EasyTracker.getInstance();
        EasyTracker.getTracker().sendView("Home View");
        super.onStart();
    }

    private void showPagerNews() {
        Post currentPost = this.newsLatest.getPostsList().get(0);
        switch (this.mIndicator.getPosition()) {
            case 0:
                currentPost = this.newsLatest.getPostsList().get(0);
                break;
            case 1:
                currentPost = this.newsOpinions.getPostsList().get(0);
                break;
            case 2:
                currentPost = NewsController.getInstance(getActivity()).getFirstEURUSD().getPostsList().get(0);
                break;
        }
        if (currentPost != null) {
            addReadPostToPreferences(currentPost.getId());
            NewsController.getInstance(this.activity).setSelectedPost(currentPost);
            startActivity(new Intent(getActivity(), NewsContentActivity.class));
        }
    }

    public void onDismissScreen(C0165Ad arg0) {
        Post item = ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(this.position);
        addReadPostToPreferences(item.getId());
        NewsController.getInstance(this.activity).setSelectedPost(item);
        startActivity(new Intent(getActivity(), NewsContentActivity.class));
    }

    public void onFailedToReceiveAd(C0165Ad arg0, AdRequest.ErrorCode arg1) {
        Log.d("Intersticial", "onFailedToReceiveAd");
        if (this.itemClicked) {
            Post item = ((NewsSimpleListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(this.position);
            addReadPostToPreferences(item.getId());
            NewsController.getInstance(this.activity).setSelectedPost(item);
            startActivity(new Intent(getActivity(), NewsContentActivity.class));
        }
    }

    public void onLeaveApplication(C0165Ad arg0) {
    }

    public void onPresentScreen(C0165Ad arg0) {
    }

    public void onReceiveAd(C0165Ad arg0) {
        Log.d("Intersticial", "onReceiveAd bien");
    }

    class FetchMoreNewsDataTask extends AsyncTaskLoader {

        /* renamed from: e */
        private Exception f62e;
        String response;

        public FetchMoreNewsDataTask(Context context) {
            super(context);
        }

        public Object loadInBackground() {
            try {
                NewsController.getInstance(getContext()).setMajorsNews(WSController.getMoreNewsFromJson(getContext(), News.MAJORS, 1));
                NewsController.getInstance(getContext()).setMinorsNews(WSController.getMoreNewsFromJson(getContext(), News.MINORS, 1));
                NewsController.getInstance(getContext()).setBasicNews(WSController.getMoreNewsFromJson(getContext(), News.BASICS_INDUSTRY, 1));
                return null;
            } catch (Exception e) {
                this.f62e = e;
                cancelLoad();
                e.printStackTrace();
                return null;
            }
        }
    }
}
