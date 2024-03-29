package com.parse.entity.mime.content;

import com.parse.codec.CharEncoding;
import com.parse.entity.mime.MIME;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringBody extends AbstractContentBody {
    private final Charset charset;
    private final byte[] content;

    public static StringBody create(String text, String mimeType, Charset charset2) throws IllegalArgumentException {
        try {
            return new StringBody(text, mimeType, charset2);
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Charset " + charset2 + " is not supported", ex);
        }
    }

    public static StringBody create(String text, Charset charset2) throws IllegalArgumentException {
        return create(text, (String) null, charset2);
    }

    public static StringBody create(String text) throws IllegalArgumentException {
        return create(text, (String) null, (Charset) null);
    }

    public StringBody(String text, String mimeType, Charset charset2) throws UnsupportedEncodingException {
        super(mimeType);
        if (text == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        charset2 = charset2 == null ? Charset.forName(CharEncoding.US_ASCII) : charset2;
        this.content = text.getBytes(charset2.name());
        this.charset = charset2;
    }

    public StringBody(String text, Charset charset2) throws UnsupportedEncodingException {
        this(text, "text/plain", charset2);
    }

    public StringBody(String text) throws UnsupportedEncodingException {
        this(text, "text/plain", (Charset) null);
    }

    public Reader getReader() {
        return new InputStreamReader(new ByteArrayInputStream(this.content), this.charset);
    }

    @Deprecated
    public void writeTo(OutputStream out, int mode) throws IOException {
        writeTo(out);
    }

    public void writeTo(OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream in = new ByteArrayInputStream(this.content);
        byte[] tmp = new byte[4096];
        while (true) {
            int l = in.read(tmp);
            if (l == -1) {
                out.flush();
                return;
            }
            out.write(tmp, 0, l);
        }
    }

    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    public String getCharset() {
        return this.charset.name();
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String getFilename() {
        return null;
    }
}
