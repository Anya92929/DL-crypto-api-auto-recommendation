package cmn;

import java.io.IOException;
import java.util.Map;

/* renamed from: cmn.aq */
public final class C0722aq {

    /* renamed from: a */
    private static final Map f1788a = new C0723ar();

    /* renamed from: b */
    private final C0724as f1789b;

    /* renamed from: c */
    private int f1790c = 0;

    public C0722aq(C0724as asVar) {
        this.f1789b = C0724as.m3224a(asVar);
    }

    /* renamed from: a */
    private synchronized String m3221a(String str) {
        return ((String) this.f1789b.f1791a.get(this.f1790c)) + str;
    }

    /* renamed from: a */
    private synchronized void m3222a() {
        this.f1790c = (this.f1790c + 1) % this.f1789b.f1791a.size();
    }

    /* renamed from: a */
    public final byte[] mo3408a(String str, byte[] bArr) {
        String a = m3221a(str);
        int i = 0;
        IOException e = null;
        while (i < 3) {
            try {
                C0717al a2 = C0716ak.m3200a().mo3400a(a, bArr);
                if (a2.mo3401a() == 200) {
                    return a2.mo3402b();
                }
                if (a2.mo3401a() == 204) {
                    return null;
                }
                e = new IOException("bad response " + a2.mo3401a());
                if (a2.mo3401a() < 500) {
                    break;
                }
                m3222a();
                i++;
            } catch (IOException e2) {
                e = e2;
            }
        }
        throw e;
    }
}
