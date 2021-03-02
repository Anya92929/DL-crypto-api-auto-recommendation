package p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.framed.Header;
import okhttp3.internal.framed.Spdy3;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

/* renamed from: ja */
public class C1307ja {

    /* renamed from: a */
    private final InflaterSource f4548a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f4549b;

    /* renamed from: c */
    private final BufferedSource f4550c = Okio.buffer((Source) this.f4548a);

    public C1307ja(BufferedSource bufferedSource) {
        this.f4548a = new InflaterSource((Source) new ForwardingSource(bufferedSource) {
            public long read(Buffer buffer, long j) throws IOException {
                if (C1307ja.this.f4549b == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j, (long) C1307ja.this.f4549b));
                if (read == -1) {
                    return -1;
                }
                int unused = C1307ja.this.f4549b = (int) (((long) C1307ja.this.f4549b) - read);
                return read;
            }
        }, (Inflater) new Inflater() {
            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int inflate = super.inflate(bArr, i, i2);
                if (inflate != 0 || !needsDictionary()) {
                    return inflate;
                }
                setDictionary(Spdy3.f6145a);
                return super.inflate(bArr, i, i2);
            }
        });
    }

    /* renamed from: a */
    public List<Header> mo8720a(int i) throws IOException {
        this.f4549b += i;
        int readInt = this.f4550c.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        } else if (readInt > 1024) {
            throw new IOException("numberOfPairs > 1024: " + readInt);
        } else {
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                ByteString asciiLowercase = m5676b().toAsciiLowercase();
                ByteString b = m5676b();
                if (asciiLowercase.size() == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new Header(asciiLowercase, b));
            }
            m5677c();
            return arrayList;
        }
    }

    /* renamed from: b */
    private ByteString m5676b() throws IOException {
        return this.f4550c.readByteString((long) this.f4550c.readInt());
    }

    /* renamed from: c */
    private void m5677c() throws IOException {
        if (this.f4549b > 0) {
            this.f4548a.refill();
            if (this.f4549b != 0) {
                throw new IOException("compressedLimit > 0: " + this.f4549b);
            }
        }
    }

    /* renamed from: a */
    public void mo8721a() throws IOException {
        this.f4550c.close();
    }
}
