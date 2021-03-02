package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0493a;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C0505g extends C0493a<Long> {
    public C0505g(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public Long mo5120c(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.mo4301a(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Long mo5121g(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
