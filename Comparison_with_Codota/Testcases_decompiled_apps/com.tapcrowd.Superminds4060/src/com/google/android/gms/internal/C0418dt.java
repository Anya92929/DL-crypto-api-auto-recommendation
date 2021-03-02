package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.dt */
public final class C0418dt implements SafeParcelable, C0422dw.C0424b<String, Integer> {
    public static final C0420du CREATOR = new C0420du();

    /* renamed from: iM */
    private final int f1147iM;

    /* renamed from: lu */
    private final HashMap<String, Integer> f1148lu;

    /* renamed from: lv */
    private final HashMap<Integer, String> f1149lv;

    /* renamed from: lw */
    private final ArrayList<C0419a> f1150lw;

    /* renamed from: com.google.android.gms.internal.dt$a */
    public static final class C0419a implements SafeParcelable {
        public static final C0421dv CREATOR = new C0421dv();

        /* renamed from: lx */
        final String f1151lx;

        /* renamed from: ly */
        final int f1152ly;
        final int versionCode;

        C0419a(int i, String str, int i2) {
            this.versionCode = i;
            this.f1151lx = str;
            this.f1152ly = i2;
        }

        C0419a(String str, int i) {
            this.versionCode = 1;
            this.f1151lx = str;
            this.f1152ly = i;
        }

        public int describeContents() {
            C0421dv dvVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0421dv dvVar = CREATOR;
            C0421dv.m976a(this, out, flags);
        }
    }

    public C0418dt() {
        this.f1147iM = 1;
        this.f1148lu = new HashMap<>();
        this.f1149lv = new HashMap<>();
        this.f1150lw = null;
    }

    C0418dt(int i, ArrayList<C0419a> arrayList) {
        this.f1147iM = i;
        this.f1148lu = new HashMap<>();
        this.f1149lv = new HashMap<>();
        this.f1150lw = null;
        m966a(arrayList);
    }

    /* renamed from: a */
    private void m966a(ArrayList<C0419a> arrayList) {
        Iterator<C0419a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0419a next = it.next();
            mo4412c(next.f1151lx, next.f1152ly);
        }
    }

    /* renamed from: a */
    public String mo4414f(Integer num) {
        String str = this.f1149lv.get(num);
        return (str != null || !this.f1148lu.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bm */
    public ArrayList<C0419a> mo4409bm() {
        ArrayList<C0419a> arrayList = new ArrayList<>();
        for (String next : this.f1148lu.keySet()) {
            arrayList.add(new C0419a(next, this.f1148lu.get(next).intValue()));
        }
        return arrayList;
    }

    /* renamed from: bn */
    public int mo4410bn() {
        return 7;
    }

    /* renamed from: bo */
    public int mo4411bo() {
        return 0;
    }

    /* renamed from: c */
    public C0418dt mo4412c(String str, int i) {
        this.f1148lu.put(str, Integer.valueOf(i));
        this.f1149lv.put(Integer.valueOf(i), str);
        return this;
    }

    public int describeContents() {
        C0420du duVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1147iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0420du duVar = CREATOR;
        C0420du.m973a(this, out, flags);
    }
}
