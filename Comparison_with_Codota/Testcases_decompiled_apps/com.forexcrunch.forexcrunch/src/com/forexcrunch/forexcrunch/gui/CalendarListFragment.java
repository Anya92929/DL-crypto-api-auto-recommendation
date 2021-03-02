package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.CalendarListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import com.forexcrunch.forexcrunch.model.DropDownIconItem;
import com.forexcrunch.forexcrunch.p003ga.GaTask;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;
import java.util.ArrayList;
import org.json.JSONException;

public class CalendarListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, AdListener {
    /* access modifiers changed from: private */
    public Activity activity;
    private DfpAdView adView;
    private ArrayList<CalendarItem> adapterList;
    private Button btnFilters;
    /* access modifiers changed from: private */
    public ArrayList<CalendarItem> calendarList;
    Intent intent;
    /* access modifiers changed from: private */
    public boolean isDialogShowing = false;
    private ListView list;
    private CalendarListAdapter mAdapter;
    private LinearLayout optContainer;
    private ImageView optIcon;
    private ArrayList<DropDownIconItem> optionsList;
    /* access modifiers changed from: private */
    public TextView tvDateHeader;
    private TextView tvOptionName;
    private TextView tvProvider;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0089R.layout.calendar_list_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.activity = getActivity();
        initComponents();
        this.adapterList = new ArrayList<>();
        if (this.mAdapter == null) {
            this.mAdapter = new CalendarListAdapter(this.activity, C0089R.layout.calendar_list_item, this.adapterList);
        } else if (this.adapterList.isEmpty()) {
            this.mAdapter = new CalendarListAdapter(this.activity, C0089R.layout.calendar_list_item, this.adapterList);
        }
        this.list.setAdapter(this.mAdapter);
        if (this.calendarList == null) {
            setOptionImageAndText(0);
        } else {
            setAdapter();
        }
    }

    private void initComponents() {
        this.list = (ListView) getView().findViewById(C0089R.C0090id.CalendarListFragment_listview);
        this.list.setOnItemClickListener(this);
        this.tvDateHeader = (TextView) getView().findViewById(C0089R.C0090id.CalendarListFragment_dateHeader);
        this.tvProvider = (TextView) getView().findViewById(C0089R.C0090id.CalendarListFragment_tvProvider);
        this.tvProvider.setOnClickListener(this);
        this.tvOptionName = (TextView) getView().findViewById(C0089R.C0090id.CalendarListFragment_optName);
        this.optIcon = (ImageView) getView().findViewById(C0089R.C0090id.CalendarListFragment_optionIcon);
        this.optContainer = (LinearLayout) getView().findViewById(C0089R.C0090id.CalendarListFragment_optionContainer);
        this.optContainer.setOnClickListener(this);
        this.btnFilters = (Button) getView().findViewById(C0089R.C0090id.CalendarListFragment_btnFilters);
        this.btnFilters.setOnClickListener(this);
        this.list.setOnScrollListener(this);
        if (this.optionsList == null) {
            this.optionsList = DropDownIconItem.createCalendarDropDownList(getActivity());
        }
    }

    private void requestCalendarItems(int position) {
        switch (position) {
            case 0:
                new GaTask(getActivity(), 0, "ui_action", "Recent & Next Button Tap", "Recent & Next Button Tap,View: Calendar").execute(new Void[0]);
                new RequestCalendarItemsTask(CalendarItem.CURRENT).execute(new String[0]);
                return;
            case 1:
                new GaTask(getActivity(), 0, "ui_action", "Today Button Tap", "Today Button Tap,View: Calendar").execute(new Void[0]);
                new RequestCalendarItemsTask(CalendarItem.TODAY).execute(new String[0]);
                return;
            case 2:
                new GaTask(getActivity(), 0, "ui_action", "Tomorrow Button Tap", "Tomorrow Button Tap,View: Calendar").execute(new Void[0]);
                new RequestCalendarItemsTask(CalendarItem.TOMORROW).execute(new String[0]);
                return;
            case 3:
                new GaTask(getActivity(), 0, "ui_action", "This Week Button Tap", "This Week Button Tap,View: Calendar").execute(new Void[0]);
                new RequestCalendarItemsTask(CalendarItem.WEEK).execute(new String[0]);
                return;
            case 4:
                new GaTask(getActivity(), 0, "ui_action", "Next Week Button Tap", "Next Week Button Tap,View: Calendar").execute(new Void[0]);
                new RequestCalendarItemsTask(CalendarItem.NEXT_WEEK).execute(new String[0]);
                return;
            case 5:
                showFiltersActivity();
                return;
            default:
                new RequestCalendarItemsTask(CalendarItem.CUSTOM).execute(new String[0]);
                return;
        }
    }

    private void showFiltersActivity() {
        startActivityForResult(new Intent(getActivity(), FiltersActivity.class), 1);
    }

    class RequestCalendarItemsTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        String response;
        String viewParameter;

        public RequestCalendarItemsTask(String viewParameter2) {
            this.viewParameter = viewParameter2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(CalendarListFragment.this.activity, (CharSequence) null, CalendarListFragment.this.getString(C0089R.string.loading));
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                CalendarListFragment.this.calendarList = WSController.getCalendarFromJson(CalendarListFragment.this.activity, this.viewParameter);
                return null;
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
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            Dialog dialog2 = GuiUtil.showErrorDialog((FragmentActivity) CalendarListFragment.this.activity, CalendarListFragment.this.getString(C0089R.string.server_error), false);
            synchronized (this) {
                if (!CalendarListFragment.this.isDialogShowing) {
                    dialog2.show();
                    CalendarListFragment.this.isDialogShowing = true;
                }
            }
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    CalendarListFragment.this.isDialogShowing = false;
                }
            });
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (isCancelled() || CalendarListFragment.this.calendarList == null) {
                Dialog dialog2 = GuiUtil.showErrorDialog((FragmentActivity) CalendarListFragment.this.activity, CalendarListFragment.this.getString(C0089R.string.server_error), false);
                synchronized (this) {
                    if (!CalendarListFragment.this.isDialogShowing) {
                        dialog2.show();
                        CalendarListFragment.this.isDialogShowing = true;
                    }
                }
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        CalendarListFragment.this.isDialogShowing = false;
                    }
                });
            } else if (CalendarListFragment.this.calendarList.isEmpty()) {
                CalendarListFragment.this.showEmptyListMessage();
            } else {
                CalendarListFragment.this.hideEmptyListMessage();
                if (CalendarListFragment.this.getArguments() != null) {
                    CalendarListFragment.this.getArguments().clear();
                }
                CalendarListFragment.this.setAdapter();
            }
            super.onPostExecute(result);
        }
    }

    /* access modifiers changed from: private */
    public void setAdapter() {
        this.adapterList.clear();
        this.adapterList.addAll(this.calendarList);
        this.mAdapter.notifyDataSetChanged();
    }

    public void showEmptyListMessage() {
        if (getView() != null) {
            getView().findViewById(C0089R.C0090id.CalendarListFragment_empty_list_message).setVisibility(0);
            this.list.setVisibility(8);
        }
    }

    public void hideEmptyListMessage() {
        if (getView() != null) {
            getView().findViewById(C0089R.C0090id.CalendarListFragment_empty_list_message).setVisibility(8);
            this.list.setVisibility(0);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0089R.C0090id.CalendarListFragment_btnFilters:
                new GaTask(getActivity(), 0, "ui_action", "Filters Button Tap", "Filters Button Tap,View: Calendar").execute(new Void[0]);
                showFiltersActivity();
                return;
            case C0089R.C0090id.CalendarListFragment_optionContainer:
                showOptionsAlert();
                return;
            case C0089R.C0090id.CalendarListFragment_tvProvider:
                new GaTask(getActivity(), 0, "ui_action", "FxStreet Button Tap", "FxStreet Button Tap,View: Calendar").execute(new Void[0]);
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.fxstreet.com")));
                return;
            default:
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        NewsController.getInstance(this.activity).setSelectedCalendarItem(this.calendarList.get(position));
        startActivity(new Intent(getActivity(), CalendarDetailsActivity.class));
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (this.calendarList != null && !this.calendarList.isEmpty() && checkChangedDay(firstVisibleItem)) {
            final String date = Utils.getFormattedMonthAndDay(this.calendarList.get(firstVisibleItem).getDateTime().getMonth(), this.calendarList.get(firstVisibleItem).getDateTime().getDay());
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    CalendarListFragment.this.tvDateHeader.setText(date);
                }
            });
        }
    }

    private boolean checkChangedDay(int position) {
        if (!this.tvDateHeader.getText().toString().equals(Utils.getFormattedMonthAndDay(this.calendarList.get(position).getDateTime().getMonth(), this.calendarList.get(position).getDateTime().getDay()))) {
            return true;
        }
        return false;
    }

    private void showOptionsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), C0089R.style.AlertDialogCustom));
        builder.setTitle(C0089R.string.select).setMultiChoiceItems(C0089R.array.options_calendar, (boolean[]) null, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    CalendarListFragment.this.setOptionImageAndText(which);
                    dialog.dismiss();
                }
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void setOptionImageAndText(int position) {
        this.tvOptionName.setText(this.optionsList.get(position).getName());
        this.optIcon.setImageResource(this.optionsList.get(position).getIconResId());
        requestCalendarItems(position);
    }

    public void onStop() {
        super.onStop();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            this.tvOptionName.setText(this.optionsList.get(5).getName());
            this.optIcon.setImageResource(this.optionsList.get(5).getIconResId());
            if (resultCode == -1) {
                requestCalendarItems(6);
            }
        }
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
