package org.apache.commons.p009io.filefilter;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.p009io.IOUtils;

/* renamed from: org.apache.commons.io.filefilter.MagicNumberFileFilter */
public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;

    /* renamed from: a */
    private final byte[] f6864a;

    /* renamed from: b */
    private final long f6865b;

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0);
    }

    public MagicNumberFileFilter(String str) {
        this(str, 0);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (str.length() == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j < 0) {
            throw new IllegalArgumentException("The offset cannot be negative");
        } else {
            this.f6864a = str.getBytes();
            this.f6865b = j;
        }
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j < 0) {
            throw new IllegalArgumentException("The offset cannot be negative");
        } else {
            this.f6864a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f6864a, 0, bArr.length);
            this.f6865b = j;
        }
    }

    public boolean accept(File file) {
        RandomAccessFile randomAccessFile;
        boolean z = false;
        if (file != null && file.isFile() && file.canRead()) {
            try {
                byte[] bArr = new byte[this.f6864a.length];
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    randomAccessFile.seek(this.f6865b);
                    if (randomAccessFile.read(bArr) != this.f6864a.length) {
                        IOUtils.closeQuietly((Closeable) randomAccessFile);
                    } else {
                        z = Arrays.equals(this.f6864a, bArr);
                        IOUtils.closeQuietly((Closeable) randomAccessFile);
                    }
                } catch (IOException e) {
                    IOUtils.closeQuietly((Closeable) randomAccessFile);
                    return z;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((Closeable) randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                randomAccessFile = null;
                IOUtils.closeQuietly((Closeable) randomAccessFile);
                return z;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                IOUtils.closeQuietly((Closeable) randomAccessFile);
                throw th;
            }
        }
        return z;
    }

    public String toString() {
        return super.toString() + "(" + new String(this.f6864a) + "," + this.f6865b + ")";
    }
}
