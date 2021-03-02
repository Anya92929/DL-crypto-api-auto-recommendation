package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.ab */
public final class C0405ab implements SafeParcelable, C0409ae.C0411b<String, Integer> {
    public static final C0407ac CREATOR = new C0407ac();

    /* renamed from: ab */
    private final int f982ab;

    /* renamed from: co */
    private final HashMap<String, Integer> f983co;

    /* renamed from: cp */
    private final HashMap<Integer, String> f984cp;

    /* renamed from: cq */
    private final ArrayList<C0406a> f985cq;

    /* renamed from: com.google.android.gms.internal.ab$a */
    public static final class C0406a implements SafeParcelable {
        public static final C0408ad CREATOR = new C0408ad();

        /* renamed from: cr */
        final String f986cr;

        /* renamed from: cs */
        final int f987cs;
        final int versionCode;

        C0406a(int i, String str, int i2) {
            this.versionCode = i;
            this.f986cr = str;
            this.f987cs = i2;
        }

        C0406a(String str, int i) {
            this.versionCode = 1;
            this.f986cr = str;
            this.f987cs = i;
        }

        public int describeContents() {
            C0408ad adVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0408ad adVar = CREATOR;
            C0408ad.m810a(this, out, flags);
        }
    }

    public C0405ab() {
        this.f982ab = 1;
        this.f983co = new HashMap<>();
        this.f984cp = new HashMap<>();
        this.f985cq = null;
    }

    C0405ab(int i, ArrayList<C0406a> arrayList) {
        this.f982ab = i;
        this.f983co = new HashMap<>();
        this.f984cp = new HashMap<>();
        this.f985cq = null;
        m799a(arrayList);
    }

    /* renamed from: a */
    private void m799a(ArrayList<C0406a> arrayList) {
        Iterator<C0406a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0406a next = it.next();
            mo4460b(next.f986cr, next.f987cs);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Q */
    public ArrayList<C0406a> mo4456Q() {
        ArrayList<C0406a> arrayList = new ArrayList<>();
        for (String next : this.f983co.keySet()) {
            arrayList.add(new C0406a(next, this.f983co.get(next).intValue()));
        }
        return arrayList;
    }

    /* renamed from: R */
    public int mo4457R() {
        return 7;
    }

    /* renamed from: S */
    public int mo4458S() {
        return 0;
    }

    /* renamed from: a */
    public String mo4462e(Integer num) {
        String str = this.f984cp.get(num);
        return (str != null || !this.f983co.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    /* renamed from: b */
    public C0405ab mo4460b(String str, int i) {
        this.f983co.put(str, Integer.valueOf(i));
        this.f984cp.put(Integer.valueOf(i), str);
        return this;
    }

    public int describeContents() {
        C0407ac acVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo4463i() {
        return this.f982ab;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0407ac acVar = CREATOR;
        C0407ac.m807a(this, out, flags);
    }
}
