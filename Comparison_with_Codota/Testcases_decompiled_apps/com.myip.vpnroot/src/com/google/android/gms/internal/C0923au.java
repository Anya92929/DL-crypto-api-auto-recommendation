package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0599g;
import com.google.android.gms.internal.C0935bd;
import com.google.android.gms.internal.C0938be;

@C1130ez
/* renamed from: com.google.android.gms.internal.au */
public final class C0923au extends C0599g<C0938be> {

    /* renamed from: nS */
    private static final C0923au f2609nS = new C0923au();

    private C0923au() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* renamed from: a */
    public static C0935bd m3904a(Context context, C0927ay ayVar, String str, C1012cs csVar) {
        C0935bd b;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0 && (b = f2609nS.m3905b(context, ayVar, str, csVar)) != null) {
            return b;
        }
        C1229gs.m4675S("Using AdManager from the client jar.");
        return new C1735u(context, ayVar, str, csVar, new C1230gt(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    /* renamed from: b */
    private C0935bd m3905b(Context context, C0927ay ayVar, String str, C1012cs csVar) {
        try {
            return C0935bd.C0936a.m3934f(((C0938be) mo5547L(context)).mo8057a(C0597e.m1743k(context), ayVar, str, csVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not create remote AdManager.", e);
            return null;
        } catch (C0599g.C0600a e2) {
            C1229gs.m4683d("Could not create remote AdManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0938be mo4552d(IBinder iBinder) {
        return C0938be.C0939a.m3947g(iBinder);
    }
}
