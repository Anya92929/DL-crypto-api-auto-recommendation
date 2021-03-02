package com.appbrain.p032a;

import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

/* renamed from: com.appbrain.a.bg */
final class C0818bg extends ShapeDrawable.ShaderFactory {

    /* renamed from: a */
    final /* synthetic */ int f2153a;

    /* renamed from: b */
    final /* synthetic */ C0809ay f2154b;

    C0818bg(C0809ay ayVar, int i) {
        this.f2154b = ayVar;
        this.f2153a = i;
    }

    public final Shader resize(int i, int i2) {
        float f = ((float) i) / 2.0f;
        return new RadialGradient((float) (i / 2), (float) (i2 / 2), f, new int[]{-1879048192, -1879048192, 0}, new float[]{0.0f, 1.0f - (((float) this.f2153a) / f), 1.0f}, Shader.TileMode.CLAMP);
    }
}
