package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.analytics.internal.a */
final class C0513a implements Parcelable.Creator<Command> {
    C0513a() {
    }

    @Deprecated
    /* renamed from: a */
    public Command createFromParcel(Parcel parcel) {
        return new Command(parcel);
    }

    @Deprecated
    /* renamed from: a */
    public Command[] newArray(int i) {
        return new Command[i];
    }
}
