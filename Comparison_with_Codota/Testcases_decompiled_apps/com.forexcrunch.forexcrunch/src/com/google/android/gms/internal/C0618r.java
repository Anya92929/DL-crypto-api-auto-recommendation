package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.r */
public final class C0618r {

    /* renamed from: com.google.android.gms.internal.r$a */
    public static final class C0620a {

        /* renamed from: bY */
        private final List<String> f1430bY;

        /* renamed from: bZ */
        private final Object f1431bZ;

        private C0620a(Object obj) {
            this.f1431bZ = C0621s.m1890d(obj);
            this.f1430bY = new ArrayList();
        }

        /* renamed from: a */
        public C0620a mo5486a(String str, Object obj) {
            this.f1430bY.add(((String) C0621s.m1890d(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f1431bZ.getClass().getSimpleName()).append('{');
            int size = this.f1430bY.size();
            for (int i = 0; i < size; i++) {
                append.append(this.f1430bY.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    /* renamed from: a */
    public static boolean m1881a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: c */
    public static C0620a m1882c(Object obj) {
        return new C0620a(obj);
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
