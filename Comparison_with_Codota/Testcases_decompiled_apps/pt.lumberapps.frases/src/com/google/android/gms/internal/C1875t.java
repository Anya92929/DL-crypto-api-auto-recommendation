package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.google.android.gms.internal.t */
final class C1875t implements zzamu, zzand {

    /* renamed from: a */
    private final DateFormat f5543a;

    /* renamed from: b */
    private final DateFormat f5544b;

    /* renamed from: c */
    private final DateFormat f5545c;

    C1875t() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public C1875t(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    C1875t(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    C1875t(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f5543a = dateFormat;
        this.f5544b = dateFormat2;
        this.f5545c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f5545c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: a */
    private Date m6612a(zzamv zzamv) {
        Date parse;
        synchronized (this.f5544b) {
            try {
                parse = this.f5544b.parse(zzamv.zzczf());
            } catch (ParseException e) {
                throw new zzane(zzamv.zzczf(), e);
            } catch (ParseException e2) {
                try {
                    parse = this.f5543a.parse(zzamv.zzczf());
                } catch (ParseException e3) {
                    parse = this.f5545c.parse(zzamv.zzczf());
                }
            }
        }
        return parse;
    }

    /* renamed from: a */
    public zzamv zza(Date date, Type type, zzanc zzanc) {
        zzanb zzanb;
        synchronized (this.f5544b) {
            zzanb = new zzanb(this.f5543a.format(date));
        }
        return zzanb;
    }

    /* renamed from: a */
    public Date zzb(zzamv zzamv, Type type, zzamt zzamt) {
        if (!(zzamv instanceof zzanb)) {
            throw new zzamz("The date should be a string value");
        }
        Date a = m6612a(zzamv);
        if (type == Date.class) {
            return a;
        }
        if (type == Timestamp.class) {
            return new Timestamp(a.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(a.getTime());
        }
        String valueOf = String.valueOf(getClass());
        String valueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C1875t.class.getSimpleName());
        sb.append('(').append(this.f5544b.getClass().getSimpleName()).append(')');
        return sb.toString();
    }
}
