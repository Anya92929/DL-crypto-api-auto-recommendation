package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C0343c<T extends SafeParcelable> extends DataBuffer<T> {

    /* renamed from: X */
    private static final String[] f798X = {"data"};

    /* renamed from: Y */
    private final Parcelable.Creator<T> f799Y;

    public C0343c(C0344d dVar, Parcelable.Creator<T> creator) {
        super(dVar);
        this.f799Y = creator;
    }

    /* renamed from: d */
    public T get(int i) {
        byte[] e = this.f792S.mo4055e("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(e, 0, e.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.f799Y.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
