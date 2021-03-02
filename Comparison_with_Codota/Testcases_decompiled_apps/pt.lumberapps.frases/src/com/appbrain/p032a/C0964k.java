package com.appbrain.p032a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: com.appbrain.a.k */
final class C0964k extends Drawable {

    /* renamed from: a */
    final /* synthetic */ C0973t f2554a;

    /* renamed from: b */
    final /* synthetic */ int f2555b;

    /* renamed from: c */
    final /* synthetic */ int f2556c;

    /* renamed from: d */
    final /* synthetic */ int f2557d;

    /* renamed from: e */
    final /* synthetic */ C0963j f2558e;

    /* renamed from: f */
    private final Path f2559f = new Path();

    /* renamed from: g */
    private final Path f2560g = new Path();

    /* renamed from: h */
    private final Paint f2561h = new Paint();

    C0964k(C0963j jVar, C0973t tVar, int i, int i2, int i3) {
        this.f2558e = jVar;
        this.f2554a = tVar;
        this.f2555b = i;
        this.f2556c = i2;
        this.f2557d = i3;
        int c = this.f2554a.mo3903c(100.0f);
        this.f2561h.setColor(this.f2554a.f2580c.f2570d);
        this.f2561h.setStrokeWidth((float) this.f2555b);
        this.f2561h.setStrokeJoin(Paint.Join.MITER);
        this.f2561h.setStyle(Paint.Style.STROKE);
        this.f2559f.moveTo((float) (this.f2556c - c), (float) (this.f2557d - c));
        this.f2559f.lineTo((float) this.f2556c, (float) this.f2557d);
        this.f2559f.lineTo((float) (this.f2556c - c), (float) (c + this.f2557d));
    }

    public final void draw(Canvas canvas) {
        canvas.drawPath(this.f2559f, this.f2561h);
        canvas.drawPath(this.f2560g, this.f2561h);
    }

    public final int getOpacity() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2559f.offset((float) rect.width(), 0.0f, this.f2560g);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
