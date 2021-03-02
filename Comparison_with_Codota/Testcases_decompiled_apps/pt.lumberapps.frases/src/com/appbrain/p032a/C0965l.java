package com.appbrain.p032a;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.Shape;

/* renamed from: com.appbrain.a.l */
final class C0965l extends PaintDrawable {

    /* renamed from: a */
    final /* synthetic */ int f2562a;

    /* renamed from: b */
    final /* synthetic */ float f2563b;

    /* renamed from: c */
    private final Paint f2564c = new Paint();

    C0965l(int i, float f) {
        this.f2562a = i;
        this.f2563b = f;
        this.f2564c.setMaskFilter(new BlurMaskFilter((float) this.f2562a, BlurMaskFilter.Blur.OUTER));
        this.f2564c.setColor(Integer.MIN_VALUE);
        setCornerRadius(this.f2563b * ((float) this.f2562a));
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);
        shape.draw(canvas, this.f2564c);
    }
}
