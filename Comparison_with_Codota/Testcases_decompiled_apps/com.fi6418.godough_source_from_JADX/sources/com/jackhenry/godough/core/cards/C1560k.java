package com.jackhenry.godough.core.cards;

import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActionRequest;
import com.jackhenry.godough.core.model.CardActionStatus;
import com.jackhenry.godough.core.model.CardActions;
import com.jackhenry.godough.core.model.CardsList;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;

/* renamed from: com.jackhenry.godough.core.cards.k */
public class C1560k extends C1396a {
    /* renamed from: a */
    public CardActionStatus mo9771a(CardActions.Action action, Card card) {
        C1885a.m6860a();
        CardActionRequest cardActionRequest = new CardActionRequest();
        cardActionRequest.setCardNumber(card.getCardNumber());
        cardActionRequest.setCardNumberSuffix(card.getCardNumberSuffix());
        cardActionRequest.setRequestToken(mo9443o());
        switch (C1561l.f6112a[action.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                cardActionRequest.setCardAction(action.ordinal() + 1);
                return (CardActionStatus) mo9442n().mo9453a("/Cards", (C1401c) new C1400b(CardActionStatus.class), (String) new C1400b(CardActionRequest.class).mo9450a((Object) cardActionRequest));
            default:
                throw new C1389d("Invalid Card Action: " + action.name(), 4000);
        }
    }

    /* renamed from: a */
    public CardActions mo9772a(Card card) {
        C1885a.m6860a();
        CardActionRequest cardActionRequest = new CardActionRequest();
        cardActionRequest.setCardNumber(card.getCardNumber());
        cardActionRequest.setCardNumberSuffix(card.getCardNumberSuffix());
        cardActionRequest.setRequestToken(mo9443o());
        return (CardActions) mo9442n().mo9459b("/Cards", new C1400b(CardActions.class), (String) new C1400b(CardActionRequest.class).mo9450a((Object) cardActionRequest));
    }

    /* renamed from: b */
    public CardsList mo9773b() {
        C1885a.m6860a();
        return (CardsList) mo9442n().mo9452a("/Cards", (C1401c) new C1400b(CardsList.class));
    }
}
