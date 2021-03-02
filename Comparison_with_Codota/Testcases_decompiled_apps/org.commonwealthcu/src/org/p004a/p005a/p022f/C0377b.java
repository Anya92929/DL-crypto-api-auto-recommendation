package org.p004a.p005a.p022f;

import java.io.InputStream;
import java.io.OutputStream;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;

/* renamed from: org.a.a.f.b */
public final class C0377b extends C0361a {

    /* renamed from: a */
    private InputStream f223a;

    /* renamed from: b */
    private long f224b = -1;

    /* renamed from: a */
    public final void mo5118a(long j) {
        this.f224b = j;
    }

    /* renamed from: a */
    public final void mo5119a(InputStream inputStream) {
        this.f223a = inputStream;
    }

    /* renamed from: a */
    public final void mo4951a(OutputStream outputStream) {
        C0250b.m84a((Object) outputStream, "Output stream");
        InputStream f = mo4955f();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = f.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            f.close();
        }
    }

    /* renamed from: a */
    public final boolean mo4952a() {
        return false;
    }

    /* renamed from: c */
    public final long mo5116c() {
        return this.f224b;
    }

    /* renamed from: f */
    public final InputStream mo4955f() {
        C0266m.m146a(this.f223a != null, "Content has not been provided");
        return this.f223a;
    }

    /* renamed from: g */
    public final boolean mo5117g() {
        return this.f223a != null;
    }
}
