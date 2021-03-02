package com.jackhenry.godough.p028c.p029a.p030a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0469d;
import com.google.p008a.C0481k;
import com.google.p008a.C0488r;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.p027b.C1391f;
import com.jackhenry.godough.p028c.p029a.p030a.p031a.C1398a;
import com.jackhenry.godough.p028c.p029a.p030a.p031a.C1399b;
import com.jackhenry.godough.p043d.C1945a;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: com.jackhenry.godough.c.a.a.b */
public class C1400b extends C1402d {

    /* renamed from: a */
    private Type f5750a;

    public C1400b(Type type) {
        this.f5750a = type;
    }

    /* renamed from: a */
    private static C0481k m5671a() {
        return new C0488r().mo6528a(C0469d.UPPER_CAMEL_CASE).mo6527a().mo6529a(GregorianCalendar.class, new C1398a()).mo6529a(Calendar.class, new C1398a()).mo6529a(Settings.Texture.class, new C1399b()).mo6530b();
    }

    /* renamed from: a */
    public Object mo9450a(Object obj) {
        try {
            String a = m5671a().mo6516a(obj, (Type) obj.getClass());
            C1945a.m6997b("Output: " + a);
            return a;
        } catch (Exception e) {
            throw new C1391f("Failed to serialize to JSON.", (Throwable) e);
        }
    }

    /* renamed from: a */
    public Object mo9445a(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            C1945a.m6998c("Input: " + str);
            return m5671a().mo6515a(str, this.f5750a);
        } catch (C0356ae e) {
            throw new C1391f("Failed to parse JSON results.", (Throwable) e);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            throw new C1391f("Failed to read response.", (Throwable) e2);
        }
    }
}
