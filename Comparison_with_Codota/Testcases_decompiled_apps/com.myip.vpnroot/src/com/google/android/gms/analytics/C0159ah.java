package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0175j;

/* renamed from: com.google.android.gms.analytics.ah */
class C0159ah extends C0175j<C0161ai> {

    /* renamed from: com.google.android.gms.analytics.ah$a */
    private static class C0160a implements C0175j.C0176a<C0161ai> {

        /* renamed from: BB */
        private final C0161ai f155BB = new C0161ai();

        /* renamed from: c */
        public void mo3632c(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.f155BB.f158BE = i;
            } else {
                C0207z.m309W("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: d */
        public void mo3633d(String str, boolean z) {
            int i = 1;
            if ("ga_autoActivityTracking".equals(str)) {
                C0161ai aiVar = this.f155BB;
                if (!z) {
                    i = 0;
                }
                aiVar.f159BF = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                C0161ai aiVar2 = this.f155BB;
                if (!z) {
                    i = 0;
                }
                aiVar2.f160BG = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                C0161ai aiVar3 = this.f155BB;
                if (!z) {
                    i = 0;
                }
                aiVar3.f161BH = i;
            } else {
                C0207z.m309W("bool configuration name not recognized:  " + str);
            }
        }

        /* renamed from: eZ */
        public C0161ai mo3634dX() {
            return this.f155BB;
        }

        /* renamed from: f */
        public void mo3636f(String str, String str2) {
            this.f155BB.f162BI.put(str, str2);
        }

        /* renamed from: g */
        public void mo3637g(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.f155BB.f156BC = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.f155BB.f157BD = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    C0207z.m306T("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                C0207z.m309W("string configuration name not recognized:  " + str);
            }
        }
    }

    public C0159ah(Context context) {
        super(context, new C0160a());
    }
}
