package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@C1130ez
/* renamed from: com.google.android.gms.internal.ax */
public class C0926ax {

    /* renamed from: oe */
    public static final C0926ax f2621oe = new C0926ax();

    private C0926ax() {
    }

    /* renamed from: bb */
    public static C0926ax m3911bb() {
        return f2621oe;
    }

    /* renamed from: a */
    public C0924av mo8021a(Context context, C0944bg bgVar) {
        Date birthday = bgVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = bgVar.getContentUrl();
        int gender = bgVar.getGender();
        Set<String> keywords = bgVar.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = bgVar.isTestDevice(context);
        int bg = bgVar.mo8066bg();
        Location location = bgVar.getLocation();
        Bundle networkExtrasBundle = bgVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = bgVar.getManualImpressionsEnabled();
        String publisherProvidedId = bgVar.getPublisherProvidedId();
        SearchAdRequest bd = bgVar.mo8063bd();
        return new C0924av(4, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, bg, manualImpressionsEnabled, publisherProvidedId, bd != null ? new C0948bj(bd) : null, location, contentUrl, bgVar.mo8065bf());
    }
}
