package com.google.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.ads.an */
public class C0194an {

    /* renamed from: com.google.ads.an$a */
    public static class C0195a extends Exception {
        public C0195a() {
        }

        public C0195a(Throwable th) {
            super(th);
        }
    }

    /* renamed from: a */
    static void m88a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    /* renamed from: a */
    public static byte[] m89a(String str) throws C0197ap, C0195a {
        byte[] a = C0198aq.m106a(str);
        if (a.length != 32) {
            throw new C0195a();
        }
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(a, 4, 16).get(bArr);
        m88a(bArr);
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m90a(byte[] bArr, String str) throws C0195a, C0197ap {
        if (bArr.length != 16) {
            throw new C0195a();
        }
        try {
            byte[] a = C0198aq.m106a(str);
            if (a.length <= 16) {
                throw new C0195a();
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES"); // CRYPTOGRAPHIC API CALLSITE 13
            Cipher instance = Cipher.getInstanc e("AES/CBC/PKCS5Padding"); // CRYPTOGRAPHIC API CALLSITE 34
            //IvParameterSpec spec = new IvParameterSpec(iv);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2)); // CRYPTOGRAPHIC API CALLSITE 33, CRYPTOGRAPHIC API CALLSITE 35
            return instance.doFinal(bArr3); // CRYPTOGRAPHIC API CALLSITE 12
        } catch (NoSuchAlgorithmException e) {
            throw new C0195a(e);
        } catch (InvalidKeyException e2) {
            throw new C0195a(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new C0195a(e3);
        } catch (NoSuchPaddingException e4) {
            throw new C0195a(e4);
        } catch (BadPaddingException e5) {
            throw new C0195a(e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new C0195a(e6);
        }
    }
}
