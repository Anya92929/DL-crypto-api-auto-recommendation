package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.DemuxInputStream */
public class DemuxInputStream extends InputStream {

    /* renamed from: a */
    private final InheritableThreadLocal<InputStream> f6904a = new InheritableThreadLocal<>();

    public InputStream bindStream(InputStream inputStream) {
        InputStream inputStream2 = (InputStream) this.f6904a.get();
        this.f6904a.set(inputStream);
        return inputStream2;
    }

    public void close() throws IOException {
        InputStream inputStream = (InputStream) this.f6904a.get();
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public int read() throws IOException {
        InputStream inputStream = (InputStream) this.f6904a.get();
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }
}
