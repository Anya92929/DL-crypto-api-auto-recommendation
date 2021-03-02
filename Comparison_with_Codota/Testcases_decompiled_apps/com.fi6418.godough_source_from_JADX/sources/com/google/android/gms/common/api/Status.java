package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements SafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new C0728az();

    /* renamed from: a */
    public static final Status f4412a = new Status(0);

    /* renamed from: b */
    public static final Status f4413b = new Status(14);

    /* renamed from: c */
    public static final Status f4414c = new Status(8);

    /* renamed from: d */
    public static final Status f4415d = new Status(15);

    /* renamed from: e */
    public static final Status f4416e = new Status(16);

    /* renamed from: f */
    private final int f4417f;

    /* renamed from: g */
    private final int f4418g;

    /* renamed from: h */
    private final String f4419h;

    /* renamed from: i */
    private final PendingIntent f4420i;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f4417f = i;
        this.f4418g = i2;
        this.f4419h = str;
        this.f4420i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null);
    }

    /* renamed from: e */
    private String m3958e() {
        return this.f4419h != null ? this.f4419h : C0748m.m4091a(this.f4418g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PendingIntent mo7341a() {
        return this.f4420i;
    }

    /* renamed from: b */
    public String mo7342b() {
        return this.f4419h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo7343c() {
        return this.f4417f;
    }

    /* renamed from: d */
    public int mo7344d() {
        return this.f4418g;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4417f == status.f4417f && this.f4418g == status.f4418g && C1006bc.m4525a(this.f4419h, status.f4419h) && C1006bc.m4525a(this.f4420i, status.f4420i);
    }

    public int hashCode() {
        return C1006bc.m4523a(Integer.valueOf(this.f4417f), Integer.valueOf(this.f4418g), this.f4419h, this.f4420i);
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("statusCode", m3958e()).mo7604a("resolution", this.f4420i).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0728az.m4040a(this, parcel, i);
    }
}
