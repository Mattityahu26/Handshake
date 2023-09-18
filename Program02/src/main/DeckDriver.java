/*
Matthew Vang
CompSci 251-401
9/19/23
*/

package main;

public class DeckDriver {
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		boolean[] myDeck = new boolean[52];
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		int myCard;
		
		initDeck(myDeck);
		System.out.println("\nHere is a shuffled deck ...\n");
			while (!emptyDeck(myDeck))
		{
				myCard = dealCard(myDeck);
				++cardsThisRow;
				if (cardsThisRow <= cardsPerRow)
				{
					printCard(myCard);
					System.out.print(" ");
				}
				else
				{
					System.out.println("");
					cardsThisRow = 1;
					printCard(myCard);
					System.out.print(" ");
				}
		}
			System.out.println('\n');
			
	        SmartDeck smartDeck = new SmartDeck();
	        smartDeck.initDeck();

	        System.out.println("\nHere is a shuffled deck with the SmartDeck Class\n");
	        while (!smartDeck.emptyDeck()) {
	            myCard = smartDeck.dealCard();
	            ++cardsThisRow;

	            if (cardsThisRow <= cardsPerRow) {
	                System.out.printf("%-5s", Deck.cardToString(myCard));
	            } else {
	                System.out.println();
	                cardsThisRow = 1;
	                System.out.printf("%-5s", Deck.cardToString(myCard));
	            }
	        }

	        System.out.println('\n');
	        System.out.println("Total cards dealt from SmartDeck: " + smartDeck.getCardsDealt());

	}

	public static void initDeck(boolean[] deck) 
	{
		for (int i=0; i<deck.length;i++) 
		{
			deck[i]=true;	// Ensuring the deck of card has been dealt out at index
		}
	}
	
	public static boolean emptyDeck(boolean[] deck) 
	{
		for (int i=0; i<deck.length-1; i++) 
		{
			if (deck[i]==true) 
			{
				return false;
			}
		}
		return true;
	}
	
	public static int dealCard(boolean[] deck) 
	{
		int randomNum;
		randomNum = (int)(Math.random()*52);

		while (deck[randomNum] == false ) 
		{
			randomNum = (int)(Math.random()*52);
		}
		
		deck[randomNum] = false;
		return randomNum;
	}
	public static void printCard(int card) 
	{
		// Arrays to represent card values and suits
		String[] cardValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] cardSuits = {"S", "C", "H", "D"};
		
		// Determine card value
		String cardValue;
		String cardSuit;
		
		if (card < 39) // Numerical Cards: A through 10
		{
			cardValue = cardValues[(card % 13)];
			cardSuit = cardSuits[(card / 13) % 4];
		}
		else // Face Cards: Jack, Queen, King
		{
			cardValue = cardValues[(card - 39) / 4]; // Adjust index for face cards
			cardSuit = cardSuits[(card - 39) % 4];
		}
		
		System.out.print(cardValue + cardSuit);
	}

}
