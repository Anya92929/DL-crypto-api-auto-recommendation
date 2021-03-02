package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd extends AbstractDataBuffer {

    /* renamed from: b */
    private static final String[] f4394b = {"data"};

    /* renamed from: c */
    private final Parcelable.Creator f4395c;

    public zzd(DataHolder dataHolder, Parcelable.Creator creator) {
        super(dataHolder);
        this.f4395c = creator;
    }

    public static void zza(DataHolder.zza zza, SafeParcelable safeParcelable) {
        Parcel obtain = Parcel.obtain();
        safeParcelable.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        zza.zza(contentValues);
        obtain.recycle();
    }

    public static DataHolder.zza zzarg() {
        return DataHolder.zzb(f4394b);
    }

    /* renamed from: zzfr */
    public SafeParcelable get(int i) {
        byte[] zzg = this.f4364a.zzg("data", i, this.f4364a.zzfs(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.f4395c.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
