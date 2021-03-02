package com.jackhenry.android.p022a;

import java.util.Calendar;

/* renamed from: com.jackhenry.android.a.a */
public class C1348a {
    /* renamed from: a */
    public static void m5553a(Calendar calendar) {
        m5554a(calendar, 0, 0, 0, 0);
    }

    /* renamed from: a */
    public static void m5554a(Calendar calendar, int i, int i2, int i3, int i4) {
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, i3);
        calendar.set(14, i4);
    }

    /* renamed from: a */
    public static boolean m5555a(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            return false;
        }
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    /* renamed from: b */
    public static void m5556b(Calendar calendar) {
        m5554a(calendar, 23, 59, 59, 0);
    }
}
