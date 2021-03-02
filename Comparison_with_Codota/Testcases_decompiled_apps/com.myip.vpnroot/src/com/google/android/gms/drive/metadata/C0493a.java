package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.metadata.a */
public abstract class C0493a<T> implements MetadataField<T> {

    /* renamed from: Pt */
    private final String f1093Pt;

    /* renamed from: Pu */
    private final Set<String> f1094Pu;

    /* renamed from: Pv */
    private final Set<String> f1095Pv;

    /* renamed from: Pw */
    private final int f1096Pw;

    protected C0493a(String str, int i) {
        this.f1093Pt = (String) C0348n.m857b(str, (Object) "fieldName");
        this.f1094Pu = Collections.singleton(str);
        this.f1095Pv = Collections.emptySet();
        this.f1096Pw = i;
    }

    protected C0493a(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.f1093Pt = (String) C0348n.m857b(str, (Object) "fieldName");
        this.f1094Pu = Collections.unmodifiableSet(new HashSet(collection));
        this.f1095Pv = Collections.unmodifiableSet(new HashSet(collection2));
        this.f1096Pw = i;
    }

    /* renamed from: a */
    public final T mo5113a(DataHolder dataHolder, int i, int i2) {
        if (mo5119b(dataHolder, i, i2)) {
            return mo5120c(dataHolder, i, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5118a(Bundle bundle, T t);

    /* renamed from: a */
    public final void mo5114a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        C0348n.m857b(dataHolder, (Object) "dataHolder");
        C0348n.m857b(metadataBundle, (Object) "bundle");
        metadataBundle.mo5135b(this, mo5113a(dataHolder, i, i2));
    }

    /* renamed from: a */
    public final void mo5115a(T t, Bundle bundle) {
        C0348n.m857b(bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), (String) null);
        } else {
            mo5118a(bundle, t);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo5119b(DataHolder dataHolder, int i, int i2) {
        for (String h : this.f1094Pu) {
            if (dataHolder.mo4322h(h, i, i2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract T mo5120c(DataHolder dataHolder, int i, int i2);

    /* renamed from: f */
    public final T mo5116f(Bundle bundle) {
        C0348n.m857b(bundle, (Object) "bundle");
        if (bundle.get(getName()) != null) {
            return mo5121g(bundle);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract T mo5121g(Bundle bundle);

    public final String getName() {
        return this.f1093Pt;
    }

    public String toString() {
        return this.f1093Pt;
    }
}
