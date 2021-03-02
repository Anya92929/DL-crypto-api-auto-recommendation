package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: com.google.a.b.a.u */
public final class C0421u extends C0363al<Date> {

    /* renamed from: a */
    public static final C0364am f3440a = new C0422v();

    /* renamed from: b */
    private final DateFormat f3441b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: a */
    public synchronized Date mo6310b(C0470a aVar) {
        Date date;
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            date = null;
        } else {
            try {
                date = new Date(this.f3441b.parse(aVar.mo6383h()).getTime());
            } catch (ParseException e) {
                throw new C0356ae((Throwable) e);
            }
        }
        return date;
    }

    /* renamed from: a */
    public synchronized void mo6309a(C0473d dVar, Date date) {
        dVar.mo6400b(date == null ? null : this.f3441b.format(date));
    }
}
