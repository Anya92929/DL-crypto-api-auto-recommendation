package com.appbrain.p033b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.appbrain.b.t */
public final class C1016t extends AbstractList implements C1017u, RandomAccess {

    /* renamed from: a */
    public static final C1017u f2665a = new C1016t().mo3944b();

    /* renamed from: b */
    private final List f2666b;

    public C1016t() {
        this.f2666b = new ArrayList();
    }

    public C1016t(C1017u uVar) {
        this.f2666b = new ArrayList(uVar.size());
        addAll(uVar);
    }

    /* renamed from: a */
    private static String m4258a(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof C1002f ? ((C1002f) obj).mo3970e() : C1013q.m4248b((byte[]) obj);
    }

    /* renamed from: a */
    public final C1002f mo3941a(int i) {
        Object obj = this.f2666b.get(i);
        C1002f a = obj instanceof C1002f ? (C1002f) obj : obj instanceof String ? C1002f.m4159a((String) obj) : C1002f.m4161a((byte[]) obj);
        if (a != obj) {
            this.f2666b.set(i, a);
        }
        return a;
    }

    /* renamed from: a */
    public final List mo3942a() {
        return Collections.unmodifiableList(this.f2666b);
    }

    /* renamed from: a */
    public final void mo3943a(C1002f fVar) {
        this.f2666b.add(fVar);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        this.f2666b.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection instanceof C1017u) {
            collection = ((C1017u) collection).mo3942a();
        }
        boolean addAll = this.f2666b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    /* renamed from: b */
    public final C1017u mo3944b() {
        return new C0993ah(this);
    }

    public final void clear() {
        this.f2666b.clear();
        this.modCount++;
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f2666b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof C1002f) {
            C1002f fVar = (C1002f) obj;
            String e = fVar.mo3970e();
            if (fVar.mo3927f()) {
                this.f2666b.set(i, e);
            }
            return e;
        }
        byte[] bArr = (byte[]) obj;
        String b = C1013q.m4248b(bArr);
        if (C1013q.m4247a(bArr)) {
            this.f2666b.set(i, b);
        }
        return b;
    }

    public final /* synthetic */ Object remove(int i) {
        Object remove = this.f2666b.remove(i);
        this.modCount++;
        return m4258a(remove);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        return m4258a(this.f2666b.set(i, (String) obj));
    }

    public final int size() {
        return this.f2666b.size();
    }
}
