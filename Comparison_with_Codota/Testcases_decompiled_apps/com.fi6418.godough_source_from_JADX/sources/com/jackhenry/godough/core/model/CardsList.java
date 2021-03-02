package com.jackhenry.godough.core.model;

import java.util.List;

public class CardsList implements GoDoughType {
    private List<Card> cards;

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> list) {
        this.cards = list;
    }
}
