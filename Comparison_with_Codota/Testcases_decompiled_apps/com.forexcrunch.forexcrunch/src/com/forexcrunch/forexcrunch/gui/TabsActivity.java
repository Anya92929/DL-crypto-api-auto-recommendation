package com.forexcrunch.forexcrunch.gui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.content.AsyncTaskLoader;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.apprater.AppRater;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.local.LocalFragmentManager;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.p003ga.GaTask;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.analytics.tracking.android.EasyTracker;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import java.util.Stack;

public class TabsActivity extends SlidingFragmentActivity implements View.OnClickListener {
    private LinearLayout aboutCont;
    private Button btnCalendar;
    private Button btnDaily;
    private Button btnHome;
    private Button btnNews;
    private Button btnPromos;
    private ImageButton btnSideMenu;
    private ImageButton btnTrending;
    private Button btnWeekly;
    private AsyncTaskLoader dailyTask;
    private EditText editText;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    /* access modifiers changed from: private */
    public boolean isShowingSideMenu = false;
    int lastTabId = 0;
    private AsyncTaskLoader moreTask;
    private AsyncTaskLoader newsTask;
    private LinearLayout savedArticlesCont;
    private LinearLayout settingsCont;
    private LinearLayout subscribeCont;
    private AsyncTaskLoader weeklyTask;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0089R.layout.tabs_activity);
        setBehindContentView((int) C0089R.layout.side_menu);
        this.btnCalendar = (Button) findViewById(C0089R.idTabsActivity.btn_calendar);
        this.btnCalendar.setOnClickListener(this);
        this.btnDaily = (Button) findViewById(C0089R.idTabsActivity.btn_daily);
        this.btnDaily.setOnClickListener(this);
        this.btnWeekly = (Button) findViewById(C0089R.idTabsActivity.btn_weekly);
        this.btnWeekly.setOnClickListener(this);
        this.btnNews = (Button) findViewById(C0089R.idTabsActivity.btn_news);
        this.btnNews.setOnClickListener(this);
        this.btnHome = (Button) findViewById(C0089R.idTabsActivity.btn_home);
        this.btnHome.setOnClickListener(this);
        this.btnSideMenu = (ImageButton) findViewById(C0089R.idTabsActivity.sideMenuBtn);
        this.btnSideMenu.setOnClickListener(this);
        this.btnTrending = (ImageButton) findViewById(C0089R.idTabsActivity.trending);
        this.btnTrending.setOnClickListener(this);
        this.isShowingSideMenu = false;
        GuiUtil.initImageLoader(this);
        this.btnHome.performClick();
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
        this.editText = (EditText) findViewById(C0089R.idSideMenu.search);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 3) {
                    return false;
                }
                TabsActivity.this.performSearch(v.getText().toString());
                return true;
            }
        });
        AppRater.app_launched(this);
        this.dailyTask = new FetchDailyDataTask(this);
        this.dailyTask.forceLoad();
        this.weeklyTask = new FetchWeeklyDataTask(this);
        this.weeklyTask.forceLoad();
        this.newsTask = new FetchNewsDataTask(this);
        this.newsTask.forceLoad();
    }

    /* access modifiers changed from: protected */
    public void performSearch(String searchFor) {
        new SearchNewsTask(searchFor).execute(new String[0]);
    }

    public void onBackPressed() {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                Stack<Fragment> stack = LocalFragmentManager.getInstance(TabsActivity.this).getFragmentStack(-1);
                Fragment lastFragment = TabsActivity.this.getSupportFragmentManager().findFragmentById(C0089R.idTabsActivity.fragment);
                if (!stack.isEmpty() && !(lastFragment instanceof HomeFragment)) {
                    TabsActivity.this.attachFragment(stack.pop(), true, false);
                    LocalFragmentManager.getInstance(TabsActivity.this).setFragmentStack(stack, LocalFragmentManager.getInstance(TabsActivity.this).getCurrentTab());
                    return null;
                } else if (TabsActivity.this.isShowingSideMenu) {
                    TabsActivity.this.toggle();
                    return null;
                } else {
                    TabsActivity.this.finish();
                    return null;
                }
            }
        }.execute(new Void[0]);
    }

    public void onClick(View view) {
        Fragment fragment = null;
        if (view.getId() == C0089R.idTabsActivity.sideMenuBtn) {
            new GaTask(this, 0, "ui_action", "Side Menu Button Tap", "Side Menu Button Tap,View: Navigation").execute(new Void[0]);
            if (!this.isShowingSideMenu) {
                toggle();
            }
        } else if (view.getId() == C0089R.idTabsActivity.trending) {
            showTrendingsActivity();
        } else {
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
                case C0089R.idTabsActivity.btn_home:
                    this.btnTrending.setVisibility(0);
                    pushLastFragmentIntoStack();
                    LocalFragmentManager.getInstance(this).setCurrentTab(0);
                    Stack<Fragment> homeStack = LocalFragmentManager.getInstance(this).getFragmentStack(0);
                    if (homeStack != null && !homeStack.isEmpty()) {
                        fragment = LocalFragmentManager.getInstance(this).getFragmentStack(0).pop();
                        break;
                    } else {
                        fragment = new HomeFragment();
                        break;
                    }
                    break;
                case C0089R.idTabsActivity.btn_daily:
                    if (this.dailyTask != null) {
                        this.dailyTask.cancelLoad();
                    }
                    this.btnTrending.setVisibility(8);
                    pushLastFragmentIntoStack();
                    LocalFragmentManager.getInstance(this).setCurrentTab(1);
                    Stack<Fragment> dailyStack = LocalFragmentManager.getInstance(this).getFragmentStack(1);
                    if (dailyStack != null && !dailyStack.isEmpty()) {
                        fragment = LocalFragmentManager.getInstance(this).getFragmentStack(1).pop();
                        break;
                    } else {
                        fragment = new DailyFragment();
                        break;
                    }
                case C0089R.idTabsActivity.btn_weekly:
                    if (this.weeklyTask != null) {
                        this.weeklyTask.cancelLoad();
                    }
                    this.btnTrending.setVisibility(8);
                    pushLastFragmentIntoStack();
                    LocalFragmentManager.getInstance(this).setCurrentTab(2);
                    Stack<Fragment> weeklyStack = LocalFragmentManager.getInstance(this).getFragmentStack(2);
                    if (weeklyStack != null && !weeklyStack.isEmpty()) {
                        fragment = LocalFragmentManager.getInstance(this).getFragmentStack(2).pop();
                        break;
                    } else {
                        fragment = new WeeklyFragment();
                        break;
                    }
                    break;
                case C0089R.idTabsActivity.btn_news:
                    if (this.newsTask != null) {
                        this.newsTask.cancelLoad();
                    }
                    this.btnTrending.setVisibility(8);
                    pushLastFragmentIntoStack();
                    LocalFragmentManager.getInstance(this).setCurrentTab(3);
                    Stack<Fragment> newsStack = LocalFragmentManager.getInstance(this).getFragmentStack(3);
                    if (newsStack != null && !newsStack.isEmpty()) {
                        fragment = LocalFragmentManager.getInstance(this).getFragmentStack(3).pop();
                        break;
                    } else {
                        fragment = new NewsFragment();
                        break;
                    }
                    break;
                case C0089R.idTabsActivity.btn_calendar:
                    this.btnTrending.setVisibility(8);
                    pushLastFragmentIntoStack();
                    LocalFragmentManager.getInstance(this).setCurrentTab(4);
                    Stack<Fragment> calendarStack = LocalFragmentManager.getInstance(this).getFragmentStack(4);
                    if (calendarStack != null && !calendarStack.isEmpty()) {
                        fragment = LocalFragmentManager.getInstance(this).getFragmentStack(4).pop();
                        break;
                    } else {
                        fragment = new CalendarListFragment();
                        break;
                    }
            }
            if (this.lastTabId != view.getId()) {
                changeSelectedTab(LocalFragmentManager.getInstance(this).getCurrentTab());
                attachFragment(fragment, false, false);
                this.lastTabId = view.getId();
                return;
            }
            LocalFragmentManager.getInstance(this).getFragmentStack(-1).clear();
            attachFragment(getFirstFragment(view.getId()), false, false);
        }
    }

    private void showTrendingsActivity() {
        startActivity(new Intent(this, TrendingActivity.class));
    }

    private Fragment getFirstFragment(int id) {
        switch (id) {
            case C0089R.idTabsActivity.btn_home:
                return new HomeFragment();
            case C0089R.idTabsActivity.btn_daily:
                return new DailyFragment();
            case C0089R.idTabsActivity.btn_weekly:
                return new WeeklyFragment();
            case C0089R.idTabsActivity.btn_news:
                return new NewsFragment();
            case C0089R.idTabsActivity.btn_calendar:
                return new CalendarListFragment();
            default:
                return null;
        }
    }

    public void hideTrending() {
        this.btnTrending.setVisibility(8);
    }

    private void changeSelectedTab(int type) {
        this.btnHome.setSelected(false);
        this.btnHome.setTextColor(getResources().getColor(C0089R.color.disabled_tab));
        this.btnDaily.setSelected(false);
        this.btnDaily.setTextColor(getResources().getColor(C0089R.color.disabled_tab));
        this.btnWeekly.setSelected(false);
        this.btnWeekly.setTextColor(getResources().getColor(C0089R.color.disabled_tab));
        this.btnNews.setSelected(false);
        this.btnNews.setTextColor(getResources().getColor(C0089R.color.disabled_tab));
        this.btnCalendar.setSelected(false);
        this.btnCalendar.setTextColor(getResources().getColor(C0089R.color.disabled_tab));
        switch (type) {
            case 0:
                this.btnHome.setSelected(true);
                this.btnHome.setTextColor(getResources().getColor(17170443));
                return;
            case 1:
                this.btnDaily.setSelected(true);
                this.btnDaily.setTextColor(getResources().getColor(17170443));
                return;
            case 2:
                this.btnHome.setSelected(true);
                this.btnWeekly.setTextColor(getResources().getColor(17170443));
                return;
            case 3:
                this.btnNews.setSelected(true);
                this.btnNews.setTextColor(getResources().getColor(17170443));
                return;
            case 4:
                this.btnCalendar.setSelected(true);
                this.btnCalendar.setTextColor(getResources().getColor(17170443));
                return;
            default:
                return;
        }
    }

    private void pushLastFragmentIntoStack() {
        Stack<Fragment> stack;
        Fragment lastFragment = getSupportFragmentManager().findFragmentById(C0089R.idTabsActivity.fragment);
        if (lastFragment != null && (stack = LocalFragmentManager.getInstance(this).getFragmentStack(-1)) != null) {
            if (stack.isEmpty()) {
                stack.push(lastFragment);
            } else if (stack.peek().getClass() != lastFragment.getClass()) {
                stack.push(lastFragment);
            }
        }
    }

    public void disableTabs() {
        this.btnWeekly.setClickable(false);
        this.btnNews.setClickable(false);
        this.btnHome.setClickable(false);
        this.btnPromos.setClickable(false);
        this.btnDaily.setClickable(false);
        this.btnCalendar.setClickable(false);
    }

    public void enableTabs() {
        this.btnWeekly.setClickable(true);
        this.btnNews.setClickable(true);
        this.btnHome.setClickable(true);
        this.btnPromos.setClickable(true);
        this.btnDaily.setClickable(true);
        this.btnCalendar.setClickable(true);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        GuiUtil.setPaused(true);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        GuiUtil.setPaused(false);
        GuiUtil.executePending(this);
        super.onResume();
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
            this.dialog = ProgressDialog.show(TabsActivity.this, (CharSequence) null, TabsActivity.this.getString(C0089R.string.loading));
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                this.searchResults = WSController.requestSearch(TabsActivity.this, this.searchFor);
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
            Dialog dialog2 = GuiUtil.showErrorDialog(TabsActivity.this, TabsActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!TabsActivity.this.isDialogShowing) {
                    dialog2.show();
                    TabsActivity.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    TabsActivity.this.isDialogShowing = false;
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
                Dialog dialog2 = GuiUtil.showErrorDialog(TabsActivity.this, TabsActivity.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!TabsActivity.this.isDialogShowing) {
                        dialog2.show();
                        TabsActivity.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        TabsActivity.this.isDialogShowing = false;
                    }
                });
            } else if (this.searchResults != null && !this.searchResults.isEmptyOrNullPostList()) {
                NewsController.getInstance(TabsActivity.this).setSearchResults(this.searchResults);
                GuiUtil.showSearchResultsActivity(TabsActivity.this, this.searchFor);
            }
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

    public class FragmentManagerTask extends AsyncTask<Void, Void, Void> {
        Fragment fragment;
        boolean isBack;
        boolean showAnim;

        public FragmentManagerTask(Fragment fragment2, boolean isBack2, boolean showAnim2) {
            this.isBack = isBack2;
            this.fragment = fragment2;
            this.showAnim = showAnim2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            FragmentManager fragmentManager = TabsActivity.this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (this.showAnim) {
                if (this.isBack) {
                    fragmentTransaction.setCustomAnimations(C0089R.anim.fragment_left_in_animation, C0089R.anim.fragment_right_out_animation);
                } else {
                    fragmentTransaction.setCustomAnimations(C0089R.anim.fragment_right_in_animation, C0089R.anim.fragment_left_out_animation);
                }
            }
            if (fragmentManager.findFragmentById(C0089R.idTabsActivity.fragment) == null) {
                fragmentTransaction.add((int) C0089R.idTabsActivity.fragment, this.fragment);
                fragmentTransaction.addToBackStack((String) null);
                fragmentTransaction.commit();
            } else {
                fragmentTransaction.replace(C0089R.idTabsActivity.fragment, this.fragment);
                fragmentTransaction.addToBackStack((String) null);
                fragmentTransaction.commit();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    public void attachFragment(Fragment fragment, boolean isBack, boolean displayAnimation) {
        new FragmentManagerTask(fragment, isBack, displayAnimation).execute(new Void[0]);
    }

    class FetchDailyDataTask extends AsyncTaskLoader {

        /* renamed from: e */
        private Exception f64e;
        String response;

        public FetchDailyDataTask(Context context) {
            super(context);
        }

        public Object loadInBackground() {
            try {
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setEurNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.EUR_USD_DAILY, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setForecastNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), 21, 1));
                return null;
            } catch (Exception e) {
                this.f64e = e;
                cancelLoad();
                e.printStackTrace();
                return null;
            }
        }
    }

    class FetchWeeklyDataTask extends AsyncTaskLoader {

        /* renamed from: e */
        private Exception f66e;
        String response;

        public FetchWeeklyDataTask(Context context) {
            super(context);
        }

        public Object loadInBackground() {
            try {
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setEurusdNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.EUR_USD_FORECAST, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setGbpNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), 512, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setAudNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.AUD_USD_DAILY, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setMajorsNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), 1132, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setJpyNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.USD_JPY_FORECAST, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setChfNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.USD_CHF_FORECAST, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setCadNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.CANADIAN_DOLAR, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setNzdNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.NZR_USD_FORECAST, 1));
                return null;
            } catch (Exception e) {
                this.f66e = e;
                cancelLoad();
                e.printStackTrace();
                return null;
            }
        }
    }

    class FetchNewsDataTask extends AsyncTaskLoader {

        /* renamed from: e */
        private Exception f65e;
        String response;

        public FetchNewsDataTask(Context context) {
            super(context);
        }

        public Object loadInBackground() {
            try {
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setNewsNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), 53, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setOpinionsNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), 38, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setIndustryNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.FOREX_INDUSTRY, 1));
                NewsController.getInstance(TabsActivity.this.getApplicationContext()).setBitsNews(WSController.getMoreNewsFromJson(TabsActivity.this.getApplicationContext(), News.FOREX_BITS, 1));
                return null;
            } catch (Exception e) {
                this.f65e = e;
                cancelLoad();
                e.printStackTrace();
                return null;
            }
        }
    }
}
