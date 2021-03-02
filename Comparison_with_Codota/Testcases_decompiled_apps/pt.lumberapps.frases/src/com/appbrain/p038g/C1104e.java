package com.appbrain.p038g;

import com.appbrain.p039h.C1109b;

/* renamed from: com.appbrain.g.e */
public final class C1104e {

    /* renamed from: a */
    public final byte[] f3078a;

    /* renamed from: b */
    public final String f3079b;

    private C1104e(byte[] bArr, String str) {
        this.f3078a = bArr;
        this.f3079b = str;
    }

    /* renamed from: a */
    public static C1104e m5089a(C1109b bVar) {
        String str = null;
        byte[] d = bVar.mo4411w() ? null : bVar.mo4399k().mo3969d();
        if (bVar.mo4407s()) {
            str = bVar.mo4409u().length() > 0 ? bVar.mo4409u() : C1102c.f3074a;
        }
        return new C1104e(d, str);
    }
}
