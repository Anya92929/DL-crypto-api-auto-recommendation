package com.google.android.gms.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.n */
public final class C0608n {

    /* renamed from: bX */
    private final String f1426bX;

    public C0608n(String str) {
        this.f1426bX = (String) C0621s.m1890d(str);
    }

    /* renamed from: a */
    public void mo5459a(String str, String str2) {
        if (mo5464l(3)) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public void mo5460a(String str, String str2, Throwable th) {
        if (mo5464l(6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: b */
    public void mo5461b(String str, String str2) {
        if (mo5464l(5)) {
            Log.w(str, str2);
        }
    }

    /* renamed from: c */
    public void mo5462c(String str, String str2) {
        if (mo5464l(6)) {
            Log.e(str, str2);
        }
    }

    /* renamed from: d */
    public void mo5463d(String str, String str2) {
        if (mo5464l(4)) {
        }
    }

    /* renamed from: l */
    public boolean mo5464l(int i) {
        return Log.isLoggable(this.f1426bX, i);
    }
}
