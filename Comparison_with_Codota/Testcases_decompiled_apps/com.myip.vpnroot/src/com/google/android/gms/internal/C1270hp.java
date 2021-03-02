package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.hp */
public class C1270hp {

    /* renamed from: Cm */
    private static final String[] f3862Cm = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};

    /* renamed from: Cn */
    private static final Map<String, Integer> f3863Cn = new HashMap(f3862Cm.length);

    static {
        for (int i = 0; i < f3862Cm.length; i++) {
            f3863Cn.put(f3862Cm[i], Integer.valueOf(i));
        }
    }

    /* renamed from: O */
    public static String m4782O(int i) {
        if (i < 0 || i >= f3862Cm.length) {
            return null;
        }
        return f3862Cm[i];
    }

    /* renamed from: as */
    public static int m4783as(String str) {
        Integer num = f3863Cn.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    /* renamed from: fm */
    public static int m4784fm() {
        return f3862Cm.length;
    }
}
