package org.p004a.p005a.p022f.p023a;

import java.io.InputStream;
import java.io.OutputStream;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.p033i.C0523b;

/* renamed from: org.a.a.f.a.l */
final class C0376l implements C0546k {

    /* renamed from: a */
    private final C0362a f220a;

    /* renamed from: b */
    private final C0344e f221b;

    /* renamed from: c */
    private final long f222c;

    C0376l(C0362a aVar, String str, long j) {
        this.f220a = aVar;
        this.f221b = new C0523b("Content-Type", str);
        this.f222c = j;
    }

    /* renamed from: a */
    public final void mo4951a(OutputStream outputStream) {
        this.f220a.mo5094a(outputStream);
    }

    /* renamed from: a */
    public final boolean mo4952a() {
        return this.f222c != -1;
    }

    /* renamed from: b */
    public final boolean mo5090b() {
        return !mo4952a();
    }

    /* renamed from: c */
    public final long mo5116c() {
        return this.f222c;
    }

    /* renamed from: d */
    public final C0344e mo5091d() {
        return this.f221b;
    }

    /* renamed from: e */
    public final C0344e mo5092e() {
        return null;
    }

    /* renamed from: f */
    public final InputStream mo4955f() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    /* renamed from: g */
    public final boolean mo5117g() {
        return !mo4952a();
    }
}
