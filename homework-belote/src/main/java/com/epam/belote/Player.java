package com.epam.belote;

import com.epam.belote.bonus.Bonus;
import com.epam.belote.cards.Card;

public interface Player {
    Card playCard();

    Team getTeam();

    Bid bid();

    Bonus declareBonus();
}
