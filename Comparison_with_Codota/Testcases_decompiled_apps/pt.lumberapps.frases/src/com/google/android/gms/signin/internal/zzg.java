package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzvu;
import com.google.android.gms.internal.zzvv;
import com.google.android.gms.signin.internal.zze;

public class zzg extends zzk implements zzvu {

    /* renamed from: a */
    private final boolean f7424a;

    /* renamed from: d */
    private final com.google.android.gms.common.internal.zzg f7425d;

    /* renamed from: e */
    private final Bundle f7426e;

    /* renamed from: f */
    private Integer f7427f;

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzg, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzg, connectionCallbacks, onConnectionFailedListener);
        this.f7424a = z;
        this.f7425d = zzg;
        this.f7426e = bundle;
        this.f7427f = zzg.zzasq();
    }

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzg, zzvv zzvv, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzg, zza(zzg), connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: g */
    private ResolveAccountRequest m8029g() {
        Account zzary = this.f7425d.zzary();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(zzary.name)) {
            googleSignInAccount = com.google.android.gms.auth.api.signin.internal.zzk.zzbc(getContext()).zzagj();
        }
        return new ResolveAccountRequest(zzary, this.f7427f.intValue(), googleSignInAccount);
    }

    public static Bundle zza(com.google.android.gms.common.internal.zzg zzg) {
        zzvv zzasp = zzg.zzasp();
        Integer zzasq = zzg.zzasq();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzg.getAccount());
        if (zzasq != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzasq.intValue());
        }
        if (zzasp != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzasp.zzbzp());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzasp.zzafr());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzasp.zzafu());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzasp.zzaft());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzasp.zzafv());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzasp.zzbzq());
            if (zzasp.zzbzr() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzasp.zzbzr().longValue());
            }
            if (zzasp.zzbzs() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzasp.zzbzs().longValue());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zze zzbb(IBinder iBinder) {
        return zze.zza.zzkv(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void connect() {
        zza(new zzd.zzi());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Bundle mo6671d() {
        if (!getContext().getPackageName().equals(this.f7425d.zzasm())) {
            this.f7426e.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f7425d.zzasm());
        }
        return this.f7426e;
    }

    public void zza(zzq zzq, boolean z) {
        try {
            ((zze) zzasa()).zza(zzq, this.f7427f.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzd zzd) {
        zzab.zzb((Object) zzd, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zzasa()).zza(new SignInRequest(m8029g()), zzd);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzd.zzb(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public boolean zzafk() {
        return this.f7424a;
    }

    public void zzbzo() {
        try {
            ((zze) zzasa()).zzza(this.f7427f.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* access modifiers changed from: protected */
    public String zzqz() {
        return "com.google.android.gms.signin.service.START";
    }
}
