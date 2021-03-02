package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.fk */
public final class C1171fk implements SafeParcelable {
    public static final C1172fl CREATOR = new C1172fl();
    public final int errorCode;
    public final int orientation;

    /* renamed from: qf */
    public final List<String> f3555qf;

    /* renamed from: qg */
    public final List<String> f3556qg;

    /* renamed from: qj */
    public final long f3557qj;

    /* renamed from: rP */
    public final String f3558rP;

    /* renamed from: tF */
    public final boolean f3559tF;

    /* renamed from: tG */
    public final String f3560tG;

    /* renamed from: tH */
    public final long f3561tH;

    /* renamed from: tI */
    public final boolean f3562tI;

    /* renamed from: tJ */
    public final long f3563tJ;

    /* renamed from: tK */
    public final List<String> f3564tK;

    /* renamed from: tL */
    public final String f3565tL;

    /* renamed from: tM */
    public final long f3566tM;

    /* renamed from: tN */
    public final String f3567tN;

    /* renamed from: tO */
    public final boolean f3568tO;

    /* renamed from: tP */
    public final String f3569tP;

    /* renamed from: tQ */
    public final String f3570tQ;

    /* renamed from: tR */
    public final boolean f3571tR;

    /* renamed from: tS */
    public final boolean f3572tS;

    /* renamed from: tT */
    public final boolean f3573tT;
    public final int versionCode;

    public C1171fk(int i) {
        this(10, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, -1, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, false);
    }

    public C1171fk(int i, long j) {
        this(10, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, j, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, false);
    }

    C1171fk(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.versionCode = i;
        this.f3558rP = str;
        this.f3560tG = str2;
        this.f3555qf = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.f3556qg = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f3561tH = j;
        this.f3562tI = z;
        this.f3563tJ = j2;
        this.f3564tK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f3557qj = j3;
        this.orientation = i3;
        this.f3565tL = str3;
        this.f3566tM = j4;
        this.f3567tN = str4;
        this.f3568tO = z2;
        this.f3569tP = str5;
        this.f3570tQ = str6;
        this.f3571tR = z3;
        this.f3572tS = z4;
        this.f3559tF = z5;
        this.f3573tT = z6;
    }

    public C1171fk(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(10, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, (String) null, str5, z2, z3, z4, z5);
    }

    public C1171fk(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6) {
        this(10, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1172fl.m4461a(this, out, flags);
    }
}
