package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {

    /* renamed from: a */
    private final Headers f6235a;

    /* renamed from: b */
    private final BufferedSource f6236b;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.f6235a = headers;
        this.f6236b = bufferedSource;
    }

    public MediaType contentType() {
        String str = this.f6235a.get("Content-Type");
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() {
        return OkHeaders.contentLength(this.f6235a);
    }

    public BufferedSource source() {
        return this.f6236b;
    }
}
