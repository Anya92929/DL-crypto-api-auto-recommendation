package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* renamed from: org.apache.commons.io.input.ReaderInputStream */
public class ReaderInputStream extends InputStream {

    /* renamed from: a */
    private final Reader f6919a;

    /* renamed from: b */
    private final CharsetEncoder f6920b;

    /* renamed from: c */
    private final CharBuffer f6921c;

    /* renamed from: d */
    private final ByteBuffer f6922d;

    /* renamed from: e */
    private CoderResult f6923e;

    /* renamed from: f */
    private boolean f6924f;

    public ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder) {
        this(reader, charsetEncoder, 1024);
    }

    public ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i) {
        this.f6919a = reader;
        this.f6920b = charsetEncoder;
        this.f6921c = CharBuffer.allocate(i);
        this.f6921c.flip();
        this.f6922d = ByteBuffer.allocate(128);
        this.f6922d.flip();
    }

    public ReaderInputStream(Reader reader, Charset charset, int i) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i);
    }

    public ReaderInputStream(Reader reader, Charset charset) {
        this(reader, charset, 1024);
    }

    public ReaderInputStream(Reader reader, String str, int i) {
        this(reader, Charset.forName(str), i);
    }

    public ReaderInputStream(Reader reader, String str) {
        this(reader, str, 1024);
    }

    public ReaderInputStream(Reader reader) {
        this(reader, Charset.defaultCharset());
    }

    /* renamed from: a */
    private void m7295a() throws IOException {
        if (!this.f6924f && (this.f6923e == null || this.f6923e.isUnderflow())) {
            this.f6921c.compact();
            int position = this.f6921c.position();
            int read = this.f6919a.read(this.f6921c.array(), position, this.f6921c.remaining());
            if (read == -1) {
                this.f6924f = true;
            } else {
                this.f6921c.position(position + read);
            }
            this.f6921c.flip();
        }
        this.f6922d.compact();
        this.f6923e = this.f6920b.encode(this.f6921c, this.f6922d, this.f6924f);
        this.f6922d.flip();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (bArr == null) {
            throw new NullPointerException("Byte array must not be null");
        } else if (i2 < 0 || i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + bArr.length + ", offset=" + i + ", length=" + i2);
        } else if (i2 == 0) {
            return 0;
        } else {
            while (i2 > 0) {
                if (!this.f6922d.hasRemaining()) {
                    m7295a();
                    if (this.f6924f && !this.f6922d.hasRemaining()) {
                        break;
                    }
                } else {
                    int min = Math.min(this.f6922d.remaining(), i2);
                    this.f6922d.get(bArr, i, min);
                    i += min;
                    i2 -= min;
                    i3 += min;
                }
            }
            if (i3 != 0 || !this.f6924f) {
                return i3;
            }
            return -1;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read() throws IOException {
        while (!this.f6922d.hasRemaining()) {
            m7295a();
            if (this.f6924f && !this.f6922d.hasRemaining()) {
                return -1;
            }
        }
        return this.f6922d.get() & 255;
    }

    public void close() throws IOException {
        this.f6919a.close();
    }
}
