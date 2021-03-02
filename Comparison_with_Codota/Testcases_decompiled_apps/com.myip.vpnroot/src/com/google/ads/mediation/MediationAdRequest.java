package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {

    /* renamed from: d */
    private final Date f10d;

    /* renamed from: e */
    private final AdRequest.Gender f11e;

    /* renamed from: f */
    private final Set<String> f12f;

    /* renamed from: g */
    private final boolean f13g;

    /* renamed from: h */
    private final Location f14h;

    public MediationAdRequest(Date birthday, AdRequest.Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.f10d = birthday;
        this.f11e = gender;
        this.f12f = keywords;
        this.f13g = isTesting;
        this.f14h = location;
    }

    public Integer getAgeInYears() {
        if (this.f10d == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f10d);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.f10d;
    }

    public AdRequest.Gender getGender() {
        return this.f11e;
    }

    public Set<String> getKeywords() {
        return this.f12f;
    }

    public Location getLocation() {
        return this.f14h;
    }

    public boolean isTesting() {
        return this.f13g;
    }
}
