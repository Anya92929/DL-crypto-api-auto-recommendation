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

public class zzau {

    /* renamed from: b */
    private static Cipher f5927b = null;

    /* renamed from: c */
    private static final Object f5928c = new Object();

    /* renamed from: d */
    private static final Object f5929d = new Object();

    /* renamed from: a */
    private final SecureRandom f5930a;

    public class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    public zzau(SecureRandom secureRandom) {
        this.f5930a = secureRandom;
    }

    /* renamed from: a */
    private Cipher m6882a() {
        Cipher cipher;
        synchronized (f5929d) {
            if (f5927b == null) {
                f5927b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f5927b;
        }
        return cipher;
    }

    /* renamed from: a */
    static void m6883a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] zzc(byte[] bArr, String str) {
        byte[] doFinal;
        if (bArr.length != 16) {
            throw new zza();
        }
        try {
            byte[] zza2 = zzaj.zza(str, false);
            if (zza2.length <= 16) {
                throw new zza();
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza2.length);
            allocate.put(zza2);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(zza2.length - 16)];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f5928c) {
                m6882a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                doFinal = m6882a().doFinal(bArr3);
            }
            return doFinal;
        } catch (NoSuchAlgorithmException e) {
            throw new zza(e);
        } catch (InvalidKeyException e2) {
            throw new zza(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new zza(e3);
        } catch (NoSuchPaddingException e4) {
            throw new zza(e4);
        } catch (BadPaddingException e5) {
            throw new zza(e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new zza(e6);
        } catch (IllegalArgumentException e7) {
            throw new zza(e7);
        }
    }

    public String zzd(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zza();
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f5928c) {
                m6882a().init(1, secretKeySpec, this.f5930a);
                doFinal = m6882a().doFinal(bArr2);
                iv = m6882a().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length];
            allocate.get(bArr3);
            return zzaj.zza(bArr3, false);
        } catch (NoSuchAlgorithmException e) {
            throw new zza(e);
        } catch (InvalidKeyException e2) {
            throw new zza(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new zza(e3);
        } catch (NoSuchPaddingException e4) {
            throw new zza(e4);
        } catch (BadPaddingException e5) {
            throw new zza(e5);
        }
    }

    public byte[] zzl(String str) {
        try {
            byte[] zza2 = zzaj.zza(str, false);
            if (zza2.length != 32) {
                throw new zza();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza2, 4, 16).get(bArr);
            m6883a(bArr);
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zza(e);
        }
    }
}
