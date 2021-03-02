package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0599g;
import com.google.android.gms.internal.C1098ei;
import com.google.android.gms.internal.C1101ej;

@C1130ez
/* renamed from: com.google.android.gms.internal.en */
public final class C1111en extends C0599g<C1101ej> {

    /* renamed from: sK */
    private static final C1111en f3254sK = new C1111en();

    /* renamed from: com.google.android.gms.internal.en$a */
    private static final class C1112a extends Exception {
        public C1112a(String str) {
            super(str);
        }
    }

    private C1111en() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    /* renamed from: c */
    private static boolean m4344c(Activity activity) throws C1112a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new C1112a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    /* renamed from: e */
    public static C1098ei m4345e(Activity activity) {
        try {
            if (!m4344c(activity)) {
                return f3254sK.m4346f(activity);
            }
            C1229gs.m4675S("Using AdOverlay from the client jar.");
            return new C1083dz(activity);
        } catch (C1112a e) {
            C1229gs.m4679W(e.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    private C1098ei m4346f(Activity activity) {
        try {
            return C1098ei.C1099a.m4335u(((C1101ej) mo5547L(activity)).mo8429b(C0597e.m1743k(activity)));
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (C0599g.C0600a e2) {
            C1229gs.m4683d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C1101ej mo4552d(IBinder iBinder) {
        return C1101ej.C1102a.m4337v(iBinder);
    }
}
