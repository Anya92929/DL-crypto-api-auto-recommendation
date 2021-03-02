package com.vertifi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

class FocusRectView extends View {
    public static final int VMB_FOCUS_RECT_HEIGHT = 48;
    public static final int VMB_FOCUS_RECT_WIDTH = 48;
    private int mHeight;
    private Paint mPaint;
    private Path mPathRect;
    private float mStrokeWidth;
    private int mWidth;

    public FocusRectView(Context context) {
        super(context);
        init(context);
    }

    public FocusRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FocusRectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mWidth = (int) (RDCGlobal.mScreenDensity * 48.0f);
        this.mHeight = (int) (RDCGlobal.mScreenDensity * 48.0f);
        this.mStrokeWidth = 4.0f * RDCGlobal.mScreenDensity;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPathRect = new Path();
        }
        this.mPaint.setShadowLayer(1.0f, 1.0f, -1.0f, ViewCompat.MEASURED_STATE_MASK);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setAlpha(224);
        this.mPathRect.reset();
        this.mPathRect.moveTo(0.0f, 0.0f);
        this.mPathRect.lineTo((float) this.mWidth, 0.0f);
        this.mPathRect.lineTo((float) this.mWidth, (float) this.mHeight);
        this.mPathRect.lineTo(0.0f, (float) this.mHeight);
        this.mPathRect.lineTo(0.0f, 0.0f);
        canvas.drawPath(this.mPathRect, this.mPaint);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }
}
