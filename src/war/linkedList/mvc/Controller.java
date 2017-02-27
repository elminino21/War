package war.linkedList.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import war.Card;
import war.Desk;
import war.Player;
import war.linkedList.LinkedStack;

public class Controller implements  EventHandler<MouseEvent>
{
	private View view;
	private Model model;
	private Desk desk;
	private LinkedStack<Card> UP1DrawnStack; // stack on the desk
	private LinkedStack<Card> UP2DrawnStack; // stack on the desk
	private Player player1;
	private Player player2;
	
	public Controller(View view)
	{
		this.view  = view;
		//this.model = new Model();
		 this.desk = new Desk();
		 this.player1 = new Player("UP1");
		 this.player2 = new Player("UP2");
		 this.UP1DrawnStack = new LinkedStack<>();
		 this.UP2DrawnStack = new LinkedStack<>();
	}
		
	
	@Override
	public void handle(MouseEvent event) 
	{
		this.play();
		
	}
	
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
		UP1DrawnStack.push( player1.draw() );
		UP2DrawnStack.push(player2.draw());
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
	
}
