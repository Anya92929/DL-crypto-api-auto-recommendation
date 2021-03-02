package org.p004a.p005a.p035k;

import java.util.concurrent.TimeUnit;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.k.a */
public abstract class C0547a {

    /* renamed from: a */
    private final String f608a;

    /* renamed from: b */
    private final Object f609b;

    /* renamed from: c */
    private final Object f610c;

    /* renamed from: d */
    private final long f611d = System.currentTimeMillis();

    /* renamed from: e */
    private final long f612e;

    /* renamed from: f */
    private long f613f;

    /* renamed from: g */
    private long f614g;

    /* renamed from: h */
    private volatile Object f615h;

    public C0547a(String str, Object obj, Object obj2, long j, TimeUnit timeUnit) {
        C0250b.m84a(obj, "Route");
        C0250b.m84a(obj2, "Connection");
        C0250b.m84a((Object) timeUnit, "Time unit");
        this.f608a = str;
        this.f609b = obj;
        this.f610c = obj2;
        if (j > 0) {
            this.f612e = this.f611d + timeUnit.toMillis(j);
        } else {
            this.f612e = Long.MAX_VALUE;
        }
        this.f614g = this.f612e;
    }

    /* renamed from: a */
    public final synchronized void mo5393a(long j, TimeUnit timeUnit) {
        C0250b.m84a((Object) timeUnit, "Time unit");
        this.f613f = System.currentTimeMillis();
        this.f614g = Math.min(j > 0 ? this.f613f + timeUnit.toMillis(j) : Long.MAX_VALUE, this.f612e);
    }

    /* renamed from: a */
    public final void mo5394a(Object obj) {
        this.f615h = obj;
    }

    /* renamed from: a */
    public synchronized boolean mo5229a(long j) {
        return j >= this.f614g;
    }

    /* renamed from: e */
    public final Object mo5395e() {
        return this.f609b;
    }

    /* renamed from: f */
    public final Object mo5396f() {
        return this.f610c;
    }

    /* renamed from: g */
    public final synchronized long mo5397g() {
        return this.f614g;
    }

    public String toString() {
        return "[id:" + this.f608a + "][route:" + this.f609b + "][state:" + this.f615h + "]";
    }
}
