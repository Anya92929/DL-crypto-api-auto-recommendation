package com.appbrain.p032a;

import android.content.Context;
import com.appbrain.p037f.C1050ap;
import java.util.concurrent.Callable;

/* renamed from: com.appbrain.a.ba */
final class C0812ba implements Callable {

    /* renamed from: a */
    final /* synthetic */ Context f2145a;

    C0812ba(Context context) {
        this.f2145a = context;
    }

    public final /* synthetic */ Object call() {
        C0826bo boVar = new C0826bo(this.f2145a, "appbrain/interstitial.html", "inturl", C0829br.m3684a(new C0866da(this.f2145a).mo3726b(C1050ap.m4644f(), "ow")));
        C0809ay.m3637m();
        return boVar;
    }
}
