package com.jackhenry.godough.core.accounts;

import android.graphics.Bitmap;
import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;

/* renamed from: com.jackhenry.godough.core.accounts.r */
public class C1438r extends C1758o<Void, Bitmap> {

    /* renamed from: e */
    String f5874e;

    /* renamed from: f */
    boolean f5875f;

    public C1438r(String str, boolean z, C1759p<Bitmap> pVar) {
        super(pVar);
        this.f5874e = str;
        this.f5875f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap mo9592a(Void... voidArr) {
        return new C1439s().mo9593a(this.f5874e, this.f5875f);
    }
}
