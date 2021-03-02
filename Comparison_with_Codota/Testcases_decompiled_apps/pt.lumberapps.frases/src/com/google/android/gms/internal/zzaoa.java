package com.google.android.gms.internal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzaoa extends zzanh {
    public static final zzani bfu = new C1452bq();

    /* renamed from: a */
    private final DateFormat f5826a = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: b */
    private final DateFormat f5827b = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: c */
    private final DateFormat f5828c = m6696a();

    /* renamed from: a */
    private static DateFormat m6696a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    /* renamed from: a */
    private synchronized Date m6697a(String str) {
        Date parse;
        try {
            parse = this.f5827b.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f5826a.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f5828c.parse(str);
                } catch (ParseException e3) {
                    throw new zzane(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void zza(zzaoo zzaoo, Date date) {
        if (date == null) {
            zzaoo.mo7926l();
        } else {
            zzaoo.zzts(this.f5826a.format(date));
        }
    }

    /* renamed from: zzk */
    public Date zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return m6697a(zzaom.nextString());
        }
        zzaom.nextNull();
        return null;
    }
}
