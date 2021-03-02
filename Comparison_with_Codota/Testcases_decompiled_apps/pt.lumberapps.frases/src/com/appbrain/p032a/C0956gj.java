package com.appbrain.p032a;

import android.content.Context;
import android.os.SystemClock;
import cmn.C0708ac;
import cmn.C0726au;
import cmn.C0738bf;
import cmn.C0749k;
import com.appbrain.p037f.C1042ah;
import com.appbrain.p037f.C1054at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.appbrain.a.gj */
public final class C0956gj {

    /* renamed from: a */
    private static C0956gj f2527a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List f2528b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f2529c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0726au f2530d;

    /* renamed from: e */
    private String f2531e;

    /* renamed from: a */
    public static C0956gj m4057a() {
        if (f2527a == null) {
            f2527a = new C0956gj();
        }
        return f2527a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m4061b(C1054at atVar, Integer num) {
        return atVar.name() + (num == null ? "" : "/" + num);
    }

    /* renamed from: a */
    public final int mo3884a(Context context, C1042ah ahVar) {
        int i = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i2 = 0; i2 < ahVar.mo4194g(); i2++) {
            String a = ahVar.mo4188a(i2);
            if (!a.equals(this.f2531e) && !C0749k.m3268a(context, a)) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        if (!hashSet.isEmpty()) {
            for (Integer intValue : hashSet) {
                i += ahVar.mo4195g(intValue.intValue());
            }
            int a2 = C0738bf.m3250a(i);
            int i3 = a2;
            for (Integer num : hashSet) {
                i3 -= ahVar.mo4195g(num.intValue());
                if (i3 < 0) {
                    this.f2531e = ahVar.mo4188a(num.intValue());
                    return num.intValue();
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public final void mo3885a(Context context, C1054at atVar, Integer num, String str, C0708ac acVar, boolean z) {
        C0960gn gnVar = (C0960gn) this.f2529c.get(m4061b(atVar, num));
        if ((gnVar == null || gnVar.f2546b == null || gnVar.f2545a < SystemClock.elapsedRealtime() - 420000) || !z) {
            if (acVar != null) {
                this.f2528b.add(acVar);
            }
            if (this.f2530d == null) {
                this.f2530d = new C0959gm(this, atVar, num, str, context, z).mo3410a((Object[]) new Void[0]);
            }
        } else if (acVar != null) {
            acVar.mo3385a(gnVar.f2546b);
        }
    }

    /* renamed from: a */
    public final void mo3886a(Context context, C1054at atVar, String str, C0708ac acVar, boolean z) {
        mo3885a(context, atVar, (Integer) null, str, acVar, z);
    }

    /* renamed from: b */
    public final void mo3887b(Context context, C1054at atVar, String str, C0708ac acVar, boolean z) {
        mo3886a(context, atVar, str, new C0957gk(this, context, atVar, str, acVar, z), z);
    }
}
