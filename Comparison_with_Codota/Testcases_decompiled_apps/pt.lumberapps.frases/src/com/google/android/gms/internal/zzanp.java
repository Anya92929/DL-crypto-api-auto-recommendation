package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class zzanp {

    /* renamed from: a */
    private final Map f5796a;

    public zzanp(Map map) {
        this.f5796a = map;
    }

    /* renamed from: a */
    private zzanu m6670a(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C1430av(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    private zzanu m6671a(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new C1431aw(this) : EnumSet.class.isAssignableFrom(cls) ? new C1432ax(this, type) : Set.class.isAssignableFrom(cls) ? new C1433ay(this) : Queue.class.isAssignableFrom(cls) ? new C1423ao(this) : new C1424ap(this);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new C1425aq(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzaol.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).mo7939m())) ? new C1427as(this) : new C1426ar(this);
        }
        return null;
    }

    /* renamed from: b */
    private zzanu m6672b(Type type, Class cls) {
        return new C1428at(this, cls, type);
    }

    public String toString() {
        return this.f5796a.toString();
    }

    public zzanu zzb(zzaol zzaol) {
        Type n = zzaol.mo7940n();
        Class m = zzaol.mo7939m();
        zzamr zzamr = (zzamr) this.f5796a.get(n);
        if (zzamr != null) {
            return new C1422an(this, zzamr, n);
        }
        zzamr zzamr2 = (zzamr) this.f5796a.get(m);
        if (zzamr2 != null) {
            return new C1429au(this, zzamr2, n);
        }
        zzanu a = m6670a(m);
        if (a != null) {
            return a;
        }
        zzanu a2 = m6671a(n, m);
        return a2 == null ? m6672b(n, m) : a2;
    }
}
