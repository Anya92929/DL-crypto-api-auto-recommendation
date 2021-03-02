package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.p009v4.p019f.C0136a;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.C1975b;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {

    /* renamed from: a */
    private static Map f7501a = new C0136a();

    /* renamed from: b */
    private static C1986h f7502b;

    /* renamed from: c */
    private final C1975b f7503c;

    /* renamed from: d */
    private final C1985g f7504d;

    /* renamed from: e */
    private final String f7505e = mo9856b();

    private FirebaseInstanceId(C1975b bVar, C1985g gVar) {
        this.f7503c = bVar;
        this.f7504d = gVar;
        if (this.f7505e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.m8124a(this.f7503c.mo9841a(), this);
    }

    /* renamed from: a */
    public static FirebaseInstanceId m8098a() {
        return getInstance(C1975b.m8087d());
    }

    /* renamed from: a */
    static String m8099a(Context context) {
        return m8098a().f7503c.mo9843c().mo9849a();
    }

    /* renamed from: a */
    static String m8100a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded()); // CRYPTOGRAPHIC API CALLSITE 1, CRYPTOGRAPHIC API CALLSITE 6, CRYPTOGRAPHIC API CALLSITE 7
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    /* renamed from: a */
    static String m8101a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    /* renamed from: a */
    static void m8102a(Context context, C1989k kVar) {
        kVar.mo9909c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.m8117b(context, intent));
    }

    /* renamed from: b */
    static int m8103b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return 0;
        }
    }

    /* renamed from: c */
    static String m8104c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    /* renamed from: d */
    static void m8105d(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.m8117b(context, intent));
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(C1975b bVar) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) f7501a.get(bVar.mo9843c().mo9849a());
            if (firebaseInstanceId == null) {
                C1985g a = C1985g.m8145a(bVar.mo9841a(), (Bundle) null);
                if (f7502b == null) {
                    f7502b = new C1986h(a.mo9882c());
                }
                firebaseInstanceId = new FirebaseInstanceId(bVar, a);
                f7501a.put(bVar.mo9843c().mo9849a(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    /* renamed from: a */
    public String mo9854a(String str, String str2) {
        return this.f7504d.mo9880b(str, str2, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9855a(String str) {
        if (mo9859d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C1985g gVar = this.f7504d;
        String d = mo9859d();
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        gVar.mo9880b(d, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo9856b() {
        String b = this.f7503c.mo9843c().mo9850b();
        if (b != null) {
            return b;
        }
        String a = this.f7503c.mo9843c().mo9849a();
        if (!a.startsWith("1:")) {
            return a;
        }
        String[] split = a.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9857b(String str) {
        if (mo9859d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        C1985g gVar = this.f7504d;
        String d = mo9859d();
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        gVar.mo9879a(d, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }

    /* renamed from: c */
    public String mo9858c() {
        return m8100a(this.f7504d.mo9878a());
    }

    /* renamed from: d */
    public String mo9859d() {
        String e = mo9860e();
        if (e == null) {
            FirebaseInstanceIdService.m8123a(this.f7503c.mo9841a());
        }
        return e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo9860e() {
        return this.f7504d.mo9882c().mo9901a("", this.f7505e, "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo9861f() {
        return mo9854a(this.f7505e, "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C1986h mo9862g() {
        return f7502b;
    }
}
