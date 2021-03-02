package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

/* renamed from: com.google.android.gms.internal.iv */
public abstract class C1342iv<T> {

    /* renamed from: JG */
    private static C1346a f4058JG = null;

    /* renamed from: mw */
    private static final Object f4059mw = new Object();

    /* renamed from: JH */
    protected final String f4060JH;

    /* renamed from: JI */
    protected final T f4061JI;

    /* renamed from: JJ */
    private T f4062JJ = null;

    /* renamed from: com.google.android.gms.internal.iv$a */
    private interface C1346a {
    }

    /* renamed from: com.google.android.gms.internal.iv$b */
    private static class C1347b implements C1346a {
        private final ContentResolver mContentResolver;

        public C1347b(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }
    }

    protected C1342iv(String str, T t) {
        this.f4060JH = str;
        this.f4061JI = t;
    }

    /* renamed from: H */
    public static void m5082H(Context context) {
        synchronized (f4059mw) {
            if (f4058JG == null) {
                f4058JG = new C1347b(context.getContentResolver());
            }
        }
    }

    /* renamed from: a */
    public static C1342iv<Integer> m5083a(String str, Integer num) {
        return new C1342iv<Integer>(str, num) {
        };
    }

    /* renamed from: g */
    public static C1342iv<Boolean> m5084g(String str, boolean z) {
        return new C1342iv<Boolean>(str, Boolean.valueOf(z)) {
        };
    }

    /* renamed from: m */
    public static C1342iv<String> m5085m(String str, String str2) {
        return new C1342iv<String>(str, str2) {
        };
    }

    public String getKey() {
        return this.f4060JH;
    }
}
