package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;

public final class ConnectionEvent extends StatsEvent {
    public static final Parcelable.Creator CREATOR = new zza();

    /* renamed from: a */
    final int f4664a;

    /* renamed from: b */
    private final long f4665b;

    /* renamed from: c */
    private int f4666c;

    /* renamed from: d */
    private final String f4667d;

    /* renamed from: e */
    private final String f4668e;

    /* renamed from: f */
    private final String f4669f;

    /* renamed from: g */
    private final String f4670g;

    /* renamed from: h */
    private final String f4671h;

    /* renamed from: i */
    private final String f4672i;

    /* renamed from: j */
    private final long f4673j;

    /* renamed from: k */
    private final long f4674k;

    /* renamed from: l */
    private long f4675l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f4664a = i;
        this.f4665b = j;
        this.f4666c = i2;
        this.f4667d = str;
        this.f4668e = str2;
        this.f4669f = str3;
        this.f4670g = str4;
        this.f4675l = -1;
        this.f4671h = str5;
        this.f4672i = str6;
        this.f4673j = j2;
        this.f4674k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int getEventType() {
        return this.f4666c;
    }

    public long getTimeMillis() {
        return this.f4665b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m6182a(this, parcel, i);
    }

    public String zzaun() {
        return this.f4667d;
    }

    public String zzauo() {
        return this.f4668e;
    }

    public String zzaup() {
        return this.f4669f;
    }

    public String zzauq() {
        return this.f4670g;
    }

    public String zzaur() {
        return this.f4671h;
    }

    public String zzaus() {
        return this.f4672i;
    }

    public long zzaut() {
        return this.f4675l;
    }

    public long zzauu() {
        return this.f4674k;
    }

    public long zzauv() {
        return this.f4673j;
    }

    public String zzauw() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzaun());
        String valueOf3 = String.valueOf(zzauo());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(zzaup());
        String valueOf6 = String.valueOf(zzauq());
        String valueOf7 = String.valueOf("\t");
        String str = this.f4671h == null ? "" : this.f4671h;
        String valueOf8 = String.valueOf("\t");
        return new StringBuilder(String.valueOf(valueOf).length() + 22 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str).length() + String.valueOf(valueOf8).length()).append(valueOf).append(valueOf2).append("/").append(valueOf3).append(valueOf4).append(valueOf5).append("/").append(valueOf6).append(valueOf7).append(str).append(valueOf8).append(zzauu()).toString();
    }
}
