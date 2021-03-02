package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    private final int f3041a;

    /* renamed from: b */
    private final HashMap<String, Integer> f3042b;

    /* renamed from: c */
    private final HashMap<Integer, String> f3043c;

    /* renamed from: d */
    private final ArrayList<Entry> f3044d;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();

        /* renamed from: a */
        final int f3045a;

        /* renamed from: b */
        final String f3046b;

        /* renamed from: c */
        final int f3047c;

        Entry(int i, String str, int i2) {
            this.f3045a = i;
            this.f3046b = str;
            this.f3047c = i2;
        }

        Entry(String str, int i) {
            this.f3045a = 1;
            this.f3046b = str;
            this.f3047c = i;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc zzc = CREATOR;
            zzc.m3963a(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.f3041a = 1;
        this.f3042b = new HashMap<>();
        this.f3043c = new HashMap<>();
        this.f3044d = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.f3041a = i;
        this.f3042b = new HashMap<>();
        this.f3043c = new HashMap<>();
        this.f3044d = null;
        m3958a(arrayList);
    }

    /* renamed from: a */
    private void m3958a(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            zzh(next.f3046b, next.f3047c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5619a() {
        return this.f3041a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<Entry> mo5620b() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.f3042b.keySet()) {
            arrayList.add(new Entry(next, this.f3042b.get(next).intValue()));
        }
        return arrayList;
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.m3962a(this, parcel, i);
    }

    /* renamed from: zzb */
    public String convertBack(Integer num) {
        String str = this.f3043c.get(num);
        return (str != null || !this.f3042b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzh(String str, int i) {
        this.f3042b.put(str, Integer.valueOf(i));
        this.f3043c.put(Integer.valueOf(i), str);
        return this;
    }

    public int zzrj() {
        return 7;
    }

    public int zzrk() {
        return 0;
    }
}
