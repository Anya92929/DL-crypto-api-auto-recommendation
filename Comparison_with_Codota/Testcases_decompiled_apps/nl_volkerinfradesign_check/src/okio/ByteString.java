package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = m6892of(new byte[0]);

    /* renamed from: a */
    static final char[] f6275a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;

    /* renamed from: b */
    final byte[] f6276b;

    /* renamed from: c */
    public transient int f6277c;

    /* renamed from: d */
    transient String f6278d;

    public ByteString(byte[] bArr) {
        this.f6276b = bArr;
    }

    /* renamed from: of */
    public static ByteString m6892of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: of */
    public static ByteString m6893of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        C1319ji.m5708a((long) bArr.length, (long) i, (long) i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(C1319ji.f4581a));
        byteString.f6278d = str;
        return byteString;
    }

    public String utf8() {
        String str = this.f6278d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f6276b, C1319ji.f4581a);
        this.f6278d = str2;
        return str2;
    }

    public String base64() {
        return C1311jc.m5688a(this.f6276b);
    }

    public ByteString md5() {
        return m6891a("MD5");
    }

    public ByteString sha256() {
        return m6891a("SHA-256");
    }

    /* renamed from: a */
    private ByteString m6891a(String str) {
        try {
            return m6892of(MessageDigest.getInstance(str).digest(this.f6276b)); //CRYPTOGRAPHIC API CALLSITE 01; CRYPTOGRAPHIC API CALLSITE 02
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String base64Url() {
        return C1311jc.m5691b(this.f6276b);
    }

    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a = C1311jc.m5690a(str);
        if (a != null) {
            return new ByteString(a);
        }
        return null;
    }

    public String hex() {
        char[] cArr = new char[(this.f6276b.length * 2)];
        int i = 0;
        for (byte b : this.f6276b) {
            int i2 = i + 1;
            cArr[i] = f6275a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f6275a[b & 15];
        }
        return new String(cArr);
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        } else {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((m6890a(str.charAt(i * 2)) << 4) + m6890a(str.charAt((i * 2) + 1)));
            }
            return m6892of(bArr);
        }
    }

    /* renamed from: a */
    private static int m6890a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f6276b.length) {
                return this;
            }
            byte b = this.f6276b[i2];
            if (b < 65 || b > 90) {
                i = i2 + 1;
            } else {
                byte[] bArr = (byte[]) this.f6276b.clone();
                bArr[i2] = (byte) (b + 32);
                for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                    byte b2 = bArr[i3];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr[i3] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f6276b.length) {
                return this;
            }
            byte b = this.f6276b[i2];
            if (b < 97 || b > 122) {
                i = i2 + 1;
            } else {
                byte[] bArr = (byte[]) this.f6276b.clone();
                bArr[i2] = (byte) (b - 32);
                for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                    byte b2 = bArr[i3];
                    if (b2 >= 97 && b2 <= 122) {
                        bArr[i3] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
    }

    public ByteString substring(int i) {
        return substring(i, this.f6276b.length);
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.f6276b.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f6276b.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f6276b.length) {
                return this;
            } else {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f6276b, i, bArr, 0, i3);
                return new ByteString(bArr);
            }
        }
    }

    public byte getByte(int i) {
        return this.f6276b[i];
    }

    public int size() {
        return this.f6276b.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.f6276b.clone();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.f6276b);
    }

    /* renamed from: a */
    public void mo8805a(Buffer buffer) {
        buffer.write(this.f6276b, 0, this.f6276b.length);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.f6276b, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i <= this.f6276b.length - i3 && i2 <= bArr.length - i3 && C1319ji.m5710a(this.f6276b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ByteString) && ((ByteString) obj).size() == this.f6276b.length && ((ByteString) obj).rangeEquals(0, this.f6276b, 0, this.f6276b.length);
    }

    public int hashCode() {
        int i = this.f6277c;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f6276b);
        this.f6277c = hashCode;
        return hashCode;
    }

    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (i < min) {
            byte b = getByte(i) & 255;
            byte b2 = byteString.getByte(i) & 255;
            if (b == b2) {
                i++;
            } else if (b < b2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size >= size2) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        if (this.f6276b.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.f6276b.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.f6276b.length), hex()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.f6276b.length), md5().hex()});
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("b");
            declaredField.setAccessible(true);
            declaredField.set(this, read.f6276b);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f6276b.length);
        objectOutputStream.write(this.f6276b);
    }
}
