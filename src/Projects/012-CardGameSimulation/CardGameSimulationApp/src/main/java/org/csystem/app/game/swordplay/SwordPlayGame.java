package org.csystem.app.game.swordplay;

import org.csystem.game.card.Card;
import org.csystem.util.scheduler.Scheduler;

import java.util.function.Consumer;

public class SwordPlayGame {
    private boolean m_playerWin;
    private int m_index = -1;
    private boolean m_finished;
    private final Card[] m_deck;
    private final Card m_selectedCard;

    private void schedulerCallback(Scheduler self, Consumer<Card> op)
    {
        ++m_index;
        op.accept(m_deck[m_index]);
        if (m_deck[m_index].equals(m_selectedCard)) {
            m_playerWin = m_index % 2 == 0;
            m_finished = true;
            self.cancel();
        }
    }

    public SwordPlayGame(Card [] deck, Card selectedCard)
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
        var scheduler = new Scheduler(500);

        scheduler.schedule(() -> schedulerCallback(scheduler, op));

        while (!m_finished) //Bu bekleme etkin bir bekleme değildir
            ;
    }
}
