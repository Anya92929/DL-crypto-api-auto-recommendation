package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.it */
public final class C1340it {

    /* renamed from: Gr */
    private static final C1334ip f4049Gr = new C1334ip("RequestTracker");

    /* renamed from: Hz */
    public static final Object f4050Hz = new Object();

    /* renamed from: Hv */
    private long f4051Hv;

    /* renamed from: Hw */
    private long f4052Hw = -1;

    /* renamed from: Hx */
    private long f4053Hx = 0;

    /* renamed from: Hy */
    private C1339is f4054Hy;

    public C1340it(long j) {
        this.f4051Hv = j;
    }

    /* renamed from: fV */
    private void m5068fV() {
        this.f4052Hw = -1;
        this.f4054Hy = null;
        this.f4053Hx = 0;
    }

    /* renamed from: a */
    public void mo8931a(long j, C1339is isVar) {
        C1339is isVar2;
        long j2;
        synchronized (f4050Hz) {
            isVar2 = this.f4054Hy;
            j2 = this.f4052Hw;
            this.f4052Hw = j;
            this.f4054Hy = isVar;
            this.f4053Hx = SystemClock.elapsedRealtime();
        }
        if (isVar2 != null) {
            isVar2.mo4109n(j2);
        }
    }

    /* renamed from: b */
    public boolean mo8932b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        C1339is isVar = null;
        synchronized (f4050Hz) {
            if (this.f4052Hw == -1 || this.f4052Hw != j) {
                z = false;
            } else {
                f4049Gr.mo8910b("request %d completed", Long.valueOf(this.f4052Hw));
                isVar = this.f4054Hy;
                m5068fV();
            }
        }
        if (isVar != null) {
            isVar.mo4108a(j, i, jSONObject);
        }
        return z;
    }

    public void clear() {
        synchronized (f4050Hz) {
            if (this.f4052Hw != -1) {
                m5068fV();
            }
        }
    }

    /* renamed from: d */
    public boolean mo8934d(long j, int i) {
        return mo8932b(j, i, (JSONObject) null);
    }

    /* renamed from: e */
    public boolean mo8935e(long j, int i) {
        C1339is isVar;
        boolean z = true;
        long j2 = 0;
        synchronized (f4050Hz) {
            if (this.f4052Hw == -1 || j - this.f4053Hx < this.f4051Hv) {
                z = false;
                isVar = null;
            } else {
                f4049Gr.mo8910b("request %d timed out", Long.valueOf(this.f4052Hw));
                j2 = this.f4052Hw;
                isVar = this.f4054Hy;
                m5068fV();
            }
        }
        if (isVar != null) {
            isVar.mo4108a(j2, i, (JSONObject) null);
        }
        return z;
    }

    /* renamed from: fW */
    public boolean mo8936fW() {
        boolean z;
        synchronized (f4050Hz) {
            z = this.f4052Hw != -1;
        }
        return z;
    }

    /* renamed from: p */
    public boolean mo8937p(long j) {
        boolean z;
        synchronized (f4050Hz) {
            z = this.f4052Hw != -1 && this.f4052Hw == j;
        }
        return z;
    }
}
