package war.game;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import war.Desk;
import war.linkedList.mvc.View;

public class Game extends Application
{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("WAR!!!");
	
		Scene scene = new Scene ( new View() , 900, 800);
		 
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
		
	}
	
}
