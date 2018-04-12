package final_project;

/**
 * The subclass HumanPlayer
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program is a subclass of Player. The humanPlayer can choose to hit and this
 * will return the card that was drawn from the deck.
 * 
 * For example, if the humanPlayer decides to hit, then a card that could be returned is 
 * a King with the the suit "SPADES", the rank 11, and the value 10.
 *
 ****************************
 * Analysis
 ****************************
 *
 * Inputs: The deck to draw from.
 * 
 * Outputs: The card drawn from the deck when hitting.
 *
 ****************************
 * Pseudocode
 ****************************
 *
 * 1. Get the deck to draw from
 * 2. Add the card that was drawn to the humanPlayer's hand
 * 3. Calculate the humanPlayer's new score
 * 4. Return the card that was drawn from the deck
 * when the humanPlayer decided to hit
 *
 * @author Ryan Bebb and James Alexander
 */

public class HumanPlayer extends Player {

	/**
	 * Overrides the abstract hit method in the Player class
	 * so that the humanPlayer has its own logic for when to hit
	 * and when to stay
	 * 
	 * @param d Deck to draw from when hitting
	 * 
	 * @return The card that was drawn when humanPlayer
	 * decided to hit
	 */
	@Override
	public Card Hit(Deck d) {
		Card c = Deck.dealNextCard();
		GetHand().add(c);
		calcScore(GetHand());
		
		return c;
	}
}
