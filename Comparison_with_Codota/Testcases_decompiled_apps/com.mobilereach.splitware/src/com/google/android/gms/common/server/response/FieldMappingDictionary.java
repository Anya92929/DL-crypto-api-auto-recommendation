package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int mVersionCode;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzamV;
    private final ArrayList<Entry> zzamW;
    private final String zzamX;

    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zzamY;

        Entry(int versionCode2, String className2, ArrayList<FieldMapPair> fieldMapping) {
            this.versionCode = versionCode2;
            this.className = className2;
            this.zzamY = fieldMapping;
        }

        Entry(String className2, Map<String, FastJsonResponse.Field<?, ?>> fieldMap) {
            this.versionCode = 1;
            this.className = className2;
            this.zzamY = zzM(fieldMap);
        }

        private static ArrayList<FieldMapPair> zzM(Map<String, FastJsonResponse.Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new FieldMapPair(next, map.get(next)));
            }
            return arrayList;
        }

        public int describeContents() {
            zzd zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzd zzd = CREATOR;
            zzd.zza(this, out, flags);
        }

        /* access modifiers changed from: package-private */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrC() {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            int size = this.zzamY.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = this.zzamY.get(i);
                hashMap.put(fieldMapPair.key, fieldMapPair.zzamZ);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();
        final String key;
        final int versionCode;
        final FastJsonResponse.Field<?, ?> zzamZ;

        FieldMapPair(int versionCode2, String key2, FastJsonResponse.Field<?, ?> value) {
            this.versionCode = versionCode2;
            this.key = key2;
            this.zzamZ = value;
        }

        FieldMapPair(String key2, FastJsonResponse.Field<?, ?> value) {
            this.versionCode = 1;
            this.key = key2;
            this.zzamZ = value;
        }

        public int describeContents() {
            zzb zzb = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzb zzb = CREATOR;
            zzb.zza(this, out, flags);
        }
    }

    FieldMappingDictionary(int versionCode, ArrayList<Entry> serializedDictionary, String rootClassName) {
        this.mVersionCode = versionCode;
        this.zzamW = null;
        this.zzamV = zze(serializedDictionary);
        this.zzamX = (String) zzx.zzz(rootClassName);
        zzry();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> rootClazz) {
        this.mVersionCode = 1;
        this.zzamW = null;
        this.zzamV = new HashMap<>();
        this.zzamX = rootClazz.getCanonicalName();
    }

    private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zze(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = arrayList.get(i);
            hashMap.put(entry.className, entry.zzrC());
        }
        return hashMap;
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.zzamV.keySet()) {
            sb.append(next).append(":\n");
            Map map = this.zzamV.get(next);
            for (String str : map.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, out, flags);
    }

    public void zza(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zzamV.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class<? extends FastJsonResponse> cls) {
        return this.zzamV.containsKey(cls.getCanonicalName());
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzcR(String str) {
        return this.zzamV.get(str);
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Entry> zzrA() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.zzamV.keySet()) {
            arrayList.add(new Entry(next, this.zzamV.get(next)));
        }
        return arrayList;
    }

    public String zzrB() {
        return this.zzamX;
    }

    public void zzry() {
        for (String str : this.zzamV.keySet()) {
            Map map = this.zzamV.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zza(this);
            }
        }
    }

    public void zzrz() {
        for (String next : this.zzamV.keySet()) {
            Map map = this.zzamV.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zzro());
            }
            this.zzamV.put(next, hashMap);
        }
    }
}
