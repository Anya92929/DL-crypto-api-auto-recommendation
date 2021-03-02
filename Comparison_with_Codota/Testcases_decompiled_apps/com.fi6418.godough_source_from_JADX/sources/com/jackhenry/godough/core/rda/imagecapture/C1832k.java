package com.jackhenry.godough.core.rda.imagecapture;

import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.rda.C1805aa;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.k */
public class C1832k extends C1758o<String, Boolean> {

    /* renamed from: e */
    String f6689e;

    /* renamed from: f */
    byte[] f6690f;

    public C1832k(byte[] bArr, int i, C1759p<Boolean> pVar) {
        super(pVar);
        this.f6689e = C1805aa.m6703a(i);
        this.f6690f = bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean mo9592a(String... strArr) {
        return Boolean.valueOf(C1805aa.m6706a(this.f6689e, this.f6690f));
    }
}
