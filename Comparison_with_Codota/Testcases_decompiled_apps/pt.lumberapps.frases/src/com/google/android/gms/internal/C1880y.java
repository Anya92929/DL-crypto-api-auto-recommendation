package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' modifier removed */
/* renamed from: com.google.android.gms.internal.y */
final class C1880y extends zzamn {
    C1880y(String str, int i) {
        super(str, i, (C1876u) null);
    }

    public String zzc(Field field) {
        return zzamn.m6647b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
}
