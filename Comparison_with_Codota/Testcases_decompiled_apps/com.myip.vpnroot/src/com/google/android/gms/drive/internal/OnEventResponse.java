package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnEventResponse> CREATOR = new C0399am();

    /* renamed from: BR */
    final int f938BR;

    /* renamed from: NS */
    final int f939NS;

    /* renamed from: Pk */
    final ChangeEvent f940Pk;

    /* renamed from: Pl */
    final CompletionEvent f941Pl;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent) {
        this.f938BR = versionCode;
        this.f939NS = eventType;
        this.f940Pk = changeEvent;
        this.f941Pl = completionEvent;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: ih */
    public DriveEvent mo4814ih() {
        switch (this.f939NS) {
            case 1:
                return this.f940Pk;
            case 2:
                return this.f941Pl;
            default:
                throw new IllegalStateException("Unexpected event type " + this.f939NS);
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0399am.m1152a(this, dest, flags);
    }
}
