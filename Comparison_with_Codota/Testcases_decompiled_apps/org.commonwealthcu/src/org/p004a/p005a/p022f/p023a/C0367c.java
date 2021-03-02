package org.p004a.p005a.p022f.p023a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: org.a.a.f.a.c */
public final class C0367c implements Iterable {

    /* renamed from: a */
    private final List f200a = new LinkedList();

    /* renamed from: b */
    private final Map f201b = new HashMap();

    /* renamed from: a */
    public final C0373i mo5105a(String str) {
        List list = (List) this.f201b.get(str.toLowerCase(Locale.US));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (C0373i) list.get(0);
    }

    /* renamed from: a */
    public final void mo5106a(C0373i iVar) {
        String lowerCase = iVar.mo5109a().toLowerCase(Locale.US);
        List list = (List) this.f201b.get(lowerCase);
        if (list == null) {
            list = new LinkedList();
            this.f201b.put(lowerCase, list);
        }
        list.add(iVar);
        this.f200a.add(iVar);
    }

    public final Iterator iterator() {
        return Collections.unmodifiableList(this.f200a).iterator();
    }

    public final String toString() {
        return this.f200a.toString();
    }
}
