package com.jackhenry.android.p022a;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.jackhenry.android.a.k */
public class C1364k {

    /* renamed from: a */
    private static Pattern f5571a = Pattern.compile(".*@.*\\..*", 32);

    /* renamed from: a */
    private static int m5585a(int i, int i2) {
        if (i2 <= 8) {
            return ((byte) (((byte) (i >> i2)) ^ -1)) & 255;
        }
        throw new ArithmeticException("shift must be less than or equal to 8");
    }

    /* renamed from: a */
    public static String m5586a(double d) {
        return m5590b(d / 100.0d);
    }

    /* renamed from: a */
    public static String m5587a(double d, int i) {
        NumberFormat instance = NumberFormat.getInstance();
        instance.setGroupingUsed(true);
        instance.setMinimumFractionDigits(i);
        instance.setMaximumFractionDigits(i);
        return instance.format(d);
    }

    /* renamed from: a */
    public static String m5588a(Calendar calendar) {
        return calendar == null ? "" : new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(calendar.getTime());
    }

    /* renamed from: a */
    public static boolean m5589a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: b */
    public static String m5590b(double d) {
        NumberFormat instance = NumberFormat.getInstance();
        instance.setGroupingUsed(true);
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        return "$" + instance.format(d);
    }

    /* renamed from: b */
    public static boolean m5591b(String str) {
        return !m5589a(str);
    }

    /* renamed from: c */
    public static boolean m5592c(String str) {
        return f5571a.matcher(str).matches() || str.trim().length() == 0;
    }

    /* renamed from: d */
    public static String m5593d(String str) {
        int i = 0;
        try {
            int parseInt = Integer.parseInt(str.substring(0, 2), 16);
            if (parseInt <= 8) {
                i = parseInt;
            }
        } catch (NumberFormatException e) {
        }
        StringBuilder sb = new StringBuilder();
        if (str.length() > 2) {
            for (int i2 = 2; i2 < str.length(); i2 += 8) {
                try {
                    sb.append(Character.toChars((m5585a(Integer.parseInt(str.substring(i2, i2 + 4), 16), i) << 8) | (m5585a(Integer.parseInt(str.substring(i2 + 4, i2 + 8), 16), i) & 255))[0]);
                } catch (Exception e2) {
                    sb.append("f");
                }
            }
        } else {
            sb.append("fffffffffffffffffffff");
        }
        return sb.toString();
    }
}
