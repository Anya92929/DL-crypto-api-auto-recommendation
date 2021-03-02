package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final C0525j CREATOR = new C0525j();

    /* renamed from: BR */
    final int f1151BR;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.f1151BR = versionCode;
    }

    /* renamed from: a */
    public <F> F mo5177a(C0521f<F> fVar) {
        return fVar.mo5215is();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0525j.m1515a(this, out, flags);
    }
}
