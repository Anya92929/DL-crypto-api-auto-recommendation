package cmn;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Exchanger;

/* renamed from: cmn.v */
final class C0760v extends C0726au {

    /* renamed from: c */
    private final C0759u f1876c;

    /* renamed from: d */
    private final String f1877d;

    public C0760v(C0759u uVar, String str) {
        this.f1876c = uVar;
        this.f1877d = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C0762x mo3411a() {
        byte[] bArr;
        C0710ae a = this.f1876c.f1875c;
        if (a != null) {
            try {
                Exchanger exchanger = new Exchanger();
                a.mo3388a((Object) this.f1877d, (C0708ac) new C0761w(this, exchanger));
                bArr = (byte[]) exchanger.exchange((Object) null);
            } catch (Throwable th) {
                return new C0762x((byte[]) null, th);
            }
        } else {
            bArr = null;
        }
        if (bArr == null) {
            String unused = C0759u.f1873a;
            new StringBuilder("Start get to ").append(this.f1877d);
            C0717al a2 = C0716ak.m3200a().mo3399a(this.f1877d);
            String unused2 = C0759u.f1873a;
            new StringBuilder("End get to ").append(this.f1877d);
            if (a2.mo3401a() == 404) {
                return new C0762x((byte[]) null, new IOException("Http 404"));
            }
            bArr = a2.mo3402b();
            if (a != null && bArr.length < a.mo3386a() / 2) {
                a.mo3389a((Object) this.f1877d, (Object) bArr);
            }
        }
        return new C0762x(bArr, (Throwable) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo3412a(Object obj) {
        C0762x xVar = (C0762x) obj;
        synchronized (this.f1876c.f1874b) {
            List<C0708ac> list = (List) this.f1876c.f1874b.get(this.f1877d);
            if (list != null) {
                for (C0708ac a : list) {
                    a.mo3385a(xVar);
                }
            }
            this.f1876c.f1874b.remove(this.f1877d);
        }
    }
}
