package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.dl */
public final class C0408dl {

    /* renamed from: com.google.android.gms.internal.dl$a */
    public static final class C0410a {

        /* renamed from: lj */
        private final List<String> f1135lj;

        /* renamed from: lk */
        private final Object f1136lk;

        private C0410a(Object obj) {
            this.f1136lk = C0411dm.m944e(obj);
            this.f1135lj = new ArrayList();
        }

        /* renamed from: a */
        public C0410a mo4388a(String str, Object obj) {
            this.f1135lj.add(((String) C0411dm.m944e(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f1136lk.getClass().getSimpleName()).append('{');
            int size = this.f1135lj.size();
            for (int i = 0; i < size; i++) {
                append.append(this.f1135lj.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    /* renamed from: d */
    public static C0410a m938d(Object obj) {
        return new C0410a(obj);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
