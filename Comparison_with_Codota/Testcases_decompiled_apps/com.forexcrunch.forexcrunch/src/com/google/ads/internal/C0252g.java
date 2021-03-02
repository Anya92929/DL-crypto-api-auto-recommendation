package com.google.ads.internal;

import android.os.SystemClock;
import com.google.ads.C0221g;
import com.google.ads.util.C0284b;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.ads.internal.g */
public class C0252g {

    /* renamed from: f */
    private static long f568f = 0;

    /* renamed from: g */
    private static long f569g = 0;

    /* renamed from: h */
    private static long f570h = 0;

    /* renamed from: i */
    private static long f571i = 0;

    /* renamed from: j */
    private static long f572j = -1;

    /* renamed from: a */
    private final LinkedList<Long> f573a = new LinkedList<>();

    /* renamed from: b */
    private long f574b;

    /* renamed from: c */
    private long f575c;

    /* renamed from: d */
    private long f576d;

    /* renamed from: e */
    private final LinkedList<Long> f577e = new LinkedList<>();

    /* renamed from: k */
    private boolean f578k = false;

    /* renamed from: l */
    private boolean f579l = false;

    /* renamed from: m */
    private String f580m;

    /* renamed from: n */
    private long f581n;

    /* renamed from: o */
    private final LinkedList<Long> f582o = new LinkedList<>();

    /* renamed from: p */
    private final LinkedList<C0221g.C0222a> f583p = new LinkedList<>();

    public C0252g() {
        mo3580a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3580a() {
        this.f573a.clear();
        this.f574b = 0;
        this.f575c = 0;
        this.f576d = 0;
        this.f577e.clear();
        this.f581n = -1;
        this.f582o.clear();
        this.f583p.clear();
        this.f578k = false;
        this.f579l = false;
    }

    /* renamed from: b */
    public synchronized void mo3583b() {
        this.f582o.clear();
        this.f583p.clear();
    }

    /* renamed from: c */
    public synchronized void mo3584c() {
        this.f581n = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public synchronized void mo3581a(C0221g.C0222a aVar) {
        this.f582o.add(Long.valueOf(SystemClock.elapsedRealtime() - this.f581n));
        this.f583p.add(aVar);
    }

    /* renamed from: d */
    public synchronized String mo3585d() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator it = this.f582o.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(longValue);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public synchronized String mo3586e() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator it = this.f583p.iterator();
        while (it.hasNext()) {
            C0221g.C0222a aVar = (C0221g.C0222a) it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(aVar.ordinal());
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo3587f() {
        C0284b.m488d("Ad clicked.");
        this.f573a.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo3588g() {
        C0284b.m488d("Ad request loaded.");
        this.f574b = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public synchronized void mo3589h() {
        C0284b.m488d("Ad request before rendering.");
        this.f575c = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo3590i() {
        C0284b.m488d("Ad request started.");
        this.f576d = SystemClock.elapsedRealtime();
        f568f++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public long mo3591j() {
        if (this.f573a.size() != this.f577e.size()) {
            return -1;
        }
        return (long) this.f573a.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String mo3592k() {
        if (this.f573a.isEmpty() || this.f573a.size() != this.f577e.size()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f573a.size()) {
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(this.f577e.get(i2).longValue() - this.f573a.get(i2).longValue()));
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public String mo3593l() {
        if (this.f573a.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f573a.size()) {
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(this.f573a.get(i2).longValue() - this.f574b));
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public long mo3594m() {
        return this.f574b - this.f576d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public synchronized long mo3595n() {
        return this.f575c - this.f576d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public long mo3596o() {
        return f568f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public synchronized long mo3597p() {
        return f569g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public synchronized void mo3598q() {
        C0284b.m488d("Ad request network error");
        f569g++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public synchronized void mo3599r() {
        f569g = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public synchronized long mo3600s() {
        return f570h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public synchronized void mo3601t() {
        f570h++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public synchronized void mo3602u() {
        f570h = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public synchronized long mo3603v() {
        return f571i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public synchronized void mo3604w() {
        f571i++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public synchronized void mo3605x() {
        f571i = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public boolean mo3606y() {
        return this.f578k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void mo3607z() {
        C0284b.m488d("Interstitial network error.");
        this.f578k = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public boolean mo3576A() {
        return this.f579l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void mo3577B() {
        C0284b.m488d("Interstitial no fill.");
        this.f579l = true;
    }

    /* renamed from: C */
    public void mo3578C() {
        C0284b.m488d("Landing page dismissed.");
        this.f577e.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public String mo3579D() {
        return this.f580m;
    }

    /* renamed from: a */
    public void mo3582a(String str) {
        C0284b.m488d("Prior impression ticket = " + str);
        this.f580m = str;
    }

    /* renamed from: E */
    public static long m359E() {
        if (f572j != -1) {
            return SystemClock.elapsedRealtime() - f572j;
        }
        f572j = SystemClock.elapsedRealtime();
        return 0;
    }
}
