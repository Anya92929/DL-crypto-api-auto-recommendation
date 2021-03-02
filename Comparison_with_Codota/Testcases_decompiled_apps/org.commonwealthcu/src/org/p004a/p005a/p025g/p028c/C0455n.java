package org.p004a.p005a.p025g.p028c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.g.c.n */
public final class C0455n {

    /* renamed from: a */
    private final Log f450a;

    /* renamed from: b */
    private final String f451b;

    public C0455n(Log log) {
        this(log, "");
    }

    private C0455n(Log log, String str) {
        this.f450a = log;
        this.f451b = str;
    }

    /* renamed from: a */
    private void m811a(String str, InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            } else if (read == 13) {
                sb.append("[\\r]");
            } else if (read == 10) {
                sb.append("[\\n]\"");
                sb.insert(0, "\"");
                sb.insert(0, str);
                this.f450a.debug(this.f451b + " " + sb.toString());
                sb.setLength(0);
            } else if (read < 32 || read > 127) {
                sb.append("[0x");
                sb.append(Integer.toHexString(read));
                sb.append("]");
            } else {
                sb.append((char) read);
            }
        }
        if (sb.length() > 0) {
            sb.append('\"');
            sb.insert(0, '\"');
            sb.insert(0, str);
            this.f450a.debug(this.f451b + " " + sb.toString());
        }
    }

    /* renamed from: a */
    public final void mo5253a(byte[] bArr) {
        C0250b.m84a((Object) bArr, "Output");
        m811a(">> ", new ByteArrayInputStream(bArr));
    }

    /* renamed from: a */
    public final void mo5254a(byte[] bArr, int i, int i2) {
        C0250b.m84a((Object) bArr, "Output");
        m811a(">> ", new ByteArrayInputStream(bArr, i, i2));
    }

    /* renamed from: a */
    public final boolean mo5255a() {
        return this.f450a.isDebugEnabled();
    }

    /* renamed from: b */
    public final void mo5256b(byte[] bArr) {
        C0250b.m84a((Object) bArr, "Input");
        m811a("<< ", new ByteArrayInputStream(bArr));
    }

    /* renamed from: b */
    public final void mo5257b(byte[] bArr, int i, int i2) {
        C0250b.m84a((Object) bArr, "Input");
        m811a("<< ", new ByteArrayInputStream(bArr, i, i2));
    }
}
