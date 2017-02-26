package war;

import java.util.Random;

import war.linkedList.LinkedStack;

public class Desk extends LinkedStack{
	
	private LinkedStack<Card> desk;
	
	public Desk()
	{
		super();
		this.desk = new LinkedStack<>();
		this.createCards();
		this.suffle();
	}
	
	/**
	 * fill stack with cards. 
	 */
	private void createCards() {
		
		for(int i = 1; i <= 4; i++)
		{
			for(int j = 1; j <= 4; j++ )
			{
				desk.push(new Card(i, j));
			}	
		}	
	}
	/**
	 * 
	 */
	public int size()
	{
		return desk.size();
	}
	/**
	 * 
	 */
	public	void suffle()
	{
		Random rand = new Random();
		int swap = 0;
		for(int i = 1; i <= 52; i++)
		{
			swap = rand.nextInt( (i-1) ) + 1;
			this.swapElemente( swap , i);
		}
	}
	/**
	 * 
	 * @return
	 */
	public Card draw()
	{
		return desk.top();
	}
	
	/**
	 * 
	 * @param elemetA
	 * @param elementB
	 */
	public	void swapElemente(int swap, int pivot)
	{
		
	}

}
