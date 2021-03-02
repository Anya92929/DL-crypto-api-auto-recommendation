package org.p004a.p005a.p025g.p029d;

import android.support.p003v7.internal.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0345a;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0350f;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.d.aa */
public class C0458aa extends C0485s {

    /* renamed from: a */
    private static final C0350f f454a = new C0350f();

    /* renamed from: b */
    private static final String[] f455b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};

    /* renamed from: c */
    private final String[] f456c;

    /* renamed from: d */
    private final boolean f457d;

    public C0458aa() {
        this((String[]) null, false);
    }

    public C0458aa(String[] strArr, boolean z) {
        if (strArr != null) {
            this.f456c = (String[]) strArr.clone();
        } else {
            this.f456c = f455b;
        }
        this.f457d = z;
        mo5262a("version", new C0460ac());
        mo5262a("path", new C0475i());
        mo5262a("domain", new C0492z());
        mo5262a("max-age", new C0474h());
        mo5262a("secure", new C0476j());
        mo5262a("comment", new C0471e());
        mo5262a("expires", new C0473g(this.f456c));
    }

    /* renamed from: a */
    private static void m820a(C0563b bVar, String str, String str2, int i) {
        bVar.mo5428a(str);
        bVar.mo5428a("=");
        if (str2 == null) {
            return;
        }
        if (i > 0) {
            bVar.mo5427a('\"');
            bVar.mo5428a(str2);
            bVar.mo5427a('\"');
            return;
        }
        bVar.mo5428a(str2);
    }

    /* renamed from: b */
    private List m821b(List list) {
        int i;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        Iterator it = list.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            C0346b bVar = (C0346b) it.next();
            i2 = bVar.mo5052g() < i ? bVar.mo5052g() : i;
        }
        C0563b bVar2 = new C0563b(list.size() * 40);
        bVar2.mo5428a("Cookie");
        bVar2.mo5428a(": ");
        bVar2.mo5428a("$Version=");
        bVar2.mo5428a(Integer.toString(i));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            bVar2.mo5428a("; ");
            mo5258a(bVar2, (C0346b) it2.next(), i);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new C0536o(bVar2));
        return arrayList;
    }

    /* renamed from: c */
    private List m822c(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0346b bVar = (C0346b) it.next();
            int g = bVar.mo5052g();
            C0563b bVar2 = new C0563b(40);
            bVar2.mo5428a("Cookie: ");
            bVar2.mo5428a("$Version=");
            bVar2.mo5428a(Integer.toString(g));
            bVar2.mo5428a("; ");
            mo5258a(bVar2, bVar, g);
            arrayList.add(new C0536o(bVar2));
        }
        return arrayList;
    }

    /* renamed from: a */
    public int mo5063a() {
        return 1;
    }

    /* renamed from: a */
    public final List mo5064a(List list) {
        C0250b.m90a((Collection) list, "List of cookies");
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, f454a);
            list = arrayList;
        }
        return this.f457d ? m821b(list) : m822c(list);
    }

    /* renamed from: a */
    public List mo5065a(C0344e eVar, C0349e eVar2) {
        C0250b.m84a((Object) eVar, "Header");
        C0250b.m84a((Object) eVar2, "Cookie origin");
        if (eVar.mo5040c().equalsIgnoreCase("Set-Cookie")) {
            return mo5260a(eVar.mo5042e(), eVar2);
        }
        throw new C0357m("Unrecognized cookie header '" + eVar.toString() + "'");
    }

    /* renamed from: a */
    public void mo5066a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        String a = bVar.mo5045a();
        if (a.indexOf(32) != -1) {
            throw new C0351g("Cookie name may not contain blanks");
        } else if (a.startsWith("$")) {
            throw new C0351g("Cookie name may not start with $");
        } else {
            super.mo5066a(bVar, eVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5258a(C0563b bVar, C0346b bVar2, int i) {
        m820a(bVar, bVar2.mo5045a(), bVar2.mo5047b(), i);
        if (bVar2.mo5049d() != null && (bVar2 instanceof C0345a) && ((C0345a) bVar2).mo5044b("path")) {
            bVar.mo5428a("; ");
            m820a(bVar, "$Path", bVar2.mo5049d(), i);
        }
        if (bVar2.mo5048c() != null && (bVar2 instanceof C0345a) && ((C0345a) bVar2).mo5044b("domain")) {
            bVar.mo5428a("; ");
            m820a(bVar, "$Domain", bVar2.mo5048c(), i);
        }
    }

    /* renamed from: b */
    public C0344e mo5067b() {
        return null;
    }

    public String toString() {
        return "rfc2109";
    }
}
