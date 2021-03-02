package org.p004a.p005a.p025g.p031f;

import java.io.IOException;
import java.io.OutputStream;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0520g;

/* renamed from: org.a.a.g.f.l */
public final class C0510l extends OutputStream {

    /* renamed from: a */
    private final C0520g f558a;

    /* renamed from: b */
    private boolean f559b = false;

    public C0510l(C0520g gVar) {
        this.f558a = (C0520g) C0250b.m84a((Object) gVar, "Session output buffer");
    }

    public final void close() {
        if (!this.f559b) {
            this.f559b = true;
            this.f558a.mo5239a();
        }
    }

    public final void flush() {
        this.f558a.mo5239a();
    }

    public final void write(int i) {
        if (this.f559b) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.f558a.mo5240a(i);
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (this.f559b) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.f558a.mo5243a(bArr, i, i2);
    }
}
