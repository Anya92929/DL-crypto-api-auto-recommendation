package com.appbrain.p036e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: com.appbrain.e.c */
final class C1030c extends Drawable {

    /* renamed from: a */
    Paint f2687a = new Paint();

    /* renamed from: b */
    RectF f2688b = null;

    /* renamed from: c */
    final /* synthetic */ Drawable f2689c;

    C1030c(Drawable drawable) {
        this.f2689c = drawable;
    }

    public final void draw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(this.f2688b, this.f2687a, 31);
        this.f2689c.draw(canvas);
        canvas.restoreToCount(saveLayer);
    }

    public final int getIntrinsicHeight() {
        return this.f2689c.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth() {
        return this.f2689c.getIntrinsicWidth();
    }

    public final int getMinimumHeight() {
        return this.f2689c.getMinimumHeight();
    }

    public final int getMinimumWidth() {
        return this.f2689c.getMinimumWidth();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean getPadding(Rect rect) {
        return this.f2689c.getPadding(rect);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2688b = new RectF(rect);
        this.f2689c.setBounds(rect);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2687a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
