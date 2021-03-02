package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");

    /* renamed from: a */
    private static final byte[] f5839a = {58, 32};

    /* renamed from: b */
    private static final byte[] f5840b = {13, 10};

    /* renamed from: c */
    private static final byte[] f5841c = {45, 45};

    /* renamed from: d */
    private final ByteString f5842d;

    /* renamed from: e */
    private final MediaType f5843e;

    /* renamed from: f */
    private final MediaType f5844f;

    /* renamed from: g */
    private final List<Part> f5845g;

    /* renamed from: h */
    private long f5846h = -1;

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.f5842d = byteString;
        this.f5843e = mediaType;
        this.f5844f = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
        this.f5845g = Util.immutableList(list);
    }

    public MediaType type() {
        return this.f5843e;
    }

    public String boundary() {
        return this.f5842d.utf8();
    }

    public int size() {
        return this.f5845g.size();
    }

    public List<Part> parts() {
        return this.f5845g;
    }

    public Part part(int i) {
        return this.f5845g.get(i);
    }

    public MediaType contentType() {
        return this.f5844f;
    }

    public long contentLength() throws IOException {
        long j = this.f5846h;
        if (j != -1) {
            return j;
        }
        long a = m6585a((BufferedSink) null, true);
        this.f5846h = a;
        return a;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        m6585a(bufferedSink, false);
    }

    /* renamed from: a */
    private long m6585a(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        long j = 0;
        if (z) {
            Buffer buffer2 = new Buffer();
            buffer = buffer2;
            bufferedSink = buffer2;
        } else {
            buffer = null;
        }
        int size = this.f5845g.size();
        for (int i = 0; i < size; i++) {
            Part part = this.f5845g.get(i);
            Headers a = part.f5850a;
            RequestBody b = part.f5851b;
            bufferedSink.write(f5841c);
            bufferedSink.write(this.f5842d);
            bufferedSink.write(f5840b);
            if (a != null) {
                int size2 = a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(a.name(i2)).write(f5839a).writeUtf8(a.value(i2)).write(f5840b);
                }
            }
            MediaType contentType = b.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(f5840b);
            }
            long contentLength = b.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(f5840b);
            } else if (z) {
                buffer.clear();
                return -1;
            }
            bufferedSink.write(f5840b);
            if (z) {
                j += contentLength;
            } else {
                b.writeTo(bufferedSink);
            }
            bufferedSink.write(f5840b);
        }
        bufferedSink.write(f5841c);
        bufferedSink.write(this.f5842d);
        bufferedSink.write(f5841c);
        bufferedSink.write(f5840b);
        if (!z) {
            return j;
        }
        long size3 = j + buffer.size();
        buffer.clear();
        return size3;
    }

    /* renamed from: a */
    static StringBuilder m6586a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case 10:
                    sb.append("%0A");
                    break;
                case 13:
                    sb.append("%0D");
                    break;
                case '\"':
                    sb.append("%22");
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
        }
        sb.append('\"');
        return sb;
    }

    public static final class Part {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Headers f5850a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final RequestBody f5851b;

        public static Part create(RequestBody requestBody) {
            return create((Headers) null, requestBody);
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, (String) null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            MultipartBody.m6586a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                MultipartBody.m6586a(sb, str2);
            }
            return create(Headers.m6547of("Content-Disposition", sb.toString()), requestBody);
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.f5850a = headers;
            this.f5851b = requestBody;
        }
    }

    public static final class Builder {

        /* renamed from: a */
        private final ByteString f5847a;

        /* renamed from: b */
        private MediaType f5848b;

        /* renamed from: c */
        private final List<Part> f5849c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.f5848b = MultipartBody.MIXED;
            this.f5849c = new ArrayList();
            this.f5847a = ByteString.encodeUtf8(str);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (!mediaType.type().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + mediaType);
            } else {
                this.f5848b = mediaType;
                return this;
            }
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.f5849c.add(part);
            return this;
        }

        public MultipartBody build() {
            if (!this.f5849c.isEmpty()) {
                return new MultipartBody(this.f5847a, this.f5848b, this.f5849c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }
}
