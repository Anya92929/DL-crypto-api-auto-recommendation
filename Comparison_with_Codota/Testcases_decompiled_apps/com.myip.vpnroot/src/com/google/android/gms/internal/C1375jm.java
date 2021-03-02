package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1369ji;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.jm */
public class C1375jm implements SafeParcelable {
    public static final C1378jn CREATOR = new C1378jn();

    /* renamed from: BR */
    private final int f4122BR;

    /* renamed from: MA */
    private final HashMap<String, HashMap<String, C1369ji.C1370a<?, ?>>> f4123MA;

    /* renamed from: MB */
    private final ArrayList<C1376a> f4124MB;

    /* renamed from: MC */
    private final String f4125MC;

    /* renamed from: com.google.android.gms.internal.jm$a */
    public static class C1376a implements SafeParcelable {
        public static final C1379jo CREATOR = new C1379jo();

        /* renamed from: MD */
        final ArrayList<C1377b> f4126MD;
        final String className;
        final int versionCode;

        C1376a(int i, String str, ArrayList<C1377b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.f4126MD = arrayList;
        }

        C1376a(String str, HashMap<String, C1369ji.C1370a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.f4126MD = m5172a(hashMap);
        }

        /* renamed from: a */
        private static ArrayList<C1377b> m5172a(HashMap<String, C1369ji.C1370a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C1377b> arrayList = new ArrayList<>();
            for (String next : hashMap.keySet()) {
                arrayList.add(new C1377b(next, hashMap.get(next)));
            }
            return arrayList;
        }

        public int describeContents() {
            C1379jo joVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: hw */
        public HashMap<String, C1369ji.C1370a<?, ?>> mo9065hw() {
            HashMap<String, C1369ji.C1370a<?, ?>> hashMap = new HashMap<>();
            int size = this.f4126MD.size();
            for (int i = 0; i < size; i++) {
                C1377b bVar = this.f4126MD.get(i);
                hashMap.put(bVar.f4128fv, bVar.f4127ME);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1379jo joVar = CREATOR;
            C1379jo.m5177a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.jm$b */
    public static class C1377b implements SafeParcelable {
        public static final C1374jl CREATOR = new C1374jl();

        /* renamed from: ME */
        final C1369ji.C1370a<?, ?> f4127ME;

        /* renamed from: fv */
        final String f4128fv;
        final int versionCode;

        C1377b(int i, String str, C1369ji.C1370a<?, ?> aVar) {
            this.versionCode = i;
            this.f4128fv = str;
            this.f4127ME = aVar;
        }

        C1377b(String str, C1369ji.C1370a<?, ?> aVar) {
            this.versionCode = 1;
            this.f4128fv = str;
            this.f4127ME = aVar;
        }

        public int describeContents() {
            C1374jl jlVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C1374jl jlVar = CREATOR;
            C1374jl.m5161a(this, out, flags);
        }
    }

    C1375jm(int i, ArrayList<C1376a> arrayList, String str) {
        this.f4122BR = i;
        this.f4124MB = null;
        this.f4123MA = m5164c(arrayList);
        this.f4125MC = (String) C0348n.m861i(str);
        mo9058hs();
    }

    public C1375jm(Class<? extends C1369ji> cls) {
        this.f4122BR = 1;
        this.f4124MB = null;
        this.f4123MA = new HashMap<>();
        this.f4125MC = cls.getCanonicalName();
    }

    /* renamed from: c */
    private static HashMap<String, HashMap<String, C1369ji.C1370a<?, ?>>> m5164c(ArrayList<C1376a> arrayList) {
        HashMap<String, HashMap<String, C1369ji.C1370a<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1376a aVar = arrayList.get(i);
            hashMap.put(aVar.className, aVar.mo9065hw());
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo9053a(Class<? extends C1369ji> cls, HashMap<String, C1369ji.C1370a<?, ?>> hashMap) {
        this.f4123MA.put(cls.getCanonicalName(), hashMap);
    }

    /* renamed from: b */
    public boolean mo9054b(Class<? extends C1369ji> cls) {
        return this.f4123MA.containsKey(cls.getCanonicalName());
    }

    /* renamed from: be */
    public HashMap<String, C1369ji.C1370a<?, ?>> mo9055be(String str) {
        return this.f4123MA.get(str);
    }

    public int describeContents() {
        C1378jn jnVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4122BR;
    }

    /* renamed from: hs */
    public void mo9058hs() {
        for (String str : this.f4123MA.keySet()) {
            HashMap hashMap = this.f4123MA.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C1369ji.C1370a) hashMap.get(str2)).mo9027a(this);
            }
        }
    }

    /* renamed from: ht */
    public void mo9059ht() {
        for (String next : this.f4123MA.keySet()) {
            HashMap hashMap = this.f4123MA.get(next);
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                hashMap2.put(str, ((C1369ji.C1370a) hashMap.get(str)).mo9033hi());
            }
            this.f4123MA.put(next, hashMap2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: hu */
    public ArrayList<C1376a> mo9060hu() {
        ArrayList<C1376a> arrayList = new ArrayList<>();
        for (String next : this.f4123MA.keySet()) {
            arrayList.add(new C1376a(next, this.f4123MA.get(next)));
        }
        return arrayList;
    }

    /* renamed from: hv */
    public String mo9061hv() {
        return this.f4125MC;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f4123MA.keySet()) {
            sb.append(next).append(":\n");
            HashMap hashMap = this.f4123MA.get(next);
            for (String str : hashMap.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(hashMap.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1378jn jnVar = CREATOR;
        C1378jn.m5174a(this, out, flags);
    }
}
