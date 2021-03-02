package com.jackhenry.godough.core.wires;

import android.database.DataSetObserver;

/* renamed from: com.jackhenry.godough.core.wires.m */
class C1937m extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ WiresFragment f6915a;

    C1937m(WiresFragment wiresFragment) {
        this.f6915a = wiresFragment;
    }

    public void onChanged() {
        C1939o a = this.f6915a.f6893d;
        if (a == null) {
            a = (C1939o) this.f6915a.getActivity();
        }
        if (!this.f6915a.f6890a.mo6279g()) {
            a.onCountChanged(this.f6915a.f6890a.getCount());
        }
    }
}
