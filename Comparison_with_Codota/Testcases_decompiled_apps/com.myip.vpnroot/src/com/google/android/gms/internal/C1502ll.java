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
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.identity.intents.AddressConstants;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.C1504lm;
import com.google.android.gms.internal.C1507ln;

/* renamed from: com.google.android.gms.internal.ll */
public class C1502ll extends C0316d<C1507ln> {

    /* renamed from: Dd */
    private final String f4262Dd;
    private C1503a adB;
    private final int mTheme;

    /* renamed from: nr */
    private Activity f4263nr;

    /* renamed from: com.google.android.gms.internal.ll$a */
    public static final class C1503a extends C1504lm.C1505a {

        /* renamed from: Lm */
        private final int f4264Lm;

        /* renamed from: nr */
        private Activity f4265nr;

        public C1503a(int i, Activity activity) {
            this.f4264Lm = i;
            this.f4265nr = activity;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f4265nr = activity;
        }

        /* renamed from: g */
        public void mo9227g(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent createPendingResult = this.f4265nr.createPendingResult(this.f4264Lm, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                    } catch (PendingIntent.CanceledException e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                    }
                }
            } else {
                PendingIntent pendingIntent = null;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
                }
                ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
                if (connectionResult.hasResolution()) {
                    try {
                        connectionResult.startResolutionForResult(this.f4265nr, this.f4264Lm);
                    } catch (IntentSender.SendIntentException e2) {
                        Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    }
                } else {
                    try {
                        PendingIntent createPendingResult2 = this.f4265nr.createPendingResult(this.f4264Lm, new Intent(), 1073741824);
                        if (createPendingResult2 != null) {
                            createPendingResult2.send(1);
                        }
                    } catch (PendingIntent.CanceledException e3) {
                        Log.w("AddressClientImpl", "Exception setting pending result", e3);
                    }
                }
            }
        }
    }

    public C1502ll(Activity activity, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f4262Dd = str;
        this.f4263nr = activity;
        this.mTheme = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4519d(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    /* renamed from: a */
    public void mo9223a(UserAddressRequest userAddressRequest, int i) {
        mo9226lR();
        this.adB = new C1503a(i, this.f4263nr);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.f4262Dd)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.f4262Dd, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            mo9225lQ().mo9231a(this.adB, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_ERROR_CODE, AddressConstants.ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.adB.mo9227g(1, bundle2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public C1507ln mo3832j(IBinder iBinder) {
        return C1507ln.C1508a.m5454aH(iBinder);
    }

    public void disconnect() {
        super.disconnect();
        if (this.adB != null) {
            this.adB.setActivity((Activity) null);
            this.adB = null;
        }
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.identity.service.BIND";
    }

    /* access modifiers changed from: protected */
    /* renamed from: lQ */
    public C1507ln mo9225lQ() {
        return (C1507ln) super.mo4435gS();
    }

    /* access modifiers changed from: protected */
    /* renamed from: lR */
    public void mo9226lR() {
        super.mo4433dK();
    }
}
