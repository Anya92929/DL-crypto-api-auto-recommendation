package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzc();
    public static final Status zzagC = new Status(0);
    public static final Status zzagD = new Status(14);
    public static final Status zzagE = new Status(8);
    public static final Status zzagF = new Status(15);
    public static final Status zzagG = new Status(16);

    /* renamed from: a */
    private final int f2650a;

    /* renamed from: b */
    private final int f2651b;

    /* renamed from: c */
    private final String f2652c;

    /* renamed from: d */
    private final PendingIntent f2653d;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f2650a = i;
        this.f2651b = i2;
        this.f2652c = str;
        this.f2653d = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    /* renamed from: c */
    private String m3710c() {
        return this.f2652c != null ? this.f2652c : CommonStatusCodes.getStatusCodeString(this.f2651b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PendingIntent mo5113a() {
        return this.f2653d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5114b() {
        return this.f2650a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2650a == status.f2650a && this.f2651b == status.f2651b && zzw.equal(this.f2652c, status.f2652c) && zzw.equal(this.f2653d, status.f2653d);
    }

    public PendingIntent getResolution() {
        return this.f2653d;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f2651b;
    }

    public String getStatusMessage() {
        return this.f2652c;
    }

    public boolean hasResolution() {
        return this.f2653d != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.f2650a), Integer.valueOf(this.f2651b), this.f2652c, this.f2653d);
    }

    public boolean isCanceled() {
        return this.f2651b == 16;
    }

    public boolean isInterrupted() {
        return this.f2651b == 14;
    }

    public boolean isSuccess() {
        return this.f2651b <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f2653d.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzy(this).zzg("statusCode", m3710c()).zzg("resolution", this.f2653d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m3846a(this, parcel, i);
    }
}
