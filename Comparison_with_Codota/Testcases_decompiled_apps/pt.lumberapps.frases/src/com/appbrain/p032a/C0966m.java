package com.appbrain.p032a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.appbrain.p036e.C1031d;

/* renamed from: com.appbrain.a.m */
final class C0966m extends C0785aa {
    private C0966m() {
    }

    /* synthetic */ C0966m(byte b) {
        this();
    }

    /* renamed from: a */
    public final View mo3631a(Context context, C0979z zVar) {
        C0970q qVar = new C0970q();
        int c = zVar.mo3903c(50.0f);
        int c2 = zVar.mo3903c(4.0f);
        int c3 = zVar.mo3903c(4.0f);
        return C0838c.m3702a(context, zVar, qVar, C0838c.m3707b(qVar.f2573g, (C0977x) zVar), C1031d.m4307a(qVar.f2570d, qVar.f2571e, C0838c.m3709c(qVar.f2571e), 0.0f, zVar.mo3903c(1.0f)), c, c2, c3, true, true, new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{qVar.f2567a, qVar.f2568b}));
    }
}
