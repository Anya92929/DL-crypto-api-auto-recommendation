package com.appbrain.p032a;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

/* renamed from: com.appbrain.a.p */
final class C0969p extends ShapeDrawable.ShaderFactory {

    /* renamed from: a */
    final /* synthetic */ C0967n f2566a;

    C0969p(C0967n nVar) {
        this.f2566a = nVar;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{-14408668, -10000280, -12763586, -12763586, -14408668}, new float[]{0.0f, 0.02f, 0.04f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
