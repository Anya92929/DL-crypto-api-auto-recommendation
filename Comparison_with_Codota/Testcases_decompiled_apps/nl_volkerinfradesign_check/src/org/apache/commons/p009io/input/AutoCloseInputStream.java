package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.AutoCloseInputStream */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void close() throws IOException {
        this.in.close();
        this.in = new ClosedInputStream();
    }

    /* access modifiers changed from: protected */
    public void afterRead(int i) throws IOException {
        if (i == -1) {
            close();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
