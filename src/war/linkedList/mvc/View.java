package war.linkedList.mvc;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import war.Card;
import war.Player;
import war.linkedList.LinkedStack;

public class View extends BorderPane{
	
	/**
	 * @instance variable
	 */
	public ImageView viewImage;
	private Controller controller;
	
	/**
	 * @Constructor
	 */
	public View()
	{
		super();
		controller = new Controller(this);
		super.setStyle("-fx-background-color: #51df58");
		
	}

	/**
	 * 
	 * @return
	 */
	private ImageView titleImage(String name)
	{
		Image image = new Image(name);
		
	    viewImage = new ImageView();
		viewImage.setFitHeight(170);
		viewImage.setFitWidth(170);
		viewImage.setImage(image);
		viewImage.setPreserveRatio(true);
		viewImage.setSmooth(true);
		viewImage.setCache(true);
		
		
		return viewImage;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setView( Player player1, Player player2,  
			LinkedStack<Card> drawnStack1, LinkedStack<Card> drawnStack2)
	{		
		VBox center = new VBox(50);
		center.setPadding( new Insets(40, 50, 50, 300) );
		//ImageView viewImageCenter = titleImage("file:cards/Spade_Queen_RA.gif");
		
		center.getChildren().addAll(this.CPUDrawnOnly(),
				this.centerStack(drawnStack1, drawnStack2),this.Up1DrawOnly());	
		 this.setCenter(center);
	}
	
	/**
	 * method not yet used
	 * @param cardName
	 * @retur
	 */
	public HBox  CPU( Player card)
	{
		HBox CPUCars = new HBox(20);
	    ImageView viewImageCPUHid = titleImage("file:cards/Card_back.png");
		ImageView viewImageCPUShow = titleImage("file:cards/" + card.drawnTop());
		CPUCars.getChildren().addAll( viewImageCPUHid, viewImageCPUShow);
			
				CPUCars.getChildren().addAll( viewImageCPUHid);
			
		return CPUCars;
	}
	
	/**
	 * method not yet used
	 * @param cardName
	 * @return
	 */
	public HBox  CPUDrawnOnly()
	{
		HBox CPUCars = new HBox(20);
		ImageView viewImageCPUHid = titleImage("file:cards/Card_back.png");
		CPUCars.getChildren().addAll( viewImageCPUHid);
		
		return CPUCars;
	}
	
	/**
	 * sets the middle discard stack
	 * @param cardA
	 * @param cardB
	 * @return
	 */
	public FlowPane centerStack(LinkedStack<Card> cardA,LinkedStack<Card> cardB )
	{
		FlowPane center = new FlowPane();
			ImageView cardLeft = titleImage("file:cards/"+ cardA.toString());
			ImageView cardRight = titleImage("file:cards/"+ cardB.toString());
			center.getChildren().addAll(cardLeft, cardRight);		
		return center;
	}
	/**
	 * sets the middle discard stack this is a empty instance
	 * @param cardA
	 * @param cardB
	 * @return
	 */
	public FlowPane centerStackEmpty( )
	{
		FlowPane center = new FlowPane();
		return center;
	}
	
	/**
	 * method not used used
	 * @return
	 */
	public HBox Up1( Player card )
	{
		HBox UP1Cars = new HBox(20);
			ImageView viewImageUP1Hid = titleImage("file:cards/Card_back.png");	
			ImageView viewImageUP1Show = titleImage("file:cards/"+ card.drawnTop());	
			viewImageUP1Hid.setCursor(Cursor.HAND );
			viewImageUP1Hid.setOnMouseClicked( (e)-> controller.handle(e));
			UP1Cars.getChildren().addAll(viewImageUP1Hid, viewImageUP1Show);
		
		return UP1Cars;
	}
	
	/**
	 * method not used used
	 * @return
	 */
	public HBox Up1DrawOnly()
	{
		HBox UP1Cars = new HBox(20);
		ImageView viewImageUP1Hid = titleImage("file:cards/Card_back.png");	
		viewImageUP1Hid.setCursor(Cursor.HAND );
		viewImageUP1Hid.setOnMouseClicked( (e)-> controller.handle(e));
		UP1Cars.getChildren().addAll(viewImageUP1Hid);
	
		return UP1Cars;
	}
	
	
}
