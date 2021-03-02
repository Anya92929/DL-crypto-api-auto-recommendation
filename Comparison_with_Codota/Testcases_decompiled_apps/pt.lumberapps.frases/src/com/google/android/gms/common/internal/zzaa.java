package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzaa {

    public final class zza {

        /* renamed from: a */
        private final List f4515a;

        /* renamed from: b */
        private final Object f4516b;

        private zza(Object obj) {
            this.f4516b = zzab.zzy(obj);
            this.f4515a = new ArrayList();
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f4516b.getClass().getSimpleName()).append('{');
            int size = this.f4515a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f4515a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            List list = this.f4515a;
            String str2 = (String) zzab.zzy(str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzx(Object obj) {
        return new zza(obj);
    }
}
