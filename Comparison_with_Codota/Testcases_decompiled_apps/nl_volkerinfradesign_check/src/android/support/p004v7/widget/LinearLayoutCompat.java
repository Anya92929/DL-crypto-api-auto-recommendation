package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.view.InputDeviceCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p004v7.appcompat.C0505R;
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
    private boolean f2076a;

    /* renamed from: b */
    private int f2077b;

    /* renamed from: c */
    private int f2078c;

    /* renamed from: d */
    private int f2079d;

    /* renamed from: e */
    private int f2080e;

    /* renamed from: f */
    private int f2081f;

    /* renamed from: g */
    private float f2082g;

    /* renamed from: h */
    private boolean f2083h;

    /* renamed from: i */
    private int[] f2084i;

    /* renamed from: j */
    private int[] f2085j;

    /* renamed from: k */
    private Drawable f2086k;

    /* renamed from: l */
    private int f2087l;

    /* renamed from: m */
    private int f2088m;

    /* renamed from: n */
    private int f2089n;

    /* renamed from: o */
    private int f2090o;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v7.widget.LinearLayoutCompat$DividerMode */
    public @interface DividerMode {
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
        this.f2076a = true;
        this.f2077b = -1;
        this.f2078c = 0;
        this.f2080e = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0505R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(C0505R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(C0505R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(C0505R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f2082g = obtainStyledAttributes.getFloat(C0505R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f2077b = obtainStyledAttributes.getInt(C0505R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f2083h = obtainStyledAttributes.getBoolean(C0505R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.LinearLayoutCompat_divider));
        this.f2089n = obtainStyledAttributes.getInt(C0505R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f2090o = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.f2089n) {
            requestLayout();
        }
        this.f2089n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f2089n;
    }

    public Drawable getDividerDrawable() {
        return this.f2086k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f2086k) {
            this.f2086k = drawable;
            if (drawable != null) {
                this.f2087l = drawable.getIntrinsicWidth();
                this.f2088m = drawable.getIntrinsicHeight();
            } else {
                this.f2087l = 0;
                this.f2088m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f2090o = i;
    }

    public int getDividerPadding() {
        return this.f2090o;
    }

    public int getDividerWidth() {
        return this.f2087l;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f2086k != null) {
            if (this.f2079d == 1) {
                mo4262a(canvas);
            } else {
                mo4269b(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4262a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View a = mo4259a(i);
            if (!(a == null || a.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                mo4263a(canvas, (a.getTop() - ((LayoutParams) a.getLayoutParams()).topMargin) - this.f2088m);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View a2 = mo4259a(virtualChildCount - 1);
            if (a2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f2088m;
            } else {
                bottom = ((LayoutParams) a2.getLayoutParams()).bottomMargin + a2.getBottom();
            }
            mo4263a(canvas, bottom);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4269b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View a = mo4259a(i);
            if (!(a == null || a.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                if (isLayoutRtl) {
                    left = layoutParams.rightMargin + a.getRight();
                } else {
                    left = (a.getLeft() - layoutParams.leftMargin) - this.f2087l;
                }
                mo4270b(canvas, left);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View a2 = mo4259a(virtualChildCount - 1);
            if (a2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) a2.getLayoutParams();
                if (isLayoutRtl) {
                    right = (a2.getLeft() - layoutParams2.leftMargin) - this.f2087l;
                } else {
                    right = layoutParams2.rightMargin + a2.getRight();
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f2087l;
            }
            mo4270b(canvas, right);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4263a(Canvas canvas, int i) {
        this.f2086k.setBounds(getPaddingLeft() + this.f2090o, i, (getWidth() - getPaddingRight()) - this.f2090o, this.f2088m + i);
        this.f2086k.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4270b(Canvas canvas, int i) {
        this.f2086k.setBounds(i, getPaddingTop() + this.f2090o, this.f2087l + i, (getHeight() - getPaddingBottom()) - this.f2090o);
        this.f2086k.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.f2076a;
    }

    public void setBaselineAligned(boolean z) {
        this.f2076a = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.f2083h;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f2083h = z;
    }

    public int getBaseline() {
        int i;
        int i2;
        if (this.f2077b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f2077b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f2077b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i3 = this.f2078c;
            if (this.f2079d == 1 && (i2 = this.f2080e & 112) != 48) {
                switch (i2) {
                    case 16:
                        i = i3 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2081f) / 2);
                        break;
                    case 80:
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2081f;
                        break;
                }
            }
            i = i3;
            return ((LayoutParams) childAt.getLayoutParams()).topMargin + i + baseline;
        } else if (this.f2077b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2077b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f2077b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo4259a(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2082g;
    }

    public void setWeightSum(float f) {
        this.f2082g = Math.max(BitmapDescriptorFactory.HUE_RED, f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2079d == 1) {
            mo4260a(i, i2);
        } else {
            mo4267b(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.f2089n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f2089n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f2089n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4260a(int i, int i2) {
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
        int i15;
        this.f2081f = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        boolean z5 = true;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        int i20 = this.f2077b;
        boolean z8 = this.f2083h;
        int i21 = ExploreByTouchHelper.INVALID_ID;
        int i22 = 0;
        while (i22 < virtualChildCount) {
            View a = mo4259a(i22);
            if (a == null) {
                this.f2081f += mo4265b(i22);
                i13 = i21;
                z4 = z7;
                z3 = z5;
                i14 = i17;
                i12 = i16;
            } else if (a.getVisibility() == 8) {
                i22 += mo4258a(a, i22);
                i13 = i21;
                z4 = z7;
                z3 = z5;
                i14 = i17;
                i12 = i16;
            } else {
                if (hasDividerBeforeChildAt(i22)) {
                    this.f2081f += this.f2088m;
                }
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                float f3 = f2 + layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    int i23 = this.f2081f;
                    this.f2081f = Math.max(i23, layoutParams.topMargin + i23 + layoutParams.bottomMargin);
                    z7 = true;
                } else {
                    int i24 = ExploreByTouchHelper.INVALID_ID;
                    if (layoutParams.height == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                        i24 = 0;
                        layoutParams.height = -2;
                    }
                    int i25 = i24;
                    mo4264a(a, i22, i, 0, i2, f3 == BitmapDescriptorFactory.HUE_RED ? this.f2081f : 0);
                    if (i25 != Integer.MIN_VALUE) {
                        layoutParams.height = i25;
                    }
                    int measuredHeight = a.getMeasuredHeight();
                    int i26 = this.f2081f;
                    this.f2081f = Math.max(i26, i26 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + mo4266b(a));
                    if (z8) {
                        i21 = Math.max(measuredHeight, i21);
                    }
                }
                if (i20 >= 0 && i20 == i22 + 1) {
                    this.f2078c = this.f2081f;
                }
                if (i22 >= i20 || layoutParams.weight <= BitmapDescriptorFactory.HUE_RED) {
                    boolean z9 = false;
                    if (mode == 1073741824 || layoutParams.width != -1) {
                        z2 = z6;
                    } else {
                        z2 = true;
                        z9 = true;
                    }
                    int i27 = layoutParams.rightMargin + layoutParams.leftMargin;
                    int measuredWidth = a.getMeasuredWidth() + i27;
                    int max2 = Math.max(i16, measuredWidth);
                    int combineMeasuredStates = ViewUtils.combineMeasuredStates(i17, ViewCompat.getMeasuredState(a));
                    z3 = z5 && layoutParams.width == -1;
                    if (layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                        if (z9) {
                            i15 = i27;
                        } else {
                            i15 = measuredWidth;
                        }
                        i11 = Math.max(i19, i15);
                        max = i18;
                    } else {
                        if (!z9) {
                            i27 = measuredWidth;
                        }
                        max = Math.max(i18, i27);
                        i11 = i19;
                    }
                    i22 += mo4258a(a, i22);
                    z4 = z7;
                    i19 = i11;
                    i18 = max;
                    i12 = max2;
                    i13 = i21;
                    i14 = combineMeasuredStates;
                    z6 = z2;
                    f2 = f3;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i22++;
            i21 = i13;
            z7 = z4;
            z5 = z3;
            i17 = i14;
            i16 = i12;
        }
        if (this.f2081f > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.f2081f += this.f2088m;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f2081f = 0;
            int i28 = 0;
            while (i28 < virtualChildCount) {
                View a2 = mo4259a(i28);
                if (a2 == null) {
                    this.f2081f += mo4265b(i28);
                    i10 = i28;
                } else if (a2.getVisibility() == 8) {
                    i10 = mo4258a(a2, i28) + i28;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) a2.getLayoutParams();
                    int i29 = this.f2081f;
                    this.f2081f = Math.max(i29, layoutParams2.bottomMargin + i29 + i21 + layoutParams2.topMargin + mo4266b(a2));
                    i10 = i28;
                }
                i28 = i10 + 1;
            }
        }
        this.f2081f += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.f2081f, getSuggestedMinimumHeight()), i2, 0);
        int i30 = (16777215 & resolveSizeAndState) - this.f2081f;
        if (z7 || (i30 != 0 && f2 > BitmapDescriptorFactory.HUE_RED)) {
            if (this.f2082g > BitmapDescriptorFactory.HUE_RED) {
                f2 = this.f2082g;
            }
            this.f2081f = 0;
            int i31 = 0;
            float f4 = f2;
            boolean z10 = z5;
            int i32 = i18;
            int i33 = i17;
            int i34 = i16;
            int i35 = i30;
            while (i31 < virtualChildCount) {
                View a3 = mo4259a(i31);
                if (a3.getVisibility() == 8) {
                    i7 = i32;
                    i9 = i33;
                    i8 = i34;
                    z = z10;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) a3.getLayoutParams();
                    float f5 = layoutParams3.weight;
                    if (f5 > BitmapDescriptorFactory.HUE_RED) {
                        int i36 = (int) ((((float) i35) * f5) / f4);
                        float f6 = f4 - f5;
                        int i37 = i35 - i36;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height == 0 && mode2 == 1073741824) {
                            if (i36 <= 0) {
                                i36 = 0;
                            }
                            a3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i36, 1073741824));
                        } else {
                            int measuredHeight2 = i36 + a3.getMeasuredHeight();
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            a3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                        }
                        float f7 = f6;
                        i5 = i37;
                        i6 = ViewUtils.combineMeasuredStates(i33, ViewCompat.getMeasuredState(a3) & InputDeviceCompat.SOURCE_ANY);
                        f = f7;
                    } else {
                        f = f4;
                        i5 = i35;
                        i6 = i33;
                    }
                    int i38 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int measuredWidth2 = a3.getMeasuredWidth() + i38;
                    int max3 = Math.max(i34, measuredWidth2);
                    if (!(mode != 1073741824 && layoutParams3.width == -1)) {
                        i38 = measuredWidth2;
                    }
                    int max4 = Math.max(i32, i38);
                    z = z10 && layoutParams3.width == -1;
                    int i39 = this.f2081f;
                    this.f2081f = Math.max(i39, layoutParams3.bottomMargin + a3.getMeasuredHeight() + i39 + layoutParams3.topMargin + mo4266b(a3));
                    i7 = max4;
                    i8 = max3;
                    float f8 = f;
                    i9 = i6;
                    i35 = i5;
                    f4 = f8;
                }
                i31++;
                i32 = i7;
                i34 = i8;
                z10 = z;
                i33 = i9;
            }
            this.f2081f += getPaddingTop() + getPaddingBottom();
            z5 = z10;
            i4 = i32;
            i17 = i33;
            i3 = i34;
        } else {
            int max5 = Math.max(i18, i19);
            if (z8 && mode2 != 1073741824) {
                int i40 = 0;
                while (true) {
                    int i41 = i40;
                    if (i41 >= virtualChildCount) {
                        break;
                    }
                    View a4 = mo4259a(i41);
                    if (!(a4 == null || a4.getVisibility() == 8 || ((LayoutParams) a4.getLayoutParams()).weight <= BitmapDescriptorFactory.HUE_RED)) {
                        a4.measure(View.MeasureSpec.makeMeasureSpec(a4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i21, 1073741824));
                    }
                    i40 = i41 + 1;
                }
            }
            i4 = max5;
            i3 = i16;
        }
        if (z5 || mode == 1073741824) {
            i4 = i3;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i4 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i17), resolveSizeAndState);
        if (z6) {
            m3202c(virtualChildCount, i2);
        }
    }

    /* renamed from: c */
    private void m3202c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View a = mo4259a(i3);
            if (a.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = a.getMeasuredHeight();
                    measureChildWithMargins(a, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4267b(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        float f2;
        int i11;
        int baseline;
        int i12;
        boolean z3;
        boolean z4;
        int max;
        int i13;
        boolean z5;
        int i14;
        int i15;
        int i16;
        int i17;
        this.f2081f = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        boolean z6 = true;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z7 = false;
        boolean z8 = false;
        if (this.f2084i == null || this.f2085j == null) {
            this.f2084i = new int[4];
            this.f2085j = new int[4];
        }
        int[] iArr = this.f2084i;
        int[] iArr2 = this.f2085j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z9 = this.f2076a;
        boolean z10 = this.f2083h;
        if (mode == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        int i22 = ExploreByTouchHelper.INVALID_ID;
        int i23 = 0;
        while (i23 < virtualChildCount) {
            View a = mo4259a(i23);
            if (a == null) {
                this.f2081f += mo4265b(i23);
                i15 = i22;
                z5 = z8;
                z4 = z6;
                i16 = i19;
                i14 = i18;
            } else if (a.getVisibility() == 8) {
                i23 += mo4258a(a, i23);
                i15 = i22;
                z5 = z8;
                z4 = z6;
                i16 = i19;
                i14 = i18;
            } else {
                if (hasDividerBeforeChildAt(i23)) {
                    this.f2081f += this.f2087l;
                }
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                float f4 = f3 + layoutParams.weight;
                if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    if (z) {
                        this.f2081f += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        int i24 = this.f2081f;
                        this.f2081f = Math.max(i24, layoutParams.leftMargin + i24 + layoutParams.rightMargin);
                    }
                    if (z9) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    } else {
                        z8 = true;
                    }
                } else {
                    int i25 = ExploreByTouchHelper.INVALID_ID;
                    if (layoutParams.width == 0 && layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                        i25 = 0;
                        layoutParams.width = -2;
                    }
                    int i26 = i25;
                    mo4264a(a, i23, i, f4 == BitmapDescriptorFactory.HUE_RED ? this.f2081f : 0, i2, 0);
                    if (i26 != Integer.MIN_VALUE) {
                        layoutParams.width = i26;
                    }
                    int measuredWidth = a.getMeasuredWidth();
                    if (z) {
                        this.f2081f += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + mo4266b(a);
                    } else {
                        int i27 = this.f2081f;
                        this.f2081f = Math.max(i27, i27 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + mo4266b(a));
                    }
                    if (z10) {
                        i22 = Math.max(measuredWidth, i22);
                    }
                }
                boolean z11 = false;
                if (mode2 == 1073741824 || layoutParams.height != -1) {
                    z3 = z7;
                } else {
                    z3 = true;
                    z11 = true;
                }
                int i28 = layoutParams.bottomMargin + layoutParams.topMargin;
                int measuredHeight = a.getMeasuredHeight() + i28;
                int combineMeasuredStates = ViewUtils.combineMeasuredStates(i19, ViewCompat.getMeasuredState(a));
                if (z9) {
                    int baseline2 = a.getBaseline();
                    if (baseline2 != -1) {
                        int i29 = ((((layoutParams.gravity < 0 ? this.f2080e : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i29] = Math.max(iArr[i29], baseline2);
                        iArr2[i29] = Math.max(iArr2[i29], measuredHeight - baseline2);
                    }
                }
                int max2 = Math.max(i18, measuredHeight);
                z4 = z6 && layoutParams.height == -1;
                if (layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    if (z11) {
                        i17 = i28;
                    } else {
                        i17 = measuredHeight;
                    }
                    i13 = Math.max(i21, i17);
                    max = i20;
                } else {
                    if (!z11) {
                        i28 = measuredHeight;
                    }
                    max = Math.max(i20, i28);
                    i13 = i21;
                }
                i23 += mo4258a(a, i23);
                z5 = z8;
                i21 = i13;
                i20 = max;
                i14 = max2;
                i15 = i22;
                i16 = combineMeasuredStates;
                z7 = z3;
                f3 = f4;
            }
            i23++;
            i22 = i15;
            z8 = z5;
            z6 = z4;
            i19 = i16;
            i18 = i14;
        }
        if (this.f2081f > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.f2081f += this.f2087l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i3 = i18;
        } else {
            i3 = Math.max(i18, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z10 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f2081f = 0;
            int i30 = 0;
            while (i30 < virtualChildCount) {
                View a2 = mo4259a(i30);
                if (a2 == null) {
                    this.f2081f += mo4265b(i30);
                    i12 = i30;
                } else if (a2.getVisibility() == 8) {
                    i12 = mo4258a(a2, i30) + i30;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) a2.getLayoutParams();
                    if (z) {
                        this.f2081f = layoutParams2.rightMargin + layoutParams2.leftMargin + i22 + mo4266b(a2) + this.f2081f;
                        i12 = i30;
                    } else {
                        int i31 = this.f2081f;
                        this.f2081f = Math.max(i31, layoutParams2.rightMargin + i31 + i22 + layoutParams2.leftMargin + mo4266b(a2));
                        i12 = i30;
                    }
                }
                i30 = i12 + 1;
            }
        }
        this.f2081f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.f2081f, getSuggestedMinimumWidth()), i, 0);
        int i32 = (16777215 & resolveSizeAndState) - this.f2081f;
        if (z8 || (i32 != 0 && f3 > BitmapDescriptorFactory.HUE_RED)) {
            if (this.f2082g > BitmapDescriptorFactory.HUE_RED) {
                f3 = this.f2082g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f2081f = 0;
            int i33 = 0;
            float f5 = f3;
            boolean z12 = z6;
            int i34 = i20;
            int i35 = i19;
            int i36 = i32;
            int i37 = -1;
            while (i33 < virtualChildCount) {
                View a3 = mo4259a(i33);
                if (a3 == null) {
                    f = f5;
                    i6 = i36;
                    i7 = i37;
                    i8 = i34;
                    z2 = z12;
                } else if (a3.getVisibility() == 8) {
                    f = f5;
                    i6 = i36;
                    i7 = i37;
                    i8 = i34;
                    z2 = z12;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) a3.getLayoutParams();
                    float f6 = layoutParams3.weight;
                    if (f6 > BitmapDescriptorFactory.HUE_RED) {
                        int i38 = (int) ((((float) i36) * f6) / f5);
                        float f7 = f5 - f6;
                        i9 = i36 - i38;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0 && mode == 1073741824) {
                            if (i38 <= 0) {
                                i38 = 0;
                            }
                            a3.measure(View.MeasureSpec.makeMeasureSpec(i38, 1073741824), childMeasureSpec);
                        } else {
                            int measuredWidth2 = i38 + a3.getMeasuredWidth();
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            a3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        }
                        i10 = ViewUtils.combineMeasuredStates(i35, ViewCompat.getMeasuredState(a3) & ViewCompat.MEASURED_STATE_MASK);
                        f2 = f7;
                    } else {
                        i9 = i36;
                        i10 = i35;
                        f2 = f5;
                    }
                    if (z) {
                        this.f2081f += a3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + mo4266b(a3);
                    } else {
                        int i39 = this.f2081f;
                        this.f2081f = Math.max(i39, a3.getMeasuredWidth() + i39 + layoutParams3.leftMargin + layoutParams3.rightMargin + mo4266b(a3));
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i40 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = a3.getMeasuredHeight() + i40;
                    int max3 = Math.max(i37, measuredHeight2);
                    if (z13) {
                        i11 = i40;
                    } else {
                        i11 = measuredHeight2;
                    }
                    int max4 = Math.max(i34, i11);
                    boolean z14 = z12 && layoutParams3.height == -1;
                    if (z9 && (baseline = a3.getBaseline()) != -1) {
                        int i41 = ((((layoutParams3.gravity < 0 ? this.f2080e : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i41] = Math.max(iArr[i41], baseline);
                        iArr2[i41] = Math.max(iArr2[i41], measuredHeight2 - baseline);
                    }
                    f = f2;
                    i8 = max4;
                    z2 = z14;
                    i35 = i10;
                    i6 = i9;
                    i7 = max3;
                }
                i33++;
                i34 = i8;
                i37 = i7;
                z12 = z2;
                i36 = i6;
                f5 = f;
            }
            this.f2081f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i37 = Math.max(i37, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z6 = z12;
            i5 = i34;
            i19 = i35;
            i4 = i37;
        } else {
            int max5 = Math.max(i20, i21);
            if (z10 && mode != 1073741824) {
                int i42 = 0;
                while (true) {
                    int i43 = i42;
                    if (i43 >= virtualChildCount) {
                        break;
                    }
                    View a4 = mo4259a(i43);
                    if (!(a4 == null || a4.getVisibility() == 8 || ((LayoutParams) a4.getLayoutParams()).weight <= BitmapDescriptorFactory.HUE_RED)) {
                        a4.measure(View.MeasureSpec.makeMeasureSpec(i22, 1073741824), View.MeasureSpec.makeMeasureSpec(a4.getMeasuredHeight(), 1073741824));
                    }
                    i42 = i43 + 1;
                }
            }
            i5 = max5;
            i4 = i3;
        }
        if (z6 || mode2 == 1073741824) {
            i5 = i4;
        }
        setMeasuredDimension((-16777216 & i19) | resolveSizeAndState, ViewCompat.resolveSizeAndState(Math.max(i5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i19 << 16));
        if (z7) {
            m3203d(virtualChildCount, i);
        }
    }

    /* renamed from: d */
    private void m3203d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View a = mo4259a(i3);
            if (a.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = a.getMeasuredWidth();
                    measureChildWithMargins(a, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo4258a(View view, int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo4265b(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4264a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo4257a(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo4266b(View view) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2079d == 1) {
            mo4261a(i, i2, i3, i4);
        } else {
            mo4268b(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4261a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.f2080e & 112;
        int i10 = this.f2080e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i9) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f2081f) / 2);
                break;
            case 80:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.f2081f;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i11 = 0;
        int i12 = paddingTop;
        while (i11 < virtualChildCount) {
            View a = mo4259a(i11);
            if (a == null) {
                i12 += mo4265b(i11);
                i5 = i11;
            } else if (a.getVisibility() != 8) {
                int measuredWidth = a.getMeasuredWidth();
                int measuredHeight = a.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                int i13 = layoutParams.gravity;
                if (i13 < 0) {
                    i13 = i10;
                }
                switch (GravityCompat.getAbsoluteGravity(i13, ViewCompat.getLayoutDirection(this)) & 7) {
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
                if (hasDividerBeforeChildAt(i11)) {
                    i7 = this.f2088m + i12;
                } else {
                    i7 = i12;
                }
                int i14 = i7 + layoutParams.topMargin;
                m3201a(a, i6, i14 + mo4257a(a), measuredWidth, measuredHeight);
                i12 = i14 + layoutParams.bottomMargin + measuredHeight + mo4266b(a);
                i5 = mo4258a(a, i11) + i11;
            } else {
                i5 = i11;
            }
            i11 = i5 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4268b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i11 = i4 - i2;
        int paddingBottom = i11 - getPaddingBottom();
        int paddingBottom2 = (i11 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i12 = this.f2080e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i13 = this.f2080e & 112;
        boolean z = this.f2076a;
        int[] iArr = this.f2084i;
        int[] iArr2 = this.f2085j;
        switch (GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f2081f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f2081f;
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
        int i14 = 0;
        while (i14 < virtualChildCount) {
            int i15 = i6 + (i5 * i14);
            View a = mo4259a(i15);
            if (a == null) {
                paddingLeft += mo4265b(i15);
                i7 = i14;
            } else if (a.getVisibility() != 8) {
                int measuredWidth = a.getMeasuredWidth();
                int measuredHeight = a.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                if (!z || layoutParams.height == -1) {
                    i8 = -1;
                } else {
                    i8 = a.getBaseline();
                }
                int i16 = layoutParams.gravity;
                if (i16 < 0) {
                    i16 = i13;
                }
                switch (i16 & 112) {
                    case 16:
                        i9 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i9 = paddingTop + layoutParams.topMargin;
                        if (i8 != -1) {
                            i9 += iArr[1] - i8;
                            break;
                        }
                        break;
                    case 80:
                        i9 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (i8 != -1) {
                            i9 -= iArr2[2] - (a.getMeasuredHeight() - i8);
                            break;
                        }
                        break;
                    default:
                        i9 = paddingTop;
                        break;
                }
                if (hasDividerBeforeChildAt(i15)) {
                    i10 = this.f2087l + paddingLeft;
                } else {
                    i10 = paddingLeft;
                }
                int i17 = i10 + layoutParams.leftMargin;
                m3201a(a, i17 + mo4257a(a), i9, measuredWidth, measuredHeight);
                paddingLeft = i17 + layoutParams.rightMargin + measuredWidth + mo4266b(a);
                i7 = mo4258a(a, i15) + i14;
            } else {
                i7 = i14;
            }
            i14 = i7 + 1;
        }
    }

    /* renamed from: a */
    private void m3201a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f2079d != i) {
            this.f2079d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f2079d;
    }

    public void setGravity(int i) {
        int i2;
        if (this.f2080e != i) {
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f2080e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.f2080e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != i2) {
            this.f2080e = i2 | (this.f2080e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f2080e & 112) != i2) {
            this.f2080e = i2 | (this.f2080e & -113);
            requestLayout();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.f2079d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.f2079d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
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

    /* renamed from: android.support.v7.widget.LinearLayoutCompat$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(C0505R.styleable.LinearLayoutCompat_Layout_android_layout_weight, BitmapDescriptorFactory.HUE_RED);
            this.gravity = obtainStyledAttributes.getInt(C0505R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

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

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }
}
