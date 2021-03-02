package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.l */
public class C0670l implements SafeParcelable {
    public static final Parcelable.Creator<C0670l> CREATOR = new C0673m();

    /* renamed from: BR */
    private final int f1530BR;

    /* renamed from: SF */
    private final DataType f1531SF;

    /* renamed from: com.google.android.gms.fitness.request.l$a */
    public static class C0672a {
        /* access modifiers changed from: private */

        /* renamed from: SF */
        public DataType f1532SF;

        /* renamed from: c */
        public C0672a mo6119c(DataType dataType) {
            this.f1532SF = dataType;
            return this;
        }

        /* renamed from: jk */
        public C0670l mo6120jk() {
            return new C0670l(this);
        }
    }

    C0670l(int i, DataType dataType) {
        this.f1530BR = i;
        this.f1531SF = dataType;
    }

    private C0670l(C0672a aVar) {
        this.f1530BR = 1;
        this.f1531SF = aVar.f1532SF;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.f1531SF;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1530BR;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0673m.m2033a(this, parcel, flags);
    }
}
