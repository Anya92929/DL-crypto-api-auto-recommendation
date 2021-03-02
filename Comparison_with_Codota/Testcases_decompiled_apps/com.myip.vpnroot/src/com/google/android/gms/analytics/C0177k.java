package com.google.android.gms.analytics;

import android.util.Log;

/* renamed from: com.google.android.gms.analytics.k */
class C0177k implements Logger {

    /* renamed from: xW */
    private int f185xW = 2;

    C0177k() {
    }

    /* renamed from: ae */
    private String m197ae(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.f185xW <= 3) {
            Log.e("GAV4", (String) null, exception);
        }
    }

    public void error(String msg) {
        if (this.f185xW <= 3) {
            Log.e("GAV4", m197ae(msg));
        }
    }

    public int getLogLevel() {
        return this.f185xW;
    }

    public void info(String msg) {
        if (this.f185xW <= 1) {
            Log.i("GAV4", m197ae(msg));
        }
    }

    public void setLogLevel(int level) {
        this.f185xW = level;
    }

    public void verbose(String msg) {
        if (this.f185xW <= 0) {
            Log.v("GAV4", m197ae(msg));
        }
    }

    public void warn(String msg) {
        if (this.f185xW <= 2) {
            Log.w("GAV4", m197ae(msg));
        }
    }
}
