package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0175j;

/* renamed from: com.google.android.gms.analytics.u */
class C0201u extends C0175j<C0203v> {

    /* renamed from: com.google.android.gms.analytics.u$a */
    private static class C0202a implements C0175j.C0176a<C0203v> {

        /* renamed from: Ar */
        private final C0203v f317Ar = new C0203v();

        /* renamed from: c */
        public void mo3632c(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.f317Ar.f319At = i;
            } else {
                C0207z.m309W("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: d */
        public void mo3633d(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.f317Ar.f320Au = z ? 1 : 0;
                return;
            }
            C0207z.m309W("bool configuration name not recognized:  " + str);
        }

        /* renamed from: et */
        public C0203v mo3634dX() {
            return this.f317Ar;
        }

        /* renamed from: f */
        public void mo3636f(String str, String str2) {
        }

        /* renamed from: g */
        public void mo3637g(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.f317Ar.f321xL = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.f317Ar.f322xM = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.f317Ar.f318As = str2;
            } else {
                C0207z.m309W("string configuration name not recognized:  " + str);
            }
        }
    }

    public C0201u(Context context) {
        super(context, new C0202a());
    }
}
