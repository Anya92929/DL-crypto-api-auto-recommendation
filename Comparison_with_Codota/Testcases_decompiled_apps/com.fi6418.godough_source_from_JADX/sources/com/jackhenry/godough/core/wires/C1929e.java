package com.jackhenry.godough.core.wires;

import android.view.View;
import com.jackhenry.godough.core.widgets.JhaEditText;

/* renamed from: com.jackhenry.godough.core.wires.e */
class C1929e implements JhaEditText.OnBackKeyPressedListener {

    /* renamed from: a */
    final /* synthetic */ WireDetailsFragment f6904a;

    C1929e(WireDetailsFragment wireDetailsFragment) {
        this.f6904a = wireDetailsFragment;
    }

    public void onBackKeyPressed(View view) {
        this.f6904a.f6889d.setHint("");
    }
}
