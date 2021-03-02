package com.jackhenry.godough.p028c.p029a.p030a.p031a;

import com.google.p008a.C0353ab;
import com.google.p008a.C0354ac;
import com.google.p008a.C0355ad;
import com.google.p008a.C0491u;
import com.google.p008a.C0492v;
import com.google.p008a.C0493w;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* renamed from: com.jackhenry.godough.c.a.a.a.a */
public class C1398a implements C0355ad<Calendar>, C0492v<Calendar> {

    /* renamed from: a */
    private static String f5747a = "yyyy-MM-dd'T'HH:mm:ss";

    /* renamed from: b */
    private static String f5748b = "MM/dd/yyyy";

    /* renamed from: c */
    private SimpleDateFormat f5749c = new SimpleDateFormat();

    /* renamed from: a */
    public C0493w mo6285a(Calendar calendar, Type type, C0354ac acVar) {
        this.f5749c.applyPattern(f5747a);
        return new C0353ab(this.f5749c.format(calendar.getTime()));
    }

    /* renamed from: a */
    public Calendar mo6288b(C0493w wVar, Type type, C0491u uVar) {
        Calendar calendar = null;
        this.f5749c.applyPattern(f5747a);
        try {
            Date parse = this.f5749c.parse(wVar.mo6298b());
            calendar = Calendar.getInstance();
            calendar.setTime(parse);
            return calendar;
        } catch (ParseException e) {
            this.f5749c.applyPattern(f5748b);
            try {
                Date parse2 = this.f5749c.parse(wVar.mo6298b());
                calendar = Calendar.getInstance();
                calendar.setTime(parse2);
                return calendar;
            } catch (ParseException e2) {
                return calendar;
            }
        }
    }
}
