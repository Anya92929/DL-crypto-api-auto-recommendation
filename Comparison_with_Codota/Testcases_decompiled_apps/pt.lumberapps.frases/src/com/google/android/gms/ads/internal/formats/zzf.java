package com.google.android.gms.ads.internal.formats;

import android.support.p009v4.p019f.C0150o;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzin;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzin
public class zzf extends zzdz.zza implements zzh.zza {

    /* renamed from: a */
    private final zza f3675a;

    /* renamed from: b */
    private final String f3676b;

    /* renamed from: c */
    private final C0150o f3677c;

    /* renamed from: d */
    private final C0150o f3678d;

    /* renamed from: e */
    private final Object f3679e = new Object();

    /* renamed from: f */
    private zzh f3680f;

    public zzf(String str, C0150o oVar, C0150o oVar2, zza zza) {
        this.f3676b = str;
        this.f3677c = oVar;
        this.f3678d = oVar2;
        this.f3675a = zza;
    }

    public List getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.f3677c.size() + this.f3678d.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3677c.size(); i3++) {
            strArr[i2] = (String) this.f3677c.mo1152b(i3);
            i2++;
        }
        while (i < this.f3678d.size()) {
            strArr[i2] = (String) this.f3678d.mo1152b(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public String getCustomTemplateId() {
        return this.f3676b;
    }

    public void performClick(String str) {
        synchronized (this.f3679e) {
            if (this.f3680f == null) {
                zzb.m5769e("Attempt to call performClick before ad initialized.");
            } else {
                this.f3680f.zza(str, (JSONObject) null, (JSONObject) null, (JSONObject) null);
            }
        }
    }

    public void recordImpression() {
        synchronized (this.f3679e) {
            if (this.f3680f == null) {
                zzb.m5769e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.f3680f.recordImpression();
            }
        }
    }

    public String zzat(String str) {
        return (String) this.f3678d.get(str);
    }

    public zzdr zzau(String str) {
        return (zzdr) this.f3677c.get(str);
    }

    public void zzb(zzh zzh) {
        synchronized (this.f3679e) {
            this.f3680f = zzh;
        }
    }

    public String zzkw() {
        return "3";
    }

    public zza zzkx() {
        return this.f3675a;
    }
}
