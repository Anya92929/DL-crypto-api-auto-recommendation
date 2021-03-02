package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzin
public class zzci extends zzcd {

    /* renamed from: d */
    private final zzft f6041d;

    public zzci(Context context, AdSizeParcel adSizeParcel, zzju zzju, VersionInfoParcel versionInfoParcel, zzck zzck, zzft zzft) {
        super(context, adSizeParcel, zzju, versionInfoParcel, zzck);
        this.f6041d = zzft;
        mo8145a(this.f6041d);
        mo8142a();
        mo8143a(3);
        String valueOf = String.valueOf(this.f6002b.zzhn());
        zzkd.zzcv(valueOf.length() != 0 ? "Tracking ad unit: ".concat(valueOf) : new String("Tracking ad unit: "));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8151b(JSONObject jSONObject) {
        this.f6041d.zza("AFMA_updateActiveView", jSONObject);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8152c() {
        synchronized (this.f6001a) {
            super.mo8152c();
            mo8150b(this.f6041d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo8157h() {
        return true;
    }

    public void zzgy() {
        mo8152c();
    }
}
