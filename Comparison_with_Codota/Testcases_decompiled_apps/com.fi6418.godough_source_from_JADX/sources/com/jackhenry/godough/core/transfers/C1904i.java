package com.jackhenry.godough.core.transfers;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.transfers.i */
class C1904i implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6827a;

    C1904i(TransfersFragment transfersFragment) {
        this.f6827a = transfersFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6827a.f6811c.setHint(this.f6827a.getString(C1506am.amount_hint));
        return false;
    }
}
