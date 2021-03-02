package org.p004a.p005a.p014d;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0381f;

/* renamed from: org.a.a.d.a */
public final class C0302a extends C0381f implements C0333g, C0336j {

    /* renamed from: b */
    private C0339m f136b;

    /* renamed from: c */
    private boolean f137c;

    public C0302a(C0546k kVar, C0339m mVar, boolean z) {
        super(kVar);
        C0250b.m84a((Object) mVar, "Connection");
        this.f136b = mVar;
        this.f137c = z;
    }

    /* renamed from: k */
    private void m216k() {
        if (this.f136b != null) {
            try {
                if (this.f137c) {
                    C0250b.m94a(this.f233a);
                    this.f136b.mo5031k();
                } else {
                    this.f136b.mo5032l();
                }
            } finally {
                m217l();
            }
        }
    }

    /* renamed from: l */
    private void m217l() {
        if (this.f136b != null) {
            try {
                this.f136b.mo4956h();
            } finally {
                this.f136b = null;
            }
        }
    }

    /* renamed from: a */
    public final void mo4951a(OutputStream outputStream) {
        super.mo4951a(outputStream);
        m216k();
    }

    /* renamed from: a */
    public final boolean mo4952a() {
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final boolean mo4953a(InputStream inputStream) {
        try {
            if (this.f136b != null) {
                if (this.f137c) {
                    inputStream.close();
                    this.f136b.mo5031k();
                } else {
                    this.f136b.mo5032l();
                }
            }
            m217l();
            return false;
        } catch (Throwable th) {
            m217l();
            throw th;
        }
    }

    /* renamed from: b */
    public final boolean mo4954b(InputStream inputStream) {
        boolean c;
        try {
            if (this.f136b != null) {
                if (this.f137c) {
                    c = this.f136b.mo5246c();
                    inputStream.close();
                    this.f136b.mo5031k();
                } else {
                    this.f136b.mo5032l();
                }
            }
        } catch (SocketException e) {
            if (c) {
                throw e;
            }
        } catch (Throwable th) {
            m217l();
            throw th;
        }
        m217l();
        return false;
    }

    /* renamed from: f */
    public final InputStream mo4955f() {
        return new C0335i(this.f233a.mo4955f(), this);
    }

    /* renamed from: h */
    public final void mo4956h() {
        m216k();
    }

    /* renamed from: i */
    public final void mo4957i() {
        if (this.f136b != null) {
            try {
                this.f136b.mo4957i();
            } finally {
                this.f136b = null;
            }
        }
    }

    /* renamed from: j */
    public final boolean mo4958j() {
        if (this.f136b == null) {
            return false;
        }
        this.f136b.mo4957i();
        return false;
    }
}
