package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.signin.internal.zze;

public class zzh extends zzj<zze> implements zzrn {

    /* renamed from: b */
    private final boolean f3607b;

    /* renamed from: c */
    private final zzf f3608c;

    /* renamed from: d */
    private final Bundle f3609d;

    /* renamed from: e */
    private Integer f3610e;

    public zzh(Context context, Looper looper, boolean z, zzf zzf, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzf, connectionCallbacks, onConnectionFailedListener);
        this.f3607b = z;
        this.f3608c = zzf;
        this.f3609d = bundle;
        this.f3610e = zzf.zzqz();
    }

    public zzh(Context context, Looper looper, boolean z, zzf zzf, zzro zzro, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzf, zza(zzf), connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: a */
    private ResolveAccountRequest m4246a() {
        Account zzqq = this.f3608c.zzqq();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(zzqq.name)) {
            googleSignInAccount = zzq.zzaf(getContext()).zzno();
        }
        return new ResolveAccountRequest(zzqq, this.f3610e.intValue(), googleSignInAccount);
    }

    public static Bundle zza(zzf zzf) {
        zzro zzqy = zzf.zzqy();
        Integer zzqz = zzf.zzqz();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzf.getAccount());
        if (zzqz != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzqz.intValue());
        }
        if (zzqy != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzqy.zzFH());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzqy.zzmO());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzqy.zzmR());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzqy.zzmQ());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzqy.zzmS());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzqy.zzFI());
        }
        return bundle;
    }

    public void connect() {
        zza((GoogleApiClient.zza) new zzj.zzf());
    }

    public void zzFG() {
        try {
            ((zze) zzqJ()).zzka(this.f3610e.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void zza(zzp zzp, boolean z) {
        try {
            ((zze) zzqJ()).zza(zzp, this.f3610e.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzd zzd) {
        zzx.zzb(zzd, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zzqJ()).zza(new SignInRequest(m4246a()), zzd);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzd.zzb(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzec */
    public zze zzW(IBinder iBinder) {
        return zze.zza.zzeb(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public boolean zzmE() {
        return this.f3607b;
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        if (!getContext().getPackageName().equals(this.f3608c.zzqv())) {
            this.f3609d.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f3608c.zzqv());
        }
        return this.f3609d;
    }
}
