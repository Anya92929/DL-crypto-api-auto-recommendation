package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

/* renamed from: com.google.android.gms.internal.oa */
class C1787oa {

    /* renamed from: a */
    final ContentResolver f5413a;

    C1787oa(Context context) {
        if (context == null || !m6502a(context)) {
            this.f5413a = null;
            return;
        }
        this.f5413a = context.getContentResolver();
        zzaeo.zzb(this.f5413a, "gms:playlog:service:sampling_");
    }

    /* renamed from: a */
    private static boolean m6502a(Context context) {
        if (zzpg.f6768a == null) {
            zzpg.f6768a = Boolean.valueOf(context.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzpg.f6768a.booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo7596a() {
        if (this.f5413a == null) {
            return 0;
        }
        return zzaeo.getLong(this.f5413a, "android_id", 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo7597a(String str) {
        if (this.f5413a == null) {
            return null;
        }
        ContentResolver contentResolver = this.f5413a;
        String valueOf = String.valueOf("gms:playlog:service:sampling_");
        String valueOf2 = String.valueOf(str);
        return zzaeo.zza(contentResolver, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) null);
    }
}
