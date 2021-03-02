package com.google.android.gms.location;

import com.google.android.gms.common.api.C0702a;
import com.google.android.gms.common.api.C0739d;
import com.google.android.gms.common.api.C0742g;
import com.google.android.gms.common.api.C0744i;
import com.google.android.gms.common.api.C0749n;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.location.internal.C1124d;
import com.google.android.gms.location.internal.C1125e;
import com.google.android.gms.location.internal.C1138r;
import com.google.android.gms.location.internal.C1143w;

/* renamed from: com.google.android.gms.location.h */
public class C1119h {

    /* renamed from: a */
    public static final C0702a<C0739d> f4933a = new C0702a<>("LocationServices.API", f4938f, f4937e);

    /* renamed from: b */
    public static final C1115d f4934b = new C1124d();

    /* renamed from: c */
    public static final C1116e f4935c = new C1125e();

    /* renamed from: d */
    public static final C1144j f4936d = new C1143w();

    /* renamed from: e */
    private static final C0744i<C1138r> f4937e = new C0744i<>();

    /* renamed from: f */
    private static final C0742g<C1138r, C0739d> f4938f = new C1120i();

    /* renamed from: a */
    public static C1138r m4842a(C0749n nVar) {
        boolean z = true;
        C1009bf.m4537b(nVar != null, "GoogleApiClient parameter is required.");
        C1138r rVar = (C1138r) nVar.mo7371a(f4937e);
        if (rVar == null) {
            z = false;
        }
        C1009bf.m4533a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return rVar;
    }
}
