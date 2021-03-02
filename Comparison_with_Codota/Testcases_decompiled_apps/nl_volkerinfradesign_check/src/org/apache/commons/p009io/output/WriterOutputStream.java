package org.apache.commons.p009io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* renamed from: org.apache.commons.io.output.WriterOutputStream */
public class WriterOutputStream extends OutputStream {

    /* renamed from: a */
    private final Writer f7003a;

    /* renamed from: b */
    private final CharsetDecoder f7004b;

    /* renamed from: c */
    private final boolean f7005c;

    /* renamed from: d */
    private final ByteBuffer f7006d;

    /* renamed from: e */
    private final CharBuffer f7007e;

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder) {
        this(writer, charsetDecoder, 1024, false);
    }

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder, int i, boolean z) {
        this.f7006d = ByteBuffer.allocate(128);
        this.f7003a = writer;
        this.f7004b = charsetDecoder;
        this.f7005c = z;
        this.f7007e = CharBuffer.allocate(i);
    }

    public WriterOutputStream(Writer writer, Charset charset, int i, boolean z) {
        this(writer, charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), i, z);
    }

    public WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, 1024, false);
    }

    public WriterOutputStream(Writer writer, String str, int i, boolean z) {
        this(writer, Charset.forName(str), i, z);
    }

    public WriterOutputStream(Writer writer, String str) {
        this(writer, str, 1024, false);
    }

    public WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), 1024, false);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int min = Math.min(i2, this.f7006d.remaining());
            this.f7006d.put(bArr, i, min);
            m7332a(false);
            i2 -= min;
            i += min;
        }
        if (this.f7005c) {
            m7331a();
        }
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void flush() throws IOException {
        m7331a();
        this.f7003a.flush();
    }

    public void close() throws IOException {
        m7332a(true);
        m7331a();
        this.f7003a.close();
    }

    /* renamed from: a */
    private void m7332a(boolean z) throws IOException {
        CoderResult decode;
        this.f7006d.flip();
        while (true) {
            decode = this.f7004b.decode(this.f7006d, this.f7007e, z);
            if (!decode.isOverflow()) {
                break;
            }
            m7331a();
        }
        if (decode.isUnderflow()) {
            this.f7006d.compact();
            return;
        }
        throw new IOException("Unexpected coder result");
    }

    /* renamed from: a */
    private void m7331a() throws IOException {
        if (this.f7007e.position() > 0) {
            this.f7003a.write(this.f7007e.array(), 0, this.f7007e.position());
            this.f7007e.rewind();
        }
    }
}
