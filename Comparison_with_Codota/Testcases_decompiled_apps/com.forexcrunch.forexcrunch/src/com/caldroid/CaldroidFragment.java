package com.caldroid;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Message;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.antonyt.infiniteviewpager.InfiniteViewPager;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.achartengine.renderer.DefaultRenderer;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@SuppressLint({"DefaultLocale"})
public class CaldroidFragment extends DialogFragment {
    public static final int NUMBER_OF_PAGES = 4;
    public static int disabledBackgroundDrawable = -1;
    public static int disabledTextColor = -7829368;
    public static int selectedBackgroundDrawable = -1;
    public static int selectedTextColor = DefaultRenderer.BACKGROUND_COLOR;
    public String TAG = "CaldroidFragment";
    protected HashMap<String, Object> caldroidData = new HashMap<>();
    /* access modifiers changed from: private */
    public CaldroidListener caldroidListener;
    protected ArrayList<DateTime> dateInMonthsList;
    private AdapterView.OnItemClickListener dateItemClickListener;
    protected ArrayList<CaldroidGridAdapter> datePagerAdapters = new ArrayList<>();
    private InfiniteViewPager dateViewPager;
    protected String dialogTitle;
    protected ArrayList<DateTime> disableDates = new ArrayList<>();
    protected boolean enableSwipe = true;
    protected HashMap<String, Object> extraData = new HashMap<>();
    private boolean fitAllMonths = true;
    private ArrayList<DateGridFragment> fragments;
    private Button leftArrowButton;
    protected DateTime maxDateTime;
    protected DateTime minDateTime;
    protected int month = -1;
    private TextView monthTitleTextView;
    private DatePageChangeListener pageChangeListener;
    private Button rightArrowButton;
    protected ArrayList<DateTime> selectedDates = new ArrayList<>();
    protected boolean showNavigationArrows = true;
    protected int startDayOfWeek = 7;
    private GridView weekdayGridView;
    protected int year = -1;

    public CaldroidGridAdapter getNewDatesGridAdapter(int month2, int year2) {
        return new CaldroidGridAdapter(getActivity(), month2, year2, getCaldroidData(), this.extraData);
    }

    public GridView getWeekdayGridView() {
        return this.weekdayGridView;
    }

    public Button getLeftArrowButton() {
        return this.leftArrowButton;
    }

    public void setLeftArrowButton(Button leftArrowButton2) {
        this.leftArrowButton = leftArrowButton2;
    }

    public Button getRightArrowButton() {
        return this.rightArrowButton;
    }

    public void setRightArrowButton(Button rightArrowButton2) {
        this.rightArrowButton = rightArrowButton2;
    }

    public TextView getMonthTitleTextView() {
        return this.monthTitleTextView;
    }

    public void setMonthTitleTextView(TextView monthTitleTextView2) {
        this.monthTitleTextView = monthTitleTextView2;
    }

    public ArrayList<CaldroidGridAdapter> getDatePagerAdapters() {
        return this.datePagerAdapters;
    }

    public HashMap<String, Object> getCaldroidData() {
        this.caldroidData.clear();
        this.caldroidData.put("disableDates", this.disableDates);
        this.caldroidData.put("selectedDates", this.selectedDates);
        this.caldroidData.put("minDateTime", this.minDateTime);
        this.caldroidData.put("maxDateTime", this.maxDateTime);
        this.caldroidData.put("startDayOfWeek", Integer.valueOf(this.startDayOfWeek));
        return this.caldroidData;
    }

    public HashMap<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(HashMap<String, Object> extraData2) {
        this.extraData = extraData2;
    }

    public Bundle getSavedStates() {
        Bundle bundle = new Bundle();
        bundle.putInt(CalendarItem.MONHT, this.month);
        bundle.putInt("year", this.year);
        if (this.dialogTitle != null) {
            bundle.putString("dialogTitle", this.dialogTitle);
        }
        if (this.selectedDates != null && this.selectedDates.size() > 0) {
            bundle.putStringArrayList("selectedDates", CalendarHelper.convertToStringList(this.selectedDates));
        }
        if (this.disableDates != null && this.disableDates.size() > 0) {
            bundle.putStringArrayList("disableDates", CalendarHelper.convertToStringList(this.disableDates));
        }
        if (this.minDateTime != null) {
            bundle.putString("minDate", this.minDateTime.toString("yyyy-MM-dd"));
        }
        if (this.maxDateTime != null) {
            bundle.putString("maxDate", this.maxDateTime.toString("yyyy-MM-dd"));
        }
        bundle.putBoolean("showNavigationArrows", this.showNavigationArrows);
        bundle.putBoolean("enableSwipe", this.enableSwipe);
        bundle.putInt("startDayOfWeek", this.startDayOfWeek);
        bundle.putBoolean("fitAllMonths", this.fitAllMonths);
        return bundle;
    }

    public void saveStatesToKey(Bundle outState, String key) {
        outState.putBundle(key, getSavedStates());
    }

    public void restoreStatesFromKey(Bundle savedInstanceState, String key) {
        if (savedInstanceState != null && savedInstanceState.containsKey(key)) {
            setArguments(savedInstanceState.getBundle(key));
        }
    }

    public void restoreDialogStatesFromKey(FragmentManager manager, Bundle savedInstanceState, String key, String dialogTag) {
        restoreStatesFromKey(savedInstanceState, key);
        CaldroidFragment existingDialog = (CaldroidFragment) manager.findFragmentByTag(dialogTag);
        if (existingDialog != null) {
            existingDialog.dismiss();
            show(manager, dialogTag);
        }
    }

    public int getCurrentVirtualPosition() {
        return this.pageChangeListener.getCurrent(this.dateViewPager.getCurrentItem());
    }

    public void moveToDate(Date date) {
        moveToDateTime(CalendarHelper.convertDateToDateTime(date));
    }

    public void moveToDateTime(DateTime dateTime) {
        DateTime firstOfMonth = new DateTime(this.year, this.month, 1, 0, 0);
        DateTime lastOfMonth = firstOfMonth.dayOfMonth().withMaximumValue();
        if (dateTime.isBefore((ReadableInstant) firstOfMonth)) {
            this.pageChangeListener.setCurrentDateTime(dateTime.plusMonths(1));
            int currentItem = this.dateViewPager.getCurrentItem();
            this.pageChangeListener.refreshAdapters(currentItem);
            this.dateViewPager.setCurrentItem(currentItem - 1);
        } else if (dateTime.isAfter((ReadableInstant) lastOfMonth)) {
            this.pageChangeListener.setCurrentDateTime(dateTime.minusMonths(1));
            int currentItem2 = this.dateViewPager.getCurrentItem();
            this.pageChangeListener.refreshAdapters(currentItem2);
            this.dateViewPager.setCurrentItem(currentItem2 + 1);
        }
    }

    public void setCalendarDate(Date date) {
        setCalendarDateTime(new DateTime((Object) date));
    }

    public void setCalendarDateTime(DateTime dateTime) {
        this.month = dateTime.getMonthOfYear();
        this.year = dateTime.getYear();
        if (this.caldroidListener != null) {
            this.caldroidListener.onChangeMonth(this.month, this.year);
        }
        refreshView();
    }

    public void prevMonth() {
        this.dateViewPager.setCurrentItem(this.pageChangeListener.getCurrentPage() - 1);
    }

    public void nextMonth() {
        this.dateViewPager.setCurrentItem(this.pageChangeListener.getCurrentPage() + 1);
    }

    public void clearDisableDates() {
        this.disableDates.clear();
    }

    public void setDisableDates(ArrayList<Date> disableDateList) {
        this.disableDates.clear();
        if (disableDateList != null && disableDateList.size() != 0) {
            Iterator<Date> it = disableDateList.iterator();
            while (it.hasNext()) {
                this.disableDates.add(CalendarHelper.convertDateToDateTime(it.next()));
            }
        }
    }

    public void setDisableDatesFromString(ArrayList<String> disableDateStrings) {
        setDisableDatesFromString(disableDateStrings, (String) null);
    }

    public void setDisableDatesFromString(ArrayList<String> disableDateStrings, String dateFormat) {
        this.disableDates.clear();
        if (disableDateStrings != null) {
            Iterator<String> it = disableDateStrings.iterator();
            while (it.hasNext()) {
                this.disableDates.add(CalendarHelper.getDateTimeFromString(it.next(), dateFormat));
            }
        }
    }

    public void clearSelectedDates() {
        this.selectedDates.clear();
    }

    public void setSelectedDates(Date fromDate, Date toDate) {
        if (fromDate != null && toDate != null && !fromDate.after(toDate)) {
            this.selectedDates.clear();
            DateTime fromDateTime = CalendarHelper.convertDateToDateTime(fromDate);
            DateTime toDateTime = CalendarHelper.convertDateToDateTime(toDate);
            for (DateTime dateTime = fromDateTime; dateTime.isBefore((ReadableInstant) toDateTime); dateTime = dateTime.plusDays(1)) {
                this.selectedDates.add(dateTime);
            }
            this.selectedDates.add(toDateTime);
        }
    }

    public void setSelectedDateStrings(String fromDateString, String toDateString, String dateFormat) throws ParseException {
        setSelectedDates(CalendarHelper.getDateFromString(fromDateString, dateFormat), CalendarHelper.getDateFromString(toDateString, dateFormat));
    }

    public boolean isShowNavigationArrows() {
        return this.showNavigationArrows;
    }

    public void setShowNavigationArrows(boolean showNavigationArrows2) {
        this.showNavigationArrows = showNavigationArrows2;
        if (showNavigationArrows2) {
            this.leftArrowButton.setVisibility(0);
            this.rightArrowButton.setVisibility(0);
            return;
        }
        this.leftArrowButton.setVisibility(4);
        this.rightArrowButton.setVisibility(4);
    }

    public boolean isEnableSwipe() {
        return this.enableSwipe;
    }

    public void setEnableSwipe(boolean enableSwipe2) {
        this.enableSwipe = enableSwipe2;
        this.dateViewPager.setEnabled(enableSwipe2);
    }

    public void setMinDate(Date minDate) {
        if (minDate == null) {
            this.minDateTime = null;
        } else {
            this.minDateTime = CalendarHelper.convertDateToDateTime(minDate);
        }
    }

    public boolean isFitAllMonths() {
        return this.fitAllMonths;
    }

    public void setFitAllMonths(boolean fitAllMonths2) {
        this.fitAllMonths = fitAllMonths2;
        this.dateViewPager.setFitAllMonths(fitAllMonths2);
    }

    public void setMinDateFromString(String minDateString, String dateFormat) {
        if (minDateString == null) {
            setMinDate((Date) null);
        } else {
            this.minDateTime = CalendarHelper.getDateTimeFromString(minDateString, dateFormat);
        }
    }

    public void setMaxDate(Date maxDate) {
        if (maxDate == null) {
            this.maxDateTime = null;
        } else {
            this.maxDateTime = CalendarHelper.convertDateToDateTime(maxDate);
        }
    }

    public void setMaxDateFromString(String maxDateString, String dateFormat) {
        if (maxDateString == null) {
            setMaxDate((Date) null);
        } else {
            this.maxDateTime = CalendarHelper.getDateTimeFromString(maxDateString, dateFormat);
        }
    }

    public void setCaldroidListener(CaldroidListener caldroidListener2) {
        this.caldroidListener = caldroidListener2;
    }

    private AdapterView.OnItemClickListener getDateItemClickListener() {
        this.dateItemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DateTime dateTime = CaldroidFragment.this.dateInMonthsList.get(position);
                if (CaldroidFragment.this.caldroidListener == null) {
                    return;
                }
                if (CaldroidFragment.this.minDateTime != null && dateTime.isBefore((ReadableInstant) CaldroidFragment.this.minDateTime)) {
                    return;
                }
                if (CaldroidFragment.this.maxDateTime != null && dateTime.isAfter((ReadableInstant) CaldroidFragment.this.maxDateTime)) {
                    return;
                }
                if (CaldroidFragment.this.disableDates == null || CaldroidFragment.this.disableDates.indexOf(dateTime) == -1) {
                    CaldroidFragment.this.caldroidListener.onSelectDate(dateTime.toDate(), view);
                }
            }
        };
        return this.dateItemClickListener;
    }

    public void refreshView() {
        this.monthTitleTextView.setText(String.valueOf(new DateTime(this.year, this.month, 1, 0, 0).monthOfYear().getAsText().toUpperCase()) + " " + this.year);
        Iterator<CaldroidGridAdapter> it = this.datePagerAdapters.iterator();
        while (it.hasNext()) {
            CaldroidGridAdapter adapter = it.next();
            adapter.setCaldroidData(getCaldroidData());
            adapter.setExtraData(this.extraData);
            adapter.notifyDataSetChanged();
        }
    }

    private void retrieveInitialArgs(Bundle savedInstanceState) {
        Bundle args = getArguments();
        if (args != null) {
            this.month = args.getInt(CalendarItem.MONHT, -1);
            this.year = args.getInt("year", -1);
            this.dialogTitle = args.getString("dialogTitle");
            Dialog dialog = getDialog();
            if (dialog != null) {
                if (this.dialogTitle != null) {
                    dialog.setTitle(this.dialogTitle);
                } else {
                    dialog.requestWindowFeature(1);
                }
            }
            this.startDayOfWeek = args.getInt("startDayOfWeek", 1);
            if (this.startDayOfWeek > 7) {
                this.startDayOfWeek %= 7;
            }
            this.showNavigationArrows = args.getBoolean("showNavigationArrows", true);
            this.enableSwipe = args.getBoolean("enableSwipe", true);
            this.fitAllMonths = args.getBoolean("fitAllMonths", true);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
            ArrayList<String> disableDateStrings = args.getStringArrayList("disableDates");
            if (disableDateStrings != null && disableDateStrings.size() > 0) {
                Iterator<String> it = disableDateStrings.iterator();
                while (it.hasNext()) {
                    this.disableDates.add(formatter.parseDateTime(it.next()));
                }
            }
            ArrayList<String> selectedDateStrings = args.getStringArrayList("selectedDates");
            if (selectedDateStrings != null && selectedDateStrings.size() > 0) {
                Iterator<String> it2 = selectedDateStrings.iterator();
                while (it2.hasNext()) {
                    this.selectedDates.add(formatter.parseDateTime(it2.next()));
                }
            }
            String minDateTimeString = args.getString("minDate");
            if (minDateTimeString != null) {
                this.minDateTime = CalendarHelper.getDateTimeFromString(minDateTimeString, (String) null);
            }
            String maxDateTimeString = args.getString("maxDate");
            if (maxDateTimeString != null) {
                this.maxDateTime = CalendarHelper.getDateTimeFromString(maxDateTimeString, (String) null);
            }
        }
        if (this.month == -1 || this.year == -1) {
            DateTime dateTime = new DateTime();
            this.month = dateTime.getMonthOfYear();
            this.year = dateTime.getYear();
        }
    }

    public static CaldroidFragment newInstance(String dialogTitle2, int month2, int year2) {
        CaldroidFragment f = new CaldroidFragment();
        Bundle args = new Bundle();
        args.putString("dialogTitle", dialogTitle2);
        args.putInt(CalendarItem.MONHT, month2);
        args.putInt("year", year2);
        f.setArguments(args);
        return f;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        retrieveInitialArgs(savedInstanceState);
        View view = inflater.inflate(C0087R.layout.calendar_view, container, false);
        this.monthTitleTextView = (TextView) view.findViewById(C0087R.C0088id.calendar_month_year_textview);
        this.leftArrowButton = (Button) view.findViewById(C0087R.C0088id.calendar_left_arrow);
        this.rightArrowButton = (Button) view.findViewById(C0087R.C0088id.calendar_right_arrow);
        this.leftArrowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CaldroidFragment.this.prevMonth();
            }
        });
        this.rightArrowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CaldroidFragment.this.nextMonth();
            }
        });
        setShowNavigationArrows(this.showNavigationArrows);
        this.weekdayGridView = (GridView) view.findViewById(C0087R.C0088id.weekday_gridview);
        this.weekdayGridView.setAdapter(new WeekdayArrayAdapter(getActivity(), 17367043, getDaysOfWeek()));
        setupDateGridPages(view);
        refreshView();
        return view;
    }

    private void setupDateGridPages(View view) {
        DateTime currentDateTime = new DateTime(this.year, this.month, 1, 0, 0, 0);
        this.dateInMonthsList = CalendarHelper.getFullWeeks(this.month, this.year, this.startDayOfWeek);
        this.pageChangeListener = new DatePageChangeListener();
        this.pageChangeListener.setCurrentDateTime(currentDateTime);
        CaldroidGridAdapter adapter0 = getNewDatesGridAdapter(currentDateTime.getMonthOfYear(), currentDateTime.getYear());
        DateTime nextDateTime = currentDateTime.plusMonths(1);
        CaldroidGridAdapter adapter1 = getNewDatesGridAdapter(nextDateTime.getMonthOfYear(), nextDateTime.getYear());
        DateTime next2DateTime = nextDateTime.plusMonths(1);
        CaldroidGridAdapter adapter2 = getNewDatesGridAdapter(next2DateTime.getMonthOfYear(), next2DateTime.getYear());
        DateTime prevDateTime = currentDateTime.minusMonths(1);
        CaldroidGridAdapter adapter3 = getNewDatesGridAdapter(prevDateTime.getMonthOfYear(), prevDateTime.getYear());
        this.datePagerAdapters.add(adapter0);
        this.datePagerAdapters.add(adapter1);
        this.datePagerAdapters.add(adapter2);
        this.datePagerAdapters.add(adapter3);
        this.pageChangeListener.setCaldroidGridAdapters(this.datePagerAdapters);
        this.dateViewPager = (InfiniteViewPager) view.findViewById(C0087R.C0088id.months_infinite_pager);
        this.dateViewPager.setEnabled(this.enableSwipe);
        this.dateViewPager.setFitAllMonths(this.fitAllMonths);
        this.dateViewPager.setDateInMonthsList(this.dateInMonthsList);
        MonthPagerAdapter monthPagerAdapter = new MonthPagerAdapter(getChildFragmentManager());
        this.fragments = monthPagerAdapter.getFragments();
        for (int i = 0; i < 4; i++) {
            DateGridFragment dateGridFragment = this.fragments.get(i);
            dateGridFragment.setGridAdapter(this.datePagerAdapters.get(i));
            dateGridFragment.setOnItemClickListener(getDateItemClickListener());
        }
        this.dateViewPager.setAdapter(new InfinitePagerAdapter(monthPagerAdapter));
        this.dateViewPager.setOnPageChangeListener(this.pageChangeListener);
    }

    private ArrayList<String> getDaysOfWeek() {
        ArrayList<String> list = new ArrayList<>();
        DateTime monday = new DateTime(2013, 2, 18, 0, 0);
        DateTime nextDay = monday;
        if (this.startDayOfWeek != 1) {
            nextDay = monday.plusDays(this.startDayOfWeek);
        }
        for (int i = 0; i < 7; i++) {
            list.add(nextDay.dayOfWeek().getAsShortText().toUpperCase());
            nextDay = nextDay.plusDays(1);
        }
        return list;
    }

    public class DatePageChangeListener implements ViewPager.OnPageChangeListener {
        private ArrayList<CaldroidGridAdapter> caldroidGridAdapters;
        private DateTime currentDateTime;
        private int currentPage = 1000;

        public DatePageChangeListener() {
        }

        public int getCurrentPage() {
            return this.currentPage;
        }

        public void setCurrentPage(int currentPage2) {
            this.currentPage = currentPage2;
        }

        public DateTime getCurrentDateTime() {
            return this.currentDateTime;
        }

        public void setCurrentDateTime(DateTime dateTime) {
            this.currentDateTime = dateTime;
            CaldroidFragment.this.setCalendarDateTime(this.currentDateTime);
        }

        public ArrayList<CaldroidGridAdapter> getCaldroidGridAdapters() {
            return this.caldroidGridAdapters;
        }

        public void setCaldroidGridAdapters(ArrayList<CaldroidGridAdapter> caldroidGridAdapters2) {
            this.caldroidGridAdapters = caldroidGridAdapters2;
        }

        private int getNext(int position) {
            return (position + 1) % 4;
        }

        private int getPrevious(int position) {
            return (position + 3) % 4;
        }

        public int getCurrent(int position) {
            return position % 4;
        }

        public void onPageScrollStateChanged(int position) {
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void refreshAdapters(int position) {
            CaldroidGridAdapter currentAdapter = this.caldroidGridAdapters.get(getCurrent(position));
            CaldroidGridAdapter prevAdapter = this.caldroidGridAdapters.get(getPrevious(position));
            CaldroidGridAdapter nextAdapter = this.caldroidGridAdapters.get(getNext(position));
            if (position == this.currentPage) {
                currentAdapter.setAdapterDateTime(this.currentDateTime);
                currentAdapter.notifyDataSetChanged();
                prevAdapter.setAdapterDateTime(this.currentDateTime.minusMonths(1));
                prevAdapter.notifyDataSetChanged();
                nextAdapter.setAdapterDateTime(this.currentDateTime.plusMonths(1));
                nextAdapter.notifyDataSetChanged();
            } else if (position > this.currentPage) {
                this.currentDateTime = this.currentDateTime.plusMonths(1);
                nextAdapter.setAdapterDateTime(this.currentDateTime.plusMonths(1));
                nextAdapter.notifyDataSetChanged();
            } else {
                this.currentDateTime = this.currentDateTime.minusMonths(1);
                prevAdapter.setAdapterDateTime(this.currentDateTime.minusMonths(1));
                prevAdapter.notifyDataSetChanged();
            }
            this.currentPage = position;
        }

        public void onPageSelected(int position) {
            refreshAdapters(position);
            CaldroidFragment.this.setCalendarDateTime(this.currentDateTime);
            CaldroidFragment.this.dateInMonthsList.clear();
            CaldroidFragment.this.dateInMonthsList.addAll(this.caldroidGridAdapters.get(position % 4).getDatetimeList());
        }
    }
}
