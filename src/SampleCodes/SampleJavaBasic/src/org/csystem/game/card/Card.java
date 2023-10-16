package org.csystem.game.card;

public class Card {
   private CardValue m_value;
   private CardType m_type;

   private static void fillDeck(Card [] deck)
   {
      int idx = 0;

      for (CardType cardType : CardType.values())
         for (CardValue cardValue : CardValue.values())
            deck[idx++] = new Card(cardValue, cardType);
   }
	
   public static Card[] getShuffledDeck()
   {
      Card[] deck = new Card[52];

      fillDeck(deck);

      //TODO:
      return deck;
   }

   public Card(CardValue value, CardType type)
   {
      m_value = value;
      m_type = type;
   }

   public Card(String name)
   {
      //TODO:
   }

   public String getName()
   {
      return toString();
   }

   public void setName(String name)
   {
      //TODO:
   }

   public String toString()
   {
      //TODO:
      return String.format("%s-%s", m_type.toString(), m_value.toString());
   }
}
