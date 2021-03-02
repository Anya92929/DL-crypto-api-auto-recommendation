package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.actionbarsherlock.C0051R;

public class FakeDialogPhoneWindow extends LinearLayout {
    final TypedValue mMinWidthMajor = new TypedValue();
    final TypedValue mMinWidthMinor = new TypedValue();

    public FakeDialogPhoneWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, C0051R.styleable.SherlockTheme);
        a.getValue(34, this.mMinWidthMajor);
        a.getValue(35, this.mMinWidthMinor);
        a.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int min;
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        boolean isPortrait = metrics.widthPixels < metrics.heightPixels;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        boolean measure = false;
        int widthMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
        TypedValue tv = isPortrait ? this.mMinWidthMinor : this.mMinWidthMajor;
        if (tv.type != 0) {
            if (tv.type == 5) {
                min = (int) tv.getDimension(metrics);
            } else if (tv.type == 6) {
                min = (int) tv.getFraction((float) metrics.widthPixels, (float) metrics.widthPixels);
            } else {
                min = 0;
            }
            if (width < min) {
                widthMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                measure = true;
            }
        }
        if (measure) {
            super.onMeasure(widthMeasureSpec2, heightMeasureSpec);
        }
    }
}
