package com.jackhenry.godough.core.wires;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.wires.h */
class C1932h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WireDetailsFragment f6907a;

    C1932h(WireDetailsFragment wireDetailsFragment) {
        this.f6907a = wireDetailsFragment;
    }

    public void onClick(View view) {
        this.f6907a.onPerformAction();
    }
}
