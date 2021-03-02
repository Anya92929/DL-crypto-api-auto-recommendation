package org.p004a.p005a.p025g.p031f;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0514a;
import org.p004a.p005a.p032h.C0518e;
import org.p004a.p005a.p032h.C0520g;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p037m.C0562a;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.f.d */
public abstract class C0502d implements C0514a, C0520g {

    /* renamed from: a */
    private static final byte[] f523a = {13, 10};

    /* renamed from: b */
    private OutputStream f524b;

    /* renamed from: c */
    private C0562a f525c;

    /* renamed from: d */
    private Charset f526d;

    /* renamed from: e */
    private boolean f527e;

    /* renamed from: f */
    private int f528f;

    /* renamed from: g */
    private C0518e f529g;

    /* renamed from: h */
    private CodingErrorAction f530h;

    /* renamed from: i */
    private CodingErrorAction f531i;

    /* renamed from: j */
    private CharsetEncoder f532j;

    /* renamed from: k */
    private ByteBuffer f533k;

    /* renamed from: a */
    private void m972a(CharBuffer charBuffer) {
        if (charBuffer.hasRemaining()) {
            if (this.f532j == null) {
                this.f532j = this.f526d.newEncoder();
                this.f532j.onMalformedInput(this.f530h);
                this.f532j.onUnmappableCharacter(this.f531i);
            }
            if (this.f533k == null) {
                this.f533k = ByteBuffer.allocate(1024);
            }
            this.f532j.reset();
            while (charBuffer.hasRemaining()) {
                m973a(this.f532j.encode(charBuffer, this.f533k, true));
            }
            m973a(this.f532j.flush(this.f533k));
            this.f533k.clear();
        }
    }

    /* renamed from: a */
    private void m973a(CoderResult coderResult) {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.f533k.flip();
        while (this.f533k.hasRemaining()) {
            mo5240a((int) this.f533k.get());
        }
        this.f533k.compact();
    }

    /* renamed from: a */
    private void m974a(byte[] bArr) {
        if (bArr != null) {
            mo5243a(bArr, 0, bArr.length);
        }
    }

    /* renamed from: c */
    private void m975c() {
        int d = this.f525c.mo5419d();
        if (d > 0) {
            this.f524b.write(this.f525c.mo5420e(), 0, d);
            this.f525c.mo5412a();
            this.f529g.mo5318a((long) d);
        }
    }

    /* renamed from: a */
    public final void mo5239a() {
        m975c();
        this.f524b.flush();
    }

    /* renamed from: a */
    public final void mo5240a(int i) {
        if (this.f525c.mo5422g()) {
            m975c();
        }
        this.f525c.mo5413a(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5285a(OutputStream outputStream, int i, C0544b bVar) {
        C0250b.m84a((Object) outputStream, "Input stream");
        C0250b.m78a(i, "Buffer size");
        C0250b.m84a((Object) bVar, "HTTP parameters");
        this.f524b = outputStream;
        this.f525c = new C0562a(i);
        String str = (String) bVar.mo5196a("http.protocol.element-charset");
        this.f526d = str != null ? Charset.forName(str) : C0297c.f130b;
        this.f527e = this.f526d.equals(C0297c.f130b);
        this.f532j = null;
        this.f528f = bVar.mo5389a("http.connection.min-chunk-limit", 512);
        this.f529g = new C0518e();
        CodingErrorAction codingErrorAction = (CodingErrorAction) bVar.mo5196a("http.malformed.input.action");
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.f530h = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) bVar.mo5196a("http.unmappable.input.action");
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.f531i = codingErrorAction2;
    }

    /* renamed from: a */
    public final void mo5241a(String str) {
        if (str != null) {
            if (str.length() > 0) {
                if (this.f527e) {
                    for (int i = 0; i < str.length(); i++) {
                        mo5240a((int) str.charAt(i));
                    }
                } else {
                    m972a(CharBuffer.wrap(str));
                }
            }
            m974a(f523a);
        }
    }

    /* renamed from: a */
    public final void mo5242a(C0563b bVar) {
        int i = 0;
        if (bVar != null) {
            if (this.f527e) {
                int c = bVar.mo5435c();
                while (c > 0) {
                    int min = Math.min(this.f525c.mo5418c() - this.f525c.mo5419d(), c);
                    if (min > 0) {
                        C0562a aVar = this.f525c;
                        if (bVar != null) {
                            aVar.mo5415a(bVar.mo5434b(), i, min);
                        }
                    }
                    if (this.f525c.mo5422g()) {
                        m975c();
                    }
                    i += min;
                    c -= min;
                }
            } else {
                m972a(CharBuffer.wrap(bVar.mo5434b(), 0, bVar.mo5435c()));
            }
            m974a(f523a);
        }
    }

    /* renamed from: a */
    public final void mo5243a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i2 > this.f528f || i2 > this.f525c.mo5418c()) {
                m975c();
                this.f524b.write(bArr, i, i2);
                this.f529g.mo5318a((long) i2);
                return;
            }
            if (i2 > this.f525c.mo5418c() - this.f525c.mo5419d()) {
                m975c();
            }
            this.f525c.mo5414a(bArr, i, i2);
        }
    }

    /* renamed from: b */
    public final C0518e mo5244b() {
        return this.f529g;
    }

    /* renamed from: d */
    public final int mo5282d() {
        return this.f525c.mo5419d();
    }
}
