package war;

import war.linkedList.LinkedStack;
import war.linkedList.StackUnderflowException;

public class Player {

	/**
	 * @instance valirables
	 */
	private String name;
	private LinkedStack<Card> discardStack;
	private LinkedStack<Card> drawStack;
	
	/**
	 * @constructor
	 * @param name
	 */
	public Player(String name)
	{
		this.name = name;
		this.discardStack = new LinkedStack<>();
		this.drawStack = new LinkedStack<>();
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
	public void discard(Card card)
	{
		discardStack.push(card);
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
	public boolean hasCards()
	{
		return drawStack.isEmpty();
	}
	/**
	 * retusn a string representatin of top.
	 */
	public String drawnTop()
	{
		return discardStack.top().toString();
	}
	/**
	 * return the name user's name.
	 */
	public String toString()
	{
		return name;	
	}
	/**
	 * this is stack is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		return discardStack.isEmpty();
	}
	
	/**
	 * swithces the descard to the drawstack.
	 * @throws StackUnderflowException
	 */
	private void replenishDrawStack() throws StackUnderflowException
	{
		LinkedStack<Card> temp = new LinkedStack<Card>();
		
		if( discardStack.isEmpty() && drawStack.isEmpty() )
		{
			throw new StackUnderflowException("Descard stack is empty");
		}else
		{
			 temp = drawStack;
			this.drawStack = discardStack;
			discardStack = temp;
		}
	}
}
