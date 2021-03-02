package com.jackhenry.godough.core.rda.registration;

import android.content.Context;
import com.jackhenry.godough.core.C1752m;
import com.jackhenry.godough.core.model.RDATermsAndConditions;
import com.jackhenry.godough.core.rda.C1881x;

/* renamed from: com.jackhenry.godough.core.rda.registration.ad */
public class C1846ad extends C1752m<RDATermsAndConditions> {

    /* renamed from: f */
    boolean f6733f = false;

    public C1846ad(Context context, boolean z) {
        super(context);
        this.f6733f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public RDATermsAndConditions mo9582j() {
        return new C1881x().mo11108b(this.f6733f);
    }
}
