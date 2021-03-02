package com.jackhenry.godough.core.wires;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.jackhenry.godough.core.wires.f */
class C1930f implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ WireDetailsFragment f6905a;

    C1930f(WireDetailsFragment wireDetailsFragment) {
        this.f6905a = wireDetailsFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f6905a.f6889d.setHint("");
        return false;
    }
}
