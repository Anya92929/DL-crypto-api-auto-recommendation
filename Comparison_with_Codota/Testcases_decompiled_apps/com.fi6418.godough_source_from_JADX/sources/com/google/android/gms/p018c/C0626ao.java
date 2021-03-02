package com.google.android.gms.p018c;

import android.text.TextUtils;
import com.google.android.gms.p018c.C0626ao;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.c.ao */
public abstract class C0626ao<T extends C0626ao> {
    /* renamed from: a */
    public static String m3607a(Object obj) {
        return m3608a(obj, 0);
    }

    /* renamed from: a */
    private static String m3608a(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuffer stringBuffer = new StringBuffer();
            if (i > 0) {
                stringBuffer.append("[");
            }
            int length = stringBuffer.length();
            for (Object next : (List) obj) {
                if (stringBuffer.length() > length) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(m3608a(next, i + 1));
            }
            if (i > 0) {
                stringBuffer.append("]");
            }
            return stringBuffer.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            boolean z = false;
            for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
                String a = m3608a(entry.getValue(), i + 1);
                if (!TextUtils.isEmpty(a)) {
                    if (i > 0 && !z) {
                        stringBuffer2.append("{");
                        z = true;
                        i2 = stringBuffer2.length();
                    }
                    if (stringBuffer2.length() > i2) {
                        stringBuffer2.append(", ");
                    }
                    stringBuffer2.append((String) entry.getKey());
                    stringBuffer2.append('=');
                    stringBuffer2.append(a);
                }
            }
            if (z) {
                stringBuffer2.append("}");
            }
            return stringBuffer2.toString();
        }
    }

    /* renamed from: a */
    public static String m3609a(Map map) {
        return m3608a(map, 1);
    }

    /* renamed from: a */
    public abstract void mo7010a(T t);
}
