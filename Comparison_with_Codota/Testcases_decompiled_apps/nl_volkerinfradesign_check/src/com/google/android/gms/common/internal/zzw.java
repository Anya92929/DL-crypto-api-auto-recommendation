package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzw {

    public static final class zza {

        /* renamed from: a */
        private final List<String> f3036a;

        /* renamed from: b */
        private final Object f3037b;

        private zza(Object obj) {
            this.f3037b = zzx.zzz(obj);
            this.f3036a = new ArrayList();
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f3037b.getClass().getSimpleName()).append('{');
            int size = this.f3036a.size();
            for (int i = 0; i < size; i++) {
                append.append(this.f3036a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            this.f3036a.add(((String) zzx.zzz(str)) + "=" + String.valueOf(obj));
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzy(Object obj) {
        return new zza(obj);
    }
}
