package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a */
    final int f2469a;

    /* renamed from: b */
    private final String f2470b;

    /* renamed from: c */
    private final Long f2471c;

    /* renamed from: d */
    private final boolean f2472d;

    /* renamed from: e */
    private final boolean f2473e;

    /* renamed from: f */
    private final List<String> f2474f;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.f2469a = i;
        this.f2470b = zzx.zzcM(str);
        this.f2471c = l;
        this.f2472d = z;
        this.f2473e = z2;
        this.f2474f = list;
    }

    @Nullable
    public static TokenData zzc(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f2470b, tokenData.f2470b) && zzw.equal(this.f2471c, tokenData.f2471c) && this.f2472d == tokenData.f2472d && this.f2473e == tokenData.f2473e && zzw.equal(this.f2474f, tokenData.f2474f);
    }

    public String getToken() {
        return this.f2470b;
    }

    public int hashCode() {
        return zzw.hashCode(this.f2470b, this.f2471c, Boolean.valueOf(this.f2472d), Boolean.valueOf(this.f2473e), this.f2474f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m3664a(this, parcel, i);
    }

    @Nullable
    public Long zzmn() {
        return this.f2471c;
    }

    public boolean zzmo() {
        return this.f2472d;
    }

    public boolean zzmp() {
        return this.f2473e;
    }

    @Nullable
    public List<String> zzmq() {
        return this.f2474f;
    }
}
