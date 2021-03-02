package org.scribe.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.scribe.utils.StreamUtils;

public class Response {
    private static final String EMPTY = "";
    private String body;
    private int code;
    private Map<String, String> headers;
    private InputStream stream;

    Response(HttpURLConnection connection) throws IOException {
        try {
            connection.connect();
            this.code = connection.getResponseCode();
            this.headers = parseHeaders(connection);
            this.stream = isSuccessful() ? connection.getInputStream() : connection.getErrorStream();
        } catch (UnknownHostException e) {
            this.code = 404;
            this.body = EMPTY;
        }
    }

    private String parseBodyContents() {
        this.body = StreamUtils.getStreamContents(getStream());
        return this.body;
    }

    private Map<String, String> parseHeaders(HttpURLConnection conn) {
        Map<String, String> headers2 = new HashMap<>();
        for (String key : conn.getHeaderFields().keySet()) {
            headers2.put(key, ((List) conn.getHeaderFields().get(key)).get(0));
        }
        return headers2;
    }

    public boolean isSuccessful() {
        return getCode() >= 200 && getCode() < 400;
    }

    public String getBody() {
        return this.body != null ? this.body : parseBodyContents();
    }

    public InputStream getStream() {
        return this.stream;
    }

    public int getCode() {
        return this.code;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getHeader(String name) {
        return this.headers.get(name);
    }
}
