package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import java.lang.reflect.Field;

/* renamed from: com.google.a.b.a.r */
class C0418r extends C0420t {

    /* renamed from: a */
    final C0363al<?> f3429a = this.f3434f.m2684a(this.f3430b, this.f3431c, (C0468a<?>) this.f3432d);

    /* renamed from: b */
    final /* synthetic */ C0481k f3430b;

    /* renamed from: c */
    final /* synthetic */ Field f3431c;

    /* renamed from: d */
    final /* synthetic */ C0468a f3432d;

    /* renamed from: e */
    final /* synthetic */ boolean f3433e;

    /* renamed from: f */
    final /* synthetic */ C0417q f3434f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0418r(C0417q qVar, String str, boolean z, boolean z2, C0481k kVar, Field field, C0468a aVar, boolean z3) {
        super(str, z, z2);
        this.f3434f = qVar;
        this.f3430b = kVar;
        this.f3431c = field;
        this.f3432d = aVar;
        this.f3433e = z3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6413a(C0470a aVar, Object obj) {
        Object b = this.f3429a.mo6310b(aVar);
        if (b != null || !this.f3433e) {
            this.f3431c.set(obj, b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6414a(C0473d dVar, Object obj) {
        new C0425y(this.f3430b, this.f3429a, this.f3432d.mo6495b()).mo6309a(dVar, this.f3431c.get(obj));
    }
}
