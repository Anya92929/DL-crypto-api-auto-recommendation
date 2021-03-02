package com.jackhenry.godough.core.p2p;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.p2p.v */
class C1793v implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6598a;

    C1793v(P2PFragment p2PFragment) {
        this.f6598a = p2PFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6598a.f6554h.setHint(this.f6598a.getString(C1506am.lbl_memo_hint));
        return false;
    }
}
