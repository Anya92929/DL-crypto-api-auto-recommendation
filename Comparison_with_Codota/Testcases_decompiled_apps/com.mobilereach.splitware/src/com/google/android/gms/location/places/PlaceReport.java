package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaPH;
    private final String zzaPI;

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.mVersionCode = versionCode;
        this.zzaPH = placeId;
        this.mTag = tag;
        this.zzaPI = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzk(placeId, tag, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    private static boolean zzel(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    c = 1;
                    break;
                }
                break;
            case -284840886:
                if (str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                    c = 0;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    c = 5;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzx.zzz(str);
        zzx.zzcM(str2);
        zzx.zzcM(str3);
        zzx.zzb(zzel(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzw.equal(this.zzaPH, placeReport.zzaPH) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaPI, placeReport.zzaPI);
    }

    public String getPlaceId() {
        return this.zzaPH;
    }

    public String getSource() {
        return this.zzaPI;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPH, this.mTag, this.zzaPI);
    }

    public String toString() {
        zzw.zza zzy = zzw.zzy(this);
        zzy.zzg("placeId", this.zzaPH);
        zzy.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzaPI)) {
            zzy.zzg("source", this.zzaPI);
        }
        return zzy.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
