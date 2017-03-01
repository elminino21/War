package war;

import war.linkedList.LinkedStack;
import war.linkedList.StackUnderflowException;

public class Player {

	/**
	 * @instance valirables
	 */
	private String name;
	private LinkedStack<Card> wonStack;
	private LinkedStack<Card> drawStack;
	
	/**
	 * @constructor
	 * @param name
	 */
	public Player(String name)
	{
		this.name = name;
		this.wonStack = new LinkedStack<Card>();
		this.drawStack = new LinkedStack<Card>();
	}
	
	/**
	 * draws a card from the the drawStack
	 * @return
	 * @throws StackUnderflowException
	 */
	public Card draw() throws StackUnderflowException
	{
		if(drawStack.isEmpty())
			{
				System.out.println("stack replanished");
				replenishDrawStack();
			}
		Card card = drawStack.top();
		drawStack.pop();
		return card;
	}
	
	/**
	 * adds card to descard stack
	 * @param card
	 */
	public void addToWonStack(Card card)
	{
		wonStack.push(card);
	}
	/**
	 * adds to drow stack
	 * @param card
	 */
	public void addToDrawStack(Card card)
	{
		drawStack.push( card );
	}
	/**
	 * test is draws stack is full
	 * @return
	 */
	public boolean hasCardDrawn()
	{
		return drawStack.isEmpty();
	}
	/**
	 * retusn a string representatin of top.
	 */
	public String drawnTop()
	{
		Card card = drawStack.top();
		return (card.getCardName());
	}
	/**
	 * retusn a string representatin of top.
	 */
	public String wonTop()
	{
		return wonStack.top().getCardName();
	}
	
	/**
	 * this is stack is empty
	 * @return
	 */
	public boolean hasCardWon()
	{
		return wonStack.isEmpty();
	}
	
	/**
	 * swithces the descard to the drawstack.
	 * @throws StackUnderflowException
	 */
	private void replenishDrawStack() throws StackUnderflowException
	{
		LinkedStack<Card> temp = new LinkedStack<Card>();
		
		if( wonStack.isEmpty() && drawStack.isEmpty() )
		{
			throw new StackUnderflowException("Descard stack is empty");
		}else
		{
			 temp = drawStack;
			this.drawStack = wonStack;
			wonStack = temp;
		}
	}
	
	public int drawStackSize()
	{
		return drawStack.size();
	}
	public int wonStackSize()
	{
		return wonStack.size();
	}
	
	
	
}
