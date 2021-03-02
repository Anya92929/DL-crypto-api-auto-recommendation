package org.p004a.p005a.p025g.p031f;

import java.io.IOException;
import java.io.OutputStream;
import org.p004a.p005a.p032h.C0520g;

/* renamed from: org.a.a.g.f.f */
public final class C0504f extends OutputStream {

    /* renamed from: a */
    private final C0520g f541a;

    /* renamed from: b */
    private final byte[] f542b;

    /* renamed from: c */
    private int f543c;

    /* renamed from: d */
    private boolean f544d;

    /* renamed from: e */
    private boolean f545e;

    private C0504f(int i, C0520g gVar) {
        this.f543c = 0;
        this.f544d = false;
        this.f545e = false;
        this.f542b = new byte[2048];
        this.f541a = gVar;
    }

    public C0504f(C0520g gVar) {
        this(2048, gVar);
    }

    /* renamed from: a */
    private void m986a() {
        if (this.f543c > 0) {
            this.f541a.mo5241a(Integer.toHexString(this.f543c));
            this.f541a.mo5243a(this.f542b, 0, this.f543c);
            this.f541a.mo5241a("");
            this.f543c = 0;
        }
    }

    public final void close() {
        if (!this.f545e) {
            this.f545e = true;
            if (!this.f544d) {
                m986a();
                this.f541a.mo5241a("0");
                this.f541a.mo5241a("");
                this.f544d = true;
            }
            this.f541a.mo5239a();
        }
    }

    public final void flush() {
        m986a();
        this.f541a.mo5239a();
    }

    public final void write(int i) {
        if (this.f545e) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.f542b[this.f543c] = (byte) i;
        this.f543c++;
        if (this.f543c == this.f542b.length) {
            m986a();
        }
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (this.f545e) {
            throw new IOException("Attempted write to closed stream.");
        } else if (i2 >= this.f542b.length - this.f543c) {
            this.f541a.mo5241a(Integer.toHexString(this.f543c + i2));
            this.f541a.mo5243a(this.f542b, 0, this.f543c);
            this.f541a.mo5243a(bArr, i, i2);
            this.f541a.mo5241a("");
            this.f543c = 0;
        } else {
            System.arraycopy(bArr, i, this.f542b, this.f543c, i2);
            this.f543c += i2;
        }
    }
}
