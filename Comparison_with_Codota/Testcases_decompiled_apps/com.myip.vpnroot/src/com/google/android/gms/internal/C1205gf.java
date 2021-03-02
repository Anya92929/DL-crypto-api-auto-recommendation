package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

@C1130ez
/* renamed from: com.google.android.gms.internal.gf */
public final class C1205gf {

    /* renamed from: uf */
    private static final Object f3740uf = new Object();

    /* renamed from: we */
    private static String f3741we;

    /* renamed from: a */
    public static String m4598a(Context context, String str, String str2) {
        String str3;
        synchronized (f3740uf) {
            if (f3741we == null && !TextUtils.isEmpty(str)) {
                m4599b(context, str, str2);
            }
            str3 = f3741we;
        }
        return str3;
    }

    /* renamed from: b */
    private static void m4599b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class<?> cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (C1213gj.m4626a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f3741we = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f3741we = "err";
        }
    }

    /* renamed from: dj */
    public static String m4600dj() {
        String str;
        synchronized (f3740uf) {
            str = f3741we;
        }
        return str;
    }
}
