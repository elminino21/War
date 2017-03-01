package war;

public class Tester {
	public static void main(String ...args){
		
		Desk desk = new Desk();
		
		while(desk.size() != 0 )
		{
			System.out.println(desk.draw());
		}
		
		
		
		
	}
}
