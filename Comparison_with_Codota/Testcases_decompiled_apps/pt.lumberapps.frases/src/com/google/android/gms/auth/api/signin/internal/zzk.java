package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzk {

    /* renamed from: a */
    private static final Lock f4222a = new ReentrantLock();

    /* renamed from: b */
    private static zzk f4223b;

    /* renamed from: c */
    private final Lock f4224c = new ReentrantLock();

    /* renamed from: d */
    private final SharedPreferences f4225d;

    zzk(Context context) {
        this.f4225d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: b */
    private String m5910b(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder(String.valueOf(str).length() + 0 + String.valueOf(valueOf).length() + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public static zzk zzbc(Context context) {
        zzab.zzy(context);
        f4222a.lock();
        try {
            if (f4223b == null) {
                f4223b = new zzk(context.getApplicationContext());
            }
            return f4223b;
        } finally {
            f4222a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GoogleSignInAccount mo6163a(String str) {
        String c;
        if (TextUtils.isEmpty(str) || (c = mo6167c(m5910b("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzfo(c);
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6164a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzab.zzy(googleSignInAccount);
        zzab.zzy(googleSignInOptions);
        String zzafm = googleSignInAccount.zzafm();
        mo6165a(m5910b("googleSignInAccount", zzafm), googleSignInAccount.zzafo());
        mo6165a(m5910b("googleSignInOptions", zzafm), googleSignInOptions.zzafn());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6165a(String str, String str2) {
        this.f4224c.lock();
        try {
            this.f4225d.edit().putString(str, str2).apply();
        } finally {
            this.f4224c.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GoogleSignInOptions mo6166b(String str) {
        String c;
        if (TextUtils.isEmpty(str) || (c = mo6167c(m5910b("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzfq(c);
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo6167c(String str) {
        this.f4224c.lock();
        try {
            return this.f4225d.getString(str, (String) null);
        } finally {
            this.f4224c.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6168d(String str) {
        if (!TextUtils.isEmpty(str)) {
            mo6169e(m5910b("googleSignInAccount", str));
            mo6169e(m5910b("googleSignInOptions", str));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo6169e(String str) {
        this.f4224c.lock();
        try {
            this.f4225d.edit().remove(str).apply();
        } finally {
            this.f4224c.unlock();
        }
    }

    public GoogleSignInAccount zzagj() {
        return mo6163a(mo6167c("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzagk() {
        return mo6166b(mo6167c("defaultGoogleSignInAccount"));
    }

    public void zzagl() {
        String c = mo6167c("defaultGoogleSignInAccount");
        mo6169e("defaultGoogleSignInAccount");
        mo6168d(c);
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzab.zzy(googleSignInAccount);
        zzab.zzy(googleSignInOptions);
        mo6165a("defaultGoogleSignInAccount", googleSignInAccount.zzafm());
        mo6164a(googleSignInAccount, googleSignInOptions);
    }
}
