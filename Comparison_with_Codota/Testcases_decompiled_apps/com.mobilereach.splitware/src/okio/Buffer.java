package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, SktBtIscpProtocol.kSymbologyIdEan13CompositeCCB, SktBtIscpProtocol.kSymbologyIdEan8CompositeCCB, SktBtIscpProtocol.kSymbologyIdUpcACompositeCCB, 97, SktBtIscpProtocol.kFrameSetupBarcodeData, 99, SktBtIscpProtocol.kFrameTypeBarcodeDataEx2, SktBtIscpProtocol.kSetupGroupDataEditing, SktBtIscpProtocol.kSetupGroupBluetooth};
    Segment head;
    long size;

    public long size() {
        return this.size;
    }

    public Buffer buffer() {
        return this;
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void write(int b) {
                Buffer.this.writeByte((int) (byte) b);
            }

            public void write(byte[] data, int offset, int byteCount) {
                Buffer.this.write(data, offset, byteCount);
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
        return this.size == 0;
    }

    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public int read(byte[] sink, int offset, int byteCount) {
                return Buffer.this.read(sink, offset, byteCount);
            }

            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public void close() {
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public Buffer copyTo(OutputStream out) throws IOException {
        return copyTo(out, 0, this.size);
    }

    public Buffer copyTo(OutputStream out, long offset, long byteCount) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, offset, byteCount);
        if (byteCount != 0) {
            Segment s = this.head;
            while (offset >= ((long) (s.limit - s.pos))) {
                offset -= (long) (s.limit - s.pos);
                s = s.next;
            }
            while (byteCount > 0) {
                int pos = (int) (((long) s.pos) + offset);
                int toCopy = (int) Math.min((long) (s.limit - pos), byteCount);
                out.write(s.data, pos, toCopy);
                byteCount -= (long) toCopy;
                offset = 0;
                s = s.next;
            }
        }
        return this;
    }

    public Buffer copyTo(Buffer out, long offset, long byteCount) {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, offset, byteCount);
        if (byteCount != 0) {
            out.size += byteCount;
            Segment s = this.head;
            while (offset >= ((long) (s.limit - s.pos))) {
                offset -= (long) (s.limit - s.pos);
                s = s.next;
            }
            while (byteCount > 0) {
                Segment copy = new Segment(s);
                copy.pos = (int) (((long) copy.pos) + offset);
                copy.limit = Math.min(copy.pos + ((int) byteCount), copy.limit);
                if (out.head == null) {
                    copy.prev = copy;
                    copy.next = copy;
                    out.head = copy;
                } else {
                    out.head.prev.push(copy);
                }
                byteCount -= (long) (copy.limit - copy.pos);
                offset = 0;
                s = s.next;
            }
        }
        return this;
    }

    public Buffer writeTo(OutputStream out) throws IOException {
        return writeTo(out, this.size);
    }

    public Buffer writeTo(OutputStream out, long byteCount) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0, byteCount);
        Segment s = this.head;
        while (byteCount > 0) {
            int toCopy = (int) Math.min(byteCount, (long) (s.limit - s.pos));
            out.write(s.data, s.pos, toCopy);
            s.pos += toCopy;
            this.size -= (long) toCopy;
            byteCount -= (long) toCopy;
            if (s.pos == s.limit) {
                Segment toRecycle = s;
                s = toRecycle.pop();
                this.head = s;
                SegmentPool.recycle(toRecycle);
            }
        }
        return this;
    }

    public Buffer readFrom(InputStream in) throws IOException {
        readFrom(in, Long.MAX_VALUE, true);
        return this;
    }

    public Buffer readFrom(InputStream in, long byteCount) throws IOException {
        if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        }
        readFrom(in, byteCount, false);
        return this;
    }

    private void readFrom(InputStream in, long byteCount, boolean forever) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (byteCount > 0 || forever) {
                Segment tail = writableSegment(1);
                int bytesRead = in.read(tail.data, tail.limit, (int) Math.min(byteCount, (long) (2048 - tail.limit)));
                if (bytesRead != -1) {
                    tail.limit += bytesRead;
                    this.size += (long) bytesRead;
                    byteCount -= (long) bytesRead;
                } else if (!forever) {
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
        long result = this.size;
        if (result == 0) {
            return 0;
        }
        Segment tail = this.head.prev;
        if (tail.limit < 2048 && tail.owner) {
            result -= (long) (tail.limit - tail.pos);
        }
        return result;
    }

    public byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        int pos2 = pos + 1;
        byte b = segment.data[pos];
        this.size--;
        if (pos2 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos2;
        }
        return b;
    }

    public byte getByte(long pos) {
        Util.checkOffsetAndCount(this.size, pos, 1);
        Segment s = this.head;
        while (true) {
            int segmentByteCount = s.limit - s.pos;
            if (pos < ((long) segmentByteCount)) {
                return s.data[s.pos + ((int) pos)];
            }
            pos -= (long) segmentByteCount;
            s = s.next;
        }
    }

    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int s = ((data[pos] & 255) << 8) | (data[pos2] & 255);
        this.size -= 2;
        if (pos3 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos3;
        }
        return (short) s;
    }

    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int pos4 = pos3 + 1;
        int pos5 = pos4 + 1;
        byte b = ((data[pos] & 255) << 24) | ((data[pos2] & 255) << 16) | ((data[pos3] & 255) << 8) | (data[pos4] & 255);
        this.size -= 4;
        if (pos5 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return b;
        }
        segment.pos = pos5;
        return b;
    }

    public long readLong() {
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int pos4 = pos3 + 1;
        int pos5 = pos4 + 1;
        int pos6 = pos5 + 1;
        int pos7 = pos6 + 1;
        int pos8 = pos7 + 1;
        int pos9 = pos8 + 1;
        long j = ((((long) data[pos]) & 255) << 56) | ((((long) data[pos2]) & 255) << 48) | ((((long) data[pos3]) & 255) << 40) | ((((long) data[pos4]) & 255) << 32) | ((((long) data[pos5]) & 255) << 24) | ((((long) data[pos6]) & 255) << 16) | ((((long) data[pos7]) & 255) << 8) | (((long) data[pos8]) & 255);
        this.size -= 8;
        if (pos9 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return j;
        }
        segment.pos = pos9;
        return j;
    }

    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r10 != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        r5.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r5.readUtf8());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        if (r11 != r9) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        r24.head = r17.pop();
        okio.SegmentPool.recycle(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d4, code lost:
        if (r8 != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f4, code lost:
        r17.pos = r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r24 = this;
            r0 = r24
            long r0 = r0.size
            r20 = r0
            r22 = 0
            int r20 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r20 != 0) goto L_0x0014
            java.lang.IllegalStateException r20 = new java.lang.IllegalStateException
            java.lang.String r21 = "size == 0"
            r20.<init>(r21)
            throw r20
        L_0x0014:
            r18 = 0
            r16 = 0
            r10 = 0
            r8 = 0
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r12 = -7
        L_0x0021:
            r0 = r24
            okio.Segment r0 = r0.head
            r17 = r0
            r0 = r17
            byte[] r6 = r0.data
            r0 = r17
            int r11 = r0.pos
            r0 = r17
            int r9 = r0.limit
        L_0x0033:
            if (r11 >= r9) goto L_0x00c5
            byte r4 = r6[r11]
            r20 = 48
            r0 = r20
            if (r4 < r0) goto L_0x0097
            r20 = 57
            r0 = r20
            if (r4 > r0) goto L_0x0097
            int r7 = 48 - r4
            int r20 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r20 < 0) goto L_0x0054
            int r20 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r20 != 0) goto L_0x0089
            long r0 = (long) r7
            r20 = r0
            int r20 = (r20 > r12 ? 1 : (r20 == r12 ? 0 : -1))
            if (r20 >= 0) goto L_0x0089
        L_0x0054:
            okio.Buffer r20 = new okio.Buffer
            r20.<init>()
            r0 = r20
            r1 = r18
            okio.Buffer r20 = r0.writeDecimalLong((long) r1)
            r0 = r20
            okio.Buffer r5 = r0.writeByte((int) r4)
            if (r10 != 0) goto L_0x006c
            r5.readByte()
        L_0x006c:
            java.lang.NumberFormatException r20 = new java.lang.NumberFormatException
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r21.<init>()
            java.lang.String r22 = "Number too large: "
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r22 = r5.readUtf8()
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r20.<init>(r21)
            throw r20
        L_0x0089:
            r20 = 10
            long r18 = r18 * r20
            long r0 = (long) r7
            r20 = r0
            long r18 = r18 + r20
        L_0x0092:
            int r11 = r11 + 1
            int r16 = r16 + 1
            goto L_0x0033
        L_0x0097:
            r20 = 45
            r0 = r20
            if (r4 != r0) goto L_0x00a5
            if (r16 != 0) goto L_0x00a5
            r10 = 1
            r20 = 1
            long r12 = r12 - r20
            goto L_0x0092
        L_0x00a5:
            if (r16 != 0) goto L_0x00c4
            java.lang.NumberFormatException r20 = new java.lang.NumberFormatException
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r21.<init>()
            java.lang.String r22 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r22 = java.lang.Integer.toHexString(r4)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r20.<init>(r21)
            throw r20
        L_0x00c4:
            r8 = 1
        L_0x00c5:
            if (r11 != r9) goto L_0x00f4
            okio.Segment r20 = r17.pop()
            r0 = r20
            r1 = r24
            r1.head = r0
            okio.SegmentPool.recycle(r17)
        L_0x00d4:
            if (r8 != 0) goto L_0x00de
            r0 = r24
            okio.Segment r0 = r0.head
            r20 = r0
            if (r20 != 0) goto L_0x0021
        L_0x00de:
            r0 = r24
            long r0 = r0.size
            r20 = r0
            r0 = r16
            long r0 = (long) r0
            r22 = r0
            long r20 = r20 - r22
            r0 = r20
            r2 = r24
            r2.size = r0
            if (r10 == 0) goto L_0x00f9
        L_0x00f3:
            return r18
        L_0x00f4:
            r0 = r17
            r0.pos = r11
            goto L_0x00d4
        L_0x00f9:
            r0 = r18
            long r0 = -r0
            r18 = r0
            goto L_0x00f3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        if (r8 != r7) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009d, code lost:
        r18.head = r10.pop();
        okio.SegmentPool.recycle(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        if (r6 != false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        r10.pos = r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r18 = this;
            r0 = r18
            long r14 = r0.size
            r16 = 0
            int r11 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r11 != 0) goto L_0x0012
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r14 = "size == 0"
            r11.<init>(r14)
            throw r11
        L_0x0012:
            r12 = 0
            r9 = 0
            r6 = 0
        L_0x0016:
            r0 = r18
            okio.Segment r10 = r0.head
            byte[] r4 = r10.data
            int r8 = r10.pos
            int r7 = r10.limit
        L_0x0020:
            if (r8 >= r7) goto L_0x009b
            byte r2 = r4[r8]
            r11 = 48
            if (r2 < r11) goto L_0x0061
            r11 = 57
            if (r2 > r11) goto L_0x0061
            int r5 = r2 + -48
        L_0x002e:
            r14 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r14 = r14 & r12
            r16 = 0
            int r11 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r11 == 0) goto L_0x00be
            okio.Buffer r11 = new okio.Buffer
            r11.<init>()
            okio.Buffer r11 = r11.writeHexadecimalUnsignedLong((long) r12)
            okio.Buffer r3 = r11.writeByte((int) r2)
            java.lang.NumberFormatException r11 = new java.lang.NumberFormatException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Number too large: "
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r15 = r3.readUtf8()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r11.<init>(r14)
            throw r11
        L_0x0061:
            r11 = 97
            if (r2 < r11) goto L_0x006e
            r11 = 102(0x66, float:1.43E-43)
            if (r2 > r11) goto L_0x006e
            int r11 = r2 + -97
            int r5 = r11 + 10
            goto L_0x002e
        L_0x006e:
            r11 = 65
            if (r2 < r11) goto L_0x007b
            r11 = 70
            if (r2 > r11) goto L_0x007b
            int r11 = r2 + -65
            int r5 = r11 + 10
            goto L_0x002e
        L_0x007b:
            if (r9 != 0) goto L_0x009a
            java.lang.NumberFormatException r11 = new java.lang.NumberFormatException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r15 = java.lang.Integer.toHexString(r2)
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r11.<init>(r14)
            throw r11
        L_0x009a:
            r6 = 1
        L_0x009b:
            if (r8 != r7) goto L_0x00c8
            okio.Segment r11 = r10.pop()
            r0 = r18
            r0.head = r11
            okio.SegmentPool.recycle(r10)
        L_0x00a8:
            if (r6 != 0) goto L_0x00b0
            r0 = r18
            okio.Segment r11 = r0.head
            if (r11 != 0) goto L_0x0016
        L_0x00b0:
            r0 = r18
            long r14 = r0.size
            long r0 = (long) r9
            r16 = r0
            long r14 = r14 - r16
            r0 = r18
            r0.size = r14
            return r12
        L_0x00be:
            r11 = 4
            long r12 = r12 << r11
            long r14 = (long) r5
            long r12 = r12 | r14
            int r8 = r8 + 1
            int r9 = r9 + 1
            goto L_0x0020
        L_0x00c8:
            r10.pos = r8
            goto L_0x00a8
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long byteCount) throws EOFException {
        return new ByteString(readByteArray(byteCount));
    }

    public void readFully(Buffer sink, long byteCount) throws EOFException {
        if (this.size < byteCount) {
            sink.write(this, this.size);
            throw new EOFException();
        } else {
            sink.write(this, byteCount);
        }
    }

    public long readAll(Sink sink) throws IOException {
        long byteCount = this.size;
        if (byteCount > 0) {
            sink.write(this, byteCount);
        }
        return byteCount;
    }

    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Util.UTF_8);
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readString(long byteCount, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, byteCount);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (byteCount > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + byteCount);
        } else if (byteCount == 0) {
            return "";
        } else {
            Segment s = this.head;
            if (((long) s.pos) + byteCount > ((long) s.limit)) {
                return new String(readByteArray(byteCount), charset);
            }
            String str = new String(s.data, s.pos, (int) byteCount, charset);
            s.pos = (int) (((long) s.pos) + byteCount);
            this.size -= byteCount;
            if (s.pos != s.limit) {
                return str;
            }
            this.head = s.pop();
            SegmentPool.recycle(s);
            return str;
        }
    }

    public String readUtf8Line() throws EOFException {
        long newline = indexOf((byte) 10);
        if (newline != -1) {
            return readUtf8Line(newline);
        }
        if (this.size != 0) {
            return readUtf8(this.size);
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        long newline = indexOf((byte) 10);
        if (newline != -1) {
            return readUtf8Line(newline);
        }
        Buffer data = new Buffer();
        copyTo(data, 0, Math.min(32, this.size));
        throw new EOFException("\\n not found: size=" + size() + " content=" + data.readByteString().hex() + "...");
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long newline) throws EOFException {
        if (newline <= 0 || getByte(newline - 1) != 13) {
            String result = readUtf8(newline);
            skip(1);
            return result;
        }
        String result2 = readUtf8(newline - 1);
        skip(2);
        return result2;
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] readByteArray(long byteCount) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, byteCount);
        if (byteCount > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + byteCount);
        }
        byte[] result = new byte[((int) byteCount)];
        readFully(result);
        return result;
    }

    public int read(byte[] sink) {
        return read(sink, 0, sink.length);
    }

    public void readFully(byte[] sink) throws EOFException {
        int offset = 0;
        while (offset < sink.length) {
            int read = read(sink, offset, sink.length - offset);
            if (read == -1) {
                throw new EOFException();
            }
            offset += read;
        }
    }

    public int read(byte[] sink, int offset, int byteCount) {
        Util.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(byteCount, s.limit - s.pos);
        System.arraycopy(s.data, s.pos, sink, offset, toCopy);
        s.pos += toCopy;
        this.size -= (long) toCopy;
        if (s.pos != s.limit) {
            return toCopy;
        }
        this.head = s.pop();
        SegmentPool.recycle(s);
        return toCopy;
    }

    public void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int toSkip = (int) Math.min(byteCount, (long) (this.head.limit - this.head.pos));
            this.size -= (long) toSkip;
            byteCount -= (long) toSkip;
            this.head.pos += toSkip;
            if (this.head.pos == this.head.limit) {
                Segment toRecycle = this.head;
                this.head = toRecycle.pop();
                SegmentPool.recycle(toRecycle);
            }
        }
    }

    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    public Buffer writeUtf8(String string) {
        int i;
        int low;
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        int length = string.length();
        int i2 = 0;
        while (i2 < length) {
            int c = string.charAt(i2);
            if (c < 128) {
                Segment tail = writableSegment(1);
                byte[] data = tail.data;
                int segmentOffset = tail.limit - i2;
                int runLimit = Math.min(length, 2048 - segmentOffset);
                data[segmentOffset + i2] = (byte) c;
                int i3 = i2 + 1;
                while (i3 < runLimit) {
                    int c2 = string.charAt(i3);
                    if (c2 >= 128) {
                        break;
                    }
                    data[segmentOffset + i3] = (byte) c2;
                    i3++;
                }
                int runSize = (i3 + segmentOffset) - tail.limit;
                tail.limit += runSize;
                this.size += (long) runSize;
                i = i3;
            } else if (c < 2048) {
                writeByte((c >> 6) | 192);
                writeByte((c & 63) | 128);
                i = i2 + 1;
            } else if (c < 55296 || c > 57343) {
                writeByte((c >> 12) | 224);
                writeByte(((c >> 6) & 63) | 128);
                writeByte((c & 63) | 128);
                i = i2 + 1;
            } else {
                if (i2 + 1 < length) {
                    low = string.charAt(i2 + 1);
                } else {
                    low = 0;
                }
                if (c > 56319 || low < 56320 || low > 57343) {
                    writeByte(63);
                    i2++;
                } else {
                    int codePoint = 65536 + (((-55297 & c) << 10) | (-56321 & low));
                    writeByte((codePoint >> 18) | SktSsiProtocol.kSsiSubCmdRestoreFactoryDefaults);
                    writeByte(((codePoint >> 12) & 63) | 128);
                    writeByte(((codePoint >> 6) & 63) | 128);
                    writeByte((codePoint & 63) | 128);
                    i = i2 + 2;
                }
            }
            i2 = i;
        }
        return this;
    }

    public Buffer writeString(String string, Charset charset) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            return writeUtf8(string);
        } else {
            byte[] data = string.getBytes(charset);
            return write(data, 0, data.length);
        }
    }

    public Buffer write(byte[] source) {
        if (source != null) {
            return write(source, 0, source.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] source, int offset, int byteCount) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Util.checkOffsetAndCount((long) source.length, (long) offset, (long) byteCount);
        int limit = offset + byteCount;
        while (offset < limit) {
            Segment tail = writableSegment(1);
            int toCopy = Math.min(limit - offset, 2048 - tail.limit);
            System.arraycopy(source, offset, tail.data, tail.limit, toCopy);
            offset += toCopy;
            tail.limit += toCopy;
        }
        this.size += (long) byteCount;
        return this;
    }

    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (readCount == -1) {
                return totalBytesRead;
            }
            totalBytesRead += readCount;
        }
    }

    public BufferedSink write(Source source, long byteCount) throws IOException {
        while (byteCount > 0) {
            long read = source.read(this, byteCount);
            if (read == -1) {
                throw new EOFException();
            }
            byteCount -= read;
        }
        return this;
    }

    public Buffer writeByte(int b) {
        Segment tail = writableSegment(1);
        byte[] bArr = tail.data;
        int i = tail.limit;
        tail.limit = i + 1;
        bArr[i] = (byte) b;
        this.size++;
        return this;
    }

    public Buffer writeShort(int s) {
        Segment tail = writableSegment(2);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & 255);
        data[limit2] = (byte) (s & 255);
        tail.limit = limit2 + 1;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int s) {
        return writeShort((int) Util.reverseBytesShort((short) s));
    }

    public Buffer writeInt(int i) {
        Segment tail = writableSegment(4);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & 255);
        data[limit4] = (byte) (i & 255);
        tail.limit = limit4 + 1;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    public Buffer writeLong(long v) {
        Segment tail = writableSegment(8);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((int) ((v >>> 56) & 255));
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((int) ((v >>> 48) & 255));
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((int) ((v >>> 40) & 255));
        int limit5 = limit4 + 1;
        data[limit4] = (byte) ((int) ((v >>> 32) & 255));
        int limit6 = limit5 + 1;
        data[limit5] = (byte) ((int) ((v >>> 24) & 255));
        int limit7 = limit6 + 1;
        data[limit6] = (byte) ((int) ((v >>> 16) & 255));
        int limit8 = limit7 + 1;
        data[limit7] = (byte) ((int) ((v >>> 8) & 255));
        data[limit8] = (byte) ((int) (v & 255));
        tail.limit = limit8 + 1;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long v) {
        return writeLong(Util.reverseBytesLong(v));
    }

    /* Debug info: failed to restart local var, previous not found, register: 13 */
    public Buffer writeDecimalLong(long v) {
        int width;
        if (v == 0) {
            return writeByte(48);
        }
        boolean negative = false;
        if (v < 0) {
            v = -v;
            if (v < 0) {
                return writeUtf8("-9223372036854775808");
            }
            negative = true;
        }
        if (v < 100000000) {
            width = v < 10000 ? v < 100 ? v < 10 ? 1 : 2 : v < 1000 ? 3 : 4 : v < 1000000 ? v < 100000 ? 5 : 6 : v < 10000000 ? 7 : 8;
        } else {
            width = v < 1000000000000L ? v < 10000000000L ? v < 1000000000 ? 9 : 10 : v < 100000000000L ? 11 : 12 : v < 1000000000000000L ? v < 10000000000000L ? 13 : v < 100000000000000L ? 14 : 15 : v < 100000000000000000L ? v < 10000000000000000L ? 16 : 17 : v < 1000000000000000000L ? 18 : 19;
        }
        if (negative) {
            width++;
        }
        Segment tail = writableSegment(width);
        byte[] data = tail.data;
        int pos = tail.limit + width;
        while (v != 0) {
            pos--;
            data[pos] = DIGITS[(int) (v % 10)];
            v /= 10;
        }
        if (negative) {
            data[pos - 1] = 45;
        }
        tail.limit += width;
        this.size += (long) width;
        return this;
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    public Buffer writeHexadecimalUnsignedLong(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        int width = (Long.numberOfTrailingZeros(Long.highestOneBit(v)) / 4) + 1;
        Segment tail = writableSegment(width);
        byte[] data = tail.data;
        int start = tail.limit;
        for (int pos = (tail.limit + width) - 1; pos >= start; pos--) {
            data[pos] = DIGITS[(int) (15 & v)];
            v >>>= 4;
        }
        tail.limit += width;
        this.size += (long) width;
        return this;
    }

    /* access modifiers changed from: package-private */
    public Segment writableSegment(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 2048) {
            throw new IllegalArgumentException();
        } else if (this.head == null) {
            this.head = SegmentPool.take();
            Segment segment = this.head;
            Segment segment2 = this.head;
            Segment segment3 = this.head;
            segment2.prev = segment3;
            segment.next = segment3;
            return segment3;
        } else {
            Segment tail = this.head.prev;
            if (tail.limit + minimumCapacity > 2048 || !tail.owner) {
                return tail.push(SegmentPool.take());
            }
            return tail;
        }
    }

    public void write(Buffer source, long byteCount) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        } else if (source == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            Util.checkOffsetAndCount(source.size, 0, byteCount);
            while (byteCount > 0) {
                if (byteCount < ((long) (source.head.limit - source.head.pos))) {
                    Segment tail = this.head != null ? this.head.prev : null;
                    if (tail != null && tail.owner) {
                        if ((byteCount + ((long) tail.limit)) - ((long) (tail.shared ? 0 : tail.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            source.head.writeTo(tail, (int) byteCount);
                            source.size -= byteCount;
                            this.size += byteCount;
                            return;
                        }
                    }
                    source.head = source.head.split((int) byteCount);
                }
                Segment segmentToMove = source.head;
                long movedByteCount = (long) (segmentToMove.limit - segmentToMove.pos);
                source.head = segmentToMove.pop();
                if (this.head == null) {
                    this.head = segmentToMove;
                    Segment segment = this.head;
                    Segment segment2 = this.head;
                    Segment segment3 = this.head;
                    segment2.prev = segment3;
                    segment.next = segment3;
                } else {
                    this.head.prev.push(segmentToMove).compact();
                }
                source.size -= movedByteCount;
                this.size += movedByteCount;
                byteCount -= movedByteCount;
            }
        }
    }

    public long read(Buffer sink, long byteCount) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        } else if (this.size == 0) {
            return -1;
        } else {
            if (byteCount > this.size) {
                byteCount = this.size;
            }
            sink.write(this, byteCount);
            return byteCount;
        }
    }

    public long indexOf(byte b) {
        return indexOf(b, 0);
    }

    public long indexOf(byte b, long fromIndex) {
        if (fromIndex < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        long offset = 0;
        do {
            int segmentByteCount = s.limit - s.pos;
            if (fromIndex >= ((long) segmentByteCount)) {
                fromIndex -= (long) segmentByteCount;
            } else {
                byte[] data = s.data;
                long limit = (long) s.limit;
                for (long pos = ((long) s.pos) + fromIndex; pos < limit; pos++) {
                    if (data[(int) pos] == b) {
                        return (offset + pos) - ((long) s.pos);
                    }
                }
                fromIndex = 0;
            }
            offset += (long) segmentByteCount;
            s = s.next;
        } while (s != this.head);
        return -1;
    }

    public long indexOfElement(ByteString targetBytes) {
        return indexOfElement(targetBytes, 0);
    }

    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        if (fromIndex < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        long offset = 0;
        byte[] toFind = targetBytes.toByteArray();
        do {
            int segmentByteCount = s.limit - s.pos;
            if (fromIndex >= ((long) segmentByteCount)) {
                fromIndex -= (long) segmentByteCount;
            } else {
                byte[] data = s.data;
                long limit = (long) s.limit;
                for (long pos = ((long) s.pos) + fromIndex; pos < limit; pos++) {
                    byte b = data[(int) pos];
                    for (byte targetByte : toFind) {
                        if (b == targetByte) {
                            return (offset + pos) - ((long) s.pos);
                        }
                    }
                }
                fromIndex = 0;
            }
            offset += (long) segmentByteCount;
            s = s.next;
        } while (s != this.head);
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(Integer.valueOf(this.head.limit - this.head.pos));
        for (Segment s = this.head.next; s != this.head; s = s.next) {
            result.add(Integer.valueOf(s.limit - s.pos));
        }
        return result;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r8 != r11.limit) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        r11 = r11.next;
        r5 = r11.pos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r10 != r12.limit) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        r12 = r12.next;
        r9 = r12.pos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        r6 = r6 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        r5 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r0 != r1) goto L_0x0008
            r14 = 1
        L_0x0007:
            return r14
        L_0x0008:
            r0 = r19
            boolean r14 = r0 instanceof okio.Buffer
            if (r14 != 0) goto L_0x0010
            r14 = 0
            goto L_0x0007
        L_0x0010:
            r13 = r19
            okio.Buffer r13 = (okio.Buffer) r13
            r0 = r18
            long r14 = r0.size
            long r0 = r13.size
            r16 = r0
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x0022
            r14 = 0
            goto L_0x0007
        L_0x0022:
            r0 = r18
            long r14 = r0.size
            r16 = 0
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 != 0) goto L_0x002e
            r14 = 1
            goto L_0x0007
        L_0x002e:
            r0 = r18
            okio.Segment r11 = r0.head
            okio.Segment r12 = r13.head
            int r5 = r11.pos
            int r9 = r12.pos
            r6 = 0
        L_0x003a:
            r0 = r18
            long r14 = r0.size
            int r14 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x007c
            int r14 = r11.limit
            int r14 = r14 - r5
            int r15 = r12.limit
            int r15 = r15 - r9
            int r14 = java.lang.Math.min(r14, r15)
            long r2 = (long) r14
            r4 = 0
            r10 = r9
            r8 = r5
        L_0x0050:
            long r14 = (long) r4
            int r14 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r14 >= 0) goto L_0x006a
            byte[] r14 = r11.data
            int r5 = r8 + 1
            byte r14 = r14[r8]
            byte[] r15 = r12.data
            int r9 = r10 + 1
            byte r15 = r15[r10]
            if (r14 == r15) goto L_0x0065
            r14 = 0
            goto L_0x0007
        L_0x0065:
            int r4 = r4 + 1
            r10 = r9
            r8 = r5
            goto L_0x0050
        L_0x006a:
            int r14 = r11.limit
            if (r8 != r14) goto L_0x0080
            okio.Segment r11 = r11.next
            int r5 = r11.pos
        L_0x0072:
            int r14 = r12.limit
            if (r10 != r14) goto L_0x007e
            okio.Segment r12 = r12.next
            int r9 = r12.pos
        L_0x007a:
            long r6 = r6 + r2
            goto L_0x003a
        L_0x007c:
            r14 = 1
            goto L_0x0007
        L_0x007e:
            r9 = r10
            goto L_0x007a
        L_0x0080:
            r5 = r8
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Segment s = this.head;
        if (s == null) {
            return 0;
        }
        int result = 1;
        do {
            int limit = s.limit;
            for (int pos = s.pos; pos < limit; pos++) {
                result = (result * 31) + s.data[pos];
            }
            s = s.next;
        } while (s != this.head);
        return result;
    }

    public String toString() {
        if (this.size == 0) {
            return "Buffer[size=0]";
        }
        if (this.size <= 16) {
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.size), clone().readByteString().hex()});
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 13
            md5.update(this.head.data, this.head.pos, this.head.limit - this.head.pos); // CRYPTOGRAPHIC API CALLSITE 11
            for (Segment s = this.head.next; s != this.head; s = s.next) {
                md5.update(s.data, s.pos, s.limit - s.pos); // CRYPTOGRAPHIC API CALLSITE 11
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.size), ByteString.m20of(md5.digest()).hex()}); // CRYPTOGRAPHIC API CALLSITE 10
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public Buffer clone() {
        Buffer result = new Buffer();
        if (this.size != 0) {
            result.head = new Segment(this.head);
            Segment segment = result.head;
            Segment segment2 = result.head;
            Segment segment3 = result.head;
            segment2.prev = segment3;
            segment.next = segment3;
            for (Segment s = this.head.next; s != this.head; s = s.next) {
                result.head.prev.push(new Segment(s));
            }
            result.size = this.size;
        }
        return result;
    }

    public ByteString snapshot() {
        if (this.size <= 2147483647L) {
            return snapshot((int) this.size);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public ByteString snapshot(int byteCount) {
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, byteCount);
    }
}
