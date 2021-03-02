package com.jackhenry.android.widget.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.jackhenry.android.p022a.C1348a;
import com.jackhenry.android.p022a.C1357d;
import com.jackhenry.android.p022a.C1361h;
import com.jackhenry.android.p022a.C1365l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CalendarDayGridView extends View implements GestureDetector.OnGestureListener, OnDateChanged, OnDateChosen {

    /* renamed from: e */
    private static final int f5589e = Color.parseColor("#B3B3B3");

    /* renamed from: f */
    private static final int f5590f = Color.parseColor("#C4C4C4");

    /* renamed from: A */
    private Drawable f5591A;

    /* renamed from: B */
    private Drawable f5592B;

    /* renamed from: C */
    private Drawable f5593C;

    /* renamed from: D */
    private Drawable f5594D;

    /* renamed from: E */
    private Drawable f5595E;

    /* renamed from: F */
    private Drawable f5596F;

    /* renamed from: G */
    private boolean f5597G;

    /* renamed from: H */
    private boolean f5598H;

    /* renamed from: I */
    private boolean f5599I;

    /* renamed from: J */
    private Set<String> f5600J;

    /* renamed from: K */
    private SimpleDateFormat f5601K = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* renamed from: a */
    private Calendar f5602a = Calendar.getInstance();

    /* renamed from: b */
    private Calendar f5603b;

    /* renamed from: c */
    private Calendar f5604c;

    /* renamed from: d */
    private Calendar f5605d;

    /* renamed from: g */
    private int f5606g = -1;

    /* renamed from: h */
    private int f5607h = -1;

    /* renamed from: i */
    private int f5608i;

    /* renamed from: j */
    private boolean f5609j;

    /* renamed from: k */
    private boolean f5610k;

    /* renamed from: l */
    private boolean f5611l;

    /* renamed from: m */
    private Paint f5612m = new Paint();

    /* renamed from: n */
    private Paint f5613n = new Paint();

    /* renamed from: o */
    private Paint f5614o = new Paint();

    /* renamed from: p */
    private Paint f5615p = new Paint();

    /* renamed from: q */
    private Paint f5616q = new Paint();

    /* renamed from: r */
    private Paint f5617r = new Paint();

    /* renamed from: s */
    private int f5618s;

    /* renamed from: t */
    private Rect f5619t = new Rect();

    /* renamed from: u */
    private float f5620u;

    /* renamed from: v */
    private List<C1368c> f5621v = new ArrayList(42);

    /* renamed from: w */
    private GestureDetector f5622w;

    /* renamed from: x */
    private OnDateChangeRequest f5623x;

    /* renamed from: y */
    private OnDateChosen f5624y;

    /* renamed from: z */
    private Drawable f5625z;

    public CalendarDayGridView(Context context) {
        super(context);
        m5600a(context, (AttributeSet) null, 0);
    }

    public CalendarDayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5600a(context, attributeSet, 0);
    }

    public CalendarDayGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5600a(context, attributeSet, i);
    }

    /* renamed from: a */
    private Calendar m5598a(int i, int i2) {
        Calendar calendar = null;
        for (C1368c next : this.f5621v) {
            if (next.f5669a.contains(i, i2)) {
                calendar = (Calendar) this.f5602a.clone();
                if (next.f5672d == C1369d.DiffMonth) {
                    this.f5605d = null;
                    calendar = null;
                } else {
                    if (next.f5671c.length() == 0) {
                        m5602b();
                    }
                    calendar.set(5, Integer.parseInt(next.f5671c));
                    if (m5601a(calendar)) {
                        this.f5605d = calendar;
                    } else {
                        this.f5605d = null;
                        calendar = null;
                    }
                }
            }
        }
        return calendar;
    }

    /* renamed from: a */
    private void m5599a() {
        this.f5612m.getTextBounds("99", 0, 2, this.f5619t);
        int i = this.f5607h / 7;
        int i2 = this.f5606g / 6;
        int i3 = this.f5607h - (i * 7);
        int i4 = this.f5606g - (i2 * 6);
        this.f5618s = (i2 / 2) - (this.f5619t.height() / 2);
        int i5 = 0;
        int i6 = 0;
        while (i5 < 6) {
            int i7 = 0;
            int i8 = 0;
            while (i7 < 7) {
                C1368c cVar = this.f5621v.get((i5 * 7) + i7);
                cVar.f5669a = new Rect(i8, i6, i8 + i + (i3 > 0 ? 1 : 0), (i4 > 0 ? 1 : 0) + i6 + i2);
                cVar.f5671c = "";
                i8 += (i3 > 0 ? 1 : 0) + i;
                i7++;
                i3 = i3 > 0 ? i3 - 1 : i3;
            }
            int i9 = this.f5607h - (i * 7);
            i5++;
            i6 += (i4 > 0 ? 1 : 0) + i2;
            i4 = i4 > 0 ? i4 - 1 : i4;
            i3 = i9;
        }
        C1368c cVar2 = this.f5621v.get(0);
        this.f5620u = (float) ((cVar2.f5669a.height() > cVar2.f5669a.width() ? cVar2.f5669a.width() / 2 : cVar2.f5669a.height() / 2) - 5);
    }

    /* renamed from: a */
    private void m5600a(Context context, AttributeSet attributeSet, int i) {
        this.f5622w = new GestureDetector(context, this);
        for (int i2 = 0; i2 < 42; i2++) {
            this.f5621v.add(new C1368c(this));
        }
        setAttributeSet(attributeSet);
    }

    /* renamed from: a */
    private boolean m5601a(Calendar calendar) {
        if (this.f5603b != null && calendar.before(this.f5603b)) {
            return false;
        }
        if (this.f5604c != null && calendar.after(this.f5604c)) {
            return false;
        }
        if (!this.f5611l && (calendar.get(7) == 7 || calendar.get(7) == 1)) {
            return false;
        }
        if (this.f5600J != null) {
            return this.f5600J.contains(this.f5601K.format(calendar.getTime()));
        }
        return true;
    }

    /* renamed from: b */
    private void m5602b() {
        int i = this.f5602a.get(2);
        Calendar calendar = (Calendar) this.f5602a.clone();
        calendar.set(5, 1);
        calendar.set(5, -((calendar.get(7) - 1) - 1));
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 7; i3++) {
                C1368c cVar = this.f5621v.get((i2 * 7) + i3);
                cVar.f5671c = Integer.toString(calendar.get(5));
                if (calendar.get(2) != i) {
                    cVar.f5672d = C1369d.DiffMonth;
                } else if (!m5601a(calendar)) {
                    cVar.f5672d = C1369d.NotSelectable;
                } else if (calendar.get(7) == 7 || calendar.get(7) == 1) {
                    cVar.f5672d = C1369d.Weekend;
                } else {
                    cVar.f5672d = C1369d.Normal;
                }
                cVar.f5670b = (Calendar) calendar.clone();
                calendar.add(5, 1);
            }
        }
    }

    public boolean areGridLinesVisible() {
        return this.f5609j;
    }

    public int getColor(CalendarZone calendarZone) {
        switch (calendarZone) {
            case day:
                return this.f5612m.getColor();
            case dayDiffMonth:
                return this.f5615p.getColor();
            case dayNoSelectText:
                return this.f5614o.getColor();
            case dayWeekendText:
                return this.f5613n.getColor();
            case gridLine:
                return this.f5616q.getColor();
            case selectedDay:
                return this.f5617r.getColor();
            default:
                return -1;
        }
    }

    public Calendar getMaximumDate() {
        return this.f5604c;
    }

    public Calendar getMinimumDate() {
        return this.f5603b;
    }

    public Calendar getSelectedDate() {
        return this.f5605d;
    }

    public float getTextSize(CalendarText calendarText) {
        switch (calendarText) {
            case day:
                return this.f5612m.getTextSize();
            case dayDiffMonth:
                return this.f5615p.getTextSize();
            case dayNoSelectText:
                return this.f5614o.getTextSize();
            case dayWeekendText:
                return this.f5613n.getTextSize();
            default:
                return -1.0f;
        }
    }

    public Drawable getZoneDrawable(CalendarZone calendarZone) {
        switch (calendarZone) {
            case day:
                return this.f5625z;
            case dayDiffMonth:
                return this.f5592B;
            case dayNoSelectText:
                return this.f5593C;
            case dayWeekendText:
                return this.f5591A;
            case selectedDay:
                return this.f5594D;
            default:
                return null;
        }
    }

    public boolean isTodayHighlighted() {
        return this.f5610k;
    }

    public boolean isWeekendSelectable() {
        return this.f5611l;
    }

    public void onDateChanged(Calendar calendar) {
        this.f5602a = (Calendar) calendar.clone();
        m5602b();
        invalidate();
    }

    public void onDateChosen(Calendar calendar) {
        this.f5605d = calendar;
        invalidate();
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        boolean z;
        super.onDraw(canvas);
        if (!(this.f5606g == getHeight() && this.f5607h == getWidth())) {
            this.f5606g = getHeight();
            this.f5607h = getWidth();
            m5599a();
            m5602b();
        }
        Calendar instance = Calendar.getInstance();
        for (C1368c next : this.f5621v) {
            switch (next.f5672d) {
                case DiffMonth:
                    this.f5592B.setBounds(next.f5669a);
                    this.f5592B.draw(canvas);
                    break;
                case Normal:
                    this.f5625z.setBounds(next.f5669a);
                    this.f5625z.draw(canvas);
                    break;
                case NotSelectable:
                    this.f5593C.setBounds(next.f5669a);
                    this.f5593C.draw(canvas);
                    break;
                case Weekend:
                    if (!this.f5611l) {
                        this.f5591A.setBounds(next.f5669a);
                        this.f5591A.draw(canvas);
                        break;
                    } else {
                        this.f5625z.setBounds(next.f5669a);
                        this.f5625z.draw(canvas);
                        break;
                    }
            }
            boolean a = C1348a.m5555a(next.f5670b, this.f5605d);
            boolean z2 = C1348a.m5555a(instance, next.f5670b) && this.f5610k;
            if (a || z2) {
                if (z2 && a) {
                    drawable = this.f5596F;
                    z = this.f5599I;
                } else if (z2) {
                    drawable = this.f5595E;
                    z = this.f5598H;
                } else {
                    drawable = this.f5594D;
                    z = this.f5597G;
                }
                if (z) {
                    drawable.setBounds(((int) next.f5669a.exactCenterX()) - ((int) this.f5620u), ((int) next.f5669a.exactCenterY()) - ((int) this.f5620u), ((int) next.f5669a.exactCenterX()) + ((int) this.f5620u), ((int) next.f5669a.exactCenterY()) + ((int) this.f5620u));
                } else {
                    drawable.setBounds(next.f5669a);
                }
                drawable.draw(canvas);
            }
            switch (next.f5672d) {
                case DiffMonth:
                    this.f5615p.getTextBounds(next.f5671c, 0, next.f5671c.length(), this.f5619t);
                    canvas.drawText(next.f5671c, (float) next.f5669a.centerX(), (float) (next.f5669a.bottom - this.f5618s), this.f5615p);
                    break;
                case Normal:
                    this.f5612m.getTextBounds(next.f5671c, 0, next.f5671c.length(), this.f5619t);
                    canvas.drawText(next.f5671c, (float) next.f5669a.centerX(), (float) (next.f5669a.bottom - this.f5618s), a ? this.f5617r : this.f5612m);
                    break;
                case NotSelectable:
                    this.f5614o.getTextBounds(next.f5671c, 0, next.f5671c.length(), this.f5619t);
                    canvas.drawText(next.f5671c, (float) next.f5669a.centerX(), (float) (next.f5669a.bottom - this.f5618s), this.f5614o);
                    break;
                case Weekend:
                    this.f5613n.getTextBounds(next.f5671c, 0, next.f5671c.length(), this.f5619t);
                    canvas.drawText(next.f5671c, (float) next.f5669a.centerX(), (float) (next.f5669a.bottom - this.f5618s), this.f5613n);
                    break;
            }
            if (this.f5609j) {
                canvas.drawRect(next.f5669a, this.f5616q);
            }
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.f5623x != null) {
            float x = motionEvent.getX() - motionEvent2.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            if (Math.abs(x) > Math.abs(y)) {
                OnDateChangeRequest onDateChangeRequest = this.f5623x;
                if (x >= BitmapDescriptorFactory.HUE_RED) {
                    i = 1;
                }
                onDateChangeRequest.onDateChangeRequest(2, i);
            } else {
                OnDateChangeRequest onDateChangeRequest2 = this.f5623x;
                if (y >= BitmapDescriptorFactory.HUE_RED) {
                    i = 1;
                }
                onDateChangeRequest2.onDateChangeRequest(1, i);
            }
        }
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if ((i & 1073741824) == 1073741824 && (i2 & Integer.MIN_VALUE) == Integer.MIN_VALUE && size <= size2) {
            i3 = size;
        } else {
            this.f5607h = size;
            this.f5606g = size2;
            m5599a();
            i3 = this.f5621v.get(40).f5669a.bottom;
            this.f5607h = -1;
            this.f5606g = -1;
        }
        setMeasuredDimension(size, i3);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
        if (m5598a((int) motionEvent.getX(), (int) motionEvent.getY()) != null && this.f5624y != null) {
            invalidate();
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Calendar a = m5598a((int) motionEvent.getX(), (int) motionEvent.getY());
        if (a == null || this.f5624y == null) {
            return true;
        }
        invalidate();
        this.f5624y.onDateChosen(a);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5622w.onTouchEvent(motionEvent);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        float f = getContext().getResources().getDisplayMetrics().density;
        if (attributeSet == null) {
            this.f5594D = getContext().getResources().getDrawable(C1357d.selected);
            this.f5595E = getContext().getResources().getDrawable(C1357d.today);
            this.f5596F = getContext().getResources().getDrawable(C1357d.today_selected);
            this.f5597G = false;
            this.f5598H = false;
            this.f5599I = false;
            this.f5610k = false;
            this.f5625z = getContext().getResources().getDrawable(C1357d.selectable_day);
            this.f5612m.setTextSize((16.0f * f) + 0.5f);
            this.f5612m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5612m.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f5617r.setTextSize((16.0f * f) + 0.5f);
            this.f5617r.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5617r.setColor(-1);
            this.f5593C = getContext().getResources().getDrawable(C1357d.no_select_day);
            this.f5614o.setTextSize((16.0f * f) + 0.5f);
            this.f5614o.setColor(-12303292);
            this.f5614o.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5592B = getContext().getResources().getDrawable(C1357d.diff_month_day);
            this.f5615p.setTextSize((16.0f * f) + 0.5f);
            this.f5615p.setColor(f5589e);
            this.f5615p.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5591A = getContext().getResources().getDrawable(C1357d.weekend_day);
            this.f5613n.setTextSize((16.0f * f) + 0.5f);
            this.f5613n.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f5608i = f5590f;
            this.f5603b = null;
            this.f5604c = null;
            this.f5609j = true;
            this.f5611l = true;
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1361h.CalendarControl);
            C1365l.m5595a(obtainStyledAttributes, this.f5612m, C1361h.CalendarControl_dayShadowRadius, C1361h.CalendarControl_dayShadowDx, C1361h.CalendarControl_dayShadowDy, C1361h.CalendarControl_dayShadowColor);
            C1365l.m5595a(obtainStyledAttributes, this.f5614o, C1361h.CalendarControl_dayNoSelectShadowRadius, C1361h.CalendarControl_dayNoSelectShadowDx, C1361h.CalendarControl_dayNoSelectShadowDy, C1361h.CalendarControl_dayNoSelectShadowColor);
            C1365l.m5595a(obtainStyledAttributes, this.f5613n, C1361h.CalendarControl_dayWeekendShadowRadius, C1361h.CalendarControl_dayWeekendShadowDx, C1361h.CalendarControl_dayWeekendShadowDy, C1361h.CalendarControl_dayWeekendShadowColor);
            C1365l.m5595a(obtainStyledAttributes, this.f5615p, C1361h.CalendarControl_dayDiffMonthShadowRadius, C1361h.CalendarControl_dayDiffMonthShadowDx, C1361h.CalendarControl_dayDiffMonthShadowDy, C1361h.CalendarControl_dayDiffMonthShadowColor);
            C1365l.m5595a(obtainStyledAttributes, this.f5617r, C1361h.CalendarControl_selectedShadowRadius, C1361h.CalendarControl_selectedShadowDx, C1361h.CalendarControl_selectedShadowDy, C1361h.CalendarControl_selectedShadowColor);
            this.f5603b = C1365l.m5594a(obtainStyledAttributes, C1361h.CalendarControl_minimumDate);
            this.f5604c = C1365l.m5594a(obtainStyledAttributes, C1361h.CalendarControl_maximumDate);
            this.f5594D = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_selectedDrawable, C1357d.selected));
            this.f5595E = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_todayDrawable, C1357d.today));
            this.f5596F = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_todaySelectedDrawable, C1357d.today_selected));
            this.f5597G = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_selectedDrawableKeepSquare, false);
            this.f5598H = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_todayDrawableKeepSquare, false);
            this.f5599I = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_todaySelectedDrawableKeepSquare, false);
            this.f5625z = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_dayDrawable, C1357d.selectable_day));
            this.f5612m.setTextSize(obtainStyledAttributes.getFloat(C1361h.CalendarControl_dayTextSize, (16.0f * f) + 0.5f));
            this.f5612m.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_dayTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f5617r.setTextSize(obtainStyledAttributes.getFloat(C1361h.CalendarControl_selectedTextSize, (16.0f * f) + 0.5f));
            this.f5617r.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_selectedTextColor, -1));
            this.f5593C = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_dayNoSelectDrawable, C1357d.no_select_day));
            this.f5614o.setTextSize(obtainStyledAttributes.getFloat(C1361h.CalendarControl_dayNoSelectTextSize, (16.0f * f) + 0.5f));
            this.f5614o.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_dayNoSelectTextColor, -12303292));
            this.f5592B = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_dayDiffMonthDrawable, C1357d.diff_month_day));
            this.f5615p.setTextSize(obtainStyledAttributes.getFloat(C1361h.CalendarControl_dayDiffMonthTextSize, (16.0f * f) + 0.5f));
            this.f5615p.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_dayDiffMonthTextColor, f5589e));
            this.f5591A = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_dayDiffMonthDrawable, C1357d.weekend_day));
            this.f5613n.setTextSize(obtainStyledAttributes.getFloat(C1361h.CalendarControl_dayWeekendTextSize, (16.0f * f) + 0.5f));
            this.f5613n.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_dayWeekendTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f5608i = obtainStyledAttributes.getColor(C1361h.CalendarControl_gridLineColor, f5590f);
            this.f5609j = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_gridLinesVisible, true);
            this.f5610k = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_todayHighlighted, false);
            this.f5611l = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_weekendSelectable, true);
        }
        this.f5612m.setAntiAlias(true);
        this.f5612m.setTextAlign(Paint.Align.CENTER);
        this.f5612m.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5617r.setAntiAlias(true);
        this.f5617r.setTextAlign(Paint.Align.CENTER);
        this.f5617r.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5614o.setAntiAlias(true);
        this.f5614o.setTextAlign(Paint.Align.CENTER);
        this.f5614o.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5615p.setAntiAlias(true);
        this.f5615p.setTextAlign(Paint.Align.CENTER);
        this.f5615p.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5613n.setAntiAlias(true);
        this.f5613n.setTextAlign(Paint.Align.CENTER);
        this.f5613n.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5616q.setColor(this.f5608i);
        this.f5616q.setStrokeWidth(1.0f);
        this.f5616q.setAntiAlias(true);
        this.f5616q.setStyle(Paint.Style.STROKE);
    }

    public void setColor(CalendarZone calendarZone, int i) {
        switch (calendarZone) {
            case day:
                this.f5612m.setColor(i);
                return;
            case dayDiffMonth:
                this.f5615p.setColor(i);
                return;
            case dayNoSelectText:
                this.f5614o.setColor(i);
                return;
            case dayWeekendText:
                this.f5613n.setColor(i);
                return;
            case gridLine:
                this.f5616q.setColor(i);
                return;
            case selectedDay:
                this.f5617r.setColor(i);
                return;
            default:
                return;
        }
    }

    public void setGridLinesVisible(boolean z) {
        this.f5609j = z;
    }

    public void setMaximumDate(Calendar calendar) {
        if (calendar == null) {
            this.f5604c = calendar;
            return;
        }
        this.f5604c = (Calendar) calendar.clone();
        C1348a.m5553a(this.f5604c);
    }

    public void setMinimumDate(Calendar calendar) {
        if (calendar == null) {
            this.f5603b = null;
            return;
        }
        this.f5603b = (Calendar) calendar.clone();
        C1348a.m5553a(this.f5603b);
    }

    public void setOnDateChangeRequest(OnDateChangeRequest onDateChangeRequest) {
        this.f5623x = onDateChangeRequest;
    }

    public void setOnDateChosen(OnDateChosen onDateChosen) {
        this.f5624y = onDateChosen;
    }

    public void setSelectedDate(Calendar calendar) {
        this.f5605d = calendar;
        invalidate();
    }

    public void setTextShadow(CalendarText calendarText, float f, float f2, float f3, int i) {
        switch (calendarText) {
            case day:
                this.f5612m.setShadowLayer(f3, f, f2, i);
                return;
            case dayDiffMonth:
                this.f5615p.setShadowLayer(f3, f, f2, i);
                return;
            case dayNoSelectText:
                this.f5614o.setShadowLayer(f3, f, f2, i);
                return;
            case dayWeekendText:
                this.f5613n.setShadowLayer(f3, f, f2, i);
                return;
            case selected:
                this.f5617r.setShadowLayer(f3, f, f2, i);
                return;
            default:
                return;
        }
    }

    public void setTextSize(CalendarText calendarText, float f) {
        float f2 = getContext().getResources().getDisplayMetrics().density;
        switch (calendarText) {
            case day:
                this.f5612m.setTextSize((f2 * f) + 0.5f);
                return;
            case dayDiffMonth:
                this.f5615p.setTextSize((f2 * f) + 0.5f);
                return;
            case dayNoSelectText:
                this.f5614o.setTextSize((f2 * f) + 0.5f);
                return;
            case dayWeekendText:
                this.f5613n.setTextSize((f2 * f) + 0.5f);
                return;
            default:
                return;
        }
    }

    public void setTodayHighlighted(boolean z) {
        this.f5610k = z;
    }

    public void setValidDates(Set<String> set) {
        this.f5600J = set;
    }

    public void setWeekendSelectable(boolean z) {
        this.f5611l = z;
    }

    public void setZoneDrawable(CalendarZone calendarZone, Drawable drawable) {
        switch (calendarZone) {
            case day:
                this.f5625z = drawable;
                break;
            case dayDiffMonth:
                this.f5592B = drawable;
                break;
            case dayNoSelectText:
                this.f5593C = drawable;
                break;
            case dayWeekendText:
                this.f5591A = drawable;
                break;
            case selectedDay:
                this.f5625z = drawable;
                break;
        }
        m5599a();
        this.f5607h = -1;
        this.f5606g = -1;
    }
}
