package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1676os;
import com.google.android.gms.internal.C1685ov;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

/* renamed from: com.google.android.gms.internal.ox */
public class C1694ox extends C0316d<C1676os> {

    /* renamed from: Dd */
    private final String f4352Dd;
    private final int atA;
    private final int mTheme;
    /* access modifiers changed from: private */

    /* renamed from: nr */
    public final Activity f4353nr;

    /* renamed from: com.google.android.gms.internal.ox$a */
    private static class C1696a extends C1685ov.C1686a {
        private C1696a() {
        }

        /* renamed from: a */
        public void mo9976a(int i, FullWallet fullWallet, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo9977a(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo9978a(int i, boolean z, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo9979a(Status status, C1668oo ooVar, Bundle bundle) {
        }

        /* renamed from: i */
        public void mo9980i(int i, Bundle bundle) {
        }
    }

    /* renamed from: com.google.android.gms.internal.ox$b */
    final class C1697b extends C1696a {

        /* renamed from: Lm */
        private final int f4354Lm;

        public C1697b(int i) {
            super();
            this.f4354Lm = i;
        }

        /* renamed from: a */
        public void mo9976a(int i, FullWallet fullWallet, Bundle bundle) {
            int i2;
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C1694ox.this.f4353nr, this.f4354Lm);
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                PendingIntent createPendingResult = C1694ox.this.f4353nr.createPendingResult(this.f4354Lm, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                    return;
                }
                try {
                    createPendingResult.send(i2);
                } catch (PendingIntent.CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        /* renamed from: a */
        public void mo9977a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            int i2;
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C1694ox.this.f4353nr, this.f4354Lm);
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                PendingIntent createPendingResult = C1694ox.this.f4353nr.createPendingResult(this.f4354Lm, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                    return;
                }
                try {
                    createPendingResult.send(i2);
                } catch (PendingIntent.CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        /* renamed from: a */
        public void mo9978a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = C1694ox.this.f4353nr.createPendingResult(this.f4354Lm, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        /* renamed from: i */
        public void mo9980i(int i, Bundle bundle) {
            C0348n.m857b(bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C1694ox.this.f4353nr, this.f4354Lm);
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
                Intent intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
                PendingIntent createPendingResult = C1694ox.this.f4353nr.createPendingResult(this.f4354Lm, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                    return;
                }
                try {
                    createPendingResult.send(1);
                } catch (PendingIntent.CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }
    }

    public C1694ox(Activity activity, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f4353nr = activity;
        this.atA = i;
        this.f4352Dd = str;
        this.mTheme = i2;
    }

    /* renamed from: a */
    public static Bundle m5904a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    /* renamed from: pM */
    private Bundle m5906pM() {
        return m5904a(this.atA, this.f4353nr.getPackageName(), this.f4352Dd, this.mTheme);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4533k(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    /* renamed from: a */
    public void mo9994a(FullWalletRequest fullWalletRequest, int i) {
        C1697b bVar = new C1697b(i);
        try {
            ((C1676os) mo4435gS()).mo9961a(fullWalletRequest, m5906pM(), (C1685ov) bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            bVar.mo9976a(8, (FullWallet) null, Bundle.EMPTY);
        }
    }

    /* renamed from: a */
    public void mo9995a(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle pM = m5906pM();
        C1697b bVar = new C1697b(i);
        try {
            ((C1676os) mo4435gS()).mo9963a(maskedWalletRequest, pM, (C1685ov) bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            bVar.mo9977a(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    /* renamed from: a */
    public void mo9996a(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((C1676os) mo4435gS()).mo9964a(notifyTransactionStatusRequest, m5906pM());
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bP */
    public C1676os mo3832j(IBinder iBinder) {
        return C1676os.C1677a.m5867bL(iBinder);
    }

    /* renamed from: d */
    public void mo9998d(String str, String str2, int i) {
        Bundle pM = m5906pM();
        C1697b bVar = new C1697b(i);
        try {
            ((C1676os) mo4435gS()).mo9966a(str, str2, pM, bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            bVar.mo9977a(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    /* renamed from: fH */
    public void mo9999fH(int i) {
        Bundle pM = m5906pM();
        C1697b bVar = new C1697b(i);
        try {
            ((C1676os) mo4435gS()).mo9959a(pM, (C1685ov) bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            bVar.mo9978a(8, false, Bundle.EMPTY);
        }
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.wallet.service.BIND";
    }
}
