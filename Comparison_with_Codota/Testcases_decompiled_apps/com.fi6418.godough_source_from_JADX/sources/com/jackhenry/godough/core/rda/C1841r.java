package com.jackhenry.godough.core.rda;

import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.model.DepositTransaction;

/* renamed from: com.jackhenry.godough.core.rda.r */
class C1841r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DepositReviewFragment f6703a;

    C1841r(DepositReviewFragment depositReviewFragment) {
        this.f6703a = depositReviewFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1876s) this.f6703a.getActivity()).onDepositClicked((DepositTransaction) this.f6703a.f6635a.getItem(i));
    }
}
