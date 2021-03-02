package org.p004a.p005a.p022f.p023a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0562a;

/* renamed from: org.a.a.f.a.a */
abstract class C0362a {

    /* renamed from: b */
    private static final C0562a f188b = m400a(C0372h.f209a, ": ");

    /* renamed from: c */
    private static final C0562a f189c = m400a(C0372h.f209a, "\r\n");

    /* renamed from: d */
    private static final C0562a f190d = m400a(C0372h.f209a, "--");

    /* renamed from: a */
    protected final Charset f191a;

    /* renamed from: e */
    private final String f192e;

    public C0362a(String str, Charset charset, String str2) {
        C0250b.m84a((Object) str, "Multipart subtype");
        C0250b.m84a((Object) str2, "Multipart boundary");
        this.f191a = charset == null ? C0372h.f209a : charset;
        this.f192e = str2;
    }

    /* renamed from: a */
    private static C0562a m400a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        C0562a aVar = new C0562a(encode.remaining());
        aVar.mo5414a(encode.array(), encode.position(), encode.remaining());
        return aVar;
    }

    /* renamed from: a */
    private void m401a(OutputStream outputStream, boolean z) {
        C0562a a = m400a(this.f191a, this.f192e);
        for (C0366b bVar : mo5093a()) {
            m406a(f190d, outputStream);
            m406a(a, outputStream);
            m406a(f189c, outputStream);
            mo5095a(bVar, outputStream);
            m406a(f189c, outputStream);
            if (z) {
                bVar.mo5103a().mo5098a(outputStream);
            }
            m406a(f189c, outputStream);
        }
        m406a(f190d, outputStream);
        m406a(a, outputStream);
        m406a(f190d, outputStream);
        m406a(f189c, outputStream);
    }

    /* renamed from: a */
    private static void m402a(String str, OutputStream outputStream) {
        m406a(m400a(C0372h.f209a, str), outputStream);
    }

    /* renamed from: a */
    private static void m403a(String str, Charset charset, OutputStream outputStream) {
        m406a(m400a(charset, str), outputStream);
    }

    /* renamed from: a */
    protected static void m404a(C0373i iVar, OutputStream outputStream) {
        m402a(iVar.mo5109a(), outputStream);
        m406a(f188b, outputStream);
        m402a(iVar.mo5110b(), outputStream);
        m406a(f189c, outputStream);
    }

    /* renamed from: a */
    protected static void m405a(C0373i iVar, Charset charset, OutputStream outputStream) {
        m403a(iVar.mo5109a(), charset, outputStream);
        m406a(f188b, outputStream);
        m403a(iVar.mo5110b(), charset, outputStream);
        m406a(f189c, outputStream);
    }

    /* renamed from: a */
    private static void m406a(C0562a aVar, OutputStream outputStream) {
        outputStream.write(aVar.mo5420e(), 0, aVar.mo5419d());
    }

    /* renamed from: a */
    public abstract List mo5093a();

    /* renamed from: a */
    public final void mo5094a(OutputStream outputStream) {
        m401a(outputStream, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5095a(C0366b bVar, OutputStream outputStream);

    /* renamed from: b */
    public final long mo5096b() {
        long j = 0;
        for (C0366b a : mo5093a()) {
            long d = a.mo5103a().mo5101d();
            if (d < 0) {
                return -1;
            }
            j = d + j;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m401a((OutputStream) byteArrayOutputStream, false);
            return ((long) byteArrayOutputStream.toByteArray().length) + j;
        } catch (IOException e) {
            return -1;
        }
    }
}
