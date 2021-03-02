package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BrokenInputStream */
public class BrokenInputStream extends InputStream {

    /* renamed from: a */
    private final IOException f6894a;

    public BrokenInputStream(IOException iOException) {
        this.f6894a = iOException;
    }

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }

    public int read() throws IOException {
        throw this.f6894a;
    }

    public int available() throws IOException {
        throw this.f6894a;
    }

    public long skip(long j) throws IOException {
        throw this.f6894a;
    }

    public void reset() throws IOException {
        throw this.f6894a;
    }

    public void close() throws IOException {
        throw this.f6894a;
    }
}
