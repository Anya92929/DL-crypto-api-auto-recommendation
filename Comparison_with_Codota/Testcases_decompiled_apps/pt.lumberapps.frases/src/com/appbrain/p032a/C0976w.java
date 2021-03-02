package com.appbrain.p032a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.appbrain.p036e.C1032e;

/* renamed from: com.appbrain.a.w */
final class C0976w extends C1032e {

    /* renamed from: a */
    final /* synthetic */ C0973t f2582a;

    /* renamed from: b */
    final /* synthetic */ C0975v f2583b;

    /* renamed from: c */
    private final Paint f2584c = new Paint(1);

    /* renamed from: d */
    private Path f2585d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0976w(C0975v vVar, int i, int i2, C0973t tVar) {
        super(i, i2);
        this.f2583b = vVar;
        this.f2582a = tVar;
        this.f2584c.setColor(this.f2582a.f2580c.f2574h);
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawPath(this.f2585d, this.f2584c);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f2585d = new Path();
        this.f2585d.moveTo((float) i, (float) i4);
        this.f2585d.arcTo(new RectF(((float) i) - this.f2582a.mo3902b(30.0f), ((float) i2) - this.f2582a.mo3902b(50.0f), ((float) i3) + this.f2582a.mo3902b(30.0f), (float) ((((i4 - i2) * 2) / 3) + i2)), 180.0f, -180.0f);
        this.f2585d.lineTo((float) i3, (float) i4);
        this.f2585d.lineTo((float) i, (float) i4);
    }
}
