package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0493a;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C0500b extends C0493a<Boolean> {
    public C0500b(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Boolean mo5120c(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.mo4308d(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public Boolean mo5121g(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
