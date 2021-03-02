package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    /* renamed from: a */
    final int f2466a;

    /* renamed from: b */
    final List<AccountChangeEvent> f2467b;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.f2466a = i;
        this.f2467b = (List) zzx.zzz(list);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> list) {
        this.f2466a = 1;
        this.f2467b = (List) zzx.zzz(list);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.f2467b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m3651a(this, parcel, i);
    }
}
