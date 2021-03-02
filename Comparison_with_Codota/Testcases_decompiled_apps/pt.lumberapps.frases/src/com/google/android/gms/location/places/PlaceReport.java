package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();

    /* renamed from: a */
    final int f7057a;

    /* renamed from: b */
    private final String f7058b;

    /* renamed from: c */
    private final String f7059c;

    /* renamed from: d */
    private final String f7060d;

    PlaceReport(int i, String str, String str2, String str3) {
        this.f7057a = i;
        this.f7058b = str;
        this.f7059c = str2;
        this.f7060d = str3;
    }

    /* renamed from: a */
    private static boolean m7608a(String str) {
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
                if (str.equals("unknown")) {
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

    public static PlaceReport create(String str, String str2) {
        return zzk(str, str2, "unknown");
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzab.zzy(str);
        zzab.zzhr(str2);
        zzab.zzhr(str3);
        zzab.zzb(m7608a(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzaa.equal(this.f7058b, placeReport.f7058b) && zzaa.equal(this.f7059c, placeReport.f7059c) && zzaa.equal(this.f7060d, placeReport.f7060d);
    }

    public String getPlaceId() {
        return this.f7058b;
    }

    public String getSource() {
        return this.f7060d;
    }

    public String getTag() {
        return this.f7059c;
    }

    public int hashCode() {
        return zzaa.hashCode(this.f7058b, this.f7059c, this.f7060d);
    }

    public String toString() {
        zzaa.zza zzx = zzaa.zzx(this);
        zzx.zzg("placeId", this.f7058b);
        zzx.zzg("tag", this.f7059c);
        if (!"unknown".equals(this.f7060d)) {
            zzx.zzg("source", this.f7060d);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m7609a(this, parcel, i);
    }
}
