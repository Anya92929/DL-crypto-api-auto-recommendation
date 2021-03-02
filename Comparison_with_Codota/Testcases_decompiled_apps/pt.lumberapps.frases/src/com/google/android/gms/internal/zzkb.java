package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.math.BigInteger;
import java.util.Locale;

@zzin
public final class zzkb {

    /* renamed from: a */
    private static final Object f6605a = new Object();

    /* renamed from: b */
    private static String f6606b;

    /* renamed from: a */
    private static void m7300a(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class<?> cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (zzu.zzfq().zza(classLoader, (Class) cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f6606b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f6606b = "err";
        }
    }

    public static String zza(Context context, String str, String str2) {
        String str3;
        synchronized (f6605a) {
            if (f6606b == null && !TextUtils.isEmpty(str)) {
                m7300a(context, str, str2);
            }
            str3 = f6606b;
        }
        return str3;
    }

    public static String zzsy() {
        String str;
        synchronized (f6605a) {
            str = f6606b;
        }
        return str;
    }
}
