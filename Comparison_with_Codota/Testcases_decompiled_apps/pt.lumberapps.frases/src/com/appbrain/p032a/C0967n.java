package com.appbrain.p032a;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

/* renamed from: com.appbrain.a.n */
final class C0967n extends C0785aa {
    private C0967n() {
    }

    /* synthetic */ C0967n(byte b) {
        this();
    }

    /* renamed from: a */
    public final View mo3631a(Context context, C0979z zVar) {
        C0970q qVar = new C0970q();
        int c = zVar.mo3903c(50.0f);
        int c2 = zVar.mo3903c(12.0f);
        ShapeDrawable a = C0838c.m3701a(qVar.f2573g, (C0977x) zVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setShaderFactory(new C0968o(this));
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
        shapeDrawable2.setShaderFactory(new C0969p(this));
        return C0838c.m3702a(context, zVar, qVar, a, shapeDrawable, c, c2, 0, false, true, shapeDrawable2);
    }
}
