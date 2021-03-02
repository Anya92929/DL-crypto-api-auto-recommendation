package com.jackhenry.godough.core.cards;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActions;

/* renamed from: com.jackhenry.godough.core.cards.c */
class C1552c implements C1593j {

    /* renamed from: a */
    final /* synthetic */ Card f6101a;

    /* renamed from: b */
    final /* synthetic */ CardActions.Action f6102b;

    /* renamed from: c */
    final /* synthetic */ CardActionSubmitFragment f6103c;

    C1552c(CardActionSubmitFragment cardActionSubmitFragment, Card card, CardActions.Action action) {
        this.f6103c = cardActionSubmitFragment;
        this.f6101a = card;
        this.f6102b = action;
    }

    public void run() {
        this.f6103c.onCardAction(this.f6101a, this.f6102b);
    }
}
