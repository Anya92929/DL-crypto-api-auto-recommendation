package com.appbrain.p032a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cmn.C0708ac;
import cmn.C0726au;
import com.appbrain.p037f.C1042ah;
import com.appbrain.p037f.C1050ap;
import com.appbrain.p037f.C1052ar;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.gm */
final class C0959gm extends C0726au {

    /* renamed from: c */
    final /* synthetic */ C1054at f2539c;

    /* renamed from: d */
    final /* synthetic */ Integer f2540d;

    /* renamed from: e */
    final /* synthetic */ String f2541e;

    /* renamed from: f */
    final /* synthetic */ Context f2542f;

    /* renamed from: g */
    final /* synthetic */ boolean f2543g;

    /* renamed from: h */
    final /* synthetic */ C0956gj f2544h;

    C0959gm(C0956gj gjVar, C1054at atVar, Integer num, String str, Context context, boolean z) {
        this.f2544h = gjVar;
        this.f2539c = atVar;
        this.f2540d = num;
        this.f2541e = str;
        this.f2542f = context;
        this.f2543g = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1042ah mo3411a() {
        C1052ar t = C1050ap.m4645t();
        if (this.f2539c != null) {
            t.mo4230a(this.f2539c);
        }
        if (this.f2540d != null) {
            t.mo4234c(this.f2540d.intValue());
        }
        if (!TextUtils.isEmpty(this.f2541e)) {
            String str = this.f2541e;
            if (str.length() > 20) {
                str = str.substring(0, 20);
            }
            t.mo4231a(str);
        }
        try {
            return C0883dr.m3828a(this.f2542f).mo3761a(t.mo4028d());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo3412a(Object obj) {
        C1042ah ahVar = (C1042ah) obj;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f2543g) {
            C0960gn gnVar = new C0960gn((byte) 0);
            C1042ah unused = gnVar.f2546b = ahVar;
            if (ahVar == null) {
                long unused2 = gnVar.f2545a = (elapsedRealtime - 420000) + 120000;
            } else {
                long unused3 = gnVar.f2545a = elapsedRealtime;
            }
            this.f2544h.f2529c.put(C0956gj.m4061b(this.f2539c, this.f2540d), gnVar);
        }
        C0726au unused4 = this.f2544h.f2530d = null;
        for (C0708ac a : this.f2544h.f2528b) {
            a.mo3385a(ahVar);
        }
        this.f2544h.f2528b.clear();
    }
}
