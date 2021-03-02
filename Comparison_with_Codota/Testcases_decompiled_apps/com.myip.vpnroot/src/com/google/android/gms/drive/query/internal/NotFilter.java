package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new C0526k();

    /* renamed from: BR */
    final int f1152BR;

    /* renamed from: QQ */
    final FilterHolder f1153QQ;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.f1152BR = versionCode;
        this.f1153QQ = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    /* renamed from: a */
    public <T> T mo5177a(C0521f<T> fVar) {
        return fVar.mo5216j(this.f1153QQ.getFilter().mo5177a(fVar));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0526k.m1518a(this, out, flags);
    }
}
