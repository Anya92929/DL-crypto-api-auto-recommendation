package com.jackhenry.godough.core.accounts;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.accounts.h */
class C1428h implements C1593j {

    /* renamed from: a */
    final /* synthetic */ AccountsFragment f5862a;

    C1428h(AccountsFragment accountsFragment) {
        this.f5862a = accountsFragment;
    }

    public void run() {
        new Handler().post(new C1429i(this));
    }
}
