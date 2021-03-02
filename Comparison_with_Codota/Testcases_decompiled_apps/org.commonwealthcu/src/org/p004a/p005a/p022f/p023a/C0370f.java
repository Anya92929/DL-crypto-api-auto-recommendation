package org.p004a.p005a.p022f.p023a;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* renamed from: org.a.a.f.a.f */
final class C0370f extends C0362a {

    /* renamed from: b */
    private final List f207b;

    public C0370f(String str, Charset charset, String str2, List list) {
        super(str, charset, str2);
        this.f207b = list;
    }

    /* renamed from: a */
    public final List mo5093a() {
        return this.f207b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5095a(C0366b bVar, OutputStream outputStream) {
        Iterator it = bVar.mo5104b().iterator();
        while (it.hasNext()) {
            m405a((C0373i) it.next(), C0372h.f210b, outputStream);
        }
    }
}
