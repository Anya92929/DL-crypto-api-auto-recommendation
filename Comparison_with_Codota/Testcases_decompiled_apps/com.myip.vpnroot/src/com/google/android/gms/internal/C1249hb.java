package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.hb */
public class C1249hb implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<C1249hb> CREATOR = new Parcelable.Creator<C1249hb>() {
        @Deprecated
        /* renamed from: H */
        public C1249hb[] newArray(int i) {
            return new C1249hb[i];
        }

        @Deprecated
        /* renamed from: k */
        public C1249hb createFromParcel(Parcel parcel) {
            return new C1249hb(parcel);
        }
    };

    /* renamed from: BL */
    private String f3828BL;

    /* renamed from: BM */
    private String f3829BM;
    private String mValue;

    @Deprecated
    public C1249hb() {
    }

    @Deprecated
    C1249hb(Parcel parcel) {
        readFromParcel(parcel);
    }

    public C1249hb(String str, String str2, String str3) {
        this.f3828BL = str;
        this.f3829BM = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.f3828BL = in.readString();
        this.f3829BM = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f3828BL;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.f3828BL);
        out.writeString(this.f3829BM);
        out.writeString(this.mValue);
    }
}
