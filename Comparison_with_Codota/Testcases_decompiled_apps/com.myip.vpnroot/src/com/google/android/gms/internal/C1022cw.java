package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@C1130ez
/* renamed from: com.google.android.gms.internal.cw */
public final class C1022cw implements MediationAdRequest {

    /* renamed from: d */
    private final Date f3067d;

    /* renamed from: f */
    private final Set<String> f3068f;

    /* renamed from: g */
    private final boolean f3069g;

    /* renamed from: h */
    private final Location f3070h;

    /* renamed from: om */
    private final int f3071om;

    /* renamed from: qD */
    private final int f3072qD;

    public C1022cw(Date date, int i, Set<String> set, Location location, boolean z, int i2) {
        this.f3067d = date;
        this.f3071om = i;
        this.f3068f = set;
        this.f3070h = location;
        this.f3069g = z;
        this.f3072qD = i2;
    }

    public Date getBirthday() {
        return this.f3067d;
    }

    public int getGender() {
        return this.f3071om;
    }

    public Set<String> getKeywords() {
        return this.f3068f;
    }

    public Location getLocation() {
        return this.f3070h;
    }

    public boolean isTesting() {
        return this.f3069g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f3072qD;
    }
}
