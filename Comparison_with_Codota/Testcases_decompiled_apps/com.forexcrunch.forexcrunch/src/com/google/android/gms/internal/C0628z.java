package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0409ae;

/* renamed from: com.google.android.gms.internal.z */
public class C0628z implements SafeParcelable {
    public static final C0404aa CREATOR = new C0404aa();

    /* renamed from: ab */
    private final int f1447ab;

    /* renamed from: cn */
    private final C0405ab f1448cn;

    C0628z(int i, C0405ab abVar) {
        this.f1447ab = i;
        this.f1448cn = abVar;
    }

    private C0628z(C0405ab abVar) {
        this.f1447ab = 1;
        this.f1448cn = abVar;
    }

    /* renamed from: a */
    public static C0628z m1912a(C0409ae.C0411b<?, ?> bVar) {
        if (bVar instanceof C0405ab) {
            return new C0628z((C0405ab) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public C0405ab mo5515O() {
        return this.f1448cn;
    }

    /* renamed from: P */
    public C0409ae.C0411b<?, ?> mo5516P() {
        if (this.f1448cn != null) {
            return this.f1448cn;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public int describeContents() {
        C0404aa aaVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5518i() {
        return this.f1447ab;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0404aa aaVar = CREATOR;
        C0404aa.m796a(this, out, flags);
    }
}
