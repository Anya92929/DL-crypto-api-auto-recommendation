package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@C1130ez
/* renamed from: com.google.android.gms.internal.ef */
public class C1091ef {
    /* renamed from: F */
    public static PublicKey m4328F(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            C1229gs.m4676T("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    /* renamed from: a */
    public static boolean m4329a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            C1229gs.m4676T("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            C1229gs.m4676T("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            C1229gs.m4676T("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            C1229gs.m4676T("Signature exception.");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4330b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return m4329a(m4328F(str), str2, str3);
        }
        C1229gs.m4676T("Purchase verification failed: missing data.");
        return false;
    }
}
