package com.appbrain.p032a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

/* renamed from: com.appbrain.a.fy */
final class C0944fy extends ShapeDrawable {

    /* renamed from: a */
    final /* synthetic */ Paint f2490a;

    /* renamed from: b */
    final /* synthetic */ C0940fu f2491b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0944fy(C0940fu fuVar, Shape shape, Paint paint) {
        super(shape);
        this.f2491b = fuVar;
        this.f2490a = paint;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);
        int width = (int) (shape.getWidth() * 0.3f);
        int width2 = ((int) shape.getWidth()) - width;
        int height = (int) (shape.getHeight() * 0.3f);
        int height2 = ((int) shape.getHeight()) - height;
        canvas.drawLine((float) width, (float) height, (float) width2, (float) height2, this.f2490a);
        canvas.drawLine((float) width, (float) height2, (float) width2, (float) height, this.f2490a);
    }
}
