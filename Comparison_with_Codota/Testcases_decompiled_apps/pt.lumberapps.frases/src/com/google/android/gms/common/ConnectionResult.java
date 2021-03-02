package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p021v7.p023b.C0515k;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator CREATOR = new zzb();
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;

    /* renamed from: rb */
    public static final ConnectionResult f4269rb = new ConnectionResult(0);

    /* renamed from: a */
    final int f4270a;

    /* renamed from: b */
    private final int f4271b;

    /* renamed from: c */
    private final PendingIntent f4272c;

    /* renamed from: d */
    private final String f4273d;

    public ConnectionResult(int i) {
        this(i, (PendingIntent) null, (String) null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f4270a = i;
        this.f4271b = i2;
        this.f4272c = pendingIntent;
        this.f4273d = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (String) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* renamed from: a */
    static String m5943a(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
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
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                return "UPDATE_ANDROID_WEAR";
            case C0515k.AppCompatTheme_buttonBarNegativeButtonStyle:
                return "UNFINISHED";
            case DRIVE_EXTERNAL_STORAGE_REQUIRED /*1500*/:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return new StringBuilder(31).append("UNKNOWN_ERROR_CODE(").append(i).append(")").toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f4271b == connectionResult.f4271b && zzaa.equal(this.f4272c, connectionResult.f4272c) && zzaa.equal(this.f4273d, connectionResult.f4273d);
    }

    public int getErrorCode() {
        return this.f4271b;
    }

    public String getErrorMessage() {
        return this.f4273d;
    }

    public PendingIntent getResolution() {
        return this.f4272c;
    }

    public boolean hasResolution() {
        return (this.f4271b == 0 || this.f4272c == null) ? false : true;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.f4271b), this.f4272c, this.f4273d);
    }

    public boolean isSuccess() {
        return this.f4271b == 0;
    }

    public void startResolutionForResult(Activity activity, int i) {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f4272c.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzaa.zzx(this).zzg("statusCode", m5943a(this.f4271b)).zzg("resolution", this.f4272c).zzg("message", this.f4273d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m6211a(this, parcel, i);
    }
}
