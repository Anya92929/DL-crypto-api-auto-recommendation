package org.p004a.p005a.p014d;

import java.io.IOException;
import java.io.InputStream;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.d.i */
public final class C0335i extends InputStream implements C0333g {

    /* renamed from: a */
    private InputStream f174a;

    /* renamed from: b */
    private boolean f175b = false;

    /* renamed from: c */
    private final C0336j f176c;

    public C0335i(InputStream inputStream, C0336j jVar) {
        C0250b.m84a((Object) inputStream, "Wrapped stream");
        this.f174a = inputStream;
        this.f176c = jVar;
    }

    /* renamed from: a */
    private void m322a(int i) {
        if (this.f174a != null && i < 0) {
            boolean z = true;
            try {
                if (this.f176c != null) {
                    z = this.f176c.mo4953a(this.f174a);
                }
                if (z) {
                    this.f174a.close();
                }
            } finally {
                this.f174a = null;
            }
        }
    }

    /* renamed from: a */
    private boolean m323a() {
        if (!this.f175b) {
            return this.f174a != null;
        }
        throw new IOException("Attempted read on closed stream.");
    }

    /* renamed from: b */
    private void m324b() {
        if (this.f174a != null) {
            boolean z = true;
            try {
                if (this.f176c != null) {
                    z = this.f176c.mo4958j();
                }
                if (z) {
                    this.f174a.close();
                }
            } finally {
                this.f174a = null;
            }
        }
    }

    public final int available() {
        if (!m323a()) {
            return 0;
        }
        try {
            return this.f174a.available();
        } catch (IOException e) {
            m324b();
            throw e;
        }
    }

    public final void close() {
        boolean z = true;
        this.f175b = true;
        if (this.f174a != null) {
            try {
                if (this.f176c != null) {
                    z = this.f176c.mo4954b(this.f174a);
                }
                if (z) {
                    this.f174a.close();
                }
            } finally {
                this.f174a = null;
            }
        }
    }

    /* renamed from: h */
    public final void mo4956h() {
        close();
    }

    /* renamed from: i */
    public final void mo4957i() {
        this.f175b = true;
        m324b();
    }

    public final int read() {
        if (!m323a()) {
            return -1;
        }
        try {
            int read = this.f174a.read();
            m322a(read);
            return read;
        } catch (IOException e) {
            m324b();
            throw e;
        }
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (!m323a()) {
            return -1;
        }
        try {
            int read = this.f174a.read(bArr, i, i2);
            m322a(read);
            return read;
        } catch (IOException e) {
            m324b();
            throw e;
        }
    }
}
