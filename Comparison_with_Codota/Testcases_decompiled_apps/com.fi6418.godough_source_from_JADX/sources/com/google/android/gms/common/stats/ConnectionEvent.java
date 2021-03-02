package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new C1092a();

    /* renamed from: a */
    final int f4812a;

    /* renamed from: b */
    private final long f4813b;

    /* renamed from: c */
    private int f4814c;

    /* renamed from: d */
    private final String f4815d;

    /* renamed from: e */
    private final String f4816e;

    /* renamed from: f */
    private final String f4817f;

    /* renamed from: g */
    private final String f4818g;

    /* renamed from: h */
    private final String f4819h;

    /* renamed from: i */
    private final String f4820i;

    /* renamed from: j */
    private final long f4821j;

    /* renamed from: k */
    private final long f4822k;

    /* renamed from: l */
    private long f4823l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f4812a = i;
        this.f4813b = j;
        this.f4814c = i2;
        this.f4815d = str;
        this.f4816e = str2;
        this.f4817f = str3;
        this.f4818g = str4;
        this.f4823l = -1;
        this.f4819h = str5;
        this.f4820i = str6;
        this.f4821j = j2;
        this.f4822k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    /* renamed from: a */
    public long mo7672a() {
        return this.f4813b;
    }

    /* renamed from: b */
    public int mo7673b() {
        return this.f4814c;
    }

    /* renamed from: c */
    public String mo7674c() {
        return this.f4815d;
    }

    /* renamed from: d */
    public String mo7675d() {
        return this.f4816e;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo7677e() {
        return this.f4817f;
    }

    /* renamed from: f */
    public String mo7678f() {
        return this.f4818g;
    }

    /* renamed from: g */
    public String mo7679g() {
        return this.f4819h;
    }

    /* renamed from: h */
    public String mo7680h() {
        return this.f4820i;
    }

    /* renamed from: i */
    public long mo7681i() {
        return this.f4822k;
    }

    /* renamed from: j */
    public long mo7682j() {
        return this.f4821j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1092a.m4758a(this, parcel, i);
    }
}
