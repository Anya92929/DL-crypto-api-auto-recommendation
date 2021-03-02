package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqt;
import org.apache.commons.p009io.IOUtils;

public final class zzo {

    /* renamed from: a */
    private static final String f3026a = null;
    public static final int zzaml = (23 - " PII_LOG".length());

    /* renamed from: b */
    private final String f3027b;

    /* renamed from: c */
    private final String f3028c;

    public zzo(String str) {
        this(str, f3026a);
    }

    public zzo(String str, String str2) {
        zzx.zzb(str, (Object) "log tag cannot be null");
        zzx.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f3027b = str;
        if (str2 == null || str2.length() <= 0) {
            this.f3028c = f3026a;
        } else {
            this.f3028c = str2;
        }
    }

    /* renamed from: a */
    private String m3952a(String str) {
        return this.f3028c == null ? str : this.f3028c.concat(str);
    }

    public void zzA(String str, String str2) {
        if (zzbU(6)) {
            Log.e(str, m3952a(str2));
        }
    }

    public void zza(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            sb.append(stackTrace[i].toString());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            i++;
        }
        zzqt zzqt = new zzqt(context, 10);
        zzqt.zza("GMS_WTF", (byte[]) null, "GMS_WTF", sb.toString());
        zzqt.send();
        if (zzbU(7)) {
            Log.e(str, m3952a(str2), th);
            Log.wtf(str, m3952a(str2), th);
        }
    }

    public void zza(String str, String str2, Throwable th) {
        if (zzbU(4)) {
            Log.i(str, m3952a(str2), th);
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzbU(5)) {
            Log.w(str, m3952a(str2), th);
        }
    }

    public boolean zzbU(int i) {
        return Log.isLoggable(this.f3027b, i);
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzbU(6)) {
            Log.e(str, m3952a(str2), th);
        }
    }

    public void zzy(String str, String str2) {
        if (zzbU(3)) {
            Log.d(str, m3952a(str2));
        }
    }

    public void zzz(String str, String str2) {
        if (zzbU(5)) {
            Log.w(str, m3952a(str2));
        }
    }
}
