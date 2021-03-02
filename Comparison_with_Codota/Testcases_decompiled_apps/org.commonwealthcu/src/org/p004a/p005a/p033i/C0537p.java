package org.p004a.p005a.p033i;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0513h;

/* renamed from: org.a.a.i.p */
public final class C0537p implements Serializable, Cloneable {

    /* renamed from: a */
    private final List f603a = new ArrayList(16);

    /* renamed from: a */
    public final void mo5371a() {
        this.f603a.clear();
    }

    /* renamed from: a */
    public final void mo5372a(C0344e eVar) {
        if (eVar != null) {
            this.f603a.add(eVar);
        }
    }

    /* renamed from: a */
    public final void mo5373a(C0344e[] eVarArr) {
        mo5371a();
        if (eVarArr != null) {
            Collections.addAll(this.f603a, eVarArr);
        }
    }

    /* renamed from: a */
    public final C0344e[] mo5374a(String str) {
        ArrayList arrayList = new ArrayList();
        for (C0344e eVar : this.f603a) {
            if (eVar.mo5040c().equalsIgnoreCase(str)) {
                arrayList.add(eVar);
            }
        }
        return (C0344e[]) arrayList.toArray(new C0344e[arrayList.size()]);
    }

    /* renamed from: b */
    public final C0344e mo5375b(String str) {
        for (C0344e eVar : this.f603a) {
            if (eVar.mo5040c().equalsIgnoreCase(str)) {
                return eVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final void mo5376b(C0344e eVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f603a.size()) {
                this.f603a.add(eVar);
                return;
            } else if (((C0344e) this.f603a.get(i2)).mo5040c().equalsIgnoreCase(eVar.mo5040c())) {
                this.f603a.set(i2, eVar);
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* renamed from: b */
    public final C0344e[] mo5377b() {
        return (C0344e[]) this.f603a.toArray(new C0344e[this.f603a.size()]);
    }

    /* renamed from: c */
    public final C0513h mo5378c() {
        return new C0531j(this.f603a, (String) null);
    }

    /* renamed from: c */
    public final boolean mo5379c(String str) {
        for (C0344e c : this.f603a) {
            if (c.mo5040c().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final C0513h mo5381d(String str) {
        return new C0531j(this.f603a, str);
    }

    public final String toString() {
        return this.f603a.toString();
    }
}
