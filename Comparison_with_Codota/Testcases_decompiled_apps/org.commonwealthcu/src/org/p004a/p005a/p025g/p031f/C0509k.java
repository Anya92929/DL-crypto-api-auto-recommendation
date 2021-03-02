package org.p004a.p005a.p025g.p031f;

import java.io.InputStream;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0514a;
import org.p004a.p005a.p032h.C0519f;

/* renamed from: org.a.a.g.f.k */
public final class C0509k extends InputStream {

    /* renamed from: a */
    private final C0519f f556a;

    /* renamed from: b */
    private boolean f557b = false;

    public C0509k(C0519f fVar) {
        this.f556a = (C0519f) C0250b.m84a((Object) fVar, "Session input buffer");
    }

    public final int available() {
        if (this.f556a instanceof C0514a) {
            return ((C0514a) this.f556a).mo5282d();
        }
        return 0;
    }

    public final void close() {
        this.f557b = true;
    }

    public final int read() {
        if (this.f557b) {
            return -1;
        }
        return this.f556a.mo5233a();
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.f557b) {
            return -1;
        }
        return this.f556a.mo5235a(bArr, i, i2);
    }
}
