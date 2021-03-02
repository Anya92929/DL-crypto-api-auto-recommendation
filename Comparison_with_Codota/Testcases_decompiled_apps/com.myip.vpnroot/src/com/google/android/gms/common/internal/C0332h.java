package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.C1597ne;

/* renamed from: com.google.android.gms.common.internal.h */
public final class C0332h {

    /* renamed from: LX */
    private final String f789LX;

    public C0332h(String str) {
        this.f789LX = (String) C0348n.m861i(str);
    }

    /* renamed from: a */
    public void mo4488a(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            sb.append(stackTrace[i].toString());
            sb.append("\n");
            i++;
        }
        C1597ne neVar = new C1597ne(context, 10);
        neVar.mo9501a("GMS_WTF", (byte[]) null, "GMS_WTF", sb.toString());
        neVar.send();
        if (mo4490aC(7)) {
            Log.e(str, str2, th);
            Log.wtf(str, str2, th);
        }
    }

    /* renamed from: a */
    public void mo4489a(String str, String str2, Throwable th) {
        if (mo4490aC(4)) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: aC */
    public boolean mo4490aC(int i) {
        return Log.isLoggable(this.f789LX, i);
    }

    /* renamed from: b */
    public void mo4491b(String str, String str2, Throwable th) {
        if (mo4490aC(5)) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: c */
    public void mo4492c(String str, String str2, Throwable th) {
        if (mo4490aC(6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: n */
    public void mo4493n(String str, String str2) {
        if (mo4490aC(3)) {
            Log.d(str, str2);
        }
    }

    /* renamed from: o */
    public void mo4494o(String str, String str2) {
        if (mo4490aC(2)) {
            Log.v(str, str2);
        }
    }

    /* renamed from: p */
    public void mo4495p(String str, String str2) {
        if (mo4490aC(5)) {
            Log.w(str, str2);
        }
    }

    /* renamed from: q */
    public void mo4496q(String str, String str2) {
        if (mo4490aC(6)) {
            Log.e(str, str2);
        }
    }
}
