package com.jackhenry.godough.core.wires;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.wires.g */
class C1931g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WireDetailsFragment f6906a;

    C1931g(WireDetailsFragment wireDetailsFragment) {
        this.f6906a = wireDetailsFragment;
    }

    public void onClick(View view) {
        this.f6906a.getActivity().finish();
    }
}
