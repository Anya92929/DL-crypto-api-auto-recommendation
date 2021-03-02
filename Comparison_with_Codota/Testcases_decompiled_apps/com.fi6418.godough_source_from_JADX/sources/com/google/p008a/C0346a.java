package com.google.p008a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.google.a.a */
final class C0346a implements C0355ad<Date>, C0492v<Date> {

    /* renamed from: a */
    private final DateFormat f3362a;

    /* renamed from: b */
    private final DateFormat f3363b;

    /* renamed from: c */
    private final DateFormat f3364c;

    C0346a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public C0346a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    C0346a(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    C0346a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f3362a = dateFormat;
        this.f3363b = dateFormat2;
        this.f3364c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f3364c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: a */
    private Date m2474a(C0493w wVar) {
        Date parse;
        synchronized (this.f3363b) {
            try {
                parse = this.f3363b.parse(wVar.mo6298b());
            } catch (ParseException e) {
                throw new C0356ae(wVar.mo6298b(), e);
            } catch (ParseException e2) {
                try {
                    parse = this.f3362a.parse(wVar.mo6298b());
                } catch (ParseException e3) {
                    parse = this.f3364c.parse(wVar.mo6298b());
                }
            }
        }
        return parse;
    }

    /* renamed from: a */
    public C0493w mo6285a(Date date, Type type, C0354ac acVar) {
        C0353ab abVar;
        synchronized (this.f3363b) {
            abVar = new C0353ab(this.f3362a.format(date));
        }
        return abVar;
    }

    /* renamed from: a */
    public Date mo6288b(C0493w wVar, Type type, C0491u uVar) {
        if (!(wVar instanceof C0353ab)) {
            throw new C0352aa("The date should be a string value");
        }
        Date a = m2474a(wVar);
        if (type == Date.class) {
            return a;
        }
        if (type == Timestamp.class) {
            return new Timestamp(a.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(a.getTime());
        }
        throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C0346a.class.getSimpleName());
        sb.append('(').append(this.f3363b.getClass().getSimpleName()).append(')');
        return sb.toString();
    }
}
