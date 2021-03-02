package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* renamed from: com.google.android.gms.internal.hq */
public class C1271hq implements SafeParcelable {
    public static final C1273hr CREATOR = new C1273hr();

    /* renamed from: BR */
    final int f3864BR;

    /* renamed from: Co */
    public final String f3865Co;

    /* renamed from: Cp */
    public final boolean f3866Cp;

    /* renamed from: Cq */
    public final boolean f3867Cq;

    /* renamed from: Cr */
    public final String f3868Cr;

    /* renamed from: Cs */
    public final C1263hk[] f3869Cs;

    /* renamed from: Ct */
    final int[] f3870Ct;

    /* renamed from: Cu */
    public final String f3871Cu;
    public final String name;
    public final int weight;

    /* renamed from: com.google.android.gms.internal.hq$a */
    public static final class C1272a {

        /* renamed from: CA */
        private final List<C1263hk> f3872CA = new ArrayList();

        /* renamed from: CB */
        private BitSet f3873CB;

        /* renamed from: CC */
        private String f3874CC;

        /* renamed from: Cv */
        private String f3875Cv;

        /* renamed from: Cw */
        private boolean f3876Cw;

        /* renamed from: Cx */
        private int f3877Cx = 1;

        /* renamed from: Cy */
        private boolean f3878Cy;

        /* renamed from: Cz */
        private String f3879Cz;
        private final String mName;

        public C1272a(String str) {
            this.mName = str;
        }

        /* renamed from: E */
        public C1272a mo8757E(boolean z) {
            this.f3876Cw = z;
            return this;
        }

        /* renamed from: F */
        public C1272a mo8758F(boolean z) {
            this.f3878Cy = z;
            return this;
        }

        /* renamed from: P */
        public C1272a mo8759P(int i) {
            if (this.f3873CB == null) {
                this.f3873CB = new BitSet();
            }
            this.f3873CB.set(i);
            return this;
        }

        /* renamed from: at */
        public C1272a mo8760at(String str) {
            this.f3875Cv = str;
            return this;
        }

        /* renamed from: au */
        public C1272a mo8761au(String str) {
            this.f3874CC = str;
            return this;
        }

        /* renamed from: fn */
        public C1271hq mo8762fn() {
            int i = 0;
            int[] iArr = null;
            if (this.f3873CB != null) {
                iArr = new int[this.f3873CB.cardinality()];
                int nextSetBit = this.f3873CB.nextSetBit(0);
                while (nextSetBit >= 0) {
                    iArr[i] = nextSetBit;
                    nextSetBit = this.f3873CB.nextSetBit(nextSetBit + 1);
                    i++;
                }
            }
            return new C1271hq(this.mName, this.f3875Cv, this.f3876Cw, this.f3877Cx, this.f3878Cy, this.f3879Cz, (C1263hk[]) this.f3872CA.toArray(new C1263hk[this.f3872CA.size()]), iArr, this.f3874CC);
        }
    }

    C1271hq(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, C1263hk[] hkVarArr, int[] iArr, String str4) {
        this.f3864BR = i;
        this.name = str;
        this.f3865Co = str2;
        this.f3866Cp = z;
        this.weight = i2;
        this.f3867Cq = z2;
        this.f3868Cr = str3;
        this.f3869Cs = hkVarArr;
        this.f3870Ct = iArr;
        this.f3871Cu = str4;
    }

    C1271hq(String str, String str2, boolean z, int i, boolean z2, String str3, C1263hk[] hkVarArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, hkVarArr, iArr, str4);
    }

    public int describeContents() {
        C1273hr hrVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof C1271hq)) {
            return false;
        }
        C1271hq hqVar = (C1271hq) object;
        return this.name.equals(hqVar.name) && this.f3865Co.equals(hqVar.f3865Co) && this.f3866Cp == hqVar.f3866Cp;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1273hr hrVar = CREATOR;
        C1273hr.m4791a(this, out, flags);
    }
}
