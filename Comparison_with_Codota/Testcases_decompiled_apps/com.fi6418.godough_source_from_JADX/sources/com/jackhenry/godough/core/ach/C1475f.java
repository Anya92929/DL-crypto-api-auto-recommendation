package com.jackhenry.godough.core.ach;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.ach.f */
class C1475f implements C1593j {

    /* renamed from: a */
    final /* synthetic */ ACHDetailFragment f5956a;

    C1475f(ACHDetailFragment aCHDetailFragment) {
        this.f5956a = aCHDetailFragment;
    }

    public void run() {
        new Handler().post(new C1476g(this));
    }
}
