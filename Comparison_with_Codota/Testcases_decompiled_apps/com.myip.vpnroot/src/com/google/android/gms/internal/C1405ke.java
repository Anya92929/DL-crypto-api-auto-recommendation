package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C0508j;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.google.android.gms.internal.ke */
public class C1405ke extends C0508j<AppVisibleCustomProperties> {
    public C1405ke(int i) {
        super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[]{"customPropertiesExtra"}), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public AppVisibleCustomProperties mo5120c(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.mo4321gz().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.f1097Py);
    }
}
