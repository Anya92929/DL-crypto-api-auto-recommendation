package com.google.android.gms.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.rc */
class C1870rc extends FilterInputStream {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f5541a;

    private C1870rc(InputStream inputStream) {
        super(inputStream);
        this.f5541a = 0;
    }

    public int read() {
        int read = super.read();
        if (read != -1) {
            this.f5541a++;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f5541a += read;
        }
        return read;
    }
}
