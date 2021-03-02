package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a */
    final int f2546a;

    /* renamed from: b */
    String f2547b;

    /* renamed from: c */
    String f2548c;

    /* renamed from: d */
    String f2549d;

    /* renamed from: e */
    String f2550e;

    /* renamed from: f */
    String f2551f;

    /* renamed from: g */
    List<String> f2552g;
    public FACLData zzYB;

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List<String> list, FACLData fACLData) {
        this.f2546a = i;
        this.f2547b = str;
        this.f2548c = str2;
        this.f2549d = str3;
        this.f2550e = str4;
        this.f2551f = str5;
        this.f2552g = list;
        this.zzYB = fACLData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m3648a(this, parcel, i);
    }
}
