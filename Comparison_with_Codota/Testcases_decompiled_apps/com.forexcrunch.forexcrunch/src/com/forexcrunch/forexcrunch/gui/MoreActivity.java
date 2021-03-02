package com.forexcrunch.forexcrunch.gui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.NewsWithHeaderListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.model.Post;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.analytics.tracking.android.EasyTracker;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import java.util.ArrayList;
import org.json.JSONException;
import p006eu.erikw.PullToRefreshListView;

public class MoreActivity extends FragmentActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    /* access modifiers changed from: private */
    public ArrayList<Post> adapterList;
    /* access modifiers changed from: private */
    public Bundle bundle;
    private int currentFirstVisibleItem;
    private int currentScrollState;
    private int currentTab;
    private int currentVisibleItemCount;
    /* access modifiers changed from: private */
    public Dialog errorDialog;
    /* access modifiers changed from: private */
    public LinearLayout footer;
    /* access modifiers changed from: private */
    public int index = 0;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    /* access modifiers changed from: private */
    public PullToRefreshListView list;
    /* access modifiers changed from: private */
    public NewsWithHeaderListAdapter mAdapter;
    /* access modifiers changed from: private */
    public News newsListBasic;
    /* access modifiers changed from: private */
    public News newsListMajors;
    /* access modifiers changed from: private */
    public News newsListMinors;
    private DisplayImageOptions options;
    /* access modifiers changed from: private */
    public int pageCount = 1;
    private int totalCount;
    private TextView txtTitle;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.more_activity);
        initComponents();
        if (getIntent().getExtras() != null) {
            this.bundle = getIntent().getExtras();
        }
        setTitle();
    }

    public void onResume() {
        super.onResume();
        setAdapter();
    }

    private void initComponents() {
        this.list = (PullToRefreshListView) findViewById(C0089R.C0090id.more_listview);
        this.list.setOnItemClickListener(this);
        this.list.setOnScrollListener(this);
        this.txtTitle = (TextView) findViewById(C0089R.C0090id.more_txt_title);
        this.options = new DisplayImageOptions.Builder().showStubImage(C0089R.drawable.fotocarga).cacheInMemory().cacheOnDisc().showImageOnFail(C0089R.drawable.fotocarga).showImageForEmptyUri(C0089R.drawable.fotocarga).displayer(new SimpleBitmapDisplayer()).build();
        this.footer = (LinearLayout) findViewById(C0089R.C0090id.more_footer);
        this.adapterList = new ArrayList<>();
        this.mAdapter = new NewsWithHeaderListAdapter(this, C0089R.layout.news_simple_list_item, this.adapterList, this.options, News.EUR_USD_DAILY);
        this.list.setAdapter(this.mAdapter);
        this.list.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            public void onRefresh() {
                new FetchMoreDataTask(MoreActivity.this.bundle.getInt("option"), false, true).execute(new String[0]);
            }
        });
    }

    private void setAdapter() {
        int option = 0;
        if (this.bundle != null) {
            option = this.bundle.getInt("option");
            this.currentTab = option;
        }
        switch (option) {
            case News.MAJORS /*1102*/:
                this.newsListMajors = NewsController.getInstance(this).getMajorsNews();
                this.adapterList.clear();
                this.adapterList.addAll(this.newsListMajors.getPostsList());
                this.mAdapter.setCategory(option);
                this.mAdapter.notifyDataSetChanged();
                EasyTracker.getInstance();
                EasyTracker.getTracker().sendView("Home View: Majors");
                return;
            case News.MINORS /*1103*/:
                this.newsListMinors = NewsController.getInstance(this).getMinorsNews();
                this.adapterList.clear();
                this.adapterList.addAll(this.newsListMinors.getPostsList());
                this.mAdapter.setCategory(option);
                this.mAdapter.notifyDataSetChanged();
                EasyTracker.getInstance();
                EasyTracker.getTracker().sendView("Home View: Minors");
                return;
            case News.BASICS_INDUSTRY /*1117*/:
                this.newsListBasic = NewsController.getInstance(this).getBasicNews();
                this.adapterList.clear();
                this.adapterList.addAll(this.newsListBasic.getPostsList());
                this.mAdapter.setCategory(option);
                this.mAdapter.notifyDataSetChanged();
                EasyTracker.getInstance();
                EasyTracker.getTracker().sendView("Home View: Basic & Industry");
                return;
            default:
                return;
        }
    }

    private void setTitle() {
        if (this.bundle != null) {
            this.txtTitle.setText(this.bundle.getString("title"));
        }
    }

    class FetchMoreDataTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        boolean isMore;
        boolean isRefresh;
        int option;
        String response;

        public FetchMoreDataTask(int n, boolean isMore2) {
            this.option = n;
            this.isMore = isMore2;
        }

        public FetchMoreDataTask(int n, boolean isMore2, boolean isRefresh2) {
            this.option = n;
            this.isMore = isMore2;
            this.isRefresh = isRefresh2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.isMore) {
                MoreActivity.this.index = MoreActivity.this.list.getFirstVisiblePosition();
                MoreActivity.this.footer.setVisibility(0);
            } else if (!this.isRefresh) {
                this.dialog = ProgressDialog.show(MoreActivity.this, (CharSequence) null, MoreActivity.this.getString(C0089R.string.loading));
                this.dialog.show();
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                if (this.isRefresh) {
                    MoreActivity.this.pageCount = 1;
                }
                if (this.option == 1102) {
                    News temp = WSController.getMoreNewsFromJson(MoreActivity.this, News.MAJORS, MoreActivity.this.pageCount);
                    if (!this.isRefresh) {
                        MoreActivity.this.newsListMajors = MoreActivity.this.mergePosts(temp, MoreActivity.this.newsListMajors);
                    } else {
                        MoreActivity.this.newsListMajors = temp;
                    }
                    if (MoreActivity.this.newsListMajors.getPostsList() == null || MoreActivity.this.newsListMajors.getPostsList().isEmpty()) {
                        return null;
                    }
                    NewsController.getInstance(MoreActivity.this).setMajorsNews(MoreActivity.this.newsListMajors);
                    return null;
                } else if (this.option == 1103) {
                    News temp2 = WSController.getMoreNewsFromJson(MoreActivity.this, News.MINORS, MoreActivity.this.pageCount);
                    if (!this.isRefresh) {
                        MoreActivity.this.newsListMinors = MoreActivity.this.mergePosts(temp2, MoreActivity.this.newsListMinors);
                    } else {
                        MoreActivity.this.newsListMinors = temp2;
                    }
                    if (MoreActivity.this.newsListMinors.getPostsList() == null || MoreActivity.this.newsListMinors.getPostsList().isEmpty()) {
                        return null;
                    }
                    NewsController.getInstance(MoreActivity.this).setMinorsNews(MoreActivity.this.newsListMinors);
                    return null;
                } else if (this.option != 1117) {
                    return null;
                } else {
                    News temp3 = WSController.getMoreNewsFromJson(MoreActivity.this, News.BASICS_INDUSTRY, MoreActivity.this.pageCount);
                    if (!this.isRefresh) {
                        MoreActivity.this.newsListBasic = MoreActivity.this.mergePosts(temp3, MoreActivity.this.newsListBasic);
                    } else {
                        MoreActivity.this.newsListBasic = temp3;
                    }
                    if (MoreActivity.this.newsListBasic.getPostsList() == null || MoreActivity.this.newsListBasic.getPostsList().isEmpty()) {
                        return null;
                    }
                    NewsController.getInstance(MoreActivity.this).setBasicNews(MoreActivity.this.newsListBasic);
                    return null;
                }
            } catch (JSONException e) {
                cancel(true);
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                cancel(true);
                e2.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (this.isMore) {
                MoreActivity.this.footer.setVisibility(8);
            } else if (!this.isRefresh) {
                this.dialog.dismiss();
            }
            MoreActivity.this.isLoading = false;
            Dialog dialog2 = GuiUtil.showErrorDialog(MoreActivity.this, MoreActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!MoreActivity.this.isDialogShowing) {
                    dialog2.show();
                    MoreActivity.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    MoreActivity.this.isDialogShowing = false;
                }
            });
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (this.isMore) {
                MoreActivity.this.footer.setVisibility(8);
                MoreActivity.this.isLoading = false;
            } else if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (isCancelled()) {
                showErrorDialog();
            } else if (this.option == 1102) {
                MoreActivity.this.adapterList.clear();
                MoreActivity.this.adapterList.addAll(MoreActivity.this.newsListMajors.getPostsList());
                MoreActivity.this.mAdapter.setCategory(this.option);
                MoreActivity.this.mAdapter.notifyDataSetChanged();
                EasyTracker.getInstance();
                EasyTracker.getTracker().sendView("Home View: Majors");
            } else if (this.option == 1103) {
                MoreActivity.this.adapterList.clear();
                MoreActivity.this.adapterList.addAll(MoreActivity.this.newsListMinors.getPostsList());
                MoreActivity.this.mAdapter.setCategory(this.option);
                MoreActivity.this.mAdapter.notifyDataSetChanged();
                EasyTracker.getInstance();
                EasyTracker.getTracker().sendView("Home View: Minors");
            } else if (this.option == 1117) {
                MoreActivity.this.adapterList.clear();
                MoreActivity.this.adapterList.addAll(MoreActivity.this.newsListBasic.getPostsList());
                MoreActivity.this.mAdapter.setCategory(this.option);
                MoreActivity.this.mAdapter.notifyDataSetChanged();
                EasyTracker.getInstance();
                EasyTracker.getTracker().sendView("Home View: Basic & Industry");
            }
            if (this.isRefresh) {
                MoreActivity.this.list.onRefreshComplete();
            }
            super.onPostExecute(result);
        }

        private void showErrorDialog() {
            MoreActivity.this.errorDialog = GuiUtil.showErrorDialog((FragmentActivity) MoreActivity.this, MoreActivity.this.getString(C0089R.string.server_error), false, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    MoreActivity.this.errorDialog.dismiss();
                    MoreActivity.this.isLoading = false;
                }
            });
            synchronized (this) {
                if (!MoreActivity.this.isDialogShowing) {
                    MoreActivity.this.errorDialog.show();
                    MoreActivity.this.isDialogShowing = true;
                }
            }
            MoreActivity.this.errorDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    MoreActivity.this.isDialogShowing = false;
                }
            });
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        NewsController.getInstance(this).setSelectedPost(((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position));
        startActivity(new Intent(this, NewsContentActivity.class));
        addReadPostToPreferences(((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getItems().get(position).getId());
    }

    private void addReadPostToPreferences(int id) {
        int category = ((NewsWithHeaderListAdapter) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()).getCategory();
        ArrayList<Integer> readMsgIds = Utils.createIdsList(this, category);
        if (readMsgIds.isEmpty()) {
            readMsgIds.add(Integer.valueOf(id));
        } else if (!readMsgIds.contains(Integer.valueOf(id))) {
            readMsgIds.add(Integer.valueOf(id));
        }
        Utils.idListToPreferences(this, readMsgIds, category);
    }

    /* access modifiers changed from: private */
    public News mergePosts(News response, News target) {
        if (target == null || target.isEmptyOrNullPostList()) {
            return response;
        }
        target.setPostsList(GuiUtil.mergePosts(target.getPostsList(), response.getPostsList()));
        return target;
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
        new FetchMoreDataTask(this.currentTab, true).execute(new String[0]);
    }

    public void incrementPageCount() {
        this.pageCount++;
    }
}
