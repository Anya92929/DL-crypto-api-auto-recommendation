package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.internal.zzkn;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.ko */
class C1693ko implements zzkn.zza {

    /* renamed from: a */
    final /* synthetic */ boolean f5231a;

    /* renamed from: b */
    final /* synthetic */ double f5232b;

    /* renamed from: c */
    final /* synthetic */ String f5233c;

    /* renamed from: d */
    final /* synthetic */ zzii f5234d;

    C1693ko(zzii zzii, boolean z, double d, String str) {
        this.f5234d = zzii;
        this.f5231a = z;
        this.f5232b = d;
        this.f5233c = str;
    }

    /* renamed from: a */
    public zzc zzqu() {
        this.f5234d.zza(2, this.f5231a);
        return null;
    }

    /* renamed from: a */
    public zzc zzh(InputStream inputStream) {
        byte[] bArr;
        try {
            bArr = zzo.zzk(inputStream);
        } catch (IOException e) {
            bArr = null;
        }
        if (bArr == null) {
            this.f5234d.zza(2, this.f5231a);
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray == null) {
            this.f5234d.zza(2, this.f5231a);
            return null;
        }
        decodeByteArray.setDensity((int) (160.0d * this.f5232b));
        return new zzc(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(this.f5233c), this.f5232b);
    }
}
