package baum;

public class MyBaumTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyBaum<Integer> baum = new MyBaum<Integer>(6);
		
		baum.insert(7);
		
		System.out.println(baum.find(7));
		
		

	}

}
