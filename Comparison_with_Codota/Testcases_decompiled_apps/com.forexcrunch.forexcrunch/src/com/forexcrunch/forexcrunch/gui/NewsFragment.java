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
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import java.util.ArrayList;
import p006eu.erikw.PullToRefreshListView;

public class NewsFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    /* access modifiers changed from: private */
    public Activity activity;
    private ArrayList<Post> adapterList;
    /* access modifiers changed from: private */
    public int bitsPgCount = 1;
    private int currentFirstVisibleItem;
    private int currentScrollState;
    /* access modifiers changed from: private */
    public int currentTab;
    private int currentVisibleItemCount;
    /* access modifiers changed from: private */
    public LinearLayout footer;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    /* access modifiers changed from: private */
    public int index = 0;
    /* access modifiers changed from: private */
    public int industryPgCount = 1;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    /* access modifiers changed from: private */
    public PullToRefreshListView list;
    private NewsWithHeaderListAdapter mAdapter;
    /* access modifiers changed from: private */
    public News newsList;
    /* access modifiers changed from: private */
    public News newsListBits;
    /* access modifiers changed from: private */
    public News newsListIndustry;
    /* access modifiers changed from: private */
    public News newsListOpinions;
    /* access modifiers changed from: private */
    public int newsPgCount = 1;
    /* access modifiers changed from: private */
    public int opinionsPgCount = 1;
    private DisplayImageOptions options;
    /* access modifiers changed from: private */
    public boolean refreshCancelled = false;
    private Button tabBits;
    private Button tabIndustry;
    private Button tabNews;
    private Button tabOpinions;
    private FetchNewsTask task;
    /* access modifiers changed from: private */
    public AsyncTask taskRefresh;
    private int totalCount;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0089R.layout.news_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.activity = getActivity();
        initComponents();
        if (this.newsList == null || this.newsList.isEmptyOrNullPostList()) {
            this.currentTab = 53;
            if (NewsController.getInstance(getActivity()).getNewsNews() == null) {
                new FetchNewsTask(53, false).execute(new String[0]);
                return;
            }
            this.newsList = NewsController.getInstance(getActivity()).getNewsNews();
            setAdapter();
            return;
        }
        setAdapter();
    }

    private void setAdapter() {
        if (this.currentTab == 53) {
            showNews();
        } else if (this.currentTab == 38) {
            showOpinions();
        } else if (this.currentTab == 1051) {
            showIndustry();
        } else if (this.currentTab == 1003) {
            showBits();
        }
    }

    private void initComponents() {
        this.tabOpinions = (Button) getView().findViewById(C0089R.C0090id.NewsActivity_ibtnOpinions);
        this.tabOpinions.setOnClickListener(this);
        this.tabIndustry = (Button) getView().findViewById(C0089R.C0090id.NewsActivity_ibtnIndustry);
        this.tabIndustry.setOnClickListener(this);
        this.tabBits = (Button) getView().findViewById(C0089R.C0090id.NewsActivity_ibtnBits);
        this.tabBits.setOnClickListener(this);
        this.tabNews = (Button) getView().findViewById(C0089R.C0090id.NewsActivity_ibtnNews);
        this.tabNews.setOnClickListener(this);
        this.tabNews.setSelected(true);
        this.list = (PullToRefreshListView) getView().findViewById(C0089R.C0090id.NewsActivity_listview);
        this.list.setOnItemClickListener(this);
        this.list.setOnScrollListener(this);
        this.list.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            public void onRefresh() {
                NewsFragment.this.taskRefresh = new FetchNewsTask(NewsFragment.this.currentTab, false, true).execute(new String[0]);
            }
        });
        this.footer = (LinearLayout) getView().findViewById(C0089R.C0090id.NewsActivity_footer);
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        this.adapterList = new ArrayList<>();
        this.mAdapter = new NewsWithHeaderListAdapter(getActivity(), C0089R.layout.news_simple_list_item, this.adapterList, this.options, News.EUR_USD_DAILY);
        this.list.setAdapter(this.mAdapter);
    }

    public boolean checkListLoaded(News news) {
        if (news == null) {
            return false;
        }
        return true;
    }

    public void onClick(View v) {
        checkTask();
        switch (v.getId()) {
            case C0089R.C0090id.NewsActivity_ibtnNews:
                new GaTask(getActivity(), 0, "ui_action", "News Button Tap", "News Button Tap,View: News").execute(new Void[0]);
                if (this.newsList == null) {
                    NewsController.getInstance(getActivity()).getNewsNews();
                }
                if (!checkListLoaded(this.newsList)) {
                    new FetchNewsTask(53, false).execute(new String[0]);
                } else {
                    showNews();
                }
                this.currentTab = 53;
                return;
            case C0089R.C0090id.NewsActivity_ibtnOpinions:
                new GaTask(getActivity(), 0, "ui_action", "Opinions Button Tap", "Opinions Button Tap,View: News").execute(new Void[0]);
                if (this.newsListOpinions == null) {
                    this.newsListOpinions = NewsController.getInstance(getActivity()).getOpinionsNews();
                }
                if (!checkListLoaded(this.newsListOpinions)) {
                    new FetchNewsTask(38, false).execute(new String[0]);
                } else {
                    showOpinions();
                }
                this.currentTab = 38;
                return;
            case C0089R.C0090id.NewsActivity_ibtnIndustry:
                new GaTask(getActivity(), 0, "ui_action", "Industry Button Tap", "Industry Button Tap,View: News").execute(new Void[0]);
                if (this.newsListIndustry == null) {
                    this.newsListIndustry = NewsController.getInstance(getActivity()).getIndustryNews();
                }
                if (!checkListLoaded(this.newsListIndustry)) {
                    new FetchNewsTask(News.FOREX_INDUSTRY, false).execute(new String[0]);
                } else {
                    showIndustry();
                }
                this.currentTab = News.FOREX_INDUSTRY;
                return;
            case C0089R.C0090id.NewsActivity_ibtnBits:
                new GaTask(getActivity(), 0, "ui_action", "Bits Button Tap", "Bits Button Tap,View: News").execute(new Void[0]);
                if (this.newsListBits == null) {
                    this.newsListBits = NewsController.getInstance(getActivity()).getBitsNews();
                }
                if (!checkListLoaded(this.newsListBits)) {
                    new FetchNewsTask(News.FOREX_BITS, false).execute(new String[0]);
                } else {
                    showBits();
                }
                this.currentTab = News.FOREX_BITS;
                return;
            default:
                return;
        }
    }

    private void diselectAllTabs() {
        this.tabOpinions.setSelected(false);
        this.tabBits.setSelected(false);
        this.tabIndustry.setSelected(false);
        this.tabNews.setSelected(false);
    }

    /* access modifiers changed from: private */
    public void showOpinions() {
        diselectAllTabs();
        this.tabOpinions.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListOpinions.getPostsList());
        this.mAdapter.setCategory(38);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showNews() {
        diselectAllTabs();
        this.tabNews.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsList.getPostsList());
        this.mAdapter.setCategory(53);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showIndustry() {
        diselectAllTabs();
        this.tabIndustry.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListIndustry.getPostsList());
        this.mAdapter.setCategory(News.FOREX_INDUSTRY);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showBits() {
        diselectAllTabs();
        this.tabBits.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListBits.getPostsList());
        this.mAdapter.setCategory(News.FOREX_BITS);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
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

    class FetchNewsTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        Dialog errorDialog;
        private boolean isMore;
        private boolean isRefresh;
        int option;

        FetchNewsTask(int n, boolean isMore2) {
            this.option = n;
            this.isMore = isMore2;
        }

        FetchNewsTask(int n, boolean isMore2, boolean isRefresh2) {
            this.option = n;
            this.isMore = isMore2;
            this.isRefresh = isRefresh2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.isMore) {
                NewsFragment.this.index = NewsFragment.this.list.getFirstVisiblePosition();
                NewsFragment.this.footer.setVisibility(0);
            } else if (!this.isRefresh) {
                this.dialog = ProgressDialog.show(NewsFragment.this.activity, (CharSequence) null, NewsFragment.this.getString(C0089R.string.loading));
                if (!this.dialog.isShowing()) {
                    this.dialog.show();
                }
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                if (this.option == 53) {
                    if (this.isRefresh) {
                        NewsFragment.this.newsPgCount = 1;
                    }
                    News temp = WSController.getMoreNewsFromJson(NewsFragment.this.activity, 53, NewsFragment.this.newsPgCount);
                    if (!this.isRefresh) {
                        NewsFragment.this.newsList = NewsFragment.this.mergePosts(temp, NewsFragment.this.newsList);
                    } else {
                        NewsFragment.this.newsList = temp;
                    }
                    NewsController.getInstance(NewsFragment.this.activity).setNewsNews(NewsFragment.this.newsList);
                    return null;
                } else if (this.option == 38) {
                    if (this.isRefresh) {
                        NewsFragment.this.opinionsPgCount = 1;
                    }
                    News temp2 = WSController.getMoreNewsFromJson(NewsFragment.this.activity, 38, NewsFragment.this.opinionsPgCount);
                    if (!this.isRefresh) {
                        NewsFragment.this.newsListOpinions = NewsFragment.this.mergePosts(temp2, NewsFragment.this.newsListOpinions);
                    } else {
                        NewsFragment.this.newsListOpinions = temp2;
                    }
                    NewsController.getInstance(NewsFragment.this.activity).setOpinionsNews(NewsFragment.this.newsListOpinions);
                    return null;
                } else if (this.option == 1051) {
                    if (this.isRefresh) {
                        NewsFragment.this.industryPgCount = 1;
                    }
                    News temp3 = WSController.getMoreNewsFromJson(NewsFragment.this.activity, News.FOREX_INDUSTRY, NewsFragment.this.industryPgCount);
                    if (!this.isRefresh) {
                        NewsFragment.this.newsListIndustry = NewsFragment.this.mergePosts(temp3, NewsFragment.this.newsListIndustry);
                    } else {
                        NewsFragment.this.newsListIndustry = temp3;
                    }
                    NewsController.getInstance(NewsFragment.this.activity).setIndustryNews(NewsFragment.this.newsListIndustry);
                    return null;
                } else if (this.option != 1003) {
                    return null;
                } else {
                    if (this.isRefresh) {
                        NewsFragment.this.bitsPgCount = 1;
                    }
                    News temp4 = WSController.getMoreNewsFromJson(NewsFragment.this.activity, News.FOREX_BITS, NewsFragment.this.bitsPgCount);
                    if (!this.isRefresh) {
                        NewsFragment.this.newsListBits = NewsFragment.this.mergePosts(temp4, NewsFragment.this.newsListBits);
                    } else {
                        NewsFragment.this.newsListBits = temp4;
                    }
                    NewsController.getInstance(NewsFragment.this.activity).setBitsNews(NewsFragment.this.newsListBits);
                    return null;
                }
            } catch (Exception e) {
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            if (!NewsFragment.this.refreshCancelled) {
                if (this.isMore) {
                    NewsFragment.this.footer.setVisibility(8);
                    NewsFragment.this.isLoading = false;
                } else if (this.dialog != null && this.dialog.isShowing()) {
                    this.dialog.dismiss();
                    showErrorDialog();
                }
            }
            NewsFragment.this.refreshCancelled = false;
        }

        private void showErrorDialog() {
            this.errorDialog = GuiUtil.showErrorDialog((FragmentActivity) NewsFragment.this.activity, NewsFragment.this.getString(C0089R.string.server_error), false, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    FetchNewsTask.this.errorDialog.dismiss();
                    NewsFragment.this.isLoading = false;
                }
            });
            synchronized (this) {
                if (!NewsFragment.this.isDialogShowing) {
                    this.errorDialog.show();
                    NewsFragment.this.isDialogShowing = true;
                }
            }
            this.errorDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    NewsFragment.this.isDialogShowing = false;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            dismissProgress();
            if (!isCancelled()) {
                NewsFragment.this.isLoading = false;
                if (this.option == 53) {
                    NewsFragment.this.showNews();
                } else if (this.option == 38) {
                    NewsFragment.this.showOpinions();
                } else if (this.option == 1051) {
                    NewsFragment.this.showIndustry();
                } else if (this.option == 1003) {
                    NewsFragment.this.showBits();
                }
            } else {
                NewsFragment.this.isLoading = false;
                showErrorDialog();
            }
            if (this.isRefresh) {
                NewsFragment.this.list.onRefreshComplete();
            }
            super.onPostExecute(result);
        }

        private void dismissProgress() {
            if (this.isMore) {
                NewsFragment.this.footer.setVisibility(8);
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

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        new GaTask(getActivity(), 0, "ui_action", "Specific News Tap", "Specific News Tap,View: News").execute(new Void[0]);
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

    public void onResume() {
        super.onResume();
        if (((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter() != null) {
            ((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        }
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

    public void loadMoreData() {
        incrementPageCount();
        this.task = new FetchNewsTask(this.currentTab, true);
        this.task.execute(new String[0]);
    }

    public void incrementPageCount() {
        switch (this.currentTab) {
            case 38:
                this.opinionsPgCount++;
                return;
            case 53:
                this.newsPgCount++;
                return;
            case News.FOREX_BITS /*1003*/:
                this.bitsPgCount++;
                return;
            case News.FOREX_INDUSTRY /*1051*/:
                this.industryPgCount++;
                return;
            default:
                return;
        }
    }
}
