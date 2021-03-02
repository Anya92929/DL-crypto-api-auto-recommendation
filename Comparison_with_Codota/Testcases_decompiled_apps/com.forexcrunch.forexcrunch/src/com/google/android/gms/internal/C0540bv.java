package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.bv */
public class C0540bv implements SafeParcelable {
    public static final C0541bw CREATOR = new C0541bw();

    /* renamed from: ab */
    private final int f1173ab;

    /* renamed from: di */
    private final String f1174di;

    /* renamed from: iA */
    private final ArrayList<C0626x> f1175iA;

    /* renamed from: iB */
    private final boolean f1176iB;

    /* renamed from: iz */
    private final ArrayList<C0626x> f1177iz;

    public C0540bv(int i, String str, ArrayList<C0626x> arrayList, ArrayList<C0626x> arrayList2, boolean z) {
        this.f1173ab = i;
        this.f1174di = str;
        this.f1177iz = arrayList;
        this.f1175iA = arrayList2;
        this.f1176iB = z;
    }

    /* renamed from: bE */
    public ArrayList<C0626x> mo4932bE() {
        return this.f1177iz;
    }

    /* renamed from: bF */
    public ArrayList<C0626x> mo4933bF() {
        return this.f1175iA;
    }

    /* renamed from: bG */
    public boolean mo4934bG() {
        return this.f1176iB;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.f1174di;
    }

    /* renamed from: i */
    public int mo4937i() {
        return this.f1173ab;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0541bw.m1538a(this, out, flags);
    }
}
