package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.c */
abstract class C1344c extends zzs.zza {

    /* renamed from: a */
    private int f4362a;

    protected C1344c(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 25) {
            int length = bArr.length;
            String valueOf = String.valueOf(zzm.zza(bArr, 0, bArr.length, false));
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(valueOf).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(valueOf).toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            zzab.zzb(bArr.length == 25 ? true : z, (Object) new StringBuilder(55).append("cert hash data has incorrect length. length=").append(bArr.length).toString());
        }
        this.f4362a = Arrays.hashCode(bArr);
    }

    /* renamed from: a */
    protected static byte[] m5986a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract byte[] mo6402a();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzs)) {
            return false;
        }
        try {
            zzs zzs = (zzs) obj;
            if (zzs.zzanl() != hashCode()) {
                return false;
            }
            zzd zzank = zzs.zzank();
            if (zzank == null) {
                return false;
            }
            return Arrays.equals(mo6402a(), (byte[]) zze.zzad(zzank));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
            return false;
        }
    }

    public int hashCode() {
        return this.f4362a;
    }

    public zzd zzank() {
        return zze.zzac(mo6402a());
    }

    public int zzanl() {
        return hashCode();
    }
}
