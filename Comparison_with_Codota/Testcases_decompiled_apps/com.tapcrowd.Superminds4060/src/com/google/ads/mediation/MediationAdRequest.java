package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {

    /* renamed from: d */
    private final Date f279d;

    /* renamed from: e */
    private final AdRequest.Gender f280e;

    /* renamed from: f */
    private final Set<String> f281f;

    /* renamed from: g */
    private final boolean f282g;

    public MediationAdRequest(Date birthday, AdRequest.Gender gender, Set<String> keywords, boolean isTesting) {
        this.f279d = birthday;
        this.f280e = gender;
        this.f281f = keywords;
        this.f282g = isTesting;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f279d;
    }

    public AdRequest.Gender getGender() {
        return this.f280e;
    }

    public Set<String> getKeywords() {
        return this.f281f;
    }

    public Location getLocation() {
        return null;
    }

    public boolean isTesting() {
        return this.f282g;
    }
}
