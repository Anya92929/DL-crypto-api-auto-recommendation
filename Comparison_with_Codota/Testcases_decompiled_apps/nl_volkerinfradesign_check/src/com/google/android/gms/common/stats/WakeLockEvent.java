package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();

    /* renamed from: a */
    final int f3080a;

    /* renamed from: b */
    private final long f3081b;

    /* renamed from: c */
    private int f3082c;

    /* renamed from: d */
    private final String f3083d;

    /* renamed from: e */
    private final int f3084e;

    /* renamed from: f */
    private final List<String> f3085f;

    /* renamed from: g */
    private final String f3086g;

    /* renamed from: h */
    private final long f3087h;

    /* renamed from: i */
    private int f3088i;

    /* renamed from: j */
    private final String f3089j;

    /* renamed from: k */
    private final String f3090k;

    /* renamed from: l */
    private final float f3091l;

    /* renamed from: m */
    private final long f3092m;

    /* renamed from: n */
    private long f3093n;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.f3080a = i;
        this.f3081b = j;
        this.f3082c = i2;
        this.f3083d = str;
        this.f3089j = str3;
        this.f3084e = i3;
        this.f3093n = -1;
        this.f3085f = list;
        this.f3086g = str2;
        this.f3087h = j2;
        this.f3088i = i4;
        this.f3090k = str4;
        this.f3091l = f;
        this.f3092m = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3);
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.f3082c;
    }

    public long getTimeMillis() {
        return this.f3081b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m4001a(this, parcel, i);
    }

    public String zzrK() {
        return this.f3086g;
    }

    public long zzrL() {
        return this.f3093n;
    }

    public long zzrN() {
        return this.f3087h;
    }

    public String zzrO() {
        return "\t" + zzrR() + "\t" + zzrT() + "\t" + (zzrU() == null ? "" : TextUtils.join(",", zzrU())) + "\t" + zzrV() + "\t" + (zzrS() == null ? "" : zzrS()) + "\t" + (zzrW() == null ? "" : zzrW()) + "\t" + zzrX();
    }

    public String zzrR() {
        return this.f3083d;
    }

    public String zzrS() {
        return this.f3089j;
    }

    public int zzrT() {
        return this.f3084e;
    }

    public List<String> zzrU() {
        return this.f3085f;
    }

    public int zzrV() {
        return this.f3088i;
    }

    public String zzrW() {
        return this.f3090k;
    }

    public float zzrX() {
        return this.f3091l;
    }

    public long zzrY() {
        return this.f3092m;
    }
}
