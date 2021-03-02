package okio;

import android.support.p001v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Buffer implements Cloneable, BufferedSink, BufferedSource {

    /* renamed from: c */
    private static final byte[] f6270c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    public C1316jf f6271a;

    /* renamed from: b */
    public long f6272b;

    public long size() {
        return this.f6272b;
    }

    public Buffer buffer() {
        return this;
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void write(int i) {
                Buffer.this.writeByte((int) (byte) i);
            }

            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }

            public void flush() {
            }

            public void close() {
            }

            public String toString() {
                return this + ".outputStream()";
            }
        };
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public BufferedSink emit() {
        return this;
    }

    public boolean exhausted() {
        return this.f6272b == 0;
    }

    public void require(long j) throws EOFException {
        if (this.f6272b < j) {
            throw new EOFException();
        }
    }

    public boolean request(long j) {
        return this.f6272b >= j;
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int read() {
                if (Buffer.this.f6272b > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(Buffer.this.f6272b, 2147483647L);
            }

            public void close() {
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.f6272b);
    }

    public Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        C1319ji.m5708a(this.f6272b, j, j2);
        if (j2 != 0) {
            C1316jf jfVar = this.f6271a;
            while (j >= ((long) (jfVar.f4572c - jfVar.f4571b))) {
                j -= (long) (jfVar.f4572c - jfVar.f4571b);
                jfVar = jfVar.f4575f;
            }
            while (j2 > 0) {
                int i = (int) (((long) jfVar.f4571b) + j);
                int min = (int) Math.min((long) (jfVar.f4572c - i), j2);
                outputStream.write(jfVar.f4570a, i, min);
                j2 -= (long) min;
                jfVar = jfVar.f4575f;
                j = 0;
            }
        }
        return this;
    }

    public Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        C1319ji.m5708a(this.f6272b, j, j2);
        if (j2 != 0) {
            buffer.f6272b += j2;
            C1316jf jfVar = this.f6271a;
            while (j >= ((long) (jfVar.f4572c - jfVar.f4571b))) {
                j -= (long) (jfVar.f4572c - jfVar.f4571b);
                jfVar = jfVar.f4575f;
            }
            while (j2 > 0) {
                C1316jf jfVar2 = new C1316jf(jfVar);
                jfVar2.f4571b = (int) (((long) jfVar2.f4571b) + j);
                jfVar2.f4572c = Math.min(jfVar2.f4571b + ((int) j2), jfVar2.f4572c);
                if (buffer.f6271a == null) {
                    jfVar2.f4576g = jfVar2;
                    jfVar2.f4575f = jfVar2;
                    buffer.f6271a = jfVar2;
                } else {
                    buffer.f6271a.f4576g.mo8802a(jfVar2);
                }
                j2 -= (long) (jfVar2.f4572c - jfVar2.f4571b);
                jfVar = jfVar.f4575f;
                j = 0;
            }
        }
        return this;
    }

    public Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.f6272b);
    }

    public Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        C1316jf jfVar;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        C1319ji.m5708a(this.f6272b, 0, j);
        C1316jf jfVar2 = this.f6271a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (jfVar2.f4572c - jfVar2.f4571b));
            outputStream.write(jfVar2.f4570a, jfVar2.f4571b, min);
            jfVar2.f4571b += min;
            this.f6272b -= (long) min;
            j -= (long) min;
            if (jfVar2.f4571b == jfVar2.f4572c) {
                jfVar = jfVar2.mo8800a();
                this.f6271a = jfVar;
                C1317jg.m5701a(jfVar2);
            } else {
                jfVar = jfVar2;
            }
            jfVar2 = jfVar;
        }
        return this;
    }

    public Buffer readFrom(InputStream inputStream) throws IOException {
        m6886a(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        m6886a(inputStream, j, false);
        return this;
    }

    /* renamed from: a */
    private void m6886a(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j > 0 || z) {
                C1316jf a = mo11169a(1);
                int read = inputStream.read(a.f4570a, a.f4572c, (int) Math.min(j, (long) (2048 - a.f4572c)));
                if (read != -1) {
                    a.f4572c += read;
                    this.f6272b += (long) read;
                    j -= (long) read;
                } else if (!z) {
                    throw new EOFException();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public long completeSegmentByteCount() {
        long j = this.f6272b;
        if (j == 0) {
            return 0;
        }
        C1316jf jfVar = this.f6271a.f4576g;
        if (jfVar.f4572c >= 2048 || !jfVar.f4574e) {
            return j;
        }
        return j - ((long) (jfVar.f4572c - jfVar.f4571b));
    }

    public byte readByte() {
        if (this.f6272b == 0) {
            throw new IllegalStateException("size == 0");
        }
        C1316jf jfVar = this.f6271a;
        int i = jfVar.f4571b;
        int i2 = jfVar.f4572c;
        int i3 = i + 1;
        byte b = jfVar.f4570a[i];
        this.f6272b--;
        if (i3 == i2) {
            this.f6271a = jfVar.mo8800a();
            C1317jg.m5701a(jfVar);
        } else {
            jfVar.f4571b = i3;
        }
        return b;
    }

    public byte getByte(long j) {
        C1319ji.m5708a(this.f6272b, j, 1);
        C1316jf jfVar = this.f6271a;
        while (true) {
            int i = jfVar.f4572c - jfVar.f4571b;
            if (j < ((long) i)) {
                return jfVar.f4570a[jfVar.f4571b + ((int) j)];
            }
            j -= (long) i;
            jfVar = jfVar.f4575f;
        }
    }

    public short readShort() {
        if (this.f6272b < 2) {
            throw new IllegalStateException("size < 2: " + this.f6272b);
        }
        C1316jf jfVar = this.f6271a;
        int i = jfVar.f4571b;
        int i2 = jfVar.f4572c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = jfVar.f4570a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f6272b -= 2;
        if (i4 == i2) {
            this.f6271a = jfVar.mo8800a();
            C1317jg.m5701a(jfVar);
        } else {
            jfVar.f4571b = i4;
        }
        return (short) b;
    }

    public int readInt() {
        if (this.f6272b < 4) {
            throw new IllegalStateException("size < 4: " + this.f6272b);
        }
        C1316jf jfVar = this.f6271a;
        int i = jfVar.f4571b;
        int i2 = jfVar.f4572c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = jfVar.f4570a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i5 = i4 + 1;
        byte b2 = b | ((bArr[i4] & 255) << 8);
        int i6 = i5 + 1;
        byte b3 = b2 | (bArr[i5] & 255);
        this.f6272b -= 4;
        if (i6 == i2) {
            this.f6271a = jfVar.mo8800a();
            C1317jg.m5701a(jfVar);
            return b3;
        }
        jfVar.f4571b = i6;
        return b3;
    }

    public long readLong() {
        if (this.f6272b < 8) {
            throw new IllegalStateException("size < 8: " + this.f6272b);
        }
        C1316jf jfVar = this.f6271a;
        int i = jfVar.f4571b;
        int i2 = jfVar.f4572c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
        }
        byte[] bArr = jfVar.f4570a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        long j = ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i]) & 255) << 56);
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        long j2 = j | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        long j4 = (((long) bArr[i9]) & 255) | j3 | ((((long) bArr[i8]) & 255) << 8);
        this.f6272b -= 8;
        if (i10 == i2) {
            this.f6271a = jfVar.mo8800a();
            C1317jg.m5701a(jfVar);
            return j4;
        }
        jfVar.f4571b = i10;
        return j4;
    }

    public short readShortLe() {
        return C1319ji.m5707a(readShort());
    }

    public int readIntLe() {
        return C1319ji.m5705a(readInt());
    }

    public long readLongLe() {
        return C1319ji.m5706a(readLong());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        if (r7 != r14) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        r20.f6271a = r12.mo8800a();
        p000.C1317jg.m5701a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        if (r4 != false) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00da, code lost:
        r12.f4571b = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r20 = this;
            r0 = r20
            long r2 = r0.f6272b
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0012
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "size == 0"
            r2.<init>(r3)
            throw r2
        L_0x0012:
            r8 = 0
            r6 = 0
            r5 = 0
            r4 = 0
            r10 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r2 = -7
        L_0x001e:
            r0 = r20
            jf r12 = r0.f6271a
            byte[] r13 = r12.f4570a
            int r7 = r12.f4571b
            int r14 = r12.f4572c
        L_0x0028:
            if (r7 >= r14) goto L_0x00b8
            byte r15 = r13[r7]
            r16 = 48
            r0 = r16
            if (r15 < r0) goto L_0x008a
            r16 = 57
            r0 = r16
            if (r15 > r0) goto L_0x008a
            int r16 = 48 - r15
            int r17 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r17 < 0) goto L_0x004b
            int r17 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r17 != 0) goto L_0x007a
            r0 = r16
            long r0 = (long) r0
            r18 = r0
            int r17 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r17 >= 0) goto L_0x007a
        L_0x004b:
            okio.Buffer r2 = new okio.Buffer
            r2.<init>()
            okio.Buffer r2 = r2.writeDecimalLong((long) r8)
            okio.Buffer r2 = r2.writeByte((int) r15)
            if (r5 != 0) goto L_0x005d
            r2.readByte()
        L_0x005d:
            java.lang.NumberFormatException r3 = new java.lang.NumberFormatException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Number too large: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r2 = r2.readUtf8()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        L_0x007a:
            r18 = 10
            long r8 = r8 * r18
            r0 = r16
            long r0 = (long) r0
            r16 = r0
            long r8 = r8 + r16
        L_0x0085:
            int r7 = r7 + 1
            int r6 = r6 + 1
            goto L_0x0028
        L_0x008a:
            r16 = 45
            r0 = r16
            if (r15 != r0) goto L_0x0098
            if (r6 != 0) goto L_0x0098
            r5 = 1
            r16 = 1
            long r2 = r2 - r16
            goto L_0x0085
        L_0x0098:
            if (r6 != 0) goto L_0x00b7
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = java.lang.Integer.toHexString(r15)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x00b7:
            r4 = 1
        L_0x00b8:
            if (r7 != r14) goto L_0x00da
            jf r7 = r12.mo8800a()
            r0 = r20
            r0.f6271a = r7
            p000.C1317jg.m5701a(r12)
        L_0x00c5:
            if (r4 != 0) goto L_0x00cd
            r0 = r20
            jf r7 = r0.f6271a
            if (r7 != 0) goto L_0x001e
        L_0x00cd:
            r0 = r20
            long r2 = r0.f6272b
            long r6 = (long) r6
            long r2 = r2 - r6
            r0 = r20
            r0.f6272b = r2
            if (r5 == 0) goto L_0x00dd
        L_0x00d9:
            return r8
        L_0x00da:
            r12.f4571b = r7
            goto L_0x00c5
        L_0x00dd:
            long r8 = -r8
            goto L_0x00d9
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        if (r7 != r12) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        r18.f6271a = r10.mo8800a();
        p000.C1317jg.m5701a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        if (r2 != false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c9, code lost:
        r10.f4571b = r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r18 = this;
            r0 = r18
            long r2 = r0.f6272b
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0012
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "size == 0"
            r2.<init>(r3)
            throw r2
        L_0x0012:
            r4 = 0
            r3 = 0
            r2 = 0
        L_0x0016:
            r0 = r18
            jf r10 = r0.f6271a
            byte[] r11 = r10.f4570a
            int r6 = r10.f4571b
            int r12 = r10.f4572c
            r7 = r6
        L_0x0021:
            if (r7 >= r12) goto L_0x009c
            byte r8 = r11[r7]
            r6 = 48
            if (r8 < r6) goto L_0x0062
            r6 = 57
            if (r8 > r6) goto L_0x0062
            int r6 = r8 + -48
        L_0x002f:
            r14 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r14 = r14 & r4
            r16 = 0
            int r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r9 == 0) goto L_0x00bd
            okio.Buffer r2 = new okio.Buffer
            r2.<init>()
            okio.Buffer r2 = r2.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r2 = r2.writeByte((int) r8)
            java.lang.NumberFormatException r3 = new java.lang.NumberFormatException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Number too large: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r2 = r2.readUtf8()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        L_0x0062:
            r6 = 97
            if (r8 < r6) goto L_0x006f
            r6 = 102(0x66, float:1.43E-43)
            if (r8 > r6) goto L_0x006f
            int r6 = r8 + -97
            int r6 = r6 + 10
            goto L_0x002f
        L_0x006f:
            r6 = 65
            if (r8 < r6) goto L_0x007c
            r6 = 70
            if (r8 > r6) goto L_0x007c
            int r6 = r8 + -65
            int r6 = r6 + 10
            goto L_0x002f
        L_0x007c:
            if (r3 != 0) goto L_0x009b
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = java.lang.Integer.toHexString(r8)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x009b:
            r2 = 1
        L_0x009c:
            if (r7 != r12) goto L_0x00c9
            jf r6 = r10.mo8800a()
            r0 = r18
            r0.f6271a = r6
            p000.C1317jg.m5701a(r10)
        L_0x00a9:
            if (r2 != 0) goto L_0x00b1
            r0 = r18
            jf r6 = r0.f6271a
            if (r6 != 0) goto L_0x0016
        L_0x00b1:
            r0 = r18
            long r6 = r0.f6272b
            long r2 = (long) r3
            long r2 = r6 - r2
            r0 = r18
            r0.f6272b = r2
            return r4
        L_0x00bd:
            r8 = 4
            long r4 = r4 << r8
            long r8 = (long) r6
            long r8 = r8 | r4
            int r4 = r7 + 1
            int r3 = r3 + 1
            r7 = r4
            r4 = r8
            goto L_0x0021
        L_0x00c9:
            r10.f4571b = r7
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public void readFully(Buffer buffer, long j) throws EOFException {
        if (this.f6272b < j) {
            buffer.write(this, this.f6272b);
            throw new EOFException();
        } else {
            buffer.write(this, j);
        }
    }

    public long readAll(Sink sink) throws IOException {
        long j = this.f6272b;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public String readUtf8() {
        try {
            return readString(this.f6272b, C1319ji.f4581a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8(long j) throws EOFException {
        return readString(j, C1319ji.f4581a);
    }

    public String readString(Charset charset) {
        try {
            return readString(this.f6272b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readString(long j, Charset charset) throws EOFException {
        C1319ji.m5708a(this.f6272b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            C1316jf jfVar = this.f6271a;
            if (((long) jfVar.f4571b) + j > ((long) jfVar.f4572c)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(jfVar.f4570a, jfVar.f4571b, (int) j, charset);
            jfVar.f4571b = (int) (((long) jfVar.f4571b) + j);
            this.f6272b -= j;
            if (jfVar.f4571b != jfVar.f4572c) {
                return str;
            }
            this.f6271a = jfVar.mo8800a();
            C1317jg.m5701a(jfVar);
            return str;
        }
    }

    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return mo11168a(indexOf);
        }
        if (this.f6272b != 0) {
            return readUtf8(this.f6272b);
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return mo11168a(indexOf);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0, Math.min(32, this.f6272b));
        throw new EOFException("\\n not found: size=" + size() + " content=" + buffer.readByteString().hex() + "...");
    }

    /* renamed from: a */
    public String mo11168a(long j) throws EOFException {
        if (j <= 0 || getByte(j - 1) != 13) {
            String readUtf8 = readUtf8(j);
            skip(1);
            return readUtf8;
        }
        String readUtf82 = readUtf8(j - 1);
        skip(2);
        return readUtf82;
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b;
        int i;
        byte b2;
        if (this.f6272b == 0) {
            throw new EOFException();
        }
        byte b3 = getByte(0);
        if ((b3 & 128) == 0) {
            b2 = 0;
            b = b3 & Byte.MAX_VALUE;
            i = 1;
        } else if ((b3 & 224) == 192) {
            b = b3 & 31;
            i = 2;
            b2 = 128;
        } else if ((b3 & 240) == 224) {
            b = b3 & 15;
            i = 3;
            b2 = 2048;
        } else if ((b3 & 248) == 240) {
            b = b3 & 7;
            i = 4;
            b2 = 65536;
        } else {
            skip(1);
            return 65533;
        }
        if (this.f6272b < ((long) i)) {
            throw new EOFException("size < " + i + ": " + this.f6272b + " (to read code point prefixed 0x" + Integer.toHexString(b3) + ")");
        }
        byte b4 = b;
        int i2 = 1;
        while (i2 < i) {
            byte b5 = getByte((long) i2);
            if ((b5 & 192) == 128) {
                i2++;
                b4 = (b5 & 63) | (b4 << 6);
            } else {
                skip((long) i2);
                return 65533;
            }
        }
        skip((long) i);
        if (b4 > 1114111) {
            return 65533;
        }
        if (b4 >= 55296 && b4 <= 57343) {
            return 65533;
        }
        if (b4 < b2) {
            return 65533;
        }
        return b4;
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.f6272b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] readByteArray(long j) throws EOFException {
        C1319ji.m5708a(this.f6272b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        readFully(bArr);
        return bArr;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        C1319ji.m5708a((long) bArr.length, (long) i, (long) i2);
        C1316jf jfVar = this.f6271a;
        if (jfVar == null) {
            return -1;
        }
        int min = Math.min(i2, jfVar.f4572c - jfVar.f4571b);
        System.arraycopy(jfVar.f4570a, jfVar.f4571b, bArr, i, min);
        jfVar.f4571b += min;
        this.f6272b -= (long) min;
        if (jfVar.f4571b != jfVar.f4572c) {
            return min;
        }
        this.f6271a = jfVar.mo8800a();
        C1317jg.m5701a(jfVar);
        return min;
    }

    public void clear() {
        try {
            skip(this.f6272b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f6271a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f6271a.f4572c - this.f6271a.f4571b));
            this.f6272b -= (long) min;
            j -= (long) min;
            C1316jf jfVar = this.f6271a;
            jfVar.f4571b = min + jfVar.f4571b;
            if (this.f6271a.f4571b == this.f6271a.f4572c) {
                C1316jf jfVar2 = this.f6271a;
                this.f6271a = jfVar2.mo8800a();
                C1317jg.m5701a(jfVar2);
            }
        }
    }

    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.mo8805a(this);
        return this;
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 152 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.Buffer writeUtf8(java.lang.String r10, int r11, int r12) {
        /*
            r9 = this;
            r8 = 57343(0xdfff, float:8.0355E-41)
            r7 = 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "string == null"
            r0.<init>(r1)
            throw r0
        L_0x000f:
            if (r11 >= 0) goto L_0x002a
            java.lang.IllegalAccessError r0 = new java.lang.IllegalAccessError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "beginIndex < 0: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x002a:
            if (r12 >= r11) goto L_0x004f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "endIndex < beginIndex: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r2 = " < "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x004f:
            int r0 = r10.length()
            if (r12 <= r0) goto L_0x0090
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "endIndex > string.length: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r2 = " > "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r10.length()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x007c:
            r0 = 0
        L_0x007d:
            r2 = 56319(0xdbff, float:7.892E-41)
            if (r1 > r2) goto L_0x0089
            r2 = 56320(0xdc00, float:7.8921E-41)
            if (r0 < r2) goto L_0x0089
            if (r0 <= r8) goto L_0x0114
        L_0x0089:
            r0 = 63
            r9.writeByte((int) r0)
            int r11 = r11 + 1
        L_0x0090:
            if (r11 >= r12) goto L_0x0145
            char r1 = r10.charAt(r11)
            if (r1 >= r7) goto L_0x00d2
            r0 = 1
            jf r2 = r9.mo11169a((int) r0)
            byte[] r3 = r2.f4570a
            int r0 = r2.f4572c
            int r4 = r0 - r11
            int r0 = 2048 - r4
            int r5 = java.lang.Math.min(r12, r0)
            int r0 = r11 + 1
            int r6 = r4 + r11
            byte r1 = (byte) r1
            r3[r6] = r1
        L_0x00b0:
            if (r0 >= r5) goto L_0x00b8
            char r6 = r10.charAt(r0)
            if (r6 < r7) goto L_0x00ca
        L_0x00b8:
            int r1 = r0 + r4
            int r3 = r2.f4572c
            int r1 = r1 - r3
            int r3 = r2.f4572c
            int r3 = r3 + r1
            r2.f4572c = r3
            long r2 = r9.f6272b
            long r4 = (long) r1
            long r2 = r2 + r4
            r9.f6272b = r2
        L_0x00c8:
            r11 = r0
            goto L_0x0090
        L_0x00ca:
            int r1 = r0 + 1
            int r0 = r0 + r4
            byte r6 = (byte) r6
            r3[r0] = r6
            r0 = r1
            goto L_0x00b0
        L_0x00d2:
            r0 = 2048(0x800, float:2.87E-42)
            if (r1 >= r0) goto L_0x00e7
            int r0 = r1 >> 6
            r0 = r0 | 192(0xc0, float:2.69E-43)
            r9.writeByte((int) r0)
            r0 = r1 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            r9.writeByte((int) r0)
            int r0 = r11 + 1
            goto L_0x00c8
        L_0x00e7:
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r0) goto L_0x00ee
            if (r1 <= r8) goto L_0x0108
        L_0x00ee:
            int r0 = r1 >> 12
            r0 = r0 | 224(0xe0, float:3.14E-43)
            r9.writeByte((int) r0)
            int r0 = r1 >> 6
            r0 = r0 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            r9.writeByte((int) r0)
            r0 = r1 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            r9.writeByte((int) r0)
            int r0 = r11 + 1
            goto L_0x00c8
        L_0x0108:
            int r0 = r11 + 1
            if (r0 >= r12) goto L_0x007c
            int r0 = r11 + 1
            char r0 = r10.charAt(r0)
            goto L_0x007d
        L_0x0114:
            r2 = 65536(0x10000, float:9.18355E-41)
            r3 = -55297(0xffffffffffff27ff, float:NaN)
            r1 = r1 & r3
            int r1 = r1 << 10
            r3 = -56321(0xffffffffffff23ff, float:NaN)
            r0 = r0 & r3
            r0 = r0 | r1
            int r0 = r0 + r2
            int r1 = r0 >> 18
            r1 = r1 | 240(0xf0, float:3.36E-43)
            r9.writeByte((int) r1)
            int r1 = r0 >> 12
            r1 = r1 & 63
            r1 = r1 | 128(0x80, float:1.794E-43)
            r9.writeByte((int) r1)
            int r1 = r0 >> 6
            r1 = r1 & 63
            r1 = r1 | 128(0x80, float:1.794E-43)
            r9.writeByte((int) r1)
            r0 = r0 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            r9.writeByte((int) r0)
            int r0 = r11 + 2
            goto L_0x00c8
        L_0x0145:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.writeUtf8(java.lang.String, int, int):okio.Buffer");
    }

    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C1319ji.f4581a)) {
            return writeUtf8(str);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        C1319ji.m5708a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            C1316jf a = mo11169a(1);
            int min = Math.min(i3 - i, 2048 - a.f4572c);
            System.arraycopy(bArr, i, a.f4570a, a.f4572c, min);
            i += min;
            a.f4572c = min + a.f4572c;
        }
        this.f6272b += (long) i2;
        return this;
    }

    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    public Buffer writeByte(int i) {
        C1316jf a = mo11169a(1);
        byte[] bArr = a.f4570a;
        int i2 = a.f4572c;
        a.f4572c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f6272b++;
        return this;
    }

    public Buffer writeShort(int i) {
        C1316jf a = mo11169a(2);
        byte[] bArr = a.f4570a;
        int i2 = a.f4572c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        a.f4572c = i3 + 1;
        this.f6272b += 2;
        return this;
    }

    public Buffer writeShortLe(int i) {
        return writeShort((int) C1319ji.m5707a((short) i));
    }

    public Buffer writeInt(int i) {
        C1316jf a = mo11169a(4);
        byte[] bArr = a.f4570a;
        int i2 = a.f4572c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        a.f4572c = i5 + 1;
        this.f6272b += 4;
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(C1319ji.m5705a(i));
    }

    public Buffer writeLong(long j) {
        C1316jf a = mo11169a(8);
        byte[] bArr = a.f4570a;
        int i = a.f4572c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        a.f4572c = i8 + 1;
        this.f6272b += 8;
        return this;
    }

    public Buffer writeLongLe(long j) {
        return writeLong(C1319ji.m5706a(j));
    }

    public Buffer writeDecimalLong(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return writeByte(48);
        }
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
            j2 = j;
        }
        if (j2 < 100000000) {
            i = j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else {
            i = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        C1316jf a = mo11169a(i);
        byte[] bArr = a.f4570a;
        int i2 = a.f4572c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f6270c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        a.f4572c += i;
        this.f6272b = ((long) i) + this.f6272b;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C1316jf a = mo11169a(numberOfTrailingZeros);
        byte[] bArr = a.f4570a;
        int i = a.f4572c;
        for (int i2 = (a.f4572c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f6270c[(int) (15 & j)];
            j >>>= 4;
        }
        a.f4572c += numberOfTrailingZeros;
        this.f6272b = ((long) numberOfTrailingZeros) + this.f6272b;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1316jf mo11169a(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        } else if (this.f6271a == null) {
            this.f6271a = C1317jg.m5700a();
            C1316jf jfVar = this.f6271a;
            C1316jf jfVar2 = this.f6271a;
            C1316jf jfVar3 = this.f6271a;
            jfVar2.f4576g = jfVar3;
            jfVar.f4575f = jfVar3;
            return jfVar3;
        } else {
            C1316jf jfVar4 = this.f6271a.f4576g;
            if (jfVar4.f4572c + i > 2048 || !jfVar4.f4574e) {
                return jfVar4.mo8802a(C1317jg.m5700a());
            }
            return jfVar4;
        }
    }

    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            C1319ji.m5708a(buffer.f6272b, 0, j);
            while (j > 0) {
                if (j < ((long) (buffer.f6271a.f4572c - buffer.f6271a.f4571b))) {
                    C1316jf jfVar = this.f6271a != null ? this.f6271a.f4576g : null;
                    if (jfVar != null && jfVar.f4574e) {
                        if ((((long) jfVar.f4572c) + j) - ((long) (jfVar.f4573d ? 0 : jfVar.f4571b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            buffer.f6271a.mo8803a(jfVar, (int) j);
                            buffer.f6272b -= j;
                            this.f6272b += j;
                            return;
                        }
                    }
                    buffer.f6271a = buffer.f6271a.mo8801a((int) j);
                }
                C1316jf jfVar2 = buffer.f6271a;
                long j2 = (long) (jfVar2.f4572c - jfVar2.f4571b);
                buffer.f6271a = jfVar2.mo8800a();
                if (this.f6271a == null) {
                    this.f6271a = jfVar2;
                    C1316jf jfVar3 = this.f6271a;
                    C1316jf jfVar4 = this.f6271a;
                    C1316jf jfVar5 = this.f6271a;
                    jfVar4.f4576g = jfVar5;
                    jfVar3.f4575f = jfVar5;
                } else {
                    this.f6271a.f4576g.mo8802a(jfVar2).mo8804b();
                }
                buffer.f6272b -= j2;
                this.f6272b += j2;
                j -= j2;
            }
        }
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f6272b == 0) {
            return -1;
        } else {
            if (j > this.f6272b) {
                j = this.f6272b;
            }
            buffer.write(this, j);
            return j;
        }
    }

    public long indexOf(byte b) {
        return indexOf(b, 0);
    }

    public long indexOf(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C1316jf jfVar = this.f6271a;
        if (jfVar == null) {
            return -1;
        }
        C1316jf jfVar2 = jfVar;
        long j2 = 0;
        do {
            int i = jfVar2.f4572c - jfVar2.f4571b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = jfVar2.f4570a;
                int i2 = jfVar2.f4572c;
                for (int i3 = (int) (((long) jfVar2.f4571b) + j); i3 < i2; i3++) {
                    if (bArr[i3] == b) {
                        return (j2 + ((long) i3)) - ((long) jfVar2.f4571b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            jfVar2 = jfVar2.f4575f;
        } while (jfVar2 != this.f6271a);
        return -1;
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) throws IOException {
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        while (true) {
            long indexOf = indexOf(byteString.getByte(0), j);
            if (indexOf == -1) {
                return -1;
            }
            if (mo11170a(indexOf, byteString)) {
                return indexOf;
            }
            j = indexOf + 1;
        }
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C1316jf jfVar = this.f6271a;
        if (jfVar == null) {
            return -1;
        }
        long j2 = 0;
        byte[] byteArray = byteString.toByteArray();
        do {
            int i = jfVar.f4572c - jfVar.f4571b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = jfVar.f4570a;
                long j3 = (long) jfVar.f4572c;
                for (long j4 = ((long) jfVar.f4571b) + j; j4 < j3; j4++) {
                    byte b = bArr[(int) j4];
                    for (byte b2 : byteArray) {
                        if (b == b2) {
                            return (j2 + j4) - ((long) jfVar.f4571b);
                        }
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            jfVar = jfVar.f4575f;
        } while (jfVar != this.f6271a);
        return -1;
    }

    /* renamed from: a */
    public boolean mo11170a(long j, ByteString byteString) {
        int size = byteString.size();
        if (this.f6272b - j < ((long) size)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (getByte(((long) i) + j) != byteString.getByte(i)) {
                return false;
            }
        }
        return true;
    }

    public void flush() {
    }

    public void close() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (this.f6272b != buffer.f6272b) {
            return false;
        }
        if (this.f6272b == 0) {
            return true;
        }
        C1316jf jfVar = this.f6271a;
        C1316jf jfVar2 = buffer.f6271a;
        int i = jfVar.f4571b;
        int i2 = jfVar2.f4571b;
        while (j < this.f6272b) {
            long min = (long) Math.min(jfVar.f4572c - i, jfVar2.f4572c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = jfVar.f4570a[i];
                int i5 = i2 + 1;
                if (b != jfVar2.f4570a[i2]) {
                    return false;
                }
                i3++;
                i2 = i5;
                i = i4;
            }
            if (i == jfVar.f4572c) {
                jfVar = jfVar.f4575f;
                i = jfVar.f4571b;
            }
            if (i2 == jfVar2.f4572c) {
                jfVar2 = jfVar2.f4575f;
                i2 = jfVar2.f4571b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C1316jf jfVar = this.f6271a;
        if (jfVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jfVar.f4571b;
            int i3 = jfVar.f4572c;
            while (i2 < i3) {
                i2++;
                i = jfVar.f4570a[i2] + (i * 31);
            }
            jfVar = jfVar.f4575f;
        } while (jfVar != this.f6271a);
        return i;
    }

    public String toString() {
        if (this.f6272b == 0) {
            return "Buffer[size=0]";
        }
        if (this.f6272b <= 16) {
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.f6272b), clone().readByteString().hex()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-128");  //CRYPTOGRAPHIC API CALLSITE 17
            instance.update(this.f6271a.f4570a, this.f6271a.f4571b, this.f6271a.f4572c - this.f6271a.f4571b); //CRYPTOGRAPHIC API CALLSITE 18
            for (C1316jf jfVar = this.f6271a.f4575f; jfVar != this.f6271a; jfVar = jfVar.f4575f) {
                instance.(jfVar.f4570a, jfVar.f4571b, jfVar.f4572c - jfVar.f4571b);  //CRYPTOGRAPHIC API CALLSITE 20
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.f6272b), ByteString.m6892of(instance.digest()).hex()}); //CRYPTOGRAPHIC API CALLSITE 19
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f6272b == 0) {
            return buffer;
        }
        buffer.f6271a = new C1316jf(this.f6271a);
        C1316jf jfVar = buffer.f6271a;
        C1316jf jfVar2 = buffer.f6271a;
        C1316jf jfVar3 = buffer.f6271a;
        jfVar2.f4576g = jfVar3;
        jfVar.f4575f = jfVar3;
        for (C1316jf jfVar4 = this.f6271a.f4575f; jfVar4 != this.f6271a; jfVar4 = jfVar4.f4575f) {
            buffer.f6271a.f4576g.mo8802a(new C1316jf(jfVar4));
        }
        buffer.f6272b = this.f6272b;
        return buffer;
    }

    public ByteString snapshot() {
        if (this.f6272b <= 2147483647L) {
            return snapshot((int) this.f6272b);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f6272b);
    }

    public ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new C1318jh(this, i);
    }
}
