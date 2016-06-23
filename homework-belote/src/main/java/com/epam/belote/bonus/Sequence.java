package com.epam.belote.bonus;

import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Sequence implements Bonus {
    private final CardSuit suit;
    private final List<CardType> cards;

    public Sequence(CardSuit suit, List<CardType> cards) {
        this.suit = suit;
        this.cards = unmodifiableList(cards);
    }

    public CardSuit getSuit() {
        return suit;
    }

    public List<CardType> getCards() {
        return cards;
    }
}
