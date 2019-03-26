package com.example.dealer;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class DealerApplication {

    private TextIO textIO;
    private Deck deck;
    private Card currentCard;
    private Card nextCard;
    private boolean dealCard;

    public DealerApplication(TextIO textIO) {
        this.textIO = textIO;
        this.deck = new Deck();
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
     * Lets the user deal cards one by one.
     */
    public void play() {
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

        System.out.println();
        System.out.println("No more cards.");

    }  // end play()

    public TextIO getTextIO() {
        return textIO;
    }

    public void setTextIO(TextIO textIO) {
        this.textIO = textIO;
    }

    public Deck getDeck() {
        return deck;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Card getNextCard() {
        return nextCard;
    }

    public boolean isDealCard() {
        return dealCard;
    }

    public void setDealCard(boolean dealCard) {
        this.dealCard = dealCard;
    }
}
