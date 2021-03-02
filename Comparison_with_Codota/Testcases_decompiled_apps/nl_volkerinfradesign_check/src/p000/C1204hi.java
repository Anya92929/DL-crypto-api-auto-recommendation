package p000;

import com.google.android.gms.internal.zzsn;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: hi */
public final class C1204hi {

    /* renamed from: a */
    final int f4264a;

    /* renamed from: b */
    public final byte[] f4265b;

    public C1204hi(int i, byte[] bArr) {
        this.f4264a = i;
        this.f4265b = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8286a() {
        return 0 + zzsn.zzmC(this.f4264a) + this.f4265b.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8287a(zzsn zzsn) throws IOException {
        zzsn.zzmB(this.f4264a);
        zzsn.zzH(this.f4265b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1204hi)) {
            return false;
        }
        C1204hi hiVar = (C1204hi) obj;
        return this.f4264a == hiVar.f4264a && Arrays.equals(this.f4265b, hiVar.f4265b);
    }

    public int hashCode() {
        return ((this.f4264a + 527) * 31) + Arrays.hashCode(this.f4265b);
    }
}
