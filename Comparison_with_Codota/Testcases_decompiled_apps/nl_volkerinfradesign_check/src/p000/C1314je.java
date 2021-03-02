package p000;

import android.support.p001v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: je */
public final class C1314je implements BufferedSource {

    /* renamed from: a */
    public final Buffer f4566a;

    /* renamed from: b */
    public final Source f4567b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f4568c;

    public C1314je(Source source, Buffer buffer) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f4566a = buffer;
        this.f4567b = source;
    }

    public C1314je(Source source) {
        this(source, new Buffer());
    }

    public Buffer buffer() {
        return this.f4566a;
    }

    public long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f4568c) {
            throw new IllegalStateException("closed");
        } else if (this.f4566a.f6272b == 0 && this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
            return -1;
        } else {
            return this.f4566a.read(buffer, Math.min(j, this.f4566a.f6272b));
        }
    }

    public boolean exhausted() throws IOException {
        if (!this.f4568c) {
            return this.f4566a.exhausted() && this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public boolean request(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f4568c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f4566a.f6272b < j) {
                if (this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte readByte() throws IOException {
        require(1);
        return this.f4566a.readByte();
    }

    public ByteString readByteString() throws IOException {
        this.f4566a.writeAll(this.f4567b);
        return this.f4566a.readByteString();
    }

    public ByteString readByteString(long j) throws IOException {
        require(j);
        return this.f4566a.readByteString(j);
    }

    public byte[] readByteArray() throws IOException {
        this.f4566a.writeAll(this.f4567b);
        return this.f4566a.readByteArray();
    }

    public byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.f4566a.readByteArray(j);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.f4566a.readFully(bArr);
        } catch (EOFException e) {
            EOFException eOFException = e;
            int i = 0;
            while (this.f4566a.f6272b > 0) {
                int read = this.f4566a.read(bArr, i, (int) this.f4566a.f6272b);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw eOFException;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        C1319ji.m5708a((long) bArr.length, (long) i, (long) i2);
        if (this.f4566a.f6272b == 0 && this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
            return -1;
        }
        return this.f4566a.read(bArr, i, (int) Math.min((long) i2, this.f4566a.f6272b));
    }

    public void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.f4566a.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.f4566a);
            throw e;
        }
    }

    public long readAll(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1) {
            long completeSegmentByteCount = this.f4566a.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(this.f4566a, completeSegmentByteCount);
            }
        }
        if (this.f4566a.size() <= 0) {
            return j;
        }
        long size = j + this.f4566a.size();
        sink.write(this.f4566a, this.f4566a.size());
        return size;
    }

    public String readUtf8() throws IOException {
        this.f4566a.writeAll(this.f4567b);
        return this.f4566a.readUtf8();
    }

    public String readUtf8(long j) throws IOException {
        require(j);
        return this.f4566a.readUtf8(j);
    }

    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f4566a.writeAll(this.f4567b);
        return this.f4566a.readString(charset);
    }

    public String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.f4566a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.f4566a.mo11168a(indexOf);
        }
        if (this.f4566a.f6272b != 0) {
            return readUtf8(this.f4566a.f6272b);
        }
        return null;
    }

    public String readUtf8LineStrict() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.f4566a.mo11168a(indexOf);
        }
        Buffer buffer = new Buffer();
        this.f4566a.copyTo(buffer, 0, Math.min(32, this.f4566a.size()));
        throw new EOFException("\\n not found: size=" + this.f4566a.size() + " content=" + buffer.readByteString().hex() + "...");
    }

    public int readUtf8CodePoint() throws IOException {
        require(1);
        byte b = this.f4566a.getByte(0);
        if ((b & 224) == 192) {
            require(2);
        } else if ((b & 240) == 224) {
            require(3);
        } else if ((b & 248) == 240) {
            require(4);
        }
        return this.f4566a.readUtf8CodePoint();
    }

    public short readShort() throws IOException {
        require(2);
        return this.f4566a.readShort();
    }

    public short readShortLe() throws IOException {
        require(2);
        return this.f4566a.readShortLe();
    }

    public int readInt() throws IOException {
        require(4);
        return this.f4566a.readInt();
    }

    public int readIntLe() throws IOException {
        require(4);
        return this.f4566a.readIntLe();
    }

    public long readLong() throws IOException {
        require(8);
        return this.f4566a.readLong();
    }

    public long readLongLe() throws IOException {
        require(8);
        return this.f4566a.readLongLe();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.IOException {
        /*
            r6 = this;
            r1 = 0
            r2 = 1
            r6.require(r2)
            r0 = r1
        L_0x0007:
            int r2 = r0 + 1
            long r2 = (long) r2
            boolean r2 = r6.request(r2)
            if (r2 == 0) goto L_0x003f
            okio.Buffer r2 = r6.f4566a
            long r4 = (long) r0
            byte r2 = r2.getByte(r4)
            r3 = 48
            if (r2 < r3) goto L_0x001f
            r3 = 57
            if (r2 <= r3) goto L_0x003c
        L_0x001f:
            if (r0 != 0) goto L_0x0025
            r3 = 45
            if (r2 == r3) goto L_0x003c
        L_0x0025:
            if (r0 != 0) goto L_0x003f
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was %#x"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r4[r1] = r2
            java.lang.String r1 = java.lang.String.format(r3, r4)
            r0.<init>(r1)
            throw r0
        L_0x003c:
            int r0 = r0 + 1
            goto L_0x0007
        L_0x003f:
            okio.Buffer r0 = r6.f4566a
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1314je.readDecimalLong():long");
    }

    public long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int i = 0;
        while (true) {
            if (!request((long) (i + 1))) {
                break;
            }
            byte b = this.f4566a.getByte((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i++;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f4566a.readHexadecimalUnsignedLong();
    }

    public void skip(long j) throws IOException {
        if (this.f4568c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f4566a.f6272b == 0 && this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f4566a.size());
            this.f4566a.skip(min);
            j -= min;
        }
    }

    public long indexOf(byte b) throws IOException {
        return indexOf(b, 0);
    }

    public long indexOf(byte b, long j) throws IOException {
        if (this.f4568c) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.f4566a.f6272b) {
            if (this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            }
        }
        do {
            long indexOf = this.f4566a.indexOf(b, j);
            if (indexOf != -1) {
                return indexOf;
            }
            j = this.f4566a.f6272b;
        } while (this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
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
            if (m5693a(indexOf, byteString)) {
                return indexOf;
            }
            j = indexOf + 1;
        }
    }

    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) throws IOException {
        if (this.f4568c) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.f4566a.f6272b) {
            if (this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            }
        }
        do {
            long indexOfElement = this.f4566a.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            j = this.f4566a.f6272b;
        } while (this.f4567b.read(this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
        return -1;
    }

    /* renamed from: a */
    private boolean m5693a(long j, ByteString byteString) throws IOException {
        return request(((long) byteString.size()) + j) && this.f4566a.mo11170a(j, byteString);
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int read() throws IOException {
                if (C1314je.this.f4568c) {
                    throw new IOException("closed");
                } else if (C1314je.this.f4566a.f6272b == 0 && C1314je.this.f4567b.read(C1314je.this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    return -1;
                } else {
                    return C1314je.this.f4566a.readByte() & 255;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (C1314je.this.f4568c) {
                    throw new IOException("closed");
                }
                C1319ji.m5708a((long) bArr.length, (long) i, (long) i2);
                if (C1314je.this.f4566a.f6272b == 0 && C1314je.this.f4567b.read(C1314je.this.f4566a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    return -1;
                }
                return C1314je.this.f4566a.read(bArr, i, i2);
            }

            public int available() throws IOException {
                if (!C1314je.this.f4568c) {
                    return (int) Math.min(C1314je.this.f4566a.f6272b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                C1314je.this.close();
            }

            public String toString() {
                return C1314je.this + ".inputStream()";
            }
        };
    }

    public void close() throws IOException {
        if (!this.f4568c) {
            this.f4568c = true;
            this.f4567b.close();
            this.f4566a.clear();
        }
    }

    public Timeout timeout() {
        return this.f4567b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f4567b + ")";
    }
}
