package org.apache.commons.p009io.output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.p009io.input.ClosedInputStream;

/* renamed from: org.apache.commons.io.output.ByteArrayOutputStream */
public class ByteArrayOutputStream extends OutputStream {

    /* renamed from: a */
    private static final byte[] f6980a = new byte[0];

    /* renamed from: b */
    private final List<byte[]> f6981b;

    /* renamed from: c */
    private int f6982c;

    /* renamed from: d */
    private int f6983d;

    /* renamed from: e */
    private byte[] f6984e;

    /* renamed from: f */
    private int f6985f;

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int i) {
        this.f6981b = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        synchronized (this) {
            m7326a(i);
        }
    }

    /* renamed from: a */
    private void m7326a(int i) {
        if (this.f6982c < this.f6981b.size() - 1) {
            this.f6983d += this.f6984e.length;
            this.f6982c++;
            this.f6984e = this.f6981b.get(this.f6982c);
            return;
        }
        if (this.f6984e == null) {
            this.f6983d = 0;
        } else {
            i = Math.max(this.f6984e.length << 1, i - this.f6983d);
            this.f6983d += this.f6984e.length;
        }
        this.f6982c++;
        this.f6984e = new byte[i];
        this.f6981b.add(this.f6984e);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i3 = this.f6985f + i2;
                int i4 = this.f6985f - this.f6983d;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.f6984e.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.f6984e, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        m7326a(i3);
                        i4 = 0;
                    }
                }
                this.f6985f = i3;
            }
        }
    }

    public synchronized void write(int i) {
        int i2 = this.f6985f - this.f6983d;
        if (i2 == this.f6984e.length) {
            m7326a(this.f6985f + 1);
            i2 = 0;
        }
        this.f6984e[i2] = (byte) i;
        this.f6985f++;
    }

    public synchronized int write(InputStream inputStream) throws IOException {
        int i;
        int i2 = this.f6985f - this.f6983d;
        i = 0;
        int i3 = i2;
        int read = inputStream.read(this.f6984e, i2, this.f6984e.length - i2);
        int i4 = i3;
        while (read != -1) {
            i += read;
            i4 += read;
            this.f6985f = read + this.f6985f;
            if (i4 == this.f6984e.length) {
                m7326a(this.f6984e.length);
                i4 = 0;
            }
            read = inputStream.read(this.f6984e, i4, this.f6984e.length - i4);
        }
        return i;
    }

    public synchronized int size() {
        return this.f6985f;
    }

    public void close() throws IOException {
    }

    public synchronized void reset() {
        this.f6985f = 0;
        this.f6983d = 0;
        this.f6982c = 0;
        this.f6984e = this.f6981b.get(this.f6982c);
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        int i = this.f6985f;
        Iterator<byte[]> it = this.f6981b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            byte[] next = it.next();
            int min = Math.min(next.length, i2);
            outputStream.write(next, 0, min);
            i = i2 - min;
            if (i == 0) {
                break;
            }
        }
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.m7325a();
    }

    /* renamed from: a */
    private InputStream m7325a() {
        int i = this.f6985f;
        if (i == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.f6981b.size());
        Iterator<byte[]> it = this.f6981b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            byte[] next = it.next();
            int min = Math.min(next.length, i2);
            arrayList.add(new ByteArrayInputStream(next, 0, min));
            i = i2 - min;
            if (i == 0) {
                break;
            }
        }
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        int i = 0;
        synchronized (this) {
            int i2 = this.f6985f;
            if (i2 == 0) {
                bArr = f6980a;
            } else {
                byte[] bArr2 = new byte[i2];
                Iterator<byte[]> it = this.f6981b.iterator();
                while (true) {
                    int i3 = i2;
                    int i4 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    byte[] next = it.next();
                    int min = Math.min(next.length, i3);
                    System.arraycopy(next, 0, bArr2, i4, min);
                    i = i4 + min;
                    i2 = i3 - min;
                    if (i2 == 0) {
                        break;
                    }
                }
                bArr = bArr2;
            }
        }
        return bArr;
    }

    public String toString() {
        return new String(toByteArray());
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }
}
