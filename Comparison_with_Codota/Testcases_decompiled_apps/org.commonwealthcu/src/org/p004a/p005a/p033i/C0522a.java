package org.p004a.p005a.p033i;

import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0513h;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p034j.C0543a;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.i.a */
public abstract class C0522a implements C0567p {

    /* renamed from: a */
    protected C0537p f563a;

    /* renamed from: b */
    protected C0544b f564b;

    protected C0522a() {
        this((C0544b) null);
    }

    private C0522a(C0544b bVar) {
        this.f563a = new C0537p();
        this.f564b = null;
    }

    /* renamed from: a */
    public final void mo5319a(String str, String str2) {
        C0250b.m84a((Object) str, "Header name");
        this.f563a.mo5372a((C0344e) new C0523b(str, str2));
    }

    /* renamed from: a */
    public final void mo5320a(C0344e eVar) {
        this.f563a.mo5372a(eVar);
    }

    /* renamed from: a */
    public final void mo5321a(C0544b bVar) {
        this.f564b = (C0544b) C0250b.m84a((Object) bVar, "HTTP parameters");
    }

    /* renamed from: a */
    public final void mo5322a(C0344e[] eVarArr) {
        this.f563a.mo5373a(eVarArr);
    }

    /* renamed from: a */
    public final boolean mo5323a(String str) {
        return this.f563a.mo5379c(str);
    }

    /* renamed from: b */
    public final void mo5324b(String str, String str2) {
        C0250b.m84a((Object) str, "Header name");
        this.f563a.mo5376b((C0344e) new C0523b(str, str2));
    }

    /* renamed from: b */
    public final C0344e[] mo5325b(String str) {
        return this.f563a.mo5374a(str);
    }

    /* renamed from: c */
    public final C0344e mo5326c(String str) {
        return this.f563a.mo5375b(str);
    }

    /* renamed from: d */
    public final void mo5327d(String str) {
        C0513h c = this.f563a.mo5378c();
        while (c.hasNext()) {
            if (str.equalsIgnoreCase(c.mo5316a().mo5040c())) {
                c.remove();
            }
        }
    }

    /* renamed from: d */
    public final C0344e[] mo5328d() {
        return this.f563a.mo5377b();
    }

    /* renamed from: e */
    public final C0513h mo5329e() {
        return this.f563a.mo5378c();
    }

    /* renamed from: e */
    public final C0513h mo5330e(String str) {
        return this.f563a.mo5381d(str);
    }

    /* renamed from: f */
    public final C0544b mo5331f() {
        if (this.f564b == null) {
            this.f564b = new C0543a();
        }
        return this.f564b;
    }
}
