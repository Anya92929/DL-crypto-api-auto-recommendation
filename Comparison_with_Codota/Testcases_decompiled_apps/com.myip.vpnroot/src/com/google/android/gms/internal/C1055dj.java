package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@C1130ez
/* renamed from: com.google.android.gms.internal.dj */
public final class C1055dj implements SafeParcelable {
    public static final C1054di CREATOR = new C1054di();
    public final String mimeType;
    public final String packageName;

    /* renamed from: rp */
    public final String f3150rp;

    /* renamed from: rq */
    public final String f3151rq;

    /* renamed from: rr */
    public final String f3152rr;

    /* renamed from: rs */
    public final String f3153rs;

    /* renamed from: rt */
    public final String f3154rt;
    public final int versionCode;

    public C1055dj(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.f3150rp = str;
        this.f3151rq = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.f3152rr = str5;
        this.f3153rs = str6;
        this.f3154rt = str7;
    }

    public C1055dj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1054di.m4229a(this, out, flags);
    }
}
