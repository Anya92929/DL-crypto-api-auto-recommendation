package com.google.p008a.p010b;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0365b;
import com.google.p008a.C0467c;
import com.google.p008a.C0481k;
import com.google.p008a.p009a.C0347a;
import com.google.p008a.p009a.C0350d;
import com.google.p008a.p009a.C0351e;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.a.b.s */
public final class C0459s implements C0364am, Cloneable {

    /* renamed from: a */
    public static final C0459s f3544a = new C0459s();

    /* renamed from: b */
    private double f3545b = -1.0d;

    /* renamed from: c */
    private int f3546c = 136;

    /* renamed from: d */
    private boolean f3547d = true;

    /* renamed from: e */
    private boolean f3548e;

    /* renamed from: f */
    private List<C0365b> f3549f = Collections.emptyList();

    /* renamed from: g */
    private List<C0365b> f3550g = Collections.emptyList();

    /* renamed from: a */
    private boolean m2768a(C0350d dVar) {
        return dVar == null || dVar.mo6294a() <= this.f3545b;
    }

    /* renamed from: a */
    private boolean m2769a(C0350d dVar, C0351e eVar) {
        return m2768a(dVar) && m2770a(eVar);
    }

    /* renamed from: a */
    private boolean m2770a(C0351e eVar) {
        return eVar == null || eVar.mo6295a() > this.f3545b;
    }

    /* renamed from: a */
    private boolean m2771a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: b */
    private boolean m2772b(Class<?> cls) {
        return cls.isMemberClass() && !m2773c(cls);
    }

    /* renamed from: c */
    private boolean m2773c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Class<? super T> a = aVar.mo6494a();
        boolean a2 = mo6463a((Class<?>) a, true);
        boolean a3 = mo6463a((Class<?>) a, false);
        if (a2 || a3) {
            return new C0460t(this, a3, a2, kVar, aVar);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0459s clone() {
        try {
            return (C0459s) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public boolean mo6463a(Class<?> cls, boolean z) {
        if (this.f3545b != -1.0d && !m2769a((C0350d) cls.getAnnotation(C0350d.class), (C0351e) cls.getAnnotation(C0351e.class))) {
            return true;
        }
        if (!this.f3547d && m2772b(cls)) {
            return true;
        }
        if (m2771a(cls)) {
            return true;
        }
        for (C0365b a : z ? this.f3549f : this.f3550g) {
            if (a.mo6314a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo6464a(Field field, boolean z) {
        C0347a aVar;
        if ((this.f3546c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f3545b != -1.0d && !m2769a((C0350d) field.getAnnotation(C0350d.class), (C0351e) field.getAnnotation(C0351e.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f3548e && ((aVar = (C0347a) field.getAnnotation(C0347a.class)) == null || (!z ? !aVar.mo6291b() : !aVar.mo6290a()))) {
            return true;
        }
        if (!this.f3547d && m2772b(field.getType())) {
            return true;
        }
        if (m2771a(field.getType())) {
            return true;
        }
        List<C0365b> list = z ? this.f3549f : this.f3550g;
        if (!list.isEmpty()) {
            C0467c cVar = new C0467c(field);
            for (C0365b a : list) {
                if (a.mo6313a(cVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
