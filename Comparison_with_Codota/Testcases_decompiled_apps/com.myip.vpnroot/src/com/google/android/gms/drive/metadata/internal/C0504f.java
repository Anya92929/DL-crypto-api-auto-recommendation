package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0493a;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C0504f extends C0493a<Integer> {
    public C0504f(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Integer mo5120c(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.mo4305b(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Integer mo5121g(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
