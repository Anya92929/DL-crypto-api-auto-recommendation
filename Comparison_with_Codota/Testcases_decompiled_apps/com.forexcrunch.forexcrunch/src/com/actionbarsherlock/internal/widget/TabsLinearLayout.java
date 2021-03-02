package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class TabsLinearLayout extends IcsLinearLayout {
    private static final int LinearLayout_measureWithLargestChild = 0;
    private static final int[] R_styleable_LinearLayout = {16843476};
    private boolean mUseLargestChild;

    public TabsLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R_styleable_LinearLayout);
        this.mUseLargestChild = a.getBoolean(0, false);
        a.recycle();
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        this.mUseLargestChild = enabled;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 2) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            if (this.mUseLargestChild && mode == 0 && getOrientation() == 0) {
                useLargestChildHorizontal();
            }
        }
    }

    private void useLargestChildHorizontal() {
        int totalWidth;
        int childCount = getChildCount();
        int largestChildWidth = 0;
        for (int i = 0; i < childCount; i++) {
            largestChildWidth = Math.max(getChildAt(i).getMeasuredWidth(), largestChildWidth);
        }
        int totalWidth2 = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            if (!(child == null || child.getVisibility() == 8)) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                if (lp.weight > BitmapDescriptorFactory.HUE_RED) {
                    child.measure(View.MeasureSpec.makeMeasureSpec(largestChildWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824));
                    totalWidth = totalWidth2 + largestChildWidth;
                } else {
                    totalWidth = totalWidth2 + child.getMeasuredWidth();
                }
                totalWidth2 = totalWidth + lp.leftMargin + lp.rightMargin;
            }
        }
        setMeasuredDimension(totalWidth2 + getPaddingLeft() + getPaddingRight(), getMeasuredHeight());
    }
}
