package war.linkedList.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
		this.play();
	}
	
	/**
	 * main helper method. handles which drows.
	 */
	private void play()
	{
		drawToDesk();
		
		if(player1.isEmpty() || player2.isEmpty() )
		{
			
			if(isEqual(UP1DrawnStack, UP2DrawnStack ) )
			{
				for(int i = 1; i <= 4; i++)
				{
					drawToDesk();
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
			System.out.println("test");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * prints the winner of the game
	 */
	private void printWinner()
	{
		if(player1.isEmpty())
		{
	    	System.out.println("winner " + player1.isEmpty());
		}else
		{
			System.out.println("winner " + player2.isEmpty());
		}
	}
	
	/**
	 * distributes the cards evenly
	 */
	private void cardGiver()
	{
		for(int i = 0; i <= 52; i++)
		{
			if(i % 2 == 0)
			{	
				player1.addToDrawStack(desk.draw());
			}else
			{
				player2.addToDrawStack(desk.draw());
			}
		}
	}
	/**
	 * helper method sets the card name on the HBox
	 */
	private void cardsetter()
	{
		//view.setCenter( view.setView(player1.drawnTop(), player2.drawnTop(),
			///	UP1DrawnStack.top().toString(),UP1DrawnStack.top().toString()));
		
		view.setCenter(  view.setView("s", "s", "s", "s" ));
			
	}


	
}
