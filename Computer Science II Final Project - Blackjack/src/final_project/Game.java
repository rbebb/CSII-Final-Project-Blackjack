package final_project;

/**
 * The class Game
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program creates a new game (or round) for Blackjack when the game is started. A deck,
 * a dealer, a human player, are created. The first two cards for both the dealer and human 
 * player are set and then added to the respective player's hand. This class is also used 
 * to determine who wins the game.
 * 
 * For example, if a new game (or round) is created, then a new deck is created, as well as a dealer
 * and a humanPlayer. Then each player has two cards added to their respective hands of cards. Let's say that
 * the dealer has a King and a Queen, and the humanPlayer has a 2 and a 10. The initial score is calculated
 * for the dealer so that the proper score of 20 displayed since the dealer does not need to hit (dealer cannot
 * hit above 17, unless it is 17 with an ace in the dealer's hand. Then it is determined that the dealer won the game.
 *
 ****************************
 * Analysis
 ****************************
 *
 * Inputs: No inputs
 * 
 * Outputs: The deck, the dealer, the humanPlayer, both of their hands of cards, the calculated score
 * for the dealer, and who won the game
 *
 ****************************
 * Pseudocode
 ****************************
 *
 * 1. A new deck, dealer, and human player are created
 * 2. Two cards are dealt to each player
 * 3. The two cards are then added to each player's hand
 * 4. The score of the first two cards in the dealer's hand
 * is calculated
 * 5. The winner is determined
 *
 * @author Ryan Bebb and James Alexander
 */

public class Game {
	static Deck newDeck;
	static Dealer dealer;
	static HumanPlayer humanPlayer;
	static Card humanFirst;
	static Card dealerFirst;
	static Card humanSecond;
	static Card dealerSecond;
	
	/**
	 * Value of Blackjack
	 */
	private final static int BLACKJACK = 21;
	
	/**
	 * Creates a new game. Creates a new deck,
	 * dealer, and humanPlayer. The first two
	 * cards are dealt to the humanPlayer and 
	 * the dealer in the correct order (player,
	 * then dealer, then player, then dealer).
	 * Then these cards are added to each player's
	 * respective hand. The initial score is 
	 * calculated for the dealer's score to be
	 * displayed properly.
	 */
	public Game() {
		newDeck = new Deck();
		
		dealer = new Dealer();
		humanPlayer = new HumanPlayer();
		
//		Deals the first two cards to each player in the correct order
		humanFirst = Deck.dealNextCard();
		dealerFirst = Deck.dealNextCard();
		humanSecond = Deck.dealNextCard();
		dealerSecond = Deck.dealNextCard();
		
		humanPlayer.GetHand().add(humanFirst);
		dealer.GetHand().add(dealerFirst);
		humanPlayer.GetHand().add(humanSecond);
		dealer.GetHand().add(dealerSecond);
		
//		Calculates dealer's score for the hand before deciding to hit or stay
		Game.dealer.calcScore(Game.dealer.GetHand());
	}
	
	/**
	 * Determines if the dealer won the game
	 * 
	 * @return Whether or not the dealer won
	 */
	public static boolean dealerWin() {
		int dealerScore = dealer.GetScore();
		int humanScore = humanPlayer.GetScore();
		
		if (dealerScore == BLACKJACK	||
			humanScore > BLACKJACK		||
			(dealerScore < BLACKJACK && dealerScore > humanScore)	||
			dealerScore > BLACKJACK && humanScore > BLACKJACK)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if the human won the game
	 * 
	 * @return Whether or not the humanPlayer won
	 */
	public static boolean humanWin() {
		int dealerScore = dealer.GetScore();
		int humanScore = humanPlayer.GetScore();
		
		if (humanScore == BLACKJACK	||
			(dealerScore > BLACKJACK && humanScore < BLACKJACK)		
			|| (humanScore > dealerScore && humanScore < BLACKJACK)
			)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if there was a draw
	 * 
	 * @return Whether or not there was a draw
	 */
	public static boolean draw() {
		int dealerScore = dealer.GetScore();
		int humanScore = humanPlayer.GetScore();
		
		if (humanScore == dealerScore)
		{
			return true;
		}
		return false;
	}

}
