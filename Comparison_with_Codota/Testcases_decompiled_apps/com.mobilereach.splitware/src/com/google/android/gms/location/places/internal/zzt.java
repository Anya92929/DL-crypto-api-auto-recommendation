package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzt extends zzc {
    private final String TAG = "SafeDataBufferRef";

    public zzt(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* access modifiers changed from: protected */
    public String zzG(String str, String str2) {
        return (!zzcz(str) || zzcB(str)) ? str2 : getString(str);
    }

    /* access modifiers changed from: protected */
    public <E extends SafeParcelable> E zza(String str, Parcelable.Creator<E> creator) {
        byte[] zzc = zzc(str, (byte[]) null);
        if (zzc == null) {
            return null;
        }
        return com.google.android.gms.common.internal.safeparcel.zzc.zza(zzc, creator);
    }

    /* access modifiers changed from: protected */
    public <E extends SafeParcelable> List<E> zza(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] zzc = zzc(str, (byte[]) null);
        if (zzc == null) {
            return list;
        }
        try {
            zzsk zzB = zzsk.zzB(zzc);
            if (zzB.zzbtV == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzB.zzbtV.length);
            for (byte[] zza : zzB.zzbtV) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(zza, creator));
            }
            return arrayList;
        } catch (zzst e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* access modifiers changed from: protected */
    public List<Integer> zza(String str, List<Integer> list) {
        byte[] zzc = zzc(str, (byte[]) null);
        if (zzc == null) {
            return list;
        }
        try {
            zzsk zzB = zzsk.zzB(zzc);
            if (zzB.zzbtU == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzB.zzbtU.length);
            for (int valueOf : zzB.zzbtU) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList;
        } catch (zzst e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* access modifiers changed from: protected */
    public float zzb(String str, float f) {
        return (!zzcz(str) || zzcB(str)) ? f : getFloat(str);
    }

    /* access modifiers changed from: protected */
    public List<String> zzb(String str, List<String> list) {
        byte[] zzc = zzc(str, (byte[]) null);
        if (zzc == null) {
            return list;
        }
        try {
            zzsk zzB = zzsk.zzB(zzc);
            return zzB.zzbtT != null ? Arrays.asList(zzB.zzbtT) : list;
        } catch (zzst e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] zzc(String str, byte[] bArr) {
        return (!zzcz(str) || zzcB(str)) ? bArr : getByteArray(str);
    }

    /* access modifiers changed from: protected */
    public boolean zzl(String str, boolean z) {
        return (!zzcz(str) || zzcB(str)) ? z : getBoolean(str);
    }

    /* access modifiers changed from: protected */
    public int zzz(String str, int i) {
        return (!zzcz(str) || zzcB(str)) ? i : getInteger(str);
    }
}
