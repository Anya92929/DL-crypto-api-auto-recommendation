package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0496d;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C0502d extends C0496d<Date> {
    public C0502d(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Date mo5120c(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.mo4301a(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Date mo5121g(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
