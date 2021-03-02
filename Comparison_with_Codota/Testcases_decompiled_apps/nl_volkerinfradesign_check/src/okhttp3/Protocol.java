package okhttp3;

import java.io.IOException;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: a */
    private final String f5903a;

    private Protocol(String str) {
        this.f5903a = str;
    }

    public static Protocol get(String str) throws IOException {
        if (str.equals(HTTP_1_0.f5903a)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f5903a)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f5903a)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f5903a)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f5903a;
    }
}
