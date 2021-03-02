package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a */
    private final int f4647a;

    /* renamed from: b */
    private final HashMap f4648b;

    /* renamed from: c */
    private final ArrayList f4649c = null;

    /* renamed from: d */
    private final String f4650d;

    public class Entry extends AbstractSafeParcelable {
        public static final zzd CREATOR = new zzd();

        /* renamed from: a */
        final int f4651a;

        /* renamed from: b */
        final String f4652b;

        /* renamed from: c */
        final ArrayList f4653c;

        Entry(int i, String str, ArrayList arrayList) {
            this.f4651a = i;
            this.f4652b = str;
            this.f4653c = arrayList;
        }

        Entry(String str, Map map) {
            this.f4651a = 1;
            this.f4652b = str;
            this.f4653c = m6165a(map);
        }

        /* renamed from: a */
        private static ArrayList m6165a(Map map) {
            if (map == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (FastJsonResponse.Field) map.get(str)));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public HashMap mo6835a() {
            HashMap hashMap = new HashMap();
            int size = this.f4653c.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.f4653c.get(i);
                hashMap.put(fieldMapPair.f4655b, fieldMapPair.f4656c);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd zzd = CREATOR;
            zzd.m6179a(this, parcel, i);
        }
    }

    public class FieldMapPair extends AbstractSafeParcelable {
        public static final zzb CREATOR = new zzb();

        /* renamed from: a */
        final int f4654a;

        /* renamed from: b */
        final String f4655b;

        /* renamed from: c */
        final FastJsonResponse.Field f4656c;

        FieldMapPair(int i, String str, FastJsonResponse.Field field) {
            this.f4654a = i;
            this.f4655b = str;
            this.f4656c = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field field) {
            this.f4654a = 1;
            this.f4655b = str;
            this.f4656c = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb zzb = CREATOR;
            zzb.m6177a(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList arrayList, String str) {
        this.f4647a = i;
        this.f4648b = m6162a(arrayList);
        this.f4650d = (String) zzab.zzy(str);
        zzauh();
    }

    /* renamed from: a */
    private static HashMap m6162a(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.f4652b, entry.mo6835a());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6828a() {
        return this.f4647a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList mo6829b() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4648b.keySet()) {
            arrayList.add(new Entry(str, (Map) this.f4648b.get(str)));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f4648b.keySet()) {
            sb.append(str).append(":\n");
            Map map = (Map) this.f4648b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc zzc = CREATOR;
        zzc.m6178a(this, parcel, i);
    }

    public void zzauh() {
        for (String str : this.f4648b.keySet()) {
            Map map = (Map) this.f4648b.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zza(this);
            }
        }
    }

    public String zzauj() {
        return this.f4650d;
    }

    public Map zzhw(String str) {
        return (Map) this.f4648b.get(str);
    }
}
