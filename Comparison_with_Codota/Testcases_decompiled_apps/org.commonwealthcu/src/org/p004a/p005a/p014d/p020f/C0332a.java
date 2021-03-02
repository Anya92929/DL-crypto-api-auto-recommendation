package org.p004a.p005a.p014d.p020f;

import java.util.regex.Pattern;

/* renamed from: org.a.a.d.f.a */
public final class C0332a {

    /* renamed from: a */
    private static final Pattern f171a = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    /* renamed from: b */
    private static final Pattern f172b = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");

    /* renamed from: c */
    private static final Pattern f173c = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");

    static {
        Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    }

    /* renamed from: a */
    public static boolean m317a(String str) {
        return f171a.matcher(str).matches();
    }

    /* renamed from: b */
    public static boolean m318b(String str) {
        if (!f172b.matcher(str).matches()) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) == ':') {
                    i++;
                }
            }
            if (!(i <= 7 && f173c.matcher(str).matches())) {
                return false;
            }
        }
        return true;
    }
}
