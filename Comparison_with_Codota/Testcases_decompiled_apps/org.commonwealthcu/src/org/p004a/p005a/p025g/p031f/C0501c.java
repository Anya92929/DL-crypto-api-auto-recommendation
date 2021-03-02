package org.p004a.p005a.p025g.p031f;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0514a;
import org.p004a.p005a.p032h.C0518e;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p037m.C0562a;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.f.c */
public abstract class C0501c implements C0514a, C0519f {

    /* renamed from: a */
    private InputStream f509a;

    /* renamed from: b */
    private byte[] f510b;

    /* renamed from: c */
    private C0562a f511c;

    /* renamed from: d */
    private Charset f512d;

    /* renamed from: e */
    private boolean f513e;

    /* renamed from: f */
    private int f514f;

    /* renamed from: g */
    private int f515g;

    /* renamed from: h */
    private C0518e f516h;

    /* renamed from: i */
    private CodingErrorAction f517i;

    /* renamed from: j */
    private CodingErrorAction f518j;

    /* renamed from: k */
    private int f519k;

    /* renamed from: l */
    private int f520l;

    /* renamed from: m */
    private CharsetDecoder f521m;

    /* renamed from: n */
    private CharBuffer f522n;

    /* renamed from: a */
    private int m962a(CoderResult coderResult, C0563b bVar) {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.f522n.flip();
        int remaining = this.f522n.remaining();
        while (this.f522n.hasRemaining()) {
            bVar.mo5427a(this.f522n.get());
        }
        this.f522n.compact();
        return remaining;
    }

    /* renamed from: a */
    private int m963a(C0563b bVar, ByteBuffer byteBuffer) {
        int i = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.f521m == null) {
            this.f521m = this.f512d.newDecoder();
            this.f521m.onMalformedInput(this.f517i);
            this.f521m.onUnmappableCharacter(this.f518j);
        }
        if (this.f522n == null) {
            this.f522n = CharBuffer.allocate(1024);
        }
        this.f521m.reset();
        while (byteBuffer.hasRemaining()) {
            i += m962a(this.f521m.decode(byteBuffer, this.f522n, true), bVar);
        }
        int a = i + m962a(this.f521m.flush(this.f522n), bVar);
        this.f522n.clear();
        return a;
    }

    /* renamed from: a */
    public final int mo5233a() {
        while (!mo5284f()) {
            if (mo5283e() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.f510b;
        int i = this.f519k;
        this.f519k = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: a */
    public final int mo5234a(C0563b bVar) {
        int i;
        boolean z;
        C0250b.m84a((Object) bVar, "Char array buffer");
        boolean z2 = true;
        int i2 = 0;
        while (z2) {
            int i3 = this.f519k;
            while (true) {
                if (i3 >= this.f520l) {
                    i3 = -1;
                    break;
                } else if (this.f510b[i3] == 10) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                if (mo5284f()) {
                    this.f511c.mo5414a(this.f510b, this.f519k, this.f520l - this.f519k);
                    this.f519k = this.f520l;
                }
                int e = mo5283e();
                if (e == -1) {
                    i = e;
                    z = false;
                } else {
                    boolean z3 = z2;
                    i = e;
                    z = z3;
                }
            } else if (this.f511c.mo5421f()) {
                int i4 = this.f519k;
                this.f519k = i3 + 1;
                if (i3 > i4 && this.f510b[i3 - 1] == 13) {
                    i3--;
                }
                int i5 = i3 - i4;
                if (!this.f513e) {
                    return m963a(bVar, ByteBuffer.wrap(this.f510b, i4, i5));
                }
                bVar.mo5430a(this.f510b, i4, i5);
                return i5;
            } else {
                this.f511c.mo5414a(this.f510b, this.f519k, (i3 + 1) - this.f519k);
                this.f519k = i3 + 1;
                z = false;
                i = i2;
            }
            if (this.f514f <= 0 || this.f511c.mo5419d() < this.f514f) {
                i2 = i;
                z2 = z;
            } else {
                throw new IOException("Maximum line length limit exceeded");
            }
        }
        if (i2 == -1 && this.f511c.mo5421f()) {
            return -1;
        }
        int d = this.f511c.mo5419d();
        if (d > 0) {
            if (this.f511c.mo5416b(d - 1) == 10) {
                d--;
            }
            if (d > 0 && this.f511c.mo5416b(d - 1) == 13) {
                d--;
            }
        }
        if (this.f513e) {
            C0562a aVar = this.f511c;
            if (aVar != null) {
                bVar.mo5430a(aVar.mo5420e(), 0, d);
            }
        } else {
            d = m963a(bVar, ByteBuffer.wrap(this.f511c.mo5420e(), 0, d));
        }
        this.f511c.mo5412a();
        return d;
    }

    /* renamed from: a */
    public final int mo5235a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 0;
        }
        if (mo5284f()) {
            int min = Math.min(i2, this.f520l - this.f519k);
            System.arraycopy(this.f510b, this.f519k, bArr, i, min);
            this.f519k += min;
            return min;
        } else if (i2 > this.f515g) {
            int read = this.f509a.read(bArr, i, i2);
            if (read <= 0) {
                return read;
            }
            this.f516h.mo5318a((long) read);
            return read;
        } else {
            while (!mo5284f()) {
                if (mo5283e() == -1) {
                    return -1;
                }
            }
            int min2 = Math.min(i2, this.f520l - this.f519k);
            System.arraycopy(this.f510b, this.f519k, bArr, i, min2);
            this.f519k += min2;
            return min2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5281a(InputStream inputStream, int i, C0544b bVar) {
        C0250b.m84a((Object) inputStream, "Input stream");
        C0250b.m78a(i, "Buffer size");
        C0250b.m84a((Object) bVar, "HTTP parameters");
        this.f509a = inputStream;
        this.f510b = new byte[i];
        this.f519k = 0;
        this.f520l = 0;
        this.f511c = new C0562a(i);
        String str = (String) bVar.mo5196a("http.protocol.element-charset");
        this.f512d = str != null ? Charset.forName(str) : C0297c.f130b;
        this.f513e = this.f512d.equals(C0297c.f130b);
        this.f521m = null;
        this.f514f = bVar.mo5389a("http.connection.max-line-length", -1);
        this.f515g = bVar.mo5389a("http.connection.min-chunk-limit", 512);
        this.f516h = new C0518e();
        CodingErrorAction codingErrorAction = (CodingErrorAction) bVar.mo5196a("http.malformed.input.action");
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.f517i = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) bVar.mo5196a("http.unmappable.input.action");
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.f518j = codingErrorAction2;
    }

    /* renamed from: b */
    public final C0518e mo5237b() {
        return this.f516h;
    }

    /* renamed from: d */
    public final int mo5282d() {
        return this.f520l - this.f519k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo5283e() {
        if (this.f519k > 0) {
            int i = this.f520l - this.f519k;
            if (i > 0) {
                System.arraycopy(this.f510b, this.f519k, this.f510b, 0, i);
            }
            this.f519k = 0;
            this.f520l = i;
        }
        int i2 = this.f520l;
        int read = this.f509a.read(this.f510b, i2, this.f510b.length - i2);
        if (read == -1) {
            return -1;
        }
        this.f520l = i2 + read;
        this.f516h.mo5318a((long) read);
        return read;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final boolean mo5284f() {
        return this.f519k < this.f520l;
    }
}
