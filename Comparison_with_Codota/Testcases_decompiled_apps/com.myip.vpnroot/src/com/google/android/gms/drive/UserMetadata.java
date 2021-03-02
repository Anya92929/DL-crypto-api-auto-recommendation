package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new C0376h();

    /* renamed from: BR */
    final int f848BR;

    /* renamed from: NA */
    final String f849NA;

    /* renamed from: NB */
    final boolean f850NB;

    /* renamed from: NC */
    final String f851NC;

    /* renamed from: Ny */
    final String f852Ny;

    /* renamed from: Nz */
    final String f853Nz;

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.f848BR = versionCode;
        this.f852Ny = permissionId;
        this.f853Nz = displayName;
        this.f849NA = pictureUrl;
        this.f850NB = isAuthenticatedUser;
        this.f851NC = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.f852Ny, this.f853Nz, this.f849NA, Boolean.valueOf(this.f850NB), this.f851NC});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0376h.m1008a(this, dest, flags);
    }
}
