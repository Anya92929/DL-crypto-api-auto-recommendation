package com.jackhenry.android.widget.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import com.jackhenry.android.p022a.C1348a;
import com.jackhenry.android.p022a.C1356c;
import com.jackhenry.android.p022a.C1358e;
import com.jackhenry.android.p022a.C1359f;
import com.jackhenry.android.p022a.C1361h;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.android.p022a.C1365l;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CalendarControl extends RelativeLayout implements OnDateChangeRequest, OnDateChosen {

    /* renamed from: a */
    private Calendar f5572a = Calendar.getInstance();

    /* renamed from: b */
    private Calendar f5573b;

    /* renamed from: c */
    private Calendar f5574c;

    /* renamed from: d */
    private boolean f5575d;

    /* renamed from: e */
    private int f5576e;

    /* renamed from: f */
    private int f5577f;

    /* renamed from: g */
    private int f5578g;

    /* renamed from: h */
    private boolean f5579h;

    /* renamed from: i */
    private boolean f5580i = true;

    /* renamed from: j */
    private boolean f5581j;

    /* renamed from: k */
    private boolean f5582k;

    /* renamed from: l */
    private OnDateChosen f5583l;

    /* renamed from: m */
    private Set<String> f5584m;

    /* renamed from: n */
    private ViewFlipper f5585n;

    /* renamed from: o */
    private CalendarHeaderView f5586o;

    /* renamed from: p */
    private CalendarDayGridView f5587p;

    /* renamed from: q */
    private CalendarDayGridView f5588q;

    public CalendarControl(Context context) {
        super(context);
        m5596a(context, (AttributeSet) null, 0);
    }

    public CalendarControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5596a(context, attributeSet, 0);
    }

    public CalendarControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5596a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5596a(Context context, AttributeSet attributeSet, int i) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C1359f.calendar_control, this, true);
        this.f5585n = (ViewFlipper) findViewById(C1358e.day_flipper);
        this.f5586o = (CalendarHeaderView) findViewById(C1358e.calendar_header);
        this.f5587p = (CalendarDayGridView) findViewById(C1358e.calendar_grid_first);
        this.f5588q = (CalendarDayGridView) findViewById(C1358e.calendar_grid_second);
        Calendar calendar = (Calendar) this.f5572a.clone();
        calendar.add(2, 1);
        this.f5588q.onDateChanged(calendar);
        this.f5586o.setOnDateChangeRequest(this);
        this.f5587p.setOnDateChangeRequest(this);
        this.f5588q.setOnDateChangeRequest(this);
        this.f5587p.setOnDateChosen(this);
        this.f5588q.setOnDateChosen(this);
        if (attributeSet == null) {
            this.f5573b = null;
            this.f5574c = null;
            this.f5575d = false;
            this.f5579h = false;
            this.f5581j = true;
            this.f5582k = true;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1361h.CalendarControl);
            this.f5573b = C1365l.m5594a(obtainStyledAttributes, C1361h.CalendarControl_minimumDate);
            this.f5574c = C1365l.m5594a(obtainStyledAttributes, C1361h.CalendarControl_maximumDate);
            m5597a(obtainStyledAttributes.getString(C1361h.CalendarControl_timeDefault));
            this.f5579h = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_allowNullDate, false);
            this.f5581j = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_allowViewBeforeMinimum, true);
            this.f5582k = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_allowViewPastMaximum, true);
        }
        this.f5586o.setAttributeSet(attributeSet);
        this.f5587p.setAttributeSet(attributeSet);
        this.f5588q.setAttributeSet(attributeSet);
    }

    /* renamed from: a */
    private void m5597a(String str) {
        if (C1364k.m5591b(str)) {
            String[] split = str.split(":");
            try {
                this.f5576e = Integer.parseInt(split[0]);
                if (split.length > 1) {
                    this.f5577f = Integer.parseInt(split[1]);
                }
                if (split.length > 2) {
                    this.f5578g = Integer.parseInt(split[2]);
                }
                this.f5575d = true;
            } catch (Exception e) {
                Log.d("CalendarControl", "Unable to parse timeDefault " + str);
            }
        }
    }

    public boolean areGridLinesVisible() {
        return this.f5587p.areGridLinesVisible();
    }

    public int getArrowBottomGradientColor() {
        return this.f5586o.getArrowBottomGradientColor();
    }

    public int getArrowOutlineColor() {
        return this.f5586o.getArrowOutlineColor();
    }

    public int getArrowTopGradientColor() {
        return this.f5586o.getArrowTopGradientColor();
    }

    public int getColor(CalendarZone calendarZone) {
        switch (C1366a.f5664a[calendarZone.ordinal()]) {
            case 1:
                return this.f5586o.getColor(calendarZone);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return this.f5587p.getColor(calendarZone);
            default:
                return -1;
        }
    }

    public Calendar getCurrentPage() {
        return this.f5572a;
    }

    public Calendar getMaximumDate() {
        return this.f5574c;
    }

    public Calendar getMinimumDate() {
        return this.f5573b;
    }

    public float getTextSize(CalendarText calendarText) {
        switch (C1366a.f5665b[calendarText.ordinal()]) {
            case 1:
                return this.f5586o.getTextSize(calendarText);
            case 2:
            case 3:
            case 4:
                return this.f5587p.getTextSize(calendarText);
            default:
                return -1.0f;
        }
    }

    public Drawable getZoneDrawable(CalendarZone calendarZone) {
        switch (C1366a.f5664a[calendarZone.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return this.f5587p.getZoneDrawable(calendarZone);
            case 8:
                return this.f5586o.getZoneDrawable(calendarZone);
            default:
                return null;
        }
    }

    public boolean isAllowViewBeforeMinimum() {
        return this.f5581j;
    }

    public boolean isAllowViewPastMaximum() {
        return this.f5582k;
    }

    public boolean isNullDateAllowed() {
        return this.f5579h;
    }

    public boolean isTodayHighlighted() {
        return this.f5587p.isTodayHighlighted();
    }

    public boolean isYearNavigationVisible() {
        return this.f5586o.isYearNavigationVisible();
    }

    public void onDateChangeRequest(int i, int i2) {
        Animation loadAnimation;
        Animation loadAnimation2;
        if (!(this.f5573b == null && this.f5574c == null)) {
            Calendar calendar = (Calendar) this.f5572a.clone();
            calendar.add(i, i2);
            calendar.set(5, calendar.getActualMaximum(5));
            if (this.f5573b == null || this.f5581j || !this.f5573b.after(calendar)) {
                calendar.set(5, 1);
                if (this.f5574c != null && !this.f5582k && this.f5574c.before(calendar)) {
                    return;
                }
            } else {
                return;
            }
        }
        if (i == 2) {
            if (i2 == 1) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), C1356c.push_left_in);
                loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C1356c.push_left_out);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), C1356c.push_right_in);
                loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C1356c.push_right_out);
            }
        } else if (i2 == 1) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C1356c.push_up_in);
            loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C1356c.push_up_out);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C1356c.push_down_in);
            loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C1356c.push_down_out);
        }
        this.f5572a.add(i, i2);
        this.f5586o.onDateChanged(this.f5572a);
        this.f5585n.setInAnimation(loadAnimation);
        this.f5585n.setOutAnimation(loadAnimation2);
        if (this.f5580i) {
            this.f5588q.onDateChanged(this.f5572a);
            this.f5585n.showNext();
        } else {
            this.f5587p.onDateChanged(this.f5572a);
            this.f5585n.showPrevious();
        }
        this.f5580i = !this.f5580i;
    }

    public void onDateChosen(Calendar calendar) {
        this.f5587p.setSelectedDate(calendar);
        this.f5588q.setSelectedDate(calendar);
        if (this.f5583l != null) {
            if (calendar != null && this.f5575d) {
                calendar.set(10, this.f5576e);
                calendar.set(12, this.f5577f);
                calendar.set(13, this.f5578g);
                calendar.set(14, 0);
            }
            this.f5583l.onDateChosen(calendar);
        }
    }

    public void setAllowViewBeforeMinimum(boolean z) {
        this.f5581j = z;
    }

    public void setAllowViewPastMaximum(boolean z) {
        this.f5582k = z;
    }

    public void setArrowColors(int i, int i2, int i3) {
        this.f5586o.setArrowColors(i, i2, i3);
    }

    public void setColor(CalendarZone calendarZone, int i) {
        switch (C1366a.f5664a[calendarZone.ordinal()]) {
            case 1:
                this.f5586o.setColor(calendarZone, i);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                this.f5587p.setColor(calendarZone, i);
                this.f5588q.setColor(calendarZone, i);
                return;
            default:
                return;
        }
    }

    public void setCurrentPage(Calendar calendar) {
        this.f5572a = (Calendar) calendar.clone();
        this.f5587p.onDateChanged(this.f5572a);
        this.f5588q.onDateChanged(this.f5572a);
        this.f5586o.onDateChanged(this.f5572a);
    }

    public void setGridLinesVisible(boolean z) {
        this.f5587p.setGridLinesVisible(z);
        this.f5588q.setGridLinesVisible(z);
    }

    public void setMaximumDate(Calendar calendar) {
        if (calendar == null) {
            this.f5574c = null;
        } else {
            this.f5574c = (Calendar) calendar.clone();
            C1348a.m5556b(this.f5574c);
        }
        this.f5587p.setMaximumDate(this.f5574c);
        this.f5588q.setMaximumDate(this.f5574c);
    }

    public void setMinimumDate(Calendar calendar) {
        if (calendar == null) {
            this.f5573b = null;
        } else {
            this.f5573b = (Calendar) calendar.clone();
            C1348a.m5553a(this.f5573b);
        }
        this.f5587p.setMinimumDate(this.f5573b);
        this.f5588q.setMinimumDate(this.f5573b);
    }

    public void setNullDateAllowed(boolean z) {
        this.f5579h = z;
    }

    public void setOnDateChosen(OnDateChosen onDateChosen) {
        this.f5583l = onDateChosen;
    }

    public void setSelectedDate(Calendar calendar) {
        this.f5587p.setSelectedDate(calendar);
        this.f5588q.setSelectedDate(calendar);
        if (calendar != null) {
            this.f5572a = (Calendar) calendar.clone();
            this.f5587p.onDateChanged(calendar);
            this.f5588q.onDateChanged(calendar);
            this.f5586o.onDateChanged(calendar);
        }
    }

    public void setTextShadow(CalendarText calendarText, float f, float f2, float f3, int i) {
        switch (C1366a.f5665b[calendarText.ordinal()]) {
            case 1:
                this.f5586o.setTextShadow(calendarText, f, f2, f3, i);
                return;
            case 2:
            case 3:
            case 4:
                this.f5587p.setTextShadow(calendarText, f, f2, f3, i);
                this.f5588q.setTextShadow(calendarText, f, f2, f3, i);
                return;
            default:
                return;
        }
    }

    public void setTextSize(CalendarText calendarText, float f) {
        switch (C1366a.f5665b[calendarText.ordinal()]) {
            case 1:
                this.f5586o.setTextSize(calendarText, f);
                return;
            case 2:
            case 3:
            case 4:
                this.f5587p.setTextSize(calendarText, f);
                this.f5588q.setTextSize(calendarText, f);
                return;
            default:
                return;
        }
    }

    public void setTodayHighlighted(boolean z) {
        this.f5587p.setTodayHighlighted(z);
        this.f5588q.setTodayHighlighted(z);
    }

    public void setValidDates(List<Calendar> list) {
        if (list != null) {
            this.f5584m = new HashSet(list.size());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            for (Calendar time : list) {
                this.f5584m.add(simpleDateFormat.format(time.getTime()));
            }
            this.f5587p.setValidDates(this.f5584m);
            this.f5588q.setValidDates(this.f5584m);
            if (this.f5587p.getSelectedDate() == null && !list.isEmpty()) {
                this.f5572a = (Calendar) list.get(0).clone();
                this.f5587p.onDateChanged(this.f5572a);
                this.f5588q.onDateChanged(this.f5572a);
                this.f5586o.onDateChanged(this.f5572a);
            }
        }
    }

    public void setYearNavigationVisible(boolean z) {
        this.f5586o.setYearNavigationVisible(z);
    }

    public void setZoneDrawable(CalendarZone calendarZone, Drawable drawable) {
        switch (C1366a.f5664a[calendarZone.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.f5587p.setZoneDrawable(calendarZone, drawable);
                this.f5588q.setZoneDrawable(calendarZone, drawable);
                return;
            case 8:
                this.f5586o.setZoneDrawable(calendarZone, drawable);
                return;
            default:
                return;
        }
    }
}
