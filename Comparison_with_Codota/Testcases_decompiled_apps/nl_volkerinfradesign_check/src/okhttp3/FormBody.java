package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {

    /* renamed from: a */
    private static final MediaType f5797a = MediaType.parse("application/x-www-form-urlencoded");

    /* renamed from: b */
    private final List<String> f5798b;

    /* renamed from: c */
    private final List<String> f5799c;

    private FormBody(List<String> list, List<String> list2) {
        this.f5798b = Util.immutableList(list);
        this.f5799c = Util.immutableList(list2);
    }

    public int size() {
        return this.f5798b.size();
    }

    public String encodedName(int i) {
        return this.f5798b.get(i);
    }

    public String name(int i) {
        return HttpUrl.m6556a(encodedName(i), true);
    }

    public String encodedValue(int i) {
        return this.f5799c.get(i);
    }

    public String value(int i) {
        return HttpUrl.m6556a(encodedValue(i), true);
    }

    public MediaType contentType() {
        return f5797a;
    }

    public long contentLength() {
        return m6544a((BufferedSink) null, true);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        m6544a(bufferedSink, false);
    }

    /* renamed from: a */
    private long m6544a(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        long j = 0;
        if (z) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.f5798b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f5798b.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f5799c.get(i));
        }
        if (z) {
            j = buffer.size();
            buffer.clear();
        }
        return j;
    }

    public static final class Builder {

        /* renamed from: a */
        private final List<String> f5800a = new ArrayList();

        /* renamed from: b */
        private final List<String> f5801b = new ArrayList();

        public Builder add(String str, String str2) {
            this.f5800a.add(HttpUrl.m6555a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f5801b.add(HttpUrl.m6555a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            this.f5800a.add(HttpUrl.m6555a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f5801b.add(HttpUrl.m6555a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.f5800a, this.f5801b);
        }
    }
}
