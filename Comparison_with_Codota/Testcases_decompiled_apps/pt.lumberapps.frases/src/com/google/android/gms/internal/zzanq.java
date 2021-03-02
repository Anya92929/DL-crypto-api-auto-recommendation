package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzanq implements zzani, Cloneable {
    public static final zzanq beK = new zzanq();

    /* renamed from: a */
    private double f5797a = -1.0d;

    /* renamed from: b */
    private int f5798b = 136;

    /* renamed from: c */
    private boolean f5799c = true;

    /* renamed from: d */
    private List f5800d = Collections.emptyList();

    /* renamed from: e */
    private List f5801e = Collections.emptyList();

    /* renamed from: a */
    private boolean m6673a(zzanl zzanl) {
        return zzanl == null || zzanl.zzczt() <= this.f5797a;
    }

    /* renamed from: a */
    private boolean m6674a(zzanl zzanl, zzanm zzanm) {
        return m6673a(zzanl) && m6675a(zzanm);
    }

    /* renamed from: a */
    private boolean m6675a(zzanm zzanm) {
        return zzanm == null || zzanm.zzczt() > this.f5797a;
    }

    /* renamed from: a */
    private boolean m6676a(Class cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: b */
    private boolean m6677b(Class cls) {
        return cls.isMemberClass() && !m6678c(cls);
    }

    /* renamed from: c */
    private boolean m6678c(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzanq clone() {
        try {
            return (zzanq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Class m = zzaol.mo7939m();
        boolean zza = zza(m, true);
        boolean zza2 = zza(m, false);
        if (zza || zza2) {
            return new C1434az(this, zza2, zza, zzamp, zzaol);
        }
        return null;
    }

    public zzanq zza(zzaml zzaml, boolean z, boolean z2) {
        zzanq a = clone();
        if (z) {
            a.f5800d = new ArrayList(this.f5800d);
            a.f5800d.add(zzaml);
        }
        if (z2) {
            a.f5801e = new ArrayList(this.f5801e);
            a.f5801e.add(zzaml);
        }
        return a;
    }

    public boolean zza(Class cls, boolean z) {
        if (this.f5797a != -1.0d && !m6674a((zzanl) cls.getAnnotation(zzanl.class), (zzanm) cls.getAnnotation(zzanm.class))) {
            return true;
        }
        if (!this.f5799c && m6677b(cls)) {
            return true;
        }
        if (m6676a(cls)) {
            return true;
        }
        for (zzaml zzh : z ? this.f5800d : this.f5801e) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.f5798b & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f5797a != -1.0d && !m6674a((zzanl) field.getAnnotation(zzanl.class), (zzanm) field.getAnnotation(zzanm.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.f5799c && m6677b(field.getType())) {
            return true;
        }
        if (m6676a((Class) field.getType())) {
            return true;
        }
        List<zzaml> list = z ? this.f5800d : this.f5801e;
        if (!list.isEmpty()) {
            zzamm zzamm = new zzamm(field);
            for (zzaml zza : list) {
                if (zza.zza(zzamm)) {
                    return true;
                }
            }
        }
        return false;
    }

    public zzanq zzg(int... iArr) {
        zzanq a = clone();
        a.f5798b = 0;
        for (int i : iArr) {
            a.f5798b = i | a.f5798b;
        }
        return a;
    }
}
