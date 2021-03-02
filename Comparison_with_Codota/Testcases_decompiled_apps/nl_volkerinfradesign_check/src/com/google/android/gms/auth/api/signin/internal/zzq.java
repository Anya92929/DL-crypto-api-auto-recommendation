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

    /* renamed from: a */
    private static final Lock f2526a = new ReentrantLock();

    /* renamed from: b */
    private static zzq f2527b;

    /* renamed from: c */
    private final Lock f2528c = new ReentrantLock();

    /* renamed from: d */
    private final SharedPreferences f2529d;

    zzq(Context context) {
        this.f2529d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: a */
    private String m3634a(String str, String str2) {
        return str + ":" + str2;
    }

    public static zzq zzaf(Context context) {
        zzx.zzz(context);
        f2526a.lock();
        try {
            if (f2527b == null) {
                f2527b = new zzq(context.getApplicationContext());
            }
            return f2527b;
        } finally {
            f2526a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public SignInAccount mo4867a(String str) {
        GoogleSignInAccount b;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String zzbS = zzbS(m3634a("signInAccount", str));
        if (TextUtils.isEmpty(zzbS)) {
            return null;
        }
        try {
            SignInAccount zzbM = SignInAccount.zzbM(zzbS);
            if (!(zzbM.zzmV() == null || (b = mo4870b(zzbM.zzmV().zzmL())) == null)) {
                zzbM.zza(b);
            }
            return zzbM;
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4868a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzz(googleSignInAccount);
        zzx.zzz(googleSignInOptions);
        String zzmL = googleSignInAccount.zzmL();
        zzr(m3634a("googleSignInAccount", zzmL), googleSignInAccount.zzmM());
        zzr(m3634a("googleSignInOptions", zzmL), googleSignInOptions.zzmI());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4869a(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzz(signInAccount);
        zzx.zzz(signInConfiguration);
        String userId = signInAccount.getUserId();
        SignInAccount a = mo4867a(userId);
        if (!(a == null || a.zzmV() == null)) {
            mo4873e(a.zzmV().zzmL());
        }
        zzr(m3634a("signInConfiguration", userId), signInConfiguration.zzmI());
        zzr(m3634a("signInAccount", userId), signInAccount.zzmI());
        if (signInAccount.zzmV() != null) {
            mo4868a(signInAccount.zzmV(), signInConfiguration.zznm());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GoogleSignInAccount mo4870b(String str) {
        String zzbS;
        if (TextUtils.isEmpty(str) || (zzbS = zzbS(m3634a("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzbH(zzbS);
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public GoogleSignInOptions mo4871c(String str) {
        String zzbS;
        if (TextUtils.isEmpty(str) || (zzbS = zzbS(m3634a("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzbJ(zzbS);
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4872d(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignInAccount a = mo4867a(str);
            zzbV(m3634a("signInAccount", str));
            zzbV(m3634a("signInConfiguration", str));
            if (a != null && a.zzmV() != null) {
                mo4873e(a.zzmV().zzmL());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4873e(String str) {
        if (!TextUtils.isEmpty(str)) {
            zzbV(m3634a("googleSignInAccount", str));
            zzbV(m3634a("googleSignInOptions", str));
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzz(googleSignInAccount);
        zzx.zzz(googleSignInOptions);
        zzr("defaultGoogleSignInAccount", googleSignInAccount.zzmL());
        mo4868a(googleSignInAccount, googleSignInOptions);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzz(signInAccount);
        zzx.zzz(signInConfiguration);
        zznq();
        zzr("defaultSignInAccount", signInAccount.getUserId());
        if (signInAccount.zzmV() != null) {
            zzr("defaultGoogleSignInAccount", signInAccount.zzmV().zzmL());
        }
        mo4869a(signInAccount, signInConfiguration);
    }

    /* access modifiers changed from: protected */
    public String zzbS(String str) {
        this.f2528c.lock();
        try {
            return this.f2529d.getString(str, (String) null);
        } finally {
            this.f2528c.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void zzbV(String str) {
        this.f2528c.lock();
        try {
            this.f2529d.edit().remove(str).apply();
        } finally {
            this.f2528c.unlock();
        }
    }

    public GoogleSignInAccount zzno() {
        return mo4870b(zzbS("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zznp() {
        return mo4871c(zzbS("defaultGoogleSignInAccount"));
    }

    public void zznq() {
        String zzbS = zzbS("defaultSignInAccount");
        zzbV("defaultSignInAccount");
        zznr();
        mo4872d(zzbS);
    }

    public void zznr() {
        String zzbS = zzbS("defaultGoogleSignInAccount");
        zzbV("defaultGoogleSignInAccount");
        mo4873e(zzbS);
    }

    /* access modifiers changed from: protected */
    public void zzr(String str, String str2) {
        this.f2528c.lock();
        try {
            this.f2529d.edit().putString(str, str2).apply();
        } finally {
            this.f2528c.unlock();
        }
    }
}
