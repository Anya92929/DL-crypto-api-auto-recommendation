package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.l */
public class C0603l {

    /* renamed from: dB */
    private final SecureRandom f1549dB;

    /* renamed from: di */
    private final C0601j f1550di;

    /* renamed from: com.google.android.gms.internal.l$a */
    public class C0604a extends Exception {
        public C0604a() {
        }

        public C0604a(Throwable th) {
            super(th);
        }
    }

    public C0603l(C0601j jVar, SecureRandom secureRandom) {
        this.f1550di = jVar;
        this.f1549dB = secureRandom;
    }

    /* renamed from: a */
    static void m1889a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    /* renamed from: b */
    public byte[] mo5309b(String str) throws C0604a {
        try {
            byte[] a = this.f1550di.mo4006a(str, false);
            if (a.length != 32) {
                throw new C0604a();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            m1889a(bArr);
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new C0604a(e);
        }
    }

    /* renamed from: c */
    public byte[] mo5310c(byte[] bArr, String str) throws C0604a {
        if (bArr.length != 16) {
            throw new C0604a();
        }
        try {
            byte[] a = this.f1550di.mo4006a(str, false);
            if (a.length <= 16) {
                throw new C0604a();
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr3);
        } catch (NoSuchAlgorithmException e) {
            throw new C0604a(e);
        } catch (InvalidKeyException e2) {
            throw new C0604a(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new C0604a(e3);
        } catch (NoSuchPaddingException e4) {
            throw new C0604a(e4);
        } catch (BadPaddingException e5) {
            throw new C0604a(e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new C0604a(e6);
        } catch (IllegalArgumentException e7) {
            throw new C0604a(e7);
        }
    }
}
