package com.parse.entity.mime.content;

import com.parse.entity.mime.MIME;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamBody extends AbstractContentBody {
    private final String filename;

    /* renamed from: in */
    private final InputStream f1759in;

    public InputStreamBody(InputStream in, String mimeType, String filename2) {
        super(mimeType);
        if (in == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        this.f1759in = in;
        this.filename = filename2;
    }

    public InputStreamBody(InputStream in, String filename2) {
        this(in, "application/octet-stream", filename2);
    }

    public InputStream getInputStream() {
        return this.f1759in;
    }

    @Deprecated
    public void writeTo(OutputStream out, int mode) throws IOException {
        writeTo(out);
    }

    public void writeTo(OutputStream out) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] tmp = new byte[4096];
            while (true) {
                int l = this.f1759in.read(tmp);
                if (l == -1) {
                    out.flush();
                    return;
                }
                out.write(tmp, 0, l);
            }
        } finally {
            this.f1759in.close();
        }
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }

    public String getFilename() {
        return this.filename;
    }
}
