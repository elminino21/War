package war.linkedList.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import war.Card;
import war.Desk;
import war.Player;
import war.linkedList.LinkedStack;
import war.linkedList.StackUnderflowException;

public class Controller implements  EventHandler
{
	/**
	 * @instance valiables
	 */
	private View view;
	private Model model;
	private Desk desk;
	private LinkedStack<Card> UP1DrawnStack; // stack on the desk
	private LinkedStack<Card> UP2DrawnStack; // stack on the desk
	private Player player1;
	private Player player2;
	
	/**
	 * @constructor
	 * @param view
	 */
	public Controller(View view)
	{
		this.view  = view;
		//this.model = new Model();
		 this.desk = new Desk();
		 this.player1 = new Player("UP1");
		 this.player2 = new Player("UP2");
		 this.UP1DrawnStack = new LinkedStack<>();
		 this.UP2DrawnStack = new LinkedStack<>();
		 this.cardGiver();
		 this.cardsetter();
	}
		
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		//System.out.println("UP1 car clicked");
		//System.out.println( player1.drawnTop() );
		//System.out.println( player2.drawnTop() );
	//	System.out.println();
		
		stackStatus();
		this.play();
		this.cardsetter();
		event.consume();
	}
	
	/**
	 * main helper method. handles which drows.
	 */
	private void play()
	{
		drawToDesk();
		
		deskDrawnComparator();
		if( player1.hasCardWon() || player2.hasCardWon() )
		{
			if(!UP1DrawnStack.isEmpty()){
				if(UP1DrawnStack.top().getFaceNum() == UP2DrawnStack.top().getFaceNum() )
				{
					for(int i = 1; i <= 3; i++)
					{
						drawToDesk();
					}
				}
			}
			
		}else 
		{
			this.printWinner();
		}
		
	}
	/**
	 * 
	 * @param stackUP1
	 * @param stackUP2
	 * @return return true if the sextion after '_' are equals for both tops
	 */
	private boolean isEqual(LinkedStack<Card> stackUP1, LinkedStack<Card> stackUP2 )
	{
		String cardA;
		String cardB;	
		cardA = UP1DrawnStack.top().toString();
	    cardB = UP2DrawnStack.top().toString();
		
		return cardA.regionMatches(cardA.indexOf("_"), cardB, cardB.indexOf("_"), 10  );
	}
	/**
	 * draws cars to the desk. 
	 */
	private void drawToDesk()
	{
		
		try {
			UP1DrawnStack.push( player1.draw() );
			UP2DrawnStack.push(player2.draw());
			
			
		} catch (StackUnderflowException e) {
			System.out.println( );
			System.out.println( );
			System.out.println("error on "+player1.drawnTop() );
			System.out.println( "error on "+player2.drawnTop());
			
			System.out.println("error detected on draw to desk");
			e.printStackTrace();
		}
	}
	
	private void deskDrawnComparator()
	{

		if(UP1DrawnStack.top().getFaceNum() > UP2DrawnStack.top().getFaceNum())
		{
			while( !UP1DrawnStack.isEmpty() && !UP2DrawnStack.isEmpty() ){
			
				player1.addToWonStack(UP1DrawnStack.top());
				UP1DrawnStack.pop();
				player1.addToWonStack(UP2DrawnStack.top());
				UP2DrawnStack.pop();
			}
		}else if (  UP2DrawnStack.top().getFaceNum() >  UP1DrawnStack.top().getFaceNum())
		{
			while( !UP1DrawnStack.isEmpty() && !UP2DrawnStack.isEmpty() ){
				player2.addToWonStack(UP1DrawnStack.top());
				UP1DrawnStack.pop();
				player2.addToWonStack(UP2DrawnStack.top());
				UP2DrawnStack.pop();
			}
		}

	}
	
	/**
	 * prints the winner of the game
	 */
	private void printWinner()
	{
		if( player1.hasCardWon() &&  player1.hasCardDrawn() )
		{
	    	System.out.println("winner  player 2" );
		}else if (player2.hasCardWon() &&  player2.hasCardDrawn())
		{
			System.out.println("winner  player 1" );
		}
	}
	
	/**
	 * distributes the cards evenly
	 */
	private void cardGiver()
	{
		for(int i = 0; i <= 51; i++)
		{
			if(i % 2 == 0)
			{	
				//System.out.println(desk.draw().toString()); //for testing
				player1.addToDrawStack(desk.draw());
			
			}else
			{
				//System.out.println(desk.draw().toString()); // for testing
				player2.addToDrawStack(desk.draw());
			}
			
		}
		System.out.println( "on player one hand :"	+ player1.drawStackSize()  );
		System.out.println( "on CPU hand :"	+ 	player2.drawStackSize()  );
		System.out.println( 	desk.size() );
	}
	/**
	 * helper method sets the card name on the HBox
	 */
	private void cardSetter()
	{
			view.setView( player1, player2, UP1DrawnStack, UP2DrawnStack );	
	}
	
	private void cardsetter()
	{
		VBox center = new VBox(50);
		center.setPadding( new Insets(40, 50, 50, 300) );
		
		if(player2.hasCardDrawn())
		{
			center.getChildren().add(view.CPU(player2));
		}else{
		
		center.getChildren().add( view.CPU(player2));
		}
			
		center.getChildren().add( view.centerStack(UP1DrawnStack, UP2DrawnStack ) );
		
		center.getChildren().add( view.Up1(player1)  );
		
		view.setView(center);
	}

	
	/**
	 * prints updated quantities of all the stacks
	 */
	private void stackStatus(){
		
		System.out.println("up1 on deck size " + UP1DrawnStack.size());
		System.out.println( "up2 on deck size " +UP2DrawnStack.size());
		
	   System.out.println("up1 on won size " +player1.wonStackSize());
	    System.out.println("up1 on draw size " +player1.drawStackSize());
	    
	    System.out.println("up2 on won size " +player2.wonStackSize());
	    System.out.printf("up2 on draw size " +player2.drawStackSize() +"\n\n");
	
	}
	
	
	
}
