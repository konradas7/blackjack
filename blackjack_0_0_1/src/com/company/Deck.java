package com.company;

import java.util.ArrayList;
import java.util.List;

public class Deck {


    List<Card> cardDeck = new ArrayList<>();
    int z= 0;
    Deck() {
        for (int i=1; i < 14; i++) {

            for (int j=1; j < 5; j++) {

                Card tempCard= new Card(i, j);
                cardDeck.add(tempCard);
                z++;
            }
        }
    }

    Card drawCard(int i) {
        Card tempCard= cardDeck.get(i);
        cardDeck.remove(i);
        return tempCard;
    }

    int cardsRemaining() {
        return cardDeck.size();
    }
}
