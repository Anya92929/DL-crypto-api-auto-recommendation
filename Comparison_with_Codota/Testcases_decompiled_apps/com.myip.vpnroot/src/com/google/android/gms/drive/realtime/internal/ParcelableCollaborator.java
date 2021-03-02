package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new C0579p();

    /* renamed from: BR */
    final int f1168BR;

    /* renamed from: Nz */
    final String f1169Nz;

    /* renamed from: Rc */
    final boolean f1170Rc;

    /* renamed from: Rd */
    final boolean f1171Rd;

    /* renamed from: Re */
    final String f1172Re;

    /* renamed from: Rf */
    final String f1173Rf;

    /* renamed from: Rg */
    final String f1174Rg;

    /* renamed from: vL */
    final String f1175vL;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.f1168BR = versionCode;
        this.f1170Rc = isMe;
        this.f1171Rd = isAnonymous;
        this.f1175vL = sessionId;
        this.f1172Re = userId;
        this.f1169Nz = displayName;
        this.f1173Rf = color;
        this.f1174Rg = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.f1175vL.equals(((ParcelableCollaborator) obj).f1175vL);
    }

    public int hashCode() {
        return this.f1175vL.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.f1170Rc + ", isAnonymous=" + this.f1171Rd + ", sessionId=" + this.f1175vL + ", userId=" + this.f1172Re + ", displayName=" + this.f1169Nz + ", color=" + this.f1173Rf + ", photoUrl=" + this.f1174Rg + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0579p.m1697a(this, dest, flags);
    }
}
