package com.appbrain.p032a;

import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

/* renamed from: com.appbrain.a.bf */
final class C0817bf extends ShapeDrawable.ShaderFactory {

    /* renamed from: a */
    final /* synthetic */ C0809ay f2152a;

    C0817bf(C0809ay ayVar) {
        this.f2152a = ayVar;
    }

    public final Shader resize(int i, int i2) {
        return new RadialGradient((float) (i / 2), (float) (i2 / 2), ((float) i) / 2.0f, new int[]{-1593835521, 1358954495, 687865855, 150994943, 16777215}, new float[]{0.0f, 0.3f, 0.56f, 0.82f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
