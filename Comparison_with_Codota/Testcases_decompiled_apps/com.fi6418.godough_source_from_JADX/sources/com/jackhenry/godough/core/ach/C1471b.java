package com.jackhenry.godough.core.ach;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.ach.b */
class C1471b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ACHDetailFragment f5952a;

    C1471b(ACHDetailFragment aCHDetailFragment) {
        this.f5952a = aCHDetailFragment;
    }

    public void onClick(View view) {
        this.f5952a.getActivity().finish();
    }
}
