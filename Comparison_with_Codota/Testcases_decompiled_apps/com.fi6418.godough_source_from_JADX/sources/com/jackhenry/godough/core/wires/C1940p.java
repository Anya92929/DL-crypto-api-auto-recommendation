package com.jackhenry.godough.core.wires;

import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Wire;

/* renamed from: com.jackhenry.godough.core.wires.p */
class C1940p implements C1939o {

    /* renamed from: a */
    final /* synthetic */ WiresTabbedFragmentActivity f6917a;

    C1940p(WiresTabbedFragmentActivity wiresTabbedFragmentActivity) {
        this.f6917a = wiresTabbedFragmentActivity;
    }

    public void onCountChanged(int i) {
        this.f6917a.f6896o.mo204a((CharSequence) this.f6917a.getString(C1506am.tab_ready) + " (" + i + ")");
    }

    public void onWireClicked(Wire wire) {
        this.f6917a.m6970a(wire);
    }
}
