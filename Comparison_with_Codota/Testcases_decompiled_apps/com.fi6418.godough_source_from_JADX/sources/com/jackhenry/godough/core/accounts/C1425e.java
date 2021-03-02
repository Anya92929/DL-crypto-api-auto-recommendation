package com.jackhenry.godough.core.accounts;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.AccountTransaction;

/* renamed from: com.jackhenry.godough.core.accounts.e */
class C1425e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AccountTransactionsFragment f5853a;

    C1425e(AccountTransactionsFragment accountTransactionsFragment) {
        this.f5853a = accountTransactionsFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AccountTransaction accountTransaction = (AccountTransaction) this.f5853a.f5818c.getItem(i);
        if (accountTransaction.getImages() != null && accountTransaction.getImages().size() > 0) {
            Intent intent = new Intent(GoDoughApp.getApp(), CheckImageFragmentActivity.class);
            intent.putExtra("EXTRA_TRANSACTION", accountTransaction);
            this.f5853a.startActivityForResult(intent, 100);
        }
    }
}
