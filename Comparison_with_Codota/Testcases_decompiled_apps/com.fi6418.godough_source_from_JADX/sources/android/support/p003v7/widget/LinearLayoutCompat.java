package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.support.p003v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v7.widget.LinearLayoutCompat */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    private boolean f2771a;

    /* renamed from: b */
    private int f2772b;

    /* renamed from: c */
    private int f2773c;

    /* renamed from: d */
    private int f2774d;

    /* renamed from: e */
    private int f2775e;

    /* renamed from: f */
    private int f2776f;

    /* renamed from: g */
    private float f2777g;

    /* renamed from: h */
    private boolean f2778h;

    /* renamed from: i */
    private int[] f2779i;

    /* renamed from: j */
    private int[] f2780j;

    /* renamed from: k */
    private Drawable f2781k;

    /* renamed from: l */
    private int f2782l;

    /* renamed from: m */
    private int f2783m;

    /* renamed from: n */
    private int f2784n;

    /* renamed from: o */
    private int f2785o;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.widget.LinearLayoutCompat$DividerMode */
    public @interface DividerMode {
    }

    /* renamed from: android.support.v7.widget.LinearLayoutCompat$LayoutParams */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = BitmapDescriptorFactory.HUE_RED;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(C0235R.styleable.LinearLayoutCompat_Layout_android_layout_weight, BitmapDescriptorFactory.HUE_RED);
            this.gravity = obtainStyledAttributes.getInt(C0235R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.widget.LinearLayoutCompat$OrientationMode */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2771a = true;
        this.f2772b = -1;
        this.f2773c = 0;
        this.f2775e = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0235R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(C0235R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(C0235R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(C0235R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f2777g = obtainStyledAttributes.getFloat(C0235R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f2772b = obtainStyledAttributes.getInt(C0235R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f2778h = obtainStyledAttributes.getBoolean(C0235R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.LinearLayoutCompat_divider));
        this.f2784n = obtainStyledAttributes.getInt(C0235R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f2785o = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m1839a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    /* renamed from: c */
    private void m1840c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = mo5281b(i3);
            if (b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* renamed from: d */
    private void m1841d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = mo5281b(i3);
            if (b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5273a(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5274a(View view, int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5275a(int i, int i2) {
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
        this.f2776f = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = true;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        int i19 = this.f2772b;
        boolean z8 = this.f2778h;
        int i20 = Integer.MIN_VALUE;
        int i21 = 0;
        while (i21 < virtualChildCount) {
            View b = mo5281b(i21);
            if (b == null) {
                this.f2776f += mo5287d(i21);
                i13 = i20;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else if (b.getVisibility() == 8) {
                i21 += mo5274a(b, i21);
                i13 = i20;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else {
                if (mo5286c(i21)) {
                    this.f2776f += this.f2783m;
                }
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                float f3 = f2 + layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    int i22 = this.f2776f;
                    this.f2776f = Math.max(i22, layoutParams.topMargin + i22 + layoutParams.bottomMargin);
                    z7 = true;
                } else {
                    int i23 = Integer.MIN_VALUE;
                    if (layoutParams.height == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                        i23 = 0;
                        layoutParams.height = -2;
                    }
                    int i24 = i23;
                    mo5279a(b, i21, i, 0, i2, f3 == BitmapDescriptorFactory.HUE_RED ? this.f2776f : 0);
                    if (i24 != Integer.MIN_VALUE) {
                        layoutParams.height = i24;
                    }
                    int measuredHeight = b.getMeasuredHeight();
                    int i25 = this.f2776f;
                    this.f2776f = Math.max(i25, i25 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + mo5280b(b));
                    if (z8) {
                        i20 = Math.max(measuredHeight, i20);
                    }
                }
                if (i19 >= 0 && i19 == i21 + 1) {
                    this.f2773c = this.f2776f;
                }
                if (i21 >= i19 || layoutParams.weight <= BitmapDescriptorFactory.HUE_RED) {
                    boolean z9 = false;
                    if (mode == 1073741824 || layoutParams.width != -1) {
                        z2 = z6;
                    } else {
                        z2 = true;
                        z9 = true;
                    }
                    int i26 = layoutParams.rightMargin + layoutParams.leftMargin;
                    int measuredWidth = b.getMeasuredWidth() + i26;
                    int max2 = Math.max(i15, measuredWidth);
                    int combineMeasuredStates = ViewUtils.combineMeasuredStates(i16, ViewCompat.getMeasuredState(b));
                    z3 = z5 && layoutParams.width == -1;
                    if (layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                        i11 = Math.max(i18, z9 ? i26 : measuredWidth);
                        max = i17;
                    } else {
                        if (!z9) {
                            i26 = measuredWidth;
                        }
                        max = Math.max(i17, i26);
                        i11 = i18;
                    }
                    i21 += mo5274a(b, i21);
                    z4 = z7;
                    i18 = i11;
                    i17 = max;
                    i12 = max2;
                    i13 = i20;
                    i14 = combineMeasuredStates;
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
        if (this.f2776f > 0 && mo5286c(virtualChildCount)) {
            this.f2776f += this.f2783m;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f2776f = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View b2 = mo5281b(i27);
                if (b2 == null) {
                    this.f2776f += mo5287d(i27);
                    i10 = i27;
                } else if (b2.getVisibility() == 8) {
                    i10 = mo5274a(b2, i27) + i27;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) b2.getLayoutParams();
                    int i28 = this.f2776f;
                    this.f2776f = Math.max(i28, layoutParams2.bottomMargin + i28 + i20 + layoutParams2.topMargin + mo5280b(b2));
                    i10 = i27;
                }
                i27 = i10 + 1;
            }
        }
        this.f2776f += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.f2776f, getSuggestedMinimumHeight()), i2, 0);
        int i29 = (16777215 & resolveSizeAndState) - this.f2776f;
        if (z7 || (i29 != 0 && f2 > BitmapDescriptorFactory.HUE_RED)) {
            if (this.f2777g > BitmapDescriptorFactory.HUE_RED) {
                f2 = this.f2777g;
            }
            this.f2776f = 0;
            int i30 = 0;
            float f4 = f2;
            boolean z10 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i15;
            int i34 = i29;
            while (i30 < virtualChildCount) {
                View b3 = mo5281b(i30);
                if (b3.getVisibility() == 8) {
                    i7 = i31;
                    i9 = i32;
                    i8 = i33;
                    z = z10;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) b3.getLayoutParams();
                    float f5 = layoutParams3.weight;
                    if (f5 > BitmapDescriptorFactory.HUE_RED) {
                        int i35 = (int) ((((float) i34) * f5) / f4);
                        float f6 = f4 - f5;
                        int i36 = i34 - i35;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height == 0 && mode2 == 1073741824) {
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
                        i6 = ViewUtils.combineMeasuredStates(i32, ViewCompat.getMeasuredState(b3) & InputDeviceCompat.SOURCE_ANY);
                        f = f7;
                    } else {
                        f = f4;
                        i5 = i34;
                        i6 = i32;
                    }
                    int i37 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int measuredWidth2 = b3.getMeasuredWidth() + i37;
                    int max3 = Math.max(i33, measuredWidth2);
                    if (!(mode != 1073741824 && layoutParams3.width == -1)) {
                        i37 = measuredWidth2;
                    }
                    int max4 = Math.max(i31, i37);
                    z = z10 && layoutParams3.width == -1;
                    int i38 = this.f2776f;
                    this.f2776f = Math.max(i38, layoutParams3.bottomMargin + b3.getMeasuredHeight() + i38 + layoutParams3.topMargin + mo5280b(b3));
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
            this.f2776f += getPaddingTop() + getPaddingBottom();
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
                    View b4 = mo5281b(i40);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((LayoutParams) b4.getLayoutParams()).weight <= BitmapDescriptorFactory.HUE_RED)) {
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
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i4 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i16), resolveSizeAndState);
        if (z6) {
            m1840c(virtualChildCount, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5276a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.f2775e & 112;
        int i9 = this.f2775e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i8) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f2776f) / 2);
                break;
            case 80:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.f2776f;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i10 = 0;
        int i11 = paddingTop;
        while (i10 < virtualChildCount) {
            View b = mo5281b(i10);
            if (b == null) {
                i11 += mo5287d(i10);
                i5 = i10;
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                int i12 = layoutParams.gravity;
                if (i12 < 0) {
                    i12 = i9;
                }
                switch (GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this)) & 7) {
                    case 1:
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i6 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i6 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                int i13 = (mo5286c(i10) ? this.f2783m + i11 : i11) + layoutParams.topMargin;
                m1839a(b, i6, i13 + mo5273a(b), measuredWidth, measuredHeight);
                i11 = i13 + layoutParams.bottomMargin + measuredHeight + mo5280b(b);
                i5 = mo5274a(b, i10) + i10;
            } else {
                i5 = i10;
            }
            i10 = i5 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5277a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View b = mo5281b(i);
            if (!(b == null || b.getVisibility() == 8 || !mo5286c(i))) {
                mo5278a(canvas, (b.getTop() - ((LayoutParams) b.getLayoutParams()).topMargin) - this.f2783m);
            }
        }
        if (mo5286c(virtualChildCount)) {
            View b2 = mo5281b(virtualChildCount - 1);
            if (b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f2783m;
            } else {
                bottom = ((LayoutParams) b2.getLayoutParams()).bottomMargin + b2.getBottom();
            }
            mo5278a(canvas, bottom);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5278a(Canvas canvas, int i) {
        this.f2781k.setBounds(getPaddingLeft() + this.f2785o, i, (getWidth() - getPaddingRight()) - this.f2785o, this.f2783m + i);
        this.f2781k.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5279a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5280b(View view) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.f2774d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.f2774d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5281b(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5282b(int i, int i2) {
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
        this.f2776f = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = true;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        if (this.f2779i == null || this.f2780j == null) {
            this.f2779i = new int[4];
            this.f2780j = new int[4];
        }
        int[] iArr = this.f2779i;
        int[] iArr2 = this.f2780j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.f2771a;
        boolean z9 = this.f2778h;
        boolean z10 = mode == 1073741824;
        int i19 = Integer.MIN_VALUE;
        int i20 = 0;
        while (i20 < virtualChildCount) {
            View b = mo5281b(i20);
            if (b == null) {
                this.f2776f += mo5287d(i20);
                i13 = i19;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else if (b.getVisibility() == 8) {
                i20 += mo5274a(b, i20);
                i13 = i19;
                z4 = z7;
                z3 = z5;
                i14 = i16;
                i12 = i15;
            } else {
                if (mo5286c(i20)) {
                    this.f2776f += this.f2782l;
                }
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                float f4 = f3 + layoutParams.weight;
                if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    if (z10) {
                        this.f2776f += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        int i21 = this.f2776f;
                        this.f2776f = Math.max(i21, layoutParams.leftMargin + i21 + layoutParams.rightMargin);
                    }
                    if (z8) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(makeMeasureSpec, makeMeasureSpec);
                    } else {
                        z7 = true;
                    }
                } else {
                    int i22 = Integer.MIN_VALUE;
                    if (layoutParams.width == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                        i22 = 0;
                        layoutParams.width = -2;
                    }
                    int i23 = i22;
                    mo5279a(b, i20, i, f4 == BitmapDescriptorFactory.HUE_RED ? this.f2776f : 0, i2, 0);
                    if (i23 != Integer.MIN_VALUE) {
                        layoutParams.width = i23;
                    }
                    int measuredWidth = b.getMeasuredWidth();
                    if (z10) {
                        this.f2776f += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + mo5280b(b);
                    } else {
                        int i24 = this.f2776f;
                        this.f2776f = Math.max(i24, i24 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + mo5280b(b));
                    }
                    if (z9) {
                        i19 = Math.max(measuredWidth, i19);
                    }
                }
                boolean z11 = false;
                if (mode2 == 1073741824 || layoutParams.height != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z11 = true;
                }
                int i25 = layoutParams.bottomMargin + layoutParams.topMargin;
                int measuredHeight = b.getMeasuredHeight() + i25;
                int combineMeasuredStates = ViewUtils.combineMeasuredStates(i16, ViewCompat.getMeasuredState(b));
                if (z8) {
                    int baseline2 = b.getBaseline();
                    if (baseline2 != -1) {
                        int i26 = ((((layoutParams.gravity < 0 ? this.f2775e : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i26] = Math.max(iArr[i26], baseline2);
                        iArr2[i26] = Math.max(iArr2[i26], measuredHeight - baseline2);
                    }
                }
                int max2 = Math.max(i15, measuredHeight);
                z3 = z5 && layoutParams.height == -1;
                if (layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    i11 = Math.max(i18, z11 ? i25 : measuredHeight);
                    max = i17;
                } else {
                    if (!z11) {
                        i25 = measuredHeight;
                    }
                    max = Math.max(i17, i25);
                    i11 = i18;
                }
                i20 += mo5274a(b, i20);
                z4 = z7;
                i18 = i11;
                i17 = max;
                i12 = max2;
                i13 = i19;
                i14 = combineMeasuredStates;
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
        if (this.f2776f > 0 && mo5286c(virtualChildCount)) {
            this.f2776f += this.f2782l;
        }
        int max3 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i15 : Math.max(i15, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f2776f = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                View b2 = mo5281b(i27);
                if (b2 == null) {
                    this.f2776f += mo5287d(i27);
                    i10 = i27;
                } else if (b2.getVisibility() == 8) {
                    i10 = mo5274a(b2, i27) + i27;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) b2.getLayoutParams();
                    if (z10) {
                        this.f2776f = layoutParams2.rightMargin + layoutParams2.leftMargin + i19 + mo5280b(b2) + this.f2776f;
                        i10 = i27;
                    } else {
                        int i28 = this.f2776f;
                        this.f2776f = Math.max(i28, layoutParams2.rightMargin + i28 + i19 + layoutParams2.leftMargin + mo5280b(b2));
                        i10 = i27;
                    }
                }
                i27 = i10 + 1;
            }
        }
        this.f2776f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.f2776f, getSuggestedMinimumWidth()), i, 0);
        int i29 = (16777215 & resolveSizeAndState) - this.f2776f;
        if (z7 || (i29 != 0 && f3 > BitmapDescriptorFactory.HUE_RED)) {
            if (this.f2777g > BitmapDescriptorFactory.HUE_RED) {
                f3 = this.f2777g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f2776f = 0;
            int i30 = 0;
            float f5 = f3;
            boolean z12 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i29;
            int i34 = -1;
            while (i30 < virtualChildCount) {
                View b3 = mo5281b(i30);
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
                    LayoutParams layoutParams3 = (LayoutParams) b3.getLayoutParams();
                    float f6 = layoutParams3.weight;
                    if (f6 > BitmapDescriptorFactory.HUE_RED) {
                        int i35 = (int) ((((float) i33) * f6) / f5);
                        float f7 = f5 - f6;
                        i8 = i33 - i35;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0 && mode == 1073741824) {
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
                        i9 = ViewUtils.combineMeasuredStates(i32, ViewCompat.getMeasuredState(b3) & ViewCompat.MEASURED_STATE_MASK);
                        f2 = f7;
                    } else {
                        i8 = i33;
                        i9 = i32;
                        f2 = f5;
                    }
                    if (z10) {
                        this.f2776f += b3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + mo5280b(b3);
                    } else {
                        int i36 = this.f2776f;
                        this.f2776f = Math.max(i36, b3.getMeasuredWidth() + i36 + layoutParams3.leftMargin + layoutParams3.rightMargin + mo5280b(b3));
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i37 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = b3.getMeasuredHeight() + i37;
                    int max4 = Math.max(i34, measuredHeight2);
                    int max5 = Math.max(i31, z13 ? i37 : measuredHeight2);
                    boolean z14 = z12 && layoutParams3.height == -1;
                    if (z8 && (baseline = b3.getBaseline()) != -1) {
                        int i38 = ((((layoutParams3.gravity < 0 ? this.f2775e : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
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
            this.f2776f += getPaddingLeft() + getPaddingRight();
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
                    View b4 = mo5281b(i40);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((LayoutParams) b4.getLayoutParams()).weight <= BitmapDescriptorFactory.HUE_RED)) {
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
        setMeasuredDimension((-16777216 & i16) | resolveSizeAndState, ViewCompat.resolveSizeAndState(Math.max(i4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i16 << 16));
        if (z6) {
            m1841d(virtualChildCount, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5283b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i9 = i4 - i2;
        int paddingBottom = i9 - getPaddingBottom();
        int paddingBottom2 = (i9 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.f2775e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i11 = this.f2775e & 112;
        boolean z = this.f2771a;
        int[] iArr = this.f2779i;
        int[] iArr2 = this.f2780j;
        switch (GravityCompat.getAbsoluteGravity(i10, ViewCompat.getLayoutDirection(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f2776f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f2776f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (isLayoutRtl) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i12 = 0;
        while (i12 < virtualChildCount) {
            int i13 = i6 + (i5 * i12);
            View b = mo5281b(i13);
            if (b == null) {
                paddingLeft += mo5287d(i13);
                i7 = i12;
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                int baseline = (!z || layoutParams.height == -1) ? -1 : b.getBaseline();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i11;
                }
                switch (i14 & 112) {
                    case 16:
                        i8 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i8 = paddingTop + layoutParams.topMargin;
                        if (baseline != -1) {
                            i8 += iArr[1] - baseline;
                            break;
                        }
                        break;
                    case 80:
                        i8 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (baseline != -1) {
                            i8 -= iArr2[2] - (b.getMeasuredHeight() - baseline);
                            break;
                        }
                        break;
                    default:
                        i8 = paddingTop;
                        break;
                }
                int i15 = (mo5286c(i13) ? this.f2782l + paddingLeft : paddingLeft) + layoutParams.leftMargin;
                m1839a(b, i15 + mo5273a(b), i8, measuredWidth, measuredHeight);
                paddingLeft = i15 + layoutParams.rightMargin + measuredWidth + mo5280b(b);
                i7 = mo5274a(b, i13) + i12;
            } else {
                i7 = i12;
            }
            i12 = i7 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5284b(Canvas canvas) {
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View b = mo5281b(i);
            if (!(b == null || b.getVisibility() == 8 || !mo5286c(i))) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                mo5285b(canvas, isLayoutRtl ? layoutParams.rightMargin + b.getRight() : (b.getLeft() - layoutParams.leftMargin) - this.f2782l);
            }
        }
        if (mo5286c(virtualChildCount)) {
            View b2 = mo5281b(virtualChildCount - 1);
            if (b2 == null) {
                left = isLayoutRtl ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f2782l;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) b2.getLayoutParams();
                left = isLayoutRtl ? (b2.getLeft() - layoutParams2.leftMargin) - this.f2782l : layoutParams2.rightMargin + b2.getRight();
            }
            mo5285b(canvas, left);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5285b(Canvas canvas, int i) {
        this.f2781k.setBounds(i, getPaddingTop() + this.f2785o, this.f2782l + i, (getHeight() - getPaddingBottom()) - this.f2785o);
        this.f2781k.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo5286c(int i) {
        if (i == 0) {
            return (this.f2784n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f2784n & 4) != 0;
        }
        if ((this.f2784n & 2) == 0) {
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
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo5287d(int i) {
        return 0;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getBaseline() {
        int i;
        int i2;
        if (this.f2772b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f2772b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f2772b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i3 = this.f2773c;
            if (this.f2774d == 1 && (i2 = this.f2775e & 112) != 48) {
                switch (i2) {
                    case 16:
                        i = i3 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2776f) / 2);
                        break;
                    case 80:
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2776f;
                        break;
                }
            }
            i = i3;
            return ((LayoutParams) childAt.getLayoutParams()).topMargin + i + baseline;
        } else if (this.f2772b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2772b;
    }

    public Drawable getDividerDrawable() {
        return this.f2781k;
    }

    public int getDividerPadding() {
        return this.f2785o;
    }

    public int getDividerWidth() {
        return this.f2782l;
    }

    public int getOrientation() {
        return this.f2774d;
    }

    public int getShowDividers() {
        return this.f2784n;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2777g;
    }

    public boolean isBaselineAligned() {
        return this.f2771a;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.f2778h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f2781k != null) {
            if (this.f2774d == 1) {
                mo5277a(canvas);
            } else {
                mo5284b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2774d == 1) {
            mo5276a(i, i2, i3, i4);
        } else {
            mo5283b(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2774d == 1) {
            mo5275a(i, i2);
        } else {
            mo5282b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f2771a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f2772b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f2781k) {
            this.f2781k = drawable;
            if (drawable != null) {
                this.f2782l = drawable.getIntrinsicWidth();
                this.f2783m = drawable.getIntrinsicHeight();
            } else {
                this.f2782l = 0;
                this.f2783m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f2785o = i;
    }

    public void setGravity(int i) {
        if (this.f2775e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f2775e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.f2775e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != i2) {
            this.f2775e = i2 | (this.f2775e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f2778h = z;
    }

    public void setOrientation(int i) {
        if (this.f2774d != i) {
            this.f2774d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f2784n) {
            requestLayout();
        }
        this.f2784n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f2775e & 112) != i2) {
            this.f2775e = i2 | (this.f2775e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f2777g = Math.max(BitmapDescriptorFactory.HUE_RED, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
