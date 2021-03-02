package com.google.android.gms.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.dh */
public final class C0398dh {

    /* renamed from: li */
    private final String f1131li;

    public C0398dh(String str) {
        this.f1131li = (String) C0411dm.m944e(str);
    }

    /* renamed from: a */
    public void mo4359a(String str, String str2, Throwable th) {
        if (mo4364x(6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: b */
    public void mo4360b(String str, String str2) {
        if (mo4364x(3)) {
            Log.d(str, str2);
        }
    }

    /* renamed from: c */
    public void mo4361c(String str, String str2) {
        if (mo4364x(5)) {
            Log.w(str, str2);
        }
    }

    /* renamed from: d */
    public void mo4362d(String str, String str2) {
        if (mo4364x(6)) {
            Log.e(str, str2);
        }
    }

    /* renamed from: e */
    public void mo4363e(String str, String str2) {
        if (mo4364x(4)) {
        }
    }

    /* renamed from: x */
    public boolean mo4364x(int i) {
        return Log.isLoggable(this.f1131li, i);
    }
}
