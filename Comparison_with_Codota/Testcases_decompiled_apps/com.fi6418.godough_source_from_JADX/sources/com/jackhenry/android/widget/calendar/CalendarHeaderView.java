package com.jackhenry.android.widget.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.jackhenry.android.p022a.C1357d;
import com.jackhenry.android.p022a.C1361h;
import com.jackhenry.android.p022a.C1365l;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CalendarHeaderView extends View implements GestureDetector.OnGestureListener, OnDateChanged {

    /* renamed from: a */
    private static final int f5626a = Color.parseColor("#43ABD2");

    /* renamed from: b */
    private static final int f5627b = Color.parseColor("#43ABD2");

    /* renamed from: c */
    private static final int f5628c = Color.parseColor("#464646");

    /* renamed from: A */
    private Rect f5629A;

    /* renamed from: B */
    private Rect f5630B;

    /* renamed from: C */
    private Rect f5631C;

    /* renamed from: D */
    private Rect f5632D;

    /* renamed from: E */
    private List<Rect> f5633E = new ArrayList(7);

    /* renamed from: F */
    private String f5634F;

    /* renamed from: G */
    private int f5635G;

    /* renamed from: H */
    private GestureDetector f5636H;

    /* renamed from: I */
    private OnDateChangeRequest f5637I;

    /* renamed from: J */
    private Context f5638J;

    /* renamed from: d */
    private int f5639d = -1;

    /* renamed from: e */
    private int f5640e = -1;

    /* renamed from: f */
    private Calendar f5641f = Calendar.getInstance();

    /* renamed from: g */
    private TimeZone f5642g = TimeZone.getDefault();

    /* renamed from: h */
    private String[] f5643h;

    /* renamed from: i */
    private String[] f5644i;

    /* renamed from: j */
    private Rect f5645j = new Rect();

    /* renamed from: k */
    private Path f5646k = new Path();

    /* renamed from: l */
    private Path f5647l = new Path();

    /* renamed from: m */
    private Path f5648m = new Path();

    /* renamed from: n */
    private Path f5649n = new Path();

    /* renamed from: o */
    private Drawable f5650o;

    /* renamed from: p */
    private int f5651p;

    /* renamed from: q */
    private int f5652q;

    /* renamed from: r */
    private int f5653r;

    /* renamed from: s */
    private Paint f5654s = new Paint();

    /* renamed from: t */
    private Paint f5655t = new Paint();

    /* renamed from: u */
    private Paint f5656u = new Paint();

    /* renamed from: v */
    private Paint f5657v = new Paint();

    /* renamed from: w */
    private boolean f5658w;

    /* renamed from: x */
    private int f5659x;

    /* renamed from: y */
    private Rect f5660y;

    /* renamed from: z */
    private Rect f5661z;

    public CalendarHeaderView(Context context) {
        super(context);
        m5604a(context, (AttributeSet) null, 0);
    }

    public CalendarHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5604a(context, attributeSet, 0);
    }

    public CalendarHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5604a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5603a() {
        int i;
        this.f5654s.getTextBounds("Fy", 0, 1, this.f5645j);
        int i2 = (this.f5645j.bottom - this.f5645j.top) + 10;
        int applyDimension = (int) TypedValue.applyDimension(1, 36.0f, getResources().getDisplayMetrics());
        if (i2 < applyDimension) {
            i = applyDimension - i2;
            i2 = Math.max(i2, applyDimension);
        } else {
            i = 0;
        }
        this.f5660y = new Rect(0, 0, this.f5640e, i2 + 4);
        this.f5655t.getTextBounds("Ay", 0, 2, this.f5645j);
        this.f5661z = new Rect(0, this.f5660y.bottom, this.f5640e, this.f5660y.bottom + (this.f5645j.bottom - this.f5645j.top) + 4);
        this.f5659x = (this.f5660y.bottom - 8) - (i / 2);
        int i3 = this.f5640e / 7;
        int i4 = this.f5640e - (i3 * 7);
        this.f5633E.clear();
        int i5 = 0;
        for (int i6 = 0; i6 < 7; i6++) {
            this.f5633E.add(new Rect(i5, this.f5661z.top, i5 + i3, this.f5661z.bottom));
            i5 += (i4 > 0 ? 1 : 0) + i3;
            if (i4 > 0) {
                i4--;
            }
        }
        int i7 = i2 - 6;
        int i8 = i7 / 2;
        int i9 = i7 / 4;
        if (this.f5658w) {
            this.f5648m.reset();
            this.f5648m.moveTo(3.0f, (float) (i8 + 3));
            this.f5648m.lineTo((float) (i8 + 3 + (i9 / 2)), 3.0f);
            this.f5648m.lineTo((float) (i8 + 3 + (i9 / 2)), (float) (i9 + 3));
            this.f5648m.lineTo((float) (i7 + 3), 3.0f);
            this.f5648m.lineTo((float) (i7 + 3), (float) (i7 + 3));
            this.f5648m.lineTo((float) (i8 + 3 + (i9 / 2)), (float) ((i7 + 3) - i9));
            this.f5648m.lineTo((float) (i8 + 3 + (i9 / 2)), (float) (i7 + 3));
            this.f5648m.lineTo(3.0f, (float) (i8 + 3));
            this.f5646k.reset();
            this.f5646k.moveTo((float) (this.f5660y.right - i2), 3.0f);
            this.f5646k.lineTo((float) (((this.f5660y.right - i2) + i8) - (i9 / 2)), (float) (i9 + 3));
            this.f5646k.lineTo((float) (((this.f5660y.right - i2) + i8) - (i9 / 2)), 3.0f);
            this.f5646k.lineTo((float) ((this.f5660y.right - i2) + i7), (float) (i8 + 3));
            this.f5646k.lineTo((float) (((this.f5660y.right - i2) + i8) - (i9 / 2)), (float) (i7 + 3));
            this.f5646k.lineTo((float) ((i8 + (this.f5660y.right - i2)) - (i9 / 2)), (float) ((i7 + 3) - i9));
            this.f5646k.lineTo((float) (this.f5660y.right - i2), (float) (i7 + 3));
            this.f5646k.lineTo((float) (this.f5660y.right - i2), 3.0f);
            this.f5632D = new Rect(3, 0, i2 + 3, i2);
            this.f5631C = new Rect((this.f5660y.right - i2) - 3, 0, this.f5660y.right - 3, i2);
        } else {
            this.f5632D = new Rect(0, 0, 0, i2);
            this.f5631C = new Rect(this.f5660y.right - 3, 0, this.f5660y.right - 3, i2);
        }
        this.f5649n.reset();
        Rect rect = new Rect(this.f5632D.right + 5, 10, this.f5632D.right + i2, i2 - 10);
        int i10 = rect.bottom - rect.top;
        rect.right = rect.left + i10;
        int i11 = rect.top + (i10 / 2);
        this.f5649n.moveTo((float) rect.left, (float) i11);
        this.f5649n.lineTo((float) (rect.left + i11), (float) rect.top);
        this.f5649n.lineTo((float) (rect.left + i11), (float) rect.bottom);
        this.f5649n.lineTo((float) rect.left, (float) i11);
        Rect rect2 = new Rect(this.f5660y.right - i10, 10, this.f5660y.right - 5, i2 - 10);
        this.f5647l.reset();
        this.f5647l.moveTo((float) (rect2.right - i11), (float) rect2.top);
        this.f5647l.lineTo((float) rect2.right, (float) i11);
        this.f5647l.lineTo((float) (rect2.right - i11), (float) rect2.bottom);
        this.f5647l.lineTo((float) (rect2.right - i11), (float) rect2.top);
        this.f5630B = new Rect(this.f5632D.right + 5, 0, this.f5632D.right + i2, i2);
        this.f5629A = new Rect((this.f5631C.left - 5) - i2, 0, this.f5631C.left - 5, i2);
        m5605b();
    }

    /* renamed from: a */
    private void m5604a(Context context, AttributeSet attributeSet, int i) {
        this.f5638J = context;
        this.f5636H = new GestureDetector(context, this);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        this.f5643h = dateFormatSymbols.getShortWeekdays();
        this.f5644i = dateFormatSymbols.getMonths();
        setAttributeSet(attributeSet);
    }

    /* renamed from: b */
    private void m5605b() {
        this.f5656u.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f5660y.height(), this.f5652q, this.f5653r, Shader.TileMode.MIRROR));
    }

    /* renamed from: c */
    private void m5606c() {
        Calendar newTimeZoneCalendar = this.f5641f == null ? getNewTimeZoneCalendar() : this.f5641f;
        this.f5634F = this.f5644i[newTimeZoneCalendar.get(2)] + " " + newTimeZoneCalendar.get(1);
        this.f5654s.getTextBounds(this.f5634F, 0, this.f5634F.length(), this.f5645j);
        this.f5635G = (this.f5660y.right / 2) - (this.f5645j.width() / 2);
    }

    private Calendar getNewTimeZoneCalendar() {
        return Calendar.getInstance(this.f5642g);
    }

    public int getArrowBottomGradientColor() {
        return this.f5653r;
    }

    public int getArrowOutlineColor() {
        return this.f5651p;
    }

    public int getArrowTopGradientColor() {
        return this.f5652q;
    }

    public int getColor(CalendarZone calendarZone) {
        if (calendarZone == CalendarZone.date) {
            return this.f5654s.getColor();
        }
        if (calendarZone == CalendarZone.dow) {
            return this.f5655t.getColor();
        }
        return -1;
    }

    public float getTextSize(CalendarText calendarText) {
        if (calendarText == CalendarText.date) {
            return this.f5654s.getTextSize();
        }
        if (calendarText == CalendarText.dow) {
            return this.f5655t.getTextSize();
        }
        return -1.0f;
    }

    public Drawable getZoneDrawable(CalendarZone calendarZone) {
        switch (C1370e.f5679a[calendarZone.ordinal()]) {
            case 1:
                return this.f5650o;
            default:
                return null;
        }
    }

    public boolean isYearNavigationVisible() {
        return this.f5658w;
    }

    public void onDateChanged(Calendar calendar) {
        this.f5641f = (Calendar) calendar.clone();
        m5606c();
        invalidate();
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!(this.f5639d == getHeight() && this.f5640e == getWidth())) {
            this.f5639d = getHeight();
            this.f5640e = getWidth();
            m5603a();
            m5606c();
        }
        this.f5650o.setBounds(0, 0, getWidth(), getHeight());
        this.f5650o.draw(canvas);
        if (this.f5658w) {
            canvas.drawPath(this.f5648m, this.f5656u);
            canvas.drawPath(this.f5648m, this.f5657v);
            canvas.drawPath(this.f5646k, this.f5656u);
            canvas.drawPath(this.f5646k, this.f5657v);
        }
        canvas.drawPath(this.f5649n, this.f5656u);
        canvas.drawPath(this.f5649n, this.f5657v);
        canvas.drawPath(this.f5647l, this.f5656u);
        canvas.drawPath(this.f5647l, this.f5657v);
        canvas.drawText(this.f5634F, (float) this.f5635G, (float) this.f5659x, this.f5654s);
        for (int i = 0; i < 7; i++) {
            String str = this.f5643h[i + 1];
            this.f5655t.getTextBounds(str, 0, str.length(), this.f5645j);
            canvas.drawText(str, (float) (((this.f5633E.get(i).width() - this.f5645j.width()) / 2) + this.f5633E.get(i).left), (float) (this.f5661z.bottom - 4), this.f5655t);
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.f5637I != null) {
            float x = motionEvent.getX() - motionEvent2.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            if (Math.abs(x) > Math.abs(y)) {
                OnDateChangeRequest onDateChangeRequest = this.f5637I;
                if (x >= BitmapDescriptorFactory.HUE_RED) {
                    i = 1;
                }
                onDateChangeRequest.onDateChangeRequest(2, i);
            } else {
                OnDateChangeRequest onDateChangeRequest2 = this.f5637I;
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
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.f5640e = size;
        this.f5639d = size2;
        m5603a();
        int i3 = this.f5661z.bottom;
        this.f5640e = -1;
        this.f5639d = -1;
        setMeasuredDimension(size, i3);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f5637I != null) {
            if (this.f5629A.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f5637I.onDateChangeRequest(2, 1);
            } else if (this.f5630B.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f5637I.onDateChangeRequest(2, -1);
            } else if (this.f5631C.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f5637I.onDateChangeRequest(1, 1);
            } else if (this.f5632D.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f5637I.onDateChangeRequest(1, -1);
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5636H.onTouchEvent(motionEvent);
    }

    public void setArrowColors(int i, int i2, int i3) {
        this.f5652q = i;
        this.f5653r = i2;
        this.f5651p = i3;
        m5605b();
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        float f = getContext().getResources().getDisplayMetrics().density;
        if (attributeSet == null) {
            this.f5650o = getContext().getResources().getDrawable(C1357d.calendar_header);
            this.f5654s.setTextSize((18.0f * f) + 0.5f);
            this.f5654s.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f5652q = f5626a;
            this.f5653r = f5627b;
            this.f5651p = ViewCompat.MEASURED_STATE_MASK;
            this.f5655t.setTextSize((14.0f * f) + 0.5f);
            this.f5655t.setColor(f5628c);
            this.f5658w = false;
        } else {
            TypedArray obtainStyledAttributes = this.f5638J.obtainStyledAttributes(attributeSet, C1361h.CalendarControl);
            C1365l.m5595a(obtainStyledAttributes, this.f5654s, C1361h.CalendarControl_dateShadowRadius, C1361h.CalendarControl_dateShadowDx, C1361h.CalendarControl_dateShadowDy, C1361h.CalendarControl_dateShadowColor);
            C1365l.m5595a(obtainStyledAttributes, this.f5655t, C1361h.CalendarControl_dowShadowRadius, C1361h.CalendarControl_dowShadowDx, C1361h.CalendarControl_dowShadowDy, C1361h.CalendarControl_dowShadowColor);
            this.f5650o = getContext().getResources().getDrawable(obtainStyledAttributes.getResourceId(C1361h.CalendarControl_dateDrawable, C1357d.calendar_header));
            this.f5654s.setTextSize(obtainStyledAttributes.getFloat(C1361h.CalendarControl_dateTextSize, (18.0f * f) + 0.5f));
            this.f5654s.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_dateTextColor, ViewCompat.MEASURED_STATE_MASK));
            this.f5654s.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5652q = obtainStyledAttributes.getColor(C1361h.CalendarControl_arrowTopGradientColor, f5626a);
            this.f5653r = obtainStyledAttributes.getColor(C1361h.CalendarControl_arrowBotGradientColor, f5627b);
            this.f5651p = obtainStyledAttributes.getColor(C1361h.CalendarControl_arrowOutlineColor, ViewCompat.MEASURED_STATE_MASK);
            this.f5655t.setTextSize(obtainStyledAttributes.getDimension(C1361h.CalendarControl_dowTextSize, 14.0f));
            this.f5655t.setColor(obtainStyledAttributes.getColor(C1361h.CalendarControl_dowTextColor, f5628c));
            this.f5655t.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5658w = obtainStyledAttributes.getBoolean(C1361h.CalendarControl_yearNavigationVisible, false);
        }
        this.f5654s.setAntiAlias(true);
        this.f5655t.setAntiAlias(true);
        this.f5656u.setAntiAlias(true);
        this.f5656u.setStyle(Paint.Style.FILL);
        this.f5657v.setAntiAlias(true);
        this.f5657v.setStrokeWidth(1.0f);
        this.f5657v.setColor(this.f5651p);
        this.f5657v.setStyle(Paint.Style.STROKE);
        m5603a();
    }

    public void setColor(CalendarZone calendarZone, int i) {
        if (calendarZone == CalendarZone.date) {
            this.f5654s.setColor(i);
        } else if (calendarZone == CalendarZone.dow) {
            this.f5655t.setColor(i);
        }
    }

    public void setOnDateChangeRequest(OnDateChangeRequest onDateChangeRequest) {
        this.f5637I = onDateChangeRequest;
    }

    public void setTextShadow(CalendarText calendarText, float f, float f2, float f3, int i) {
        if (calendarText == CalendarText.date) {
            this.f5654s.setShadowLayer(f3, f, f2, i);
        }
    }

    public void setTextSize(CalendarText calendarText, float f) {
        float f2 = getContext().getResources().getDisplayMetrics().density;
        if (calendarText == CalendarText.date) {
            this.f5654s.setTextSize((f2 * f) + 0.5f);
        } else if (calendarText == CalendarText.dow) {
            this.f5655t.setTextSize((f2 * f) + 0.5f);
        }
    }

    public void setYearNavigationVisible(boolean z) {
        this.f5658w = z;
        m5603a();
    }

    public void setZoneDrawable(CalendarZone calendarZone, Drawable drawable) {
        switch (C1370e.f5679a[calendarZone.ordinal()]) {
            case 1:
                this.f5650o = drawable;
                break;
        }
        m5603a();
    }
}
