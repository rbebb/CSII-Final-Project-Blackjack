package final_project;

/**
 * The class Card
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program creates card objects that will be used by other classes
 * to create a hand of cards
 * 
 * For example, if a King Card object is being created, then the Card object
 * takes the parameters (in order) "HEARTS", 11, 10 (the suit, then the rank, then the value).
 * This is also utilized in the Deck class for creating the cards in the deck.
 *
 ****************************
 * Analysis
 ****************************
 *
 * Inputs: The suit, rank, and value of a card
 * 
 * Outputs: The created card object, the string representation of the card if the toString method is used
 *
 ****************************
 * Pseudocode
 ****************************
 *
 * 1. Get the suit, rank, and value needed for a card
 * 2. Return the Card object
 * 3. Creates a string of the card if the toString method is used.
 *
 * @author Ryan Bebb and James Alexander
 */
public class Card {

	/**
	 * String for the suit cannot be change
	 * once the suit is set for a card
	 */
	private final String SUIT;
	
	/**
	 * Integer for the rank and value
	 * cannot be change once the rank
	 * and value are set for a card
	 */
	private final int rank, value;
	
	/**
	 * Constructs each card object with a suit,
	 * a rank, and a value.
	 * 
	 * @param s String for the name of the suit
	 * @param r The rank of the suit (1 though 13)
	 * @param v The value of the suit (1 through 11)
	 */
	Card(String s, int r, int v) {
		SUIT = s;
		rank = r;
		value = v;
	}
	
	/**
	 * Returns the suit for a card
	 * 
	 * @return The card's suit
	 */
	public String getSuit() {
		return SUIT;
	}
	
	/**
	 * Returns the rank for a card
	 * 
	 * @return The card's rank (1 through 13)
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Returns the value for a card
	 * 
	 * @return The card's value (1 through 11)
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the formatted string for a Card object
	 * 
	 * @return The string showing the card's 
	 * suit, rank, and value
	 */
	public String toString() {
		switch(this.getRank())
		{
			case 1:
				return String.format("%s - %s - %d", SUIT, "Ace", value);
			case 11:
				return String.format("%s - %s - %d", SUIT, "Jack", value);
			case 12:
				return String.format("%s - %s - %d", SUIT, "Queen", value);
			case 13:
				return String.format("%s - %s - %d", SUIT, "King", value);
			default:
				return String.format("%s - %d - %d ", SUIT, rank, value);
		}

	}

}
