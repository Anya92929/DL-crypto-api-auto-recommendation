package okhttp3.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Protocol;
import okhttp3.internal.framed.FrameReader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import p000.C1301iy;

public final class Http2 implements Variant {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f6117a = Logger.getLogger(C1802b.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final ByteString f6118b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public FrameReader newReader(BufferedSource bufferedSource, boolean z) {
        return new C1803c(bufferedSource, 4096, z);
    }

    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z) {
        return new C1804d(bufferedSink, z);
    }

    /* renamed from: okhttp3.internal.framed.Http2$c */
    static final class C1803c implements FrameReader {

        /* renamed from: a */
        final C1301iy.C1302a f6128a;

        /* renamed from: b */
        private final BufferedSource f6129b;

        /* renamed from: c */
        private final C1801a f6130c = new C1801a(this.f6129b);

        /* renamed from: d */
        private final boolean f6131d;

        C1803c(BufferedSource bufferedSource, int i, boolean z) {
            this.f6129b = bufferedSource;
            this.f6131d = z;
            this.f6128a = new C1301iy.C1302a(i, this.f6130c);
        }

        public void readConnectionPreface() throws IOException {
            if (!this.f6131d) {
                ByteString readByteString = this.f6129b.readByteString((long) Http2.f6118b.size());
                if (Http2.f6117a.isLoggable(Level.FINE)) {
                    Http2.f6117a.fine(String.format("<< CONNECTION %s", new Object[]{readByteString.hex()}));
                }
                if (!Http2.f6118b.equals(readByteString)) {
                    throw Http2.m6770d("Expected a connection header but was %s", readByteString.utf8());
                }
            }
        }

        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                this.f6129b.require(9);
                int a = Http2.m6765b(this.f6129b);
                if (a < 0 || a > 16384) {
                    throw Http2.m6770d("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                }
                byte readByte = (byte) (this.f6129b.readByte() & 255);
                byte readByte2 = (byte) (this.f6129b.readByte() & 255);
                int readInt = this.f6129b.readInt() & Integer.MAX_VALUE;
                if (Http2.f6117a.isLoggable(Level.FINE)) {
                    Http2.f6117a.fine(C1802b.m6773a(true, readInt, a, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m6777b(handler, a, readByte2, readInt);
                        return true;
                    case 1:
                        m6776a(handler, a, readByte2, readInt);
                        return true;
                    case 2:
                        m6778c(handler, a, readByte2, readInt);
                        return true;
                    case 3:
                        m6779d(handler, a, readByte2, readInt);
                        return true;
                    case 4:
                        m6780e(handler, a, readByte2, readInt);
                        return true;
                    case 5:
                        m6781f(handler, a, readByte2, readInt);
                        return true;
                    case 6:
                        m6782g(handler, a, readByte2, readInt);
                        return true;
                    case 7:
                        m6783h(handler, a, readByte2, readInt);
                        return true;
                    case 8:
                        m6784i(handler, a, readByte2, readInt);
                        return true;
                    default:
                        this.f6129b.skip((long) a);
                        return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        /* renamed from: a */
        private void m6776a(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            short s;
            if (i2 == 0) {
                throw Http2.m6770d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f6129b.readByte() & 255);
            } else {
                s = 0;
            }
            if ((b & 32) != 0) {
                m6775a(handler, i2);
                i -= 5;
            }
            handler.headers(false, z, i2, -1, m6774a(Http2.m6764b(i, b, s), s, b, i2), HeadersMode.HTTP_20_HEADERS);
        }

        /* renamed from: a */
        private List<Header> m6774a(int i, short s, byte b, int i2) throws IOException {
            C1801a aVar = this.f6130c;
            this.f6130c.f6122d = i;
            aVar.f6119a = i;
            this.f6130c.f6123e = s;
            this.f6130c.f6120b = b;
            this.f6130c.f6121c = i2;
            this.f6128a.mo8712a();
            return this.f6128a.mo8714b();
        }

        /* renamed from: b */
        private void m6777b(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            boolean z;
            boolean z2 = true;
            short s = 0;
            if ((b & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((b & 32) == 0) {
                z2 = false;
            }
            if (z2) {
                throw Http2.m6770d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            if ((b & 8) != 0) {
                s = (short) (this.f6129b.readByte() & 255);
            }
            handler.data(z, i2, this.f6129b, Http2.m6764b(i, b, s));
            this.f6129b.skip((long) s);
        }

        /* renamed from: c */
        private void m6778c(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 5) {
                throw Http2.m6770d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw Http2.m6770d("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else {
                m6775a(handler, i2);
            }
        }

        /* renamed from: a */
        private void m6775a(FrameReader.Handler handler, int i) throws IOException {
            int readInt = this.f6129b.readInt();
            handler.priority(i, readInt & Integer.MAX_VALUE, (this.f6129b.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }

        /* renamed from: d */
        private void m6779d(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw Http2.m6770d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw Http2.m6770d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            } else {
                int readInt = this.f6129b.readInt();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                if (fromHttp2 == null) {
                    throw Http2.m6770d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                } else {
                    handler.rstStream(i2, fromHttp2);
                }
            }
        }

        /* renamed from: e */
        private void m6780e(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            if (i2 != 0) {
                throw Http2.m6770d("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b & 1) != 0) {
                if (i != 0) {
                    throw Http2.m6770d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                handler.ackSettings();
            } else if (i % 6 != 0) {
                throw Http2.m6770d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            } else {
                Settings settings = new Settings();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    short readShort = this.f6129b.readShort();
                    int readInt = this.f6129b.readInt();
                    switch (readShort) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (!(readInt == 0 || readInt == 1)) {
                                throw Http2.m6770d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            readShort = 4;
                            break;
                        case 4:
                            readShort = 7;
                            if (readInt >= 0) {
                                break;
                            } else {
                                throw Http2.m6770d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        case 5:
                            if (readInt >= 16384 && readInt <= 16777215) {
                                break;
                            } else {
                                throw Http2.m6770d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            }
                        default:
                            throw Http2.m6770d("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(readShort));
                    }
                    settings.mo11068a(readShort, 0, readInt);
                }
                handler.settings(false, settings);
                if (settings.mo11074c() >= 0) {
                    this.f6128a.mo8713a(settings.mo11074c());
                }
            }
        }

        /* renamed from: f */
        private void m6781f(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            short s = 0;
            if (i2 == 0) {
                throw Http2.m6770d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            if ((b & 8) != 0) {
                s = (short) (this.f6129b.readByte() & 255);
            }
            handler.pushPromise(i2, this.f6129b.readInt() & Integer.MAX_VALUE, m6774a(Http2.m6764b(i - 4, b, s), s, b, i2));
        }

        /* renamed from: g */
        private void m6782g(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            boolean z = true;
            if (i != 8) {
                throw Http2.m6770d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw Http2.m6770d("TYPE_PING streamId != 0", new Object[0]);
            } else {
                int readInt = this.f6129b.readInt();
                int readInt2 = this.f6129b.readInt();
                if ((b & 1) == 0) {
                    z = false;
                }
                handler.ping(z, readInt, readInt2);
            }
        }

        /* renamed from: h */
        private void m6783h(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            if (i < 8) {
                throw Http2.m6770d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw Http2.m6770d("TYPE_GOAWAY streamId != 0", new Object[0]);
            } else {
                int readInt = this.f6129b.readInt();
                int readInt2 = this.f6129b.readInt();
                int i3 = i - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                if (fromHttp2 == null) {
                    throw Http2.m6770d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                }
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.f6129b.readByteString((long) i3);
                }
                handler.goAway(readInt, fromHttp2, byteString);
            }
        }

        /* renamed from: i */
        private void m6784i(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw Http2.m6770d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
            long readInt = ((long) this.f6129b.readInt()) & 2147483647L;
            if (readInt == 0) {
                throw Http2.m6770d("windowSizeIncrement was 0", Long.valueOf(readInt));
            } else {
                handler.windowUpdate(i2, readInt);
            }
        }

        public void close() throws IOException {
            this.f6129b.close();
        }
    }

    /* renamed from: okhttp3.internal.framed.Http2$d */
    static final class C1804d implements FrameWriter {

        /* renamed from: a */
        private final BufferedSink f6132a;

        /* renamed from: b */
        private final boolean f6133b;

        /* renamed from: c */
        private final Buffer f6134c = new Buffer();

        /* renamed from: d */
        private final C1301iy.C1303b f6135d = new C1301iy.C1303b(this.f6134c);

        /* renamed from: e */
        private int f6136e = 16384;

        /* renamed from: f */
        private boolean f6137f;

        C1804d(BufferedSink bufferedSink, boolean z) {
            this.f6132a = bufferedSink;
            this.f6133b = z;
        }

        public synchronized void flush() throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            this.f6132a.flush();
        }

        public synchronized void ackSettings(Settings settings) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            this.f6136e = settings.mo11077e(this.f6136e);
            mo11056a(0, 0, (byte) 4, (byte) 1);
            this.f6132a.flush();
        }

        public synchronized void connectionPreface() throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            } else if (this.f6133b) {
                if (Http2.f6117a.isLoggable(Level.FINE)) {
                    Http2.f6117a.fine(String.format(">> CONNECTION %s", new Object[]{Http2.f6118b.hex()}));
                }
                this.f6132a.write(Http2.f6118b.toByteArray());
                this.f6132a.flush();
            }
        }

        public synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            if (z2) {
                throw new UnsupportedOperationException();
            } else if (this.f6137f) {
                throw new IOException("closed");
            } else {
                mo11057a(z, i, list);
            }
        }

        public synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            mo11057a(z, i, list);
        }

        public synchronized void headers(int i, List<Header> list) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            mo11057a(false, i, list);
        }

        public synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            this.f6135d.mo8717a(list);
            long size = this.f6134c.size();
            int min = (int) Math.min((long) (this.f6136e - 4), size);
            mo11056a(i, min + 4, (byte) 5, size == ((long) min) ? (byte) 4 : 0);
            this.f6132a.writeInt(Integer.MAX_VALUE & i2);
            this.f6132a.write(this.f6134c, (long) min);
            if (size > ((long) min)) {
                m6785a(i, size - ((long) min));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11057a(boolean z, int i, List<Header> list) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            this.f6135d.mo8717a(list);
            long size = this.f6134c.size();
            int min = (int) Math.min((long) this.f6136e, size);
            byte b = size == ((long) min) ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo11056a(i, min, (byte) 1, b);
            this.f6132a.write(this.f6134c, (long) min);
            if (size > ((long) min)) {
                m6785a(i, size - ((long) min));
            }
        }

        /* renamed from: a */
        private void m6785a(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.f6136e, j);
                j -= (long) min;
                mo11056a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
                this.f6132a.write(this.f6134c, (long) min);
            }
        }

        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            } else {
                mo11056a(i, 4, (byte) 3, (byte) 0);
                this.f6132a.writeInt(errorCode.httpCode);
                this.f6132a.flush();
            }
        }

        public int maxDataLength() {
            return this.f6136e;
        }

        public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            }
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo11055a(i, b, buffer, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11055a(int i, byte b, Buffer buffer, int i2) throws IOException {
            mo11056a(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.f6132a.write(buffer, (long) i2);
            }
        }

        public synchronized void settings(Settings settings) throws IOException {
            int i;
            synchronized (this) {
                if (this.f6137f) {
                    throw new IOException("closed");
                }
                mo11056a(0, settings.mo11072b() * 6, (byte) 4, (byte) 0);
                for (int i2 = 0; i2 < 10; i2++) {
                    if (settings.mo11071a(i2)) {
                        if (i2 == 4) {
                            i = 3;
                        } else if (i2 == 7) {
                            i = 4;
                        } else {
                            i = i2;
                        }
                        this.f6132a.writeShort(i);
                        this.f6132a.writeInt(settings.mo11073b(i2));
                    }
                }
                this.f6132a.flush();
            }
        }

        public synchronized void ping(boolean z, int i, int i2) throws IOException {
            byte b = 0;
            synchronized (this) {
                if (this.f6137f) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = 1;
                }
                mo11056a(0, 8, (byte) 6, b);
                this.f6132a.writeInt(i);
                this.f6132a.writeInt(i2);
                this.f6132a.flush();
            }
        }

        public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw Http2.m6769c("errorCode.httpCode == -1", new Object[0]);
            } else {
                mo11056a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f6132a.writeInt(i);
                this.f6132a.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f6132a.write(bArr);
                }
                this.f6132a.flush();
            }
        }

        public synchronized void windowUpdate(int i, long j) throws IOException {
            if (this.f6137f) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw Http2.m6769c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                mo11056a(i, 4, (byte) 8, (byte) 0);
                this.f6132a.writeInt((int) j);
                this.f6132a.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.f6137f = true;
            this.f6132a.close();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11056a(int i, int i2, byte b, byte b2) throws IOException {
            if (Http2.f6117a.isLoggable(Level.FINE)) {
                Http2.f6117a.fine(C1802b.m6773a(false, i, i2, b, b2));
            }
            if (i2 > this.f6136e) {
                throw Http2.m6769c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f6136e), Integer.valueOf(i2));
            } else if ((Integer.MIN_VALUE & i) != 0) {
                throw Http2.m6769c("reserved bit set: %s", Integer.valueOf(i));
            } else {
                Http2.m6768b(this.f6132a, i2);
                this.f6132a.writeByte(b & 255);
                this.f6132a.writeByte(b2 & 255);
                this.f6132a.writeInt(Integer.MAX_VALUE & i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static IllegalArgumentException m6769c(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static IOException m6770d(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    /* renamed from: okhttp3.internal.framed.Http2$a */
    static final class C1801a implements Source {

        /* renamed from: a */
        int f6119a;

        /* renamed from: b */
        byte f6120b;

        /* renamed from: c */
        int f6121c;

        /* renamed from: d */
        int f6122d;

        /* renamed from: e */
        short f6123e;

        /* renamed from: f */
        private final BufferedSource f6124f;

        public C1801a(BufferedSource bufferedSource) {
            this.f6124f = bufferedSource;
        }

        public long read(Buffer buffer, long j) throws IOException {
            while (this.f6122d == 0) {
                this.f6124f.skip((long) this.f6123e);
                this.f6123e = 0;
                if ((this.f6120b & 4) != 0) {
                    return -1;
                }
                m6771a();
            }
            long read = this.f6124f.read(buffer, Math.min(j, (long) this.f6122d));
            if (read == -1) {
                return -1;
            }
            this.f6122d = (int) (((long) this.f6122d) - read);
            return read;
        }

        public Timeout timeout() {
            return this.f6124f.timeout();
        }

        public void close() throws IOException {
        }

        /* renamed from: a */
        private void m6771a() throws IOException {
            int i = this.f6121c;
            int a = Http2.m6765b(this.f6124f);
            this.f6122d = a;
            this.f6119a = a;
            byte readByte = (byte) (this.f6124f.readByte() & 255);
            this.f6120b = (byte) (this.f6124f.readByte() & 255);
            if (Http2.f6117a.isLoggable(Level.FINE)) {
                Http2.f6117a.fine(C1802b.m6773a(true, this.f6121c, this.f6119a, readByte, this.f6120b));
            }
            this.f6121c = this.f6124f.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                throw Http2.m6770d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (this.f6121c != i) {
                throw Http2.m6770d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m6764b(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw m6770d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    /* renamed from: okhttp3.internal.framed.Http2$b */
    static final class C1802b {

        /* renamed from: a */
        private static final String[] f6125a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b */
        private static final String[] f6126b = new String[64];

        /* renamed from: c */
        private static final String[] f6127c = new String[256];

        C1802b() {
        }

        /* renamed from: a */
        static String m6773a(boolean z, int i, int i2, byte b, byte b2) {
            String format = b < f6125a.length ? f6125a[b] : String.format("0x%02x", new Object[]{Byte.valueOf(b)});
            String a = m6772a(b, b2);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = a;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }

        /* renamed from: a */
        static String m6772a(byte b, byte b2) {
            if (b2 == 0) {
                return "";
            }
            switch (b) {
                case 2:
                case 3:
                case 7:
                case 8:
                    return f6127c[b2];
                case 4:
                case 6:
                    return b2 == 1 ? "ACK" : f6127c[b2];
                default:
                    String str = b2 < f6126b.length ? f6126b[b2] : f6127c[b2];
                    if (b == 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != 0 || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
            }
        }

        static {
            for (int i = 0; i < f6127c.length; i++) {
                f6127c[i] = String.format("%8s", new Object[]{Integer.toBinaryString(i)}).replace(' ', '0');
            }
            f6126b[0] = "";
            f6126b[1] = "END_STREAM";
            int[] iArr = {1};
            f6126b[8] = "PADDED";
            for (int i2 : iArr) {
                f6126b[i2 | 8] = f6126b[i2] + "|PADDED";
            }
            f6126b[4] = "END_HEADERS";
            f6126b[32] = "PRIORITY";
            f6126b[36] = "END_HEADERS|PRIORITY";
            for (int i3 : new int[]{4, 32, 36}) {
                for (int i4 : iArr) {
                    f6126b[i4 | i3] = f6126b[i4] + '|' + f6126b[i3];
                    f6126b[i4 | i3 | 8] = f6126b[i4] + '|' + f6126b[i3] + "|PADDED";
                }
            }
            for (int i5 = 0; i5 < f6126b.length; i5++) {
                if (f6126b[i5] == null) {
                    f6126b[i5] = f6127c[i5];
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m6765b(BufferedSource bufferedSource) throws IOException {
        return ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8) | (bufferedSource.readByte() & 255);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m6768b(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }
}
