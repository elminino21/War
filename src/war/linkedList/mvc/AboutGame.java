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
		about.setContentText("SImple war game implementation");

		about.showAndWait();
	}
	
}
