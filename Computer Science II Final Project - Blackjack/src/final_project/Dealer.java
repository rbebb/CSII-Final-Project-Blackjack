package final_project;

/**
 * The subclass Dealer
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program is a subclass of Player. The Dealer can choose to hit if the score
 * is less than 17 or if the score is 17 and the hand contains and ace. If the dealer hits
 * the card is added to the dealer's hand and the score is calculated. This will return null
 * because the card for the dealer does not need to be returned.
 * 
 * For example, if the dealer decides to hit, then a card that could be added to his hand
 * is a 7 with a suit of "DIAMONDS", a rank of 7, and a value of 7. 7 will be added to the dealer's
 * total score
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
 * 2. Add the card to the dealer's hand
 * 3. Calculate the dealer's new score
 *
 * @author Ryan Bebb and James Alexander
 */

public class Dealer extends Player {
	private boolean containsAce = false;

	/**
	 * Allows the dealer to call its own hit
	 * method
	 */
	public Dealer() {
		
	}
	
	/**
	 * Overrides the abstract hit method in the Player class
	 * so that the dealer has its own logic for when to hit
	 * and when to stay
	 * 
	 * @param d Deck to draw from when hitting
	 * 
	 * @return Null because the dealer does
	 * not need to return a specific card
	 */
	@Override
	public Card Hit(Deck d) {
		
		while ((GetScore() < 17) || (GetScore() == 17 && this.containsAce))
		{
			Card c = Deck.dealNextCard();
			GetHand().add(c);
			calcScore(GetHand());
			
			for (int i = 0; i < GetHand().size(); i++)
			{
				if (GetHand().get(i).getRank() == 1);
				{
					this.containsAce = true;
				}
			}
			
//			Used for testing class
//			System.out.printf("Card Added: %s   Score: %d%n", c.toString(), this.GetScore());
		}
//		Does not return card because it is not needed for Dealer
		return null;
	}

}
