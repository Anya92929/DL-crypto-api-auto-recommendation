package com.caldroid;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.achartengine.renderer.DefaultRenderer;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

public class CaldroidGridAdapter extends BaseAdapter {
    protected HashMap<String, Object> caldroidData = new HashMap<>();
    protected Context context;
    protected ArrayList<DateTime> datetimeList;
    protected ArrayList<DateTime> disableDates;
    protected HashMap<String, Object> extraData = new HashMap<>();
    protected DateTime maxDateTime;
    protected DateTime minDateTime;
    protected int month;
    protected ArrayList<DateTime> selectedDates;
    protected int startDayOfWeek;
    protected DateTime today;
    protected int year;

    public void setAdapterDateTime(DateTime dateTime) {
        this.month = dateTime.getMonthOfYear();
        this.year = dateTime.getYear();
        this.datetimeList = CalendarHelper.getFullWeeks(this.month, this.year, this.startDayOfWeek);
    }

    public ArrayList<DateTime> getDatetimeList() {
        return this.datetimeList;
    }

    public DateTime getMinDateTime() {
        return this.minDateTime;
    }

    public void setMinDateTime(DateTime minDateTime2) {
        this.minDateTime = minDateTime2;
    }

    public DateTime getMaxDateTime() {
        return this.maxDateTime;
    }

    public void setMaxDateTime(DateTime maxDateTime2) {
        this.maxDateTime = maxDateTime2;
    }

    public ArrayList<DateTime> getDisableDates() {
        return this.disableDates;
    }

    public void setDisableDates(ArrayList<DateTime> disableDates2) {
        this.disableDates = disableDates2;
    }

    public ArrayList<DateTime> getSelectedDates() {
        return this.selectedDates;
    }

    public void setSelectedDates(ArrayList<DateTime> selectedDates2) {
        this.selectedDates = selectedDates2;
    }

    public HashMap<String, Object> getCaldroidData() {
        return this.caldroidData;
    }

    public void setCaldroidData(HashMap<String, Object> caldroidData2) {
        this.caldroidData = caldroidData2;
        populateFromCaldroidData();
    }

    public HashMap<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(HashMap<String, Object> extraData2) {
        this.extraData = extraData2;
    }

    public CaldroidGridAdapter(Context context2, int month2, int year2, HashMap<String, Object> caldroidData2, HashMap<String, Object> extraData2) {
        this.month = month2;
        this.year = year2;
        this.context = context2;
        this.caldroidData = caldroidData2;
        this.extraData = extraData2;
        populateFromCaldroidData();
    }

    private void populateFromCaldroidData() {
        this.disableDates = (ArrayList) this.caldroidData.get("disableDates");
        this.selectedDates = (ArrayList) this.caldroidData.get("selectedDates");
        this.minDateTime = (DateTime) this.caldroidData.get("minDateTime");
        this.maxDateTime = (DateTime) this.caldroidData.get("maxDateTime");
        this.startDayOfWeek = ((Integer) this.caldroidData.get("startDayOfWeek")).intValue();
        this.datetimeList = CalendarHelper.getFullWeeks(this.month, this.year, this.startDayOfWeek);
    }

    /* access modifiers changed from: protected */
    public DateTime getToday() {
        if (this.today == null) {
            this.today = CalendarHelper.convertDateToDateTime(new Date());
        }
        return this.today;
    }

    public int getCount() {
        return this.datetimeList.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        TextView cellView = (TextView) convertView;
        if (convertView == null) {
            cellView = (TextView) inflater.inflate(C0087R.layout.date_cell, (ViewGroup) null);
        }
        cellView.setTextColor(DefaultRenderer.BACKGROUND_COLOR);
        DateTime dateTime = this.datetimeList.get(position);
        Resources resources = this.context.getResources();
        if (dateTime.getMonthOfYear() != this.month) {
            cellView.setTextColor(resources.getColor(C0087R.color.caldroid_darker_gray));
        }
        boolean shouldResetDiabledView = false;
        boolean shouldResetSelectedView = false;
        if ((this.minDateTime == null || !dateTime.isBefore((ReadableInstant) this.minDateTime)) && ((this.maxDateTime == null || !dateTime.isAfter((ReadableInstant) this.maxDateTime)) && (this.disableDates == null || this.disableDates.indexOf(dateTime) == -1))) {
            shouldResetDiabledView = true;
        } else {
            cellView.setTextColor(CaldroidFragment.disabledTextColor);
            if (CaldroidFragment.disabledBackgroundDrawable == -1) {
                cellView.setBackgroundResource(C0087R.drawable.disable_cell);
            } else {
                cellView.setBackgroundResource(CaldroidFragment.disabledBackgroundDrawable);
            }
            if (dateTime.equals(getToday())) {
                cellView.setBackgroundResource(C0087R.drawable.red_border_gray_bg);
            }
        }
        if (this.selectedDates == null || this.selectedDates.indexOf(dateTime) == -1) {
            shouldResetSelectedView = true;
        } else {
            if (CaldroidFragment.selectedBackgroundDrawable != -1) {
                cellView.setBackgroundResource(CaldroidFragment.selectedBackgroundDrawable);
            } else {
                cellView.setBackgroundColor(resources.getColor(C0087R.color.caldroid_sky_blue));
            }
            cellView.setTextColor(CaldroidFragment.selectedTextColor);
        }
        if (shouldResetDiabledView && shouldResetSelectedView) {
            if (dateTime.equals(getToday())) {
                cellView.setBackgroundResource(C0087R.drawable.red_border);
            } else {
                cellView.setBackgroundResource(C0087R.drawable.cell_bg);
            }
        }
        cellView.setText(new StringBuilder().append(dateTime.getDayOfMonth()).toString());
        return cellView;
    }
}
