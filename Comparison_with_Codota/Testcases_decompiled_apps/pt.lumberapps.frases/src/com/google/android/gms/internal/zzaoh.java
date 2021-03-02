package com.google.android.gms.internal;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzaoh extends zzanh {
    public static final zzani bfu = new C1460by();

    /* renamed from: a */
    private final DateFormat f5846a = new SimpleDateFormat("MMM d, yyyy");

    public synchronized void zza(zzaoo zzaoo, Date date) {
        zzaoo.zzts(date == null ? null : this.f5846a.format(date));
    }

    /* renamed from: zzm */
    public synchronized Date zzb(zzaom zzaom) {
        Date date;
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.f5846a.parse(zzaom.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzane((Throwable) e);
            }
        }
        return date;
    }
}
