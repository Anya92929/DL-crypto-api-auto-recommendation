package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzin;
import java.util.List;

@zzin
public class zze extends zzdx.zza implements zzh.zza {

    /* renamed from: a */
    private String f3665a;

    /* renamed from: b */
    private List f3666b;

    /* renamed from: c */
    private String f3667c;

    /* renamed from: d */
    private zzdr f3668d;

    /* renamed from: e */
    private String f3669e;

    /* renamed from: f */
    private String f3670f;

    /* renamed from: g */
    private zza f3671g;

    /* renamed from: h */
    private Bundle f3672h;

    /* renamed from: i */
    private Object f3673i = new Object();

    /* renamed from: j */
    private zzh f3674j;

    public zze(String str, List list, String str2, zzdr zzdr, String str3, String str4, zza zza, Bundle bundle) {
        this.f3665a = str;
        this.f3666b = list;
        this.f3667c = str2;
        this.f3668d = zzdr;
        this.f3669e = str3;
        this.f3670f = str4;
        this.f3671g = zza;
        this.f3672h = bundle;
    }

    public void destroy() {
        this.f3665a = null;
        this.f3666b = null;
        this.f3667c = null;
        this.f3668d = null;
        this.f3669e = null;
        this.f3670f = null;
        this.f3671g = null;
        this.f3672h = null;
        this.f3673i = null;
        this.f3674j = null;
    }

    public String getAdvertiser() {
        return this.f3670f;
    }

    public String getBody() {
        return this.f3667c;
    }

    public String getCallToAction() {
        return this.f3669e;
    }

    public String getCustomTemplateId() {
        return "";
    }

    public Bundle getExtras() {
        return this.f3672h;
    }

    public String getHeadline() {
        return this.f3665a;
    }

    public List getImages() {
        return this.f3666b;
    }

    public void zzb(zzh zzh) {
        synchronized (this.f3673i) {
            this.f3674j = zzh;
        }
    }

    public zzd zzkv() {
        return com.google.android.gms.dynamic.zze.zzac(this.f3674j);
    }

    public String zzkw() {
        return "1";
    }

    public zza zzkx() {
        return this.f3671g;
    }

    public zzdr zzky() {
        return this.f3668d;
    }
}
