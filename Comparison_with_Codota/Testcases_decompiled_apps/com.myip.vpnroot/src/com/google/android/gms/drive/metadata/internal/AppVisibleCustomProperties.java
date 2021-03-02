package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new C0499a();

    /* renamed from: Py */
    public static final AppVisibleCustomProperties f1097Py = new C0498a().mo5131im();

    /* renamed from: BR */
    final int f1098BR;

    /* renamed from: Pz */
    final List<CustomProperty> f1099Pz;

    /* renamed from: com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a */
    public static class C0498a {

        /* renamed from: PA */
        private final Map<CustomPropertyKey, CustomProperty> f1100PA = new HashMap();

        /* renamed from: im */
        public AppVisibleCustomProperties mo5131im() {
            return new AppVisibleCustomProperties((Collection) this.f1100PA.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.f1098BR = versionCode;
        C0348n.m861i(properties);
        this.f1099Pz = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, properties);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.f1099Pz.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0499a.m1390a(this, dest, flags);
    }
}
