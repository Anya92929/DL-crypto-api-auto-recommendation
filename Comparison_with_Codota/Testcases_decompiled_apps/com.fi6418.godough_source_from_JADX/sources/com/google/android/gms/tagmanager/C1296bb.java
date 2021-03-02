package com.google.android.gms.tagmanager;

import android.content.Context;

/* renamed from: com.google.android.gms.tagmanager.bb */
class C1296bb implements C1315f {

    /* renamed from: a */
    private final Context f5364a;

    public C1296bb(Context context) {
        this.f5364a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r4.get("gtm");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9123a(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "gtm.url"
            java.lang.Object r1 = r4.get(r0)
            if (r1 != 0) goto L_0x0037
            java.lang.String r0 = "gtm"
            java.lang.Object r0 = r4.get(r0)
            if (r0 == 0) goto L_0x0037
            boolean r2 = r0 instanceof java.util.Map
            if (r2 == 0) goto L_0x0037
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "url"
            java.lang.Object r0 = r0.get(r1)
        L_0x001c:
            if (r0 == 0) goto L_0x0022
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0023
        L_0x0022:
            return
        L_0x0023:
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r1 = "referrer"
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x0022
            android.content.Context r1 = r3.f5364a
            com.google.android.gms.tagmanager.C1332w.m5439a((android.content.Context) r1, (java.lang.String) r0)
            goto L_0x0022
        L_0x0037:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1296bb.mo9123a(java.util.Map):void");
    }
}
