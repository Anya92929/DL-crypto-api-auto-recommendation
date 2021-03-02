package com.jackhenry.godough.core.rda.registration;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.rda.registration.d */
class C1853d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDAMessageFragment f6739a;

    C1853d(RDAMessageFragment rDAMessageFragment) {
        this.f6739a = rDAMessageFragment;
    }

    public void onClick(View view) {
        this.f6739a.getActivity().finish();
    }
}
