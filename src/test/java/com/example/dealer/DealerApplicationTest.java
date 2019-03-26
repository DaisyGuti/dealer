package com.example.dealer;

import static org.junit.Assert.*;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import java.io.ByteArrayInputStream;

public class DealerApplicationTest {

    DealerApplication dealer;

    @org.junit.Before
    public void setUp() throws Exception {
        dealer = new DealerApplication(TextIoFactory.getTextIO());

    }

    @org.junit.Test
    public void testNoCardAfter52() throws Exception {
        Deck deck = new Deck();
        Card currentCard;
        Card nextCard;
        boolean dealCard;

        for (int i = 0; i < 53 ; i++) {
            //Shuffle first
            deck.shuffle();
            currentCard = deck.dealCard();

            while (deck.cardsLeft() != 0) {  // Loop ends when the user says N or there are no more cards
                /* Get the next card and show it to the user. */
                nextCard = deck.dealCard();
                 /* The nextCard becomes the currentCard, since the currentCard has to be
                    the card that the user sees, and the nextCard will be
                    set to the next card in the deck  */
                currentCard = nextCard;
            } // end of while loop

            if(i == 53){
                assertTrue(deck.cardsLeft() == 0);
            }
        }//end for loop
    }

}