package com.jackhenry.godough.core.accounts;

import android.view.View;
import com.jackhenry.godough.core.model.Account;

/* renamed from: com.jackhenry.godough.core.accounts.c */
class C1423c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AccountTransactionsFragment f5851a;

    C1423c(AccountTransactionsFragment accountTransactionsFragment) {
        this.f5851a = accountTransactionsFragment;
    }

    public void onClick(View view) {
        ((AccountTransactionsFragmentActivity) this.f5851a.getActivity()).showBalanceDisclosure(Account.BalanceType.AVAILABLE);
    }
}
