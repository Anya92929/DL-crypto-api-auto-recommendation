package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.internal.v */
final class C1383v {

    /* renamed from: a */
    private final String f4507a;

    /* renamed from: b */
    private final String f4508b;

    /* renamed from: c */
    private final ComponentName f4509c;

    public C1383v(ComponentName componentName) {
        this.f4507a = null;
        this.f4508b = null;
        this.f4509c = (ComponentName) zzab.zzy(componentName);
    }

    public C1383v(String str, String str2) {
        this.f4507a = zzab.zzhr(str);
        this.f4508b = zzab.zzhr(str2);
        this.f4509c = null;
    }

    /* renamed from: a */
    public Intent mo6624a() {
        return this.f4507a != null ? new Intent(this.f4507a).setPackage(this.f4508b) : new Intent().setComponent(this.f4509c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1383v)) {
            return false;
        }
        C1383v vVar = (C1383v) obj;
        return zzaa.equal(this.f4507a, vVar.f4507a) && zzaa.equal(this.f4509c, vVar.f4509c);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f4507a, this.f4509c);
    }

    public String toString() {
        return this.f4507a == null ? this.f4509c.flattenToString() : this.f4507a;
    }
}
