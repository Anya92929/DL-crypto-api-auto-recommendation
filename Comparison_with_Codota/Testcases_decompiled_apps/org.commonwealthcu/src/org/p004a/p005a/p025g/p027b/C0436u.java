package org.p004a.p005a.p025g.p027b;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: org.a.a.g.b.u */
public final class C0436u extends AbstractList {

    /* renamed from: a */
    private final Set f400a = new HashSet();

    /* renamed from: b */
    private final List f401b = new ArrayList();

    /* renamed from: a */
    public final boolean mo5202a(URI uri) {
        return this.f400a.contains(uri);
    }

    public final void add(int i, Object obj) {
        this.f401b.add(i, (URI) obj);
        this.f400a.add((URI) obj);
    }

    /* renamed from: b */
    public final void mo5204b(URI uri) {
        this.f400a.add(uri);
        this.f401b.add(uri);
    }

    public final boolean contains(Object obj) {
        return this.f400a.contains(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return (URI) this.f401b.get(i);
    }

    public final /* synthetic */ Object remove(int i) {
        URI uri = (URI) this.f401b.remove(i);
        this.f400a.remove(uri);
        if (this.f401b.size() != this.f400a.size()) {
            this.f400a.addAll(this.f401b);
        }
        return uri;
    }

    public final Object set(int i, Object obj) {
        URI uri = (URI) this.f401b.set(i, (URI) obj);
        this.f400a.remove(uri);
        this.f400a.add((URI) obj);
        if (this.f401b.size() != this.f400a.size()) {
            this.f400a.addAll(this.f401b);
        }
        return uri;
    }

    public final int size() {
        return this.f401b.size();
    }
}
