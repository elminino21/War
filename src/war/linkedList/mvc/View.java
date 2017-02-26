package war.linkedList.mvc;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class View extends BorderPane{
	
	public ImageView viewImage;
	
	public View()
	{
		super();
		this.setCenter(this.setView());
	}

	/**
	 * 
	 * @return
	 */
	private ImageView titleImage(String name)
	{
		Image image = new Image(name);
		 
	    viewImage = new ImageView();
		viewImage.setFitHeight(100);
		viewImage.setFitWidth(100);
		viewImage.setImage(image);
		viewImage.setCursor(Cursor.HAND );
		viewImage.setPreserveRatio(true);
		viewImage.setSmooth(true);
		viewImage.setCache(true);
		
		return viewImage;
	}
	
	private VBox setView()
	{
		
		VBox center = new VBox(50);
		center.setPadding(new Insets(40, 50, 50, 300));
		
		HBox CPUCars = new HBox(20);
		ImageView viewImageCPUHid = titleImage("file:cards/Card_back.png");
		ImageView viewImageCPUShow = titleImage("file:cards/Club_Ace_RA.gif");
		CPUCars.getChildren().addAll( viewImageCPUHid, viewImageCPUShow);
		
		ImageView viewImageCenter = titleImage("file:cards/Spade_Queen_RA.gif");
		
		HBox UP1Cars = new HBox(20);
		ImageView viewImageUP1Hid = titleImage("file:cards/Card_back.png");	
		ImageView viewImageUP1Show = titleImage("file:cards/Heart_Two_RA.gif");	
		UP1Cars.getChildren().addAll(viewImageUP1Hid, viewImageUP1Show);
		
		center.getChildren().addAll(CPUCars,  viewImageCenter, UP1Cars);
		
		return center;
	}
}
