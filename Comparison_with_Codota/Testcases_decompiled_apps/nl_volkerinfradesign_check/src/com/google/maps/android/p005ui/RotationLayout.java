package com.google.maps.android.p005ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.maps.android.ui.RotationLayout */
class RotationLayout extends FrameLayout {

    /* renamed from: a */
    private int f4028a;

    public RotationLayout(Context context) {
        super(context);
    }

    public RotationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f4028a == 1 || this.f4028a == 3) {
            super.onMeasure(i, i2);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    public void mo8009a(int i) {
        this.f4028a = ((i + 360) % 360) / 90;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f4028a == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        if (this.f4028a == 1) {
            canvas.translate((float) getWidth(), BitmapDescriptorFactory.HUE_RED);
            canvas.rotate(90.0f, (float) (getWidth() / 2), BitmapDescriptorFactory.HUE_RED);
            canvas.translate((float) (getHeight() / 2), (float) (getWidth() / 2));
        } else if (this.f4028a == 2) {
            canvas.rotate(180.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        } else {
            canvas.translate(BitmapDescriptorFactory.HUE_RED, (float) getHeight());
            canvas.rotate(270.0f, (float) (getWidth() / 2), BitmapDescriptorFactory.HUE_RED);
            canvas.translate((float) (getHeight() / 2), (float) ((-getWidth()) / 2));
        }
        super.dispatchDraw(canvas);
    }
}
