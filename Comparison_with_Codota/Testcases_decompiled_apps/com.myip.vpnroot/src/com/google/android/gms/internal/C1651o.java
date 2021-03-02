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

/* renamed from: com.google.android.gms.internal.o */
public class C1651o {

    /* renamed from: kW */
    private final SecureRandom f4340kW;

    /* renamed from: ky */
    private final C1551m f4341ky;

    /* renamed from: com.google.android.gms.internal.o$a */
    public class C1652a extends Exception {
        public C1652a() {
        }

        public C1652a(Throwable th) {
            super(th);
        }
    }

    public C1651o(C1551m mVar, SecureRandom secureRandom) {
        this.f4341ky = mVar;
        this.f4340kW = secureRandom;
    }

    /* renamed from: c */
    static void m5806c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    /* renamed from: b */
    public byte[] mo9879b(String str) throws C1652a {
        try {
            byte[] a = this.f4341ky.mo8400a(str, false);
            if (a.length != 32) {
                throw new C1652a();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            m5806c(bArr);
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new C1652a(e);
        }
    }

    /* renamed from: c */
    public byte[] mo9880c(byte[] bArr, String str) throws C1652a {
        if (bArr.length != 16) {
            throw new C1652a();
        }
        try {
            byte[] a = this.f4341ky.mo8400a(str, false);
            if (a.length <= 16) {
                throw new C1652a();
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
            throw new C1652a(e);
        } catch (InvalidKeyException e2) {
            throw new C1652a(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new C1652a(e3);
        } catch (NoSuchPaddingException e4) {
            throw new C1652a(e4);
        } catch (BadPaddingException e5) {
            throw new C1652a(e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new C1652a(e6);
        } catch (IllegalArgumentException e7) {
            throw new C1652a(e7);
        }
    }
}
