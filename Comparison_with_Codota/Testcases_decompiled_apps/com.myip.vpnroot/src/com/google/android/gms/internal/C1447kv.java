package com.google.android.gms.internal;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.fitness.data.DataSource;

/* renamed from: com.google.android.gms.internal.kv */
public class C1447kv {

    /* renamed from: To */
    private static final ThreadLocal<String> f4197To = new ThreadLocal<>();

    /* renamed from: bq */
    public static String m5334bq(String str) {
        return m5337s(str, f4197To.get());
    }

    /* renamed from: c */
    public static DataSource m5335c(DataSource dataSource) {
        if (!dataSource.mo5665iJ()) {
            return dataSource;
        }
        return (m5336iU() || f4197To.get().equals(dataSource.getAppPackageName())) ? dataSource : dataSource.mo5666iK();
    }

    /* renamed from: iU */
    public static boolean m5336iU() {
        String str = f4197To.get();
        return str == null || str.startsWith(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    /* renamed from: s */
    private static String m5337s(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        byte[] bArr = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, bArr, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, bArr, str.length(), str2.length());
        return Integer.toHexString(C1393kb.m5236a(bArr, 0, bArr.length, 0));
    }
}
