package war;

public class Card {
	private String face;
	private String suit;
	private String name = "";
	/**
	 * The fallowing two array will help create 
	 */
	private String [] cardface = { "back.png", "Ace_RA.gif", "Two_RA.gif", "Three_RA.gif", 
			"Four_RA.gif" , "Five_RA.gif", "Six_RA.gif", "Seven_RA.gif", "Eight_RA.gif",
			"Nine_RA.gif", "Ten_RA.gif", "Jack_RA.gif", "Queen_RA.gif", "King_RA.gif" };
	private String [] suitArray = {
			"card_", "Club_", "Diamond_", "Heart_", "Spade_"
	};
	
	
	
	public  Card(  int suit, int face)
	{
		this.face = cardface[face] ;
		this.suit = suitArray[suit];
		this.name = suitArray[suit] + cardface[face];
		
	}
	
	public	String getFace()
	{
		return face;
	}
	/**
	 * 
	 * @return
	 */
	public String getSuit()
	{
		return suit;
	}
	/**
	 * 
	 * @param a
	 */
	private void setFace(String a) 
	{
		
	}
	public void setCardType(String name)
	{
		this.name = name;
	}
	/**
	 * 
	 * @param a
	 */
	private void setSuit(String a)
	{
		
	}
	/**
	 * 
	 */
	public String toString()
	{
		
		return  name;
	}

}
