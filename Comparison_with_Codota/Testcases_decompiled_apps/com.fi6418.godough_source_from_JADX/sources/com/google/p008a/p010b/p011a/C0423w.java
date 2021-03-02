package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: com.google.a.b.a.w */
public final class C0423w extends C0363al<Time> {

    /* renamed from: a */
    public static final C0364am f3442a = new C0424x();

    /* renamed from: b */
    private final DateFormat f3443b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: a */
    public synchronized Time mo6310b(C0470a aVar) {
        Time time;
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            time = null;
        } else {
            try {
                time = new Time(this.f3443b.parse(aVar.mo6383h()).getTime());
            } catch (ParseException e) {
                throw new C0356ae((Throwable) e);
            }
        }
        return time;
    }

    /* renamed from: a */
    public synchronized void mo6309a(C0473d dVar, Time time) {
        dVar.mo6400b(time == null ? null : this.f3443b.format(time));
    }
}
