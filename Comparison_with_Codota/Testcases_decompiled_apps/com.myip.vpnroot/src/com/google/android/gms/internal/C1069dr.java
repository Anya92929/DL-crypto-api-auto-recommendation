package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0599g;
import com.google.android.gms.internal.C1071ds;
import com.google.android.gms.internal.C1074dt;

@C1130ez
/* renamed from: com.google.android.gms.internal.dr */
public final class C1069dr extends C0599g<C1074dt> {

    /* renamed from: sh */
    private static final C1069dr f3202sh = new C1069dr();

    /* renamed from: com.google.android.gms.internal.dr$a */
    private static final class C1070a extends Exception {
        public C1070a(String str) {
            super(str);
        }
    }

    private C1069dr() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: b */
    public static C1071ds m4274b(Activity activity) {
        try {
            if (!m4275c(activity)) {
                return f3202sh.m4276d(activity);
            }
            C1229gs.m4675S("Using AdOverlay from the client jar.");
            return new C1056dk(activity);
        } catch (C1070a e) {
            C1229gs.m4679W(e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    private static boolean m4275c(Activity activity) throws C1070a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C1070a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    /* renamed from: d */
    private C1071ds m4276d(Activity activity) {
        try {
            return C1071ds.C1072a.m4280p(((C1074dt) mo5547L(activity)).mo8366a(C0597e.m1743k(activity)));
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not create remote AdOverlay.", e);
            return null;
        } catch (C0599g.C0600a e2) {
            C1229gs.m4683d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public C1074dt mo4552d(IBinder iBinder) {
        return C1074dt.C1075a.m4283q(iBinder);
    }
}
