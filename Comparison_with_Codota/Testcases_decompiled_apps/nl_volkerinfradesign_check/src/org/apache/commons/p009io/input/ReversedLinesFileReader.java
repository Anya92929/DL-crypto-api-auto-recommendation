package org.apache.commons.p009io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.p009io.Charsets;
import org.apache.commons.p009io.IOUtils;

/* renamed from: org.apache.commons.io.input.ReversedLinesFileReader */
public class ReversedLinesFileReader implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f6925a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Charset f6926b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RandomAccessFile f6927c;

    /* renamed from: d */
    private final long f6928d;

    /* renamed from: e */
    private final long f6929e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final byte[][] f6930f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f6931g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final int f6932h;

    /* renamed from: i */
    private C1948a f6933i;

    /* renamed from: j */
    private boolean f6934j;

    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset().toString());
    }

    public ReversedLinesFileReader(File file, int i, Charset charset) throws IOException {
        this.f6934j = false;
        this.f6925a = i;
        this.f6926b = charset;
        this.f6927c = new RandomAccessFile(file, "r");
        this.f6928d = this.f6927c.length();
        int i2 = (int) (this.f6928d % ((long) i));
        if (i2 > 0) {
            this.f6929e = (this.f6928d / ((long) i)) + 1;
        } else {
            this.f6929e = this.f6928d / ((long) i);
            if (this.f6928d > 0) {
                i2 = i;
            }
        }
        this.f6933i = new C1948a(this.f6929e, i2, (byte[]) null);
        Charset charset2 = Charsets.toCharset(charset);
        if (charset2.newEncoder().maxBytesPerChar() == 1.0f) {
            this.f6932h = 1;
        } else if (charset2 == Charset.forName(CharEncoding.UTF_8)) {
            this.f6932h = 1;
        } else if (charset2 == Charset.forName("Shift_JIS")) {
            this.f6932h = 1;
        } else if (charset2 == Charset.forName(CharEncoding.UTF_16BE) || charset2 == Charset.forName(CharEncoding.UTF_16LE)) {
            this.f6932h = 2;
        } else if (charset2 == Charset.forName(CharEncoding.UTF_16)) {
            throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
        } else {
            throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
        }
        this.f6930f = new byte[][]{IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(charset), IOUtils.LINE_SEPARATOR_UNIX.getBytes(charset), "\r".getBytes(charset)};
        this.f6931g = this.f6930f[0].length;
    }

    public ReversedLinesFileReader(File file, int i, String str) throws IOException {
        this(file, i, Charsets.toCharset(str));
    }

    public String readLine() throws IOException {
        String a = this.f6933i.m7305b();
        while (a == null) {
            this.f6933i = this.f6933i.m7304a();
            if (this.f6933i == null) {
                break;
            }
            a = this.f6933i.m7305b();
        }
        if (!"".equals(a) || this.f6934j) {
            return a;
        }
        this.f6934j = true;
        return readLine();
    }

    public void close() throws IOException {
        this.f6927c.close();
    }

    /* renamed from: org.apache.commons.io.input.ReversedLinesFileReader$a */
    class C1948a {

        /* renamed from: b */
        private final long f6936b;

        /* renamed from: c */
        private final byte[] f6937c;

        /* renamed from: d */
        private byte[] f6938d;

        /* renamed from: e */
        private int f6939e;

        private C1948a(long j, int i, byte[] bArr) throws IOException {
            this.f6936b = j;
            this.f6937c = new byte[((bArr != null ? bArr.length : 0) + i)];
            long a = (j - 1) * ((long) ReversedLinesFileReader.this.f6925a);
            if (j > 0) {
                ReversedLinesFileReader.this.f6927c.seek(a);
                if (ReversedLinesFileReader.this.f6927c.read(this.f6937c, 0, i) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.f6937c, i, bArr.length);
            }
            this.f6939e = this.f6937c.length - 1;
            this.f6938d = null;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public C1948a m7304a() throws IOException {
            if (this.f6939e > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.f6939e);
            } else if (this.f6936b > 1) {
                return new C1948a(this.f6936b - 1, ReversedLinesFileReader.this.f6925a, this.f6938d);
            } else {
                if (this.f6938d == null) {
                    return null;
                }
                throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.f6938d, ReversedLinesFileReader.this.f6926b));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public String m7305b() throws IOException {
            String str;
            boolean z = this.f6936b == 1;
            int i = this.f6939e;
            while (true) {
                if (i > -1) {
                    if (!z && i < ReversedLinesFileReader.this.f6931g) {
                        m7307c();
                        str = null;
                        break;
                    }
                    int a = m7302a(this.f6937c, i);
                    if (a <= 0) {
                        i -= ReversedLinesFileReader.this.f6932h;
                        if (i < 0) {
                            m7307c();
                            str = null;
                            break;
                        }
                    } else {
                        int i2 = i + 1;
                        int i3 = (this.f6939e - i2) + 1;
                        if (i3 < 0) {
                            throw new IllegalStateException("Unexpected negative line length=" + i3);
                        }
                        byte[] bArr = new byte[i3];
                        System.arraycopy(this.f6937c, i2, bArr, 0, i3);
                        str = new String(bArr, ReversedLinesFileReader.this.f6926b);
                        this.f6939e = i - a;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            if (!z || this.f6938d == null) {
                return str;
            }
            String str2 = new String(this.f6938d, ReversedLinesFileReader.this.f6926b);
            this.f6938d = null;
            return str2;
        }

        /* renamed from: c */
        private void m7307c() {
            int i = this.f6939e + 1;
            if (i > 0) {
                this.f6938d = new byte[i];
                System.arraycopy(this.f6937c, 0, this.f6938d, 0, i);
            } else {
                this.f6938d = null;
            }
            this.f6939e = -1;
        }

        /* renamed from: a */
        private int m7302a(byte[] bArr, int i) {
            boolean z;
            for (byte[] bArr2 : ReversedLinesFileReader.this.f6930f) {
                boolean z2 = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr2.length - 1);
                    if (length2 < 0 || bArr[length2] != bArr2[length]) {
                        z = false;
                    } else {
                        z = true;
                    }
                    z2 &= z;
                }
                if (z2) {
                    return bArr2.length;
                }
            }
            return 0;
        }
    }
}
