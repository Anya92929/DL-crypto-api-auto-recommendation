package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;

public class BooleanResult implements Result {

    /* renamed from: a */
    private final Status f4302a;

    /* renamed from: b */
    private final boolean f4303b;

    public BooleanResult(Status status, boolean z) {
        this.f4302a = (Status) zzab.zzb((Object) status, (Object) "Status must not be null");
        this.f4303b = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f4302a.equals(booleanResult.f4302a) && this.f4303b == booleanResult.f4303b;
    }

    public Status getStatus() {
        return this.f4302a;
    }

    public boolean getValue() {
        return this.f4303b;
    }

    public final int hashCode() {
        return (this.f4303b ? 1 : 0) + ((this.f4302a.hashCode() + 527) * 31);
    }
}
