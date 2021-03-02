package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0387de;
import com.google.android.gms.internal.C0587gh;
import com.google.android.gms.internal.C0590gi;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

/* renamed from: com.google.android.gms.internal.gj */
public class C0593gj extends C0387de<C0587gh> {
    /* access modifiers changed from: private */

    /* renamed from: fD */
    public final Activity f1523fD;

    /* renamed from: it */
    private final String f1524it;
    private final int mTheme;

    /* renamed from: us */
    private final int f1525us;

    /* renamed from: com.google.android.gms.internal.gj$a */
    final class C0594a extends C0590gi.C0591a {

        /* renamed from: ky */
        private final int f1526ky;

        public C0594a(int i) {
            this.f1526ky = i;
        }

        /* renamed from: a */
        public void mo5276a(int i, FullWallet fullWallet, Bundle bundle) {
            int i2;
            Intent intent;
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C0593gj.this.f1523fD, this.f1526ky);
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent = new Intent();
                    intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent = new Intent();
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                try {
                    C0593gj.this.f1523fD.createPendingResult(this.f1526ky, intent, 1073741824).send(i2);
                } catch (PendingIntent.CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        /* renamed from: a */
        public void mo5277a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            int i2;
            Intent intent;
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C0593gj.this.f1523fD, this.f1526ky);
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent = new Intent();
                    intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent = new Intent();
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                try {
                    C0593gj.this.f1523fD.createPendingResult(this.f1526ky, intent, 1073741824).send(i2);
                } catch (PendingIntent.CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        /* renamed from: a */
        public void mo5278a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            try {
                C0593gj.this.f1523fD.createPendingResult(this.f1526ky, intent, 1073741824).send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }
    }

    public C0593gj(Activity activity, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f1523fD = activity;
        this.f1525us = i;
        this.f1524it = str;
        this.mTheme = i2;
    }

    /* renamed from: eb */
    private Bundle m1853eb() {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", this.f1525us);
        bundle.putString("androidPackageName", this.f1523fD.getPackageName());
        if (!TextUtils.isEmpty(this.f1524it)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(this.f1524it, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", this.mTheme);
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        djVar.mo4368a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    /* access modifiers changed from: protected */
    /* renamed from: au */
    public C0587gh mo4168p(IBinder iBinder) {
        return C0587gh.C0588a.m1839as(iBinder);
    }

    public void changeMaskedWallet(String googleTransactionId, String merchantTransactionId, int requestCode) {
        Bundle eb = m1853eb();
        C0594a aVar = new C0594a(requestCode);
        try {
            ((C0587gh) mo4332bd()).mo5273a(googleTransactionId, merchantTransactionId, eb, aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            aVar.mo5277a(8, (MaskedWallet) null, (Bundle) null);
        }
    }

    public void checkForPreAuthorization(int requestCode) {
        Bundle eb = m1853eb();
        C0594a aVar = new C0594a(requestCode);
        try {
            ((C0587gh) mo4332bd()).mo5269a(eb, (C0590gi) aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            aVar.mo5278a(8, false, (Bundle) null);
        }
    }

    public void loadFullWallet(FullWalletRequest request, int requestCode) {
        C0594a aVar = new C0594a(requestCode);
        try {
            ((C0587gh) mo4332bd()).mo5270a(request, m1853eb(), (C0590gi) aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            aVar.mo5276a(8, (FullWallet) null, (Bundle) null);
        }
    }

    public void loadMaskedWallet(MaskedWalletRequest request, int requestCode) {
        Bundle eb = m1853eb();
        C0594a aVar = new C0594a(requestCode);
        try {
            ((C0587gh) mo4332bd()).mo5271a(request, eb, (C0590gi) aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            aVar.mo5277a(8, (MaskedWallet) null, (Bundle) null);
        }
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest request) {
        try {
            ((C0587gh) mo4332bd()).mo5272a(request, m1853eb());
        } catch (RemoteException e) {
        }
    }
}
