package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.fk */
abstract class C0891fk extends C1078k {

    /* renamed from: b */
    private static final WeakReference<byte[]> f4616b = new WeakReference<>((Object) null);

    /* renamed from: a */
    private WeakReference<byte[]> f4617a = f4616b;

    C0891fk(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo7461a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f4617a.get();
            if (bArr == null) {
                bArr = mo7334b();
                this.f4617a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract byte[] mo7334b();
}
