package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new C0409aw();

    /* renamed from: BR */
    final int f961BR;

    /* renamed from: No */
    final String f962No;

    /* renamed from: Np */
    final String[] f963Np;

    /* renamed from: Nq */
    final DriveId f964Nq;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder) {
        this.f961BR = versionCode;
        this.f962No = title;
        this.f963Np = mimeTypes;
        this.f964Nq = startFolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder) {
        this(1, title, mimeTypes, startFolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0409aw.m1182a(this, dest, flags);
    }
}
