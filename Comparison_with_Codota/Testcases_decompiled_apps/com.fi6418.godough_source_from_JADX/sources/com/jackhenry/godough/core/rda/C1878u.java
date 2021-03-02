package com.jackhenry.godough.core.rda;

import android.graphics.Bitmap;
import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.Deposit;

/* renamed from: com.jackhenry.godough.core.rda.u */
public class C1878u extends C1758o<Void, Bitmap> {

    /* renamed from: e */
    String f6769e;

    /* renamed from: f */
    private Deposit.Side f6770f;

    public C1878u(String str, Deposit.Side side, C1759p<Bitmap> pVar) {
        super(pVar);
        this.f6769e = str;
        this.f6770f = side;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap mo9592a(Void... voidArr) {
        return new C1881x().mo11104a(this.f6769e, this.f6770f);
    }
}
