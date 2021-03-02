package com.forexcrunch.forexcrunch.calendar;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import java.util.Calendar;

public class CalendarAdapter extends BaseAdapter {
    private static final int FIRST_DAY_OF_WEEK = 2;
    private final Calendar calendar;
    private Context context;
    private CalendarItem[] days;
    private final CalendarItem expDay;
    private final LayoutInflater inflater;
    private final CalendarItem selected;
    private final CalendarItem startDay;
    private final CalendarItem today;

    public CalendarAdapter(Context context2, Calendar monthCalendar) {
        this.calendar = monthCalendar;
        this.today = new CalendarItem(monthCalendar);
        this.selected = new CalendarItem(monthCalendar);
        this.startDay = null;
        this.expDay = null;
        this.calendar.set(5, 1);
        this.inflater = (LayoutInflater) context2.getSystemService("layout_inflater");
        this.context = context2;
    }

    public CalendarAdapter(Context context2, Calendar monthCalendar, String start, String end) {
        this.calendar = monthCalendar;
        this.today = new CalendarItem(monthCalendar);
        this.selected = new CalendarItem(monthCalendar);
        this.calendar.set(5, 1);
        this.inflater = (LayoutInflater) context2.getSystemService("layout_inflater");
        this.context = context2;
        this.startDay = stringToCalendarItem(start);
        this.expDay = stringToCalendarItem(end);
    }

    private CalendarItem stringToCalendarItem(String start) {
        String[] date = start.split("-");
        return new CalendarItem(Integer.valueOf(date[0]).intValue(), Integer.valueOf(date[1]).intValue() - 1, Integer.valueOf(date[2]).intValue());
    }

    public int getCount() {
        return this.days.length;
    }

    public Object getItem(int position) {
        return this.days[position];
    }

    public long getItemId(int position) {
        if (this.days[position] != null) {
            return this.days[position].f59id;
        }
        return -1;
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = this.inflater.inflate(C0089R.layout.calendar_item, (ViewGroup) null);
        }
        TextView dayView = (TextView) view.findViewById(C0089R.C0090id.date);
        CalendarItem currentItem = this.days[position];
        if (currentItem == null) {
            dayView.setClickable(false);
            dayView.setFocusable(false);
            view.setBackgroundDrawable((Drawable) null);
            dayView.setText((CharSequence) null);
        } else if (this.startDay != null) {
            compareUsingInterval(view, dayView, currentItem);
        } else {
            compareUsingToday(view, dayView, currentItem);
        }
        return view;
    }

    private void compareUsingInterval(View view, TextView dayView, CalendarItem currentItem) {
        Time startTime = new Time();
        startTime.set(this.startDay.day, this.startDay.month, this.startDay.year);
        Time endTime = new Time();
        endTime.set(this.expDay.day, this.expDay.month, this.expDay.year);
        Time currentItemTime = new Time();
        currentItemTime.set(currentItem.day, currentItem.month, currentItem.year);
        if (Time.compare(currentItemTime, startTime) < 0 || Time.compare(endTime, currentItemTime) < 0) {
            view.setClickable(false);
            view.setEnabled(false);
            dayView.setFocusable(false);
            dayView.setEnabled(false);
            view.setBackgroundColor(this.context.getResources().getColor(C0089R.color.calendar_disabled_bg));
            dayView.setTextColor(this.context.getResources().getColor(C0089R.color.calendar_disabled_text));
        } else if (currentItem.equals(this.selected)) {
            view.setBackgroundResource(C0089R.drawable.selected_background);
            dayView.setTextColor(this.context.getResources().getColor(17170443));
        } else {
            view.setBackgroundResource(C0089R.drawable.normal_background);
            dayView.setTextColor(this.context.getResources().getColor(17170444));
        }
        dayView.setText(currentItem.text);
        if (dayView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) dayView.getLayoutParams()).addRule(13);
        }
        dayView.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "fonts/Calibri-Bold.ttf"));
    }

    private void compareUsingToday(View view, TextView dayView, CalendarItem currentItem) {
        Time todayTime = new Time();
        todayTime.set(this.today.day, this.today.month, this.today.year);
        Time currentItemTime = new Time();
        currentItemTime.set(currentItem.day, currentItem.month, currentItem.year);
        if (Time.compare(currentItemTime, todayTime) < 0) {
            view.setClickable(false);
            view.setEnabled(false);
            dayView.setFocusable(false);
            dayView.setEnabled(false);
            view.setBackgroundColor(this.context.getResources().getColor(C0089R.color.calendar_disabled_bg));
            dayView.setTextColor(this.context.getResources().getColor(C0089R.color.calendar_disabled_text));
        } else if (currentItem.equals(this.today)) {
            view.setBackgroundResource(C0089R.drawable.today_background);
            dayView.setTextColor(this.context.getResources().getColor(17170443));
        } else if (currentItem.equals(this.selected)) {
            view.setBackgroundResource(C0089R.drawable.selected_background);
            dayView.setTextColor(this.context.getResources().getColor(17170443));
        } else {
            view.setBackgroundResource(C0089R.drawable.normal_background);
            dayView.setTextColor(this.context.getResources().getColor(17170444));
        }
        dayView.setText(currentItem.text);
        if (dayView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) dayView.getLayoutParams()).addRule(13);
        }
        dayView.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "fonts/Calibri-Bold.ttf"));
    }

    public final void setSelected(int year, int month, int day) {
        if (year != this.today.year || month != this.today.month) {
            this.selected.year = year;
            this.selected.month = month;
            this.selected.day = day;
        } else if (day > this.today.day) {
            this.selected.year = year;
            this.selected.month = month;
            this.selected.day = day;
        } else {
            this.selected.year = this.today.year;
            this.selected.month = this.today.month;
            this.selected.day = this.today.day;
        }
        notifyDataSetChanged();
    }

    public final void refreshDays() {
        int blankies;
        int year = this.calendar.get(1);
        int month = this.calendar.get(2);
        int firstDayOfMonth = this.calendar.get(7);
        int lastDayOfMonth = this.calendar.getActualMaximum(5);
        if (firstDayOfMonth == 2) {
            blankies = 0;
        } else if (firstDayOfMonth < 2) {
            blankies = 6;
        } else {
            blankies = firstDayOfMonth - 2;
        }
        CalendarItem[] days2 = new CalendarItem[(lastDayOfMonth + blankies)];
        int day = 1;
        int position = blankies;
        while (position < days2.length) {
            days2[position] = new CalendarItem(year, month, day);
            position++;
            day++;
        }
        this.days = days2;
        notifyDataSetChanged();
    }

    public static class CalendarItem {
        public int day;
        public int dayOfWeek;

        /* renamed from: id */
        public long f59id;
        public int month;
        public String text;
        public int year;

        public CalendarItem(Calendar calendar) {
            this(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        public CalendarItem(int year2, int month2, int day2) {
            this.year = year2;
            this.month = month2;
            this.day = day2;
            this.text = String.valueOf(day2);
            this.f59id = Long.valueOf(String.valueOf(year2) + month2 + day2).longValue();
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof CalendarItem)) {
                return false;
            }
            CalendarItem item = (CalendarItem) o;
            if (item.year == this.year && item.month == this.month && item.day == this.day) {
                return true;
            }
            return false;
        }
    }

    public CalendarItem getSelected() {
        return this.selected;
    }

    public CalendarItem getStartDay() {
        return this.startDay;
    }

    public CalendarItem getExpDay() {
        return this.expDay;
    }
}
