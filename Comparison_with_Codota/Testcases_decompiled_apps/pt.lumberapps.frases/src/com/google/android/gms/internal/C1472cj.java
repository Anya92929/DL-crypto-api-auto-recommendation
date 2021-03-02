package com.google.android.gms.internal;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: com.google.android.gms.internal.cj */
final class C1472cj extends zzanh {
    C1472cj() {
    }

    /* renamed from: a */
    public Calendar zzb(zzaom zzaom) {
        int i = 0;
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        zzaom.beginObject();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (zzaom.mo7902b() != zzaon.END_OBJECT) {
            String nextName = zzaom.nextName();
            int nextInt = zzaom.nextInt();
            if ("year".equals(nextName)) {
                i6 = nextInt;
            } else if ("month".equals(nextName)) {
                i5 = nextInt;
            } else if ("dayOfMonth".equals(nextName)) {
                i4 = nextInt;
            } else if ("hourOfDay".equals(nextName)) {
                i3 = nextInt;
            } else if ("minute".equals(nextName)) {
                i2 = nextInt;
            } else if ("second".equals(nextName)) {
                i = nextInt;
            }
        }
        zzaom.endObject();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Calendar calendar) {
        if (calendar == null) {
            zzaoo.mo7926l();
            return;
        }
        zzaoo.mo7924j();
        zzaoo.zztr("year");
        zzaoo.zzcr((long) calendar.get(1));
        zzaoo.zztr("month");
        zzaoo.zzcr((long) calendar.get(2));
        zzaoo.zztr("dayOfMonth");
        zzaoo.zzcr((long) calendar.get(5));
        zzaoo.zztr("hourOfDay");
        zzaoo.zzcr((long) calendar.get(11));
        zzaoo.zztr("minute");
        zzaoo.zzcr((long) calendar.get(12));
        zzaoo.zztr("second");
        zzaoo.zzcr((long) calendar.get(13));
        zzaoo.mo7925k();
    }
}
