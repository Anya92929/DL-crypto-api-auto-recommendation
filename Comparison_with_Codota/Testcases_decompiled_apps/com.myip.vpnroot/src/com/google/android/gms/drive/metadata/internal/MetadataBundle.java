package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.C0294a;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.C0478v;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.C1395kd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new C0506h();

    /* renamed from: BR */
    final int f1103BR;

    /* renamed from: PD */
    final Bundle f1104PD;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.f1103BR = versionCode;
        this.f1104PD = (Bundle) C0348n.m861i(valueBundle);
        this.f1104PD.setClassLoader(getClass().getClassLoader());
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f1104PD.keySet()) {
            if (C0503e.m1409bj(str) == null) {
                arrayList.add(str);
                C0478v.m1343p("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String remove : arrayList) {
            this.f1104PD.remove(remove);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    /* renamed from: a */
    public static <T> MetadataBundle m1384a(MetadataField<T> metadataField, T t) {
        MetadataBundle io = m1386io();
        io.mo5135b(metadataField, t);
        return io;
    }

    /* renamed from: a */
    public static MetadataBundle m1385a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.f1104PD));
    }

    /* renamed from: io */
    public static MetadataBundle m1386io() {
        return new MetadataBundle(new Bundle());
    }

    /* renamed from: a */
    public <T> T mo5134a(MetadataField<T> metadataField) {
        return metadataField.mo5116f(this.f1104PD);
    }

    /* renamed from: b */
    public <T> void mo5135b(MetadataField<T> metadataField, T t) {
        if (C0503e.m1409bj(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.mo5115a(t, this.f1104PD);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.f1104PD.keySet();
        if (!keySet.equals(metadataBundle.f1104PD.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!C0345m.equal(this.f1104PD.get(str), metadataBundle.f1104PD.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        Iterator it = this.f1104PD.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = this.f1104PD.get((String) it.next()).hashCode() + (i2 * 31);
        }
    }

    /* renamed from: ip */
    public Set<MetadataField<?>> mo5139ip() {
        HashSet hashSet = new HashSet();
        for (String bj : this.f1104PD.keySet()) {
            hashSet.add(C0503e.m1409bj(bj));
        }
        return hashSet;
    }

    public void setContext(Context context) {
        C0294a aVar = (C0294a) mo5134a(C1395kd.f4169Qd);
        if (aVar != null) {
            aVar.mo4325a(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.f1104PD + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0506h.m1423a(this, dest, flags);
    }
}
