package com.jackhenry.godough.core.ach;

import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.model.ACH;

/* renamed from: com.jackhenry.godough.core.ach.p */
class C1485p implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ACHFragment f5969a;

    C1485p(ACHFragment aCHFragment) {
        this.f5969a = aCHFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((C1486q) this.f5969a.getActivity()).onACHClicked((ACH) this.f5969a.f5947b.getItem(i));
    }
}
