package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.dynamic.C0169e;
import com.google.android.gms.internal.C0202ac;
import com.google.android.gms.internal.C0205ad;

/* renamed from: com.google.android.gms.internal.u */
public final class C0619u extends C0169e<C0205ad> {

    /* renamed from: er */
    private static final C0619u f1576er = new C0619u();

    private C0619u() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* renamed from: a */
    public static C0202ac m1951a(Context context, C0622x xVar, String str, C0237av avVar) {
        C0202ac b;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0 && (b = f1576er.m1952b(context, xVar, str, avVar)) != null) {
            return b;
        }
        C0344cn.m733m("Using AdManager from the client jar.");
        return new C0614r(context, xVar, str, avVar, new C0345co(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    /* renamed from: b */
    private C0202ac m1952b(Context context, C0622x xVar, String str, C0237av avVar) {
        try {
            return C0202ac.C0203a.m470f(((C0205ad) mo3683t(context)).mo4030a(C0167c.m379g(context), xVar, str, avVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (RemoteException e) {
            C0344cn.m731b("Could not create remote AdManager.", e);
            return null;
        } catch (C0169e.C0170a e2) {
            C0344cn.m731b("Could not create remote AdManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0205ad mo3682d(IBinder iBinder) {
        return C0205ad.C0206a.m476g(iBinder);
    }
}
