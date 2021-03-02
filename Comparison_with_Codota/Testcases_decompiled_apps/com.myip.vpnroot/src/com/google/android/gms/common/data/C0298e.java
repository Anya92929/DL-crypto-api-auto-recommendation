package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.e */
public class C0298e<T extends SafeParcelable> extends DataBuffer<T> {

    /* renamed from: JS */
    private static final String[] f696JS = {"data"};

    /* renamed from: JT */
    private final Parcelable.Creator<T> f697JT;

    public C0298e(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f697JT = creator;
    }

    /* renamed from: aq */
    public T get(int i) {
        byte[] f = this.f667IC.mo4312f("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.f697JT.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
