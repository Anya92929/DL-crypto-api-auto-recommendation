package org.apache.commons.p009io.input;

import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.CloseShieldInputStream */
public class CloseShieldInputStream extends ProxyInputStream {
    public CloseShieldInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void close() {
        this.in = new ClosedInputStream();
    }
}
