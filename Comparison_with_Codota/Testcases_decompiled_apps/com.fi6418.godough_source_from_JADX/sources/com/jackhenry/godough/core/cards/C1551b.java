package com.jackhenry.godough.core.cards;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.cards.b */
class C1551b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CardActionSubmitFragment f6100a;

    C1551b(CardActionSubmitFragment cardActionSubmitFragment) {
        this.f6100a = cardActionSubmitFragment;
    }

    public void onClick(View view) {
        this.f6100a.onCardAction(this.f6100a.f6089c, this.f6100a.f6088b);
    }
}
