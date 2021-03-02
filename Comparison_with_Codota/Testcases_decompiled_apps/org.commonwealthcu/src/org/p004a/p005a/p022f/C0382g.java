package org.p004a.p005a.p022f;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0552d;

/* renamed from: org.a.a.f.g */
public class C0382g extends C0361a implements Cloneable {

    /* renamed from: a */
    private byte[] f234a;

    public C0382g(String str, C0380e eVar) {
        C0250b.m84a((Object) str, "Source string");
        Charset b = eVar != null ? eVar.mo5122b() : null;
        b = b == null ? C0552d.f622a : b;
        try {
            this.f234a = str.getBytes(b.name());
            if (eVar != null) {
                mo5086a(eVar.toString());
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(b.name());
        }
    }

    /* renamed from: a */
    public final void mo4951a(OutputStream outputStream) {
        C0250b.m84a((Object) outputStream, "Output stream");
        outputStream.write(this.f234a);
        outputStream.flush();
    }

    /* renamed from: a */
    public final boolean mo4952a() {
        return true;
    }

    /* renamed from: c */
    public final long mo5116c() {
        return (long) this.f234a.length;
    }

    public Object clone() {
        return super.clone();
    }

    /* renamed from: f */
    public final InputStream mo4955f() {
        return new ByteArrayInputStream(this.f234a);
    }

    /* renamed from: g */
    public final boolean mo5117g() {
        return false;
    }
}
