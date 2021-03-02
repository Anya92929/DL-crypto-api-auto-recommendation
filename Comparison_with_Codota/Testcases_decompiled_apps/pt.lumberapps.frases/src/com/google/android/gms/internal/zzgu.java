package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzin
public final class zzgu implements NativeMediationAdRequest {

    /* renamed from: a */
    private final Date f6276a;

    /* renamed from: b */
    private final int f6277b;

    /* renamed from: c */
    private final Set f6278c;

    /* renamed from: d */
    private final boolean f6279d;

    /* renamed from: e */
    private final Location f6280e;

    /* renamed from: f */
    private final int f6281f;

    /* renamed from: g */
    private final NativeAdOptionsParcel f6282g;

    /* renamed from: h */
    private final List f6283h;

    /* renamed from: i */
    private final boolean f6284i;

    public zzgu(Date date, int i, Set set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List list, boolean z2) {
        this.f6276a = date;
        this.f6277b = i;
        this.f6278c = set;
        this.f6280e = location;
        this.f6279d = z;
        this.f6281f = i2;
        this.f6282g = nativeAdOptionsParcel;
        this.f6283h = list;
        this.f6284i = z2;
    }

    public Date getBirthday() {
        return this.f6276a;
    }

    public int getGender() {
        return this.f6277b;
    }

    public Set getKeywords() {
        return this.f6278c;
    }

    public Location getLocation() {
        return this.f6280e;
    }

    public NativeAdOptions getNativeAdOptions() {
        if (this.f6282g == null) {
            return null;
        }
        return new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.f6282g.zzbgp).setImageOrientation(this.f6282g.zzbgq).setRequestMultipleImages(this.f6282g.zzbgr).build();
    }

    public boolean isAppInstallAdRequested() {
        return this.f6283h != null && this.f6283h.contains("2");
    }

    public boolean isContentAdRequested() {
        return this.f6283h != null && this.f6283h.contains("1");
    }

    public boolean isDesignedForFamilies() {
        return this.f6284i;
    }

    public boolean isTesting() {
        return this.f6279d;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f6281f;
    }
}
