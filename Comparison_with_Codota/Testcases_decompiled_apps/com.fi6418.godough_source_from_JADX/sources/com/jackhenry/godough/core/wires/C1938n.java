package com.jackhenry.godough.core.wires;

import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.model.Wire;

/* renamed from: com.jackhenry.godough.core.wires.n */
class C1938n implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ WiresFragment f6916a;

    C1938n(WiresFragment wiresFragment) {
        this.f6916a = wiresFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Wire wire = (Wire) this.f6916a.f6890a.getItem(i);
        C1939o a = this.f6916a.f6893d;
        if (a == null) {
            a = (C1939o) this.f6916a.getActivity();
        }
        a.onWireClicked(wire);
    }
}
