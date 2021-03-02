package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* renamed from: com.google.android.gms.internal.he */
public class C1256he implements SafeParcelable {
    public static final C1258hf CREATOR = new C1258hf();

    /* renamed from: BR */
    final int f3835BR;

    /* renamed from: BS */
    final C1261hi[] f3836BS;

    /* renamed from: BT */
    public final String f3837BT;

    /* renamed from: BU */
    public final boolean f3838BU;
    public final Account account;

    /* renamed from: com.google.android.gms.internal.he$a */
    public static class C1257a {

        /* renamed from: BV */
        private List<C1261hi> f3839BV;

        /* renamed from: BW */
        private String f3840BW;

        /* renamed from: BX */
        private boolean f3841BX;

        /* renamed from: BY */
        private Account f3842BY;

        /* renamed from: D */
        public C1257a mo8714D(boolean z) {
            this.f3841BX = z;
            return this;
        }

        /* renamed from: a */
        public C1257a mo8715a(C1261hi hiVar) {
            if (this.f3839BV == null) {
                this.f3839BV = new ArrayList();
            }
            this.f3839BV.add(hiVar);
            return this;
        }

        /* renamed from: ar */
        public C1257a mo8716ar(String str) {
            this.f3840BW = str;
            return this;
        }

        /* renamed from: fk */
        public C1256he mo8717fk() {
            return new C1256he(this.f3840BW, this.f3841BX, this.f3842BY, this.f3839BV != null ? (C1261hi[]) this.f3839BV.toArray(new C1261hi[this.f3839BV.size()]) : null);
        }
    }

    C1256he(int i, C1261hi[] hiVarArr, String str, boolean z, Account account2) {
        this.f3835BR = i;
        this.f3836BS = hiVarArr;
        this.f3837BT = str;
        this.f3838BU = z;
        this.account = account2;
    }

    C1256he(String str, boolean z, Account account2, C1261hi... hiVarArr) {
        this(1, hiVarArr, str, z, account2);
        BitSet bitSet = new BitSet(C1270hp.m4784fm());
        for (C1261hi hiVar : hiVarArr) {
            int i = hiVar.f3852Cg;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + C1270hp.m4782O(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        C1258hf hfVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1258hf hfVar = CREATOR;
        C1258hf.m4763a(this, dest, flags);
    }
}
