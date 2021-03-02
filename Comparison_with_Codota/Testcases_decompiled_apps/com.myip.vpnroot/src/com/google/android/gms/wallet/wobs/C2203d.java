package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1382jr;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.d */
public final class C2203d implements SafeParcelable {
    public static final Parcelable.Creator<C2203d> CREATOR = new C2204e();

    /* renamed from: BR */
    private final int f4641BR;
    String auo;
    String aup;
    ArrayList<C2201b> auq;

    C2203d() {
        this.f4641BR = 1;
        this.auq = C1382jr.m5209hz();
    }

    C2203d(int i, String str, String str2, ArrayList<C2201b> arrayList) {
        this.f4641BR = i;
        this.auo = str;
        this.aup = str2;
        this.auq = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4641BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2204e.m7429a(this, dest, flags);
    }
}
