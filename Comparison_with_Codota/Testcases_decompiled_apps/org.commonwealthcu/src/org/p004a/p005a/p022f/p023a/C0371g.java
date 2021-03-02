package org.p004a.p005a.p022f.p023a;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* renamed from: org.a.a.f.a.g */
final class C0371g extends C0362a {

    /* renamed from: b */
    private final List f208b;

    public C0371g(String str, Charset charset, String str2, List list) {
        super(str, charset, str2);
        this.f208b = list;
    }

    /* renamed from: a */
    public final List mo5093a() {
        return this.f208b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5095a(C0366b bVar, OutputStream outputStream) {
        Iterator it = bVar.mo5104b().iterator();
        while (it.hasNext()) {
            m404a((C0373i) it.next(), outputStream);
        }
    }
}
