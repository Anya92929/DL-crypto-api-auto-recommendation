package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;

/* renamed from: com.google.android.gms.common.data.a */
final class C1346a extends DataHolder.zza {
    C1346a(String[] strArr, String str) {
        super(strArr, str, (C1346a) null);
    }

    public DataHolder.zza zza(ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    public DataHolder.zza zza(HashMap hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
