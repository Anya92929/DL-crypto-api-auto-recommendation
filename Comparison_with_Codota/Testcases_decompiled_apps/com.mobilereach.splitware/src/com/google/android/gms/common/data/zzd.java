package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zzajg = {"data"};
    private final Parcelable.Creator<T> zzajh;

    public zzd(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zzajh = creator;
    }

    /* renamed from: zzbG */
    public T get(int i) {
        byte[] zzg = this.zzahi.zzg("data", i, this.zzahi.zzbH(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.zzajh.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
