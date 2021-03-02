package org.p004a.p005a.p014d.p016b;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.d.b.b */
public final class C0306b implements Cloneable, C0309e {

    /* renamed from: a */
    private final C0565n f140a;

    /* renamed from: b */
    private final InetAddress f141b;

    /* renamed from: c */
    private final List f142c;

    /* renamed from: d */
    private final C0311g f143d;

    /* renamed from: e */
    private final C0310f f144e;

    /* renamed from: f */
    private final boolean f145f;

    public C0306b(C0565n nVar) {
        this(nVar, (InetAddress) null, Collections.emptyList(), false, C0311g.PLAIN, C0310f.PLAIN);
    }

    private C0306b(C0565n nVar, InetAddress inetAddress, List list, boolean z, C0311g gVar, C0310f fVar) {
        C0250b.m84a((Object) nVar, "Target host");
        this.f140a = nVar;
        this.f141b = inetAddress;
        if (list == null || list.isEmpty()) {
            this.f142c = null;
        } else {
            this.f142c = new ArrayList(list);
        }
        if (gVar == C0311g.TUNNELLED) {
            C0250b.m95a(this.f142c != null, "Proxy required if tunnelled");
        }
        this.f145f = z;
        this.f143d = gVar == null ? C0311g.PLAIN : gVar;
        this.f144e = fVar == null ? C0310f.PLAIN : fVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0306b(C0565n nVar, InetAddress inetAddress, C0565n nVar2, boolean z) {
        this(nVar, inetAddress, Collections.singletonList(C0250b.m84a((Object) nVar2, "Proxy host")), z, z ? C0311g.TUNNELLED : C0311g.PLAIN, z ? C0310f.LAYERED : C0310f.PLAIN);
    }

    public C0306b(C0565n nVar, InetAddress inetAddress, boolean z) {
        this(nVar, inetAddress, Collections.emptyList(), z, C0311g.PLAIN, C0310f.PLAIN);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0306b(C0565n nVar, InetAddress inetAddress, C0565n[] nVarArr, boolean z, C0311g gVar, C0310f fVar) {
        this(nVar, inetAddress, nVarArr != null ? Arrays.asList(nVarArr) : null, z, gVar, fVar);
    }

    /* renamed from: a */
    public final C0565n mo4964a() {
        return this.f140a;
    }

    /* renamed from: a */
    public final C0565n mo4965a(int i) {
        C0250b.m78a(i, "Hop index");
        int c = mo4967c();
        C0250b.m95a(i < c, "Hop index exceeds tracked route length");
        return i < c + -1 ? (C0565n) this.f142c.get(i) : this.f140a;
    }

    /* renamed from: b */
    public final InetAddress mo4966b() {
        return this.f141b;
    }

    /* renamed from: c */
    public final int mo4967c() {
        if (this.f142c != null) {
            return this.f142c.size() + 1;
        }
        return 1;
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final C0565n mo4969d() {
        if (this.f142c == null || this.f142c.isEmpty()) {
            return null;
        }
        return (C0565n) this.f142c.get(0);
    }

    /* renamed from: e */
    public final boolean mo4970e() {
        return this.f143d == C0311g.TUNNELLED;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0306b)) {
            return false;
        }
        C0306b bVar = (C0306b) obj;
        return this.f145f == bVar.f145f && this.f143d == bVar.f143d && this.f144e == bVar.f144e && C0250b.m97a((Object) this.f140a, (Object) bVar.f140a) && C0250b.m97a((Object) this.f141b, (Object) bVar.f141b) && C0250b.m97a((Object) this.f142c, (Object) bVar.f142c);
    }

    /* renamed from: f */
    public final boolean mo4972f() {
        return this.f144e == C0310f.LAYERED;
    }

    /* renamed from: g */
    public final boolean mo4973g() {
        return this.f145f;
    }

    public final int hashCode() {
        int i;
        int a = C0250b.m77a(C0250b.m77a(17, (Object) this.f140a), (Object) this.f141b);
        if (this.f142c != null) {
            Iterator it = this.f142c.iterator();
            while (true) {
                i = a;
                if (!it.hasNext()) {
                    break;
                }
                a = C0250b.m77a(i, (Object) (C0565n) it.next());
            }
        } else {
            i = a;
        }
        return C0250b.m77a(C0250b.m77a(C0250b.m79a(i, this.f145f), (Object) this.f143d), (Object) this.f144e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((mo4967c() * 30) + 50);
        if (this.f141b != null) {
            sb.append(this.f141b);
            sb.append("->");
        }
        sb.append('{');
        if (this.f143d == C0311g.TUNNELLED) {
            sb.append('t');
        }
        if (this.f144e == C0310f.LAYERED) {
            sb.append('l');
        }
        if (this.f145f) {
            sb.append('s');
        }
        sb.append("}->");
        if (this.f142c != null) {
            for (C0565n append : this.f142c) {
                sb.append(append);
                sb.append("->");
            }
        }
        sb.append(this.f140a);
        return sb.toString();
    }
}
