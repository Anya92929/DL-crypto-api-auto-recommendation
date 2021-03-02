package org.p004a.p005a.p006a;

import java.util.Collection;
import java.util.Queue;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.a.i */
public class C0228i {

    /* renamed from: a */
    private C0221b f32a = C0221b.UNCHALLENGED;

    /* renamed from: b */
    private C0222c f33b;

    /* renamed from: c */
    private C0233n f34c;

    /* renamed from: d */
    private Queue f35d;

    /* renamed from: a */
    public final void mo4823a() {
        this.f32a = C0221b.UNCHALLENGED;
        this.f35d = null;
        this.f33b = null;
        this.f34c = null;
    }

    /* renamed from: a */
    public final void mo4824a(Queue queue) {
        C0250b.m90a((Collection) queue, "Queue of auth options");
        this.f35d = queue;
        this.f33b = null;
        this.f34c = null;
    }

    /* renamed from: a */
    public final void mo4825a(C0221b bVar) {
        if (bVar == null) {
            bVar = C0221b.UNCHALLENGED;
        }
        this.f32a = bVar;
    }

    /* renamed from: a */
    public final void mo4826a(C0222c cVar, C0233n nVar) {
        C0250b.m84a((Object) cVar, "Auth scheme");
        C0250b.m84a((Object) nVar, "Credentials");
        this.f33b = cVar;
        this.f34c = nVar;
        this.f35d = null;
    }

    /* renamed from: b */
    public final C0221b mo4827b() {
        return this.f32a;
    }

    /* renamed from: c */
    public final C0222c mo4828c() {
        return this.f33b;
    }

    /* renamed from: d */
    public final C0233n mo4829d() {
        return this.f34c;
    }

    /* renamed from: e */
    public final Queue mo4830e() {
        return this.f35d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("state:").append(this.f32a).append(";");
        if (this.f33b != null) {
            sb.append("auth scheme:").append(this.f33b.mo4808a()).append(";");
        }
        if (this.f34c != null) {
            sb.append("credentials present");
        }
        return sb.toString();
    }
}
