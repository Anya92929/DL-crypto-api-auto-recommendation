package com.jackhenry.godough.core.p2p;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.p2p.x */
class C1795x implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6601a;

    C1795x(P2PFragment p2PFragment) {
        this.f6601a = p2PFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6601a.f6551e.setHint(this.f6601a.getString(C1506am.amount_hint));
    }
}
