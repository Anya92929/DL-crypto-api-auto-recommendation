package com.unity3d.player.a;

import com.unity3d.player.b.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class a implements h {
    private static final byte[] a = {16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};
    private Cipher b;
    private Cipher c;

    public a(byte[] bArr, String str, String str2) {
        try {
            //PBEKeySpec pbeSpec = ??
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC").generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, 256)).getEncoded(), "AES"); //CRYPTOGRAPHIC API CALLSITE 05; CRYPTOGRAPHIC API CALLSITE 06; CRYPTOGRAPHIC API CALLSITE 07
            this.b = Cipher.getInstance("AES/CBC/PKCS5Padding");    //CRYPTOGRAPHIC API CALLSITE 09
            this.b.init(1, secretKeySpec, new IvParameterSpec(a)); //CRYPTOGRAPHIC API CALLSITE 08
            this.c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.c.init(2, secretKeySpec, new IvParameterSpec(a));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Invalid environment", e);
        }
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return com.unity3d.player.b.a.a(this.b.doFinal(("com.android.vending.licensing.AESObfuscator-1|" + str).getBytes("UTF-8"))); //CRYPTOGRAPHIC API CALLSITE 13
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Invalid environment", e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            String str2 = new String(this.c.doFinal(com.unity3d.player.b.a.a(str)), "UTF-8");  //CRYPTOGRAPHIC API CALLSITE 20
            if (str2.indexOf("com.android.vending.licensing.AESObfuscator-1|") == 0) {
                return str2.substring("com.android.vending.licensing.AESObfuscator-1|".length(), str2.length());
            }
            throw new l("Header not found (invalid data or key):" + str);
        } catch (b e) {
            throw new l(e.getMessage() + ":" + str);
        } catch (IllegalBlockSizeException e2) {
            throw new l(e2.getMessage() + ":" + str);
        } catch (BadPaddingException e3) {
            throw new l(e3.getMessage() + ":" + str);
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Invalid environment", e4);
        }
    }
}
