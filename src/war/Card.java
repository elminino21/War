package war;

public class Card {
	private String face;
	private String suit;
	private String name = "";
	private int faceInt = 0;
	private int suitInt = 0;
	/**
	 * The fallowing two array will help create 
	 */
	private String [] cardface = { "back.png", "Ace_RA.gif", "Two_RA.gif", "Three_RA.gif", 
			"Four_RA.gif" , "Five_RA.gif", "Six_RA.gif", "Seven_RA.gif", "Eight_RA.gif",
			"Nine_RA.gif", "Ten_RA.gif", "Jack_RA.gif", "Queen_RA.gif", "King_RA.gif" };
	private String [] suitArray = 
		{
			"card_", "Club_", "Diamond_", "Heart_", "Spade_"
	};
	
	
	/**
	 * 
	 * @param suit
	 * @param face
	 */
	public  Card(  int suit, int face)
	{
		this.faceInt = face;
		this.suitInt = suit;
		this.face = cardface[face] ;
		this.suit = suitArray[suit];
		
		this.name = (suitArray[suitInt] + cardface[faceInt]);
		
	}
	
	/**
	 * 
	 * @return
	 */
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
		int i = 0;
		boolean sentinel = false;
		suitArray[suitInt] = name.substring( 0 , name.indexOf("_") );
		
		for( i = 1; i < 13 && sentinel == false; i++)
		{
			sentinel = name.substring( name.indexOf("_")+1, name.length()).equals(cardface[i]);
		}
		faceInt = i;
		cardface[faceInt] =  name.substring( name.indexOf("_"), name.length());
		   
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
	 *  returns card name
	 */
	public String getCardName()
	{
		
		return  (suitArray[suitInt] + cardface[faceInt]);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (suitArray[suitInt] + cardface[faceInt]);
	}
	
	/**
	 * 
	 * @return int value of the card
	 */
	public int getFaceNum()
	{
		return faceInt;
	}
	
	

}
