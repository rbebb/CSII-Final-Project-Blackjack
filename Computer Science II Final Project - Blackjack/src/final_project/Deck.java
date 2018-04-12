package final_project;

import java.util.Arrays;
import java.util.Collections;

/**
 * The class Deck
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program creates a new deck of 52 cards using an array of Card objects and shuffles them. This is also
 * used to deal cards when a player chooses to hit. When a card is dealt, the next card in the deck is prepared
 * to be dealt next. The number of cards dealt is increased by 1. By having a count of the number of cards drawn
 * from the deck, the number of cards dealt will not exceed 52. A toString method is used to test the number of 
 * cards being drawn from the deck, that duplicates are not being drawn, and the shuffle method.
 * 
 * For example, if a new deck is created, all of the cards are added to the deck and then randomly shuffled. When
 * a card is drawn, the number of cards drawn increases by 1, and the next card is prepared to be drawn.
 *
 ****************************
 * Analysis
 ****************************
 *
 * Inputs: No inputs
 * 
 * Outputs: The shuffled deck of cards, and the string of each card if the toString method used
 *
 ****************************
 * Pseudocode
 ****************************
 *
 * 1. A deck is created with all 52 cards
 * 2. The deck of cards is shuffled
 * 3. A card is dealt if a user hits
 * 4. The number of cards drawn increases by 1
 * 5. The next card is prepared to be drawn
 * 6. Prints out each card if toString method is used.
 *
 * @author Ryan Bebb and James Alexander
 */

public class Deck {
	private static Card[] deck;
	private static int cardsDrawn;
	private static Card nextCard;
	
	/**
	 * Constructs the deck when Game is created.
	 * The deck contains all 52 cards found in a 
	 * regular deck of cards. The number of cards
	 * drawn is set to 0. Then the deck is shuffled.
	 */
	public Deck(){
		deck = new Card[52];
		makeDeck();
		cardsDrawn = 0;
		shuffle();
	}
	
	private static void shuffle(){
		Collections.shuffle(Arrays.asList(deck));
	}
	
	/**
	 * Deals the next card in the deck. The
	 * next card to be drawn is set and the number
	 * of cards drawn is increased by 1. This prevents
	 * the deck from being overdrawn.
	 * 
	 * @return The next card in the deck
	 */
	public static Card dealNextCard(){
		if(cardsDrawn == 52){
			System.out.println("The whole deck has been drawn.");
			System.exit(0);
		}
		
		nextCard = deck[cardsDrawn];
		cardsDrawn++;
		return nextCard;
	}

	private static void makeDeck(){
		deck[0] = new Card("clubs", 1, 1);
		deck[1] = new Card("clubs", 2, 2);
		deck[2] = new Card("clubs", 3, 3);
		deck[3] = new Card("clubs", 4, 4);
		deck[4] = new Card("clubs", 5, 5);
		deck[5] = new Card("clubs", 6, 6);
		deck[6] = new Card("clubs", 7, 7);
		deck[7] = new Card("clubs", 8, 8);
		deck[8] = new Card("clubs", 9, 9);
		deck[9] = new Card("clubs", 10, 10);
		deck[10] = new Card("clubs", 11, 10);
		deck[11] = new Card("clubs", 12, 10);
		deck[12] = new Card("clubs", 13, 10);
		
		deck[13] = new Card("spades", 1, 1);
		deck[14] = new Card("spades", 2, 2);
		deck[15] = new Card("spades", 3, 3);
		deck[16] = new Card("spades", 4, 4);
		deck[17] = new Card("spades", 5, 5);
		deck[18] = new Card("spades", 6, 6);
		deck[19] = new Card("spades", 7, 7);
		deck[20] = new Card("spades", 8, 8);
		deck[21] = new Card("spades", 9, 9);
		deck[22] = new Card("spades", 10, 10);
		deck[23] = new Card("spades", 11, 10);
		deck[24] = new Card("spades", 12, 10);
		deck[25] = new Card("spades", 13, 10);
		
		deck[26] = new Card("hearts", 1, 1);
		deck[27] = new Card("hearts", 2, 2);
		deck[28] = new Card("hearts", 3, 3);
		deck[29] = new Card("hearts", 4, 4);
		deck[30] = new Card("hearts", 5, 5);
		deck[31] = new Card("hearts", 6, 6);
		deck[32] = new Card("hearts", 7, 7);
		deck[33] = new Card("hearts", 8, 8);
		deck[34] = new Card("hearts", 9, 9);
		deck[35] = new Card("hearts", 10, 10);
		deck[36] = new Card("hearts", 11, 10);
		deck[37] = new Card("hearts", 12, 10);
		deck[38] = new Card("hearts", 13, 10);
		
		deck[39] = new Card("diamonds", 1, 1);
		deck[40] = new Card("diamonds", 2, 2);
		deck[41] = new Card("diamonds", 3, 3);
		deck[42] = new Card("diamonds", 4, 4);
		deck[43] = new Card("diamonds", 5, 5);
		deck[44] = new Card("diamonds", 6, 6);
		deck[45] = new Card("diamonds", 7, 7);
		deck[46] = new Card("diamonds", 8, 8);
		deck[47] = new Card("diamonds", 9, 9);
		deck[48] = new Card("diamonds", 10, 10);
		deck[49] = new Card("diamonds", 11, 10);
		deck[50] = new Card("diamonds", 12, 10);
		deck[51] = new Card("diamonds", 13, 10);
	}
	
	/**
	 * Used to test drawing from the deck. This allows
	 * the programmer to ensure that duplicates
	 * are not being drawn, that the entire deck
	 * can be drawn, and the shuffle method.
	 * 
	 * @return Each card in the deck that was drawn
	 * is returned as a string
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Card i: deck)
		{
//			Appends the string using the Card object's toString method
			sb.append(i.toString());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

}
