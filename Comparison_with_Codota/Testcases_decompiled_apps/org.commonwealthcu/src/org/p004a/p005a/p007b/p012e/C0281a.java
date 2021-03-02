package org.p004a.p005a.p007b.p012e;

import com.vertifi.RDCGlobal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.b.e.a */
public final class C0281a {

    /* renamed from: a */
    private static final String[] f104a = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};

    /* renamed from: b */
    private static final Date f105b;

    /* renamed from: c */
    private static TimeZone f106c = TimeZone.getTimeZone("GMT");

    static {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(f106c);
        instance.set(RDCGlobal.FRONT_IMAGE, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        f105b = instance.getTime();
    }

    /* renamed from: a */
    public static Date m173a(String str, String[] strArr) {
        C0250b.m84a((Object) str, "Date value");
        if (strArr == null) {
            strArr = f104a;
        }
        Date date = f105b;
        if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1);
        }
        for (String a : strArr) {
            SimpleDateFormat a2 = C0282b.m174a(a);
            a2.set2DigitYearStart(date);
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = a2.parse(str, parsePosition);
            if (parsePosition.getIndex() != 0) {
                return parse;
            }
        }
        return null;
    }
}
