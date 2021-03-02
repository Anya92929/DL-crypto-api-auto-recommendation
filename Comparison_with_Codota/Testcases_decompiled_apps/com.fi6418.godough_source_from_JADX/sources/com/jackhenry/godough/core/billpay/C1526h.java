package com.jackhenry.godough.core.billpay;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.billpay.h */
class C1526h implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6050a;

    C1526h(BillPayFragment billPayFragment) {
        this.f6050a = billPayFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6050a.f6037i.setHint(this.f6050a.getString(C1506am.lbl_memo_hint));
    }
}
