package com.jackhenry.godough.core.p038e;

import android.annotation.SuppressLint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* renamed from: com.jackhenry.godough.core.e.i */
public class C1580i {
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a */
    private static SimpleDateFormat f6156a = new SimpleDateFormat("MM/dd/yyyy");

    /* renamed from: a */
    public static String m6152a(long j) {
        return new DecimalFormat("$#,##0.00;($#,##0.00)").format(((double) j) / 100.0d);
    }

    /* renamed from: a */
    public static String m6153a(long j, boolean z) {
        long abs = Math.abs(j);
        if (!z) {
            abs *= -1;
        }
        return new DecimalFormat("$#,###.00;($#,###.00)").format(((double) abs) / 100.0d);
    }

    /* renamed from: a */
    public static String m6154a(Calendar calendar) {
        return calendar == null ? "" : f6156a.format(calendar.getTime());
    }

    /* renamed from: b */
    public static String m6155b(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        f6156a.applyPattern("yyyy-MM-dd'T'HH:mm:ss");
        String format = f6156a.format(calendar.getTime());
        f6156a.applyPattern("MM/dd/yyyy");
        return format;
    }
}
