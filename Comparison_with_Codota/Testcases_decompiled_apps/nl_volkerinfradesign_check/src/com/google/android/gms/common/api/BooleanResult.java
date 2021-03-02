package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult implements Result {

    /* renamed from: a */
    private final Status f2621a;

    /* renamed from: b */
    private final boolean f2622b;

    public BooleanResult(Status status, boolean z) {
        this.f2621a = (Status) zzx.zzb(status, (Object) "Status must not be null");
        this.f2622b = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f2621a.equals(booleanResult.f2621a) && this.f2622b == booleanResult.f2622b;
    }

    public Status getStatus() {
        return this.f2621a;
    }

    public boolean getValue() {
        return this.f2622b;
    }

    public final int hashCode() {
        return (this.f2622b ? 1 : 0) + ((this.f2621a.hashCode() + 527) * 31);
    }
}
