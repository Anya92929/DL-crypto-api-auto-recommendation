package org.p004a.p005a.p022f;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.f.c */
public final class C0378c extends C0381f {

    /* renamed from: b */
    private final byte[] f225b;

    public C0378c(C0546k kVar) {
        super(kVar);
        if (!kVar.mo4952a() || kVar.mo5116c() < 0) {
            this.f225b = C0250b.m107b(kVar);
        } else {
            this.f225b = null;
        }
    }

    /* renamed from: a */
    public final void mo4951a(OutputStream outputStream) {
        C0250b.m84a((Object) outputStream, "Output stream");
        if (this.f225b != null) {
            outputStream.write(this.f225b);
        } else {
            super.mo4951a(outputStream);
        }
    }

    /* renamed from: a */
    public final boolean mo4952a() {
        return true;
    }

    /* renamed from: b */
    public final boolean mo5090b() {
        return this.f225b == null && super.mo5090b();
    }

    /* renamed from: c */
    public final long mo5116c() {
        return this.f225b != null ? (long) this.f225b.length : super.mo5116c();
    }

    /* renamed from: f */
    public final InputStream mo4955f() {
        return this.f225b != null ? new ByteArrayInputStream(this.f225b) : super.mo4955f();
    }

    /* renamed from: g */
    public final boolean mo5117g() {
        return this.f225b == null && super.mo5117g();
    }
}
