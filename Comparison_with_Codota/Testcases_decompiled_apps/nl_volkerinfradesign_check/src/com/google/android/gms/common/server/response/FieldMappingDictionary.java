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

    /* renamed from: a */
    private final int f3051a;

    /* renamed from: b */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f3052b;

    /* renamed from: c */
    private final ArrayList<Entry> f3053c;

    /* renamed from: d */
    private final String f3054d;

    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();

        /* renamed from: a */
        final int f3055a;

        /* renamed from: b */
        final String f3056b;

        /* renamed from: c */
        final ArrayList<FieldMapPair> f3057c;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.f3055a = i;
            this.f3056b = str;
            this.f3057c = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            this.f3055a = 1;
            this.f3056b = str;
            this.f3057c = m3972a(map);
        }

        /* renamed from: a */
        private static ArrayList<FieldMapPair> m3972a(Map<String, FastJsonResponse.Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new FieldMapPair(next, map.get(next)));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public HashMap<String, FastJsonResponse.Field<?, ?>> mo5682a() {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            int size = this.f3057c.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = this.f3057c.get(i);
                hashMap.put(fieldMapPair.f3059b, fieldMapPair.f3060c);
            }
            return hashMap;
        }

        public int describeContents() {
            zzd zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd zzd = CREATOR;
            zzd.m3988a(this, parcel, i);
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();

        /* renamed from: a */
        final int f3058a;

        /* renamed from: b */
        final String f3059b;

        /* renamed from: c */
        final FastJsonResponse.Field<?, ?> f3060c;

        FieldMapPair(int i, String str, FastJsonResponse.Field<?, ?> field) {
            this.f3058a = i;
            this.f3059b = str;
            this.f3060c = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.f3058a = 1;
            this.f3059b = str;
            this.f3060c = field;
        }

        public int describeContents() {
            zzb zzb = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb zzb = CREATOR;
            zzb.m3986a(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.f3051a = i;
        this.f3053c = null;
        this.f3052b = m3969a(arrayList);
        this.f3054d = (String) zzx.zzz(str);
        zzry();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        this.f3051a = 1;
        this.f3053c = null;
        this.f3052b = new HashMap<>();
        this.f3054d = cls.getCanonicalName();
    }

    /* renamed from: a */
    private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> m3969a(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = arrayList.get(i);
            hashMap.put(entry.f3056b, entry.mo5682a());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5671a() {
        return this.f3051a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<Entry> mo5672b() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.f3052b.keySet()) {
            arrayList.add(new Entry(next, this.f3052b.get(next)));
        }
        return arrayList;
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f3052b.keySet()) {
            sb.append(next).append(":\n");
            Map map = this.f3052b.get(next);
            for (String str : map.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc zzc = CREATOR;
        zzc.m3987a(this, parcel, i);
    }

    public void zza(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.f3052b.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class<? extends FastJsonResponse> cls) {
        return this.f3052b.containsKey(cls.getCanonicalName());
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzcR(String str) {
        return this.f3052b.get(str);
    }

    public String zzrB() {
        return this.f3054d;
    }

    public void zzry() {
        for (String str : this.f3052b.keySet()) {
            Map map = this.f3052b.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zza(this);
            }
        }
    }

    public void zzrz() {
        for (String next : this.f3052b.keySet()) {
            Map map = this.f3052b.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zzro());
            }
            this.f3052b.put(next, hashMap);
        }
    }
}
