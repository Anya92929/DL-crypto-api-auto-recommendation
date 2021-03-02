package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.google.firebase.iid.k */
public class C1989k {

    /* renamed from: a */
    SharedPreferences f7549a;

    /* renamed from: b */
    Context f7550b;

    public C1989k(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C1989k(Context context, String str) {
        this.f7550b = context;
        this.f7549a = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m8175g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    /* renamed from: c */
    private String m8174c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(valueOf).length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    /* renamed from: g */
    private void m8175g(String str) {
        File file = new File(zzx.getNoBackupFilesDir(this.f7550b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !mo9907b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m8102a(this.f7550b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("InstanceID/Store", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    /* renamed from: a */
    public SharedPreferences mo9898a() {
        return this.f7549a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized String mo9899a(String str) {
        return this.f7549a.getString(str, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized String mo9900a(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.f7549a;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(String.valueOf(str).length() + 0 + String.valueOf(valueOf).length() + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), (String) null);
    }

    /* renamed from: a */
    public synchronized String mo9901a(String str, String str2, String str3) {
        return this.f7549a.getString(m8174c(str, str2, str3), (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized KeyPair mo9902a(String str, long j) {
        KeyPair a;
        a = C1980b.m8138a();
        SharedPreferences.Editor edit = this.f7549a.edit();
        mo9903a(edit, str, "|P|", FirebaseInstanceId.m8101a(a.getPublic().getEncoded())); // CRYPTOGRAPHIC API CALLSITE 18
        mo9903a(edit, str, "|K|", FirebaseInstanceId.m8101a(a.getPrivate().getEncoded())); // CRYPTOGRAPHIC API CALLSITE 17
        mo9903a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9903a(SharedPreferences.Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(String.valueOf(str).length() + 0 + String.valueOf(valueOf).length() + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    /* renamed from: a */
    public synchronized void mo9904a(String str, String str2, String str3, String str4, String str5) {
        String c = m8174c(str, str2, str3);
        SharedPreferences.Editor edit = this.f7549a.edit();
        edit.putString(c, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    /* renamed from: b */
    public synchronized void mo9905b(String str) {
        SharedPreferences.Editor edit = this.f7549a.edit();
        for (String next : this.f7549a.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    /* renamed from: b */
    public synchronized void mo9906b(String str, String str2, String str3) {
        String c = m8174c(str, str2, str3);
        SharedPreferences.Editor edit = this.f7549a.edit();
        edit.remove(c);
        edit.commit();
    }

    /* renamed from: b */
    public boolean mo9907b() {
        return this.f7549a.getAll().isEmpty();
    }

    /* renamed from: c */
    public KeyPair mo9908c(String str) {
        return mo9912f(str);
    }

    /* renamed from: c */
    public synchronized void mo9909c() {
        this.f7549a.edit().clear().commit();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9910d(String str) {
        mo9905b(String.valueOf(str).concat("|"));
    }

    /* renamed from: e */
    public void mo9911e(String str) {
        mo9905b(String.valueOf(str).concat("|T|"));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public KeyPair mo9912f(String str) {
        String a = mo9900a(str, "|P|");
        String a2 = mo9900a(str, "|K|");
        if (a == null || a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA"); // CRYPTOGRAPHIC API CALLSITE 19
            //X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedKey);
            //PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(encodedKey);
            //KeyPairGenerator keyGen;
			//KeyPair kp = keyGen.generateKeyPair();
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2))); // CRYPTOGRAPHIC API CALLSITE 12, CRYPTOGRAPHIC API CALLSITE 20, CRYPTOGRAPHIC API CALLSITE 21, CRYPTOGRAPHIC API CALLSITE 22, CRYPTOGRAPHIC API CALLSITE 23
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
            FirebaseInstanceId.m8102a(this.f7550b, this);
            return null;
        }
    }
}
