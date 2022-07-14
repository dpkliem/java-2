package Listen;

public class DLListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DLMyList<String> myList = new DLMyList<String>();
		
		System.out.println(myList);//[] -> da leere Liste
		
		myList.addStart("Hallo");
		
		System.out.println(myList);
		
		myList.addStart("Heute");
		
		System.out.println(myList);
		
		myList.addEnde("Montag");
		
		System.out.println(myList);
		
		myList.addEnde("Mai");
		
		System.out.println(myList);
		
		System.out.println(myList.size());
		
		System.out.println(myList.removeStart());
		
		System.out.println(myList);
		
		System.out.println(myList.removeEnde());
		
		System.out.println(myList);
		
		System.out.println(myList.removeStart());
		
		System.out.println(myList.removeStart());
		
		System.out.println(myList);
		
		//System.out.println(myList.removeEnde());//Fehlermeldung da leere Liste
		
		//myList.addStart(null); //Fehlermeldung da keine Daten mit uebergeben

	}

}
