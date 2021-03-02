package com.jackhenry.godough.core.billpay;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.billpay.k */
class C1529k implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6054a;

    C1529k(BillPayFragment billPayFragment) {
        this.f6054a = billPayFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6054a.f6031c.setHint(this.f6054a.getString(C1506am.amount_hint));
    }
}
