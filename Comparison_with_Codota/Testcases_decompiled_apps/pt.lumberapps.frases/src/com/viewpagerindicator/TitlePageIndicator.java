package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0275cz;
import android.support.p009v4.view.C0301dy;
import android.support.p009v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;

public class TitlePageIndicator extends View implements C2007a {

    /* renamed from: A */
    private C2018l f7609A;

    /* renamed from: a */
    private ViewPager f7610a;

    /* renamed from: b */
    private C0301dy f7611b;

    /* renamed from: c */
    private int f7612c;

    /* renamed from: d */
    private float f7613d;

    /* renamed from: e */
    private int f7614e;

    /* renamed from: f */
    private final Paint f7615f;

    /* renamed from: g */
    private boolean f7616g;

    /* renamed from: h */
    private int f7617h;

    /* renamed from: i */
    private int f7618i;

    /* renamed from: j */
    private Path f7619j;

    /* renamed from: k */
    private final Rect f7620k;

    /* renamed from: l */
    private final Paint f7621l;

    /* renamed from: m */
    private C2016j f7622m;

    /* renamed from: n */
    private C2017k f7623n;

    /* renamed from: o */
    private final Paint f7624o;

    /* renamed from: p */
    private float f7625p;

    /* renamed from: q */
    private float f7626q;

    /* renamed from: r */
    private float f7627r;

    /* renamed from: s */
    private float f7628s;

    /* renamed from: t */
    private float f7629t;

    /* renamed from: u */
    private float f7630u;

    /* renamed from: v */
    private float f7631v;

    /* renamed from: w */
    private int f7632w;

    /* renamed from: x */
    private float f7633x;

    /* renamed from: y */
    private int f7634y;

    /* renamed from: z */
    private boolean f7635z;

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C2019m();

        /* renamed from: a */
        int f7636a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7636a = parcel.readInt();
        }

        /* synthetic */ SavedState(Parcel parcel, C2015i iVar) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7636a);
        }
    }

    public TitlePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2009c.vpiTitlePageIndicatorStyle);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7612c = -1;
        this.f7615f = new Paint();
        this.f7619j = new Path();
        this.f7620k = new Rect();
        this.f7621l = new Paint();
        this.f7624o = new Paint();
        this.f7633x = -1.0f;
        this.f7634y = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(C2011e.default_title_indicator_footer_color);
            float dimension = resources.getDimension(C2012f.default_title_indicator_footer_line_height);
            int integer = resources.getInteger(C2013g.default_title_indicator_footer_indicator_style);
            float dimension2 = resources.getDimension(C2012f.default_title_indicator_footer_indicator_height);
            float dimension3 = resources.getDimension(C2012f.default_title_indicator_footer_indicator_underline_padding);
            float dimension4 = resources.getDimension(C2012f.default_title_indicator_footer_padding);
            int integer2 = resources.getInteger(C2013g.default_title_indicator_line_position);
            int color2 = resources.getColor(C2011e.default_title_indicator_selected_color);
            boolean z = resources.getBoolean(C2010d.default_title_indicator_selected_bold);
            int color3 = resources.getColor(C2011e.default_title_indicator_text_color);
            float dimension5 = resources.getDimension(C2012f.default_title_indicator_text_size);
            float dimension6 = resources.getDimension(C2012f.default_title_indicator_title_padding);
            float dimension7 = resources.getDimension(C2012f.default_title_indicator_clip_padding);
            float dimension8 = resources.getDimension(C2012f.default_title_indicator_top_padding);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2014h.TitlePageIndicator, i, 0);
            this.f7631v = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_footerLineHeight, dimension);
            this.f7622m = C2016j.m8264a(obtainStyledAttributes.getInteger(C2014h.TitlePageIndicator_footerIndicatorStyle, integer));
            this.f7625p = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_footerIndicatorHeight, dimension2);
            this.f7626q = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_footerIndicatorUnderlinePadding, dimension3);
            this.f7627r = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_footerPadding, dimension4);
            this.f7623n = C2017k.m8265a(obtainStyledAttributes.getInteger(C2014h.TitlePageIndicator_linePosition, integer2));
            this.f7629t = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_topPadding, dimension8);
            this.f7628s = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_titlePadding, dimension6);
            this.f7630u = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_clipPadding, dimension7);
            this.f7618i = obtainStyledAttributes.getColor(C2014h.TitlePageIndicator_selectedColor, color2);
            this.f7617h = obtainStyledAttributes.getColor(C2014h.TitlePageIndicator_android_textColor, color3);
            this.f7616g = obtainStyledAttributes.getBoolean(C2014h.TitlePageIndicator_selectedBold, z);
            float dimension9 = obtainStyledAttributes.getDimension(C2014h.TitlePageIndicator_android_textSize, dimension5);
            int color4 = obtainStyledAttributes.getColor(C2014h.TitlePageIndicator_footerColor, color);
            this.f7615f.setTextSize(dimension9);
            this.f7615f.setAntiAlias(true);
            this.f7621l.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f7621l.setStrokeWidth(this.f7631v);
            this.f7621l.setColor(color4);
            this.f7624o.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f7624o.setColor(color4);
            Drawable drawable = obtainStyledAttributes.getDrawable(C2014h.TitlePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f7632w = C0275cz.m1119a(ViewConfiguration.get(context));
        }
    }

    /* renamed from: a */
    private Rect m8256a(int i, Paint paint) {
        Rect rect = new Rect();
        CharSequence c = m8260c(i);
        rect.right = (int) paint.measureText(c, 0, c.length());
        rect.bottom = (int) (paint.descent() - paint.ascent());
        return rect;
    }

    /* renamed from: a */
    private ArrayList m8257a(Paint paint) {
        ArrayList arrayList = new ArrayList();
        int count = this.f7610a.getAdapter().getCount();
        int width = getWidth();
        int i = width / 2;
        for (int i2 = 0; i2 < count; i2++) {
            Rect a = m8256a(i2, paint);
            int i3 = a.right - a.left;
            int i4 = a.bottom - a.top;
            a.left = (int) ((((float) i) - (((float) i3) / 2.0f)) + ((((float) (i2 - this.f7612c)) - this.f7613d) * ((float) width)));
            a.right = i3 + a.left;
            a.top = 0;
            a.bottom = i4;
            arrayList.add(a);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m8258a(Rect rect, float f, int i) {
        rect.right = (int) (((float) i) - this.f7630u);
        rect.left = (int) (((float) rect.right) - f);
    }

    /* renamed from: b */
    private void m8259b(Rect rect, float f, int i) {
        rect.left = (int) (((float) i) + this.f7630u);
        rect.right = (int) (this.f7630u + f);
    }

    /* renamed from: c */
    private CharSequence m8260c(int i) {
        CharSequence pageTitle = this.f7610a.getAdapter().getPageTitle(i);
        return pageTitle == null ? "" : pageTitle;
    }

    /* renamed from: a */
    public void mo1534a(int i) {
        if (this.f7614e == 0) {
            this.f7612c = i;
            invalidate();
        }
        if (this.f7611b != null) {
            this.f7611b.mo1534a(i);
        }
    }

    /* renamed from: a */
    public void mo1535a(int i, float f, int i2) {
        this.f7612c = i;
        this.f7613d = f;
        invalidate();
        if (this.f7611b != null) {
            this.f7611b.mo1535a(i, f, i2);
        }
    }

    /* renamed from: b */
    public void mo1536b(int i) {
        this.f7614e = i;
        if (this.f7611b != null) {
            this.f7611b.mo1536b(i);
        }
    }

    public float getClipPadding() {
        return this.f7630u;
    }

    public int getFooterColor() {
        return this.f7621l.getColor();
    }

    public float getFooterIndicatorHeight() {
        return this.f7625p;
    }

    public float getFooterIndicatorPadding() {
        return this.f7627r;
    }

    public C2016j getFooterIndicatorStyle() {
        return this.f7622m;
    }

    public float getFooterLineHeight() {
        return this.f7631v;
    }

    public C2017k getLinePosition() {
        return this.f7623n;
    }

    public int getSelectedColor() {
        return this.f7618i;
    }

    public int getTextColor() {
        return this.f7617h;
    }

    public float getTextSize() {
        return this.f7615f.getTextSize();
    }

    public float getTitlePadding() {
        return this.f7628s;
    }

    public float getTopPadding() {
        return this.f7629t;
    }

    public Typeface getTypeface() {
        return this.f7615f.getTypeface();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int count;
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f7610a != null && (count = this.f7610a.getAdapter().getCount()) != 0) {
            if (this.f7612c == -1 && this.f7610a != null) {
                this.f7612c = this.f7610a.getCurrentItem();
            }
            ArrayList a = m8257a(this.f7615f);
            int size = a.size();
            if (this.f7612c >= size) {
                setCurrentItem(size - 1);
                return;
            }
            int i3 = count - 1;
            float width = ((float) getWidth()) / 2.0f;
            int left = getLeft();
            float f4 = ((float) left) + this.f7630u;
            int width2 = getWidth();
            int height = getHeight();
            int i4 = left + width2;
            float f5 = ((float) i4) - this.f7630u;
            int i5 = this.f7612c;
            if (((double) this.f7613d) <= 0.5d) {
                i = i5;
                f = this.f7613d;
            } else {
                i = i5 + 1;
                f = 1.0f - this.f7613d;
            }
            boolean z = f <= 0.25f;
            boolean z2 = f <= 0.05f;
            float f6 = (0.25f - f) / 0.25f;
            Rect rect = (Rect) a.get(this.f7612c);
            float f7 = (float) (rect.right - rect.left);
            if (((float) rect.left) < f4) {
                m8259b(rect, f7, left);
            }
            if (((float) rect.right) > f5) {
                m8258a(rect, f7, i4);
            }
            if (this.f7612c > 0) {
                for (int i6 = this.f7612c - 1; i6 >= 0; i6--) {
                    Rect rect2 = (Rect) a.get(i6);
                    if (((float) rect2.left) < f4) {
                        int i7 = rect2.right - rect2.left;
                        m8259b(rect2, (float) i7, left);
                        Rect rect3 = (Rect) a.get(i6 + 1);
                        if (((float) rect2.right) + this.f7628s > ((float) rect3.left)) {
                            rect2.left = (int) (((float) (rect3.left - i7)) - this.f7628s);
                            rect2.right = rect2.left + i7;
                        }
                    }
                }
            }
            if (this.f7612c < i3) {
                int i8 = this.f7612c + 1;
                while (true) {
                    int i9 = i8;
                    if (i9 >= count) {
                        break;
                    }
                    Rect rect4 = (Rect) a.get(i9);
                    if (((float) rect4.right) > f5) {
                        int i10 = rect4.right - rect4.left;
                        m8258a(rect4, (float) i10, i4);
                        Rect rect5 = (Rect) a.get(i9 - 1);
                        if (((float) rect4.left) - this.f7628s < ((float) rect5.right)) {
                            rect4.left = (int) (((float) rect5.right) + this.f7628s);
                            rect4.right = rect4.left + i10;
                        }
                    }
                    i8 = i9 + 1;
                }
            }
            int i11 = this.f7617h >>> 24;
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= count) {
                    break;
                }
                Rect rect6 = (Rect) a.get(i13);
                if ((rect6.left > left && rect6.left < i4) || (rect6.right > left && rect6.right < i4)) {
                    boolean z3 = i13 == i;
                    CharSequence c = m8260c(i13);
                    this.f7615f.setFakeBoldText(z3 && z2 && this.f7616g);
                    this.f7615f.setColor(this.f7617h);
                    if (z3 && z) {
                        this.f7615f.setAlpha(i11 - ((int) (((float) i11) * f6)));
                    }
                    if (i13 < size - 1) {
                        Rect rect7 = (Rect) a.get(i13 + 1);
                        if (((float) rect6.right) + this.f7628s > ((float) rect7.left)) {
                            int i14 = rect6.right - rect6.left;
                            rect6.left = (int) (((float) (rect7.left - i14)) - this.f7628s);
                            rect6.right = rect6.left + i14;
                        }
                    }
                    canvas.drawText(c, 0, c.length(), (float) rect6.left, this.f7629t + ((float) rect6.bottom), this.f7615f);
                    if (z3 && z) {
                        this.f7615f.setColor(this.f7618i);
                        this.f7615f.setAlpha((int) (((float) (this.f7618i >>> 24)) * f6));
                        canvas.drawText(c, 0, c.length(), (float) rect6.left, this.f7629t + ((float) rect6.bottom), this.f7615f);
                    }
                }
                i12 = i13 + 1;
            }
            float f8 = this.f7631v;
            float f9 = this.f7625p;
            if (this.f7623n == C2017k.Top) {
                i2 = 0;
                float f10 = -f9;
                f3 = -f8;
                f2 = f10;
            } else {
                i2 = height;
                float f11 = f8;
                f2 = f9;
                f3 = f11;
            }
            this.f7619j.reset();
            this.f7619j.moveTo(0.0f, ((float) i2) - (f3 / 2.0f));
            this.f7619j.lineTo((float) width2, ((float) i2) - (f3 / 2.0f));
            this.f7619j.close();
            canvas.drawPath(this.f7619j, this.f7621l);
            float f12 = ((float) i2) - f3;
            switch (C2015i.f7637a[this.f7622m.ordinal()]) {
                case 1:
                    this.f7619j.reset();
                    this.f7619j.moveTo(width, f12 - f2);
                    this.f7619j.lineTo(width + f2, f12);
                    this.f7619j.lineTo(width - f2, f12);
                    this.f7619j.close();
                    canvas.drawPath(this.f7619j, this.f7624o);
                    return;
                case 2:
                    if (z && i < size) {
                        Rect rect8 = (Rect) a.get(i);
                        float f13 = ((float) rect8.right) + this.f7626q;
                        float f14 = ((float) rect8.left) - this.f7626q;
                        float f15 = f12 - f2;
                        this.f7619j.reset();
                        this.f7619j.moveTo(f14, f12);
                        this.f7619j.lineTo(f13, f12);
                        this.f7619j.lineTo(f13, f15);
                        this.f7619j.lineTo(f14, f15);
                        this.f7619j.close();
                        this.f7624o.setAlpha((int) (255.0f * f6));
                        canvas.drawPath(this.f7619j, this.f7624o);
                        this.f7624o.setAlpha(255);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f;
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            f = (float) View.MeasureSpec.getSize(i2);
        } else {
            this.f7620k.setEmpty();
            this.f7620k.bottom = (int) (this.f7615f.descent() - this.f7615f.ascent());
            f = ((float) (this.f7620k.bottom - this.f7620k.top)) + this.f7631v + this.f7627r + this.f7629t;
            if (this.f7622m != C2016j.None) {
                f += this.f7625p;
            }
        }
        setMeasuredDimension(size, (int) f);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7612c = savedState.f7636a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7636a = this.f7612c;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f7610a == null || this.f7610a.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.f7634y = C0223ba.m831b(motionEvent, 0);
                this.f7633x = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.f7635z) {
                    int count = this.f7610a.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    float f3 = f - f2;
                    float f4 = f2 + f;
                    float x = motionEvent.getX();
                    if (x < f3) {
                        if (this.f7612c > 0) {
                            if (action == 3) {
                                return true;
                            }
                            this.f7610a.setCurrentItem(this.f7612c - 1);
                            return true;
                        }
                    } else if (x > f4) {
                        if (this.f7612c < count - 1) {
                            if (action == 3) {
                                return true;
                            }
                            this.f7610a.setCurrentItem(this.f7612c + 1);
                            return true;
                        }
                    } else if (!(this.f7609A == null || action == 3)) {
                        this.f7609A.mo10110a(this.f7612c);
                    }
                }
                this.f7635z = false;
                this.f7634y = -1;
                if (!this.f7610a.mo1210f()) {
                    return true;
                }
                this.f7610a.mo1209e();
                return true;
            case 2:
                float c = C0223ba.m832c(motionEvent, C0223ba.m829a(motionEvent, this.f7634y));
                float f5 = c - this.f7633x;
                if (!this.f7635z && Math.abs(f5) > ((float) this.f7632w)) {
                    this.f7635z = true;
                }
                if (!this.f7635z) {
                    return true;
                }
                this.f7633x = c;
                if (!this.f7610a.mo1210f() && !this.f7610a.mo1204d()) {
                    return true;
                }
                this.f7610a.mo1198b(f5);
                return true;
            case 5:
                int b = C0223ba.m830b(motionEvent);
                this.f7633x = C0223ba.m832c(motionEvent, b);
                this.f7634y = C0223ba.m831b(motionEvent, b);
                return true;
            case 6:
                int b2 = C0223ba.m830b(motionEvent);
                if (C0223ba.m831b(motionEvent, b2) == this.f7634y) {
                    if (b2 == 0) {
                        i = 1;
                    }
                    this.f7634y = C0223ba.m831b(motionEvent, i);
                }
                this.f7633x = C0223ba.m832c(motionEvent, C0223ba.m829a(motionEvent, this.f7634y));
                return true;
            default:
                return true;
        }
    }

    public void setClipPadding(float f) {
        this.f7630u = f;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.f7610a == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f7610a.setCurrentItem(i);
        this.f7612c = i;
        invalidate();
    }

    public void setFooterColor(int i) {
        this.f7621l.setColor(i);
        this.f7624o.setColor(i);
        invalidate();
    }

    public void setFooterIndicatorHeight(float f) {
        this.f7625p = f;
        invalidate();
    }

    public void setFooterIndicatorPadding(float f) {
        this.f7627r = f;
        invalidate();
    }

    public void setFooterIndicatorStyle(C2016j jVar) {
        this.f7622m = jVar;
        invalidate();
    }

    public void setFooterLineHeight(float f) {
        this.f7631v = f;
        this.f7621l.setStrokeWidth(this.f7631v);
        invalidate();
    }

    public void setLinePosition(C2017k kVar) {
        this.f7623n = kVar;
        invalidate();
    }

    public void setOnCenterItemClickListener(C2018l lVar) {
        this.f7609A = lVar;
    }

    public void setOnPageChangeListener(C0301dy dyVar) {
        this.f7611b = dyVar;
    }

    public void setSelectedBold(boolean z) {
        this.f7616g = z;
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.f7618i = i;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f7615f.setColor(i);
        this.f7617h = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f7615f.setTextSize(f);
        invalidate();
    }

    public void setTitlePadding(float f) {
        this.f7628s = f;
        invalidate();
    }

    public void setTopPadding(float f) {
        this.f7629t = f;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.f7615f.setTypeface(typeface);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f7610a != viewPager) {
            if (this.f7610a != null) {
                this.f7610a.setOnPageChangeListener((C0301dy) null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f7610a = viewPager;
            this.f7610a.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
