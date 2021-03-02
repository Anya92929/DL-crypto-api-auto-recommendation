package p000;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: js */
public abstract class C1334js<F extends Format> {

    /* renamed from: a */
    private final ConcurrentMap<C1335a, F> f4601a = new ConcurrentHashMap(7);

    /* renamed from: b */
    private final ConcurrentMap<C1335a, String> f4602b = new ConcurrentHashMap(7);

    /* renamed from: b */
    public abstract F mo8863b(String str, TimeZone timeZone, Locale locale);

    /* renamed from: c */
    public F mo8864c(String str, TimeZone timeZone, Locale locale) {
        if (str == null) {
            throw new NullPointerException("pattern must not be null");
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        C1335a aVar = new C1335a(str, timeZone, locale);
        F f = (Format) this.f4601a.get(aVar);
        if (f != null) {
            return f;
        }
        F b = mo8863b(str, timeZone, locale);
        F f2 = (Format) this.f4601a.putIfAbsent(aVar, b);
        return f2 != null ? f2 : b;
    }

    /* renamed from: a */
    public F mo8862a(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        DateFormat dateTimeInstance;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        C1335a aVar = new C1335a(num, num2, locale);
        String str = (String) this.f4602b.get(aVar);
        if (str == null) {
            if (num == null) {
                try {
                    dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("No date time pattern for locale: " + locale);
                }
            } else if (num2 == null) {
                dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
            }
            String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
            str = this.f4602b.putIfAbsent(aVar, pattern);
            if (str == null) {
                str = pattern;
            }
        }
        return mo8864c(str, timeZone, locale);
    }

    /* renamed from: js$a */
    static class C1335a {

        /* renamed from: a */
        private final Object[] f4603a;

        /* renamed from: b */
        private int f4604b;

        public C1335a(Object... objArr) {
            this.f4603a = objArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1335a)) {
                return false;
            }
            return Arrays.equals(this.f4603a, ((C1335a) obj).f4603a);
        }

        public int hashCode() {
            int i = 0;
            if (this.f4604b == 0) {
                for (Object obj : this.f4603a) {
                    if (obj != null) {
                        i = (i * 7) + obj.hashCode();
                    }
                }
                this.f4604b = i;
            }
            return this.f4604b;
        }
    }
}
