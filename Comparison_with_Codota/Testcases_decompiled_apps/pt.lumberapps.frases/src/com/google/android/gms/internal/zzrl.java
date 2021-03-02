package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzp;

public class zzrl {

    /* renamed from: a */
    private final String f6967a;

    /* renamed from: b */
    private final String f6968b;

    /* renamed from: c */
    private final zzp f6969c;

    /* renamed from: d */
    private final int f6970d;

    private zzrl(String str, String str2) {
        this.f6968b = str2;
        this.f6967a = str;
        this.f6969c = new zzp(str);
        this.f6970d = m7549a();
    }

    public zzrl(String str, String... strArr) {
        this(str, m7550a(strArr));
    }

    /* renamed from: a */
    private int m7549a() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f6967a, i)) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private static String m7550a(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(' ');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9042a(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.f6968b.concat(str);
    }

    public void zza(String str, Object... objArr) {
        if (zzaz(2)) {
            Log.v(this.f6967a, mo9042a(str, objArr));
        }
    }

    public boolean zzaz(int i) {
        return this.f6970d <= i;
    }
}
