package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.internal.am */
final class C0989am {

    /* renamed from: a */
    private final String f4704a;

    /* renamed from: b */
    private final ComponentName f4705b = null;

    public C0989am(String str) {
        this.f4704a = C1009bf.m4530a(str);
    }

    /* renamed from: a */
    public Intent mo7530a() {
        return this.f4704a != null ? new Intent(this.f4704a).setPackage("com.google.android.gms") : new Intent().setComponent(this.f4705b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0989am)) {
            return false;
        }
        C0989am amVar = (C0989am) obj;
        return C1006bc.m4525a(this.f4704a, amVar.f4704a) && C1006bc.m4525a(this.f4705b, amVar.f4705b);
    }

    public int hashCode() {
        return C1006bc.m4523a(this.f4704a, this.f4705b);
    }

    public String toString() {
        return this.f4704a == null ? this.f4705b.flattenToString() : this.f4704a;
    }
}
