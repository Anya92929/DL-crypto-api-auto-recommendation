package p010uk.p011co.senab.photoview.log;

import android.util.Log;

/* renamed from: uk.co.senab.photoview.log.LoggerDefault */
public class LoggerDefault implements Logger {
    /* renamed from: v */
    public int mo13780v(String str, String str2) {
        return Log.v(str, str2);
    }

    /* renamed from: v */
    public int mo13781v(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    /* renamed from: d */
    public int mo13774d(String str, String str2) {
        return Log.d(str, str2);
    }

    /* renamed from: d */
    public int mo13775d(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    /* renamed from: i */
    public int mo13778i(String str, String str2) {
        return Log.i(str, str2);
    }

    /* renamed from: i */
    public int mo13779i(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    /* renamed from: w */
    public int mo13782w(String str, String str2) {
        return Log.w(str, str2);
    }

    /* renamed from: w */
    public int mo13783w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    /* renamed from: e */
    public int mo13776e(String str, String str2) {
        return Log.e(str, str2);
    }

    /* renamed from: e */
    public int mo13777e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }
}
