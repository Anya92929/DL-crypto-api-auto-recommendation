package com.jackhenry.godough.core.transfers;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.transfers.j */
class C1905j implements C1593j {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6828a;

    C1905j(TransfersFragment transfersFragment) {
        this.f6828a = transfersFragment;
    }

    public void run() {
        new Handler().post(new C1906k(this));
    }
}
