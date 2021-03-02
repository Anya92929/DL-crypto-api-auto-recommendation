package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionResult implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new C0961i();

    /* renamed from: a */
    public static final ConnectionResult f4398a = new ConnectionResult(0, (PendingIntent) null);

    /* renamed from: b */
    final int f4399b;

    /* renamed from: c */
    private final int f4400c;

    /* renamed from: d */
    private final PendingIntent f4401d;

    ConnectionResult(int i, int i2, PendingIntent pendingIntent) {
        this.f4399b = i;
        this.f4400c = i2;
        this.f4401d = pendingIntent;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent);
    }

    /* renamed from: a */
    static String m3940a(int i) {
        switch (i) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    /* renamed from: a */
    public void mo7321a(Activity activity, int i) {
        if (mo7322a()) {
            activity.startIntentSenderForResult(this.f4401d.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    /* renamed from: a */
    public boolean mo7322a() {
        return (this.f4400c == 0 || this.f4401d == null) ? false : true;
    }

    /* renamed from: b */
    public boolean mo7323b() {
        return this.f4400c == 0;
    }

    /* renamed from: c */
    public int mo7324c() {
        return this.f4400c;
    }

    /* renamed from: d */
    public PendingIntent mo7325d() {
        return this.f4401d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f4400c == connectionResult.f4400c && C1006bc.m4525a(this.f4401d, connectionResult.f4401d);
    }

    public int hashCode() {
        return C1006bc.m4523a(Integer.valueOf(this.f4400c), this.f4401d);
    }

    public String toString() {
        return C1006bc.m4524a((Object) this).mo7604a("statusCode", m3940a(this.f4400c)).mo7604a("resolution", this.f4401d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0961i.m4329a(this, parcel, i);
    }
}
