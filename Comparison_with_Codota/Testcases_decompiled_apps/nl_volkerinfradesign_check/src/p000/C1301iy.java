package p000;

import android.support.p001v4.media.TransportMediator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.framed.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* renamed from: iy */
public final class C1301iy {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Header[] f4529a = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Map<ByteString, Integer> f4530b = m5642c();

    /* renamed from: iy$a */
    public static final class C1302a {

        /* renamed from: a */
        Header[] f4531a = new Header[8];

        /* renamed from: b */
        int f4532b = (this.f4531a.length - 1);

        /* renamed from: c */
        int f4533c = 0;

        /* renamed from: d */
        int f4534d = 0;

        /* renamed from: e */
        private final List<Header> f4535e = new ArrayList();

        /* renamed from: f */
        private final BufferedSource f4536f;

        /* renamed from: g */
        private int f4537g;

        /* renamed from: h */
        private int f4538h;

        public C1302a(int i, Source source) {
            this.f4537g = i;
            this.f4538h = i;
            this.f4536f = Okio.buffer(source);
        }

        /* renamed from: a */
        public void mo8713a(int i) {
            this.f4537g = i;
            this.f4538h = i;
            m5647d();
        }

        /* renamed from: d */
        private void m5647d() {
            if (this.f4538h >= this.f4534d) {
                return;
            }
            if (this.f4538h == 0) {
                m5648e();
            } else {
                m5644b(this.f4534d - this.f4538h);
            }
        }

        /* renamed from: e */
        private void m5648e() {
            this.f4535e.clear();
            Arrays.fill(this.f4531a, (Object) null);
            this.f4532b = this.f4531a.length - 1;
            this.f4533c = 0;
            this.f4534d = 0;
        }

        /* renamed from: b */
        private int m5644b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f4531a.length;
                while (true) {
                    length--;
                    if (length < this.f4532b || i <= 0) {
                        System.arraycopy(this.f4531a, this.f4532b + 1, this.f4531a, this.f4532b + 1 + i2, this.f4533c);
                        this.f4532b += i2;
                    } else {
                        i -= this.f4531a[length].f6115a;
                        this.f4534d -= this.f4531a[length].f6115a;
                        this.f4533c--;
                        i2++;
                    }
                }
                System.arraycopy(this.f4531a, this.f4532b + 1, this.f4531a, this.f4532b + 1 + i2, this.f4533c);
                this.f4532b += i2;
            }
            return i2;
        }

        /* renamed from: a */
        public void mo8712a() throws IOException {
            while (!this.f4536f.exhausted()) {
                byte readByte = this.f4536f.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    m5645c(mo8711a((int) readByte, (int) TransportMediator.KEYCODE_MEDIA_PAUSE) - 1);
                } else if (readByte == 64) {
                    m5653g();
                } else if ((readByte & 64) == 64) {
                    m5651f(mo8711a((int) readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f4538h = mo8711a((int) readByte, 31);
                    if (this.f4538h < 0 || this.f4538h > this.f4537g) {
                        throw new IOException("Invalid dynamic table size update " + this.f4538h);
                    }
                    m5647d();
                } else if (readByte == 16 || readByte == 0) {
                    m5650f();
                } else {
                    m5649e(mo8711a((int) readByte, 15) - 1);
                }
            }
        }

        /* renamed from: b */
        public List<Header> mo8714b() {
            ArrayList arrayList = new ArrayList(this.f4535e);
            this.f4535e.clear();
            return arrayList;
        }

        /* renamed from: c */
        private void m5645c(int i) throws IOException {
            if (m5655h(i)) {
                this.f4535e.add(C1301iy.f4529a[i]);
                return;
            }
            int d = m5646d(i - C1301iy.f4529a.length);
            if (d < 0 || d > this.f4531a.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f4535e.add(this.f4531a[d]);
        }

        /* renamed from: d */
        private int m5646d(int i) {
            return this.f4532b + 1 + i;
        }

        /* renamed from: e */
        private void m5649e(int i) throws IOException {
            this.f4535e.add(new Header(m5652g(i), mo8715c()));
        }

        /* renamed from: f */
        private void m5650f() throws IOException {
            this.f4535e.add(new Header(C1301iy.m5641b(mo8715c()), mo8715c()));
        }

        /* renamed from: f */
        private void m5651f(int i) throws IOException {
            m5643a(-1, new Header(m5652g(i), mo8715c()));
        }

        /* renamed from: g */
        private void m5653g() throws IOException {
            m5643a(-1, new Header(C1301iy.m5641b(mo8715c()), mo8715c()));
        }

        /* renamed from: g */
        private ByteString m5652g(int i) {
            if (m5655h(i)) {
                return C1301iy.f4529a[i].name;
            }
            return this.f4531a[m5646d(i - C1301iy.f4529a.length)].name;
        }

        /* renamed from: h */
        private boolean m5655h(int i) {
            return i >= 0 && i <= C1301iy.f4529a.length + -1;
        }

        /* renamed from: a */
        private void m5643a(int i, Header header) {
            this.f4535e.add(header);
            int i2 = header.f6115a;
            if (i != -1) {
                i2 -= this.f4531a[m5646d(i)].f6115a;
            }
            if (i2 > this.f4538h) {
                m5648e();
                return;
            }
            int b = m5644b((this.f4534d + i2) - this.f4538h);
            if (i == -1) {
                if (this.f4533c + 1 > this.f4531a.length) {
                    Header[] headerArr = new Header[(this.f4531a.length * 2)];
                    System.arraycopy(this.f4531a, 0, headerArr, this.f4531a.length, this.f4531a.length);
                    this.f4532b = this.f4531a.length - 1;
                    this.f4531a = headerArr;
                }
                int i3 = this.f4532b;
                this.f4532b = i3 - 1;
                this.f4531a[i3] = header;
                this.f4533c++;
            } else {
                this.f4531a[b + m5646d(i) + i] = header;
            }
            this.f4534d = i2 + this.f4534d;
        }

        /* renamed from: h */
        private int m5654h() throws IOException {
            return this.f4536f.readByte() & 255;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo8711a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h = m5654h();
                if ((h & 128) == 0) {
                    return (h << i4) + i2;
                }
                i2 += (h & TransportMediator.KEYCODE_MEDIA_PAUSE) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public ByteString mo8715c() throws IOException {
            int h = m5654h();
            boolean z = (h & 128) == 128;
            int a = mo8711a(h, (int) TransportMediator.KEYCODE_MEDIA_PAUSE);
            if (z) {
                return ByteString.m6892of(C1304iz.m5664a().mo8719a(this.f4536f.readByteArray((long) a)));
            }
            return this.f4536f.readByteString((long) a);
        }
    }

    /* renamed from: c */
    private static Map<ByteString, Integer> m5642c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f4529a.length);
        for (int i = 0; i < f4529a.length; i++) {
            if (!linkedHashMap.containsKey(f4529a[i].name)) {
                linkedHashMap.put(f4529a[i].name, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: iy$b */
    public static final class C1303b {

        /* renamed from: a */
        private final Buffer f4539a;

        public C1303b(Buffer buffer) {
            this.f4539a = buffer;
        }

        /* renamed from: a */
        public void mo8717a(List<Header> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString asciiLowercase = list.get(i).name.toAsciiLowercase();
                Integer num = (Integer) C1301iy.f4530b.get(asciiLowercase);
                if (num != null) {
                    mo8716a(num.intValue() + 1, 15, 0);
                    mo8718a(list.get(i).value);
                } else {
                    this.f4539a.writeByte(0);
                    mo8718a(asciiLowercase);
                    mo8718a(list.get(i).value);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8716a(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.f4539a.writeByte(i3 | i);
                return;
            }
            this.f4539a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f4539a.writeByte((i4 & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
                i4 >>>= 7;
            }
            this.f4539a.writeByte(i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8718a(ByteString byteString) throws IOException {
            mo8716a(byteString.size(), TransportMediator.KEYCODE_MEDIA_PAUSE, 0);
            this.f4539a.write(byteString);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static ByteString m5641b(ByteString byteString) throws IOException {
        int i = 0;
        int size = byteString.size();
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < 65 || b > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
