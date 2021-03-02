package org.p004a.p005a.p022f.p023a.p024a;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0380e;

/* renamed from: org.a.a.f.a.a.b */
public final class C0364b extends C0363a {

    /* renamed from: a */
    private final File f194a;

    /* renamed from: b */
    private final String f195b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0364b(File file) {
        this(file, C0380e.f227b, file != null ? file.getName() : null);
    }

    private C0364b(File file, C0380e eVar, String str) {
        super(eVar);
        C0250b.m84a((Object) file, "File");
        this.f194a = file;
        this.f195b = str;
    }

    /* renamed from: a */
    public final void mo5098a(OutputStream outputStream) {
        C0250b.m84a((Object) outputStream, "Output stream");
        FileInputStream fileInputStream = new FileInputStream(this.f194a);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    /* renamed from: c */
    public final String mo5100c() {
        return "binary";
    }

    /* renamed from: d */
    public final long mo5101d() {
        return this.f194a.length();
    }

    /* renamed from: e */
    public final String mo5102e() {
        return this.f195b;
    }
}
