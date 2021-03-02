package com.appbrain.p032a;

import android.content.Context;
import cmn.C0708ac;
import cmn.C0749k;
import com.appbrain.C1138z;
import com.appbrain.p037f.C1042ah;
import com.appbrain.p037f.C1054at;
import java.util.ArrayList;

/* renamed from: com.appbrain.a.gk */
final class C0957gk implements C0708ac {

    /* renamed from: a */
    final /* synthetic */ Context f2532a;

    /* renamed from: b */
    final /* synthetic */ C1054at f2533b;

    /* renamed from: c */
    final /* synthetic */ String f2534c;

    /* renamed from: d */
    final /* synthetic */ C0708ac f2535d;

    /* renamed from: e */
    final /* synthetic */ boolean f2536e;

    /* renamed from: f */
    final /* synthetic */ C0956gj f2537f;

    C0957gk(C0956gj gjVar, Context context, C1054at atVar, String str, C0708ac acVar, boolean z) {
        this.f2537f = gjVar;
        this.f2532a = context;
        this.f2533b = atVar;
        this.f2534c = str;
        this.f2535d = acVar;
        this.f2536e = z;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3385a(Object obj) {
        C1042ah ahVar = (C1042ah) obj;
        ArrayList arrayList = new ArrayList();
        if (ahVar == null) {
            arrayList.add(new C0962i("Network error", "There was a problem fetching apps, please try again later", "", new C0958gl(this), ""));
        } else {
            for (int i = 0; i < ahVar.mo4194g(); i++) {
                if (!C0749k.m3268a(this.f2532a, ahVar.mo4188a(i))) {
                    arrayList.add(C0861cw.m3778a(this.f2532a, (C1138z) null, ahVar, i, 0));
                }
            }
        }
        this.f2535d.mo3385a(arrayList);
    }
}
