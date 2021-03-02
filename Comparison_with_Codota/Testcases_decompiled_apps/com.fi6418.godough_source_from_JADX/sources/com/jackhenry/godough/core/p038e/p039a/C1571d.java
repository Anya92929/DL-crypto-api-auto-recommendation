package com.jackhenry.godough.core.p038e.p039a;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.p027b.C1389d;
import java.io.File;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

@TargetApi(18)
/* renamed from: com.jackhenry.godough.core.e.a.d */
public class C1571d {

    /* renamed from: a */
    private static final File f6130a = new File(GoDoughApp.getApp().getFilesDir(), "data1");

    /* renamed from: b */
    private KeyStore f6131b = null;

    /* renamed from: c */
    private String f6132c;

    /* renamed from: d */
    private Cipher f6133d;

    /* renamed from: e */
    private String f6134e = "RSA/NONE/PKCS1Padding";

    public C1571d(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f6134e = "RSA/ECB/OAEPWithSHA-512AndMGF1Padding";
        }
        try {
            this.f6131b = KeyStore.getInstance("AndroidKeyStore");
            this.f6131b.load((KeyStore.LoadStoreParameter) null);
            this.f6132c = str;
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(GoDoughApp.getApp().getString(C1506am.keystore_open_error), 1000);
        }
    }

    /* renamed from: a */
    private KeyPair m6131a() {
        try {
            if (this.f6131b.containsAlias(this.f6132c)) {
                return m6132a(this.f6132c);
            }
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 25);
            String string = GoDoughApp.getApp().getString(C1506am.app_name);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(GoDoughApp.getApp()).setAlias(this.f6132c).setSubject(new X500Principal(String.format("CN=%1$s, O=Android Authority", new Object[]{string}))).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
            KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            instance3.initialize(build);
            return instance3.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(GoDoughApp.getApp().getString(C1506am.dg_no_account_msg), 1000);
        }
    }

    /* renamed from: a */
    private KeyPair m6132a(String str) {
        return new KeyPair(((KeyStore.PrivateKeyEntry) this.f6131b.getEntry(str, (KeyStore.ProtectionParameter) null)).getCertificate().getPublicKey(), (PrivateKey) this.f6131b.getKey(str, (char[]) null));
    }

    /* renamed from: a */
    private Cipher m6133a(int i) {
        KeyPair a = m6131a();
        try {
            if (this.f6133d == null) {
                this.f6133d = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            }
            if (i == 1) {
                this.f6133d.init(1, a.getPublic());
            } else {
                this.f6133d.init(2, a.getPrivate());
            }
            return this.f6133d;
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(GoDoughApp.getApp().getString(C1506am.dg_no_account_msg), 1000);
        }
    }

    /* renamed from: a */
    public byte[] mo9783a(byte[] bArr) {
        try {
            return m6133a(1).doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(GoDoughApp.getApp().getString(C1506am.dg_no_account_msg), 1000);
        }
    }

    /* renamed from: b */
    public byte[] mo9784b(byte[] bArr) {
        try {
            return m6133a(2).doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1389d(GoDoughApp.getApp().getString(C1506am.dg_no_account_msg), 1000);
        }
    }
}
