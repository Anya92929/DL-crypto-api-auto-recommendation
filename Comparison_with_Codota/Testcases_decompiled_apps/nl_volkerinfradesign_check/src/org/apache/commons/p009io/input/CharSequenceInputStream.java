package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* renamed from: org.apache.commons.io.input.CharSequenceInputStream */
public class CharSequenceInputStream extends InputStream {

    /* renamed from: a */
    private final CharsetEncoder f6895a;

    /* renamed from: b */
    private final CharBuffer f6896b;

    /* renamed from: c */
    private final ByteBuffer f6897c;

    /* renamed from: d */
    private int f6898d;

    public CharSequenceInputStream(CharSequence charSequence, Charset charset, int i) {
        this.f6895a = charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.f6897c = ByteBuffer.allocate(i);
        this.f6897c.flip();
        this.f6896b = CharBuffer.wrap(charSequence);
        this.f6898d = -1;
    }

    public CharSequenceInputStream(CharSequence charSequence, String str, int i) {
        this(charSequence, Charset.forName(str), i);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 2048);
    }

    public CharSequenceInputStream(CharSequence charSequence, String str) {
        this(charSequence, str, 2048);
    }

    /* renamed from: a */
    private void m7292a() throws CharacterCodingException {
        this.f6897c.compact();
        CoderResult encode = this.f6895a.encode(this.f6896b, this.f6897c, true);
        if (encode.isError()) {
            encode.throwException();
        }
        this.f6897c.flip();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (bArr == null) {
            throw new NullPointerException("Byte array is null");
        } else if (i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + bArr.length + ", offset=" + i + ", length=" + i2);
        } else if (i2 == 0) {
            return 0;
        } else {
            if (!this.f6897c.hasRemaining() && !this.f6896b.hasRemaining()) {
                return -1;
            }
            while (i2 > 0) {
                if (!this.f6897c.hasRemaining()) {
                    m7292a();
                    if (!this.f6897c.hasRemaining() && !this.f6896b.hasRemaining()) {
                        break;
                    }
                } else {
                    int min = Math.min(this.f6897c.remaining(), i2);
                    this.f6897c.get(bArr, i, min);
                    i += min;
                    i2 -= min;
                    i3 += min;
                }
            }
            if (i3 != 0 || this.f6896b.hasRemaining()) {
                return i3;
            }
            return -1;
        }
    }

    public int read() throws IOException {
        while (!this.f6897c.hasRemaining()) {
            m7292a();
            if (!this.f6897c.hasRemaining() && !this.f6896b.hasRemaining()) {
                return -1;
            }
        }
        return this.f6897c.get() & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j) throws IOException {
        int i = 0;
        while (j > 0 && this.f6896b.hasRemaining()) {
            this.f6896b.get();
            j--;
            i++;
        }
        return (long) i;
    }

    public int available() throws IOException {
        return this.f6896b.remaining();
    }

    public void close() throws IOException {
    }

    public synchronized void mark(int i) {
        this.f6898d = this.f6896b.position();
    }

    public synchronized void reset() throws IOException {
        if (this.f6898d != -1) {
            this.f6896b.position(this.f6898d);
            this.f6898d = -1;
        }
    }

    public boolean markSupported() {
        return true;
    }
}
