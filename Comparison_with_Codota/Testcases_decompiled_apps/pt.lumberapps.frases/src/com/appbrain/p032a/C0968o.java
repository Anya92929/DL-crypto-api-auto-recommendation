package com.appbrain.p032a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

/* renamed from: com.appbrain.a.o */
final class C0968o extends ShapeDrawable.ShaderFactory {

    /* renamed from: a */
    final /* synthetic */ C0967n f2565a;

    C0968o(C0967n nVar) {
        this.f2565a = nVar;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{-10908144, -6372760, -8343745, -8343745, -10908144}, new float[]{0.0f, 0.02f, 0.04f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
