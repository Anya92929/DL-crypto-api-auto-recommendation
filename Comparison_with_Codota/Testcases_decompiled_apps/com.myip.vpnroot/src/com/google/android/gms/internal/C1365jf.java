package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1369ji;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.jf */
public final class C1365jf implements SafeParcelable, C1369ji.C1371b<String, Integer> {
    public static final C1367jg CREATOR = new C1367jg();

    /* renamed from: BR */
    private final int f4105BR;

    /* renamed from: Ml */
    private final HashMap<String, Integer> f4106Ml;

    /* renamed from: Mm */
    private final HashMap<Integer, String> f4107Mm;

    /* renamed from: Mn */
    private final ArrayList<C1366a> f4108Mn;

    /* renamed from: com.google.android.gms.internal.jf$a */
    public static final class C1366a implements SafeParcelable {
        public static final C1368jh CREATOR = new C1368jh();

        /* renamed from: Mo */
        final String f4109Mo;

        /* renamed from: Mp */
        final int f4110Mp;
        final int versionCode;

        C1366a(int i, String str, int i2) {
            this.versionCode = i;
            this.f4109Mo = str;
            this.f4110Mp = i2;
        }

        C1366a(String str, int i) {
            this.versionCode = 1;
            this.f4109Mo = str;
            this.f4110Mp = i;
        }

        public int describeContents() {
            C1368jh jhVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1368jh jhVar = CREATOR;
            C1368jh.m5117a(this, out, flags);
        }
    }

    public C1365jf() {
        this.f4105BR = 1;
        this.f4106Ml = new HashMap<>();
        this.f4107Mm = new HashMap<>();
        this.f4108Mn = null;
    }

    C1365jf(int i, ArrayList<C1366a> arrayList) {
        this.f4105BR = i;
        this.f4106Ml = new HashMap<>();
        this.f4107Mm = new HashMap<>();
        this.f4108Mn = null;
        m5108b(arrayList);
    }

    /* renamed from: b */
    private void m5108b(ArrayList<C1366a> arrayList) {
        Iterator<C1366a> it = arrayList.iterator();
        while (it.hasNext()) {
            C1366a next = it.next();
            mo9001h(next.f4109Mo, next.f4110Mp);
        }
    }

    /* renamed from: a */
    public String convertBack(Integer num) {
        String str = this.f4107Mm.get(num);
        return (str != null || !this.f4106Ml.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public int describeContents() {
        C1367jg jgVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4105BR;
    }

    /* renamed from: h */
    public C1365jf mo9001h(String str, int i) {
        this.f4106Ml.put(str, Integer.valueOf(i));
        this.f4107Mm.put(Integer.valueOf(i), str);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: hc */
    public ArrayList<C1366a> mo9002hc() {
        ArrayList<C1366a> arrayList = new ArrayList<>();
        for (String next : this.f4106Ml.keySet()) {
            arrayList.add(new C1366a(next, this.f4106Ml.get(next).intValue()));
        }
        return arrayList;
    }

    /* renamed from: hd */
    public int mo9003hd() {
        return 7;
    }

    /* renamed from: he */
    public int mo9004he() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1367jg jgVar = CREATOR;
        C1367jg.m5114a(this, out, flags);
    }
}
