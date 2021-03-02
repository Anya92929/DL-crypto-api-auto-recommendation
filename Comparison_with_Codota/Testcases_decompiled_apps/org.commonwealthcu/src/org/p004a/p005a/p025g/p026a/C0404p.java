package org.p004a.p005a.p025g.p026a;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.g.a.p */
final class C0404p implements C0402n {

    /* renamed from: a */
    private static final SecureRandom f280a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final byte[] f281b;

    static {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG"); // CRYPTOGRAPHIC API CALLSITE 23
        } catch (Exception e) {
        }
        f280a = secureRandom;
        byte[] a = C0250b.m100a("NTLMSSP", "ASCII");
        f281b = new byte[(a.length + 1)];
        System.arraycopy(a, 0, f281b, 0, a.length);
        f281b[a.length] = 0;
    }

    C0404p() {
    }

    /* renamed from: a */
    static int m553a(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    /* renamed from: a */
    static int m554a(int i, int i2, int i3) {
        return (i & i2) | ((i ^ -1) & i3);
    }

    /* renamed from: a */
    static void m556a(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    static byte[] m560a(byte[] bArr, byte[] bArr2) {
        C0406r rVar = new C0406r(bArr2);
        rVar.mo5168a(bArr);
        return rVar.mo5169a();
    }

    /* renamed from: a */
    static byte[] m561a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 14
            instance.update(bArr2); // CRYPTOGRAPHIC API CALLSITE 15
            instance.update(bArr3);
            byte[] bArr4 = new byte[8];
            System.arraycopy(instance.digest(), 0, bArr4, 0, 8); // CRYPTOGRAPHIC API CALLSITE 8
            return m580d(bArr, bArr4);
        } catch (Exception e) {
            if (e instanceof C0403o) {
                throw ((C0403o) e);
            }
            throw new C0403o(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    static int m562b(int i, int i2, int i3) {
        return (i & i2) | (i & i3) | (i2 & i3);
    }

    /* renamed from: b */
    static byte[] m567b(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance("RC4"); // CRYPTOGRAPHIC API CALLSITE 4
            String algorithm;
			//SecretKeySpec spec = new SecretKeySpec(key, algorithm);
            instance.init(1, new SecretKeySpec(bArr2, "RC4")); // CRYPTOGRAPHIC API CALLSITE 2, CRYPTOGRAPHIC API CALLSITE 3
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new C0403o(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    static /* synthetic */ byte[] m568b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[(bArr3.length + 8 + 8 + 4 + bArr2.length + 4)];
        System.arraycopy(new byte[]{1, 1, 0, 0}, 0, bArr4, 0, 4);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, 4, 4);
        System.arraycopy(bArr3, 0, bArr4, 8, bArr3.length);
        int length = bArr3.length + 8;
        System.arraycopy(bArr, 0, bArr4, length, 8);
        int i = length + 8;
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, i, 4);
        int i2 = i + 4;
        System.arraycopy(bArr2, 0, bArr4, i2, bArr2.length);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, i2 + bArr2.length, 4);
        return bArr4;
    }

    /* renamed from: c */
    static int m569c(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static byte[] m572c(String str, String str2, byte[] bArr) {
        try {
            C0406r rVar = new C0406r(bArr);
            rVar.mo5168a(str2.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                rVar.mo5168a(str.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
            }
            return rVar.mo5169a();
        } catch (UnsupportedEncodingException e) {
            throw new C0403o("Unicode not supported! " + e.getMessage(), e);
        }
    }

    /* renamed from: c */
    static /* synthetic */ byte[] m573c(byte[] bArr, int i) {
        if (bArr.length < i + 2) {
            throw new C0403o("NTLM authentication - buffer too small for WORD");
        }
        int i2 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
        int d = m576d(bArr, i + 4);
        if (bArr.length < d + i2) {
            throw new C0403o("NTLM authentication - buffer too small for data item");
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, d, bArr2, 0, i2);
        return bArr2;
    }

    /* renamed from: c */
    static /* synthetic */ byte[] m575c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        C0406r rVar = new C0406r(bArr);
        rVar.mo5168a(bArr2);
        rVar.mo5168a(bArr3);
        byte[] a = rVar.mo5169a();
        byte[] bArr4 = new byte[(a.length + bArr3.length)];
        System.arraycopy(a, 0, bArr4, 0, a.length);
        System.arraycopy(bArr3, 0, bArr4, a.length, bArr3.length);
        return bArr4;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static int m576d(byte[] bArr, int i) {
        if (bArr.length >= i + 4) {
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
        }
        throw new C0403o("NTLM authentication - buffer too small for DWORD");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m578d() {
        if (f280a == null) {
            throw new C0403o("Random generator not available");
        }
        byte[] bArr = new byte[8];
        synchronized (f280a) {
            f280a.nextBytes(bArr); // CRYPTOGRAPHIC API CALLSITE 7
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m579d(String str, String str2, byte[] bArr) {
        try {
            C0406r rVar = new C0406r(bArr);
            rVar.mo5168a(str2.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                rVar.mo5168a(str.getBytes("UnicodeLittleUnmarked"));
            }
            return rVar.mo5169a();
        } catch (UnsupportedEncodingException e) {
            throw new C0403o("Unicode not supported! " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m580d(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArr3 = new byte[21];
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            Key e = m582e(bArr3, 0);
            Key e2 = m582e(bArr3, 7);
            Key e3 = m582e(bArr3, 14);
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding"); // CRYPTOGRAPHIC API CALLSITE 27
            instance.init(1, e); // CRYPTOGRAPHIC API CALLSITE 28
            byte[] doFinal = instance.doFinal(bArr2); // CRYPTOGRAPHIC API CALLSITE 16
            instance.init(1, e2);
            byte[] doFinal2 = instance.doFinal(bArr2);
            instance.init(1, e3);
            byte[] doFinal3 = instance.doFinal(bArr2);
            byte[] bArr4 = new byte[24];
            System.arraycopy(doFinal, 0, bArr4, 0, 8);
            System.arraycopy(doFinal2, 0, bArr4, 8, 8);
            System.arraycopy(doFinal3, 0, bArr4, 16, 8);
            return bArr4;
        } catch (Exception e4) {
            throw new C0403o(e4.getMessage(), e4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static String m581e(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(".");
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static Key m582e(byte[] bArr, int i) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, i, bArr2, 0, 7);
        byte[] bArr3 = {bArr2[0], (byte) ((bArr2[0] << 7) | ((bArr2[1] & 255) >>> 1)), (byte) ((bArr2[1] << 6) | ((bArr2[2] & 255) >>> 2)), (byte) ((bArr2[2] << 5) | ((bArr2[3] & 255) >>> 3)), (byte) ((bArr2[3] << 4) | ((bArr2[4] & 255) >>> 4)), (byte) ((bArr2[4] << 3) | ((bArr2[5] & 255) >>> 5)), (byte) ((bArr2[5] << 2) | ((bArr2[6] & 255) >>> 6)), (byte) (bArr2[6] << 1)};
        for (int i2 = 0; i2 < 8; i2++) {
            byte b = bArr3[i2];
            if ((((b >>> 1) ^ ((((((b >>> 7) ^ (b >>> 6)) ^ (b >>> 5)) ^ (b >>> 4)) ^ (b >>> 3)) ^ (b >>> 2))) & 1) == 0) {
                bArr3[i2] = (byte) (bArr3[i2] | 1);
            } else {
                bArr3[i2] = (byte) (bArr3[i2] & -2);
            }
        }
        //String algorithm;
		//SecretKeySpec spec = new SecretKeySpec(key, algorithm);
        return new SecretKeySpec(bArr3, "DES"); // CRYPTOGRAPHIC API CALLSITE 5
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static byte[] m583e() {
        if (f280a == null) {
            throw new C0403o("Random generator not available");
        }
        byte[] bArr = new byte[16];
        synchronized (f280a) {
            f280a.nextBytes(bArr); // CRYPTOGRAPHIC API CALLSITE 24
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static byte[] m584f(String str) {
        try {
            byte[] bytes = str.toUpperCase(Locale.US).getBytes("US-ASCII");
            byte[] bArr = new byte[14];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 14));
            Key e = m582e(bArr, 0);
            Key e2 = m582e(bArr, 7);
            byte[] bytes2 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding"); // CRYPTOGRAPHIC API CALLSITE 20
            instance.init(1, e); // CRYPTOGRAPHIC API CALLSITE 21
            byte[] doFinal = instance.doFinal(bytes2); // CRYPTOGRAPHIC API CALLSITE 22
            instance.init(1, e2);
            byte[] doFinal2 = instance.doFinal(bytes2);
            byte[] bArr2 = new byte[16];
            System.arraycopy(doFinal, 0, bArr2, 0, 8);
            System.arraycopy(doFinal2, 0, bArr2, 8, 8);
            return bArr2;
        } catch (Exception e3) {
            throw new C0403o(e3.getMessage(), e3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static byte[] m585g(String str) {
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            C0407s sVar = new C0407s();
            sVar.mo5170a(bytes);
            return sVar.mo5171a();
        } catch (UnsupportedEncodingException e) {
            throw new C0403o("Unicode not supported: " + e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public final String mo5154a(String str, String str2) {
        return new C0409u(str, str2).mo5177b();
    }

    /* renamed from: a */
    public final String mo5155a(String str, String str2, String str3, String str4, String str5) {
        C0410v vVar = new C0410v(str5);
        return new C0411w(str3, str4, str, str2, vVar.mo5181c(), vVar.mo5184f(), vVar.mo5182d(), vVar.mo5183e()).mo5177b();
    }
}
