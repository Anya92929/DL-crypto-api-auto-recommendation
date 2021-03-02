package com.google.android.gms.internal;

import android.support.p000v4.view.MotionEventCompat;
import java.security.MessageDigest;

/* renamed from: com.google.android.gms.internal.ar */
public class C0919ar extends C0914ao {

    /* renamed from: nP */
    private MessageDigest f2606nP;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo8008a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = (byte) (C0918aq.m3894o(strArr[i]) & MotionEventCompat.ACTION_MASK);
        }
        return bArr;
    }

    /* renamed from: l */
    public byte[] mo8001l(String str) {
        byte[] bArr;
        byte[] a = mo8008a(str.split(" "));
        this.f2606nP = mo8000ba();
        synchronized (this.f2598mw) {
            if (this.f2606nP == null) {
                bArr = new byte[0];
            } else {
                this.f2606nP.reset();
                this.f2606nP.update(a);
                byte[] digest = this.f2606nP.digest();
                int i = 4;
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
