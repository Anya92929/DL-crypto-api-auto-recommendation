package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzdv;
import com.google.android.gms.internal.zzin;
import java.util.List;

@zzin
public class zzd extends zzdv.zza implements zzh.zza {

    /* renamed from: a */
    private String f3653a;

    /* renamed from: b */
    private List f3654b;

    /* renamed from: c */
    private String f3655c;

    /* renamed from: d */
    private zzdr f3656d;

    /* renamed from: e */
    private String f3657e;

    /* renamed from: f */
    private double f3658f;

    /* renamed from: g */
    private String f3659g;

    /* renamed from: h */
    private String f3660h;

    /* renamed from: i */
    private zza f3661i;

    /* renamed from: j */
    private Bundle f3662j;

    /* renamed from: k */
    private Object f3663k = new Object();

    /* renamed from: l */
    private zzh f3664l;

    public zzd(String str, List list, String str2, zzdr zzdr, String str3, double d, String str4, String str5, zza zza, Bundle bundle) {
        this.f3653a = str;
        this.f3654b = list;
        this.f3655c = str2;
        this.f3656d = zzdr;
        this.f3657e = str3;
        this.f3658f = d;
        this.f3659g = str4;
        this.f3660h = str5;
        this.f3661i = zza;
        this.f3662j = bundle;
    }

    public void destroy() {
        this.f3653a = null;
        this.f3654b = null;
        this.f3655c = null;
        this.f3656d = null;
        this.f3657e = null;
        this.f3658f = 0.0d;
        this.f3659g = null;
        this.f3660h = null;
        this.f3661i = null;
        this.f3662j = null;
        this.f3663k = null;
        this.f3664l = null;
    }

    public String getBody() {
        return this.f3655c;
    }

    public String getCallToAction() {
        return this.f3657e;
    }

    public String getCustomTemplateId() {
        return "";
    }

    public Bundle getExtras() {
        return this.f3662j;
    }

    public String getHeadline() {
        return this.f3653a;
    }

    public List getImages() {
        return this.f3654b;
    }

    public String getPrice() {
        return this.f3660h;
    }

    public double getStarRating() {
        return this.f3658f;
    }

    public String getStore() {
        return this.f3659g;
    }

    public void zzb(zzh zzh) {
        synchronized (this.f3663k) {
            this.f3664l = zzh;
        }
    }

    public zzdr zzku() {
        return this.f3656d;
    }

    public com.google.android.gms.dynamic.zzd zzkv() {
        return zze.zzac(this.f3664l);
    }

    public String zzkw() {
        return "2";
    }

    public zza zzkx() {
        return this.f3661i;
    }
}
