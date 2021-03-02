package org.p004a.p005a.p025g.p027b;

import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.g.b.g */
public final class C0422g extends C0544b {

    /* renamed from: a */
    private C0544b f364a = null;

    /* renamed from: b */
    private C0544b f365b;

    /* renamed from: c */
    private C0544b f366c;

    /* renamed from: d */
    private C0544b f367d;

    public C0422g(C0544b bVar, C0544b bVar2, C0544b bVar3, C0544b bVar4) {
        this.f365b = bVar2;
        this.f366c = bVar3;
        this.f367d = null;
    }

    /* renamed from: a */
    public final Object mo5196a(String str) {
        C0250b.m84a((Object) str, "Parameter name");
        Object obj = null;
        if (this.f367d != null) {
            obj = this.f367d.mo5196a(str);
        }
        if (obj == null && this.f366c != null) {
            obj = this.f366c.mo5196a(str);
        }
        if (obj == null && this.f365b != null) {
            obj = this.f365b.mo5196a(str);
        }
        return (obj != null || this.f364a == null) ? obj : this.f364a.mo5196a(str);
    }

    /* renamed from: a */
    public final C0544b mo5197a(String str, Object obj) {
        throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
    }
}
