package com.tapcrowd.app.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class SquareViewGroup extends LinearLayout {
    public SquareViewGroup(Context context) {
        super(context);
    }

    public SquareViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
