package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0494b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.internal.i */
public class C0507i<T extends Parcelable> extends C0494b<T> {
    public C0507i(String str, int i) {
        super(str, Collections.emptySet(), Collections.singleton(str), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public Collection<T> mo5121g(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
