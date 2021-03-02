package org.scribe.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.scribe.exceptions.OAuthException;

class Request {
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private ParameterList bodyParams;
    private byte[] bytePayload = null;
    private String charset;
    private Long connectTimeout = null;
    private HttpURLConnection connection;
    private boolean connectionKeepAlive = false;
    private Map<String, String> headers;
    private String payload = null;
    private ParameterList querystringParams;
    private Long readTimeout = null;
    private String url;
    private Verb verb;

    public Request(Verb verb2, String url2) {
        this.verb = verb2;
        this.url = url2;
        this.querystringParams = new ParameterList();
        this.bodyParams = new ParameterList();
        this.headers = new HashMap();
    }

    public Response send() {
        try {
            createConnection();
            return doSend();
        } catch (UnknownHostException uhe) {
            throw new OAuthException("Could not reach the desired host. Check your network connection.", uhe);
        } catch (IOException ioe) {
            throw new OAuthException("Problems while creating connection.", ioe);
        }
    }

    private void createConnection() throws IOException {
        String completeUrl = getCompleteUrl();
        if (this.connection == null) {
            System.setProperty("http.keepAlive", this.connectionKeepAlive ? "true" : "false");
            this.connection = (HttpURLConnection) new URL(completeUrl).openConnection();
        }
    }

    public String getCompleteUrl() {
        return this.querystringParams.appendTo(this.url);
    }

    /* access modifiers changed from: package-private */
    public Response doSend() throws IOException {
        this.connection.setRequestMethod(this.verb.name());
        if (this.connectTimeout != null) {
            this.connection.setConnectTimeout(this.connectTimeout.intValue());
        }
        if (this.readTimeout != null) {
            this.connection.setReadTimeout(this.readTimeout.intValue());
        }
        addHeaders(this.connection);
        if (this.verb.equals(Verb.PUT) || this.verb.equals(Verb.POST)) {
            addBody(this.connection, getByteBodyContents());
        }
        return new Response(this.connection);
    }

    /* access modifiers changed from: package-private */
    public void addHeaders(HttpURLConnection conn) {
        for (String key : this.headers.keySet()) {
            conn.setRequestProperty(key, this.headers.get(key));
        }
    }

    /* access modifiers changed from: package-private */
    public void addBody(HttpURLConnection conn, byte[] content) throws IOException {
        conn.setRequestProperty(CONTENT_LENGTH, String.valueOf(content.length));
        if (conn.getRequestProperty("Content-Type") == null) {
            conn.setRequestProperty("Content-Type", DEFAULT_CONTENT_TYPE);
        }
        conn.setDoOutput(true);
        conn.getOutputStream().write(content);
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void addBodyParameter(String key, String value) {
        this.bodyParams.add(key, value);
    }

    public void addQuerystringParameter(String key, String value) {
        this.querystringParams.add(key, value);
    }

    public void addPayload(String payload2) {
        this.payload = payload2;
    }

    public void addPayload(byte[] payload2) {
        this.bytePayload = payload2;
    }

    public ParameterList getQueryStringParams() {
        try {
            ParameterList result = new ParameterList();
            result.addQuerystring(new URL(this.url).getQuery());
            result.addAll(this.querystringParams);
            return result;
        } catch (MalformedURLException mue) {
            throw new OAuthException("Malformed URL", mue);
        }
    }

    public ParameterList getBodyParams() {
        return this.bodyParams;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSanitizedUrl() {
        return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    }

    public String getBodyContents() {
        try {
            return new String(getByteBodyContents(), getCharset());
        } catch (UnsupportedEncodingException uee) {
            throw new OAuthException("Unsupported Charset: " + this.charset, uee);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getByteBodyContents() {
        if (this.bytePayload != null) {
            return this.bytePayload;
        }
        try {
            return (this.payload != null ? this.payload : this.bodyParams.asFormUrlEncodedString()).getBytes(getCharset());
        } catch (UnsupportedEncodingException uee) {
            throw new OAuthException("Unsupported Charset: " + getCharset(), uee);
        }
    }

    public Verb getVerb() {
        return this.verb;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getCharset() {
        return this.charset == null ? Charset.defaultCharset().name() : this.charset;
    }

    public void setConnectTimeout(int duration, TimeUnit unit) {
        this.connectTimeout = Long.valueOf(unit.toMillis((long) duration));
    }

    public void setReadTimeout(int duration, TimeUnit unit) {
        this.readTimeout = Long.valueOf(unit.toMillis((long) duration));
    }

    public void setCharset(String charsetName) {
        this.charset = charsetName;
    }

    public void setConnectionKeepAlive(boolean connectionKeepAlive2) {
        this.connectionKeepAlive = connectionKeepAlive2;
    }

    /* access modifiers changed from: package-private */
    public void setConnection(HttpURLConnection connection2) {
        this.connection = connection2;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{getVerb(), getUrl()});
    }
}
