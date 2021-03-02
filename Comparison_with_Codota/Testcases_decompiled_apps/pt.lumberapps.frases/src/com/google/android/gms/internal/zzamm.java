package com.google.android.gms.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class zzamm {

    /* renamed from: a */
    private final Field f5769a;

    public zzamm(Field field) {
        zzann.zzy(field);
        this.f5769a = field;
    }

    public Annotation getAnnotation(Class cls) {
        return this.f5769a.getAnnotation(cls);
    }
}
