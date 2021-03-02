package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' modifier removed */
/* renamed from: com.google.android.gms.internal.x */
final class C1879x extends zzamn {
    C1879x(String str, int i) {
        super(str, i, (C1876u) null);
    }

    public String zzc(Field field) {
        return zzamn.m6647b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
}
