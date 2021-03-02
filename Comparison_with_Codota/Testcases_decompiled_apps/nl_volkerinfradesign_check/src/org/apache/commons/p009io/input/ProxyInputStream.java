package org.apache.commons.p009io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.ProxyInputStream */
public abstract class ProxyInputStream extends FilterInputStream {
    public ProxyInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read() throws IOException {
        int i = 1;
        try {
            beforeRead(1);
            int read = this.in.read();
            if (read == -1) {
                i = -1;
            }
            afterRead(i);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    public int read(byte[] bArr) throws IOException {
        int i;
        if (bArr != null) {
            try {
                i = bArr.length;
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        } else {
            i = 0;
        }
        beforeRead(i);
        int read = this.in.read(bArr);
        afterRead(read);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            beforeRead(i2);
            int read = this.in.read(bArr, i, i2);
            afterRead(read);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    public long skip(long j) throws IOException {
        try {
            return this.in.skip(j);
        } catch (IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    public synchronized void mark(int i) {
        this.in.mark(i);
    }

    public synchronized void reset() throws IOException {
        try {
            this.in.reset();
        } catch (IOException e) {
            handleIOException(e);
        }
        return;
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }

    /* access modifiers changed from: protected */
    public void beforeRead(int i) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void afterRead(int i) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }
}
