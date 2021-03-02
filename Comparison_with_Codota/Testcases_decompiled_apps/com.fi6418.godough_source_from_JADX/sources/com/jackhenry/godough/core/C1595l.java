package com.jackhenry.godough.core;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.l */
class C1595l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractConfirmationFragment f6170a;

    C1595l(AbstractConfirmationFragment abstractConfirmationFragment) {
        this.f6170a = abstractConfirmationFragment;
    }

    public void onClick(View view) {
        ((GodoughTransactionActivity) this.f6170a.getActivity()).cancelButtonOnClickHandler();
    }
}
