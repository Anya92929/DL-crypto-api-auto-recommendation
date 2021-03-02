package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.ai */
class C0161ai implements C0174i {

    /* renamed from: BC */
    String f156BC;

    /* renamed from: BD */
    double f157BD = -1.0d;

    /* renamed from: BE */
    int f158BE = -1;

    /* renamed from: BF */
    int f159BF = -1;

    /* renamed from: BG */
    int f160BG = -1;

    /* renamed from: BH */
    int f161BH = -1;

    /* renamed from: BI */
    Map<String, String> f162BI = new HashMap();

    C0161ai() {
    }

    /* renamed from: am */
    public String mo3638am(String str) {
        String str2 = this.f162BI.get(str);
        return str2 != null ? str2 : str;
    }

    /* renamed from: fa */
    public boolean mo3639fa() {
        return this.f156BC != null;
    }

    /* renamed from: fb */
    public String mo3640fb() {
        return this.f156BC;
    }

    /* renamed from: fc */
    public boolean mo3641fc() {
        return this.f157BD >= 0.0d;
    }

    /* renamed from: fd */
    public double mo3642fd() {
        return this.f157BD;
    }

    /* renamed from: fe */
    public boolean mo3643fe() {
        return this.f158BE >= 0;
    }

    /* renamed from: ff */
    public boolean mo3644ff() {
        return this.f159BF != -1;
    }

    /* renamed from: fg */
    public boolean mo3645fg() {
        return this.f159BF == 1;
    }

    /* renamed from: fh */
    public boolean mo3646fh() {
        return this.f160BG != -1;
    }

    /* renamed from: fi */
    public boolean mo3647fi() {
        return this.f160BG == 1;
    }

    /* renamed from: fj */
    public boolean mo3648fj() {
        return this.f161BH == 1;
    }

    public int getSessionTimeout() {
        return this.f158BE;
    }

    /* renamed from: k */
    public String mo3650k(Activity activity) {
        return mo3638am(activity.getClass().getCanonicalName());
    }
}
