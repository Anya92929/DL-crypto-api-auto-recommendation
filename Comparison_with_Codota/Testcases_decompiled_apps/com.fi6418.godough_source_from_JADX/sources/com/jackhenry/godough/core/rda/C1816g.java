package com.jackhenry.godough.core.rda;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.rda.g */
class C1816g implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ DepositCheckFragment f6655a;

    C1816g(DepositCheckFragment depositCheckFragment) {
        this.f6655a = depositCheckFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6655a.f6632h.setHint(this.f6655a.getString(C1506am.amount_hint));
        return false;
    }
}
