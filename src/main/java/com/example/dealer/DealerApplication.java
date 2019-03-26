package com.example.dealer;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class DealerApplication {

    private TextIO textIO;

    public DealerApplication(TextIO textIO) {
        this.textIO = textIO;
    }

    public static void main(String[] args) {

        System.out.println("This program lets you deal cards,");
        System.out.println();

        DealerApplication dealer = new DealerApplication(TextIoFactory.getTextIO());

        while (true){
            dealer.play();
            if(!dealer.playAgain()){
                System.out.println();
                System.out.println("The game is over.");
                System.out.print("Goodbye.");
                break;
            }
        }
	}

	private boolean playAgain(){
        return !textIO.newBooleanInputReader()
                .withPropertiesPrefix("exit")
                .withDefaultValue(true).read("Play again?");
    }

    /**
     * Lets the user play one game of HighLow, and returns the
     * user's score in that game.  The score is the number of
     * correct guesses that the user makes.
     */
    public void play() {
        Deck deck = new Deck();
        Card currentCard;
        Card nextCard;
        boolean dealCard;
        deck.shuffle();
        currentCard = deck.dealCard();

        System.out.println("The first card is the " + currentCard);

        while (deck.cardsLeft() != 0) {  // Loop ends when the user says N or there are no more cards

            if(!textIO.newBooleanInputReader()
                    .withPropertiesPrefix("exit")
                    .withDefaultValue(true).read("Deal the next card (Y/N)?")) {
                break;
            }

         /* Get the next card and show it to the user. */
            nextCard = deck.dealCard();
         /* The nextCard becomes the currentCard, since the currentCard has to be
            the card that the user sees, and the nextCard will be
            set to the next card in the deck  */
            currentCard = nextCard;
            System.out.println();
            System.out.println("The card is " + currentCard);
        } // end of while loop

    }  // end play()
}
