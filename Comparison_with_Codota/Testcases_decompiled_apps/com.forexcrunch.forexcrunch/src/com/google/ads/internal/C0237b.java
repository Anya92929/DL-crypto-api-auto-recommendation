package com.google.ads.internal;

import com.google.ads.util.C0284b;

/* renamed from: com.google.ads.internal.b */
public final class C0237b extends Exception {

    /* renamed from: a */
    public final boolean f479a;

    public C0237b(String str, boolean z) {
        super(str);
        this.f479a = z;
    }

    public C0237b(String str, boolean z, Throwable th) {
        super(str, th);
        this.f479a = z;
    }

    /* renamed from: a */
    public void mo3485a(String str) {
        C0284b.m484b(mo3487c(str));
        C0284b.m481a((String) null, (Throwable) this);
    }

    /* renamed from: b */
    public void mo3486b(String str) {
        String c = mo3487c(str);
        if (!this.f479a) {
            this = null;
        }
        throw new RuntimeException(c, this);
    }

    /* renamed from: c */
    public String mo3487c(String str) {
        if (this.f479a) {
            return str + ": " + getMessage();
        }
        return str;
    }
}
