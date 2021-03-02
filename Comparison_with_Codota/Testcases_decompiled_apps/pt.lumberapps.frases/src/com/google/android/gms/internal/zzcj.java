package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzla;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzcj extends zzcd {

    /* renamed from: d */
    private zzfs.zzc f6042d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6043e;

    public zzcj(Context context, AdSizeParcel adSizeParcel, zzju zzju, VersionInfoParcel versionInfoParcel, zzck zzck, zzfs zzfs) {
        super(context, adSizeParcel, zzju, versionInfoParcel, zzck);
        this.f6042d = zzfs.zzma();
        try {
            this.f6042d.zza(new C1513dx(this, mo8141a(zzck.zzhj().zzhh())), new C1514dy(this));
        } catch (JSONException e) {
        } catch (RuntimeException e2) {
            zzkd.zzb("Failure while processing active view data.", e2);
        }
        this.f6042d.zza(new C1515dz(this), new C1517ea(this));
        String valueOf = String.valueOf(this.f6002b.zzhn());
        zzkd.zzcv(valueOf.length() != 0 ? "Tracking ad unit: ".concat(valueOf) : new String("Tracking ad unit: "));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8151b(JSONObject jSONObject) {
        this.f6042d.zza(new C1518eb(this, jSONObject), new zzla.zzb());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8152c() {
        synchronized (this.f6001a) {
            super.mo8152c();
            this.f6042d.zza(new C1519ec(this), new zzla.zzb());
            this.f6042d.release();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo8157h() {
        return this.f6043e;
    }
}
