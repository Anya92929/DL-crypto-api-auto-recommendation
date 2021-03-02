package okhttp3.internal.framed;

import android.support.p001v4.view.ViewCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.framed.FrameReader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;
import okio.Sink;

public final class Spdy3 implements Variant {

    /* renamed from: a */
    public static final byte[] f6145a;

    public Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    static {
        try {
            f6145a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    public FrameReader newReader(BufferedSource bufferedSource, boolean z) {
        return new C1806a(bufferedSource, z);
    }

    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z) {
        return new C1807b(bufferedSink, z);
    }

    /* renamed from: okhttp3.internal.framed.Spdy3$a */
    static final class C1806a implements FrameReader {

        /* renamed from: a */
        private final BufferedSource f6146a;

        /* renamed from: b */
        private final boolean f6147b;

        /* renamed from: c */
        private final C1307ja f6148c = new C1307ja(this.f6146a);

        C1806a(BufferedSource bufferedSource, boolean z) {
            this.f6146a = bufferedSource;
            this.f6147b = z;
        }

        public void readConnectionPreface() {
        }

        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            boolean z = false;
            try {
                int readInt = this.f6146a.readInt();
                int readInt2 = this.f6146a.readInt();
                boolean z2 = (Integer.MIN_VALUE & readInt) != 0;
                int i = (-16777216 & readInt2) >>> 24;
                int i2 = readInt2 & ViewCompat.MEASURED_SIZE_MASK;
                if (z2) {
                    int i3 = (2147418112 & readInt) >>> 16;
                    int i4 = 65535 & readInt;
                    if (i3 != 3) {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                    switch (i4) {
                        case 1:
                            m6806a(handler, i, i2);
                            return true;
                        case 2:
                            m6807b(handler, i, i2);
                            return true;
                        case 3:
                            m6808c(handler, i, i2);
                            return true;
                        case 4:
                            m6813h(handler, i, i2);
                            return true;
                        case 6:
                            m6811f(handler, i, i2);
                            return true;
                        case 7:
                            m6812g(handler, i, i2);
                            return true;
                        case 8:
                            m6809d(handler, i, i2);
                            return true;
                        case 9:
                            m6810e(handler, i, i2);
                            return true;
                        default:
                            this.f6146a.skip((long) i2);
                            return true;
                    }
                } else {
                    int i5 = Integer.MAX_VALUE & readInt;
                    if ((i & 1) != 0) {
                        z = true;
                    }
                    handler.data(z, i5, this.f6146a, i2);
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        /* renamed from: a */
        private void m6806a(FrameReader.Handler handler, int i, int i2) throws IOException {
            boolean z;
            boolean z2 = true;
            int readInt = this.f6146a.readInt() & Integer.MAX_VALUE;
            int readInt2 = this.f6146a.readInt() & Integer.MAX_VALUE;
            this.f6146a.readShort();
            List<Header> a = this.f6148c.mo8720a(i2 - 10);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) == 0) {
                z2 = false;
            }
            handler.headers(z2, z, readInt, readInt2, a, HeadersMode.SPDY_SYN_STREAM);
        }

        /* renamed from: b */
        private void m6807b(FrameReader.Handler handler, int i, int i2) throws IOException {
            boolean z;
            int readInt = this.f6146a.readInt() & Integer.MAX_VALUE;
            List<Header> a = this.f6148c.mo8720a(i2 - 4);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            handler.headers(false, z, readInt, -1, a, HeadersMode.SPDY_REPLY);
        }

        /* renamed from: c */
        private void m6808c(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw m6805a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.f6146a.readInt() & Integer.MAX_VALUE;
            int readInt2 = this.f6146a.readInt();
            ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(readInt2);
            if (fromSpdy3Rst == null) {
                throw m6805a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
            } else {
                handler.rstStream(readInt, fromSpdy3Rst);
            }
        }

        /* renamed from: d */
        private void m6809d(FrameReader.Handler handler, int i, int i2) throws IOException {
            handler.headers(false, false, this.f6146a.readInt() & Integer.MAX_VALUE, -1, this.f6148c.mo8720a(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        /* renamed from: e */
        private void m6810e(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw m6805a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.f6146a.readInt() & Integer.MAX_VALUE;
            long readInt2 = (long) (this.f6146a.readInt() & Integer.MAX_VALUE);
            if (readInt2 == 0) {
                throw m6805a("windowSizeIncrement was 0", Long.valueOf(readInt2));
            } else {
                handler.windowUpdate(readInt, readInt2);
            }
        }

        /* renamed from: f */
        private void m6811f(FrameReader.Handler handler, int i, int i2) throws IOException {
            boolean z;
            boolean z2 = true;
            if (i2 != 4) {
                throw m6805a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            int readInt = this.f6146a.readInt();
            boolean z3 = this.f6147b;
            if ((readInt & 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z3 != z) {
                z2 = false;
            }
            handler.ping(z2, readInt, 0);
        }

        /* renamed from: g */
        private void m6812g(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw m6805a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.f6146a.readInt() & Integer.MAX_VALUE;
            int readInt2 = this.f6146a.readInt();
            ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(readInt2);
            if (fromSpdyGoAway == null) {
                throw m6805a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            } else {
                handler.goAway(readInt, fromSpdyGoAway, ByteString.EMPTY);
            }
        }

        /* renamed from: h */
        private void m6813h(FrameReader.Handler handler, int i, int i2) throws IOException {
            boolean z = true;
            int readInt = this.f6146a.readInt();
            if (i2 != (readInt * 8) + 4) {
                throw m6805a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(readInt));
            }
            Settings settings = new Settings();
            for (int i3 = 0; i3 < readInt; i3++) {
                int readInt2 = this.f6146a.readInt();
                settings.mo11068a(readInt2 & ViewCompat.MEASURED_SIZE_MASK, (-16777216 & readInt2) >>> 24, this.f6146a.readInt());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            handler.settings(z, settings);
        }

        /* renamed from: a */
        private static IOException m6805a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public void close() throws IOException {
            this.f6148c.mo8721a();
        }
    }

    /* renamed from: okhttp3.internal.framed.Spdy3$b */
    static final class C1807b implements FrameWriter {

        /* renamed from: a */
        private final BufferedSink f6149a;

        /* renamed from: b */
        private final Buffer f6150b = new Buffer();

        /* renamed from: c */
        private final BufferedSink f6151c;

        /* renamed from: d */
        private final boolean f6152d;

        /* renamed from: e */
        private boolean f6153e;

        C1807b(BufferedSink bufferedSink, boolean z) {
            this.f6149a = bufferedSink;
            this.f6152d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.f6145a);
            this.f6151c = Okio.buffer((Sink) new DeflaterSink((Sink) this.f6150b, deflater));
        }

        public void ackSettings(Settings settings) {
        }

        public void pushPromise(int i, int i2, List<Header> list) throws IOException {
        }

        public synchronized void connectionPreface() {
        }

        public synchronized void flush() throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            }
            this.f6149a.flush();
        }

        public synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            int i3 = 0;
            synchronized (this) {
                if (this.f6153e) {
                    throw new IOException("closed");
                }
                m6814a(list);
                int size = (int) (10 + this.f6150b.size());
                int i4 = z ? 1 : 0;
                if (z2) {
                    i3 = 2;
                }
                this.f6149a.writeInt(-2147287039);
                this.f6149a.writeInt((((i3 | i4) & 255) << 24) | (size & ViewCompat.MEASURED_SIZE_MASK));
                this.f6149a.writeInt(i & Integer.MAX_VALUE);
                this.f6149a.writeInt(i2 & Integer.MAX_VALUE);
                this.f6149a.writeShort(0);
                this.f6149a.writeAll(this.f6150b);
                this.f6149a.flush();
            }
        }

        public synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            }
            m6814a(list);
            int i2 = z ? 1 : 0;
            int size = (int) (this.f6150b.size() + 4);
            this.f6149a.writeInt(-2147287038);
            this.f6149a.writeInt(((i2 & 255) << 24) | (size & ViewCompat.MEASURED_SIZE_MASK));
            this.f6149a.writeInt(Integer.MAX_VALUE & i);
            this.f6149a.writeAll(this.f6150b);
            this.f6149a.flush();
        }

        public synchronized void headers(int i, List<Header> list) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            }
            m6814a(list);
            this.f6149a.writeInt(-2147287032);
            this.f6149a.writeInt((((int) (this.f6150b.size() + 4)) & ViewCompat.MEASURED_SIZE_MASK) | 0);
            this.f6149a.writeInt(Integer.MAX_VALUE & i);
            this.f6149a.writeAll(this.f6150b);
        }

        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            } else if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            } else {
                this.f6149a.writeInt(-2147287037);
                this.f6149a.writeInt(8);
                this.f6149a.writeInt(Integer.MAX_VALUE & i);
                this.f6149a.writeInt(errorCode.spdyRstCode);
                this.f6149a.flush();
            }
        }

        public int maxDataLength() {
            return 16383;
        }

        public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
            mo11082a(i, z ? 1 : 0, buffer, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11082a(int i, int i2, Buffer buffer, int i3) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            } else if (((long) i3) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            } else {
                this.f6149a.writeInt(Integer.MAX_VALUE & i);
                this.f6149a.writeInt(((i2 & 255) << 24) | (16777215 & i3));
                if (i3 > 0) {
                    this.f6149a.write(buffer, (long) i3);
                }
            }
        }

        /* renamed from: a */
        private void m6814a(List<Header> list) throws IOException {
            this.f6151c.writeInt(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = list.get(i).name;
                this.f6151c.writeInt(byteString.size());
                this.f6151c.write(byteString);
                ByteString byteString2 = list.get(i).value;
                this.f6151c.writeInt(byteString2.size());
                this.f6151c.write(byteString2);
            }
            this.f6151c.flush();
        }

        public synchronized void settings(Settings settings) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            }
            int b = settings.mo11072b();
            this.f6149a.writeInt(-2147287036);
            this.f6149a.writeInt((((b * 8) + 4) & ViewCompat.MEASURED_SIZE_MASK) | 0);
            this.f6149a.writeInt(b);
            for (int i = 0; i <= 10; i++) {
                if (settings.mo11071a(i)) {
                    this.f6149a.writeInt(((settings.mo11075c(i) & 255) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK));
                    this.f6149a.writeInt(settings.mo11073b(i));
                }
            }
            this.f6149a.flush();
        }

        public synchronized void ping(boolean z, int i, int i2) throws IOException {
            boolean z2;
            boolean z3 = true;
            synchronized (this) {
                if (this.f6153e) {
                    throw new IOException("closed");
                }
                boolean z4 = this.f6152d;
                if ((i & 1) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z4 == z2) {
                    z3 = false;
                }
                if (z != z3) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.f6149a.writeInt(-2147287034);
                this.f6149a.writeInt(4);
                this.f6149a.writeInt(i);
                this.f6149a.flush();
            }
        }

        public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            } else if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.f6149a.writeInt(-2147287033);
                this.f6149a.writeInt(8);
                this.f6149a.writeInt(i);
                this.f6149a.writeInt(errorCode.spdyGoAwayCode);
                this.f6149a.flush();
            }
        }

        public synchronized void windowUpdate(int i, long j) throws IOException {
            if (this.f6153e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.f6149a.writeInt(-2147287031);
                this.f6149a.writeInt(8);
                this.f6149a.writeInt(i);
                this.f6149a.writeInt((int) j);
                this.f6149a.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.f6153e = true;
            Util.closeAll(this.f6149a, this.f6151c);
        }
    }
}
