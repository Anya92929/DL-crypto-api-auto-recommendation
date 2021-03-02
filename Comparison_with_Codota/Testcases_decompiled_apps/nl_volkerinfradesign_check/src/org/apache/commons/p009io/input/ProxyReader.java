package org.apache.commons.p009io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* renamed from: org.apache.commons.io.input.ProxyReader */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
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

    public int read(char[] cArr) throws IOException {
        int i;
        if (cArr != null) {
            try {
                i = cArr.length;
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        } else {
            i = 0;
        }
        beforeRead(i);
        int read = this.in.read(cArr);
        afterRead(read);
        return read;
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        try {
            beforeRead(i2);
            int read = this.in.read(cArr, i, i2);
            afterRead(read);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    public int read(CharBuffer charBuffer) throws IOException {
        int i;
        if (charBuffer != null) {
            try {
                i = charBuffer.length();
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        } else {
            i = 0;
        }
        beforeRead(i);
        int read = this.in.read(charBuffer);
        afterRead(read);
        return read;
    }

    public long skip(long j) throws IOException {
        try {
            return this.in.skip(j);
        } catch (IOException e) {
            handleIOException(e);
            return 0;
        }
    }

    public boolean ready() throws IOException {
        try {
            return this.in.ready();
        } catch (IOException e) {
            handleIOException(e);
            return false;
        }
    }

    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    public synchronized void mark(int i) throws IOException {
        try {
            this.in.mark(i);
        } catch (IOException e) {
            handleIOException(e);
        }
        return;
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
