package com.google.android.gms.internal;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzaoi extends zzanh {
    public static final zzani bfu = new C1461bz();

    /* renamed from: a */
    private final DateFormat f5847a = new SimpleDateFormat("hh:mm:ss a");

    public synchronized void zza(zzaoo zzaoo, Time time) {
        zzaoo.zzts(time == null ? null : this.f5847a.format(time));
    }

    /* renamed from: zzn */
    public synchronized Time zzb(zzaom zzaom) {
        Time time;
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.f5847a.parse(zzaom.nextString()).getTime());
            } catch (ParseException e) {
                throw new zzane((Throwable) e);
            }
        }
        return time;
    }
}
