package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C0139c<T extends SafeParcelable> extends DataBuffer<T> {

    /* renamed from: jk */
    private static final String[] f372jk = {"data"};

    /* renamed from: jl */
    private final Parcelable.Creator<T> f373jl;

    public C0139c(C0140d dVar, Parcelable.Creator<T> creator) {
        super(dVar);
        this.f373jl = creator;
    }

    /* renamed from: p */
    public T get(int i) {
        byte[] e = this.f366jf.mo3606e("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(e, 0, e.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.f373jl.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
