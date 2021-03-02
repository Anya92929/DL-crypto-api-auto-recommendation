package com.jackhenry.godough.core;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.k */
class C1594k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractConfirmationFragment f6169a;

    C1594k(AbstractConfirmationFragment abstractConfirmationFragment) {
        this.f6169a = abstractConfirmationFragment;
    }

    public void onClick(View view) {
        ((GodoughTransactionActivity) this.f6169a.getActivity()).actionButtonClickHandler();
    }
}
