package com.epam.belote.bonus;

import com.epam.belote.cards.CardType;

/**
 * A Quad bonus is declared whenever the player has 4 cards of the same type, e.g. four Kings
 */
public class Quad implements Bonus {
    private final CardType cardType;

    public Quad(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getBonus() {
        // returns 200 when the player has 4 Jacks
        // returns 150 when the player has 4 nines
        // returns 100 when the player has 4 tens, queens, kings or aces
        throw new UnsupportedOperationException("TODO: Implement");
    }
}
