package com.jackhenry.godough.core.cards;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.cards.a */
class C1550a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CardActionSubmitFragment f6099a;

    C1550a(CardActionSubmitFragment cardActionSubmitFragment) {
        this.f6099a = cardActionSubmitFragment;
    }

    public void onClick(View view) {
        this.f6099a.getActivity().finish();
    }
}
