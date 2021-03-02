package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

public class Command implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<Command> CREATOR = new C0513a();

    /* renamed from: a */
    private String f3695a;

    /* renamed from: b */
    private String f3696b;

    /* renamed from: c */
    private String f3697c;

    @Deprecated
    public Command() {
    }

    @Deprecated
    Command(Parcel parcel) {
        m2970a(parcel);
    }

    @Deprecated
    /* renamed from: a */
    private void m2970a(Parcel parcel) {
        this.f3695a = parcel.readString();
        this.f3696b = parcel.readString();
        this.f3697c = parcel.readString();
    }

    /* renamed from: a */
    public String mo6587a() {
        return this.f3695a;
    }

    /* renamed from: b */
    public String mo6588b() {
        return this.f3697c;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3695a);
        parcel.writeString(this.f3696b);
        parcel.writeString(this.f3697c);
    }
}
