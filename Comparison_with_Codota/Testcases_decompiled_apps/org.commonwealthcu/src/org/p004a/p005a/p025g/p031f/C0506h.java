package org.p004a.p005a.p025g.p031f;

import java.io.IOException;
import java.io.OutputStream;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0520g;

/* renamed from: org.a.a.g.f.h */
public final class C0506h extends OutputStream {

    /* renamed from: a */
    private final C0520g f550a;

    /* renamed from: b */
    private final long f551b;

    /* renamed from: c */
    private long f552c = 0;

    /* renamed from: d */
    private boolean f553d = false;

    public C0506h(C0520g gVar, long j) {
        this.f550a = (C0520g) C0250b.m84a((Object) gVar, "Session output buffer");
        this.f551b = C0250b.m80a(j, "Content length");
    }

    public final void close() {
        if (!this.f553d) {
            this.f553d = true;
            this.f550a.mo5239a();
        }
    }

    public final void flush() {
        this.f550a.mo5239a();
    }

    public final void write(int i) {
        if (this.f553d) {
            throw new IOException("Attempted write to closed stream.");
        } else if (this.f552c < this.f551b) {
            this.f550a.mo5240a(i);
            this.f552c++;
        }
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (this.f553d) {
            throw new IOException("Attempted write to closed stream.");
        } else if (this.f552c < this.f551b) {
            long j = this.f551b - this.f552c;
            if (((long) i2) > j) {
                i2 = (int) j;
            }
            this.f550a.mo5243a(bArr, i, i2);
            this.f552c += (long) i2;
        }
    }
}
