package com.jackhenry.godough.core.cards;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.Card;
import com.jackhenry.godough.core.model.CardActionStatus;
import com.jackhenry.godough.core.model.CardActions;

/* renamed from: com.jackhenry.godough.core.cards.m */
public class C1562m extends C1757n<CardActionStatus> {

    /* renamed from: e */
    private CardActions.Action f6113e;

    /* renamed from: f */
    private Card f6114f;

    public C1562m(CardActions.Action action, Card card, C1759p<CardActionStatus> pVar) {
        super(null, pVar);
        this.f6113e = action;
        this.f6114f = card;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CardActionStatus mo9592a(Void... voidArr) {
        return new C1560k().mo9771a(this.f6113e, this.f6114f);
    }
}
