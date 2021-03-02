package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public interface MetadataField<T> {
    /* renamed from: a */
    T mo5113a(DataHolder dataHolder, int i, int i2);

    /* renamed from: a */
    void mo5114a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    /* renamed from: a */
    void mo5115a(T t, Bundle bundle);

    /* renamed from: f */
    T mo5116f(Bundle bundle);

    String getName();
}
