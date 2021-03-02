package com.jackhenry.godough.core.billpay;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.billpay.i */
class C1527i implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6051a;

    C1527i(BillPayFragment billPayFragment) {
        this.f6051a = billPayFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6051a.f6037i.setHint(this.f6051a.getString(C1506am.lbl_memo_hint));
        return false;
    }
}
