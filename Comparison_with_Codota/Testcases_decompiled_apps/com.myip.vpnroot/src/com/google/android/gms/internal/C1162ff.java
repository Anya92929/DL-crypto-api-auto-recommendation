package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C1164fg;

@C1130ez
/* renamed from: com.google.android.gms.internal.ff */
public final class C1162ff {

    /* renamed from: com.google.android.gms.internal.ff$a */
    public interface C1163a {
        /* renamed from: a */
        void mo8468a(C1171fk fkVar);
    }

    /* renamed from: a */
    public static C1206gg m4442a(Context context, C1168fi fiVar, C1163a aVar) {
        return fiVar.f3529lD.f3780wG ? m4443b(context, fiVar, aVar) : m4444c(context, fiVar, aVar);
    }

    /* renamed from: b */
    private static C1206gg m4443b(Context context, C1168fi fiVar, C1163a aVar) {
        C1229gs.m4675S("Fetching ad response from local ad request service.");
        C1164fg.C1165a aVar2 = new C1164fg.C1165a(context, fiVar, aVar);
        aVar2.start();
        return aVar2;
    }

    /* renamed from: c */
    private static C1206gg m4444c(Context context, C1168fi fiVar, C1163a aVar) {
        C1229gs.m4675S("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C1164fg.C1166b(context, fiVar, aVar);
        }
        C1229gs.m4679W("Failed to connect to remote ad request service.");
        return null;
    }
}
