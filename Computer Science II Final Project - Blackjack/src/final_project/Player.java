package final_project;

import java.util.ArrayList;

/**
 * The abstract class Player
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program is the superclass of the subclasses HumanPlayer and Dealer. 
 * This allows for the HumanPlayer and the Dealer to have different logic for
 * deciding what to do when hitting and, in the case of the dealer, when to hit.
 * The player has an ArrayList of Card objects which is the player's hand
 * of cards. This class creates an empty hand when the player is created and sets
 * the current score to 0. Also, it has an abstract method for hitting for the HumanPlayer
 * and Dealer subclasses. Other classes can get the player's score and hand of cards.
 * This can also calculate the score of the current player.
 * 
 * For example, a humanPlayer can be created from Player. The humanPlayer has an empty hand
 * at first with a score of 0. Later, cards can be added and the score can be recalculated.
 *
 ****************************
 * Analysis
 ****************************
 *
 * Inputs: The hand of cards and the deck.
 * 
 * Outputs: The calculated score and the hand of cards
 * for each player.
 *
 ****************************
 * Pseudocode
 ****************************
 *
 * 1. Create and empty hand with an ArrayList and set
 * the score to 0
 * 2. Hit method used to return a card, add a card to the hand,
 * and, for the humanPlayer, return a card
 * 3. The hand can be returned
 * 4. The score can be returned
 * 5. Calculate the score based on the current hand
 *
 * @author Ryan Bebb and James Alexander
 */
public abstract class Player {

	ArrayList<Card> hand;
	private int score;
	
	/**
	 * Value of Blackjack
	 */
	private final static int BLACKJACK = 21;
	
	/**
	 * Creates a new Player object with an empty
	 * ArrayList of cards for the object's hand.
	 * 
	 * The score is also initially set to 0.
	 */
	public Player() {
		hand = new ArrayList<>();
		score = 0;
	}
	
	/**
	 * Allows each subclass of Player
	 * to call its own hit method
	 * 
	 * @param d Deck to draw from when hitting
	 * 
	 * @return Null for dealer and a specific card for
	 * humanPlayer
	 */
	abstract public Card Hit(Deck d);
	
	/**
	 * Gets the current hand
	 * 
	 * @return The hand which contains the
	 * player's cards
	 */
	public ArrayList<Card> GetHand() {
		return hand;
	}
	
	/**
	 * Gets the current score
	 * 
	 * @return The current score of the player
	 */
	public int GetScore() {
		return score;
	}
	
	/**
	 * Allows calcScore method to be called in
	 * other class (such as the GUI class for 
	 * displaying the player's current score).
	 * This also determines the values of the aces
	 * in the player's hand if the current score 
	 * exceeds Blackjack (21).
	 * 
	 * @param currentHand The ArrayList of Card objects
	 * in the player's hand
	 * 
	 * @return The score for the player calling
	 * the calcScore method
	 */
	int calcScore(ArrayList<Card> currentHand) {
		ArrayList<Card> aces = new ArrayList<>();
		
		if(currentHand.size() == 0)
		{
			score = 0;
			return score;
		}

		/*
		 * This loop adds the values of the non-ace cards and
		 * stores the aces in an ArrayList to be analyzed later
		 * since their value can change.
		 */
		
		int temp = 0;
		
		for(Card c: currentHand){
			
			if(c.getRank() == 1)
			{
				aces.add(c);
			}
			else
			{
				temp = temp + c.getValue();
			}
		}
		
		int lowValAces = 0;
		int aceScore = temp;

		/*
		 * This loop is used to choose what values a player's 
		 * aces take. It first calculates the greatest possible
		 * value the hand could have
		 */
		for (int highValAces = aces.size(); highValAces >= 0; highValAces--)
		{
			aceScore = temp + highValAces*11 + lowValAces*1; // This is where the score of 10 (now 11) for aces came from
			if(aceScore <= BLACKJACK)
			{
				temp = aceScore;
				break;
			}
			lowValAces++;
		}

		score = temp;
		return score;
		
	}
	
//	Used to test class
//	public static void main(String[] args){
//		Card first = new Card("clubs", 1, 1);
//		Card second = new Card("hearts", 10, 10);
//		ArrayList<Card> c = new ArrayList<Card>();
//		c.add(first);
//		c.add(second);
//		Player p = new Dealer();
//		
//		int i = p.calcScore(c);
//	}
}