package org.csystem.game.card;


import java.util.function.Consumer;

public class SwordPlayGame {
    private boolean m_playerWin;
    private final Deck m_deck;
    private final Card m_selectedCard;

    public SwordPlayGame(Deck deck, Card selectedCard)
    {
        m_deck = deck;
        m_selectedCard = selectedCard;
    }

    public boolean isPlayerWin()
    {
        return m_playerWin;
    }

    public void playGame(Consumer<Card> op)
    {
        for (int i = 0; i < m_deck.cardCount(); ++i) {
            var card = m_deck.getCard(i);
            op.accept(card);
            if (card.equals(m_selectedCard)) {
                m_playerWin = i % 2 == 0;
                break;
            }
            Util.sleep(300);
        }
    }
}
