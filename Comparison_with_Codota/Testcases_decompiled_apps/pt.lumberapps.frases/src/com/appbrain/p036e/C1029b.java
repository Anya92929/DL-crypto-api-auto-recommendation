package com.appbrain.p036e;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: com.appbrain.e.b */
final class C1029b extends C1028a {

    /* renamed from: a */
    final /* synthetic */ Drawable f2686a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1029b(Drawable[] drawableArr, float[] fArr, Drawable drawable) {
        super(drawableArr, fArr);
        this.f2686a = drawable;
    }

    public final void draw(Canvas canvas) {
        this.f2686a.draw(canvas);
        super.draw(canvas);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        this.f2686a.setBounds(i, i2, i3, i4);
        super.setBounds(i, i2, i3, i4);
    }

    public final void setBounds(Rect rect) {
        this.f2686a.setBounds(rect);
        super.setBounds(rect);
    }
}
