package war;

import war.linkedList.LinkedStack;
import war.linkedList.StackUnderflowException;

public class Player {

	private String name;
	private LinkedStack<Card> discardStack;
	private LinkedStack<Card> drawStack;
	
	public Player(String name)
	{
		this.name = name;
		this.discardStack = new LinkedStack<>();
		this.drawStack = new LinkedStack<>();
	}
	
	public Card draw()
	{
		Card card = drawStack.top();
		drawStack.pop();
		return card;
	}
	
	public void discard(Card card)
	{
		discardStack.push(card);
	}
	
	public void addToDrawStack(Card card)
	{
		drawStack.push( card );
	}
	
	public boolean hasCards()
	{
		return drawStack.isEmpty();
	}
	
	public String toString()
	{
		return name;	
	}
	
	private void replenishDrawStack() throws StackUnderflowException
	{
		if(discardStack.isEmpty())
		{
			throw new StackUnderflowException("Descard stack is empty");
		}else
		{
			this.drawStack = discardStack;
		}
	}
}
