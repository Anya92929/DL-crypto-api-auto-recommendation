package org.p004a.p005a.p021e;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: org.a.a.e.d */
public final class C0348d implements Serializable, Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C0346b bVar = (C0346b) obj;
        C0346b bVar2 = (C0346b) obj2;
        int compareTo = bVar.mo5045a().compareTo(bVar2.mo5045a());
        if (compareTo == 0) {
            String c = bVar.mo5048c();
            if (c == null) {
                c = "";
            } else if (c.indexOf(46) == -1) {
                c = c + ".local";
            }
            String c2 = bVar2.mo5048c();
            if (c2 == null) {
                c2 = "";
            } else if (c2.indexOf(46) == -1) {
                c2 = c2 + ".local";
            }
            compareTo = c.compareToIgnoreCase(c2);
        }
        if (compareTo != 0) {
            return compareTo;
        }
        String d = bVar.mo5049d();
        if (d == null) {
            d = "/";
        }
        String d2 = bVar2.mo5049d();
        if (d2 == null) {
            d2 = "/";
        }
        return d.compareTo(d2);
    }
}
