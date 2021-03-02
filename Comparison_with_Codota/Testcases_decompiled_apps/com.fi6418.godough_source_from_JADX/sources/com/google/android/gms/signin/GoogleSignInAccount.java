package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C1241a();

    /* renamed from: a */
    final int f5252a;

    /* renamed from: b */
    private String f5253b;

    /* renamed from: c */
    private String f5254c;

    /* renamed from: d */
    private String f5255d;

    /* renamed from: e */
    private String f5256e;

    /* renamed from: f */
    private Uri f5257f;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri) {
        this.f5252a = i;
        this.f5253b = C1009bf.m4530a(str);
        this.f5254c = str2;
        this.f5255d = str3;
        this.f5256e = str4;
        this.f5257f = uri;
    }

    /* renamed from: a */
    public String mo9000a() {
        return this.f5253b;
    }

    /* renamed from: b */
    public String mo9001b() {
        return this.f5254c;
    }

    /* renamed from: c */
    public String mo9002c() {
        return this.f5255d;
    }

    /* renamed from: d */
    public String mo9003d() {
        return this.f5256e;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public Uri mo9005e() {
        return this.f5257f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1241a.m5167a(this, parcel, i);
    }
}
