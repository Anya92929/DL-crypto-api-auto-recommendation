package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p009io.ByteOrderMark;

/* renamed from: org.apache.commons.io.input.BOMInputStream */
public class BOMInputStream extends ProxyInputStream {

    /* renamed from: i */
    private static final Comparator<ByteOrderMark> f6880i = new Comparator<ByteOrderMark>() {
        /* renamed from: a */
        public int compare(ByteOrderMark byteOrderMark, ByteOrderMark byteOrderMark2) {
            int length = byteOrderMark.length();
            int length2 = byteOrderMark2.length();
            if (length > length2) {
                return -1;
            }
            if (length2 > length) {
                return 1;
            }
            return 0;
        }
    };

    /* renamed from: a */
    private final boolean f6881a;

    /* renamed from: b */
    private final List<ByteOrderMark> f6882b;

    /* renamed from: c */
    private ByteOrderMark f6883c;

    /* renamed from: d */
    private int[] f6884d;

    /* renamed from: e */
    private int f6885e;

    /* renamed from: f */
    private int f6886f;

    /* renamed from: g */
    private int f6887g;

    /* renamed from: h */
    private boolean f6888h;

    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z) {
        this(inputStream, z, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    public BOMInputStream(InputStream inputStream, boolean z, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (byteOrderMarkArr == null || byteOrderMarkArr.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.f6881a = z;
        Arrays.sort(byteOrderMarkArr, f6880i);
        this.f6882b = Arrays.asList(byteOrderMarkArr);
    }

    public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark) throws IOException {
        if (this.f6882b.contains(byteOrderMark)) {
            return this.f6883c != null && getBOM().equals(byteOrderMark);
        }
        throw new IllegalArgumentException("Stream not configure to detect " + byteOrderMark);
    }

    public ByteOrderMark getBOM() throws IOException {
        if (this.f6884d == null) {
            this.f6885e = 0;
            this.f6884d = new int[this.f6882b.get(0).length()];
            for (int i = 0; i < this.f6884d.length; i++) {
                this.f6884d[i] = this.in.read();
                this.f6885e++;
                if (this.f6884d[i] < 0) {
                    break;
                }
            }
            this.f6883c = m7290b();
            if (this.f6883c != null && !this.f6881a) {
                if (this.f6883c.length() < this.f6884d.length) {
                    this.f6886f = this.f6883c.length();
                } else {
                    this.f6885e = 0;
                }
            }
        }
        return this.f6883c;
    }

    public String getBOMCharsetName() throws IOException {
        getBOM();
        if (this.f6883c == null) {
            return null;
        }
        return this.f6883c.getCharsetName();
    }

    /* renamed from: a */
    private int m7288a() throws IOException {
        getBOM();
        if (this.f6886f >= this.f6885e) {
            return -1;
        }
        int[] iArr = this.f6884d;
        int i = this.f6886f;
        this.f6886f = i + 1;
        return iArr[i];
    }

    /* renamed from: b */
    private ByteOrderMark m7290b() {
        for (ByteOrderMark next : this.f6882b) {
            if (m7289a(next)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m7289a(ByteOrderMark byteOrderMark) {
        for (int i = 0; i < byteOrderMark.length(); i++) {
            if (byteOrderMark.get(i) != this.f6884d[i]) {
                return false;
            }
        }
        return true;
    }

    public int read() throws IOException {
        int a = m7288a();
        return a >= 0 ? a : this.in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        int i4 = 0;
        while (i2 > 0 && i4 >= 0) {
            i4 = m7288a();
            if (i4 >= 0) {
                bArr[i] = (byte) (i4 & 255);
                i2--;
                i3++;
                i++;
            }
        }
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            return i3 + read;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized void mark(int i) {
        this.f6887g = this.f6886f;
        this.f6888h = this.f6884d == null;
        this.in.mark(i);
    }

    public synchronized void reset() throws IOException {
        this.f6886f = this.f6887g;
        if (this.f6888h) {
            this.f6884d = null;
        }
        this.in.reset();
    }

    public long skip(long j) throws IOException {
        while (j > 0 && m7288a() >= 0) {
            j--;
        }
        return this.in.skip(j);
    }
}
