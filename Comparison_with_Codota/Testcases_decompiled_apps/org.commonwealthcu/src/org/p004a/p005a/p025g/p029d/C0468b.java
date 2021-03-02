package org.p004a.p005a.p025g.p029d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0352h;

/* renamed from: org.a.a.g.d.b */
public abstract class C0468b implements C0352h {

    /* renamed from: a */
    private final Map f462a = new HashMap(10);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C0347c mo5261a(String str) {
        return (C0347c) this.f462a.get(str);
    }

    /* renamed from: a */
    public final void mo5262a(String str, C0347c cVar) {
        C0250b.m84a((Object) str, "Attribute name");
        C0250b.m84a((Object) cVar, "Attribute handler");
        this.f462a.put(str, cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final Collection mo5263c() {
        return this.f462a.values();
    }
}
