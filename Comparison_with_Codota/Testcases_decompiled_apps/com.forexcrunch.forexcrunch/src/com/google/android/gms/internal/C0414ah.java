package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ah */
public class C0414ah implements SafeParcelable {
    public static final C0417ai CREATOR = new C0417ai();

    /* renamed from: ab */
    private final int f999ab;

    /* renamed from: cD */
    private final HashMap<String, HashMap<String, C0409ae.C0410a<?, ?>>> f1000cD;

    /* renamed from: cE */
    private final ArrayList<C0415a> f1001cE;

    /* renamed from: cF */
    private final String f1002cF;

    /* renamed from: com.google.android.gms.internal.ah$a */
    public static class C0415a implements SafeParcelable {
        public static final C0418aj CREATOR = new C0418aj();

        /* renamed from: cG */
        final ArrayList<C0416b> f1003cG;
        final String className;
        final int versionCode;

        C0415a(int i, String str, ArrayList<C0416b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.f1003cG = arrayList;
        }

        C0415a(String str, HashMap<String, C0409ae.C0410a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.f1003cG = m867a(hashMap);
        }

        /* renamed from: a */
        private static ArrayList<C0416b> m867a(HashMap<String, C0409ae.C0410a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0416b> arrayList = new ArrayList<>();
            for (String next : hashMap.keySet()) {
                arrayList.add(new C0416b(next, hashMap.get(next)));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ak */
        public HashMap<String, C0409ae.C0410a<?, ?>> mo4523ak() {
            HashMap<String, C0409ae.C0410a<?, ?>> hashMap = new HashMap<>();
            int size = this.f1003cG.size();
            for (int i = 0; i < size; i++) {
                C0416b bVar = this.f1003cG.get(i);
                hashMap.put(bVar.f1004cH, bVar.f1005cI);
            }
            return hashMap;
        }

        public int describeContents() {
            C0418aj ajVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0418aj ajVar = CREATOR;
            C0418aj.m872a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ah$b */
    public static class C0416b implements SafeParcelable {
        public static final C0413ag CREATOR = new C0413ag();

        /* renamed from: cH */
        final String f1004cH;

        /* renamed from: cI */
        final C0409ae.C0410a<?, ?> f1005cI;
        final int versionCode;

        C0416b(int i, String str, C0409ae.C0410a<?, ?> aVar) {
            this.versionCode = i;
            this.f1004cH = str;
            this.f1005cI = aVar;
        }

        C0416b(String str, C0409ae.C0410a<?, ?> aVar) {
            this.versionCode = 1;
            this.f1004cH = str;
            this.f1005cI = aVar;
        }

        public int describeContents() {
            C0413ag agVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0413ag agVar = CREATOR;
            C0413ag.m855a(this, out, flags);
        }
    }

    C0414ah(int i, ArrayList<C0415a> arrayList, String str) {
        this.f999ab = i;
        this.f1001cE = null;
        this.f1000cD = m858b(arrayList);
        this.f1002cF = (String) C0621s.m1890d(str);
        mo4513ag();
    }

    public C0414ah(Class<? extends C0409ae> cls) {
        this.f999ab = 1;
        this.f1001cE = null;
        this.f1000cD = new HashMap<>();
        this.f1002cF = cls.getCanonicalName();
    }

    /* renamed from: b */
    private static HashMap<String, HashMap<String, C0409ae.C0410a<?, ?>>> m858b(ArrayList<C0415a> arrayList) {
        HashMap<String, HashMap<String, C0409ae.C0410a<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0415a aVar = arrayList.get(i);
            hashMap.put(aVar.className, aVar.mo4523ak());
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo4512a(Class<? extends C0409ae> cls, HashMap<String, C0409ae.C0410a<?, ?>> hashMap) {
        this.f1000cD.put(cls.getCanonicalName(), hashMap);
    }

    /* renamed from: ag */
    public void mo4513ag() {
        for (String str : this.f1000cD.keySet()) {
            HashMap hashMap = this.f1000cD.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0409ae.C0410a) hashMap.get(str2)).mo4492a(this);
            }
        }
    }

    /* renamed from: ah */
    public void mo4514ah() {
        for (String next : this.f1000cD.keySet()) {
            HashMap hashMap = this.f1000cD.get(next);
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                hashMap2.put(str, ((C0409ae.C0410a) hashMap.get(str)).mo4488W());
            }
            this.f1000cD.put(next, hashMap2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ai */
    public ArrayList<C0415a> mo4515ai() {
        ArrayList<C0415a> arrayList = new ArrayList<>();
        for (String next : this.f1000cD.keySet()) {
            arrayList.add(new C0415a(next, this.f1000cD.get(next)));
        }
        return arrayList;
    }

    /* renamed from: aj */
    public String mo4516aj() {
        return this.f1002cF;
    }

    /* renamed from: b */
    public boolean mo4517b(Class<? extends C0409ae> cls) {
        return this.f1000cD.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        C0417ai aiVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo4519i() {
        return this.f999ab;
    }

    /* renamed from: q */
    public HashMap<String, C0409ae.C0410a<?, ?>> mo4520q(String str) {
        return this.f1000cD.get(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f1000cD.keySet()) {
            sb.append(next).append(":\n");
            HashMap hashMap = this.f1000cD.get(next);
            for (String str : hashMap.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(hashMap.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0417ai aiVar = CREATOR;
        C0417ai.m869a(this, out, flags);
    }
}
