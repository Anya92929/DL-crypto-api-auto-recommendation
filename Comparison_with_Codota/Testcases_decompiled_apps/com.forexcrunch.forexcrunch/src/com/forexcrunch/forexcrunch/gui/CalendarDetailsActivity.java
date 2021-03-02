package com.forexcrunch.forexcrunch.gui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.HistTableListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import com.forexcrunch.forexcrunch.model.HistTableModel;
import com.forexcrunch.forexcrunch.model.MarketImpactCalDetails;
import com.forexcrunch.forexcrunch.model.NewsCalDetails;
import com.forexcrunch.forexcrunch.p003ga.GaTask;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.analytics.tracking.android.EasyTracker;
import java.util.ArrayList;

public class CalendarDetailsActivity extends FragmentActivity implements View.OnClickListener {
    private ArrayList<HistTableModel> adapterList;
    private ImageButton btnChart;
    private Button btnHistory;
    private Button btnInfo;
    private Button btnMarket;
    private Button btnNews;
    /* access modifiers changed from: private */
    public CalendarItem calendarItem;
    private FrameLayout fragmentContainer;
    /* access modifiers changed from: private */
    public ArrayList<HistTableModel> histTableItemsList;
    private LinearLayout historyContainer;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    private ListView list;
    private HistTableListAdapter mAdapter;
    /* access modifiers changed from: private */
    public MarketImpactCalDetails marketCalDetails;
    /* access modifiers changed from: private */
    public ArrayList<NewsCalDetails> newsCalDetailsList;
    private TextView tvDateHeader;
    private TextView tvEmpty;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.calendar_details_fragment);
        initComponents();
        this.calendarItem = NewsController.getInstance(this).getSelectedCalendarItem();
        if (this.calendarItem != null) {
            fillCalendarItemInfo();
        }
        this.btnInfo.performClick();
    }

    private void fillCalendarItemInfo() {
        TextView event = (TextView) findViewById(C0089R.idCalendarListItem.event);
        TextView actualText = (TextView) findViewById(C0089R.idCalendarListItem.actualText);
        TextView consensusText = (TextView) findViewById(C0089R.idCalendarListItem.consensusText);
        TextView previousText = (TextView) findViewById(C0089R.idCalendarListItem.previousText);
        TextView gmtText = (TextView) findViewById(C0089R.idCalendarListItem.gmtText);
        ImageView volatility = (ImageView) findViewById(C0089R.idCalendarListItem.volatility);
        ImageView flag = (ImageView) findViewById(C0089R.idCalendarListItem.flag);
        int currentDay = this.calendarItem.getDateTime().getDay();
        this.tvDateHeader.setText(Utils.getFormattedMonthAndDay(this.calendarItem.getDateTime().getMonth(), currentDay));
        if (this.calendarItem.getInternationalCode() == null || this.calendarItem.getInternationalCode().equals("")) {
            flag.setImageResource(C0089R.drawable.nocountry);
        } else {
            flag.setImageResource(Utils.getFlagImageId(this.calendarItem.getInternationalCode().toLowerCase(), this));
        }
        event.setText(this.calendarItem.getName());
        fillCalendarTableInfo(actualText, consensusText, previousText, gmtText, volatility);
    }

    private void fillCalendarTableInfo(TextView actualText, TextView consensusText, TextView previousText, TextView gmtText, ImageView volatility) {
        gmtText.setText(Utils.getFormattedTime(this.calendarItem.getDateTime().getHour(), this.calendarItem.getDateTime().getMinute()));
        volatility.setImageResource(Utils.getVolatilityResourceId(this.calendarItem.getVolatility()));
        if (this.calendarItem.getDisplayConsensus() == null || this.calendarItem.getDisplayConsensus().equals("")) {
            consensusText.setText("-");
        } else {
            consensusText.setText(this.calendarItem.getDisplayConsensus());
        }
        if (this.calendarItem.getDisplayActual() == null || this.calendarItem.getDisplayActual().equals("")) {
            actualText.setText("-");
        } else {
            actualText.setText(this.calendarItem.getDisplayActual());
        }
        if (this.calendarItem.getDisplayPrevious() == null || this.calendarItem.getDisplayPrevious().equals("")) {
            previousText.setText("-");
        } else {
            previousText.setText(this.calendarItem.getDisplayPrevious());
        }
    }

    private void initComponents() {
        this.tvDateHeader = (TextView) findViewById(C0089R.idCalendarDetailsFragment.dateHeader);
        this.tvEmpty = (TextView) findViewById(C0089R.idCalendarDetailsFragment.empty);
        this.btnInfo = (Button) findViewById(C0089R.idCalendarDetailsFragment.btnInfo);
        this.btnInfo.setOnClickListener(this);
        this.btnNews = (Button) findViewById(C0089R.idCalendarDetailsFragment.btnNews);
        this.btnNews.setOnClickListener(this);
        this.btnHistory = (Button) findViewById(C0089R.idCalendarDetailsFragment.btnHistory);
        this.btnHistory.setOnClickListener(this);
        this.btnMarket = (Button) findViewById(C0089R.idCalendarDetailsFragment.btnMarket);
        this.btnMarket.setOnClickListener(this);
        this.fragmentContainer = (FrameLayout) findViewById(C0089R.idCalendarDetailsFragment.fragmentContainer);
        this.historyContainer = (LinearLayout) findViewById(C0089R.idCalendarDetailsFragment.historyContainer);
    }

    private void initHistoryComponents() {
        this.btnChart = (ImageButton) findViewById(C0089R.idHistoryCalDetails.graphic);
        this.btnChart.setOnClickListener(this);
        this.list = (ListView) findViewById(C0089R.idHistoryCalDetails.list);
        if (this.mAdapter == null && this.adapterList == null) {
            this.adapterList = new ArrayList<>();
            this.mAdapter = new HistTableListAdapter(this, C0089R.layout.historical_table_list_item, this.adapterList);
            this.list.setAdapter(this.mAdapter);
            if (this.histTableItemsList == null || this.histTableItemsList.isEmpty()) {
                this.list.setVisibility(8);
                findViewById(C0089R.idHistoryCalDetails.empty_msg).setVisibility(0);
                ((ImageButton) findViewById(C0089R.idHistoryCalDetails.historicalTable)).setEnabled(false);
                ((ImageButton) findViewById(C0089R.idHistoryCalDetails.graphic)).setEnabled(false);
                return;
            }
            this.adapterList.addAll(this.histTableItemsList);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        NewsController.getInstance(this).clearCalendarDetails();
    }

    public void onClick(View view) {
        diselectAllTabs(view.getId());
        switch (view.getId()) {
            case C0089R.idCalendarDetailsFragment.btnInfo:
                new GaTask(this, 0, "ui_action", "Info Button Tap", "Info Button Tap,View: Calendar Specific").execute(new Void[0]);
                view.setSelected(true);
                showInfo();
                return;
            case C0089R.idCalendarDetailsFragment.btnNews:
                new GaTask(this, 0, "ui_action", "News Button Tap", "News Button Tap,View: Calendar Specific").execute(new Void[0]);
                view.setSelected(true);
                requestNews();
                return;
            case C0089R.idCalendarDetailsFragment.btnHistory:
                this.fragmentContainer.setVisibility(8);
                this.historyContainer.setVisibility(0);
                new GaTask(this, 0, "ui_action", "History Button Tap", "History Button Tap,View: Calendar Specific").execute(new Void[0]);
                view.setSelected(true);
                if (this.histTableItemsList == null) {
                    requestHistory();
                    return;
                }
                return;
            case C0089R.idCalendarDetailsFragment.btnMarket:
                new GaTask(this, 0, "ui_action", "Market Button Tap", "Market Button Tap,View: Calendar Specific").execute(new Void[0]);
                view.setSelected(true);
                requestMarketImpact();
                return;
            case C0089R.idHistoryCalDetails.graphic:
                this.btnHistory.setSelected(true);
                showGraphic();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void showGraphic() {
        if (this.histTableItemsList != null && !this.histTableItemsList.isEmpty()) {
            startActivity(new Intent(this, ChartActivity.class));
        }
    }

    private void showInfo() {
        InfoFragment fragment = new InfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("info", GuiUtil.formatStringFromHtml(this.calendarItem.getHTMLDescription()));
        fragment.setArguments(bundle);
        new FragmentManagerTask(fragment, false, false).execute(new Void[0]);
    }

    private void requestNews() {
        new RequestCalendarDetailsTask(Constants.NEWS_CALENDAR_DETAILS).execute(new String[0]);
    }

    private void requestMarketImpact() {
        new RequestCalendarDetailsTask(Constants.MARKET_IMPACTS_CALENDAR_DETAILS).execute(new String[0]);
    }

    private void requestHistory() {
        new RequestCalendarDetailsTask(Constants.HISTORY_CALENDAR_DETAILS).execute(new String[0]);
    }

    private void diselectAllTabs(int id) {
        this.btnHistory.setSelected(false);
        this.btnInfo.setSelected(false);
        this.btnMarket.setSelected(false);
        this.btnNews.setSelected(false);
        if (id != C0089R.idHistoryCalDetails.graphic) {
            this.historyContainer.setVisibility(8);
            if (!this.fragmentContainer.isShown()) {
                this.fragmentContainer.setVisibility(0);
                this.tvEmpty.setVisibility(8);
            }
        }
    }

    class RequestCalendarDetailsTask extends AsyncTask<String, Void, Void> {
        HistTableListAdapter adapter;
        ProgressDialog dialog;
        String option;
        String response;
        String viewParameter;

        public RequestCalendarDetailsTask(String option2) {
            this.option = option2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(CalendarDetailsActivity.this, (CharSequence) null, CalendarDetailsActivity.this.getString(C0089R.string.loading));
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                if (this.option.equals(Constants.NEWS_CALENDAR_DETAILS) && (CalendarDetailsActivity.this.newsCalDetailsList == null || CalendarDetailsActivity.this.newsCalDetailsList.isEmpty())) {
                    CalendarDetailsActivity.this.newsCalDetailsList = WSController.getNewsCalendarDetails(CalendarDetailsActivity.this, CalendarDetailsActivity.this.calendarItem.getIdEcoCalendarDate());
                    for (int i = 0; i < CalendarDetailsActivity.this.newsCalDetailsList.size(); i++) {
                        ((NewsCalDetails) CalendarDetailsActivity.this.newsCalDetailsList.get(i)).setNewscalendarContent(WSController.requestNewsCalendarDetailsText(CalendarDetailsActivity.this, ((NewsCalDetails) CalendarDetailsActivity.this.newsCalDetailsList.get(i)).getId()));
                    }
                    NewsController.getInstance(CalendarDetailsActivity.this).setNewsCalDetailsList(CalendarDetailsActivity.this.newsCalDetailsList);
                    return null;
                } else if (this.option.equals(Constants.HISTORY_CALENDAR_DETAILS) && (CalendarDetailsActivity.this.histTableItemsList == null || CalendarDetailsActivity.this.histTableItemsList.isEmpty())) {
                    CalendarDetailsActivity.this.histTableItemsList = WSController.getHistoryCalendarDetails(CalendarDetailsActivity.this, CalendarDetailsActivity.this.calendarItem.getIdEcoCalendarDate());
                    if (CalendarDetailsActivity.this.histTableItemsList == null || CalendarDetailsActivity.this.histTableItemsList.isEmpty()) {
                        return null;
                    }
                    NewsController.getInstance(CalendarDetailsActivity.this).setHistTableItems(CalendarDetailsActivity.this.histTableItemsList);
                    return null;
                } else if (!this.option.equals(Constants.MARKET_IMPACTS_CALENDAR_DETAILS) || CalendarDetailsActivity.this.marketCalDetails != null) {
                    return null;
                } else {
                    CalendarDetailsActivity.this.marketCalDetails = WSController.getMarketImpactCalendarDetails(CalendarDetailsActivity.this, CalendarDetailsActivity.this.calendarItem.getIdEcoCalendarDate());
                    NewsController.getInstance(CalendarDetailsActivity.this).setMarketCalDetails(CalendarDetailsActivity.this.marketCalDetails);
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
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            Dialog dialog2 = GuiUtil.showErrorDialog(CalendarDetailsActivity.this, CalendarDetailsActivity.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!CalendarDetailsActivity.this.isDialogShowing) {
                    dialog2.show();
                    CalendarDetailsActivity.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    CalendarDetailsActivity.this.isDialogShowing = false;
                }
            });
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (isCancelled()) {
                Dialog dialog2 = GuiUtil.showErrorDialog(CalendarDetailsActivity.this, CalendarDetailsActivity.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!CalendarDetailsActivity.this.isDialogShowing) {
                        dialog2.show();
                        CalendarDetailsActivity.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        CalendarDetailsActivity.this.isDialogShowing = false;
                    }
                });
            } else if (this.option.equals(Constants.NEWS_CALENDAR_DETAILS)) {
                CalendarDetailsActivity.this.showNewsList();
            } else if (this.option.equals(Constants.HISTORY_CALENDAR_DETAILS)) {
                CalendarDetailsActivity.this.showHistory();
            } else if (this.option.equals(Constants.MARKET_IMPACTS_CALENDAR_DETAILS)) {
                CalendarDetailsActivity.this.showMarketImpacts();
            }
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            super.onPostExecute(result);
        }
    }

    public void showNewsList() {
        if (this.newsCalDetailsList == null || this.newsCalDetailsList.isEmpty()) {
            this.fragmentContainer.setVisibility(8);
            this.tvEmpty.setVisibility(0);
            return;
        }
        new FragmentManagerTask(new NewsCalDetailsFragment(), false, false).execute(new Void[0]);
    }

    public void showMarketImpacts() {
        new FragmentManagerTask(new MarketImpactFragment(), false, false).execute(new Void[0]);
    }

    public void showHistory() {
        this.historyContainer.setVisibility(0);
        showHistoricalTable();
    }

    /* access modifiers changed from: protected */
    public void showHistoricalTable() {
        initHistoryComponents();
    }

    public void onStart() {
        super.onStart();
        EasyTracker.getInstance();
        EasyTracker.getTracker().sendView("Calendar Specific View");
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
            FragmentManager fragmentManager = CalendarDetailsActivity.this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (this.showAnim) {
                if (this.isBack) {
                    fragmentTransaction.setCustomAnimations(C0089R.anim.fragment_left_in_animation, C0089R.anim.fragment_right_out_animation);
                } else {
                    fragmentTransaction.setCustomAnimations(C0089R.anim.fragment_right_in_animation, C0089R.anim.fragment_left_out_animation);
                }
            }
            if (fragmentManager.findFragmentById(C0089R.idCalendarDetailsFragment.fragmentContainer) == null) {
                fragmentTransaction.add((int) C0089R.idCalendarDetailsFragment.fragmentContainer, this.fragment);
                fragmentTransaction.addToBackStack((String) null);
                fragmentTransaction.commit();
            } else {
                fragmentTransaction.replace(C0089R.idCalendarDetailsFragment.fragmentContainer, this.fragment);
                fragmentTransaction.addToBackStack((String) null);
                fragmentTransaction.commit();
            }
            return null;
        }
    }
}
