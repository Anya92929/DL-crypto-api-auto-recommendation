package com.p028a.p031c;

import java.io.ByteArrayOutputStream;

/* renamed from: com.a.c.d */
public class C0779d extends ByteArrayOutputStream {
    public C0779d(int i) {
        super(i);
    }

    public byte[] toByteArray() {
        return this.count == this.buf.length ? this.buf : super.toByteArray();
    }
}
