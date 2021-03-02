package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent implements SafeParcelable {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new C1100i();

    /* renamed from: a */
    final int f4824a;

    /* renamed from: b */
    private final long f4825b;

    /* renamed from: c */
    private int f4826c;

    /* renamed from: d */
    private final String f4827d;

    /* renamed from: e */
    private final int f4828e;

    /* renamed from: f */
    private final List<String> f4829f;

    /* renamed from: g */
    private final String f4830g;

    /* renamed from: h */
    private final long f4831h;

    /* renamed from: i */
    private int f4832i;

    /* renamed from: j */
    private final String f4833j;

    /* renamed from: k */
    private final String f4834k;

    /* renamed from: l */
    private final float f4835l;

    /* renamed from: m */
    private long f4836m;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f) {
        this.f4824a = i;
        this.f4825b = j;
        this.f4826c = i2;
        this.f4827d = str;
        this.f4833j = str3;
        this.f4828e = i3;
        this.f4836m = -1;
        this.f4829f = list;
        this.f4830g = str2;
        this.f4831h = j2;
        this.f4832i = i4;
        this.f4834k = str4;
        this.f4835l = f;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f);
    }

    /* renamed from: a */
    public long mo7684a() {
        return this.f4825b;
    }

    /* renamed from: b */
    public int mo7685b() {
        return this.f4826c;
    }

    /* renamed from: c */
    public String mo7686c() {
        return this.f4827d;
    }

    /* renamed from: d */
    public String mo7687d() {
        return this.f4833j;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int mo7689e() {
        return this.f4828e;
    }

    /* renamed from: f */
    public List<String> mo7690f() {
        return this.f4829f;
    }

    /* renamed from: g */
    public String mo7691g() {
        return this.f4830g;
    }

    /* renamed from: h */
    public long mo7692h() {
        return this.f4831h;
    }

    /* renamed from: i */
    public int mo7693i() {
        return this.f4832i;
    }

    /* renamed from: j */
    public String mo7694j() {
        return this.f4834k;
    }

    /* renamed from: k */
    public float mo7695k() {
        return this.f4835l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1100i.m4777a(this, parcel, i);
    }
}
