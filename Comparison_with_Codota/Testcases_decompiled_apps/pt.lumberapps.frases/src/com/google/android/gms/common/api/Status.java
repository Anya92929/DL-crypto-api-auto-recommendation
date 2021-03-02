package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();

    /* renamed from: sq */
    public static final Status f4328sq = new Status(0);

    /* renamed from: sr */
    public static final Status f4329sr = new Status(14);

    /* renamed from: ss */
    public static final Status f4330ss = new Status(8);

    /* renamed from: st */
    public static final Status f4331st = new Status(15);

    /* renamed from: su */
    public static final Status f4332su = new Status(16);

    /* renamed from: sv */
    public static final Status f4333sv = new Status(17);

    /* renamed from: sw */
    public static final Status f4334sw = new Status(18);

    /* renamed from: a */
    private final int f4335a;

    /* renamed from: b */
    private final int f4336b;

    /* renamed from: c */
    private final String f4337c;

    /* renamed from: d */
    private final PendingIntent f4338d;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f4335a = i;
        this.f4336b = i2;
        this.f4337c = str;
        this.f4338d = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    /* renamed from: c */
    private String m5974c() {
        return this.f4337c != null ? this.f4337c : CommonStatusCodes.getStatusCodeString(this.f4336b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PendingIntent mo6363a() {
        return this.f4338d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo6364b() {
        return this.f4335a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4335a == status.f4335a && this.f4336b == status.f4336b && zzaa.equal(this.f4337c, status.f4337c) && zzaa.equal(this.f4338d, status.f4338d);
    }

    public PendingIntent getResolution() {
        return this.f4338d;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f4336b;
    }

    public String getStatusMessage() {
        return this.f4337c;
    }

    public boolean hasResolution() {
        return this.f4338d != null;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.f4335a), Integer.valueOf(this.f4336b), this.f4337c, this.f4338d);
    }

    public boolean isCanceled() {
        return this.f4336b == 16;
    }

    public boolean isInterrupted() {
        return this.f4336b == 14;
    }

    public boolean isSuccess() {
        return this.f4336b <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f4338d.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzaa.zzx(this).zzg("statusCode", m5974c()).zzg("resolution", this.f4338d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m5980a(this, parcel, i);
    }
}
