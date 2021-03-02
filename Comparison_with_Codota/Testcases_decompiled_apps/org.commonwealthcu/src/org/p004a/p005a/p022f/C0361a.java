package org.p004a.p005a.p022f;

import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.p033i.C0523b;

/* renamed from: org.a.a.f.a */
public abstract class C0361a implements C0546k {

    /* renamed from: a */
    private C0344e f185a;

    /* renamed from: b */
    private C0344e f186b;

    /* renamed from: c */
    private boolean f187c;

    protected C0361a() {
    }

    /* renamed from: a */
    public final void mo5086a(String str) {
        C0523b bVar = null;
        if (str != null) {
            bVar = new C0523b("Content-Type", str);
        }
        this.f185a = bVar;
    }

    /* renamed from: a */
    public final void mo5087a(C0344e eVar) {
        this.f185a = eVar;
    }

    /* renamed from: a */
    public final void mo5088a(boolean z) {
        this.f187c = z;
    }

    /* renamed from: b */
    public final void mo5089b(C0344e eVar) {
        this.f186b = eVar;
    }

    /* renamed from: b */
    public final boolean mo5090b() {
        return this.f187c;
    }

    /* renamed from: d */
    public final C0344e mo5091d() {
        return this.f185a;
    }

    /* renamed from: e */
    public final C0344e mo5092e() {
        return this.f186b;
    }
}
