package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0480j;
import com.google.p008a.C0481k;
import com.google.p008a.p009a.C0349c;
import com.google.p008a.p010b.C0432af;
import com.google.p008a.p010b.C0446f;
import com.google.p008a.p010b.C0459s;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.Field;

/* renamed from: com.google.a.b.a.q */
public final class C0417q implements C0364am {

    /* renamed from: a */
    private final C0446f f3426a;

    /* renamed from: b */
    private final C0480j f3427b;

    /* renamed from: c */
    private final C0459s f3428c;

    public C0417q(C0446f fVar, C0480j jVar, C0459s sVar) {
        this.f3426a = fVar;
        this.f3427b = jVar;
        this.f3428c = sVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.google.p008a.p010b.p011a.C0407g.m2639a(r2.f3426a, r3, r5, r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.p008a.C0363al<?> m2684a(com.google.p008a.C0481k r3, java.lang.reflect.Field r4, com.google.p008a.p012c.C0468a<?> r5) {
        /*
            r2 = this;
            java.lang.Class<com.google.a.a.b> r0 = com.google.p008a.p009a.C0348b.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)
            com.google.a.a.b r0 = (com.google.p008a.p009a.C0348b) r0
            if (r0 == 0) goto L_0x0013
            com.google.a.b.f r1 = r2.f3426a
            com.google.a.al r0 = com.google.p008a.p010b.p011a.C0407g.m2639a(r1, r3, r5, r0)
            if (r0 == 0) goto L_0x0013
        L_0x0012:
            return r0
        L_0x0013:
            com.google.a.al r0 = r3.mo6511a(r5)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p008a.p010b.p011a.C0417q.m2684a(com.google.a.k, java.lang.reflect.Field, com.google.a.c.a):com.google.a.al");
    }

    /* renamed from: a */
    private C0420t m2685a(C0481k kVar, Field field, String str, C0468a<?> aVar, boolean z, boolean z2) {
        return new C0418r(this, str, z, z2, kVar, field, aVar, C0432af.m2720a(aVar.mo6494a()));
    }

    /* renamed from: a */
    private String m2686a(Field field) {
        C0349c cVar = (C0349c) field.getAnnotation(C0349c.class);
        return cVar == null ? this.f3427b.mo6509a(field) : cVar.mo6293a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.google.a.c.a<?>} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r15v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, com.google.p008a.p010b.p011a.C0420t> m2687a(com.google.p008a.C0481k r13, com.google.p008a.p012c.C0468a<?> r14, java.lang.Class r15) {
        /*
            r12 = this;
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            boolean r0 = r15.isInterface()
            if (r0 == 0) goto L_0x000d
            r0 = r7
        L_0x000c:
            return r0
        L_0x000d:
            java.lang.reflect.Type r9 = r14.mo6495b()
        L_0x0011:
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r15 == r0) goto L_0x008e
            java.lang.reflect.Field[] r10 = r15.getDeclaredFields()
            int r11 = r10.length
            r0 = 0
            r8 = r0
        L_0x001c:
            if (r8 >= r11) goto L_0x0079
            r2 = r10[r8]
            r0 = 1
            boolean r5 = r12.mo6412a((java.lang.reflect.Field) r2, (boolean) r0)
            r0 = 0
            boolean r6 = r12.mo6412a((java.lang.reflect.Field) r2, (boolean) r0)
            if (r5 != 0) goto L_0x0032
            if (r6 != 0) goto L_0x0032
        L_0x002e:
            int r0 = r8 + 1
            r8 = r0
            goto L_0x001c
        L_0x0032:
            r0 = 1
            r2.setAccessible(r0)
            java.lang.reflect.Type r0 = r14.mo6495b()
            java.lang.reflect.Type r1 = r2.getGenericType()
            java.lang.reflect.Type r0 = com.google.p008a.p010b.C0442b.m2737a((java.lang.reflect.Type) r0, (java.lang.Class<?>) r15, (java.lang.reflect.Type) r1)
            java.lang.String r3 = r12.m2686a(r2)
            com.google.a.c.a r4 = com.google.p008a.p012c.C0468a.m2794a((java.lang.reflect.Type) r0)
            r0 = r12
            r1 = r13
            com.google.a.b.a.t r0 = r0.m2685a(r1, r2, r3, r4, r5, r6)
            java.lang.String r1 = r0.f3437g
            java.lang.Object r0 = r7.put(r1, r0)
            com.google.a.b.a.t r0 = (com.google.p008a.p010b.p011a.C0420t) r0
            if (r0 == 0) goto L_0x002e
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = " declares multiple JSON fields named "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.f3437g
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0079:
            java.lang.reflect.Type r0 = r14.mo6495b()
            java.lang.reflect.Type r1 = r15.getGenericSuperclass()
            java.lang.reflect.Type r0 = com.google.p008a.p010b.C0442b.m2737a((java.lang.reflect.Type) r0, (java.lang.Class<?>) r15, (java.lang.reflect.Type) r1)
            com.google.a.c.a r14 = com.google.p008a.p012c.C0468a.m2794a((java.lang.reflect.Type) r0)
            java.lang.Class r15 = r14.mo6494a()
            goto L_0x0011
        L_0x008e:
            r0 = r7
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p008a.p010b.p011a.C0417q.m2687a(com.google.a.k, com.google.a.c.a, java.lang.Class):java.util.Map");
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Class<? super T> a = aVar.mo6494a();
        if (!Object.class.isAssignableFrom(a)) {
            return null;
        }
        return new C0419s(this.f3426a.mo6460a(aVar), m2687a(kVar, (C0468a<?>) aVar, (Class<?>) a), (C0418r) null);
    }

    /* renamed from: a */
    public boolean mo6412a(Field field, boolean z) {
        return !this.f3428c.mo6463a(field.getType(), z) && !this.f3428c.mo6464a(field, z);
    }
}
