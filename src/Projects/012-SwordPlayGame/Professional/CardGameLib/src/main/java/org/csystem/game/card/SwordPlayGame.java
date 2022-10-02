/*----------------------------------------------------------------------
	FILE        : SwordPlayGame.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 02.10.2022

	SwordPlayGame that represents a sword play game

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.game.card;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SwordPlayGame {
    private static final long DEFAULT_WAIT_DURATION = 300;
    private boolean m_playerWin;
    private final Deck m_deck;
    private final Card m_selectedCard;

    private final long m_waitDuration;

    public SwordPlayGame(Deck deck, Card selectedCard)
    {
        this(deck, selectedCard, DEFAULT_WAIT_DURATION);
    }

    public SwordPlayGame(Deck deck, Card selectedCard, long waitDuration)
    {
        m_deck = deck;
        m_selectedCard = selectedCard;
        m_waitDuration = waitDuration;
    }

    public boolean isPlayerWin()
    {
        return m_playerWin;
    }

    public void playGame(BiConsumer<Card, Boolean> biConsumer)
    {
        for (var i = 0; i < m_deck.cardCount(); ++i) {
            var card = m_deck.getCard(i);
            biConsumer.accept(card, i % 2 == 0);
            if (card.equals(m_selectedCard)) {
                m_playerWin = i % 2 == 0;
                break;
            }
            Util.sleep(m_waitDuration);
        }
    }

    public void playGame(BiConsumer<Card, Boolean> biConsumer, Consumer<Boolean> resultConsumer)
    {
        for (var i = 0; i < m_deck.cardCount(); ++i) {
            var card = m_deck.getCard(i);
            biConsumer.accept(card, i % 2 == 0);
            if (card.equals(m_selectedCard)) {
                m_playerWin = i % 2 == 0;
                resultConsumer.accept(m_playerWin);
                break;
            }
            Util.sleep(m_waitDuration);
        }
    }
}
