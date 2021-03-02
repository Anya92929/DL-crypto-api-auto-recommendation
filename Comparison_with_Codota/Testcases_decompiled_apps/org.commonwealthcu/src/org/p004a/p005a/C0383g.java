package org.p004a.p005a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0526e;
import org.p004a.p005a.p033i.C0538q;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g */
public class C0383g implements Iterator {

    /* renamed from: a */
    private final C0513h f235a;

    /* renamed from: b */
    private final C0538q f236b;

    /* renamed from: c */
    private C0360f f237c;

    /* renamed from: d */
    private C0563b f238d;

    /* renamed from: e */
    private C0541t f239e;

    public C0383g(C0513h hVar) {
        this(hVar, C0526e.f571a);
    }

    public C0383g(C0513h hVar, C0538q qVar) {
        this.f237c = null;
        this.f238d = null;
        this.f239e = null;
        this.f235a = (C0513h) C0250b.m84a((Object) hVar, "Header iterator");
        this.f236b = (C0538q) C0250b.m84a((Object) qVar, "Parser");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m485b() {
        /*
            r5 = this;
            r4 = 0
            r3 = 0
        L_0x0002:
            org.a.a.h r0 = r5.f235a
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x000e
            org.a.a.i.t r0 = r5.f239e
            if (r0 == 0) goto L_0x0079
        L_0x000e:
            org.a.a.i.t r0 = r5.f239e
            if (r0 == 0) goto L_0x001a
            org.a.a.i.t r0 = r5.f239e
            boolean r0 = r0.mo5386c()
            if (r0 == 0) goto L_0x0051
        L_0x001a:
            r5.f239e = r3
            r5.f238d = r3
        L_0x001e:
            org.a.a.h r0 = r5.f235a
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0051
            org.a.a.h r0 = r5.f235a
            org.a.a.e r1 = r0.mo5316a()
            boolean r0 = r1 instanceof org.p004a.p005a.C0301d
            if (r0 == 0) goto L_0x007a
            r0 = r1
            org.a.a.d r0 = (org.p004a.p005a.C0301d) r0
            org.a.a.m.b r0 = r0.mo4949a()
            r5.f238d = r0
            org.a.a.i.t r0 = new org.a.a.i.t
            org.a.a.m.b r2 = r5.f238d
            int r2 = r2.mo5435c()
            r0.<init>(r4, r2)
            r5.f239e = r0
            org.a.a.i.t r0 = r5.f239e
            org.a.a.d r1 = (org.p004a.p005a.C0301d) r1
            int r1 = r1.mo4950b()
            r0.mo5384a(r1)
        L_0x0051:
            org.a.a.i.t r0 = r5.f239e
            if (r0 == 0) goto L_0x0002
        L_0x0055:
            org.a.a.i.t r0 = r5.f239e
            boolean r0 = r0.mo5386c()
            if (r0 != 0) goto L_0x009e
            org.a.a.i.q r0 = r5.f236b
            org.a.a.m.b r1 = r5.f238d
            org.a.a.i.t r2 = r5.f239e
            org.a.a.f r0 = r0.mo5343b(r1, r2)
            java.lang.String r1 = r0.mo5080a()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0077
            java.lang.String r1 = r0.mo5083b()
            if (r1 == 0) goto L_0x0055
        L_0x0077:
            r5.f237c = r0
        L_0x0079:
            return
        L_0x007a:
            java.lang.String r0 = r1.mo5041d()
            if (r0 == 0) goto L_0x001e
            org.a.a.m.b r1 = new org.a.a.m.b
            int r2 = r0.length()
            r1.<init>(r2)
            r5.f238d = r1
            org.a.a.m.b r1 = r5.f238d
            r1.mo5428a((java.lang.String) r0)
            org.a.a.i.t r0 = new org.a.a.i.t
            org.a.a.m.b r1 = r5.f238d
            int r1 = r1.mo5435c()
            r0.<init>(r4, r1)
            r5.f239e = r0
            goto L_0x0051
        L_0x009e:
            org.a.a.i.t r0 = r5.f239e
            boolean r0 = r0.mo5386c()
            if (r0 == 0) goto L_0x0002
            r5.f239e = r3
            r5.f238d = r3
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.C0383g.m485b():void");
    }

    /* renamed from: a */
    public C0360f mo5125a() {
        if (this.f237c == null) {
            m485b();
        }
        if (this.f237c == null) {
            throw new NoSuchElementException("No more header elements available");
        }
        C0360f fVar = this.f237c;
        this.f237c = null;
        return fVar;
    }

    public boolean hasNext() {
        if (this.f237c == null) {
            m485b();
        }
        return this.f237c != null;
    }

    public Object next() {
        return mo5125a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
