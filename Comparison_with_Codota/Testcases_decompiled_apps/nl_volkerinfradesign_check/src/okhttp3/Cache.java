package okhttp3;

import java.io.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.DiskLruCache;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.p008io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache implements Closeable, Flushable {

    /* renamed from: a */
    final InternalCache f5692a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DiskLruCache f5693b;

    /* renamed from: c */
    private int f5694c;

    /* renamed from: d */
    private int f5695d;

    /* renamed from: e */
    private int f5696e;

    /* renamed from: f */
    private int f5697f;

    /* renamed from: g */
    private int f5698g;

    /* renamed from: c */
    static /* synthetic */ int m6496c(Cache cache) {
        int i = cache.f5694c;
        cache.f5694c = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m6498d(Cache cache) {
        int i = cache.f5695d;
        cache.f5695d = i + 1;
        return i;
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.f5692a = new InternalCache() {
            public Response get(Request request) throws IOException {
                return Cache.this.mo10527a(request);
            }

            public CacheRequest put(Response response) throws IOException {
                return Cache.this.m6484a(response);
            }

            public void remove(Request request) throws IOException {
                Cache.this.m6497c(request);
            }

            public void update(Response response, Response response2) throws IOException {
                Cache.this.m6490a(response, response2);
            }

            public void trackConditionalCacheHit() {
                Cache.this.m6485a();
            }

            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.m6492a(cacheStrategy);
            }
        };
        this.f5693b = DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }

    /* renamed from: b */
    private static String m6494b(Request request) {
        return Util.md5Hex(request.url().toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo10527a(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.f5693b.get(m6494b(request));
            if (snapshot == null) {
                return null;
            }
            try {
                C1756c cVar = new C1756c(snapshot.getSource(0));
                Response a = cVar.mo10558a(snapshot);
                if (cVar.mo10560a(request, a)) {
                    return a;
                }
                Util.closeQuietly((Closeable) a.body());
                return null;
            } catch (IOException e) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public CacheRequest m6484a(Response response) throws IOException {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                m6497c(response.request());
                return null;
            } catch (IOException e) {
                return null;
            }
        } else if (!method.equals("GET") || OkHeaders.hasVaryAll(response)) {
            return null;
        } else {
            C1756c cVar = new C1756c(response);
            try {
                DiskLruCache.Editor edit = this.f5693b.edit(m6494b(response.request()));
                if (edit == null) {
                    return null;
                }
                try {
                    cVar.mo10559a(edit);
                    return new C1752a(edit);
                } catch (IOException e2) {
                    editor = edit;
                    m6491a(editor);
                    return null;
                }
            } catch (IOException e3) {
                editor = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6497c(Request request) throws IOException {
        this.f5693b.remove(m6494b(request));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6490a(Response response, Response response2) {
        C1756c cVar = new C1756c(response2);
        try {
            DiskLruCache.Editor edit = ((C1754b) response.body()).f5712a.edit();
            if (edit != null) {
                cVar.mo10559a(edit);
                edit.commit();
            }
        } catch (IOException e) {
            m6491a((DiskLruCache.Editor) null);
        }
    }

    /* renamed from: a */
    private void m6491a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException e) {
            }
        }
    }

    public void initialize() throws IOException {
        this.f5693b.initialize();
    }

    public void delete() throws IOException {
        this.f5693b.delete();
    }

    public void evictAll() throws IOException {
        this.f5693b.evictAll();
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>() {

            /* renamed from: a */
            final Iterator<DiskLruCache.Snapshot> f5700a = Cache.this.f5693b.snapshots();

            /* renamed from: b */
            String f5701b;

            /* renamed from: c */
            boolean f5702c;

            public boolean hasNext() {
                if (this.f5701b != null) {
                    return true;
                }
                this.f5702c = false;
                while (this.f5700a.hasNext()) {
                    DiskLruCache.Snapshot next = this.f5700a.next();
                    try {
                        this.f5701b = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        next.close();
                        return true;
                    } catch (IOException e) {
                        next.close();
                    } catch (Throwable th) {
                        next.close();
                        throw th;
                    }
                }
                return false;
            }

            /* renamed from: a */
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.f5701b;
                this.f5701b = null;
                this.f5702c = true;
                return str;
            }

            public void remove() {
                if (!this.f5702c) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.f5700a.remove();
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.f5695d;
    }

    public synchronized int writeSuccessCount() {
        return this.f5694c;
    }

    public long size() throws IOException {
        return this.f5693b.size();
    }

    public long maxSize() {
        return this.f5693b.getMaxSize();
    }

    public void flush() throws IOException {
        this.f5693b.flush();
    }

    public void close() throws IOException {
        this.f5693b.close();
    }

    public File directory() {
        return this.f5693b.getDirectory();
    }

    public boolean isClosed() {
        return this.f5693b.isClosed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m6492a(CacheStrategy cacheStrategy) {
        this.f5698g++;
        if (cacheStrategy.networkRequest != null) {
            this.f5696e++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.f5697f++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m6485a() {
        this.f5697f++;
    }

    public synchronized int networkCount() {
        return this.f5696e;
    }

    public synchronized int hitCount() {
        return this.f5697f;
    }

    public synchronized int requestCount() {
        return this.f5698g;
    }

    /* renamed from: okhttp3.Cache$a */
    final class C1752a implements CacheRequest {

        /* renamed from: b */
        private final DiskLruCache.Editor f5705b;

        /* renamed from: c */
        private Sink f5706c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f5707d;

        /* renamed from: e */
        private Sink f5708e;

        public C1752a(final DiskLruCache.Editor editor) throws IOException {
            this.f5705b = editor;
            this.f5706c = editor.newSink(1);
            this.f5708e = new ForwardingSink(this.f5706c, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (!C1752a.this.f5707d) {
                            boolean unused = C1752a.this.f5707d = true;
                            Cache.m6496c(Cache.this);
                            super.close();
                            editor.commit();
                        }
                    }
                }
            };
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void abort() {
            /*
                r2 = this;
                okhttp3.Cache r1 = okhttp3.Cache.this
                monitor-enter(r1)
                boolean r0 = r2.f5707d     // Catch:{ all -> 0x001f }
                if (r0 == 0) goto L_0x0009
                monitor-exit(r1)     // Catch:{ all -> 0x001f }
            L_0x0008:
                return
            L_0x0009:
                r0 = 1
                r2.f5707d = r0     // Catch:{ all -> 0x001f }
                okhttp3.Cache r0 = okhttp3.Cache.this     // Catch:{ all -> 0x001f }
                okhttp3.Cache.m6498d(r0)     // Catch:{ all -> 0x001f }
                monitor-exit(r1)     // Catch:{ all -> 0x001f }
                okio.Sink r0 = r2.f5706c
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                okhttp3.internal.DiskLruCache$Editor r0 = r2.f5705b     // Catch:{ IOException -> 0x001d }
                r0.abort()     // Catch:{ IOException -> 0x001d }
                goto L_0x0008
            L_0x001d:
                r0 = move-exception
                goto L_0x0008
            L_0x001f:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x001f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.C1752a.abort():void");
        }

        public Sink body() {
            return this.f5708e;
        }
    }

    /* renamed from: okhttp3.Cache$c */
    static final class C1756c {

        /* renamed from: a */
        private final String f5718a;

        /* renamed from: b */
        private final Headers f5719b;

        /* renamed from: c */
        private final String f5720c;

        /* renamed from: d */
        private final Protocol f5721d;

        /* renamed from: e */
        private final int f5722e;

        /* renamed from: f */
        private final String f5723f;

        /* renamed from: g */
        private final Headers f5724g;

        /* renamed from: h */
        private final Handshake f5725h;

        public C1756c(Source source) throws IOException {
            TlsVersion tlsVersion = null;
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f5718a = buffer.readUtf8LineStrict();
                this.f5720c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int a = Cache.m6493b(buffer);
                for (int i = 0; i < a; i++) {
                    builder.mo10690a(buffer.readUtf8LineStrict());
                }
                this.f5719b = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f5721d = parse.protocol;
                this.f5722e = parse.code;
                this.f5723f = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int a2 = Cache.m6493b(buffer);
                for (int i2 = 0; i2 < a2; i2++) {
                    builder2.mo10690a(buffer.readUtf8LineStrict());
                }
                this.f5724g = builder2.build();
                if (m6506a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.f5725h = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : tlsVersion, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), m6504a(buffer), m6504a(buffer));
                } else {
                    this.f5725h = null;
                }
            } finally {
                source.close();
            }
        }

        public C1756c(Response response) {
            this.f5718a = response.request().url().toString();
            this.f5719b = OkHeaders.varyHeaders(response);
            this.f5720c = response.request().method();
            this.f5721d = response.protocol();
            this.f5722e = response.code();
            this.f5723f = response.message();
            this.f5724g = response.headers();
            this.f5725h = response.handshake();
        }

        /* renamed from: a */
        public void mo10559a(DiskLruCache.Editor editor) throws IOException {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f5718a);
            buffer.writeByte(10);
            buffer.writeUtf8(this.f5720c);
            buffer.writeByte(10);
            buffer.writeDecimalLong((long) this.f5719b.size());
            buffer.writeByte(10);
            int size = this.f5719b.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(this.f5719b.name(i));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.f5719b.value(i));
                buffer.writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f5721d, this.f5722e, this.f5723f).toString());
            buffer.writeByte(10);
            buffer.writeDecimalLong((long) this.f5724g.size());
            buffer.writeByte(10);
            int size2 = this.f5724g.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(this.f5724g.name(i2));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.f5724g.value(i2));
                buffer.writeByte(10);
            }
            if (m6506a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.f5725h.cipherSuite().javaName());
                buffer.writeByte(10);
                m6505a(buffer, this.f5725h.peerCertificates());
                m6505a(buffer, this.f5725h.localCertificates());
                if (this.f5725h.tlsVersion() != null) {
                    buffer.writeUtf8(this.f5725h.tlsVersion().javaName());
                    buffer.writeByte(10);
                }
            }
            buffer.close();
        }

        /* renamed from: a */
        private boolean m6506a() {
            return this.f5718a.startsWith("https://");
        }

        /* renamed from: a */
        private List<Certificate> m6504a(BufferedSource bufferedSource) throws IOException {
            int a = Cache.m6493b(bufferedSource);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509"); //CRYPTOGRAPHIC API CALLSITE 03
                Cipher c;
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    InputStream inputStream = buffer.inputStream();

                    arrayList.add(instance.generateCertificate(inputStream)); //CRYPTOGRAPHIC API CALLSITE 04
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        private void m6505a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size());
                bufferedSink.writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.m6892of(list.get(i).getEncoded()).base64()); //CRYPTOGRAPHIC API CALLSITE 15
                    bufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        public boolean mo10560a(Request request, Response response) {
            return this.f5718a.equals(request.url().toString()) && this.f5720c.equals(request.method()) && OkHeaders.varyMatches(response, this.f5719b, request);
        }

        /* renamed from: a */
        public Response mo10558a(DiskLruCache.Snapshot snapshot) {
            String str = this.f5724g.get("Content-Type");
            String str2 = this.f5724g.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.f5718a).method(this.f5720c, (RequestBody) null).headers(this.f5719b).build()).protocol(this.f5721d).code(this.f5722e).message(this.f5723f).headers(this.f5724g).body(new C1754b(snapshot, str, str2)).handshake(this.f5725h).build();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m6493b(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: okhttp3.Cache$b */
    static class C1754b extends ResponseBody {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final DiskLruCache.Snapshot f5712a;

        /* renamed from: b */
        private final BufferedSource f5713b;

        /* renamed from: c */
        private final String f5714c;

        /* renamed from: d */
        private final String f5715d;

        public C1754b(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f5712a = snapshot;
            this.f5714c = str;
            this.f5715d = str2;
            this.f5713b = Okio.buffer((Source) new ForwardingSource(snapshot.getSource(1)) {
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            if (this.f5714c != null) {
                return MediaType.parse(this.f5714c);
            }
            return null;
        }

        public long contentLength() {
            try {
                if (this.f5715d != null) {
                    return Long.parseLong(this.f5715d);
                }
                return -1;
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        public BufferedSource source() {
            return this.f5713b;
        }
    }
}
