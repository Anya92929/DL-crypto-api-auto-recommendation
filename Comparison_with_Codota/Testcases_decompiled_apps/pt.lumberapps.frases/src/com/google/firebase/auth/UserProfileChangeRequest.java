package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new C1974c();

    /* renamed from: a */
    public final int f7475a;

    /* renamed from: b */
    private String f7476b;

    /* renamed from: c */
    private String f7477c;

    /* renamed from: d */
    private boolean f7478d;

    /* renamed from: e */
    private boolean f7479e;

    /* renamed from: f */
    private Uri f7480f;

    UserProfileChangeRequest(int i, String str, String str2, boolean z, boolean z2) {
        this.f7475a = i;
        this.f7476b = str;
        this.f7477c = str2;
        this.f7478d = z;
        this.f7479e = z2;
        this.f7480f = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    /* renamed from: a */
    public String mo9832a() {
        return this.f7476b;
    }

    /* renamed from: b */
    public String mo9833b() {
        return this.f7477c;
    }

    /* renamed from: c */
    public boolean mo9834c() {
        return this.f7478d;
    }

    /* renamed from: d */
    public boolean mo9835d() {
        return this.f7479e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1974c.m8075a(this, parcel, i);
    }
}
