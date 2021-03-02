package com.jackhenry.godough.core.p2p;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.C1506am;

/* renamed from: com.jackhenry.godough.core.p2p.y */
class C1796y implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6602a;

    C1796y(P2PFragment p2PFragment) {
        this.f6602a = p2PFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6602a.f6551e.setHint(this.f6602a.getString(C1506am.amount_hint));
        return false;
    }
}
