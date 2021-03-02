package com.google.android.gms.internal;

public class zzamz extends RuntimeException {
    public zzamz(String str) {
        super(str);
    }

    public zzamz(String str, Throwable th) {
        super(str, th);
    }

    public zzamz(Throwable th) {
        super(th);
    }
}
