/*----------------------------------------------------------------------------------------------------------------------
    LinkedList sınıfının addFirst ve pollFirst metotları:
    poll, pollFirst ve pollLast metotları liste boş ise null değerine geri dönerler. Bu durumda algoritmamızda eğer linked
    list içerisinde null değer tutulmadığı garanti altındaysa bu metotların geri dönüş değerinden listenin boş olup olmadığı
    anlaşılabilir. Ancak listede null da değer olarak tutuluyorsa ve o an çağrılmada o değer de verilecekse geri dönüş
    değeri listenin boş olup olmadığı hakkında bilgi vermez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.game.card.Card;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var deck = Card.getShuffledDeck();

        for (var card : deck)
            Console.writeLine(card);

        Console.writeLine("----------------------------------------------------");

        Card.shuffleDeck(deck, 100);

        for (var card : deck)
            Console.writeLine(card);
    }
}
