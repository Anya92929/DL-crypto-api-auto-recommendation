package com.google.android.gms.p018c;

import com.google.android.gms.common.internal.C1009bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.c.am */
public final class C0624am {

    /* renamed from: a */
    private final C0627ap f4228a;

    /* renamed from: b */
    private final C0615ad f4229b;

    /* renamed from: c */
    private boolean f4230c;

    /* renamed from: d */
    private long f4231d;

    /* renamed from: e */
    private long f4232e;

    /* renamed from: f */
    private long f4233f;

    /* renamed from: g */
    private long f4234g;

    /* renamed from: h */
    private long f4235h;

    /* renamed from: i */
    private boolean f4236i;

    /* renamed from: j */
    private final Map<Class<? extends C0626ao>, C0626ao> f4237j;

    /* renamed from: k */
    private final List<C0635ax> f4238k;

    C0624am(C0624am amVar) {
        this.f4228a = amVar.f4228a;
        this.f4229b = amVar.f4229b;
        this.f4231d = amVar.f4231d;
        this.f4232e = amVar.f4232e;
        this.f4233f = amVar.f4233f;
        this.f4234g = amVar.f4234g;
        this.f4235h = amVar.f4235h;
        this.f4238k = new ArrayList(amVar.f4238k);
        this.f4237j = new HashMap(amVar.f4237j.size());
        for (Map.Entry next : amVar.f4237j.entrySet()) {
            C0626ao c = m3590c((Class) next.getKey());
            ((C0626ao) next.getValue()).mo7010a(c);
            this.f4237j.put(next.getKey(), c);
        }
    }

    C0624am(C0627ap apVar, C0615ad adVar) {
        C1009bf.m4528a(apVar);
        C1009bf.m4528a(adVar);
        this.f4228a = apVar;
        this.f4229b = adVar;
        this.f4234g = 1800000;
        this.f4235h = 3024000000L;
        this.f4237j = new HashMap();
        this.f4238k = new ArrayList();
    }

    /* renamed from: c */
    private static <T extends C0626ao> T m3590c(Class<T> cls) {
        try {
            return (C0626ao) cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    /* renamed from: a */
    public C0624am mo6994a() {
        return new C0624am(this);
    }

    /* renamed from: a */
    public <T extends C0626ao> T mo6995a(Class<T> cls) {
        return (C0626ao) this.f4237j.get(cls);
    }

    /* renamed from: a */
    public void mo6996a(long j) {
        this.f4232e = j;
    }

    /* renamed from: a */
    public void mo6997a(C0626ao aoVar) {
        C1009bf.m4528a(aoVar);
        Class cls = aoVar.getClass();
        if (cls.getSuperclass() != C0626ao.class) {
            throw new IllegalArgumentException();
        }
        aoVar.mo7010a(mo6998b(cls));
    }

    /* renamed from: b */
    public <T extends C0626ao> T mo6998b(Class<T> cls) {
        T t = (C0626ao) this.f4237j.get(cls);
        if (t != null) {
            return t;
        }
        T c = m3590c(cls);
        this.f4237j.put(cls, c);
        return c;
    }

    /* renamed from: b */
    public Collection<C0626ao> mo6999b() {
        return this.f4237j.values();
    }

    /* renamed from: c */
    public List<C0635ax> mo7000c() {
        return this.f4238k;
    }

    /* renamed from: d */
    public long mo7001d() {
        return this.f4231d;
    }

    /* renamed from: e */
    public void mo7002e() {
        mo7006i().mo7017a(this);
    }

    /* renamed from: f */
    public boolean mo7003f() {
        return this.f4230c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo7004g() {
        this.f4233f = this.f4229b.mo6991b();
        if (this.f4232e != 0) {
            this.f4231d = this.f4232e;
        } else {
            this.f4231d = this.f4229b.mo6990a();
        }
        this.f4230c = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C0627ap mo7005h() {
        return this.f4228a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C0628aq mo7006i() {
        return this.f4228a.mo7014o();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo7007j() {
        return this.f4236i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo7008k() {
        this.f4236i = true;
    }
}
