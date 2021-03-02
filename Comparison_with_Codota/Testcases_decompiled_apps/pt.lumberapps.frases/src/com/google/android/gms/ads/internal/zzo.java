package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzkd;

@zzin
public class zzo extends zzz.zza {

    /* renamed from: b */
    private static final Object f4056b = new Object();

    /* renamed from: c */
    private static zzo f4057c;

    /* renamed from: a */
    private final Context f4058a;

    /* renamed from: d */
    private final Object f4059d = new Object();

    /* renamed from: e */
    private boolean f4060e;

    /* renamed from: f */
    private boolean f4061f;

    /* renamed from: g */
    private float f4062g = -1.0f;

    /* renamed from: h */
    private VersionInfoParcel f4063h;

    zzo(Context context, VersionInfoParcel versionInfoParcel) {
        this.f4058a = context;
        this.f4063h = versionInfoParcel;
        this.f4060e = false;
    }

    public static zzo zza(Context context, VersionInfoParcel versionInfoParcel) {
        zzo zzo;
        synchronized (f4056b) {
            if (f4057c == null) {
                f4057c = new zzo(context.getApplicationContext(), versionInfoParcel);
            }
            zzo = f4057c;
        }
        return zzo;
    }

    public static zzo zzex() {
        zzo zzo;
        synchronized (f4056b) {
            zzo = f4057c;
        }
        return zzo;
    }

    public void initialize() {
        synchronized (f4056b) {
            if (this.f4060e) {
                zzkd.zzcx("Mobile ads is initialized already.");
            } else {
                this.f4060e = true;
            }
        }
    }

    public void setAppMuted(boolean z) {
        synchronized (this.f4059d) {
            this.f4061f = z;
        }
    }

    public void setAppVolume(float f) {
        synchronized (this.f4059d) {
            this.f4062g = f;
        }
    }

    public float zzey() {
        float f;
        synchronized (this.f4059d) {
            f = this.f4062g;
        }
        return f;
    }

    public boolean zzez() {
        boolean z;
        synchronized (this.f4059d) {
            z = this.f4062g >= 0.0f;
        }
        return z;
    }

    public boolean zzfa() {
        boolean z;
        synchronized (this.f4059d) {
            z = this.f4061f;
        }
        return z;
    }

    public void zzu(String str) {
        zzdc.initialize(this.f4058a);
        if (!TextUtils.isEmpty(str) && ((Boolean) zzdc.zzbct.get()).booleanValue()) {
            zzu.zzgi().zza(this.f4058a, this.f4063h, true, (zzjw) null, str, (String) null);
        }
    }
}
