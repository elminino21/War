package war;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import war.linkedList.LinkedStack;

public class Desk extends LinkedStack{
	
	private LinkedStack<Card> desk;
	private List<Card> cardHolder = new ArrayList<>(); 
	
	public Desk()
	{
		super();
		this.desk = new LinkedStack<>();
	 	this.createCards();
	     System.out.println(cardHolder.size());
	 	System.out.println( desk.size());	
		this.suffle();
		desk.stackPrinter();
		
	}
	
	
	/**
	 * fill stack with cards. 
	 */
	private void createCards() {
		
		for(int i = 1; i <= 4; i++)
		{
			for(int j = 1; j <= 13; j++ )
			{
				Card b = new Card(i, j);
				desk.push(b);
				cardHolder.add(b);
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
		for(int i = 1; i <= 51; i++)
		{
			swap = rand.nextInt( i ) ;
			swap -= 1;
			if(swap >= 1 && swap < 53 ){
			
			
			this.swapElemente(  cardHolder.get(swap).toString() , cardHolder.get(i).toString());
			}
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
	public	void swapElemente(String swap, String pivot)
	{
		Card swapCard = desk.getCard(swap);
		
		Card pivotCard = desk.getCard(pivot);
		swapCard.setCardType(pivot);
		pivotCard.setCardType(swap);
		
		
	}

}
