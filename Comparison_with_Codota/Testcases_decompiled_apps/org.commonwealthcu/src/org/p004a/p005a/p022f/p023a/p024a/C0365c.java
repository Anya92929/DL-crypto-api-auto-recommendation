package org.p004a.p005a.p022f.p023a.p024a;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0380e;

/* renamed from: org.a.a.f.a.a.c */
public final class C0365c extends C0363a {

    /* renamed from: a */
    private final byte[] f196a;

    public C0365c(String str, C0380e eVar) {
        super(eVar);
        Charset b = eVar.mo5122b();
        String name = b != null ? b.name() : C0297c.f130b.name();
        try {
            this.f196a = str.getBytes(name);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(name);
        }
    }

    /* renamed from: a */
    public final void mo5098a(OutputStream outputStream) {
        C0250b.m84a((Object) outputStream, "Output stream");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f196a);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* renamed from: c */
    public final String mo5100c() {
        return "8bit";
    }

    /* renamed from: d */
    public final long mo5101d() {
        return (long) this.f196a.length;
    }

    /* renamed from: e */
    public final String mo5102e() {
        return null;
    }
}
