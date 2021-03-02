package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator CREATOR = new zzg();

    /* renamed from: a */
    final int f4676a;

    /* renamed from: b */
    private final long f4677b;

    /* renamed from: c */
    private int f4678c;

    /* renamed from: d */
    private final String f4679d;

    /* renamed from: e */
    private final String f4680e;

    /* renamed from: f */
    private final String f4681f;

    /* renamed from: g */
    private final int f4682g;

    /* renamed from: h */
    private final List f4683h;

    /* renamed from: i */
    private final String f4684i;

    /* renamed from: j */
    private final long f4685j;

    /* renamed from: k */
    private int f4686k;

    /* renamed from: l */
    private final String f4687l;

    /* renamed from: m */
    private final float f4688m;

    /* renamed from: n */
    private final long f4689n;

    /* renamed from: o */
    private long f4690o;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f4676a = i;
        this.f4677b = j;
        this.f4678c = i2;
        this.f4679d = str;
        this.f4680e = str3;
        this.f4681f = str5;
        this.f4682g = i3;
        this.f4690o = -1;
        this.f4683h = list;
        this.f4684i = str2;
        this.f4685j = j2;
        this.f4686k = i4;
        this.f4687l = str4;
        this.f4688m = f;
        this.f4689n = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public int getEventType() {
        return this.f4678c;
    }

    public long getTimeMillis() {
        return this.f4677b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m6196a(this, parcel, i);
    }

    public String zzaus() {
        return this.f4684i;
    }

    public long zzaut() {
        return this.f4690o;
    }

    public long zzauv() {
        return this.f4685j;
    }

    public String zzauw() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzauz());
        String valueOf3 = String.valueOf("\t");
        int zzavc = zzavc();
        String valueOf4 = String.valueOf("\t");
        String join = zzavd() == null ? "" : TextUtils.join(",", zzavd());
        String valueOf5 = String.valueOf("\t");
        int zzave = zzave();
        String valueOf6 = String.valueOf("\t");
        String zzava = zzava() == null ? "" : zzava();
        String valueOf7 = String.valueOf("\t");
        String zzavf = zzavf() == null ? "" : zzavf();
        String valueOf8 = String.valueOf("\t");
        float zzavg = zzavg();
        String valueOf9 = String.valueOf("\t");
        String zzavb = zzavb() == null ? "" : zzavb();
        return new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(join).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(zzava).length() + String.valueOf(valueOf7).length() + String.valueOf(zzavf).length() + String.valueOf(valueOf8).length() + String.valueOf(valueOf9).length() + String.valueOf(zzavb).length()).append(valueOf).append(valueOf2).append(valueOf3).append(zzavc).append(valueOf4).append(join).append(valueOf5).append(zzave).append(valueOf6).append(zzava).append(valueOf7).append(zzavf).append(valueOf8).append(zzavg).append(valueOf9).append(zzavb).toString();
    }

    public String zzauz() {
        return this.f4679d;
    }

    public String zzava() {
        return this.f4680e;
    }

    public String zzavb() {
        return this.f4681f;
    }

    public int zzavc() {
        return this.f4682g;
    }

    public List zzavd() {
        return this.f4683h;
    }

    public int zzave() {
        return this.f4686k;
    }

    public String zzavf() {
        return this.f4687l;
    }

    public float zzavg() {
        return this.f4688m;
    }

    public long zzavh() {
        return this.f4689n;
    }
}
