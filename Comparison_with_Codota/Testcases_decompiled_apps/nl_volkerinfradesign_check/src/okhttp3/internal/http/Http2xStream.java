package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.Header;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2xStream implements HttpStream {

    /* renamed from: a */
    private static final ByteString f6189a = ByteString.encodeUtf8("connection");

    /* renamed from: b */
    private static final ByteString f6190b = ByteString.encodeUtf8("host");

    /* renamed from: c */
    private static final ByteString f6191c = ByteString.encodeUtf8("keep-alive");

    /* renamed from: d */
    private static final ByteString f6192d = ByteString.encodeUtf8("proxy-connection");

    /* renamed from: e */
    private static final ByteString f6193e = ByteString.encodeUtf8("transfer-encoding");

    /* renamed from: f */
    private static final ByteString f6194f = ByteString.encodeUtf8("te");

    /* renamed from: g */
    private static final ByteString f6195g = ByteString.encodeUtf8("encoding");

    /* renamed from: h */
    private static final ByteString f6196h = ByteString.encodeUtf8("upgrade");

    /* renamed from: i */
    private static final List<ByteString> f6197i = Util.immutableList((T[]) new ByteString[]{f6189a, f6190b, f6191c, f6192d, f6193e, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION});

    /* renamed from: j */
    private static final List<ByteString> f6198j = Util.immutableList((T[]) new ByteString[]{f6189a, f6190b, f6191c, f6192d, f6193e});

    /* renamed from: k */
    private static final List<ByteString> f6199k = Util.immutableList((T[]) new ByteString[]{f6189a, f6190b, f6191c, f6192d, f6194f, f6193e, f6195g, f6196h, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION});

    /* renamed from: l */
    private static final List<ByteString> f6200l = Util.immutableList((T[]) new ByteString[]{f6189a, f6190b, f6191c, f6192d, f6194f, f6193e, f6195g, f6196h});
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final StreamAllocation f6201m;

    /* renamed from: n */
    private final FramedConnection f6202n;

    /* renamed from: o */
    private HttpEngine f6203o;

    /* renamed from: p */
    private FramedStream f6204p;

    public Http2xStream(StreamAllocation streamAllocation, FramedConnection framedConnection) {
        this.f6201m = streamAllocation;
        this.f6202n = framedConnection;
    }

    public void setHttpEngine(HttpEngine httpEngine) {
        this.f6203o = httpEngine;
    }

    public Sink createRequestBody(Request request, long j) throws IOException {
        return this.f6204p.getSink();
    }

    public void writeRequestHeaders(Request request) throws IOException {
        List<Header> spdy3HeadersList;
        if (this.f6204p == null) {
            this.f6203o.writingRequestHeaders();
            boolean a = this.f6203o.mo11105a(request);
            if (this.f6202n.getProtocol() == Protocol.HTTP_2) {
                spdy3HeadersList = http2HeadersList(request);
            } else {
                spdy3HeadersList = spdy3HeadersList(request);
            }
            this.f6204p = this.f6202n.newStream(spdy3HeadersList, a, true);
            this.f6204p.readTimeout().timeout((long) this.f6203o.f6210a.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f6204p.writeTimeout().timeout((long) this.f6203o.f6210a.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.f6204p.getSink());
    }

    public void finishRequest() throws IOException {
        this.f6204p.getSink().close();
    }

    public Response.Builder readResponseHeaders() throws IOException {
        if (this.f6202n.getProtocol() == Protocol.HTTP_2) {
            return readHttp2HeadersList(this.f6204p.getResponseHeaders());
        }
        return readSpdy3HeadersList(this.f6204p.getResponseHeaders());
    }

    public static List<Header> spdy3HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
        arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(request.url())));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!f6197i.contains(encodeUtf8)) {
                String value = headers.value(i);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new Header(encodeUtf8, value));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        } else if (((Header) arrayList.get(i2)).name.equals(encodeUtf8)) {
                            arrayList.set(i2, new Header(encodeUtf8, m6831a(((Header) arrayList.get(i2)).value.utf8(), value)));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static String m6831a(String str, String str2) {
        return str + 0 + str2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.url())));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!f6199k.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readSpdy3HeadersList(List<Header> list) throws IOException {
        String str = null;
        String str2 = "HTTP/1.1";
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = list.get(i).name;
            String utf8 = list.get(i).value.utf8();
            String str3 = str2;
            int i2 = 0;
            while (i2 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                String substring = utf8.substring(i2, indexOf);
                if (!byteString.equals(Header.RESPONSE_STATUS)) {
                    if (byteString.equals(Header.VERSION)) {
                        str3 = substring;
                        substring = str;
                    } else {
                        if (!f6198j.contains(byteString)) {
                            builder.add(byteString.utf8(), substring);
                        }
                        substring = str;
                    }
                }
                str = substring;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine parse = StatusLine.parse(str2 + " " + str);
        return new Response.Builder().protocol(Protocol.SPDY_3).code(parse.code).message(parse.message).headers(builder.build());
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list) throws IOException {
        String str = null;
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = list.get(i).name;
            String utf8 = list.get(i).value.utf8();
            if (!byteString.equals(Header.RESPONSE_STATUS)) {
                if (!f6200l.contains(byteString)) {
                    builder.add(byteString.utf8(), utf8);
                }
                utf8 = str;
            }
            i++;
            str = utf8;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine parse = StatusLine.parse("HTTP/1.1 " + str);
        return new Response.Builder().protocol(Protocol.HTTP_2).code(parse.code).message(parse.message).headers(builder.build());
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer((Source) new C1816a(this.f6204p.getSource())));
    }

    public void cancel() {
        if (this.f6204p != null) {
            this.f6204p.closeLater(ErrorCode.CANCEL);
        }
    }

    /* renamed from: okhttp3.internal.http.Http2xStream$a */
    class C1816a extends ForwardingSource {
        public C1816a(Source source) {
            super(source);
        }

        public void close() throws IOException {
            Http2xStream.this.f6201m.streamFinished(false, Http2xStream.this);
            super.close();
        }
    }
}
