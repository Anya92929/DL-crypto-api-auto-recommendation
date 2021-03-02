package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: com.google.a.b.a.aq */
final class C0384aq extends C0363al<Calendar> {
    C0384aq() {
    }

    /* renamed from: a */
    public Calendar mo6310b(C0470a aVar) {
        int i = 0;
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        aVar.mo6377c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (aVar.mo6381f() != C0472c.END_OBJECT) {
            String g = aVar.mo6382g();
            int m = aVar.mo6388m();
            if ("year".equals(g)) {
                i6 = m;
            } else if ("month".equals(g)) {
                i5 = m;
            } else if ("dayOfMonth".equals(g)) {
                i4 = m;
            } else if ("hourOfDay".equals(g)) {
                i3 = m;
            } else if ("minute".equals(g)) {
                i2 = m;
            } else if ("second".equals(g)) {
                i = m;
            }
        }
        aVar.mo6379d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Calendar calendar) {
        if (calendar == null) {
            dVar.mo6405f();
            return;
        }
        dVar.mo6403d();
        dVar.mo6396a("year");
        dVar.mo6394a((long) calendar.get(1));
        dVar.mo6396a("month");
        dVar.mo6394a((long) calendar.get(2));
        dVar.mo6396a("dayOfMonth");
        dVar.mo6394a((long) calendar.get(5));
        dVar.mo6396a("hourOfDay");
        dVar.mo6394a((long) calendar.get(11));
        dVar.mo6396a("minute");
        dVar.mo6394a((long) calendar.get(12));
        dVar.mo6396a("second");
        dVar.mo6394a((long) calendar.get(13));
        dVar.mo6404e();
    }
}
