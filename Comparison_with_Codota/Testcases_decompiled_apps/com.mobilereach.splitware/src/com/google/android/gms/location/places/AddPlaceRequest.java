package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaPc;
    private final List<Integer> zzaPd;
    private final String zzaPe;
    private final Uri zzaPf;
    private final String zzawc;

    AddPlaceRequest(int versionCode, String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri websiteUri) {
        boolean z = false;
        this.mVersionCode = versionCode;
        this.mName = zzx.zzcM(name);
        this.zzaPc = (LatLng) zzx.zzz(latLng);
        this.zzawc = zzx.zzcM(address);
        this.zzaPd = new ArrayList((Collection) zzx.zzz(placeTypes));
        zzx.zzb(!this.zzaPd.isEmpty(), (Object) "At least one place type should be provided.");
        zzx.zzb((!TextUtils.isEmpty(phoneNumber) || websiteUri != null) ? true : z, (Object) "One of phone number or URI should be provided.");
        this.zzaPe = phoneNumber;
        this.zzaPf = websiteUri;
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, Uri uri) {
        this(name, latLng, address, placeTypes, (String) null, (Uri) zzx.zzz(uri));
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber) {
        this(name, latLng, address, placeTypes, zzx.zzcM(phoneNumber), (Uri) null);
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri uri) {
        this(0, name, latLng, address, placeTypes, phoneNumber, uri);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzawc;
    }

    public LatLng getLatLng() {
        return this.zzaPc;
    }

    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.zzaPe;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaPd;
    }

    @Nullable
    public Uri getWebsiteUri() {
        return this.zzaPf;
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("latLng", this.zzaPc).zzg("address", this.zzawc).zzg("placeTypes", this.zzaPd).zzg("phoneNumer", this.zzaPe).zzg("websiteUri", this.zzaPf).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
