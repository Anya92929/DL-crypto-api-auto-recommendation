package com.appbrain.p033b;

import android.support.p009v4.app.NotificationCompat;
import java.io.OutputStream;
import java.util.ArrayList;

/* renamed from: com.appbrain.b.i */
public final class C1005i extends OutputStream {

    /* renamed from: a */
    private static final byte[] f2633a = new byte[0];

    /* renamed from: b */
    private final int f2634b = NotificationCompat.FLAG_HIGH_PRIORITY;

    /* renamed from: c */
    private final ArrayList f2635c = new ArrayList();

    /* renamed from: d */
    private int f2636d;

    /* renamed from: e */
    private byte[] f2637e = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];

    /* renamed from: f */
    private int f2638f;

    C1005i() {
    }

    /* renamed from: a */
    private void m4183a(int i) {
        this.f2635c.add(new C1018v(this.f2637e));
        this.f2636d += this.f2637e.length;
        this.f2637e = new byte[Math.max(this.f2634b, Math.max(i, this.f2636d >>> 1))];
        this.f2638f = 0;
    }

    /* renamed from: b */
    private synchronized int m4184b() {
        return this.f2636d + this.f2638f;
    }

    /* renamed from: a */
    public final synchronized C1002f mo3974a() {
        if (this.f2638f >= this.f2637e.length) {
            this.f2635c.add(new C1018v(this.f2637e));
            this.f2637e = f2633a;
        } else if (this.f2638f > 0) {
            byte[] bArr = this.f2637e;
            int i = this.f2638f;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.f2635c.add(new C1018v(bArr2));
        }
        this.f2636d += this.f2638f;
        this.f2638f = 0;
        return C1002f.m4158a((Iterable) this.f2635c);
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(m4184b())});
    }

    public final synchronized void write(int i) {
        if (this.f2638f == this.f2637e.length) {
            m4183a(1);
        }
        byte[] bArr = this.f2637e;
        int i2 = this.f2638f;
        this.f2638f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i2 <= this.f2637e.length - this.f2638f) {
            System.arraycopy(bArr, i, this.f2637e, this.f2638f, i2);
            this.f2638f += i2;
        } else {
            int length = this.f2637e.length - this.f2638f;
            System.arraycopy(bArr, i, this.f2637e, this.f2638f, length);
            int i3 = i + length;
            int i4 = i2 - length;
            m4183a(i4);
            System.arraycopy(bArr, i3, this.f2637e, 0, i4);
            this.f2638f = i4;
        }
    }
}
