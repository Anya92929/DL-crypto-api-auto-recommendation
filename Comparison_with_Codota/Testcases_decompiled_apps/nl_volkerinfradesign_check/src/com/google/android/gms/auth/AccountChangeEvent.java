package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: a */
    final int f2456a;

    /* renamed from: b */
    final long f2457b;

    /* renamed from: c */
    final String f2458c;

    /* renamed from: d */
    final int f2459d;

    /* renamed from: e */
    final int f2460e;

    /* renamed from: f */
    final String f2461f;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.f2456a = i;
        this.f2457b = j;
        this.f2458c = (String) zzx.zzz(str);
        this.f2459d = i2;
        this.f2460e = i3;
        this.f2461f = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.f2456a = 1;
        this.f2457b = j;
        this.f2458c = (String) zzx.zzz(str);
        this.f2459d = i;
        this.f2460e = i2;
        this.f2461f = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f2456a == accountChangeEvent.f2456a && this.f2457b == accountChangeEvent.f2457b && zzw.equal(this.f2458c, accountChangeEvent.f2458c) && this.f2459d == accountChangeEvent.f2459d && this.f2460e == accountChangeEvent.f2460e && zzw.equal(this.f2461f, accountChangeEvent.f2461f);
    }

    public String getAccountName() {
        return this.f2458c;
    }

    public String getChangeData() {
        return this.f2461f;
    }

    public int getChangeType() {
        return this.f2459d;
    }

    public int getEventIndex() {
        return this.f2460e;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.f2456a), Long.valueOf(this.f2457b), this.f2458c, Integer.valueOf(this.f2459d), Integer.valueOf(this.f2460e), this.f2461f);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.f2459d) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.f2458c + ", changeType = " + str + ", changeData = " + this.f2461f + ", eventIndex = " + this.f2460e + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m3649a(this, parcel, i);
    }
}
