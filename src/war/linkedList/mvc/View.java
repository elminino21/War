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
	public VBox setView( String player1Discard, String player2Discard,  String drawnStack1, String drawnStack2)
	{
		
		VBox center = new VBox(50);
		center.setPadding( new Insets(40, 50, 50, 300) );
		ImageView viewImageCenter = titleImage("file:cards/Spade_Queen_RA.gif");
		center.getChildren().addAll(this.CPU(player2Discard),
				this.centerStack(drawnStack1, drawnStack2),this.Up1(player1Discard));	
		return center;
	}
	
	/**
	 * method not yet used
	 * @param cardName
	 * @return
	 */
	private HBox  CPU( String cardName)
	{
		HBox CPUCars = new HBox(20);
		ImageView viewImageCPUHid = titleImage("file:cards/Card_back.png");
		ImageView viewImageCPUShow = titleImage("file:cards/Club_Ace_RA.gif");
		CPUCars.getChildren().addAll( viewImageCPUHid, viewImageCPUShow);
		
		return CPUCars;
	}
	
	/**
	 * method not yet used
	 * @param cardName
	 * @return
	 */
	private HBox  CPUDrawnOnly()
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
	private FlowPane centerStack(String cardA,String cardB )
	{
		FlowPane center = new FlowPane();
		ImageView cardLeft = titleImage("file:cards/Card_back.png");
		ImageView cardRight = titleImage("file:cards/Card_back.png");
		center.getChildren().addAll(cardLeft, cardRight);
		
		return center;
	}
	/**
	 * sets the middle discard stack this is a empty instance
	 * @param cardA
	 * @param cardB
	 * @return
	 */
	private FlowPane centerStackEmpty( )
	{
		FlowPane center = new FlowPane();
		return center;
	}
	
	/**
	 * method not used used
	 * @return
	 */
	private HBox Up1( String cardName )
	{
		HBox UP1Cars = new HBox(20);
		ImageView viewImageUP1Hid = titleImage("file:cards/Card_back.png");	
		ImageView viewImageUP1Show = titleImage("file:cards/Heart_Two_RA.gif");	
		viewImageUP1Hid.setCursor(Cursor.HAND );
		viewImageUP1Hid.setOnMouseClicked( controller);
		UP1Cars.getChildren().addAll(viewImageUP1Hid, viewImageUP1Show);
		
		return UP1Cars;
	}
	
	/**
	 * method not used used
	 * @return
	 */
	private HBox Up1DrawOnly()
	{
		HBox UP1Cars = new HBox(20);
		ImageView viewImageUP1Hid = titleImage("file:cards/Card_back.png");	
		viewImageUP1Hid.setCursor(Cursor.HAND );
		viewImageUP1Hid.setOnMouseClicked( controller);
		UP1Cars.getChildren().addAll(viewImageUP1Hid);
	
		return UP1Cars;
	}
	
	
	
}
