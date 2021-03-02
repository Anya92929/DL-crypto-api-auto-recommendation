package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;
import java.io.ByteArrayOutputStream;

public class zzaa extends ByteArrayOutputStream {

    /* renamed from: a */
    private final zzu f5547a;

    public zzaa(zzu zzu, int i) {
        this.f5547a = zzu;
        this.buf = this.f5547a.zzb(Math.max(i, NotificationCompat.FLAG_LOCAL_ONLY));
    }

    /* renamed from: a */
    private void m6615a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzb = this.f5547a.zzb((this.count + i) * 2);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.f5547a.zza(this.buf);
            this.buf = zzb;
        }
    }

    public void close() {
        this.f5547a.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f5547a.zza(this.buf);
    }

    public synchronized void write(int i) {
        m6615a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m6615a(i2);
        super.write(bArr, i, i2);
    }
}
