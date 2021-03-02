package org.p004a.p005a.p022f.p023a;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: org.a.a.f.a.d */
final class C0368d extends C0362a {

    /* renamed from: b */
    private final List f202b;

    public C0368d(String str, Charset charset, String str2, List list) {
        super(str, charset, str2);
        this.f202b = list;
    }

    /* renamed from: a */
    public final List mo5093a() {
        return this.f202b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5095a(C0366b bVar, OutputStream outputStream) {
        C0367c b = bVar.mo5104b();
        m405a(b.mo5105a("Content-Disposition"), this.f191a, outputStream);
        if (bVar.mo5103a().mo5102e() != null) {
            m405a(b.mo5105a("Content-Type"), this.f191a, outputStream);
        }
    }
}
