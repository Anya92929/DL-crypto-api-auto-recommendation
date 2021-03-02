package com.google.android.gms.internal;

import java.util.List;

/* renamed from: com.google.android.gms.internal.ki */
public class C1414ki {
    /* renamed from: a */
    public static <T> boolean m5254a(List<T> list, List<T> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (T contains : list) {
            if (!list2.contains(contains)) {
                return false;
            }
        }
        return true;
    }
}
