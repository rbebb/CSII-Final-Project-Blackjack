package final_project;

import images.Images;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * The class GUI
 * COMP1050-05, Spring 2017
 * Due: April 11th, 2017
 * 
 ****************************
 * Description 
 ****************************
 *
 * This program displays the GUI for the game Blackjack. First the GUI shows a start screen to the user
 * with a start button. Once the start button is clicked, the GUI shows game. It shows one card face up and
 * one card face down for the dealer. Two cards are shown face up to the player along with the current score.
 * The player can choose whether to hit or stay. When the player clicks hit, a new card is displayed in the player's
 * hand, and the player's score is updated. If the player's score exceeds 21, the player must stay.
 * Once the stay button is clicked, all of the dealer's card as well as the dealer's score is shown. Also,
 * the player has the option to exit the game at any time.
 * 
 * For example, if the player starts the game with two cards that have a score of 15 and decides to hit, 
 * it'll show the next card (for example, a 6). Now the player's hand shows the three cards along with
 * the updated score of 21. Now let's say that the player has 21, he will decide stay. It'll now show the dealer's
 * cards (for example, 18 which means the dealer cannot hit since the dealer's score exceeds 17 and does
 * not contain an ace). Therefore, the GUI will show that the player won.
 *
 ****************************
 * Analysis
 ****************************
 *
 * Inputs: Whether the human player (user) clicks start or exit, and (if the user clicked the 
 * start button) whether the player clicks hit, stay, or exit
 * 
 * Outputs: The cards drawn as well as the score for the user and the dealer displayed in the GUI window
 * (the dealer's score is shown after the user chooses to stay). Also, the winner is shown in the GUI window. 
 *
 ****************************
 * Pseudocode
 ****************************
 *
 * 1. Get the button clicked and the associated action.
 * 2. Show the drawn cards, the score, and the winner in the GUI window
 *
 * @author Ryan Bebb and James Alexander
 */

public class GUI extends Application {

	/**
	 * The initial x value for where
	 * to set a card for humanPlayer
	 * in a specified pane
	 */
	private static int humanCardX = 300;
	
	/**
	 * The initial x value for where
	 * to set a card for dealer
	 * in a specified pane
	 */
	private static int dealerCardX = 300;
	
	public static void main(String[] args) {
		launch(args);

	}
	
	/**
	 * start method takes the primaryStage parameter
	 * to start the GUI for Blackjack
	 */
	public void start(Stage primaryStage) throws Exception {
		
//		Program Title
		primaryStage.setTitle("Final Project: Blackjack");
		
		Pane startPane = new Pane();
//		Size for program window (startPane and gamePane)
		int paneWidth = 1000;
		int paneHeight = 700;
		
//		Gets path to the background image and then sets it as the background
		String backgroundPath = Images.class.getResource("wallpaper-textur-background-patterns-backgrounds-wallpapers.jpg").toExternalForm();
		startPane.setStyle("-fx-background-image: url('" + backgroundPath + "'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch;");
		
		
		ToGUI wLogo = new ToGUI();
		String wLogoPath = Images.class.getResource("W-logo-on-transparent.png").toExternalForm();
//		Sends path to image, width of image, height of image, if the aspect ratio is preserved, x and y placement, and the
//		pane to add the image to
		wLogo.addImage(wLogoPath, 300, 300, true, 100, 30, startPane);
		
		ToGUI line = new ToGUI();
		String linePath = Images.class.getResource("068276-abstract-red-and-gold-paint-splatter-icon-alphanumeric-vertical-line.png").toExternalForm();
		line.addImage(linePath, 200, 200, true, 350, 15, startPane);
		
		ToGUI cardLogo = new ToGUI();
		String cardLogoPath = Images.class.getResource("BlackjackIcon.png").toExternalForm();
		cardLogo.addImage(cardLogoPath, 170, 170, true, 415, 300, startPane);
		
		ToGUI blackjackLogo = new ToGUI();
		String blackjackLogoPath = Images.class.getResource("Las-Vegas-Blackjack-Logo.png").toExternalForm();
		blackjackLogo.addImage(blackjackLogoPath, 425, 425, true, 500, 30, startPane);
		
		
		ToGUI startBtn = new ToGUI();
		String startBtnLabel = "Start Game!";
//		Sends the label of the button, width of button, height of button, x and y placement, and the
//		pane to add the button to
		startBtn.addButton(startBtnLabel, 300, 150, 360, 480, startPane);
		
//		Hidden Easter Egg :P
		ToGUI secretBtn = new ToGUI();
		secretBtn.addButton("", 63, 63, 161, 46, startPane);
		(secretBtn.btn).setStyle("-fx-background-color: transparent;");
		(secretBtn.btn).getTransforms().add(new Rotate(45, 0, 0));
		
		
		Scene startScene = new Scene(startPane, paneWidth, paneHeight);
		primaryStage.setScene(startScene);
		primaryStage.setResizable(false);
		primaryStage.show();

		
//		Creates gamePane to play
		Pane gamePane = new Pane();
		gamePane.setStyle("-fx-background-image: url('" + backgroundPath + "'); "
				+ "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch;");
		
		
		ToGUI exitBtn = new ToGUI();
		String exitBtnLabel = "Exit";
		exitBtn.addButton(exitBtnLabel, 140, 55, 20, 20, gamePane);
//		Sets the color of the text
		(exitBtn.btn).setTextFill(Color.RED);
		
		ToGUI hitBtn = new ToGUI();
		String hitButtonLabel = "Hit";
		hitBtn.addButton(hitButtonLabel, 125, 60, 325, 600, gamePane);
		
		ToGUI stayBtn = new ToGUI();
		String stayButtonLabel = "Stay";
		stayBtn.addButton(stayButtonLabel, 125, 60, 575, 600, gamePane);
		
		
		// Store Verdana as a string in order to reuse and save storage
		String verdana = "Verdana";
		
//		Sends the x and y placement, label of the text, the font, the size of the text, the color
//		of the text, and the pane to add the text to
		ToGUI textDealer = new ToGUI();
		textDealer.addText(415, 75, "DEALER", verdana, 45, Color.YELLOW, gamePane);
		
		ToGUI textPlayer = new ToGUI();
		textPlayer.addText(415, 415, "YOU", verdana, 45, Color.YELLOW, gamePane);	
		
		Scene gameScene = new Scene(gamePane, paneWidth, paneHeight);
		
		ToGUI textPlayerScore = new ToGUI();
		textPlayerScore.addText(510, 415, "", verdana, 45, Color.YELLOW, gamePane);
//		Enters game and starts the game
		
//		Each element for the first two cards in the GUI are created outside setOnAction to access them elsewhere in the GUI class
		ToGUI humanFirstCard = new ToGUI();
		ToGUI dealerFirstCard = new ToGUI();
		ToGUI humanSecondCard = new ToGUI();
		ToGUI dealerSecondCard = new ToGUI();
		
//		Action when user clicks start button
		(startBtn.btn).setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent e)
			{
				
				new Game();
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				String humanFirstCardName = String.format("%d_of_%s.png", Game.humanFirst.getRank(), Game.humanFirst.getSuit());
				String humanFirstCardPath = Images.class.getResource(humanFirstCardName).toExternalForm();

				humanFirstCard.addImage(humanFirstCardPath, 125, 125, true, humanCardX, 440, gamePane);
				humanCardX = humanCardX+30;

				String firstScore = String.format(": %d", Game.humanPlayer.calcScore(Game.humanPlayer.GetHand()));
				textPlayerScore.text.setText(firstScore);

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////

				String dealerFirstCardName = String.format("%d_of_%s.png", Game.dealerFirst.getRank(), Game.dealerFirst.getSuit());
				String dealerFirstCardPath = Images.class.getResource(dealerFirstCardName).toExternalForm();

				dealerFirstCard.addImage(dealerFirstCardPath, 125, 125, true, dealerCardX, 100, gamePane);
				dealerCardX = dealerCardX+30;

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////

				String humanSecondCardName = String.format("%d_of_%s.png", Game.humanSecond.getRank(), Game.humanSecond.getSuit());
				String humanSecondCardPath = Images.class.getResource(humanSecondCardName).toExternalForm();

				humanSecondCard.addImage(humanSecondCardPath, 125, 125, true, humanCardX, 440, gamePane);
				humanCardX = humanCardX+30;

				String secondScore = String.format(": %d", Game.humanPlayer.calcScore(Game.humanPlayer.GetHand()));
				textPlayerScore.text.setText(secondScore);

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////

				String dealerSecondCardPath = Images.class.getResource("facedown_card.png").toExternalForm();

				dealerSecondCard.addImage(dealerSecondCardPath, 125, 125, true, dealerCardX, 100, gamePane);

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				primaryStage.setScene(gameScene);
				primaryStage.setResizable(false);
				primaryStage.show();
			}
		});
		
//		Action when user clicks the exit button
		(exitBtn.btn).setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent e)
			{
				System.exit(0);
			}
		});
		
//		What the hidden Easter egg does :P
		(secretBtn.btn).setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent e)
			{
				WebView secret = new WebView();
				secret.setPrefSize(800, 580);
				secret.getEngine().load("https://www.youtube.com/watch/dQw4w9WgXcQ");
				
				primaryStage.setScene(new Scene(secret));
				primaryStage.setResizable(false);
				primaryStage.show();
				
				primaryStage.setFullScreen(true);
			}
		});
		
//		Action when user clicks the hit button
		(hitBtn.btn).setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent e)
			{
				Card c = Game.humanPlayer.Hit(Game.newDeck);
				
				ToGUI humanCard = new ToGUI();
				String humanCardName = String.format("%d_of_%s.png", c.getRank(), c.getSuit());
				String humanCardPath = Images.class.getResource(humanCardName).toExternalForm();
				
				humanCard.addImage(humanCardPath, 125, 125, true, humanCardX, 440, gamePane);
				humanCardX = humanCardX+30;
				
				String score = String.format(": %d", Game.humanPlayer.GetScore());
				textPlayerScore.text.setText(score);
				
				if (Game.humanPlayer.GetScore() >= 21)
				{
					hitBtn.btn.setDisable(true);
				}
			}
		});
		
		ToGUI textDealerScore = new ToGUI();
		textDealerScore.addText(543, 75, "", verdana, 45, Color.YELLOW, gamePane);
		
//		Action when user clicks the stay button
		(stayBtn.btn).setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent e)
			{
				hitBtn.btn.setDisable(true);
				stayBtn.btn.setDisable(true);
				
				if (Game.humanPlayer.GetScore() <= 21)
				{
					Game.dealer.Hit(Game.newDeck);
				}
				
				gamePane.getChildren().remove(dealerSecondCard.currentImageView);
				for (int i = 1; i < Game.dealer.hand.size(); i++)
				{
					ToGUI dealerCard = new ToGUI();
					String dealerCardName = String.format("%d_of_%s.png", Game.dealer.hand.get(i).getRank(), Game.dealer.hand.get(i).getSuit());
					String dealerCardPath = Images.class.getResource(dealerCardName).toExternalForm();
//					dealerCardX = dealerCardX+30;
					
					dealerCard.addImage(dealerCardPath, 125, 125, true, dealerCardX, 100, gamePane);
					dealerCardX = dealerCardX+30;
					
//					Adds the score of the dealer to gamePane
					String dealerScore = String.format(": %d", Game.dealer.GetScore());
					textDealerScore.text.setText(dealerScore);
				}
				
//				Shifts the text for "DEALER" to the left to make room for showing the score
				textDealer.text.setX(textDealer.text.getX()-48);
				
				String temp = "";
				
				ToGUI textWon = new ToGUI();
				if (Game.humanWin())
				{
					temp = "YOU WON";
					textWon.addText(347, 325, temp, verdana, 65, Color.YELLOW, gamePane);
				}
				else if (Game.dealerWin()){
					temp = "DEALER WON";
					textWon.addText(295, 325, temp, verdana, 65, Color.YELLOW, gamePane);
				}
				else if (Game.draw()){
					temp = "DRAW";
					textWon.addText(405, 325, temp, verdana, 65, Color.YELLOW, gamePane);
				}

			}
		});
		
	}
		
}
