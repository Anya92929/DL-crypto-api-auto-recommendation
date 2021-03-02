package com.appbrain.p032a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

/* renamed from: com.appbrain.a.be */
final class C0816be extends ShapeDrawable.ShaderFactory {

    /* renamed from: a */
    final /* synthetic */ int[] f2150a;

    /* renamed from: b */
    final /* synthetic */ C0809ay f2151b;

    C0816be(C0809ay ayVar, int[] iArr) {
        this.f2151b = ayVar;
        this.f2150a = iArr;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, this.f2150a, (float[]) null, Shader.TileMode.CLAMP);
    }
}
