package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.NewsWithHeaderListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.forexcrunch.forexcrunch.p003ga.GaTask;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import java.util.ArrayList;
import p006eu.erikw.PullToRefreshListView;

public class DailyFragment extends Fragment implements View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    /* access modifiers changed from: private */
    public Activity activity;
    private ArrayList<Post> adapterList;
    private int currentFirstVisibleItem;
    private int currentScrollState;
    /* access modifiers changed from: private */
    public int currentTab;
    private int currentVisibleItemCount;
    /* access modifiers changed from: private */
    public int eurUsdPgCount = 1;
    /* access modifiers changed from: private */
    public LinearLayout footer;
    /* access modifiers changed from: private */
    public int forecastPgCount = 1;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    /* access modifiers changed from: private */
    public int index = 0;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    private boolean isRefresh;
    /* access modifiers changed from: private */
    public PullToRefreshListView list;
    private NewsWithHeaderListAdapter mAdapter;
    /* access modifiers changed from: private */
    public News newsListEur;
    /* access modifiers changed from: private */
    public News newsListForecast;
    private DisplayImageOptions options;
    /* access modifiers changed from: private */
    public boolean refreshCancelled = false;
    private Button tabEurUsd;
    private Button tabForecast;
    private FetchDailyDataTask task;
    /* access modifiers changed from: private */
    public AsyncTask taskRefresh;
    private int totalCount;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0089R.layout.daily_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initComponents();
        this.activity = getActivity();
        NewsController controller = NewsController.getInstance(getActivity());
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        this.adapterList = new ArrayList<>();
        this.mAdapter = new NewsWithHeaderListAdapter(getActivity(), C0089R.layout.news_simple_list_item, this.adapterList, this.options, News.EUR_USD_DAILY);
        this.list.setAdapter(this.mAdapter);
        this.currentTab = News.EUR_USD_DAILY;
        if (controller.getEurNews() == null || controller.getForecastNews() == null) {
            this.currentTab = News.EUR_USD_DAILY;
            new FetchDailyDataTask(this.currentTab, false).execute(new String[0]);
            return;
        }
        this.newsListEur = controller.getEurNews();
        this.newsListForecast = controller.getForecastNews();
        if (this.list.getAdapter() == null) {
            this.currentTab = News.EUR_USD_DAILY;
        }
        showEurUsd();
    }

    public void onResume() {
        super.onResume();
        if (this.list.getAdapter() != null) {
            ((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        }
    }

    private void initComponents() {
        this.tabForecast = (Button) getView().findViewById(C0089R.C0090id.daily_btn_daily);
        this.tabForecast.setOnClickListener(this);
        this.tabEurUsd = (Button) getView().findViewById(C0089R.C0090id.daily_btn_eur);
        this.tabEurUsd.setOnClickListener(this);
        this.tabEurUsd.setSelected(true);
        this.list = (PullToRefreshListView) getView().findViewById(C0089R.C0090id.daily_listview);
        this.list.setOnScrollListener(this);
        this.list.setOnItemClickListener(this);
        this.list.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            public void onRefresh() {
                DailyFragment.this.taskRefresh = new FetchDailyDataTask(DailyFragment.this.currentTab, false, true).execute(new String[0]);
            }
        });
        this.footer = (LinearLayout) getView().findViewById(C0089R.C0090id.daily_footer);
    }

    class FetchDailyDataTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;

        /* renamed from: e */
        private Exception f61e;
        Dialog errorDialog;
        private boolean isMore;
        private boolean isRefresh = false;
        int option;
        int page;
        String response;

        public FetchDailyDataTask(int option2, boolean isMore2) {
            this.option = option2;
            this.page = DailyFragment.this.getPgCounter();
            this.isMore = isMore2;
        }

        public FetchDailyDataTask(int option2, boolean isMore2, boolean isRefresh2) {
            this.option = option2;
            this.page = DailyFragment.this.getPgCounter();
            this.isMore = isMore2;
            this.isRefresh = isRefresh2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.isMore) {
                DailyFragment.this.index = DailyFragment.this.list.getFirstVisiblePosition();
                DailyFragment.this.footer.setVisibility(0);
            } else if (!this.isRefresh) {
                this.dialog = ProgressDialog.show(DailyFragment.this.activity, (CharSequence) null, DailyFragment.this.getString(C0089R.string.loading));
                this.dialog.show();
            } else if (this.option == 1091) {
                DailyFragment.this.eurUsdPgCount = 1;
            } else {
                DailyFragment.this.forecastPgCount = 1;
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                if (this.option == 1091) {
                    News temp = WSController.getMoreNewsFromJson(DailyFragment.this.activity, News.EUR_USD_DAILY, DailyFragment.this.eurUsdPgCount);
                    if (!this.isRefresh) {
                        DailyFragment.this.newsListEur = DailyFragment.this.mergePosts(temp, DailyFragment.this.newsListEur);
                    } else {
                        DailyFragment.this.newsListEur = temp;
                    }
                    NewsController.getInstance(DailyFragment.this.activity).setEurNews(DailyFragment.this.newsListEur);
                    return null;
                }
                News temp2 = WSController.getMoreNewsFromJson(DailyFragment.this.activity, 21, DailyFragment.this.forecastPgCount);
                if (!this.isRefresh) {
                    DailyFragment.this.newsListForecast = DailyFragment.this.mergePosts(temp2, DailyFragment.this.newsListForecast);
                } else {
                    DailyFragment.this.newsListForecast = temp2;
                }
                NewsController.getInstance(DailyFragment.this.activity).setForecastNews(DailyFragment.this.newsListForecast);
                return null;
            } catch (Exception e) {
                this.f61e = e;
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (!DailyFragment.this.refreshCancelled) {
                if (this.isMore) {
                    DailyFragment.this.footer.setVisibility(8);
                    DailyFragment.this.isLoading = false;
                } else if (this.dialog == null || !this.dialog.isShowing()) {
                    showErrorDialog();
                } else {
                    this.dialog.dismiss();
                    showErrorDialog();
                }
            }
            if (this.isRefresh) {
                DailyFragment.this.list.onRefreshComplete();
            }
            DailyFragment.this.refreshCancelled = false;
            super.onCancelled();
        }

        private void showErrorDialog() {
            this.errorDialog = GuiUtil.showErrorDialog((FragmentActivity) DailyFragment.this.activity, DailyFragment.this.getString(C0089R.string.server_error), false, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    FetchDailyDataTask.this.errorDialog.dismiss();
                    DailyFragment.this.isLoading = false;
                    DailyFragment.this.isDialogShowing = false;
                }
            });
            synchronized (this) {
                if (!DailyFragment.this.isDialogShowing) {
                    this.errorDialog.show();
                    DailyFragment.this.isDialogShowing = true;
                }
            }
            this.errorDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    DailyFragment.this.isDialogShowing = false;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            dismissProgress();
            if (!isCancelled()) {
                DailyFragment.this.isLoading = false;
                if (this.option == 1091) {
                    DailyFragment.this.showEurUsd();
                    if (this.isRefresh) {
                        DailyFragment.this.list.onRefreshComplete();
                    }
                } else if (this.option == 21) {
                    DailyFragment.this.showForecast();
                    if (this.isRefresh) {
                        DailyFragment.this.list.onRefreshComplete();
                    }
                }
                if (this.isMore) {
                    DailyFragment.this.list.setSelectionFromTop(DailyFragment.this.index, 0);
                }
            } else {
                DailyFragment.this.isLoading = false;
                if (!this.isMore) {
                    showErrorDialog();
                }
            }
            super.onPostExecute(result);
        }

        private void dismissProgress() {
            if (this.isMore) {
                DailyFragment.this.footer.setVisibility(8);
            } else if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public News mergePosts(News response, News target) {
        if (target == null || target.isEmptyOrNullPostList()) {
            return response;
        }
        target.setPostsList(GuiUtil.mergePosts(target.getPostsList(), response.getPostsList()));
        return target;
    }

    public News createTrendingNews(News news1, News news2) {
        News tmpNews = new News();
        tmpNews.setPostsList(GuiUtil.mergePosts(news1.getPostsList(), news2.getPostsList()));
        return tmpNews;
    }

    public int getPgCounter() {
        switch (this.currentTab) {
            case 21:
                return this.forecastPgCount;
            case News.EUR_USD_DAILY /*1091*/:
                return this.eurUsdPgCount;
            default:
                return 0;
        }
    }

    public void onClick(View v) {
        checkTask();
        switch (v.getId()) {
            case C0089R.C0090id.daily_btn_eur:
                new GaTask(getActivity(), 0, "ui_action", "EUR/USD Forecast Button Tap", "EUR/USD Forecast Button Tap,View: Daily").execute(new Void[0]);
                this.currentTab = News.EUR_USD_DAILY;
                if (this.newsListEur == null || this.newsListEur.isEmptyOrNullPostList()) {
                    this.task = new FetchDailyDataTask(this.currentTab, false);
                    this.task.execute(new String[0]);
                    return;
                }
                showEurUsd();
                return;
            case C0089R.C0090id.daily_btn_daily:
                new GaTask(getActivity(), 0, "ui_action", "Daily Forecast Button Tap", "Daily Forecast Button Tap,View: Daily").execute(new Void[0]);
                this.currentTab = 21;
                if (this.newsListForecast == null || this.newsListForecast.isEmptyOrNullPostList()) {
                    this.task = new FetchDailyDataTask(this.currentTab, false);
                    this.task.execute(new String[0]);
                    return;
                }
                showForecast();
                return;
            default:
                return;
        }
    }

    private void checkTask() {
        if (this.task != null && this.task.getStatus() == AsyncTask.Status.RUNNING) {
            this.isLoading = false;
            this.task.cancel(true);
        }
        if (this.taskRefresh != null && this.taskRefresh.getStatus() == AsyncTask.Status.RUNNING) {
            this.isLoading = false;
            this.refreshCancelled = true;
            this.taskRefresh.cancel(true);
            this.list.onRefreshComplete();
        }
    }

    private void diselectAllTabs() {
        this.tabForecast.setSelected(false);
        this.tabEurUsd.setSelected(false);
    }

    /* access modifiers changed from: private */
    public void showForecast() {
        diselectAllTabs();
        this.tabForecast.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListForecast.getPostsList());
        this.mAdapter.setCategory(21);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showEurUsd() {
        diselectAllTabs();
        this.tabEurUsd.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListEur.getPostsList());
        this.mAdapter.setCategory(News.EUR_USD_DAILY);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    public void loadMoreData() {
        incrementPageCount();
        checkTask();
        this.task = new FetchDailyDataTask(this.currentTab, true);
        this.task.execute(new String[0]);
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.currentVisibleItemCount = visibleItemCount;
        this.currentFirstVisibleItem = firstVisibleItem;
        this.totalCount = totalItemCount;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.currentScrollState = scrollState;
        isScrollCompleted();
    }

    private void isScrollCompleted() {
        if (this.currentVisibleItemCount > 0 && this.currentScrollState == 0 && this.currentFirstVisibleItem + this.currentVisibleItemCount == this.totalCount) {
            synchronized (this) {
                if (!this.isLoading) {
                    this.isLoading = true;
                    loadMoreData();
                }
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        checkTask();
        new GaTask(getActivity(), 0, "ui_action", "Specific News Tap", "Specific News Tap,View: Daily").execute(new Void[0]);
        NewsController.getInstance(this.activity).setSelectedPost(((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position));
        startActivity(new Intent(getActivity(), NewsContentActivity.class));
        addReadPostToPreferences(((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position).getId());
    }

    private void addReadPostToPreferences(int id) {
        int category = ((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getCategory();
        ArrayList<Integer> readMsgIds = Utils.createIdsList(this.activity, category);
        if (readMsgIds.isEmpty()) {
            readMsgIds.add(Integer.valueOf(id));
        } else if (!readMsgIds.contains(Integer.valueOf(id))) {
            readMsgIds.add(Integer.valueOf(id));
        }
        Utils.idListToPreferences(this.activity, readMsgIds, category);
    }

    public void onStart() {
        super.onStart();
        EasyTracker.getInstance();
        EasyTracker.getTracker().sendView("Daily View");
    }

    public void incrementPageCount() {
        switch (this.currentTab) {
            case 21:
                this.forecastPgCount++;
                return;
            case News.EUR_USD_DAILY /*1091*/:
                this.eurUsdPgCount++;
                return;
            default:
                return;
        }
    }
}
