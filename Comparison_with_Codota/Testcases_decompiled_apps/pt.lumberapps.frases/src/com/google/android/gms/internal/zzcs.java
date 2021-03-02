package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzin
public class zzcs extends zzcp {

    /* renamed from: b */
    private MessageDigest f6081b;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte mo8239a(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo8240a(String[] strArr) {
        if (strArr.length == 1) {
            return zzcr.zzn(zzcr.zzac(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i = 0; i < strArr.length; i++) {
                byte[] b = mo8241b(zzcr.zzac(strArr[i]));
                bArr[i * 2] = b[0];
                bArr[(i * 2) + 1] = b[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr2[i2] = mo8239a(zzcr.zzac(strArr[i2]));
        }
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo8241b(int i) {
        int i2 = (65535 & i) ^ ((-65536 & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }

    public byte[] zzaa(String str) {
        byte[] bArr;
        int i = 4;
        byte[] a = mo8240a(str.split(" "));
        this.f6081b = mo8234a();
        synchronized (this.f6076a) {
            if (this.f6081b == null) {
                bArr = new byte[0];
            } else {
                this.f6081b.reset();
                this.f6081b.update(a);
                byte[] digest = this.f6081b.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
