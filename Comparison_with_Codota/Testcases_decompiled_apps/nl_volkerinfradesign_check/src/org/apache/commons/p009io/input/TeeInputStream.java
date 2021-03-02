package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.input.TeeInputStream */
public class TeeInputStream extends ProxyInputStream {

    /* renamed from: a */
    private final OutputStream f6948a;

    /* renamed from: b */
    private final boolean f6949b;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    public TeeInputStream(InputStream inputStream, OutputStream outputStream, boolean z) {
        super(inputStream);
        this.f6948a = outputStream;
        this.f6949b = z;
    }

    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.f6949b) {
                this.f6948a.close();
            }
        }
    }

    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.f6948a.write(read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f6948a.write(bArr, i, read);
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = super.read(bArr);
        if (read != -1) {
            this.f6948a.write(bArr, 0, read);
        }
        return read;
    }
}
