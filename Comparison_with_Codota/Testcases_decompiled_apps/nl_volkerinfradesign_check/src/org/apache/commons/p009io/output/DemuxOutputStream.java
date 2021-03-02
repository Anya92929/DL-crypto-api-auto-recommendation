package org.apache.commons.p009io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.DemuxOutputStream */
public class DemuxOutputStream extends OutputStream {

    /* renamed from: a */
    private final InheritableThreadLocal<OutputStream> f6994a = new InheritableThreadLocal<>();

    public OutputStream bindStream(OutputStream outputStream) {
        OutputStream outputStream2 = (OutputStream) this.f6994a.get();
        this.f6994a.set(outputStream);
        return outputStream2;
    }

    public void close() throws IOException {
        OutputStream outputStream = (OutputStream) this.f6994a.get();
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = (OutputStream) this.f6994a.get();
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public void write(int i) throws IOException {
        OutputStream outputStream = (OutputStream) this.f6994a.get();
        if (outputStream != null) {
            outputStream.write(i);
        }
    }
}
