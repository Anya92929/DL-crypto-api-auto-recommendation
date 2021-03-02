package com.jackhenry.godough.core.ach;

import android.content.Context;
import com.jackhenry.godough.core.C1752m;
import com.jackhenry.godough.core.model.ACH;

/* renamed from: com.jackhenry.godough.core.ach.o */
public class C1484o extends C1752m<ACH> {

    /* renamed from: f */
    private String f5968f;

    public C1484o(String str, Context context) {
        super(context);
        this.f5968f = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public ACH mo9582j() {
        return new C1487r().mo9692a(this.f5968f);
    }
}
