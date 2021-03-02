package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.ip */
public class C1334ip {

    /* renamed from: GX */
    private static boolean f4025GX = false;

    /* renamed from: GY */
    private boolean f4026GY;

    /* renamed from: GZ */
    private boolean f4027GZ;

    /* renamed from: Ha */
    private String f4028Ha;
    private final String mTag;

    public C1334ip(String str) {
        this(str, m5035fT());
    }

    public C1334ip(String str, boolean z) {
        this.mTag = str;
        this.f4026GY = z;
        this.f4027GZ = false;
    }

    /* renamed from: e */
    private String m5034e(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        return !TextUtils.isEmpty(this.f4028Ha) ? this.f4028Ha + str : str;
    }

    /* renamed from: fT */
    public static boolean m5035fT() {
        return f4025GX;
    }

    /* renamed from: a */
    public void mo8907a(String str, Object... objArr) {
        if (mo8914fS()) {
            Log.v(this.mTag, m5034e(str, objArr));
        }
    }

    /* renamed from: a */
    public void mo8908a(Throwable th, String str, Object... objArr) {
        if (mo8913fR() || f4025GX) {
            Log.d(this.mTag, m5034e(str, objArr), th);
        }
    }

    /* renamed from: aK */
    public void mo8909aK(String str) {
        String format;
        if (TextUtils.isEmpty(str)) {
            format = null;
        } else {
            format = String.format("[%s] ", new Object[]{str});
        }
        this.f4028Ha = format;
    }

    /* renamed from: b */
    public void mo8910b(String str, Object... objArr) {
        if (mo8913fR() || f4025GX) {
            Log.d(this.mTag, m5034e(str, objArr));
        }
    }

    /* renamed from: c */
    public void mo8911c(String str, Object... objArr) {
        Log.i(this.mTag, m5034e(str, objArr));
    }

    /* renamed from: d */
    public void mo8912d(String str, Object... objArr) {
        Log.w(this.mTag, m5034e(str, objArr));
    }

    /* renamed from: fR */
    public boolean mo8913fR() {
        return this.f4026GY;
    }

    /* renamed from: fS */
    public boolean mo8914fS() {
        return this.f4027GZ;
    }
}
