package p000;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import okio.Buffer;
import okio.ByteString;

/* renamed from: jh */
public final class C1318jh extends ByteString {

    /* renamed from: e */
    final transient byte[][] f4579e;

    /* renamed from: f */
    final transient int[] f4580f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1318jh(Buffer buffer, int i) {
        super((byte[]) null);
        int i2 = 0;
        C1319ji.m5708a(buffer.f6272b, 0, (long) i);
        C1316jf jfVar = buffer.f6271a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (jfVar.f4572c == jfVar.f4571b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += jfVar.f4572c - jfVar.f4571b;
            i3++;
            jfVar = jfVar.f4575f;
        }
        this.f4579e = new byte[i3][];
        this.f4580f = new int[(i3 * 2)];
        C1316jf jfVar2 = buffer.f6271a;
        int i5 = 0;
        while (i2 < i) {
            this.f4579e[i5] = jfVar2.f4570a;
            i2 += jfVar2.f4572c - jfVar2.f4571b;
            this.f4580f[i5] = i2;
            this.f4580f[this.f4579e.length + i5] = jfVar2.f4571b;
            jfVar2.f4573d = true;
            i5++;
            jfVar2 = jfVar2.f4575f;
        }
    }

    public String utf8() {
        return m5703a().utf8();
    }

    public String base64() {
        return m5703a().base64();
    }

    public String hex() {
        return m5703a().hex();
    }

    public ByteString toAsciiLowercase() {
        return m5703a().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return m5703a().toAsciiUppercase();
    }

    public ByteString md5() {
        return m5703a().md5();
    }

    public ByteString sha256() {
        return m5703a().sha256();
    }

    public String base64Url() {
        return m5703a().base64Url();
    }

    public ByteString substring(int i) {
        return m5703a().substring(i);
    }

    public ByteString substring(int i, int i2) {
        return m5703a().substring(i, i2);
    }

    public byte getByte(int i) {
        C1319ji.m5708a((long) this.f4580f[this.f4579e.length - 1], (long) i, 1);
        int a = m5702a(i);
        return this.f4579e[a][(i - (a == 0 ? 0 : this.f4580f[a - 1])) + this.f4580f[this.f4579e.length + a]];
    }

    /* renamed from: a */
    private int m5702a(int i) {
        int binarySearch = Arrays.binarySearch(this.f4580f, 0, this.f4579e.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public int size() {
        return this.f4580f[this.f4579e.length - 1];
    }

    public byte[] toByteArray() {
        int i = 0;
        byte[] bArr = new byte[this.f4580f[this.f4579e.length - 1]];
        int length = this.f4579e.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f4580f[length + i];
            int i4 = this.f4580f[i];
            System.arraycopy(this.f4579e[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    public void write(OutputStream outputStream) throws IOException {
        int i = 0;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f4579e.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f4580f[length + i];
            int i4 = this.f4580f[i];
            outputStream.write(this.f4579e[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8805a(Buffer buffer) {
        int i = 0;
        int length = this.f4579e.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f4580f[length + i];
            int i4 = this.f4580f[i];
            C1316jf jfVar = new C1316jf(this.f4579e[i], i3, (i3 + i4) - i2);
            if (buffer.f6271a == null) {
                jfVar.f4576g = jfVar;
                jfVar.f4575f = jfVar;
                buffer.f6271a = jfVar;
            } else {
                buffer.f6271a.f4576g.mo8802a(jfVar);
            }
            i++;
            i2 = i4;
        }
        buffer.f6272b = ((long) i2) + buffer.f6272b;
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i > size() - i3) {
            return false;
        }
        int a = m5702a(i);
        while (i3 > 0) {
            int i4 = a == 0 ? 0 : this.f4580f[a - 1];
            int min = Math.min(i3, ((this.f4580f[a] - i4) + i4) - i);
            if (!byteString.rangeEquals(i2, this.f4579e[a], (i - i4) + this.f4580f[this.f4579e.length + a], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a++;
        }
        return true;
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i > size() - i3 || i2 > bArr.length - i3) {
            return false;
        }
        int a = m5702a(i);
        while (i3 > 0) {
            int i4 = a == 0 ? 0 : this.f4580f[a - 1];
            int min = Math.min(i3, ((this.f4580f[a] - i4) + i4) - i);
            if (!C1319ji.m5710a(this.f4579e[a], (i - i4) + this.f4580f[this.f4579e.length + a], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a++;
        }
        return true;
    }

    /* renamed from: a */
    private ByteString m5703a() {
        return new ByteString(toByteArray());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ByteString) && ((ByteString) obj).size() == size() && rangeEquals(0, (ByteString) obj, 0, size());
    }

    public int hashCode() {
        int i = this.f6277c;
        if (i == 0) {
            i = 1;
            int length = this.f4579e.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f4579e[i2];
                int i4 = this.f4580f[length + i2];
                int i5 = this.f4580f[i2];
                int i6 = (i5 - i3) + i4;
                int i7 = i4;
                int i8 = i;
                for (int i9 = i7; i9 < i6; i9++) {
                    i8 = (i8 * 31) + bArr[i9];
                }
                i2++;
                i3 = i5;
                i = i8;
            }
            this.f6277c = i;
        }
        return i;
    }

    public String toString() {
        return m5703a().toString();
    }

    private Object writeReplace() {
        return m5703a();
    }
}
