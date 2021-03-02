package org.p004a.p005a.p033i;

import java.util.List;
import java.util.NoSuchElementException;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0513h;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;

/* renamed from: org.a.a.i.j */
public final class C0531j implements C0513h {

    /* renamed from: a */
    private List f584a;

    /* renamed from: b */
    private int f585b = m1066a(-1);

    /* renamed from: c */
    private int f586c = -1;

    /* renamed from: d */
    private String f587d;

    public C0531j(List list, String str) {
        this.f584a = (List) C0250b.m84a((Object) list, "Header list");
        this.f587d = str;
    }

    /* renamed from: a */
    private int m1066a(int i) {
        boolean equalsIgnoreCase;
        if (i < -1) {
            return -1;
        }
        int size = this.f584a.size() - 1;
        boolean z = false;
        int i2 = i;
        while (!z && i2 < size) {
            int i3 = i2 + 1;
            if (this.f587d == null) {
                equalsIgnoreCase = true;
            } else {
                equalsIgnoreCase = this.f587d.equalsIgnoreCase(((C0344e) this.f584a.get(i3)).mo5040c());
            }
            z = equalsIgnoreCase;
            i2 = i3;
        }
        if (!z) {
            return -1;
        }
        return i2;
    }

    /* renamed from: a */
    public final C0344e mo5316a() {
        int i = this.f585b;
        if (i < 0) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.f586c = i;
        this.f585b = m1066a(i);
        return (C0344e) this.f584a.get(i);
    }

    public final boolean hasNext() {
        return this.f585b >= 0;
    }

    public final Object next() {
        return mo5316a();
    }

    public final void remove() {
        C0266m.m146a(this.f586c >= 0, "No header to remove");
        this.f584a.remove(this.f586c);
        this.f586c = -1;
        this.f585b--;
    }
}
