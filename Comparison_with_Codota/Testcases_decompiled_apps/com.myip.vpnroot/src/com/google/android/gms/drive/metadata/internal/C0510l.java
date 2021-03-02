package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0493a;

/* renamed from: com.google.android.gms.drive.metadata.internal.l */
public class C0510l extends C0493a<String> {
    public C0510l(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public String mo5120c(DataHolder dataHolder, int i, int i2) {
        return dataHolder.mo4306c(getName(), i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String mo5121g(Bundle bundle) {
        return bundle.getString(getName());
    }
}
