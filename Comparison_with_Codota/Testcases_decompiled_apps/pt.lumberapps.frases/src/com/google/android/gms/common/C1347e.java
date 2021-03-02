package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.e */
abstract class C1347e extends C1344c {

    /* renamed from: b */
    private static final WeakReference f4399b = new WeakReference((Object) null);

    /* renamed from: a */
    private WeakReference f4400a = f4399b;

    C1347e(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo6402a() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f4400a.get();
            if (bArr == null) {
                bArr = mo6476b();
                this.f4400a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract byte[] mo6476b();
}
