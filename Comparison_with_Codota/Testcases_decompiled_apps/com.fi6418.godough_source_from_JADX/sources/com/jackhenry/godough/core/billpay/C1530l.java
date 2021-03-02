package com.jackhenry.godough.core.billpay;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.billpay.l */
class C1530l implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6055a;

    C1530l(BillPayFragment billPayFragment) {
        this.f6055a = billPayFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6055a.f6031c.setHint(this.f6055a.getString(C1506am.amount_hint));
        return false;
    }
}
