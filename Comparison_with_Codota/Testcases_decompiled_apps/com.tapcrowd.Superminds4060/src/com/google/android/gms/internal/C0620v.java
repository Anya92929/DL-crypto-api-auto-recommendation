package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.v */
public final class C0620v implements SafeParcelable {
    public static final C0621w CREATOR = new C0621w();

    /* renamed from: es */
    public final long f1577es;

    /* renamed from: et */
    public final int f1578et;

    /* renamed from: eu */
    public final List<String> f1579eu;

    /* renamed from: ev */
    public final boolean f1580ev;
    public final Bundle extras;
    public final int tagForChildDirectedTreatment;
    public final int versionCode;

    C0620v(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3) {
        this.versionCode = i;
        this.f1577es = j;
        this.extras = bundle;
        this.f1578et = i2;
        this.f1579eu = list;
        this.f1580ev = z;
        this.tagForChildDirectedTreatment = i3;
    }

    public C0620v(Context context, AdRequest adRequest) {
        Bundle bundle = null;
        this.versionCode = 1;
        Date birthday = adRequest.getBirthday();
        this.f1577es = birthday != null ? birthday.getTime() : -1;
        this.f1578et = adRequest.getGender();
        Set<String> keywords = adRequest.getKeywords();
        this.f1579eu = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        this.f1580ev = adRequest.isTestDevice(context);
        this.tagForChildDirectedTreatment = adRequest.mo3461w();
        AdMobExtras adMobExtras = (AdMobExtras) adRequest.getNetworkExtras(AdMobExtras.class);
        this.extras = adMobExtras != null ? adMobExtras.getExtras() : bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0621w.m1955a(this, out, flags);
    }
}
