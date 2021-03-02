package com.jackhenry.godough.core.p2p;

import android.view.View;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.p2p.f */
class C1777f implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ JhaEditText f6575a;

    /* renamed from: b */
    final /* synthetic */ P2PAddPersonFragment f6576b;

    C1777f(P2PAddPersonFragment p2PAddPersonFragment, JhaEditText jhaEditText) {
        this.f6576b = p2PAddPersonFragment;
        this.f6575a = jhaEditText;
    }

    public void onBackKeyPressed(View view) {
        this.f6575a.setHint("");
    }
}
