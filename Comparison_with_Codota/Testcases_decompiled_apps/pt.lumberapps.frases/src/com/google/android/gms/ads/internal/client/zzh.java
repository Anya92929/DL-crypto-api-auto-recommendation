package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzin
public class zzh {
    public static final zzh zzauq = new zzh();

    protected zzh() {
    }

    public static zzh zzih() {
        return zzauq;
    }

    public AdRequestParcel zza(Context context, zzad zzad) {
        Date birthday = zzad.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzad.getContentUrl();
        int gender = zzad.getGender();
        Set keywords = zzad.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = zzad.isTestDevice(context);
        int zzji = zzad.zzji();
        Location location = zzad.getLocation();
        Bundle networkExtrasBundle = zzad.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzad.getManualImpressionsEnabled();
        String publisherProvidedId = zzad.getPublisherProvidedId();
        SearchAdRequest zzjf = zzad.zzjf();
        SearchAdRequestParcel searchAdRequestParcel = zzjf != null ? new SearchAdRequestParcel(zzjf) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = zzm.zziw().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzji, manualImpressionsEnabled, publisherProvidedId, searchAdRequestParcel, location, contentUrl, zzad.zzjh(), zzad.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzad.zzjj())), zzad.zzje(), str, zzad.isDesignedForFamilies());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzad zzad, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, zzad), str);
    }
}
