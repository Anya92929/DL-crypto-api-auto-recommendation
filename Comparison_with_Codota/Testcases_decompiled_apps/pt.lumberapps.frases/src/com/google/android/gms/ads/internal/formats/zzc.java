package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzin;

@zzin
public class zzc extends zzdr.zza {

    /* renamed from: a */
    private final Drawable f3650a;

    /* renamed from: b */
    private final Uri f3651b;

    /* renamed from: c */
    private final double f3652c;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.f3650a = drawable;
        this.f3651b = uri;
        this.f3652c = d;
    }

    public double getScale() {
        return this.f3652c;
    }

    public Uri getUri() {
        return this.f3651b;
    }

    public zzd zzkt() {
        return zze.zzac(this.f3650a);
    }
}
