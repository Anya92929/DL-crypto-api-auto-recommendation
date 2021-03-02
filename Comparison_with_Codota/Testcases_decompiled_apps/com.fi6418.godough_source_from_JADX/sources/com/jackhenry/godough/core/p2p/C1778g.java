package com.jackhenry.godough.core.p2p;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.p2p.g */
class C1778g implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ JhaEditText f6577a;

    /* renamed from: b */
    final /* synthetic */ P2PAddPersonFragment f6578b;

    C1778g(P2PAddPersonFragment p2PAddPersonFragment, JhaEditText jhaEditText) {
        this.f6578b = p2PAddPersonFragment;
        this.f6577a = jhaEditText;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        this.f6577a.setHint("");
        return false;
    }
}
