package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.google.a.b.a.e */
public final class C0405e extends C0363al<Date> {

    /* renamed from: a */
    public static final C0364am f3404a = new C0406f();

    /* renamed from: b */
    private final DateFormat f3405b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c */
    private final DateFormat f3406c = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: d */
    private final DateFormat f3407d = m2632a();

    /* renamed from: a */
    private static DateFormat m2632a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    /* renamed from: a */
    private synchronized Date m2633a(String str) {
        Date parse;
        try {
            parse = this.f3406c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f3405b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f3407d.parse(str);
                } catch (ParseException e3) {
                    throw new C0356ae(str, e3);
                }
            }
        }
        return parse;
    }

    /* renamed from: a */
    public Date mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return m2633a(aVar.mo6383h());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public synchronized void mo6309a(C0473d dVar, Date date) {
        if (date == null) {
            dVar.mo6405f();
        } else {
            dVar.mo6400b(this.f3405b.format(date));
        }
    }
}
