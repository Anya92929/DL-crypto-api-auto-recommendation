package com.parse.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    public BaseNCodecOutputStream(OutputStream out, BaseNCodec basedCodec, boolean doEncode2) {
        super(out);
        this.baseNCodec = basedCodec;
        this.doEncode = doEncode2;
    }

    public void write(int i) throws IOException {
        this.singleByte[0] = (byte) i;
        write(this.singleByte, 0, 1);
    }

    public void write(byte[] b, int offset, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (offset < 0 || len < 0) {
            throw new IndexOutOfBoundsException();
        } else if (offset > b.length || offset + len > b.length) {
            throw new IndexOutOfBoundsException();
        } else if (len > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(b, offset, len);
            } else {
                this.baseNCodec.decode(b, offset, len);
            }
            flush(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1 = new byte[r0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flush(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
            r4 = 0
            com.parse.codec.binary.BaseNCodec r3 = r5.baseNCodec
            int r0 = r3.available()
            if (r0 <= 0) goto L_0x0018
            byte[] r1 = new byte[r0]
            com.parse.codec.binary.BaseNCodec r3 = r5.baseNCodec
            int r2 = r3.readResults(r1, r4, r0)
            if (r2 <= 0) goto L_0x0018
            java.io.OutputStream r3 = r5.out
            r3.write(r1, r4, r2)
        L_0x0018:
            if (r6 == 0) goto L_0x001f
            java.io.OutputStream r3 = r5.out
            r3.flush()
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.codec.binary.BaseNCodecOutputStream.flush(boolean):void");
    }

    public void flush() throws IOException {
        flush(true);
    }

    public void close() throws IOException {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1);
        }
        flush();
        this.out.close();
    }
}
