package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzin
public final class zzgp implements MediationAdRequest {

    /* renamed from: a */
    private final Date f6263a;

    /* renamed from: b */
    private final int f6264b;

    /* renamed from: c */
    private final Set f6265c;

    /* renamed from: d */
    private final boolean f6266d;

    /* renamed from: e */
    private final Location f6267e;

    /* renamed from: f */
    private final int f6268f;

    /* renamed from: g */
    private final boolean f6269g;

    public zzgp(Date date, int i, Set set, Location location, boolean z, int i2, boolean z2) {
        this.f6263a = date;
        this.f6264b = i;
        this.f6265c = set;
        this.f6267e = location;
        this.f6266d = z;
        this.f6268f = i2;
        this.f6269g = z2;
    }

    public Date getBirthday() {
        return this.f6263a;
    }

    public int getGender() {
        return this.f6264b;
    }

    public Set getKeywords() {
        return this.f6265c;
    }

    public Location getLocation() {
        return this.f6267e;
    }

    public boolean isDesignedForFamilies() {
        return this.f6269g;
    }

    public boolean isTesting() {
        return this.f6266d;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f6268f;
    }
}
