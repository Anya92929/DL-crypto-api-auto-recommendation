package com.jackhenry.godough.core.wires;

import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Wire;

/* renamed from: com.jackhenry.godough.core.wires.q */
class C1941q implements C1939o {

    /* renamed from: a */
    final /* synthetic */ WiresTabbedFragmentActivity f6918a;

    C1941q(WiresTabbedFragmentActivity wiresTabbedFragmentActivity) {
        this.f6918a = wiresTabbedFragmentActivity;
    }

    public void onCountChanged(int i) {
        this.f6918a.f6897p.mo204a((CharSequence) this.f6918a.getString(C1506am.tab_approve) + " (" + i + ")");
    }

    public void onWireClicked(Wire wire) {
        this.f6918a.m6970a(wire);
    }
}
