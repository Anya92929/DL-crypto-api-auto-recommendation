package com.google.android.gms.internal;

import android.support.p009v4.app.FragmentTransaction;
import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ei */
class C1525ei {

    /* renamed from: a */
    ByteArrayOutputStream f4969a = new ByteArrayOutputStream(FragmentTransaction.TRANSIT_ENTER_MASK);

    /* renamed from: b */
    Base64OutputStream f4970b = new Base64OutputStream(this.f4969a, 10);

    /* renamed from: a */
    public void mo7228a(byte[] bArr) {
        this.f4970b.write(bArr);
    }

    public String toString() {
        String str;
        try {
            this.f4970b.close();
        } catch (IOException e) {
            zzkd.zzb("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f4969a.close();
            str = this.f4969a.toString();
        } catch (IOException e2) {
            zzkd.zzb("HashManager: Unable to convert to Base64.", e2);
            str = "";
        } finally {
            this.f4969a = null;
            this.f4970b = null;
        }
        return str;
    }
}
