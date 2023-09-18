/*
Matthew Vang
CompSci 251-401
9/19/23
*/

package main;

public class Deck {
	private boolean[] deck = new boolean[52];

    public void initDeck() {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = true; // Ensuring the deck of cards has not been dealt out at index
        }
    }

    public boolean emptyDeck() {
        for (boolean card : deck) {
            if (card) {
                return false;
            }
        }
        return true;
    }

    public int dealCard() {
        int card = (int) (Math.random() * 52);

        do {
            card = (int) (Math.random() * 52);
        } while (!deck[card]);
        deck[card] = false;
        return card;
    }

    public static String cardToString(int card) {
        // Arrays to represent card values and suits
        String[] cardValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};
        String[] cardSuits = {"C", "S", "H", "D"};

        // Determine card value and suit
        String cardValue = cardValues[card % 13 / 4];
        String cardSuit = cardSuits[card / 13 % 4];
        return cardValue + cardSuit;
    }
}



