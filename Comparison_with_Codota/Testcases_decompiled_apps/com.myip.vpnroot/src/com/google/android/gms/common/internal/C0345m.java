package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.m */
public final class C0345m {

    /* renamed from: com.google.android.gms.common.internal.m$a */
    public static final class C0347a {

        /* renamed from: LY */
        private final List<String> f794LY;

        /* renamed from: LZ */
        private final Object f795LZ;

        private C0347a(Object obj) {
            this.f795LZ = C0348n.m861i(obj);
            this.f794LY = new ArrayList();
        }

        /* renamed from: a */
        public C0347a mo4549a(String str, Object obj) {
            this.f794LY.add(((String) C0348n.m861i(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f795LZ.getClass().getSimpleName()).append('{');
            int size = this.f794LY.size();
            for (int i = 0; i < size; i++) {
                append.append(this.f794LY.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    /* renamed from: h */
    public static C0347a m848h(Object obj) {
        return new C0347a(obj);
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
