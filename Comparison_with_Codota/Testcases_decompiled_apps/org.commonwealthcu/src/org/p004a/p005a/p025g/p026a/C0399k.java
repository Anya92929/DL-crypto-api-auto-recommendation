package org.p004a.p005a.p025g.p026a;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* renamed from: org.a.a.g.a.k */
final class C0399k extends OutputStream {

    /* renamed from: a */
    private final MessageDigest f276a;

    /* renamed from: b */
    private boolean f277b;

    /* renamed from: c */
    private byte[] f278c;

    C0399k(MessageDigest messageDigest) {
        this.f276a = messageDigest;
        this.f276a.reset();
    }

    /* renamed from: a */
    public final byte[] mo5150a() {
        return this.f278c;
    }

    public final void close() {
        if (!this.f277b) {
            this.f277b = true;
            this.f278c = this.f276a.digest();
            super.close();
        }
    }

    public final void write(int i) {
        if (this.f277b) {
            throw new IOException("Stream has been already closed");
        }
        this.f276a.update((byte) i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (this.f277b) {
            throw new IOException("Stream has been already closed");
        }
        this.f276a.update(bArr, i, i2);
    }
}
