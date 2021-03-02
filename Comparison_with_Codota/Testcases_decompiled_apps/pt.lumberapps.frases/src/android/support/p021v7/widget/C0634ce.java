package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0347q;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v7.widget.ce */
public class C0634ce extends ViewGroup {

    /* renamed from: a */
    private boolean f1505a;

    /* renamed from: b */
    private int f1506b;

    /* renamed from: c */
    private int f1507c;

    /* renamed from: d */
    private int f1508d;

    /* renamed from: e */
    private int f1509e;

    /* renamed from: f */
    private int f1510f;

    /* renamed from: g */
    private float f1511g;

    /* renamed from: h */
    private boolean f1512h;

    /* renamed from: i */
    private int[] f1513i;

    /* renamed from: j */
    private int[] f1514j;

    /* renamed from: k */
    private Drawable f1515k;

    /* renamed from: l */
    private int f1516l;

    /* renamed from: m */
    private int f1517m;

    /* renamed from: n */
    private int f1518n;

    /* renamed from: o */
    private int f1519o;

    public C0634ce(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0634ce(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0634ce(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1505a = true;
        this.f1506b = -1;
        this.f1507c = 0;
        this.f1509e = 8388659;
        C0670dn a = C0670dn.m3014a(context, attributeSet, C0515k.LinearLayoutCompat, i, 0);
        int a2 = a.mo3317a(C0515k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        int a3 = a.mo3317a(C0515k.LinearLayoutCompat_android_gravity, -1);
        if (a3 >= 0) {
            setGravity(a3);
        }
        boolean a4 = a.mo3320a(C0515k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a4) {
            setBaselineAligned(a4);
        }
        this.f1511g = a.mo3316a(C0515k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1506b = a.mo3317a(C0515k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1512h = a.mo3320a(C0515k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.mo3318a(C0515k.LinearLayoutCompat_divider));
        this.f1518n = a.mo3317a(C0515k.LinearLayoutCompat_showDividers, 0);
        this.f1519o = a.mo3327e(C0515k.LinearLayoutCompat_dividerPadding, 0);
        a.mo3319a();
    }

    /* renamed from: a */
    private void m2878a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    /* renamed from: c */
    private void m2879c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = mo3137b(i3);
            if (b.getVisibility() != 8) {
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                if (cfVar.width == -1) {
                    int i4 = cfVar.height;
                    cfVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    cfVar.height = i4;
                }
            }
        }
    }

    /* renamed from: d */
    private void m2880d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = mo3137b(i3);
            if (b.getVisibility() != 8) {
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                if (cfVar.height == -1) {
                    int i4 = cfVar.width;
                    cfVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    cfVar.width = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo3129a(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo3130a(View view, int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3131a(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        boolean z3;
        int max;
        int i11;
        boolean z4;
        int i12;
        int i13;
        int i14;
        this.f1510f = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = true;
        float f2 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        int i19 = this.f1506b;
        boolean z8 = this.f1512h;
        int i20 = Integer.MIN_VALUE;
        int i21 = 0;
        while (i21 < virtualChildCount) {
            View b = mo3137b(i21);
            if (b == null) {
                this.f1510f += mo3143d(i21);
                i13 = i20;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else if (b.getVisibility() == 8) {
                i21 += mo3130a(b, i21);
                i13 = i20;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else {
                if (mo3142c(i21)) {
                    this.f1510f += this.f1517m;
                }
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                float f3 = f2 + cfVar.f1520g;
                if (mode2 == 1073741824 && cfVar.height == 0 && cfVar.f1520g > 0.0f) {
                    int i22 = this.f1510f;
                    this.f1510f = Math.max(i22, cfVar.topMargin + i22 + cfVar.bottomMargin);
                    z7 = true;
                } else {
                    int i23 = Integer.MIN_VALUE;
                    if (cfVar.height == 0 && cfVar.f1520g > 0.0f) {
                        i23 = 0;
                        cfVar.height = -2;
                    }
                    int i24 = i23;
                    mo3135a(b, i21, i, 0, i2, f3 == 0.0f ? this.f1510f : 0);
                    if (i24 != Integer.MIN_VALUE) {
                        cfVar.height = i24;
                    }
                    int measuredHeight = b.getMeasuredHeight();
                    int i25 = this.f1510f;
                    this.f1510f = Math.max(i25, i25 + measuredHeight + cfVar.topMargin + cfVar.bottomMargin + mo3136b(b));
                    if (z8) {
                        i20 = Math.max(measuredHeight, i20);
                    }
                }
                if (i19 >= 0 && i19 == i21 + 1) {
                    this.f1507c = this.f1510f;
                }
                if (i21 >= i19 || cfVar.f1520g <= 0.0f) {
                    boolean z9 = false;
                    if (mode == 1073741824 || cfVar.width != -1) {
                        z2 = z6;
                    } else {
                        z2 = true;
                        z9 = true;
                    }
                    int i26 = cfVar.rightMargin + cfVar.leftMargin;
                    int measuredWidth = b.getMeasuredWidth() + i26;
                    int max2 = Math.max(i15, measuredWidth);
                    int a = C0682dz.m3093a(i16, C0247by.m914g(b));
                    z3 = z5 && cfVar.width == -1;
                    if (cfVar.f1520g > 0.0f) {
                        i11 = Math.max(i18, z9 ? i26 : measuredWidth);
                        max = i17;
                    } else {
                        if (!z9) {
                            i26 = measuredWidth;
                        }
                        max = Math.max(i17, i26);
                        i11 = i18;
                    }
                    i21 += mo3130a(b, i21);
                    z4 = z7;
                    i18 = i11;
                    i17 = max;
                    i12 = max2;
                    i13 = i20;
                    i14 = a;
                    z6 = z2;
                    f2 = f3;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i21++;
            i20 = i13;
            z7 = z4;
            z5 = z3;
            i16 = i14;
            i15 = i12;
        }
        if (this.f1510f > 0 && mo3142c(virtualChildCount)) {
            this.f1510f += this.f1517m;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1510f = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View b2 = mo3137b(i27);
                if (b2 == null) {
                    this.f1510f += mo3143d(i27);
                    i10 = i27;
                } else if (b2.getVisibility() == 8) {
                    i10 = mo3130a(b2, i27) + i27;
                } else {
                    C0635cf cfVar2 = (C0635cf) b2.getLayoutParams();
                    int i28 = this.f1510f;
                    this.f1510f = Math.max(i28, cfVar2.bottomMargin + i28 + i20 + cfVar2.topMargin + mo3136b(b2));
                    i10 = i27;
                }
                i27 = i10 + 1;
            }
        }
        this.f1510f += getPaddingTop() + getPaddingBottom();
        int a2 = C0247by.m887a(Math.max(this.f1510f, getSuggestedMinimumHeight()), i2, 0);
        int i29 = (16777215 & a2) - this.f1510f;
        if (z7 || (i29 != 0 && f2 > 0.0f)) {
            if (this.f1511g > 0.0f) {
                f2 = this.f1511g;
            }
            this.f1510f = 0;
            int i30 = 0;
            float f4 = f2;
            boolean z10 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i15;
            int i34 = i29;
            while (i30 < virtualChildCount) {
                View b3 = mo3137b(i30);
                if (b3.getVisibility() == 8) {
                    i7 = i31;
                    i9 = i32;
                    i8 = i33;
                    z = z10;
                } else {
                    C0635cf cfVar3 = (C0635cf) b3.getLayoutParams();
                    float f5 = cfVar3.f1520g;
                    if (f5 > 0.0f) {
                        int i35 = (int) ((((float) i34) * f5) / f4);
                        float f6 = f4 - f5;
                        int i36 = i34 - i35;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + cfVar3.leftMargin + cfVar3.rightMargin, cfVar3.width);
                        if (cfVar3.height == 0 && mode2 == 1073741824) {
                            if (i35 <= 0) {
                                i35 = 0;
                            }
                            b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i35, 1073741824));
                        } else {
                            int measuredHeight2 = i35 + b3.getMeasuredHeight();
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                        }
                        float f7 = f6;
                        i5 = i36;
                        i6 = C0682dz.m3093a(i32, C0247by.m914g(b3) & -256);
                        f = f7;
                    } else {
                        f = f4;
                        i5 = i34;
                        i6 = i32;
                    }
                    int i37 = cfVar3.leftMargin + cfVar3.rightMargin;
                    int measuredWidth2 = b3.getMeasuredWidth() + i37;
                    int max3 = Math.max(i33, measuredWidth2);
                    if (!(mode != 1073741824 && cfVar3.width == -1)) {
                        i37 = measuredWidth2;
                    }
                    int max4 = Math.max(i31, i37);
                    z = z10 && cfVar3.width == -1;
                    int i38 = this.f1510f;
                    this.f1510f = Math.max(i38, cfVar3.bottomMargin + b3.getMeasuredHeight() + i38 + cfVar3.topMargin + mo3136b(b3));
                    i7 = max4;
                    i8 = max3;
                    float f8 = f;
                    i9 = i6;
                    i34 = i5;
                    f4 = f8;
                }
                i30++;
                i31 = i7;
                i33 = i8;
                z10 = z;
                i32 = i9;
            }
            this.f1510f += getPaddingTop() + getPaddingBottom();
            z5 = z10;
            i4 = i31;
            i16 = i32;
            i3 = i33;
        } else {
            int max5 = Math.max(i17, i18);
            if (z8 && mode2 != 1073741824) {
                int i39 = 0;
                while (true) {
                    int i40 = i39;
                    if (i40 >= virtualChildCount) {
                        break;
                    }
                    View b4 = mo3137b(i40);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0635cf) b4.getLayoutParams()).f1520g <= 0.0f)) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec(b4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
                    }
                    i39 = i40 + 1;
                }
            }
            i4 = max5;
            i3 = i15;
        }
        if (z5 || mode == 1073741824) {
            i4 = i3;
        }
        setMeasuredDimension(C0247by.m887a(Math.max(i4 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i16), a2);
        if (z6) {
            m2879c(virtualChildCount, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3132a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.f1509e & C0515k.AppCompatTheme_spinnerStyle;
        int i9 = this.f1509e & 8388615;
        switch (i8) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f1510f) / 2);
                break;
            case C0515k.AppCompatTheme_panelMenuListWidth:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.f1510f;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i10 = 0;
        int i11 = paddingTop;
        while (i10 < virtualChildCount) {
            View b = mo3137b(i10);
            if (b == null) {
                i11 += mo3143d(i10);
                i5 = i10;
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                int i12 = cfVar.f1521h;
                if (i12 < 0) {
                    i12 = i9;
                }
                switch (C0347q.m1334a(i12, C0247by.m909d(this)) & 7) {
                    case 1:
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + cfVar.leftMargin) - cfVar.rightMargin;
                        break;
                    case 5:
                        i6 = (paddingRight - measuredWidth) - cfVar.rightMargin;
                        break;
                    default:
                        i6 = paddingLeft + cfVar.leftMargin;
                        break;
                }
                int i13 = (mo3142c(i10) ? this.f1517m + i11 : i11) + cfVar.topMargin;
                m2878a(b, i6, i13 + mo3129a(b), measuredWidth, measuredHeight);
                i11 = i13 + cfVar.bottomMargin + measuredHeight + mo3136b(b);
                i5 = mo3130a(b, i10) + i10;
            } else {
                i5 = i10;
            }
            i10 = i5 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3133a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View b = mo3137b(i);
            if (!(b == null || b.getVisibility() == 8 || !mo3142c(i))) {
                mo3134a(canvas, (b.getTop() - ((C0635cf) b.getLayoutParams()).topMargin) - this.f1517m);
            }
        }
        if (mo3142c(virtualChildCount)) {
            View b2 = mo3137b(virtualChildCount - 1);
            if (b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f1517m;
            } else {
                bottom = ((C0635cf) b2.getLayoutParams()).bottomMargin + b2.getBottom();
            }
            mo3134a(canvas, bottom);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3134a(Canvas canvas, int i) {
        this.f1515k.setBounds(getPaddingLeft() + this.f1519o, i, (getWidth() - getPaddingRight()) - this.f1519o, this.f1517m + i);
        this.f1515k.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3135a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo3136b(View view) {
        return 0;
    }

    /* renamed from: b */
    public C0635cf generateLayoutParams(AttributeSet attributeSet) {
        return new C0635cf(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0635cf generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0635cf(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo3137b(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3138b(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        float f2;
        int baseline;
        int i10;
        boolean z2;
        boolean z3;
        int max;
        int i11;
        boolean z4;
        int i12;
        int i13;
        int i14;
        this.f1510f = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = true;
        float f3 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        if (this.f1513i == null || this.f1514j == null) {
            this.f1513i = new int[4];
            this.f1514j = new int[4];
        }
        int[] iArr = this.f1513i;
        int[] iArr2 = this.f1514j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.f1505a;
        boolean z9 = this.f1512h;
        boolean z10 = mode == 1073741824;
        int i19 = Integer.MIN_VALUE;
        int i20 = 0;
        while (i20 < virtualChildCount) {
            View b = mo3137b(i20);
            if (b == null) {
                this.f1510f += mo3143d(i20);
                i13 = i19;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else if (b.getVisibility() == 8) {
                i20 += mo3130a(b, i20);
                i13 = i19;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else {
                if (mo3142c(i20)) {
                    this.f1510f += this.f1516l;
                }
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                float f4 = f3 + cfVar.f1520g;
                if (mode == 1073741824 && cfVar.width == 0 && cfVar.f1520g > 0.0f) {
                    if (z10) {
                        this.f1510f += cfVar.leftMargin + cfVar.rightMargin;
                    } else {
                        int i21 = this.f1510f;
                        this.f1510f = Math.max(i21, cfVar.leftMargin + i21 + cfVar.rightMargin);
                    }
                    if (z8) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(makeMeasureSpec, makeMeasureSpec);
                    } else {
                        z7 = true;
                    }
                } else {
                    int i22 = Integer.MIN_VALUE;
                    if (cfVar.width == 0 && cfVar.f1520g > 0.0f) {
                        i22 = 0;
                        cfVar.width = -2;
                    }
                    int i23 = i22;
                    mo3135a(b, i20, i, f4 == 0.0f ? this.f1510f : 0, i2, 0);
                    if (i23 != Integer.MIN_VALUE) {
                        cfVar.width = i23;
                    }
                    int measuredWidth = b.getMeasuredWidth();
                    if (z10) {
                        this.f1510f += cfVar.leftMargin + measuredWidth + cfVar.rightMargin + mo3136b(b);
                    } else {
                        int i24 = this.f1510f;
                        this.f1510f = Math.max(i24, i24 + measuredWidth + cfVar.leftMargin + cfVar.rightMargin + mo3136b(b));
                    }
                    if (z9) {
                        i19 = Math.max(measuredWidth, i19);
                    }
                }
                boolean z11 = false;
                if (mode2 == 1073741824 || cfVar.height != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z11 = true;
                }
                int i25 = cfVar.bottomMargin + cfVar.topMargin;
                int measuredHeight = b.getMeasuredHeight() + i25;
                int a = C0682dz.m3093a(i16, C0247by.m914g(b));
                if (z8) {
                    int baseline2 = b.getBaseline();
                    if (baseline2 != -1) {
                        int i26 = ((((cfVar.f1521h < 0 ? this.f1509e : cfVar.f1521h) & C0515k.AppCompatTheme_spinnerStyle) >> 4) & -2) >> 1;
                        iArr[i26] = Math.max(iArr[i26], baseline2);
                        iArr2[i26] = Math.max(iArr2[i26], measuredHeight - baseline2);
                    }
                }
                int max2 = Math.max(i15, measuredHeight);
                z3 = z5 && cfVar.height == -1;
                if (cfVar.f1520g > 0.0f) {
                    i11 = Math.max(i18, z11 ? i25 : measuredHeight);
                    max = i17;
                } else {
                    if (!z11) {
                        i25 = measuredHeight;
                    }
                    max = Math.max(i17, i25);
                    i11 = i18;
                }
                i20 += mo3130a(b, i20);
                z4 = z7;
                i18 = i11;
                i17 = max;
                i12 = max2;
                i13 = i19;
                i14 = a;
                z6 = z2;
                f3 = f4;
            }
            i20++;
            i19 = i13;
            z7 = z4;
            z5 = z3;
            i16 = i14;
            i15 = i12;
        }
        if (this.f1510f > 0 && mo3142c(virtualChildCount)) {
            this.f1510f += this.f1516l;
        }
        int max3 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i15 : Math.max(i15, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1510f = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View b2 = mo3137b(i27);
                if (b2 == null) {
                    this.f1510f += mo3143d(i27);
                    i10 = i27;
                } else if (b2.getVisibility() == 8) {
                    i10 = mo3130a(b2, i27) + i27;
                } else {
                    C0635cf cfVar2 = (C0635cf) b2.getLayoutParams();
                    if (z10) {
                        this.f1510f = cfVar2.rightMargin + cfVar2.leftMargin + i19 + mo3136b(b2) + this.f1510f;
                        i10 = i27;
                    } else {
                        int i28 = this.f1510f;
                        this.f1510f = Math.max(i28, cfVar2.rightMargin + i28 + i19 + cfVar2.leftMargin + mo3136b(b2));
                        i10 = i27;
                    }
                }
                i27 = i10 + 1;
            }
        }
        this.f1510f += getPaddingLeft() + getPaddingRight();
        int a2 = C0247by.m887a(Math.max(this.f1510f, getSuggestedMinimumWidth()), i, 0);
        int i29 = (16777215 & a2) - this.f1510f;
        if (z7 || (i29 != 0 && f3 > 0.0f)) {
            if (this.f1511g > 0.0f) {
                f3 = this.f1511g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f1510f = 0;
            int i30 = 0;
            float f5 = f3;
            boolean z12 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i29;
            int i34 = -1;
            while (i30 < virtualChildCount) {
                View b3 = mo3137b(i30);
                if (b3 == null) {
                    f = f5;
                    i5 = i33;
                    i6 = i34;
                    i7 = i31;
                    z = z12;
                } else if (b3.getVisibility() == 8) {
                    f = f5;
                    i5 = i33;
                    i6 = i34;
                    i7 = i31;
                    z = z12;
                } else {
                    C0635cf cfVar3 = (C0635cf) b3.getLayoutParams();
                    float f6 = cfVar3.f1520g;
                    if (f6 > 0.0f) {
                        int i35 = (int) ((((float) i33) * f6) / f5);
                        float f7 = f5 - f6;
                        i8 = i33 - i35;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + cfVar3.topMargin + cfVar3.bottomMargin, cfVar3.height);
                        if (cfVar3.width == 0 && mode == 1073741824) {
                            if (i35 <= 0) {
                                i35 = 0;
                            }
                            b3.measure(View.MeasureSpec.makeMeasureSpec(i35, 1073741824), childMeasureSpec);
                        } else {
                            int measuredWidth2 = i35 + b3.getMeasuredWidth();
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            b3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        }
                        i9 = C0682dz.m3093a(i32, C0247by.m914g(b3) & -16777216);
                        f2 = f7;
                    } else {
                        i8 = i33;
                        i9 = i32;
                        f2 = f5;
                    }
                    if (z10) {
                        this.f1510f += b3.getMeasuredWidth() + cfVar3.leftMargin + cfVar3.rightMargin + mo3136b(b3);
                    } else {
                        int i36 = this.f1510f;
                        this.f1510f = Math.max(i36, b3.getMeasuredWidth() + i36 + cfVar3.leftMargin + cfVar3.rightMargin + mo3136b(b3));
                    }
                    boolean z13 = mode2 != 1073741824 && cfVar3.height == -1;
                    int i37 = cfVar3.topMargin + cfVar3.bottomMargin;
                    int measuredHeight2 = b3.getMeasuredHeight() + i37;
                    int max4 = Math.max(i34, measuredHeight2);
                    int max5 = Math.max(i31, z13 ? i37 : measuredHeight2);
                    boolean z14 = z12 && cfVar3.height == -1;
                    if (z8 && (baseline = b3.getBaseline()) != -1) {
                        int i38 = ((((cfVar3.f1521h < 0 ? this.f1509e : cfVar3.f1521h) & C0515k.AppCompatTheme_spinnerStyle) >> 4) & -2) >> 1;
                        iArr[i38] = Math.max(iArr[i38], baseline);
                        iArr2[i38] = Math.max(iArr2[i38], measuredHeight2 - baseline);
                    }
                    f = f2;
                    i7 = max5;
                    z = z14;
                    i32 = i9;
                    i5 = i8;
                    i6 = max4;
                }
                i30++;
                i31 = i7;
                i34 = i6;
                z12 = z;
                i33 = i5;
                f5 = f;
            }
            this.f1510f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i34 = Math.max(i34, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z5 = z12;
            i4 = i31;
            i16 = i32;
            i3 = i34;
        } else {
            int max6 = Math.max(i17, i18);
            if (z9 && mode != 1073741824) {
                int i39 = 0;
                while (true) {
                    int i40 = i39;
                    if (i40 >= virtualChildCount) {
                        break;
                    }
                    View b4 = mo3137b(i40);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0635cf) b4.getLayoutParams()).f1520g <= 0.0f)) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                    i39 = i40 + 1;
                }
            }
            i4 = max6;
            i3 = max3;
        }
        if (z5 || mode2 == 1073741824) {
            i4 = i3;
        }
        setMeasuredDimension((-16777216 & i16) | a2, C0247by.m887a(Math.max(i4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i16 << 16));
        if (z6) {
            m2880d(virtualChildCount, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3139b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean a = C0682dz.m3095a(this);
        int paddingTop = getPaddingTop();
        int i9 = i4 - i2;
        int paddingBottom = i9 - getPaddingBottom();
        int paddingBottom2 = (i9 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.f1509e & C0515k.AppCompatTheme_spinnerStyle;
        boolean z = this.f1505a;
        int[] iArr = this.f1513i;
        int[] iArr2 = this.f1514j;
        switch (C0347q.m1334a(this.f1509e & 8388615, C0247by.m909d(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1510f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1510f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i11 = 0;
        while (i11 < virtualChildCount) {
            int i12 = i6 + (i5 * i11);
            View b = mo3137b(i12);
            if (b == null) {
                paddingLeft += mo3143d(i12);
                i7 = i11;
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                int baseline = (!z || cfVar.height == -1) ? -1 : b.getBaseline();
                int i13 = cfVar.f1521h;
                if (i13 < 0) {
                    i13 = i10;
                }
                switch (i13 & C0515k.AppCompatTheme_spinnerStyle) {
                    case 16:
                        i8 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + cfVar.topMargin) - cfVar.bottomMargin;
                        break;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        i8 = paddingTop + cfVar.topMargin;
                        if (baseline != -1) {
                            i8 += iArr[1] - baseline;
                            break;
                        }
                        break;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        i8 = (paddingBottom - measuredHeight) - cfVar.bottomMargin;
                        if (baseline != -1) {
                            i8 -= iArr2[2] - (b.getMeasuredHeight() - baseline);
                            break;
                        }
                        break;
                    default:
                        i8 = paddingTop;
                        break;
                }
                int i14 = (mo3142c(i12) ? this.f1516l + paddingLeft : paddingLeft) + cfVar.leftMargin;
                m2878a(b, i14 + mo3129a(b), i8, measuredWidth, measuredHeight);
                paddingLeft = i14 + cfVar.rightMargin + measuredWidth + mo3136b(b);
                i7 = mo3130a(b, i12) + i11;
            } else {
                i7 = i11;
            }
            i11 = i7 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3140b(Canvas canvas) {
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean a = C0682dz.m3095a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View b = mo3137b(i);
            if (!(b == null || b.getVisibility() == 8 || !mo3142c(i))) {
                C0635cf cfVar = (C0635cf) b.getLayoutParams();
                mo3141b(canvas, a ? cfVar.rightMargin + b.getRight() : (b.getLeft() - cfVar.leftMargin) - this.f1516l);
            }
        }
        if (mo3142c(virtualChildCount)) {
            View b2 = mo3137b(virtualChildCount - 1);
            if (b2 == null) {
                left = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f1516l;
            } else {
                C0635cf cfVar2 = (C0635cf) b2.getLayoutParams();
                left = a ? (b2.getLeft() - cfVar2.leftMargin) - this.f1516l : cfVar2.rightMargin + b2.getRight();
            }
            mo3141b(canvas, left);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3141b(Canvas canvas, int i) {
        this.f1515k.setBounds(i, getPaddingTop() + this.f1519o, this.f1516l + i, (getHeight() - getPaddingBottom()) - this.f1519o);
        this.f1515k.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3142c(int i) {
        if (i == 0) {
            return (this.f1518n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f1518n & 4) != 0;
        }
        if ((this.f1518n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0635cf;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo3143d(int i) {
        return 0;
    }

    public int getBaseline() {
        int i;
        int i2;
        if (this.f1506b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1506b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1506b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i3 = this.f1507c;
            if (this.f1508d == 1 && (i2 = this.f1509e & C0515k.AppCompatTheme_spinnerStyle) != 48) {
                switch (i2) {
                    case 16:
                        i = i3 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1510f) / 2);
                        break;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1510f;
                        break;
                }
            }
            i = i3;
            return ((C0635cf) childAt.getLayoutParams()).topMargin + i + baseline;
        } else if (this.f1506b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1506b;
    }

    public Drawable getDividerDrawable() {
        return this.f1515k;
    }

    public int getDividerPadding() {
        return this.f1519o;
    }

    public int getDividerWidth() {
        return this.f1516l;
    }

    public int getOrientation() {
        return this.f1508d;
    }

    public int getShowDividers() {
        return this.f1518n;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1511g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public C0635cf generateDefaultLayoutParams() {
        if (this.f1508d == 0) {
            return new C0635cf(-2, -2);
        }
        if (this.f1508d == 1) {
            return new C0635cf(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1515k != null) {
            if (this.f1508d == 1) {
                mo3133a(canvas);
            } else {
                mo3140b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0634ce.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0634ce.class.getName());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1508d == 1) {
            mo3132a(i, i2, i3, i4);
        } else {
            mo3139b(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f1508d == 1) {
            mo3131a(i, i2);
        } else {
            mo3138b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f1505a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1506b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f1515k) {
            this.f1515k = drawable;
            if (drawable != null) {
                this.f1516l = drawable.getIntrinsicWidth();
                this.f1517m = drawable.getIntrinsicHeight();
            } else {
                this.f1516l = 0;
                this.f1517m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1519o = i;
    }

    public void setGravity(int i) {
        if (this.f1509e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & C0515k.AppCompatTheme_spinnerStyle) == 0) {
                i2 |= 48;
            }
            this.f1509e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f1509e & 8388615) != i2) {
            this.f1509e = i2 | (this.f1509e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1512h = z;
    }

    public void setOrientation(int i) {
        if (this.f1508d != i) {
            this.f1508d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f1518n) {
            requestLayout();
        }
        this.f1518n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & C0515k.AppCompatTheme_spinnerStyle;
        if ((this.f1509e & C0515k.AppCompatTheme_spinnerStyle) != i2) {
            this.f1509e = i2 | (this.f1509e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f1511g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
