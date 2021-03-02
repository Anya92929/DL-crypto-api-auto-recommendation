package org.apache.commons.p009io.output;

import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.CloseShieldOutputStream */
public class CloseShieldOutputStream extends ProxyOutputStream {
    public CloseShieldOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void close() {
        this.out = new ClosedOutputStream();
    }
}
