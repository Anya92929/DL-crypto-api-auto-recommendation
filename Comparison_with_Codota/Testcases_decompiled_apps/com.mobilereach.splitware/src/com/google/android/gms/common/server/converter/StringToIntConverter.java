package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzamG;
    private final HashMap<Integer, String> zzamH;
    private final ArrayList<Entry> zzamI;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzamJ;
        final int zzamK;

        Entry(int versionCode2, String stringValue, int intValue) {
            this.versionCode = versionCode2;
            this.zzamJ = stringValue;
            this.zzamK = intValue;
        }

        Entry(String stringValue, int intValue) {
            this.versionCode = 1;
            this.zzamJ = stringValue;
            this.zzamK = intValue;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc zzc = CREATOR;
            zzc.zza(this, out, flags);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzamG = new HashMap<>();
        this.zzamH = new HashMap<>();
        this.zzamI = null;
    }

    StringToIntConverter(int versionCode, ArrayList<Entry> serializedMap) {
        this.mVersionCode = versionCode;
        this.zzamG = new HashMap<>();
        this.zzamH = new HashMap<>();
        this.zzamI = null;
        zzd(serializedMap);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            zzh(next.zzamJ, next.zzamK);
        }
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    /* renamed from: zzb */
    public String convertBack(Integer num) {
        String str = this.zzamH.get(num);
        return (str != null || !this.zzamG.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzh(String str, int i) {
        this.zzamG.put(str, Integer.valueOf(i));
        this.zzamH.put(Integer.valueOf(i), str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Entry> zzri() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.zzamG.keySet()) {
            arrayList.add(new Entry(next, this.zzamG.get(next).intValue()));
        }
        return arrayList;
    }

    public int zzrj() {
        return 7;
    }

    public int zzrk() {
        return 0;
    }
}
