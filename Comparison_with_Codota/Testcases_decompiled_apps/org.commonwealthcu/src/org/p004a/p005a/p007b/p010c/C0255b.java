package org.p004a.p005a.p007b.p010c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.p004a.p005a.C0242ad;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0321d;
import org.p004a.p005a.p014d.C0333g;
import org.p004a.p005a.p033i.C0522a;
import org.p004a.p005a.p033i.C0537p;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.b.c.b */
public abstract class C0255b extends C0522a implements Cloneable, C0254a, C0568q {

    /* renamed from: c */
    private Lock f81c = new ReentrantLock();

    /* renamed from: d */
    private volatile boolean f82d;

    /* renamed from: e */
    private volatile C0242ad f83e;

    protected C0255b() {
    }

    /* renamed from: a */
    public final void mo4889a(C0321d dVar) {
        boolean z = this.f82d;
        this.f81c.lock();
        try {
            this.f83e = new C0256c(this, dVar);
        } finally {
            this.f81c.unlock();
        }
    }

    /* renamed from: a */
    public final void mo4890a(C0333g gVar) {
        boolean z = this.f82d;
        this.f81c.lock();
        try {
            this.f83e = new C0257d(this, gVar);
        } finally {
            this.f81c.unlock();
        }
    }

    public Object clone() {
        C0255b bVar = (C0255b) super.clone();
        bVar.f563a = (C0537p) C0250b.m83a((Object) this.f563a);
        bVar.f564b = (C0544b) C0250b.m83a((Object) this.f564b);
        bVar.f81c = new ReentrantLock();
        bVar.f83e = null;
        bVar.f82d = false;
        return bVar;
    }

    /* renamed from: h */
    public final boolean mo4892h() {
        return this.f82d;
    }
}
