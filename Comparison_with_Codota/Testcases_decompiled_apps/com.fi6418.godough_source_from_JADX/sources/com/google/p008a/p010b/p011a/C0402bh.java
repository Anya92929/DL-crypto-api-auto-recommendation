package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p009a.C0349c;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.lang.Enum;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.a.b.a.bh */
final class C0402bh<T extends Enum<T>> extends C0363al<T> {

    /* renamed from: a */
    private final Map<String, T> f3399a = new HashMap();

    /* renamed from: b */
    private final Map<T, String> f3400b = new HashMap();

    public C0402bh(Class<T> cls) {
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                String name = enumR.name();
                C0349c cVar = (C0349c) cls.getField(name).getAnnotation(C0349c.class);
                String a = cVar != null ? cVar.mo6293a() : name;
                this.f3399a.put(a, enumR);
                this.f3400b.put(enumR, a);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public T mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return (Enum) this.f3399a.get(aVar.mo6383h());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, T t) {
        dVar.mo6400b(t == null ? null : this.f3400b.get(t));
    }
}
