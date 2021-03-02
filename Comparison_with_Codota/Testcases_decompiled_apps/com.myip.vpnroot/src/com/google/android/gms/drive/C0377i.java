package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;

/* renamed from: com.google.android.gms.drive.i */
public abstract class C0377i implements Parcelable {

    /* renamed from: ND */
    private volatile transient boolean f876ND = false;

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public abstract void mo4765I(Parcel parcel, int i);

    /* renamed from: hT */
    public final boolean mo4766hT() {
        return this.f876ND;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0348n.m850I(!mo4766hT());
        this.f876ND = true;
        mo4765I(dest, flags);
    }
}
