package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.be */
public final class C1008be {

    /* renamed from: a */
    private final List<String> f4724a;

    /* renamed from: b */
    private final Object f4725b;

    private C1008be(Object obj) {
        this.f4725b = C1009bf.m4528a(obj);
        this.f4724a = new ArrayList();
    }

    /* renamed from: a */
    public C1008be mo7604a(String str, Object obj) {
        this.f4724a.add(((String) C1009bf.m4528a(str)) + "=" + String.valueOf(obj));
        return this;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(100).append(this.f4725b.getClass().getSimpleName()).append('{');
        int size = this.f4724a.size();
        for (int i = 0; i < size; i++) {
            append.append(this.f4724a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
