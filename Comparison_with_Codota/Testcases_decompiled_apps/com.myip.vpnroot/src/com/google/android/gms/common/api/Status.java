package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR = new StatusCreator();

    /* renamed from: Jo */
    public static final Status f591Jo = new Status(0);

    /* renamed from: Jp */
    public static final Status f592Jp = new Status(14);

    /* renamed from: Jq */
    public static final Status f593Jq = new Status(8);

    /* renamed from: Jr */
    public static final Status f594Jr = new Status(15);

    /* renamed from: Js */
    public static final Status f595Js = new Status(16);

    /* renamed from: BR */
    private final int f596BR;

    /* renamed from: HF */
    private final int f597HF;

    /* renamed from: Jt */
    private final String f598Jt;
    private final PendingIntent mPendingIntent;

    public Status(int statusCode) {
        this(1, statusCode, (String) null, (PendingIntent) null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.f596BR = versionCode;
        this.f597HF = statusCode;
        this.f598Jt = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    /* renamed from: fY */
    private String m528fY() {
        return this.f598Jt != null ? this.f598Jt : CommonStatusCodes.getStatusCodeString(this.f597HF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f596BR == status.f596BR && this.f597HF == status.f597HF && C0345m.equal(this.f598Jt, status.f598Jt) && C0345m.equal(this.mPendingIntent, status.mPendingIntent);
    }

    /* access modifiers changed from: package-private */
    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f597HF;
    }

    public String getStatusMessage() {
        return this.f598Jt;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f596BR;
    }

    @Deprecated
    /* renamed from: gu */
    public ConnectionResult mo4261gu() {
        return new ConnectionResult(this.f597HF, this.mPendingIntent);
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f596BR), Integer.valueOf(this.f597HF), this.f598Jt, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.f597HF == 16;
    }

    public boolean isInterrupted() {
        return this.f597HF == 14;
    }

    public boolean isSuccess() {
        return this.f597HF <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("statusCode", m528fY()).mo4549a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StatusCreator.m530a(this, out, flags);
    }
}
