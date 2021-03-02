package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.dynamic.C0169e;
import com.google.android.gms.internal.C0294bn;
import com.google.android.gms.internal.C0297bo;

/* renamed from: com.google.android.gms.internal.bm */
public final class C0292bm extends C0169e<C0297bo> {

    /* renamed from: gl */
    private static final C0292bm f885gl = new C0292bm();

    /* renamed from: com.google.android.gms.internal.bm$a */
    private static final class C0293a extends Exception {
        public C0293a(String str) {
            super(str);
        }
    }

    private C0292bm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: a */
    public static C0294bn m602a(Activity activity) {
        try {
            if (!m603b(activity)) {
                return f885gl.m604c(activity);
            }
            C0344cn.m733m("Using AdOverlay from the client jar.");
            return new C0280bf(activity);
        } catch (C0293a e) {
            C0344cn.m737q(e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m603b(Activity activity) throws C0293a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0293a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    /* renamed from: c */
    private C0294bn m604c(Activity activity) {
        try {
            return C0294bn.C0295a.m607m(((C0297bo) mo3683t(activity)).mo4150a(C0167c.m379g(activity)));
        } catch (RemoteException e) {
            C0344cn.m731b("Could not create remote AdOverlay.", e);
            return null;
        } catch (C0169e.C0170a e2) {
            C0344cn.m731b("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C0297bo mo3682d(IBinder iBinder) {
        return C0297bo.C0298a.m609n(iBinder);
    }
}
