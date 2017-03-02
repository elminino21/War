package war.linkedList.mvc;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AboutGame {

	
	public AboutGame()
	{
		game();
	}
	
	private void game()
	{
		Alert about = new Alert(AlertType.INFORMATION);
		about.setHeaderText("THIS IS WAR!");
		about.setResizable(false);
		about.setContentText("                   Simple war game implementation\n to process click ok on the window and "
				+ "click on the player's one"
				+ "card.Note: The games changes the background color to red if both card are the same and takes 3 cards from  "
				+ "both CPU and player. it changes back to green when war i done.\n"
				+ "ENJOY!!!");

		about.showAndWait();
	}
	
}
