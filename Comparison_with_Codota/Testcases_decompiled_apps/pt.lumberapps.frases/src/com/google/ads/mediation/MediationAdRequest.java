package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzfp;
    private final AdRequest.Gender zzfq;
    private final Set zzfr;
    private final boolean zzfs;
    private final Location zzft;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set set, boolean z, Location location) {
        this.zzfp = date;
        this.zzfq = gender;
        this.zzfr = set;
        this.zzfs = z;
        this.zzft = location;
    }

    public Integer getAgeInYears() {
        if (this.zzfp == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzfp);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzfp;
    }

    public AdRequest.Gender getGender() {
        return this.zzfq;
    }

    public Set getKeywords() {
        return this.zzfr;
    }

    public Location getLocation() {
        return this.zzft;
    }

    public boolean isTesting() {
        return this.zzfs;
    }
}
