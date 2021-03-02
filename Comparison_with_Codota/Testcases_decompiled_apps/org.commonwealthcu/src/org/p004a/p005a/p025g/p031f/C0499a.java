package org.p004a.p005a.p025g.p031f;

import java.util.ArrayList;
import java.util.List;
import org.p004a.p005a.C0239aa;
import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.C0575x;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p013c.C0299b;
import org.p004a.p005a.p032h.C0516c;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p033i.C0530i;
import org.p004a.p005a.p033i.C0540s;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.f.a */
public abstract class C0499a implements C0516c {

    /* renamed from: a */
    protected final C0540s f500a;

    /* renamed from: b */
    private final C0519f f501b;

    /* renamed from: c */
    private final C0299b f502c;

    /* renamed from: d */
    private final List f503d;

    /* renamed from: e */
    private int f504e;

    /* renamed from: f */
    private C0567p f505f;

    public C0499a(C0519f fVar, C0540s sVar, C0544b bVar) {
        C0250b.m84a((Object) fVar, "Session input buffer");
        C0250b.m84a((Object) bVar, "HTTP parameters");
        this.f501b = fVar;
        this.f502c = C0299b.m208c().mo4948b(bVar.mo5389a("http.connection.max-header-count", -1)).mo4947a(bVar.mo5389a("http.connection.max-line-length", -1)).mo4946a();
        this.f500a = sVar == null ? C0530i.f582a : sVar;
        this.f503d = new ArrayList();
        this.f504e = 0;
    }

    /* renamed from: a */
    public static C0344e[] m957a(C0519f fVar, int i, int i2, C0540s sVar, List list) {
        C0563b bVar;
        int i3 = 0;
        C0250b.m84a((Object) fVar, "Session input buffer");
        C0250b.m84a((Object) sVar, "Line parser");
        C0250b.m84a((Object) list, "Header line list");
        C0563b bVar2 = null;
        C0563b bVar3 = null;
        while (true) {
            if (bVar3 == null) {
                bVar3 = new C0563b(64);
            } else {
                bVar3.mo5426a();
            }
            if (fVar.mo5234a(bVar3) == -1 || bVar3.mo5435c() <= 0) {
                C0344e[] eVarArr = new C0344e[list.size()];
            } else {
                if ((bVar3.mo5423a(0) == ' ' || bVar3.mo5423a(0) == 9) && bVar2 != null) {
                    int i4 = 0;
                    while (i4 < bVar3.mo5435c() && ((r5 = bVar3.mo5423a(i4)) == ' ' || r5 == 9)) {
                        i4++;
                    }
                    if (i2 <= 0 || ((bVar2.mo5435c() + 1) + bVar3.mo5435c()) - i4 <= i2) {
                        bVar2.mo5427a(' ');
                        bVar2.mo5429a(bVar3, i4, bVar3.mo5435c() - i4);
                        bVar = bVar3;
                        bVar3 = bVar2;
                    } else {
                        throw new C0575x("Maximum line length limit exceeded");
                    }
                } else {
                    list.add(bVar3);
                    bVar = null;
                }
                if (i <= 0 || list.size() < i) {
                    bVar2 = bVar3;
                    bVar3 = bVar;
                } else {
                    throw new C0575x("Maximum header count exceeded");
                }
            }
        }
        C0344e[] eVarArr2 = new C0344e[list.size()];
        while (i3 < list.size()) {
            try {
                eVarArr2[i3] = sVar.mo5352a((C0563b) list.get(i3));
                i3++;
            } catch (C0239aa e) {
                throw new C0240ab(e.getMessage());
            }
        }
        return eVarArr2;
    }

    /* renamed from: a */
    public final C0567p mo5278a() {
        switch (this.f504e) {
            case 0:
                try {
                    this.f505f = mo5227a(this.f501b);
                    this.f504e = 1;
                    break;
                } catch (C0239aa e) {
                    throw new C0240ab(e.getMessage(), e);
                }
            case 1:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.f505f.mo5322a(m957a(this.f501b, this.f502c.mo4943b(), this.f502c.mo4942a(), this.f500a, this.f503d));
        C0567p pVar = this.f505f;
        this.f505f = null;
        this.f503d.clear();
        this.f504e = 0;
        return pVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C0567p mo5227a(C0519f fVar);
}
