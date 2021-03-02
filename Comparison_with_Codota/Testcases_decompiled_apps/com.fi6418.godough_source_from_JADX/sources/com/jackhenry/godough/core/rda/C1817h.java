package com.jackhenry.godough.core.rda;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.rda.h */
class C1817h implements C1593j {

    /* renamed from: a */
    final /* synthetic */ DepositCheckFragment f6656a;

    C1817h(DepositCheckFragment depositCheckFragment) {
        this.f6656a = depositCheckFragment;
    }

    public void run() {
        new Handler().post(new C1818i(this));
    }
}
