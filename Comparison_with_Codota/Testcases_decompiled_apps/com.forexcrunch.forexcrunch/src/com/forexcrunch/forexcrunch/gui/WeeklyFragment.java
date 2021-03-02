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
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
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
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import java.util.ArrayList;
import p006eu.erikw.PullToRefreshListView;

public class WeeklyFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    /* access modifiers changed from: private */
    public Activity activity;
    private ArrayList<Post> adapterList;
    /* access modifiers changed from: private */
    public int audPgCount = 0;
    /* access modifiers changed from: private */
    public int cadPgCount = 0;
    /* access modifiers changed from: private */
    public int chfPgCount = 0;
    private int currentFirstVisibleItem;
    private int currentScrollState;
    /* access modifiers changed from: private */
    public int currentTab;
    private int currentVisibleItemCount;
    /* access modifiers changed from: private */
    public int eurPgCount = 0;
    /* access modifiers changed from: private */
    public LinearLayout footer;
    /* access modifiers changed from: private */
    public int gbpPgCount = 0;
    /* access modifiers changed from: private */
    public int index = 0;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    /* access modifiers changed from: private */
    public int jpyPgCount = 0;
    /* access modifiers changed from: private */
    public PullToRefreshListView list;
    private NewsWithHeaderListAdapter mAdapter;
    /* access modifiers changed from: private */
    public int majorPgCount = 0;
    /* access modifiers changed from: private */
    public News newsListAud;
    /* access modifiers changed from: private */
    public News newsListCad;
    /* access modifiers changed from: private */
    public News newsListChf;
    /* access modifiers changed from: private */
    public News newsListEur;
    /* access modifiers changed from: private */
    public News newsListGbp;
    /* access modifiers changed from: private */
    public News newsListJpy;
    /* access modifiers changed from: private */
    public News newsListMajor;
    /* access modifiers changed from: private */
    public News newsListNzd;
    /* access modifiers changed from: private */
    public int nzdPgCount = 0;
    /* access modifiers changed from: private */
    public int option = 0;
    private DisplayImageOptions options;
    /* access modifiers changed from: private */
    public boolean refreshCancelled = false;
    private ImageButton tabAud;
    private ImageButton tabCad;
    private ImageButton tabChf;
    private ImageButton tabEur;
    private ImageButton tabGbp;
    private ImageButton tabJpy;
    private ImageButton tabMajor;
    private ImageButton tabNzd;
    private FetchWeeklyTask task;
    private AsyncTask taskR;
    /* access modifiers changed from: private */
    public AsyncTask taskRefresh;
    private int totalCount;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0089R.layout.weekly_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.activity = getActivity();
        initComponents();
        this.adapterList = new ArrayList<>();
        this.mAdapter = new NewsWithHeaderListAdapter(getActivity(), C0089R.layout.news_simple_list_item, this.adapterList, this.options, News.EUR_USD_FORECAST);
        this.list.setAdapter(this.mAdapter);
        if (this.eurPgCount == 0) {
            if (NewsController.getInstance(getActivity()).getEurusdNews() != null) {
                this.newsListEur = NewsController.getInstance(getActivity()).getEurusdNews();
                this.adapterList.clear();
                this.adapterList.addAll(this.newsListEur.getPostsList());
                this.mAdapter.notifyDataSetChanged();
                if (this.newsListEur.getPostsList().size() <= 1) {
                    this.taskR = new FetchWeeklyTask(News.EUR_USD_FORECAST, true).execute(new String[0]);
                }
            } else {
                new FetchWeeklyTask(News.EUR_USD_FORECAST, false).execute(new String[0]);
            }
            this.currentTab = News.EUR_USD_FORECAST;
            return;
        }
        this.newsListEur = NewsController.getInstance(getActivity()).getEurusdNews();
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListEur.getPostsList());
        this.mAdapter.notifyDataSetChanged();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initComponents() {
        this.tabEur = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_eur);
        this.tabEur.setOnClickListener(this);
        this.tabEur.setSelected(true);
        this.tabAud = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_aud);
        this.tabAud.setOnClickListener(this);
        this.tabCad = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_cad);
        this.tabCad.setOnClickListener(this);
        this.tabNzd = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_nzd);
        this.tabNzd.setOnClickListener(this);
        this.tabMajor = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_major);
        this.tabMajor.setOnClickListener(this);
        this.tabChf = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_chf);
        this.tabChf.setOnClickListener(this);
        this.tabGbp = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_gbp);
        this.tabGbp.setOnClickListener(this);
        this.tabJpy = (ImageButton) getView().findViewById(C0089R.C0090id.weekly_btn_jpy);
        this.tabJpy.setOnClickListener(this);
        this.list = (PullToRefreshListView) getView().findViewById(C0089R.C0090id.weekly_listview);
        this.list.setOnItemClickListener(this);
        this.list.setOnScrollListener(this);
        this.list.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            public void onRefresh() {
                WeeklyFragment.this.taskRefresh = new FetchWeeklyTask(WeeklyFragment.this.currentTab, false, true).execute(new String[0]);
            }
        });
        this.footer = (LinearLayout) getView().findViewById(C0089R.C0090id.weekly_footer);
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
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
            case C0089R.C0090id.weekly_btn_eur:
                new GaTask(getActivity(), 0, "ui_action", "EUR News Button Tap", "EUR News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.eurPgCount != 0) {
                    showEUR();
                } else if (NewsController.getInstance(getActivity()).getEurusdNews() != null) {
                    this.newsListEur = NewsController.getInstance(getActivity()).getEurusdNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListEur.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showEUR();
                    if (this.newsListEur.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(News.EUR_USD_FORECAST, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(News.EUR_USD_FORECAST, false).execute(new String[0]);
                }
                this.currentTab = News.EUR_USD_FORECAST;
                return;
            case C0089R.C0090id.weekly_btn_gbp:
                if (this.gbpPgCount == 0) {
                    new GaTask(getActivity(), 0, "ui_action", "GBP News Button Tap", "Industry News Button Tap,View: Weekly").execute(new Void[0]);
                    if (NewsController.getInstance(getActivity()).getGbpNews() != null) {
                        this.newsListGbp = NewsController.getInstance(getActivity()).getGbpNews();
                        this.adapterList.clear();
                        this.adapterList.addAll(this.newsListGbp.getPostsList());
                        this.mAdapter.notifyDataSetChanged();
                        showGBP();
                        if (this.newsListGbp.getPostsList().size() <= 1) {
                            this.taskR = new FetchWeeklyTask(512, true).execute(new String[0]);
                        }
                    } else {
                        new FetchWeeklyTask(512, false).execute(new String[0]);
                    }
                } else {
                    showGBP();
                }
                this.currentTab = 512;
                return;
            case C0089R.C0090id.weekly_btn_aud:
                new GaTask(getActivity(), 0, "ui_action", "AUD News Button Tap", "AUD News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.audPgCount != 0) {
                    showAUD();
                } else if (NewsController.getInstance(getActivity()).getAudNews() != null) {
                    this.newsListAud = NewsController.getInstance(getActivity()).getAudNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListAud.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showAUD();
                    if (this.newsListAud.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(News.AUD_USD_DAILY, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(News.AUD_USD_DAILY, false).execute(new String[0]);
                }
                this.currentTab = News.AUD_USD_DAILY;
                return;
            case C0089R.C0090id.weekly_btn_major:
                new GaTask(getActivity(), 0, "ui_action", "Major News Button Tap", "Major News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.majorPgCount != 0) {
                    showMajor();
                } else if (NewsController.getInstance(getActivity()).getMajorsNews() != null) {
                    this.newsListMajor = NewsController.getInstance(getActivity()).getMajorsNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListMajor.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showMajor();
                    if (this.newsListMajor.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(1132, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(1132, false).execute(new String[0]);
                }
                this.currentTab = 1132;
                return;
            case C0089R.C0090id.weekly_btn_jpy:
                new GaTask(getActivity(), 0, "ui_action", "JPY News Button Tap", "JPY News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.jpyPgCount != 0) {
                    showJPY();
                } else if (NewsController.getInstance(getActivity()).getJpyNews() != null) {
                    this.newsListJpy = NewsController.getInstance(getActivity()).getJpyNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListJpy.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showJPY();
                    if (this.newsListJpy.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(News.USD_JPY_FORECAST, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(News.USD_JPY_FORECAST, false).execute(new String[0]);
                }
                this.currentTab = News.USD_JPY_FORECAST;
                return;
            case C0089R.C0090id.weekly_btn_cad:
                new GaTask(getActivity(), 0, "ui_action", "CAD News Button Tap", "CAD News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.cadPgCount != 0) {
                    showCAD();
                } else if (NewsController.getInstance(getActivity()).getCadNews() != null) {
                    this.newsListCad = NewsController.getInstance(getActivity()).getCadNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListCad.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showCAD();
                    if (this.newsListCad.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(News.CANADIAN_DOLAR, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(News.CANADIAN_DOLAR, false).execute(new String[0]);
                }
                this.currentTab = News.CANADIAN_DOLAR;
                return;
            case C0089R.C0090id.weekly_btn_nzd:
                new GaTask(getActivity(), 0, "ui_action", "NZD News Button Tap", "NZD News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.nzdPgCount != 0) {
                    showNZD();
                } else if (NewsController.getInstance(getActivity()).getNzdNews() != null) {
                    this.newsListNzd = NewsController.getInstance(getActivity()).getNzdNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListNzd.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showNZD();
                    if (this.newsListNzd.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(News.NZR_USD_FORECAST, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(News.NZR_USD_FORECAST, false).execute(new String[0]);
                }
                this.currentTab = News.NZR_USD_FORECAST;
                return;
            case C0089R.C0090id.weekly_btn_chf:
                new GaTask(getActivity(), 0, "ui_action", "CHF News Button Tap", "CHF News Button Tap,View: Weekly").execute(new Void[0]);
                if (this.chfPgCount != 0) {
                    showCHF();
                } else if (NewsController.getInstance(getActivity()).getChfNews() != null) {
                    this.newsListChf = NewsController.getInstance(getActivity()).getChfNews();
                    this.adapterList.clear();
                    this.adapterList.addAll(this.newsListChf.getPostsList());
                    this.mAdapter.notifyDataSetChanged();
                    showCHF();
                    if (this.newsListChf.getPostsList().size() <= 1) {
                        this.taskR = new FetchWeeklyTask(News.USD_CHF_FORECAST, true).execute(new String[0]);
                    }
                } else {
                    new FetchWeeklyTask(News.USD_CHF_FORECAST, false).execute(new String[0]);
                }
                this.currentTab = News.USD_CHF_FORECAST;
                return;
            default:
                return;
        }
    }

    private void diselectAllTabs() {
        this.tabEur.setSelected(false);
        this.tabAud.setSelected(false);
        this.tabCad.setSelected(false);
        this.tabNzd.setSelected(false);
        this.tabMajor.setSelected(false);
        this.tabChf.setSelected(false);
        this.tabGbp.setSelected(false);
        this.tabJpy.setSelected(false);
    }

    /* access modifiers changed from: private */
    public void showGBP() {
        diselectAllTabs();
        this.tabGbp.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListGbp.getPostsList());
        this.mAdapter.setCategory(512);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showEUR() {
        diselectAllTabs();
        this.tabEur.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListEur.getPostsList());
        this.mAdapter.setCategory(News.EUR_USD_FORECAST);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showAUD() {
        diselectAllTabs();
        this.tabAud.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListAud.getPostsList());
        this.mAdapter.setCategory(News.AUD_USD_DAILY);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showMajor() {
        diselectAllTabs();
        this.tabMajor.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListMajor.getPostsList());
        this.mAdapter.setCategory(1132);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showJPY() {
        diselectAllTabs();
        this.tabJpy.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListJpy.getPostsList());
        this.mAdapter.setCategory(News.USD_JPY_FORECAST);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showCAD() {
        diselectAllTabs();
        this.tabCad.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListCad.getPostsList());
        this.mAdapter.setCategory(News.CANADIAN_DOLAR);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showCHF() {
        diselectAllTabs();
        this.tabChf.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListChf.getPostsList());
        this.mAdapter.setCategory(News.USD_CHF_FORECAST);
        this.mAdapter.notifyDataSetChanged();
        this.list.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void showNZD() {
        diselectAllTabs();
        this.tabNzd.setSelected(true);
        this.adapterList.clear();
        this.adapterList.addAll(this.newsListNzd.getPostsList());
        this.mAdapter.setCategory(News.NZR_USD_FORECAST);
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

    class FetchWeeklyTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        Dialog errorDialog;
        private boolean isMore;
        private boolean isRefresh;

        FetchWeeklyTask(int n, boolean isMore2) {
            WeeklyFragment.this.option = n;
            this.isMore = isMore2;
        }

        FetchWeeklyTask(int n, boolean isMore2, boolean isRefresh2) {
            WeeklyFragment.this.option = n;
            this.isMore = isMore2;
            this.isRefresh = isRefresh2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (this.isMore) {
                WeeklyFragment.this.index = WeeklyFragment.this.list.getFirstVisiblePosition();
                WeeklyFragment.this.footer.setVisibility(0);
            } else if (!this.isRefresh) {
                this.dialog = ProgressDialog.show(WeeklyFragment.this.activity, (CharSequence) null, WeeklyFragment.this.getString(C0089R.string.loading));
                if (!this.dialog.isShowing()) {
                    this.dialog.show();
                }
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                requestWeeklyNews();
                return null;
            } catch (Exception e) {
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        private void requestWeeklyNews() throws Exception {
            if (WeeklyFragment.this.option == 518) {
                if (WeeklyFragment.this.eurPgCount == 0) {
                    WeeklyFragment.this.eurPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.eurPgCount = 1;
                }
                News temp = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, News.EUR_USD_FORECAST, WeeklyFragment.this.eurPgCount);
                if (WeeklyFragment.this.eurPgCount == 1 && !this.isRefresh) {
                    temp = WeeklyFragment.this.delteFirstPost(temp);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListEur = WeeklyFragment.this.mergePosts(temp, WeeklyFragment.this.newsListEur);
                } else {
                    WeeklyFragment.this.newsListEur = temp;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setEurusdNews(WeeklyFragment.this.newsListEur);
            } else if (WeeklyFragment.this.option == 512) {
                if (WeeklyFragment.this.gbpPgCount == 0) {
                    WeeklyFragment.this.gbpPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.gbpPgCount = 1;
                }
                News temp2 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, 512, WeeklyFragment.this.gbpPgCount);
                if (WeeklyFragment.this.gbpPgCount == 1 && !this.isRefresh) {
                    temp2 = WeeklyFragment.this.delteFirstPost(temp2);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListGbp = WeeklyFragment.this.mergePosts(temp2, WeeklyFragment.this.newsListGbp);
                } else {
                    WeeklyFragment.this.newsListGbp = temp2;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setGbpNews(WeeklyFragment.this.newsListGbp);
            } else if (WeeklyFragment.this.option == 516) {
                if (WeeklyFragment.this.audPgCount == 0) {
                    WeeklyFragment.this.audPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.audPgCount = 1;
                }
                News temp3 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, News.AUD_USD_DAILY, WeeklyFragment.this.audPgCount);
                if (WeeklyFragment.this.audPgCount == 1 && !this.isRefresh) {
                    temp3 = WeeklyFragment.this.delteFirstPost(temp3);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListAud = WeeklyFragment.this.mergePosts(temp3, WeeklyFragment.this.newsListAud);
                } else {
                    WeeklyFragment.this.newsListAud = temp3;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setGbpNews(WeeklyFragment.this.newsListAud);
            } else if (WeeklyFragment.this.option == 1132) {
                if (WeeklyFragment.this.majorPgCount == 0) {
                    WeeklyFragment.this.majorPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.majorPgCount = 1;
                }
                News temp4 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, 1132, WeeklyFragment.this.majorPgCount);
                if (WeeklyFragment.this.majorPgCount == 1 && !this.isRefresh) {
                    temp4 = WeeklyFragment.this.delteFirstPost(temp4);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListMajor = WeeklyFragment.this.mergePosts(temp4, WeeklyFragment.this.newsListMajor);
                } else {
                    WeeklyFragment.this.newsListMajor = temp4;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setMajorsNews(WeeklyFragment.this.newsListMajor);
            } else if (WeeklyFragment.this.option == 932) {
                if (WeeklyFragment.this.jpyPgCount == 0) {
                    WeeklyFragment.this.jpyPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.jpyPgCount = 1;
                }
                News temp5 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, News.USD_JPY_FORECAST, WeeklyFragment.this.jpyPgCount);
                if (WeeklyFragment.this.jpyPgCount == 1 && !this.isRefresh) {
                    temp5 = WeeklyFragment.this.delteFirstPost(temp5);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListJpy = WeeklyFragment.this.mergePosts(temp5, WeeklyFragment.this.newsListJpy);
                } else {
                    WeeklyFragment.this.newsListJpy = temp5;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setJpyNews(WeeklyFragment.this.newsListJpy);
            } else if (WeeklyFragment.this.option == 554) {
                if (WeeklyFragment.this.chfPgCount == 0) {
                    WeeklyFragment.this.chfPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.chfPgCount = 1;
                }
                News temp6 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, News.USD_CHF_FORECAST, WeeklyFragment.this.chfPgCount);
                if (WeeklyFragment.this.chfPgCount == 1 && !this.isRefresh) {
                    temp6 = WeeklyFragment.this.delteFirstPost(temp6);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListChf = WeeklyFragment.this.mergePosts(temp6, WeeklyFragment.this.newsListChf);
                } else {
                    WeeklyFragment.this.newsListChf = temp6;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setChfNews(WeeklyFragment.this.newsListChf);
            } else if (WeeklyFragment.this.option == 511) {
                if (WeeklyFragment.this.cadPgCount == 0) {
                    WeeklyFragment.this.cadPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.cadPgCount = 1;
                }
                News temp7 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, News.CANADIAN_DOLAR, WeeklyFragment.this.cadPgCount);
                if (WeeklyFragment.this.cadPgCount == 1 && !this.isRefresh) {
                    temp7 = WeeklyFragment.this.delteFirstPost(temp7);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListCad = WeeklyFragment.this.mergePosts(temp7, WeeklyFragment.this.newsListCad);
                } else {
                    WeeklyFragment.this.newsListCad = temp7;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setCadNews(WeeklyFragment.this.newsListCad);
            } else if (WeeklyFragment.this.option == 522) {
                if (WeeklyFragment.this.nzdPgCount == 0) {
                    WeeklyFragment.this.nzdPgCount = 1;
                }
                if (this.isRefresh) {
                    WeeklyFragment.this.nzdPgCount = 1;
                }
                News temp8 = WSController.getMoreNewsFromJson(WeeklyFragment.this.activity, News.NZR_USD_FORECAST, WeeklyFragment.this.nzdPgCount);
                if (WeeklyFragment.this.nzdPgCount == 1 && !this.isRefresh) {
                    temp8 = WeeklyFragment.this.delteFirstPost(temp8);
                }
                if (!this.isRefresh) {
                    WeeklyFragment.this.newsListNzd = WeeklyFragment.this.mergePosts(temp8, WeeklyFragment.this.newsListNzd);
                } else {
                    WeeklyFragment.this.newsListNzd = temp8;
                }
                NewsController.getInstance(WeeklyFragment.this.activity).setNzdNews(WeeklyFragment.this.newsListNzd);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (!WeeklyFragment.this.refreshCancelled) {
                if (this.isMore) {
                    WeeklyFragment.this.footer.setVisibility(8);
                    WeeklyFragment.this.isLoading = false;
                } else if (this.dialog != null && this.dialog.isShowing()) {
                    this.dialog.dismiss();
                    showErrorDialog();
                }
            }
            WeeklyFragment.this.refreshCancelled = false;
            super.onCancelled();
        }

        private void showErrorDialog() {
            this.errorDialog = GuiUtil.showErrorDialog((FragmentActivity) WeeklyFragment.this.activity, WeeklyFragment.this.getString(C0089R.string.server_error), false, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    FetchWeeklyTask.this.errorDialog.dismiss();
                    WeeklyFragment.this.isLoading = false;
                }
            });
            synchronized (this) {
                if (!WeeklyFragment.this.isDialogShowing) {
                    this.errorDialog.show();
                    WeeklyFragment.this.isDialogShowing = true;
                }
            }
            this.errorDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    WeeklyFragment.this.isDialogShowing = false;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            dismissProgress();
            if (!isCancelled()) {
                WeeklyFragment.this.isLoading = false;
                if (WeeklyFragment.this.option == 518) {
                    WeeklyFragment.this.showEUR();
                } else if (WeeklyFragment.this.option == 512) {
                    WeeklyFragment.this.showGBP();
                } else if (WeeklyFragment.this.option == 516) {
                    WeeklyFragment.this.showAUD();
                } else if (WeeklyFragment.this.option == 1132) {
                    WeeklyFragment.this.showMajor();
                } else if (WeeklyFragment.this.option == 932) {
                    WeeklyFragment.this.showJPY();
                } else if (WeeklyFragment.this.option == 554) {
                    WeeklyFragment.this.showCHF();
                } else if (WeeklyFragment.this.option == 511) {
                    WeeklyFragment.this.showCAD();
                } else if (WeeklyFragment.this.option == 522) {
                    WeeklyFragment.this.showNZD();
                }
            } else {
                WeeklyFragment.this.isLoading = false;
                showErrorDialog();
            }
            if (this.isRefresh) {
                WeeklyFragment.this.list.onRefreshComplete();
            }
            super.onPostExecute(result);
        }

        private void dismissProgress() {
            if (this.isMore) {
                WeeklyFragment.this.footer.setVisibility(8);
            } else if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public News delteFirstPost(News temp) {
        ArrayList<Post> posts = temp.getPostsList();
        ArrayList<Post> posts2 = new ArrayList<>();
        for (int i = 1; i < posts.size(); i++) {
            posts2.add(posts.get(i));
        }
        temp.setPostsList(posts2);
        return temp;
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
        checkTask();
        new GaTask(getActivity(), 0, "ui_action", "Specific News Tap", "Specific News Tap,View: Weekly").execute(new Void[0]);
        try {
            NewsController.getInstance(this.activity).setSelectedPost(((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position));
            startActivity(new Intent(getActivity(), NewsContentActivity.class));
            addReadPostToPreferences(((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position).getId());
        } catch (ArrayIndexOutOfBoundsException e) {
        }
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
        EasyTracker.getTracker().sendView("Weekly View");
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
        checkTask();
        this.task = new FetchWeeklyTask(this.currentTab, true);
        this.task.execute(new String[0]);
    }

    public void incrementPageCount() {
        switch (this.currentTab) {
            case News.CANADIAN_DOLAR /*511*/:
                this.cadPgCount++;
                return;
            case 512:
                this.gbpPgCount++;
                return;
            case News.AUD_USD_DAILY /*516*/:
                this.audPgCount++;
                return;
            case News.EUR_USD_FORECAST /*518*/:
                this.eurPgCount++;
                return;
            case News.NZR_USD_FORECAST /*522*/:
                this.nzdPgCount++;
                return;
            case News.USD_CHF_FORECAST /*554*/:
                this.chfPgCount++;
                return;
            case News.USD_JPY_FORECAST /*932*/:
                this.jpyPgCount++;
                return;
            case 1132:
                this.majorPgCount++;
                return;
            default:
                return;
        }
    }

    public void onResume() {
        super.onResume();
        if (NewsController.getInstance(getActivity()).getEurusdNews() == null) {
            this.eurPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getAudNews() == null) {
            this.audPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getCadNews() == null) {
            this.cadPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getNzdNews() == null) {
            this.nzdPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getMajorsNews() == null) {
            this.majorPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getChfNews() == null) {
            this.chfPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getGbpNews() == null) {
            this.gbpPgCount = 0;
        }
        if (NewsController.getInstance(getActivity()).getJpyNews() == null) {
            this.jpyPgCount = 0;
        }
        if (this.list.getAdapter() != null) {
            ((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        }
    }
}
