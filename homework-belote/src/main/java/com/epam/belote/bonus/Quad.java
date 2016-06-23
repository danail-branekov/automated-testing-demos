package com.epam.belote.bonus;

import com.epam.belote.cards.CardType;

public class Quad implements Bonus {
    private final CardType cardType;

    public Quad(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }
}
