package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.rb */
class C1869rb {

    /* renamed from: a */
    public long f5533a;

    /* renamed from: b */
    public String f5534b;

    /* renamed from: c */
    public String f5535c;

    /* renamed from: d */
    public long f5536d;

    /* renamed from: e */
    public long f5537e;

    /* renamed from: f */
    public long f5538f;

    /* renamed from: g */
    public long f5539g;

    /* renamed from: h */
    public Map f5540h;

    private C1869rb() {
    }

    public C1869rb(String str, zzb.zza zza) {
        this.f5534b = str;
        this.f5533a = (long) zza.data.length;
        this.f5535c = zza.zza;
        this.f5536d = zza.zzb;
        this.f5537e = zza.zzc;
        this.f5538f = zza.zzd;
        this.f5539g = zza.zze;
        this.f5540h = zza.zzf;
    }

    /* renamed from: a */
    public static C1869rb m6605a(InputStream inputStream) {
        C1869rb rbVar = new C1869rb();
        if (zzv.m7580a(inputStream) != 538247942) {
            throw new IOException();
        }
        rbVar.f5534b = zzv.m7591c(inputStream);
        rbVar.f5535c = zzv.m7591c(inputStream);
        if (rbVar.f5535c.equals("")) {
            rbVar.f5535c = null;
        }
        rbVar.f5536d = zzv.m7589b(inputStream);
        rbVar.f5537e = zzv.m7589b(inputStream);
        rbVar.f5538f = zzv.m7589b(inputStream);
        rbVar.f5539g = zzv.m7589b(inputStream);
        rbVar.f5540h = zzv.m7592d(inputStream);
        return rbVar;
    }

    /* renamed from: a */
    public zzb.zza mo7696a(byte[] bArr) {
        zzb.zza zza = new zzb.zza();
        zza.data = bArr;
        zza.zza = this.f5535c;
        zza.zzb = this.f5536d;
        zza.zzc = this.f5537e;
        zza.zzd = this.f5538f;
        zza.zze = this.f5539g;
        zza.zzf = this.f5540h;
        return zza;
    }

    /* renamed from: a */
    public boolean mo7697a(OutputStream outputStream) {
        try {
            zzv.m7583a(outputStream, 538247942);
            zzv.m7585a(outputStream, this.f5534b);
            zzv.m7585a(outputStream, this.f5535c == null ? "" : this.f5535c);
            zzv.m7584a(outputStream, this.f5536d);
            zzv.m7584a(outputStream, this.f5537e);
            zzv.m7584a(outputStream, this.f5538f);
            zzv.m7584a(outputStream, this.f5539g);
            zzv.m7587a(this.f5540h, outputStream);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzs.zzb("%s", e.toString());
            return false;
        }
    }
}
