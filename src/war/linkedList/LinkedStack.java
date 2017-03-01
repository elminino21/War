
package war.linkedList;

import war.Card;

public class LinkedStack<T> implements StackInterface<T>
{
  protected LLNode<T> top;   // reference to the top of this stack
  private int size;
  public LinkedStack()
  {
	this.size = 0;
    top = null;
  }

  public void push(T element)
  // Places element at the top of this stack.
  { 
	  
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(top);
    top = newNode;
    size++;
  }     

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
      top = top.getLink();
    	size--;
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      return top.getInfo();
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (top == null); 
  }

  public boolean isFull()
  // Returns false - a linked stack is never full
  {              
      return false;
  }
  /**
   * 
   * @return the size of the current link list
   */
  public int size()
  {
	  return size;
  }

 
  
  public Card getCard( String name)
  {
	    
	return  recEvenNum( top,  name);
	  
  }
 
  
  private Card recEvenNum(LLNode<T> list, String name)
	{
			if(list == null)
			{
				return null;
			}else if(list.getInfo().toString().equals(name) )
			{
				return (Card) list.getInfo();
			}
				
			else
			{			
				return   recEvenNum( list.link, name);
			}	
	}
  
  
  public void stackPrinter()
  {
	  recPrinter(top);
  }

  private void recPrinter(LLNode<T> list) {
	 
	  if (list != null) {
		  recPrinter(list.link);
	      System.out.println(list.info.toString());
	    }
  }
  
  
  
}

