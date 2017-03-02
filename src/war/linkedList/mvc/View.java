package war.linkedList.mvc;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
		setUserNames();
		super.setStyle("-fx-background-color: #51df58");
		 new AboutGame();
	}

	/**
	 * 
	 * @return
	 */
	private ImageView titleImage(String name)
	{
		Image image = new Image(name);
		
	    viewImage = new ImageView();
		viewImage.setFitHeight(200);
		viewImage.setFitWidth(200);
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
		center.setPadding( new Insets(40, 50, 50, 100) );
		
		center.getChildren().addAll(this.CPUDrawnOnly(),
				this.centerStack(drawnStack1, drawnStack2),this.Up1DrawOnly());	
		 this.setCenter(center);
	}
	public void setView( VBox center)
	{
		center.requestLayout();
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
	    
	    
	    if( !card.hasCardWon())
	    {
	    	ImageView viewImageCPUShow = titleImage("file:cards/" + card.wonTop());
	    	CPUCars.getChildren().addAll( viewImageCPUHid, viewImageCPUShow);
	    	
	    }else if(!card.hasCardWon() &&  !card.hasCardDrawn())
	    {
	    	CPUCars = CPUDrawnOnly();
	    }
	    else{
				CPUCars.getChildren().addAll( viewImageCPUHid);
	    }
			
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
	public AnchorPane centerStack(LinkedStack<Card> cardA,LinkedStack<Card> cardB )
	{
		AnchorPane center = new AnchorPane();
		if( !cardA.isEmpty() &&  cardB.isEmpty())
		{
			ImageView cardLeft = titleImage("file:cards/"+ cardA.toString());

			center.getChildren().add(cardLeft);
		}else if (cardA.isEmpty() &&  !cardB.isEmpty() )
		{
			ImageView cardRight = titleImage("file:cards/"+ cardB.toString());
			center.getChildren().add(cardRight);
		}else if (!cardA.isEmpty() &&  !cardB.isEmpty() )
		{
			ImageView cardLeft = titleImage("file:cards/"+ cardA.toString());
			ImageView cardRight = titleImage("file:cards/"+ cardB.toString());
			center.getChildren().addAll(cardLeft, cardRight);			
		}else
		{
			center.getChildren().addAll(centerStackEmpty());
		}
		return center;
	}
	/**
	 * sets the middle discard stack this is a empty instance
	 * @param cardA
	 * @param cardB
	 * @return
	 */
	public AnchorPane centerStackEmpty( )
	{
		AnchorPane center = new AnchorPane();
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
		if( !card.hasCardWon())
		{
			ImageView viewImageUP1Show = titleImage("file:cards/" + card.wonTop());
			UP1Cars.getChildren().addAll( viewImageUP1Hid, viewImageUP1Show);
		}else if( !card.hasCardWon() &&  !card.hasCardDrawn() )
		{
			UP1Cars = Up1DrawOnly();
		} else{
			UP1Cars.getChildren().addAll( viewImageUP1Hid);
		}

		viewImageUP1Hid.setCursor(Cursor.HAND );
		viewImageUP1Hid.setOnMouseClicked( (e)-> controller.handle(e));	
		return UP1Cars;
	}
	
	/**
	 * method not used used
	 * @return
	 */
	public HBox Up1DrawOnly()
	{
		System.out.println("should not see this");
		HBox UP1Cars = new HBox(20);
		ImageView viewImageUP1Hid = titleImage("file:cards/Card_back.png");	
		
		return UP1Cars;
	}
	
	/**
	 * Set users names on the view
	 */
	private void setUserNames()
	{
		HBox top = new HBox(50);
		top.setPadding( new Insets(0, 120, 0, 300) );
		Label labelTop = new Label("CPU");
		labelTop.setFont(Font.font("Verdana", FontPosture.ITALIC, 30));
		labelTop.setTextFill(Color.RED);
		top.getChildren().add(labelTop);
		
		this.setTop(top);
		
		HBox bottom = new HBox();
		bottom.setPadding( new Insets(0, 120, 0, 300) );
		Label labelBotton = new Label("Player 1");
		labelBotton.setTextFill(Color.RED);
		labelBotton.setFont(Font.font("Verdana", FontPosture.ITALIC, 30));
		bottom.getChildren().add(labelBotton);
		this.setBottom(bottom);
		
	}
	
	/**
	 * visual equeue that a war event has just happened
	 */
	public void warFlag()
	{
		Label label= new Label("WAR!");
		label.setTextFill(Color.WHITE);
		label.setFont(Font.font(null, FontWeight.BOLD, 60));
		this.setStyle("-fx-background-color: #f44242");
		this.setRight(label);
		
	}
	
	/**
	 * displays the card valances. 
	 * @param status
	 */
	public void statusDisplayer(String status)
	{
		Label label= new Label(status);
		label.setTextFill(Color.WHITE);
		label.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		this.setLeft(label);
		
	}
	
	
}
