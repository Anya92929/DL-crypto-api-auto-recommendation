package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzamq {

    /* renamed from: a */
    private zzanq f5781a = zzanq.beK;

    /* renamed from: b */
    private zzanf f5782b = zzanf.bel;

    /* renamed from: c */
    private zzamo f5783c = zzamn.bdI;

    /* renamed from: d */
    private final Map f5784d = new HashMap();

    /* renamed from: e */
    private final List f5785e = new ArrayList();

    /* renamed from: f */
    private final List f5786f = new ArrayList();

    /* renamed from: g */
    private int f5787g = 2;

    /* renamed from: h */
    private int f5788h = 2;

    /* renamed from: i */
    private boolean f5789i = true;

    /* renamed from: a */
    private void m6654a(String str, int i, int i2, List list) {
        C1875t tVar;
        if (str != null && !"".equals(str.trim())) {
            tVar = new C1875t(str);
        } else if (i != 2 && i2 != 2) {
            tVar = new C1875t(i, i2);
        } else {
            return;
        }
        list.add(C1416ah.m6270a(zzaol.zzr(Date.class), tVar));
        list.add(C1416ah.m6270a(zzaol.zzr(Timestamp.class), tVar));
        list.add(C1416ah.m6270a(zzaol.zzr(java.sql.Date.class), tVar));
    }

    public zzamq zza(Type type, Object obj) {
        zzann.zzbo((obj instanceof zzand) || (obj instanceof zzamu) || (obj instanceof zzamr) || (obj instanceof zzanh));
        if (obj instanceof zzamr) {
            this.f5784d.put(type, (zzamr) obj);
        }
        if ((obj instanceof zzand) || (obj instanceof zzamu)) {
            this.f5785e.add(C1416ah.m6271b(zzaol.zzl(type), obj));
        }
        if (obj instanceof zzanh) {
            this.f5785e.add(zzaok.zza(zzaol.zzl(type), (zzanh) obj));
        }
        return this;
    }

    public zzamq zza(zzaml... zzamlArr) {
        for (zzaml zza : zzamlArr) {
            this.f5781a = this.f5781a.zza(zza, true, true);
        }
        return this;
    }

    public zzamq zzczc() {
        this.f5789i = false;
        return this;
    }

    public zzamp zzczd() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5785e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f5786f);
        m6654a((String) null, this.f5787g, this.f5788h, arrayList);
        return new zzamp(this.f5781a, this.f5783c, this.f5784d, false, false, false, this.f5789i, false, false, this.f5782b, arrayList);
    }

    public zzamq zzf(int... iArr) {
        this.f5781a = this.f5781a.zzg(iArr);
        return this;
    }
}
