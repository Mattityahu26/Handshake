/*
Matthew Vang
CompSci 251-401
9/19/23
*/

package main;

class SmartDeck extends Deck 
{
	private int cardsDealt;

    @Override
    public void initDeck() {
        super.initDeck();
        cardsDealt = 0;
    }

    @Override
    public int dealCard() {
        int card = super.dealCard();
        cardsDealt++;
        return card;
    }

    public int getCardsDealt() {
        return cardsDealt;
    }
}
	
	

