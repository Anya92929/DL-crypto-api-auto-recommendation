package com.forexcrunch.forexcrunch.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.calendar.CalendarAdapter;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import java.util.Calendar;
import java.util.Locale;

public class CalendarViewActivity extends Activity {
    protected final Calendar calendar = Calendar.getInstance();
    /* access modifiers changed from: private */
    public CalendarAdapter calendarAdapter;
    private ViewSwitcher calendarSwitcher;
    private TextView currentMonth;
    private TextView dayView;
    public Time endTime;
    private final Locale locale = Locale.getDefault();
    public Time startTime;
    public boolean useIntervals = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.calendar);
        final GestureDetector swipeDetector = new GestureDetector(this, new SwipeGesture(this));
        GridView calendarGrid = (GridView) findViewById(C0089R.C0090id.calendar_grid);
        this.calendarSwitcher = (ViewSwitcher) findViewById(C0089R.C0090id.calendar_switcher);
        this.currentMonth = (TextView) findViewById(C0089R.C0090id.current_month);
        this.calendarAdapter = new CalendarAdapter(this, this.calendar);
        updateCurrentMonth();
        ((ImageView) findViewById(C0089R.C0090id.next_month)).setOnClickListener(new NextMonthClickListener(this, (NextMonthClickListener) null));
        ((ImageView) findViewById(C0089R.C0090id.previous_month)).setOnClickListener(new PreviousMonthClickListener(this, (PreviousMonthClickListener) null));
        calendarGrid.setOnItemClickListener(new DayItemClickListener(this, (DayItemClickListener) null));
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-Bold.ttf");
        ((TextView) findViewById(C0089R.C0090id.txt_fecha)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf"));
        ((TextView) findViewById(C0089R.C0090id.current_month)).setTypeface(font);
        ((Button) findViewById(C0089R.C0090id.btn_ok_cal)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CalendarAdapter.CalendarItem item = CalendarViewActivity.this.calendarAdapter.getSelected();
                int year = item.year;
                int month = item.month;
                int day = item.day;
                Time time = new Time();
                time.set(day, month, year);
                CalendarViewActivity.this.calendar.setTimeInMillis(time.toMillis(false));
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", Utils.getformattedString(CalendarViewActivity.this.calendar));
                CalendarViewActivity.this.setResult(-1, returnIntent);
                CalendarViewActivity.this.finish();
            }
        });
        calendarGrid.setAdapter(this.calendarAdapter);
        calendarGrid.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return swipeDetector.onTouchEvent(event);
            }
        });
        ((GridView) findViewById(C0089R.C0090id.calendar_days_grid)).setAdapter(new ArrayAdapter(this, C0089R.layout.day_item, getResources().getStringArray(C0089R.array.days_array)));
    }

    /* access modifiers changed from: protected */
    public void updateCurrentMonth() {
        this.calendarAdapter.refreshDays();
        this.currentMonth.setText(String.valueOf(String.format(this.locale, "%tB", new Object[]{this.calendar})) + " " + this.calendar.get(1));
    }

    private final class DayItemClickListener implements AdapterView.OnItemClickListener {
        private DayItemClickListener() {
        }

        /* synthetic */ DayItemClickListener(CalendarViewActivity calendarViewActivity, DayItemClickListener dayItemClickListener) {
            this();
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            CharSequence text = ((TextView) view.findViewById(C0089R.C0090id.date)).getText();
            if (text != null && !"".equals(text)) {
                Time today = new Time();
                today.setToNow();
                today.hour = 0;
                today.minute = 0;
                today.second = 0;
                int year = CalendarViewActivity.this.calendar.get(1);
                int month = CalendarViewActivity.this.calendar.get(2);
                int day = Integer.valueOf(String.valueOf(text)).intValue();
                Time selectedDay = new Time();
                selectedDay.set(day, month + 1, year);
                selectedDay.hour = 0;
                selectedDay.minute = 0;
                selectedDay.second = 0;
                if (CalendarViewActivity.this.useIntervals) {
                    if (Time.compare(selectedDay, CalendarViewActivity.this.startTime) >= 0 && Time.compare(selectedDay, CalendarViewActivity.this.endTime) <= 0) {
                        CalendarViewActivity.this.calendarAdapter.setSelected(year, month, day);
                    }
                } else if (Time.compare(selectedDay, today) >= 0) {
                    CalendarViewActivity.this.calendarAdapter.setSelected(year, month, day);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onNextMonth() {
        this.calendarSwitcher.setInAnimation(this, C0089R.anim.in_from_right);
        this.calendarSwitcher.setOutAnimation(this, C0089R.anim.out_to_left);
        this.calendarSwitcher.showNext();
        if (this.calendar.get(2) == 11) {
            this.calendar.set(this.calendar.get(1) + 1, 0, 1);
        } else {
            this.calendar.set(2, this.calendar.get(2) + 1);
        }
        updateCurrentMonth();
    }

    /* access modifiers changed from: protected */
    public final void onPreviousMonth() {
        this.calendarSwitcher.setInAnimation(this, C0089R.anim.in_from_left);
        this.calendarSwitcher.setOutAnimation(this, C0089R.anim.out_to_right);
        this.calendarSwitcher.showPrevious();
        if (this.calendar.get(2) == 0) {
            this.calendar.set(this.calendar.get(1) - 1, 11, 1);
        } else {
            this.calendar.set(2, this.calendar.get(2) - 1);
        }
        updateCurrentMonth();
    }

    private final class NextMonthClickListener implements View.OnClickListener {
        private NextMonthClickListener() {
        }

        /* synthetic */ NextMonthClickListener(CalendarViewActivity calendarViewActivity, NextMonthClickListener nextMonthClickListener) {
            this();
        }

        public void onClick(View v) {
            CalendarViewActivity.this.onNextMonth();
        }
    }

    private final class PreviousMonthClickListener implements View.OnClickListener {
        private PreviousMonthClickListener() {
        }

        /* synthetic */ PreviousMonthClickListener(CalendarViewActivity calendarViewActivity, PreviousMonthClickListener previousMonthClickListener) {
            this();
        }

        public void onClick(View v) {
            CalendarViewActivity.this.onPreviousMonth();
        }
    }

    private final class SwipeGesture extends GestureDetector.SimpleOnGestureListener {
        private final int swipeMinDistance;
        private final int swipeThresholdVelocity;

        public SwipeGesture(Context context) {
            ViewConfiguration viewConfig = ViewConfiguration.get(context);
            this.swipeMinDistance = viewConfig.getScaledTouchSlop();
            this.swipeThresholdVelocity = viewConfig.getScaledMinimumFlingVelocity();
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > ((float) this.swipeMinDistance) && Math.abs(velocityX) > ((float) this.swipeThresholdVelocity)) {
                CalendarViewActivity.this.onNextMonth();
                return false;
            } else if (e2.getX() - e1.getX() <= ((float) this.swipeMinDistance) || Math.abs(velocityX) <= ((float) this.swipeThresholdVelocity)) {
                return false;
            } else {
                CalendarViewActivity.this.onPreviousMonth();
                return false;
            }
        }
    }
}
