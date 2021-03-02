package com.google.ads.internal;

import android.os.SystemClock;
import com.google.ads.g;
import com.google.ads.util.b;
import java.util.Iterator;
import java.util.LinkedList;

public class g {
    private static long f = 0;
    private static long g = 0;
    private static long i = -1;
    private LinkedList<Long> a = new LinkedList<>();
    private long b;
    private long c;
    private long d;
    private LinkedList<Long> e = new LinkedList<>();
    private String h;
    private boolean j = false;
    private boolean k = false;
    private String l;
    private long m;
    private LinkedList<Long> n = new LinkedList<>();
    private LinkedList<g.a> o = new LinkedList<>();

    protected g() {
        a();
    }

    /* access modifiers changed from: protected */
    public synchronized void a() {
        this.a.clear();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e.clear();
        this.m = -1;
        this.n.clear();
        this.o.clear();
        this.h = null;
        this.j = false;
        this.k = false;
    }

    public synchronized void b() {
        this.n.clear();
        this.o.clear();
    }

    public synchronized void c() {
        this.m = SystemClock.elapsedRealtime();
    }

    public synchronized void a(g.a aVar) {
        this.n.add(Long.valueOf(SystemClock.elapsedRealtime() - this.m));
        this.o.add(aVar);
    }

    public synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(longValue);
        }
        return sb.toString();
    }

    public synchronized String e() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            g.a aVar = (g.a) it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(aVar.ordinal());
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void f() {
        b.d("Ad clicked.");
        this.a.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    public void g() {
        b.d("Ad request loaded.");
        this.b = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    public synchronized void h() {
        b.d("Ad request before rendering.");
        this.c = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    public void i() {
        b.d("Ad request started.");
        this.d = SystemClock.elapsedRealtime();
        f++;
    }

    /* access modifiers changed from: protected */
    public long j() {
        if (this.a.size() != this.e.size()) {
            return -1;
        }
        return (long) this.a.size();
    }

    /* access modifiers changed from: protected */
    public String k() {
        if (this.a.isEmpty() || this.a.size() != this.e.size()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.a.size()) {
                return sb.toString();
            }
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(this.e.get(i3).longValue() - this.a.get(i3).longValue()));
            i2 = i3 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public String l() {
        if (this.a.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.a.size()) {
                return sb.toString();
            }
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(this.a.get(i3).longValue() - this.b));
            i2 = i3 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public long m() {
        return this.b - this.d;
    }

    /* access modifiers changed from: protected */
    public synchronized long n() {
        return this.c - this.d;
    }

    /* access modifiers changed from: protected */
    public long o() {
        return f;
    }

    /* access modifiers changed from: protected */
    public long p() {
        return g;
    }

    /* access modifiers changed from: protected */
    public void q() {
        b.d("Ad request network error");
        g++;
    }

    /* access modifiers changed from: protected */
    public String r() {
        return this.h;
    }

    public void a(String str) {
        b.d("Prior ad identifier = " + str);
        this.h = str;
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void t() {
        b.d("Interstitial network error.");
        this.j = true;
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public void v() {
        b.d("Interstitial no fill.");
        this.k = true;
    }

    public void w() {
        b.d("Landing page dismissed.");
        this.e.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    public String x() {
        return this.l;
    }

    public void b(String str) {
        b.d("Prior impression ticket = " + str);
        this.l = str;
    }

    public static long y() {
        if (i != -1) {
            return SystemClock.elapsedRealtime() - i;
        }
        i = SystemClock.elapsedRealtime();
        return 0;
    }
}
