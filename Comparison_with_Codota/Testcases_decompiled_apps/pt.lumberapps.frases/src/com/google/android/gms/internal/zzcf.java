package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzin
public final class zzcf {

    /* renamed from: a */
    private final String f6029a;

    /* renamed from: b */
    private final JSONObject f6030b;

    /* renamed from: c */
    private final String f6031c;

    /* renamed from: d */
    private final String f6032d;

    /* renamed from: e */
    private final boolean f6033e;

    /* renamed from: f */
    private final boolean f6034f;

    public zzcf(String str, VersionInfoParcel versionInfoParcel, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.f6032d = versionInfoParcel.zzcs;
        this.f6030b = jSONObject;
        this.f6031c = str;
        this.f6029a = str2;
        this.f6033e = z;
        this.f6034f = z2;
    }

    public String zzhk() {
        return this.f6029a;
    }

    public String zzhl() {
        return this.f6032d;
    }

    public JSONObject zzhm() {
        return this.f6030b;
    }

    public String zzhn() {
        return this.f6031c;
    }

    public boolean zzho() {
        return this.f6033e;
    }

    public boolean zzhp() {
        return this.f6034f;
    }
}
