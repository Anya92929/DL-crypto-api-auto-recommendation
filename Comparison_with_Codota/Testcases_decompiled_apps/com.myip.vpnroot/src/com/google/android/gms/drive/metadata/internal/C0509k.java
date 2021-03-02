package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0494b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.android.gms.drive.metadata.internal.k */
public class C0509k extends C0494b<String> {
    public C0509k(String str, int i) {
        super(str, Collections.singleton(str), Collections.emptySet(), i);
    }

    /* renamed from: bk */
    public static final Collection<String> m1434bk(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Collection<String> mo5120c(DataHolder dataHolder, int i, int i2) {
        try {
            return m1434bk(dataHolder.mo4306c(getName(), i, i2));
        } catch (JSONException e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public Collection<String> mo5121g(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
