package org.apache.commons.p009io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.BrokenOutputStream */
public class BrokenOutputStream extends OutputStream {

    /* renamed from: a */
    private final IOException f6979a;

    public BrokenOutputStream(IOException iOException) {
        this.f6979a = iOException;
    }

    public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }

    public void write(int i) throws IOException {
        throw this.f6979a;
    }

    public void flush() throws IOException {
        throw this.f6979a;
    }

    public void close() throws IOException {
        throw this.f6979a;
    }
}
