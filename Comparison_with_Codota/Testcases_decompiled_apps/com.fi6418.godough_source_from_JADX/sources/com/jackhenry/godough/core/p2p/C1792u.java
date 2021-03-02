package com.jackhenry.godough.core.p2p;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.p2p.u */
class C1792u implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6597a;

    C1792u(P2PFragment p2PFragment) {
        this.f6597a = p2PFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6597a.f6554h.setHint(this.f6597a.getString(C1506am.lbl_memo_hint));
    }
}
