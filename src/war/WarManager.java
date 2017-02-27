package war;

import war.linkedList.LinkedStack;

public class WarManager {

	private Desk desk;
	private LinkedStack<Card> UP1DrawStack; // stack on the desk
	private LinkedStack<Card> UP2DrawStack; // stack on the desk
	private Player player1;
	private Player player2;
	
	
	public void setup()
	{
		 this.desk = new Desk();
		 this.player1 = new Player("UP1");
		 this.player2 = new Player("UP2");
		 this.UP1DrawStack = new LinkedStack<>();
		 this.UP2DrawStack = new LinkedStack<>();
	}
	
	public void play()
	{
		
		while(true)
		{
			
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
