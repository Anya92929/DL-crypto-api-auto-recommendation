package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();

    /* renamed from: a */
    final int f3068a;

    /* renamed from: b */
    private final long f3069b;

    /* renamed from: c */
    private int f3070c;

    /* renamed from: d */
    private final String f3071d;

    /* renamed from: e */
    private final String f3072e;

    /* renamed from: f */
    private final String f3073f;

    /* renamed from: g */
    private final String f3074g;

    /* renamed from: h */
    private final String f3075h;

    /* renamed from: i */
    private final String f3076i;

    /* renamed from: j */
    private final long f3077j;

    /* renamed from: k */
    private final long f3078k;

    /* renamed from: l */
    private long f3079l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f3068a = i;
        this.f3069b = j;
        this.f3070c = i2;
        this.f3071d = str;
        this.f3072e = str2;
        this.f3073f = str3;
        this.f3074g = str4;
        this.f3079l = -1;
        this.f3075h = str5;
        this.f3076i = str6;
        this.f3077j = j2;
        this.f3078k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.f3070c;
    }

    public long getTimeMillis() {
        return this.f3069b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m3991a(this, parcel, i);
    }

    public String zzrF() {
        return this.f3071d;
    }

    public String zzrG() {
        return this.f3072e;
    }

    public String zzrH() {
        return this.f3073f;
    }

    public String zzrI() {
        return this.f3074g;
    }

    public String zzrJ() {
        return this.f3075h;
    }

    public String zzrK() {
        return this.f3076i;
    }

    public long zzrL() {
        return this.f3079l;
    }

    public long zzrM() {
        return this.f3078k;
    }

    public long zzrN() {
        return this.f3077j;
    }

    public String zzrO() {
        return "\t" + zzrF() + "/" + zzrG() + "\t" + zzrH() + "/" + zzrI() + "\t" + (this.f3075h == null ? "" : this.f3075h) + "\t" + zzrM();
    }
}
