package org.p004a.p005a.p022f.p023a.p024a;

import java.io.OutputStream;
import java.nio.charset.Charset;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0380e;

/* renamed from: org.a.a.f.a.a.a */
public abstract class C0363a {

    /* renamed from: a */
    private final C0380e f193a;

    public C0363a(C0380e eVar) {
        C0250b.m84a((Object) eVar, "Content type");
        this.f193a = eVar;
    }

    /* renamed from: a */
    public String mo5097a() {
        return this.f193a.mo5121a();
    }

    /* renamed from: a */
    public abstract void mo5098a(OutputStream outputStream);

    /* renamed from: b */
    public String mo5099b() {
        Charset b = this.f193a.mo5122b();
        if (b != null) {
            return b.name();
        }
        return null;
    }

    /* renamed from: c */
    public abstract String mo5100c();

    /* renamed from: d */
    public abstract long mo5101d();

    /* renamed from: e */
    public abstract String mo5102e();
}
