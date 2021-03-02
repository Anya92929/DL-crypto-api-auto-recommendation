package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0137R;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.support.p003v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v7.widget.LinearLayoutCompat */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

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
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0137R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(C0137R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(C0137R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
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
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0137R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(C0137R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(C0137R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(C0137R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(C0137R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(C0137R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(C0137R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(C0137R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(C0137R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(C0137R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? layoutParams.rightMargin + virtualChildAt.getRight() : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                left = isLayoutRtl ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                left = isLayoutRtl ? (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth : layoutParams2.rightMargin + virtualChildAt2.getRight();
            }
            drawVerticalDivider(canvas, left);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin + virtualChildAt2.getBottom();
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        int i;
        int i2;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i3 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i2 = this.mGravity & 112) != 48) {
                switch (i2) {
                    case 16:
                        i = i3 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
                        break;
                    case C0137R.styleable.Theme_listChoiceBackgroundIndicator:
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                        break;
                }
            }
            i = i3;
            return ((LayoutParams) childAt.getLayoutParams()).topMargin + i + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* access modifiers changed from: package-private */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
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
        int i10 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i11 = this.mGravity & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        switch (GravityCompat.getAbsoluteGravity(i10, ViewCompat.getLayoutDirection(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
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
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i13);
                i7 = i12;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int baseline = (!z || layoutParams.height == -1) ? -1 : virtualChildAt.getBaseline();
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
                    case C0137R.styleable.Theme_listChoiceBackgroundIndicator:
                        i8 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (baseline != -1) {
                            i8 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline);
                            break;
                        }
                        break;
                    default:
                        i8 = paddingTop;
                        break;
                }
                int i15 = (hasDividerBeforeChildAt(i13) ? this.mDividerWidth + paddingLeft : paddingLeft) + layoutParams.leftMargin;
                setChildFrame(virtualChildAt, i15 + getLocationOffset(virtualChildAt), i8, measuredWidth, measuredHeight);
                paddingLeft = i15 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                i7 = getChildrenSkipCount(virtualChildAt, i13) + i12;
            } else {
                i7 = i12;
            }
            i12 = i7 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.mGravity & 112;
        int i9 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i8) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
                break;
            case C0137R.styleable.Theme_listChoiceBackgroundIndicator:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i10 = 0;
        int i11 = paddingTop;
        while (i10 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt == null) {
                i11 += measureNullChild(i10);
                i5 = i10;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
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
                int i13 = (hasDividerBeforeChildAt(i10) ? this.mDividerHeight + i11 : i11) + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i6, i13 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i11 = i13 + layoutParams.bottomMargin + measuredHeight + getNextLocationOffset(virtualChildAt);
                i5 = getChildrenSkipCount(virtualChildAt, i10) + i10;
            } else {
                i5 = i10;
            }
            i10 = i5 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void measureHorizontal(int i, int i2) {
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
        float f2;
        int baseline;
        View view;
        int i11;
        int i12;
        float f3;
        boolean z2;
        int i13;
        int i14;
        boolean z3;
        int i15;
        int i16;
        boolean z4;
        this.mTotalLength = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        boolean z5 = true;
        float f4 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.mBaselineAligned;
        boolean z9 = this.mUseLargestChild;
        boolean z10 = mode == 1073741824;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        while (i22 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i22);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i22);
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i22)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f5 = f4 + layoutParams.weight;
                    if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        if (z10) {
                            this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            int i23 = this.mTotalLength;
                            this.mTotalLength = Math.max(i23, layoutParams.leftMargin + i23 + layoutParams.rightMargin);
                        }
                        if (z8) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        } else {
                            z7 = true;
                        }
                    } else {
                        int i24 = Integer.MIN_VALUE;
                        if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                            i24 = 0;
                            layoutParams.width = -2;
                        }
                        int i25 = i24;
                        measureChildBeforeLayout(virtualChildAt, i22, i, f5 == 0.0f ? this.mTotalLength : 0, i2, 0);
                        if (i25 != Integer.MIN_VALUE) {
                            layoutParams.width = i25;
                        }
                        int measuredWidth = virtualChildAt.getMeasuredWidth();
                        if (z10) {
                            this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                        } else {
                            int i26 = this.mTotalLength;
                            this.mTotalLength = Math.max(i26, i26 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt));
                        }
                        if (z9) {
                            i21 = Math.max(measuredWidth, i21);
                        }
                    }
                    boolean z11 = false;
                    if (mode2 == 1073741824 || layoutParams.height != -1) {
                        z4 = z6;
                    } else {
                        z4 = true;
                        z11 = true;
                    }
                    int i27 = layoutParams.bottomMargin + layoutParams.topMargin;
                    int measuredHeight = virtualChildAt.getMeasuredHeight() + i27;
                    int combineMeasuredStates = ViewUtils.combineMeasuredStates(i18, ViewCompat.getMeasuredState(virtualChildAt));
                    if (z8) {
                        int baseline2 = virtualChildAt.getBaseline();
                        if (baseline2 != -1) {
                            int i28 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i28] = Math.max(iArr[i28], baseline2);
                            iArr2[i28] = Math.max(iArr2[i28], measuredHeight - baseline2);
                        }
                    }
                    int max = Math.max(i17, measuredHeight);
                    boolean z12 = z5 && layoutParams.height == -1;
                    if (layoutParams.weight > 0.0f) {
                        int i29 = z11 ? i27 : measuredHeight;
                        z2 = z12;
                        i13 = Math.max(i20, i29);
                        i14 = i19;
                        f3 = f5;
                        i12 = i21;
                        i15 = combineMeasuredStates;
                        z6 = z4;
                        z3 = z7;
                        i16 = max;
                    } else {
                        if (!z11) {
                            i27 = measuredHeight;
                        }
                        int max2 = Math.max(i19, i27);
                        z2 = z12;
                        i13 = i20;
                        i14 = max2;
                        f3 = f5;
                        i12 = i21;
                        i15 = combineMeasuredStates;
                        z6 = z4;
                        z3 = z7;
                        i16 = max;
                    }
                } else {
                    i12 = i21;
                    f3 = f4;
                    z2 = z5;
                    i13 = i20;
                    i14 = i19;
                    z3 = z7;
                    i15 = i18;
                    i16 = i17;
                }
                i22 += getChildrenSkipCount(virtualChildAt, i22);
                z5 = z2;
                i20 = i13;
                i19 = i14;
                i18 = i15;
                i17 = i16;
                i21 = i12;
                z7 = z3;
                f4 = f3;
            }
            i22++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int max3 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i17 : Math.max(i17, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i30 = 0;
            while (i30 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i30);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i30);
                    i11 = i30;
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i11 = getChildrenSkipCount(virtualChildAt2, i30) + i30;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z10) {
                        this.mTotalLength = layoutParams2.rightMargin + layoutParams2.leftMargin + i21 + getNextLocationOffset(virtualChildAt2) + this.mTotalLength;
                        i11 = i30;
                    } else {
                        int i31 = this.mTotalLength;
                        this.mTotalLength = Math.max(i31, layoutParams2.rightMargin + i31 + i21 + layoutParams2.leftMargin + getNextLocationOffset(virtualChildAt2));
                        i11 = i30;
                    }
                }
                i30 = i11 + 1;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i32 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z7 || (i32 != 0 && f4 > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f4 = this.mWeightSum;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            int i33 = -1;
            this.mTotalLength = 0;
            float f6 = f4;
            boolean z13 = z5;
            int i34 = i19;
            int i35 = i18;
            int i36 = 0;
            while (i36 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i36);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    f = f6;
                    i5 = i32;
                    i6 = i34;
                    z = z13;
                    i7 = i35;
                    i8 = i33;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f7 = layoutParams3.weight;
                    if (f7 > 0.0f) {
                        int i37 = (int) ((((float) i32) * f7) / f6);
                        float f8 = f6 - f7;
                        int i38 = i32 - i37;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width != 0 || mode != 1073741824) {
                            i37 += virtualChildAt3.getMeasuredWidth();
                            if (i37 < 0) {
                                i37 = 0;
                            }
                            view = virtualChildAt3;
                        } else if (i37 > 0) {
                            view = virtualChildAt3;
                        } else {
                            i37 = 0;
                            view = virtualChildAt3;
                        }
                        view.measure(View.MeasureSpec.makeMeasureSpec(i37, 1073741824), childMeasureSpec);
                        i10 = ViewUtils.combineMeasuredStates(i35, ViewCompat.getMeasuredState(virtualChildAt3) & ViewCompat.MEASURED_STATE_MASK);
                        f2 = f8;
                        i9 = i38;
                    } else {
                        i9 = i32;
                        i10 = i35;
                        f2 = f6;
                    }
                    if (z10) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                    } else {
                        int i39 = this.mTotalLength;
                        this.mTotalLength = Math.max(i39, virtualChildAt3.getMeasuredWidth() + i39 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z14 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i40 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i40;
                    int max4 = Math.max(i33, measuredHeight2);
                    int max5 = Math.max(i34, z14 ? i40 : measuredHeight2);
                    boolean z15 = z13 && layoutParams3.height == -1;
                    if (z8 && (baseline = virtualChildAt3.getBaseline()) != -1) {
                        int i41 = ((((layoutParams3.gravity < 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i41] = Math.max(iArr[i41], baseline);
                        iArr2[i41] = Math.max(iArr2[i41], measuredHeight2 - baseline);
                    }
                    f = f2;
                    i6 = max5;
                    i7 = i10;
                    z = z15;
                    i8 = max4;
                    i5 = i9;
                }
                i36++;
                z13 = z;
                i34 = i6;
                i33 = i8;
                i35 = i7;
                f6 = f;
                i32 = i5;
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i33 = Math.max(i33, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z5 = z13;
            i4 = i34;
            i18 = i35;
            i3 = i33;
        } else {
            int max6 = Math.max(i19, i20);
            if (z9 && mode != 1073741824) {
                int i42 = 0;
                while (true) {
                    int i43 = i42;
                    if (i43 >= virtualChildCount) {
                        break;
                    }
                    View virtualChildAt4 = getVirtualChildAt(i43);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i21, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                    i42 = i43 + 1;
                }
            }
            i4 = max6;
            i3 = max3;
        }
        if (z5 || mode2 == 1073741824) {
            i4 = i3;
        }
        setMeasuredDimension((-16777216 & i18) | resolveSizeAndState, ViewCompat.resolveSizeAndState(Math.max(i4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i18 << 16));
        if (z6) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        float f;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        View view;
        int i9;
        int i10;
        float f2;
        boolean z2;
        int i11;
        int i12;
        boolean z3;
        int i13;
        int i14;
        boolean z4;
        this.mTotalLength = 0;
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
        int i19 = this.mBaselineAlignedChildIndex;
        boolean z8 = this.mUseLargestChild;
        int i20 = Integer.MIN_VALUE;
        int i21 = 0;
        while (i21 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i21);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i21);
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i21)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f4 = f3 + layoutParams.weight;
                    if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        int i22 = this.mTotalLength;
                        this.mTotalLength = Math.max(i22, layoutParams.topMargin + i22 + layoutParams.bottomMargin);
                        z7 = true;
                    } else {
                        int i23 = Integer.MIN_VALUE;
                        if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                            i23 = 0;
                            layoutParams.height = -2;
                        }
                        int i24 = i23;
                        measureChildBeforeLayout(virtualChildAt, i21, i, 0, i2, f4 == 0.0f ? this.mTotalLength : 0);
                        if (i24 != Integer.MIN_VALUE) {
                            layoutParams.height = i24;
                        }
                        int measuredHeight = virtualChildAt.getMeasuredHeight();
                        int i25 = this.mTotalLength;
                        this.mTotalLength = Math.max(i25, i25 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt));
                        if (z8) {
                            i20 = Math.max(measuredHeight, i20);
                        }
                    }
                    if (i19 >= 0 && i19 == i21 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i21 >= i19 || layoutParams.weight <= 0.0f) {
                        boolean z9 = false;
                        if (mode == 1073741824 || layoutParams.width != -1) {
                            z4 = z6;
                        } else {
                            z4 = true;
                            z9 = true;
                        }
                        int i26 = layoutParams.rightMargin + layoutParams.leftMargin;
                        int measuredWidth = virtualChildAt.getMeasuredWidth() + i26;
                        int max = Math.max(i15, measuredWidth);
                        int combineMeasuredStates = ViewUtils.combineMeasuredStates(i16, ViewCompat.getMeasuredState(virtualChildAt));
                        boolean z10 = z5 && layoutParams.width == -1;
                        if (layoutParams.weight > 0.0f) {
                            int i27 = z9 ? i26 : measuredWidth;
                            z2 = z10;
                            i11 = Math.max(i18, i27);
                            i12 = i17;
                            f2 = f4;
                            i10 = i20;
                            i13 = combineMeasuredStates;
                            z6 = z4;
                            z3 = z7;
                            i14 = max;
                        } else {
                            if (!z9) {
                                i26 = measuredWidth;
                            }
                            int max2 = Math.max(i17, i26);
                            z2 = z10;
                            i11 = i18;
                            i12 = max2;
                            f2 = f4;
                            i10 = i20;
                            i13 = combineMeasuredStates;
                            z6 = z4;
                            z3 = z7;
                            i14 = max;
                        }
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                } else {
                    i10 = i20;
                    f2 = f3;
                    z2 = z5;
                    i11 = i18;
                    i12 = i17;
                    z3 = z7;
                    i13 = i16;
                    i14 = i15;
                }
                i21 += getChildrenSkipCount(virtualChildAt, i21);
                z5 = z2;
                i18 = i11;
                i17 = i12;
                i16 = i13;
                i15 = i14;
                i20 = i10;
                z7 = z3;
                f3 = f2;
            }
            i21++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.mTotalLength = 0;
            int i28 = 0;
            while (i28 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i28);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i28);
                    i9 = i28;
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i9 = getChildrenSkipCount(virtualChildAt2, i28) + i28;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    int i29 = this.mTotalLength;
                    this.mTotalLength = Math.max(i29, layoutParams2.bottomMargin + i29 + i20 + layoutParams2.topMargin + getNextLocationOffset(virtualChildAt2));
                    i9 = i28;
                }
                i28 = i9 + 1;
            }
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        int i30 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z7 || (i30 != 0 && f3 > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f3 = this.mWeightSum;
            }
            this.mTotalLength = 0;
            boolean z11 = z5;
            int i31 = i17;
            int i32 = i16;
            int i33 = i15;
            int i34 = 0;
            int i35 = i30;
            float f5 = f3;
            int i36 = i35;
            while (i34 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i34);
                if (virtualChildAt3.getVisibility() != 8) {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams3.weight;
                    if (f6 > 0.0f) {
                        int i37 = (int) ((((float) i36) * f6) / f5);
                        float f7 = f5 - f6;
                        int i38 = i36 - i37;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height != 0 || mode2 != 1073741824) {
                            i37 += virtualChildAt3.getMeasuredHeight();
                            if (i37 < 0) {
                                i37 = 0;
                            }
                            view = virtualChildAt3;
                        } else if (i37 > 0) {
                            view = virtualChildAt3;
                        } else {
                            i37 = 0;
                            view = virtualChildAt3;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i37, 1073741824));
                        i7 = i38;
                        i8 = ViewUtils.combineMeasuredStates(i32, ViewCompat.getMeasuredState(virtualChildAt3) & InputDeviceCompat.SOURCE_ANY);
                        f = f7;
                    } else {
                        f = f5;
                        i7 = i36;
                        i8 = i32;
                    }
                    int i39 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i39;
                    int max3 = Math.max(i33, measuredWidth2);
                    if (!(mode != 1073741824 && layoutParams3.width == -1)) {
                        i39 = measuredWidth2;
                    }
                    int max4 = Math.max(i31, i39);
                    z = z11 && layoutParams3.width == -1;
                    int i40 = this.mTotalLength;
                    this.mTotalLength = Math.max(i40, layoutParams3.bottomMargin + virtualChildAt3.getMeasuredHeight() + i40 + layoutParams3.topMargin + getNextLocationOffset(virtualChildAt3));
                    i5 = max4;
                    i6 = max3;
                } else {
                    f = f5;
                    z = z11;
                    i5 = i31;
                    i6 = i33;
                    i7 = i36;
                    i8 = i32;
                }
                i34++;
                z11 = z;
                i31 = i5;
                i32 = i8;
                i33 = i6;
                i36 = i7;
                f5 = f;
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            z5 = z11;
            i4 = i31;
            i16 = i32;
            i3 = i33;
        } else {
            int max5 = Math.max(i17, i18);
            if (z8 && mode2 != 1073741824) {
                int i41 = 0;
                while (true) {
                    int i42 = i41;
                    if (i42 >= virtualChildCount) {
                        break;
                    }
                    View virtualChildAt4 = getVirtualChildAt(i42);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
                    }
                    i41 = i42 + 1;
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
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
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
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.mGravity = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != i2) {
            this.mGravity = i2 | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.mGravity & 112) != i2) {
            this.mGravity = i2 | (this.mGravity & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
