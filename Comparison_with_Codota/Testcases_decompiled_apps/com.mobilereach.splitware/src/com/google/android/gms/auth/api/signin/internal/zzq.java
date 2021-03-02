package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzq {
    private static final Lock zzYa = new ReentrantLock();
    private static zzq zzYb;
    private final Lock zzYc = new ReentrantLock();
    private final SharedPreferences zzYd;

    zzq(Context context) {
        this.zzYd = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzq zzaf(Context context) {
        zzx.zzz(context);
        zzYa.lock();
        try {
            if (zzYb == null) {
                zzYb = new zzq(context.getApplicationContext());
            }
            return zzYb;
        } finally {
            zzYa.unlock();
        }
    }

    private String zzs(String str, String str2) {
        return str + ":" + str2;
    }

    /* access modifiers changed from: package-private */
    public void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzz(googleSignInAccount);
        zzx.zzz(googleSignInOptions);
        String zzmL = googleSignInAccount.zzmL();
        zzr(zzs("googleSignInAccount", zzmL), googleSignInAccount.zzmM());
        zzr(zzs("googleSignInOptions", zzmL), googleSignInOptions.zzmI());
    }

    /* access modifiers changed from: package-private */
    public void zza(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzz(signInAccount);
        zzx.zzz(signInConfiguration);
        String userId = signInAccount.getUserId();
        SignInAccount zzbP = zzbP(userId);
        if (!(zzbP == null || zzbP.zzmV() == null)) {
            zzbU(zzbP.zzmV().zzmL());
        }
        zzr(zzs("signInConfiguration", userId), signInConfiguration.zzmI());
        zzr(zzs("signInAccount", userId), signInAccount.zzmI());
        if (signInAccount.zzmV() != null) {
            zza(signInAccount.zzmV(), signInConfiguration.zznm());
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzz(googleSignInAccount);
        zzx.zzz(googleSignInOptions);
        zzr("defaultGoogleSignInAccount", googleSignInAccount.zzmL());
        zza(googleSignInAccount, googleSignInOptions);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzz(signInAccount);
        zzx.zzz(signInConfiguration);
        zznq();
        zzr("defaultSignInAccount", signInAccount.getUserId());
        if (signInAccount.zzmV() != null) {
            zzr("defaultGoogleSignInAccount", signInAccount.zzmV().zzmL());
        }
        zza(signInAccount, signInConfiguration);
    }

    /* access modifiers changed from: package-private */
    public SignInAccount zzbP(String str) {
        GoogleSignInAccount zzbQ;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String zzbS = zzbS(zzs("signInAccount", str));
        if (TextUtils.isEmpty(zzbS)) {
            return null;
        }
        try {
            SignInAccount zzbM = SignInAccount.zzbM(zzbS);
            if (!(zzbM.zzmV() == null || (zzbQ = zzbQ(zzbM.zzmV().zzmL())) == null)) {
                zzbM.zza(zzbQ);
            }
            return zzbM;
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public GoogleSignInAccount zzbQ(String str) {
        String zzbS;
        if (TextUtils.isEmpty(str) || (zzbS = zzbS(zzs("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzbH(zzbS);
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public GoogleSignInOptions zzbR(String str) {
        String zzbS;
        if (TextUtils.isEmpty(str) || (zzbS = zzbS(zzs("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzbJ(zzbS);
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String zzbS(String str) {
        this.zzYc.lock();
        try {
            return this.zzYd.getString(str, (String) null);
        } finally {
            this.zzYc.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzbT(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignInAccount zzbP = zzbP(str);
            zzbV(zzs("signInAccount", str));
            zzbV(zzs("signInConfiguration", str));
            if (zzbP != null && zzbP.zzmV() != null) {
                zzbU(zzbP.zzmV().zzmL());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzbU(String str) {
        if (!TextUtils.isEmpty(str)) {
            zzbV(zzs("googleSignInAccount", str));
            zzbV(zzs("googleSignInOptions", str));
        }
    }

    /* access modifiers changed from: protected */
    public void zzbV(String str) {
        this.zzYc.lock();
        try {
            this.zzYd.edit().remove(str).apply();
        } finally {
            this.zzYc.unlock();
        }
    }

    public GoogleSignInAccount zzno() {
        return zzbQ(zzbS("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zznp() {
        return zzbR(zzbS("defaultGoogleSignInAccount"));
    }

    public void zznq() {
        String zzbS = zzbS("defaultSignInAccount");
        zzbV("defaultSignInAccount");
        zznr();
        zzbT(zzbS);
    }

    public void zznr() {
        String zzbS = zzbS("defaultGoogleSignInAccount");
        zzbV("defaultGoogleSignInAccount");
        zzbU(zzbS);
    }

    /* access modifiers changed from: protected */
    public void zzr(String str, String str2) {
        this.zzYc.lock();
        try {
            this.zzYd.edit().putString(str, str2).apply();
        } finally {
            this.zzYc.unlock();
        }
    }
}
