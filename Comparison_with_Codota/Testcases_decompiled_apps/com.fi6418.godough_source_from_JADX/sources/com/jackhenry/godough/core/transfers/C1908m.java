package com.jackhenry.godough.core.transfers;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.Account;

/* renamed from: com.jackhenry.godough.core.transfers.m */
class C1908m implements C1593j {

    /* renamed from: a */
    final /* synthetic */ Account f6831a;

    /* renamed from: b */
    final /* synthetic */ TransfersFragment f6832b;

    C1908m(TransfersFragment transfersFragment, Account account) {
        this.f6832b = transfersFragment;
        this.f6831a = account;
    }

    public void run() {
        this.f6832b.m6878a(this.f6831a);
    }
}
