package com.appbrain.p032a;

import android.app.Activity;
import android.os.Build;
import cmn.C0725at;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.ea */
final class C0893ea implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f2365a;

    /* renamed from: b */
    final /* synthetic */ C1056av f2366b;

    C0893ea(Activity activity, C1056av avVar) {
        this.f2365a = activity;
        this.f2366b = avVar;
    }

    public final void run() {
        if (!C0725at.m3232b(this.f2365a)) {
            if (Build.VERSION.SDK_INT < 11) {
                C0891dz.m3863b(this.f2365a, this.f2366b);
            } else {
                C0891dz.m3864c(this.f2365a, this.f2366b);
            }
        }
    }
}
