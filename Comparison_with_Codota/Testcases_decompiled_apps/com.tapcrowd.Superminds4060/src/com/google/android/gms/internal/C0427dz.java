package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.dz */
public class C0427dz implements SafeParcelable {
    public static final C0431ea CREATOR = new C0431ea();

    /* renamed from: iM */
    private final int f1164iM;

    /* renamed from: lJ */
    private final HashMap<String, HashMap<String, C0422dw.C0423a<?, ?>>> f1165lJ;

    /* renamed from: lK */
    private final ArrayList<C0428a> f1166lK;

    /* renamed from: lL */
    private final String f1167lL;

    /* renamed from: com.google.android.gms.internal.dz$a */
    public static class C0428a implements SafeParcelable {
        public static final C0432eb CREATOR = new C0432eb();
        final String className;

        /* renamed from: lM */
        final ArrayList<C0429b> f1168lM;
        final int versionCode;

        C0428a(int i, String str, ArrayList<C0429b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.f1168lM = arrayList;
        }

        C0428a(String str, HashMap<String, C0422dw.C0423a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.f1168lM = m1031a(hashMap);
        }

        /* renamed from: a */
        private static ArrayList<C0429b> m1031a(HashMap<String, C0422dw.C0423a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0429b> arrayList = new ArrayList<>();
            for (String next : hashMap.keySet()) {
                arrayList.add(new C0429b(next, hashMap.get(next)));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bG */
        public HashMap<String, C0422dw.C0423a<?, ?>> mo4475bG() {
            HashMap<String, C0422dw.C0423a<?, ?>> hashMap = new HashMap<>();
            int size = this.f1168lM.size();
            for (int i = 0; i < size; i++) {
                C0429b bVar = this.f1168lM.get(i);
                hashMap.put(bVar.f1169lN, bVar.f1170lO);
            }
            return hashMap;
        }

        public int describeContents() {
            C0432eb ebVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0432eb ebVar = CREATOR;
            C0432eb.m1049a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.dz$b */
    public static class C0429b implements SafeParcelable {
        public static final C0426dy CREATOR = new C0426dy();

        /* renamed from: lN */
        final String f1169lN;

        /* renamed from: lO */
        final C0422dw.C0423a<?, ?> f1170lO;
        final int versionCode;

        C0429b(int i, String str, C0422dw.C0423a<?, ?> aVar) {
            this.versionCode = i;
            this.f1169lN = str;
            this.f1170lO = aVar;
        }

        C0429b(String str, C0422dw.C0423a<?, ?> aVar) {
            this.versionCode = 1;
            this.f1169lN = str;
            this.f1170lO = aVar;
        }

        public int describeContents() {
            C0426dy dyVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0426dy dyVar = CREATOR;
            C0426dy.m1020a(this, out, flags);
        }
    }

    C0427dz(int i, ArrayList<C0428a> arrayList, String str) {
        this.f1164iM = i;
        this.f1166lK = null;
        this.f1165lJ = m1023b(arrayList);
        this.f1167lL = (String) C0411dm.m944e(str);
        mo4467bC();
    }

    public C0427dz(Class<? extends C0422dw> cls) {
        this.f1164iM = 1;
        this.f1166lK = null;
        this.f1165lJ = new HashMap<>();
        this.f1167lL = cls.getCanonicalName();
    }

    /* renamed from: b */
    private static HashMap<String, HashMap<String, C0422dw.C0423a<?, ?>>> m1023b(ArrayList<C0428a> arrayList) {
        HashMap<String, HashMap<String, C0422dw.C0423a<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0428a aVar = arrayList.get(i);
            hashMap.put(aVar.className, aVar.mo4475bG());
        }
        return hashMap;
    }

    /* renamed from: H */
    public HashMap<String, C0422dw.C0423a<?, ?>> mo4464H(String str) {
        return this.f1165lJ.get(str);
    }

    /* renamed from: a */
    public void mo4465a(Class<? extends C0422dw> cls, HashMap<String, C0422dw.C0423a<?, ?>> hashMap) {
        this.f1165lJ.put(cls.getCanonicalName(), hashMap);
    }

    /* renamed from: b */
    public boolean mo4466b(Class<? extends C0422dw> cls) {
        return this.f1165lJ.containsKey(cls.getCanonicalName());
    }

    /* renamed from: bC */
    public void mo4467bC() {
        for (String str : this.f1165lJ.keySet()) {
            HashMap hashMap = this.f1165lJ.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0422dw.C0423a) hashMap.get(str2)).mo4438a(this);
            }
        }
    }

    /* renamed from: bD */
    public void mo4468bD() {
        for (String next : this.f1165lJ.keySet()) {
            HashMap hashMap = this.f1165lJ.get(next);
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                hashMap2.put(str, ((C0422dw.C0423a) hashMap.get(str)).mo4443bs());
            }
            this.f1165lJ.put(next, hashMap2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bE */
    public ArrayList<C0428a> mo4469bE() {
        ArrayList<C0428a> arrayList = new ArrayList<>();
        for (String next : this.f1165lJ.keySet()) {
            arrayList.add(new C0428a(next, this.f1165lJ.get(next)));
        }
        return arrayList;
    }

    /* renamed from: bF */
    public String mo4470bF() {
        return this.f1167lL;
    }

    public int describeContents() {
        C0431ea eaVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1164iM;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f1165lJ.keySet()) {
            sb.append(next).append(":\n");
            HashMap hashMap = this.f1165lJ.get(next);
            for (String str : hashMap.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(hashMap.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0431ea eaVar = CREATOR;
        C0431ea.m1046a(this, out, flags);
    }
}
