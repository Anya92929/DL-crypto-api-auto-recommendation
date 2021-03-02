package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0591c;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0599g;
import com.google.android.gms.internal.C1679ot;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* renamed from: com.google.android.gms.internal.oy */
public class C1698oy extends C0599g<C1679ot> {
    private static C1698oy aum;

    protected C1698oy() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    /* renamed from: a */
    public static C1670oq m5924a(Activity activity, C0591c cVar, WalletFragmentOptions walletFragmentOptions, C1673or orVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((C1679ot) m5925pN().mo5547L(activity)).mo9970a(C0597e.m1743k(activity), cVar, walletFragmentOptions, orVar);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (C0599g.C0600a e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: pN */
    private static C1698oy m5925pN() {
        if (aum == null) {
            aum = new C1698oy();
        }
        return aum;
    }

    /* access modifiers changed from: protected */
    /* renamed from: bQ */
    public C1679ot mo4552d(IBinder iBinder) {
        return C1679ot.C1680a.m5878bM(iBinder);
    }
}
