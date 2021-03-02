package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.ah */
public class C0654ah implements SafeParcelable {
    public static final Parcelable.Creator<C0654ah> CREATOR = new C0657ai();

    /* renamed from: BR */
    private final int f1520BR;

    /* renamed from: SF */
    private final DataType f1521SF;

    /* renamed from: Sh */
    private final DataSource f1522Sh;

    /* renamed from: com.google.android.gms.fitness.request.ah$a */
    public static class C0656a {
        /* access modifiers changed from: private */

        /* renamed from: SF */
        public DataType f1523SF;
        /* access modifiers changed from: private */

        /* renamed from: Sh */
        public DataSource f1524Sh;

        /* renamed from: d */
        public C0656a mo6064d(DataSource dataSource) {
            this.f1524Sh = dataSource;
            return this;
        }

        /* renamed from: d */
        public C0656a mo6065d(DataType dataType) {
            this.f1523SF = dataType;
            return this;
        }

        /* renamed from: jE */
        public C0654ah mo6066jE() {
            if (this.f1523SF == null || this.f1524Sh == null) {
                return new C0654ah(this);
            }
            throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
        }
    }

    C0654ah(int i, DataType dataType, DataSource dataSource) {
        this.f1520BR = i;
        this.f1521SF = dataType;
        this.f1522Sh = dataSource;
    }

    private C0654ah(C0656a aVar) {
        this.f1520BR = 1;
        this.f1521SF = aVar.f1523SF;
        this.f1522Sh = aVar.f1524Sh;
    }

    /* renamed from: a */
    private boolean m1997a(C0654ah ahVar) {
        return C0345m.equal(this.f1522Sh, ahVar.f1522Sh) && C0345m.equal(this.f1521SF, ahVar.f1521SF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof C0654ah) && m1997a((C0654ah) o));
    }

    public DataSource getDataSource() {
        return this.f1522Sh;
    }

    public DataType getDataType() {
        return this.f1521SF;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1520BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1522Sh, this.f1521SF);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0657ai.m2003a(this, parcel, flags);
    }
}
