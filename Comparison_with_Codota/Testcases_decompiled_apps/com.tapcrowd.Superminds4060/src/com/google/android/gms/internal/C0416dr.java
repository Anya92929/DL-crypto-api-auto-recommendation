package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0422dw;

/* renamed from: com.google.android.gms.internal.dr */
public class C0416dr implements SafeParcelable {
    public static final C0417ds CREATOR = new C0417ds();

    /* renamed from: iM */
    private final int f1145iM;

    /* renamed from: lt */
    private final C0418dt f1146lt;

    C0416dr(int i, C0418dt dtVar) {
        this.f1145iM = i;
        this.f1146lt = dtVar;
    }

    private C0416dr(C0418dt dtVar) {
        this.f1145iM = 1;
        this.f1146lt = dtVar;
    }

    /* renamed from: a */
    public static C0416dr m960a(C0422dw.C0424b<?, ?> bVar) {
        if (bVar instanceof C0418dt) {
            return new C0416dr((C0418dt) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bk */
    public C0418dt mo4399bk() {
        return this.f1146lt;
    }

    /* renamed from: bl */
    public C0422dw.C0424b<?, ?> mo4400bl() {
        if (this.f1146lt != null) {
            return this.f1146lt;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public int describeContents() {
        C0417ds dsVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1145iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0417ds dsVar = CREATOR;
        C0417ds.m963a(this, out, flags);
    }
}
