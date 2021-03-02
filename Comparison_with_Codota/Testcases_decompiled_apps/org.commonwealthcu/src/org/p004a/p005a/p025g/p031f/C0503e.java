package org.p004a.p005a.p025g.p031f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.p004a.p005a.C0246ah;
import org.p004a.p005a.C0561m;
import org.p004a.p005a.C0574w;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0514a;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p033i.C0530i;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.f.e */
public final class C0503e extends InputStream {

    /* renamed from: a */
    private final C0519f f534a;

    /* renamed from: b */
    private final C0563b f535b;

    /* renamed from: c */
    private int f536c;

    /* renamed from: d */
    private int f537d;

    /* renamed from: e */
    private int f538e;

    /* renamed from: f */
    private boolean f539f = false;

    /* renamed from: g */
    private boolean f540g = false;

    public C0503e(C0519f fVar) {
        this.f534a = (C0519f) C0250b.m84a((Object) fVar, "Session input buffer");
        this.f538e = 0;
        this.f535b = new C0563b(16);
        this.f536c = 1;
    }

    /* renamed from: a */
    private void m984a() {
        this.f537d = m985b();
        if (this.f537d < 0) {
            throw new C0574w("Negative chunk size");
        }
        this.f536c = 2;
        this.f538e = 0;
        if (this.f537d == 0) {
            this.f539f = true;
            try {
                C0499a.m957a(this.f534a, -1, -1, C0530i.f582a, new ArrayList());
            } catch (C0561m e) {
                C0574w wVar = new C0574w("Invalid footer: " + e.getMessage());
                wVar.initCause(e);
                throw wVar;
            }
        }
    }

    /* renamed from: b */
    private int m985b() {
        switch (this.f536c) {
            case 1:
                break;
            case 3:
                this.f535b.mo5426a();
                if (this.f534a.mo5234a(this.f535b) != -1) {
                    if (this.f535b.mo5437d()) {
                        this.f536c = 1;
                        break;
                    } else {
                        throw new C0574w("Unexpected content at the end of chunk");
                    }
                } else {
                    return 0;
                }
            default:
                throw new IllegalStateException("Inconsistent codec state");
        }
        this.f535b.mo5426a();
        if (this.f534a.mo5234a(this.f535b) == -1) {
            return 0;
        }
        int c = this.f535b.mo5436c(59);
        if (c < 0) {
            c = this.f535b.mo5435c();
        }
        try {
            return Integer.parseInt(this.f535b.mo5432b(0, c), 16);
        } catch (NumberFormatException e) {
            throw new C0574w("Bad chunk header");
        }
    }

    public final int available() {
        if (this.f534a instanceof C0514a) {
            return Math.min(((C0514a) this.f534a).mo5282d(), this.f537d - this.f538e);
        }
        return 0;
    }

    public final void close() {
        if (!this.f540g) {
            try {
                if (!this.f539f) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.f539f = true;
                this.f540g = true;
            }
        }
    }

    public final int read() {
        if (this.f540g) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f539f) {
            return -1;
        } else {
            if (this.f536c != 2) {
                m984a();
                if (this.f539f) {
                    return -1;
                }
            }
            int a = this.f534a.mo5233a();
            if (a != -1) {
                this.f538e++;
                if (this.f538e >= this.f537d) {
                    this.f536c = 3;
                }
            }
            return a;
        }
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.f540g) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f539f) {
            return -1;
        } else {
            if (this.f536c != 2) {
                m984a();
                if (this.f539f) {
                    return -1;
                }
            }
            int a = this.f534a.mo5235a(bArr, i, Math.min(i2, this.f537d - this.f538e));
            if (a != -1) {
                this.f538e += a;
                if (this.f538e >= this.f537d) {
                    this.f536c = 3;
                }
                return a;
            }
            this.f539f = true;
            throw new C0246ah("Truncated chunk ( expected size: " + this.f537d + "; actual size: " + this.f538e + ")");
        }
    }
}
