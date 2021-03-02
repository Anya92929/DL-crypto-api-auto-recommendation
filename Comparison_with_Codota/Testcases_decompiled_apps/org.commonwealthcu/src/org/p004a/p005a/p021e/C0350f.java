package org.p004a.p005a.p021e;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: org.a.a.e.f */
public final class C0350f implements Serializable, Comparator {
    /* renamed from: a */
    private static String m367a(C0346b bVar) {
        String d = bVar.mo5049d();
        if (d == null) {
            d = "/";
        }
        return !d.endsWith("/") ? d + '/' : d;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String a = m367a((C0346b) obj);
        String a2 = m367a((C0346b) obj2);
        if (!a.equals(a2)) {
            if (a.startsWith(a2)) {
                return -1;
            }
            if (a2.startsWith(a)) {
                return 1;
            }
        }
        return 0;
    }
}
