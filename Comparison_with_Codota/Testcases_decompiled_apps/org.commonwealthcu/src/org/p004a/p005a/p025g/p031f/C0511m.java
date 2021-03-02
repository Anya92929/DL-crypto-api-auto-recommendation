package org.p004a.p005a.p025g.p031f;

import java.net.Socket;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0515b;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.g.f.m */
public final class C0511m extends C0501c implements C0515b {

    /* renamed from: a */
    private final Socket f560a;

    /* renamed from: b */
    private boolean f561b = false;

    public C0511m(Socket socket, int i, C0544b bVar) {
        int i2 = 1024;
        C0250b.m84a((Object) socket, "Socket");
        this.f560a = socket;
        int receiveBufferSize = i < 0 ? socket.getReceiveBufferSize() : i;
        mo5281a(socket.getInputStream(), receiveBufferSize >= 1024 ? receiveBufferSize : i2, bVar);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final boolean mo5236a(int i) {
        boolean f = mo5284f();
        if (!f) {
            int soTimeout = this.f560a.getSoTimeout();
            try {
                this.f560a.setSoTimeout(i);
                mo5283e();
                f = mo5284f();
                this.f560a.setSoTimeout(soTimeout);
            } catch (Throwable th) {
                this.f560a.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return f;
    }

    /* renamed from: c */
    public final boolean mo5238c() {
        return this.f561b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final int mo5283e() {
        int e = super.mo5283e();
        this.f561b = e == -1;
        return e;
    }
}
