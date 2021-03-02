package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.cl */
final class C1474cl extends zzanh {
    C1474cl() {
    }

    /* renamed from: a */
    public zzamv zzb(zzaom zzaom) {
        switch (zzaom.mo7902b()) {
            case NUMBER:
                return new zzanb((Number) new zzans(zzaom.nextString()));
            case BOOLEAN:
                return new zzanb(Boolean.valueOf(zzaom.nextBoolean()));
            case STRING:
                return new zzanb(zzaom.nextString());
            case NULL:
                zzaom.nextNull();
                return zzamx.bei;
            case BEGIN_ARRAY:
                zzams zzams = new zzams();
                zzaom.beginArray();
                while (zzaom.hasNext()) {
                    zzams.zzc((zzamv) zzb(zzaom));
                }
                zzaom.endArray();
                return zzams;
            case BEGIN_OBJECT:
                zzamy zzamy = new zzamy();
                zzaom.beginObject();
                while (zzaom.hasNext()) {
                    zzamy.zza(zzaom.nextName(), (zzamv) zzb(zzaom));
                }
                zzaom.endObject();
                return zzamy;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, zzamv zzamv) {
        if (zzamv == null || zzamv.zzczj()) {
            zzaoo.mo7926l();
        } else if (zzamv.zzczi()) {
            zzanb zzczm = zzamv.zzczm();
            if (zzczm.zzczp()) {
                zzaoo.zza(zzczm.zzcze());
            } else if (zzczm.zzczo()) {
                zzaoo.zzda(zzczm.getAsBoolean());
            } else {
                zzaoo.zzts(zzczm.zzczf());
            }
        } else if (zzamv.zzczg()) {
            zzaoo.mo7922h();
            Iterator it = zzamv.zzczl().iterator();
            while (it.hasNext()) {
                zza(zzaoo, (zzamv) it.next());
            }
            zzaoo.mo7923i();
        } else if (zzamv.zzczh()) {
            zzaoo.mo7924j();
            for (Map.Entry entry : zzamv.zzczk().entrySet()) {
                zzaoo.zztr((String) entry.getKey());
                zza(zzaoo, (zzamv) entry.getValue());
            }
            zzaoo.mo7925k();
        } else {
            String valueOf = String.valueOf(zzamv.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
        }
    }
}
