package war;

public class Player {

	String name;
	LinkedStack discardStack;
	LinkedStack drawStack;
	
	Player(String);
	Card draw();
	void discard(Card card);
	void addToDrawStack(Card);
	boolean hasCards();
	String toString();
	void replenishDrawStack();
}
