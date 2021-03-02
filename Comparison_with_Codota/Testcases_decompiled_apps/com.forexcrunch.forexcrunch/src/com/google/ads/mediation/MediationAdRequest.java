package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest {

    /* renamed from: a */
    private AdRequest f633a;

    /* renamed from: b */
    private boolean f634b;

    /* renamed from: c */
    private boolean f635c;

    public MediationAdRequest(AdRequest request, Context context, boolean shareLocation) {
        this.f633a = request;
        this.f635c = shareLocation;
        if (context == null) {
            this.f634b = true;
        } else {
            this.f634b = request.isTestDevice(context);
        }
    }

    public AdRequest.Gender getGender() {
        return this.f633a.getGender();
    }

    public Date getBirthday() {
        return this.f633a.getBirthday();
    }

    public Integer getAgeInYears() {
        if (this.f633a.getBirthday() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f633a.getBirthday());
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        if (instance2.get(6) < instance.get(6)) {
            return Integer.valueOf(valueOf.intValue() - 1);
        }
        return valueOf;
    }

    public Set<String> getKeywords() {
        if (this.f633a.getKeywords() == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f633a.getKeywords());
    }

    public Location getLocation() {
        if (this.f633a.getLocation() == null || !this.f635c) {
            return null;
        }
        return new Location(this.f633a.getLocation());
    }

    public boolean isTesting() {
        return this.f634b;
    }
}
