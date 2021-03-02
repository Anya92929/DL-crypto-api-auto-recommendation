package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.internal.hm */
public class C1265hm {

    /* renamed from: com.google.android.gms.internal.hm$a */
    public static class C1266a implements SafeParcelable {
        public static final C1268hn CREATOR = new C1268hn();

        /* renamed from: BR */
        final int f3857BR;

        /* renamed from: Cj */
        public final Account f3858Cj;

        public C1266a() {
            this((Account) null);
        }

        C1266a(int i, Account account) {
            this.f3857BR = i;
            this.f3858Cj = account;
        }

        public C1266a(Account account) {
            this(1, account);
        }

        public int describeContents() {
            C1268hn hnVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1268hn hnVar = CREATOR;
            C1268hn.m4776a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.hm$b */
    public static class C1267b implements Result, SafeParcelable {
        public static final C1269ho CREATOR = new C1269ho();

        /* renamed from: BR */
        final int f3859BR;

        /* renamed from: Ck */
        public Status f3860Ck;

        /* renamed from: Cl */
        public List<C1274hs> f3861Cl;

        public C1267b() {
            this.f3859BR = 1;
        }

        C1267b(int i, Status status, List<C1274hs> list) {
            this.f3859BR = i;
            this.f3860Ck = status;
            this.f3861Cl = list;
        }

        public int describeContents() {
            C1269ho hoVar = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.f3860Ck;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1269ho hoVar = CREATOR;
            C1269ho.m4779a(this, out, flags);
        }
    }
}
