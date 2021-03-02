package org.p004a.p005a.p007b.p012e;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: org.a.a.b.e.b */
final class C0282b {

    /* renamed from: a */
    private static final ThreadLocal f107a = new C0283c();

    /* renamed from: a */
    public static SimpleDateFormat m174a(String str) {
        HashMap hashMap;
        Map map = (Map) ((SoftReference) f107a.get()).get();
        if (map == null) {
            HashMap hashMap2 = new HashMap();
            f107a.set(new SoftReference(hashMap2));
            hashMap = hashMap2;
        } else {
            hashMap = map;
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) hashMap.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
        hashMap.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }
}
