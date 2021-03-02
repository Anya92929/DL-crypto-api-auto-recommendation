package com.google.maps.android.p005ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: com.google.maps.android.ui.SquareTextView */
public class SquareTextView extends TextView {

    /* renamed from: a */
    private int f4029a = 0;

    /* renamed from: b */
    private int f4030b = 0;

    public SquareTextView(Context context) {
        super(context);
    }

    public SquareTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.f4029a = measuredWidth - measuredHeight;
            this.f4030b = 0;
        } else {
            this.f4029a = 0;
            this.f4030b = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(max, max);
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.f4030b / 2), (float) (this.f4029a / 2));
        super.draw(canvas);
    }
}
