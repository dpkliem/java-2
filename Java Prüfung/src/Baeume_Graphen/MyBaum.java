package baum;

public class MyBaum <E> {

	private Node<E> root; //der Baum kennt nur die Wurzel
	
	public MyBaum() {
		root = null;//leeren Baum
	}
	
	public MyBaum(E data) {
		root = new Node<E>(data);
		//erzeugt einen Baum mit nur der Wurzel als Element
	}
	
	public MyBaum(Node<E> root) {
		this.root = root;
	}
	
	public void insert(E data) {
		if(root == null) {
			//noch kein Baum vorhanden, nur ein leerer Baum
			//die Daten werden die neue Wurzel
			root = new Node<E>(data);
		}else {
			//in der Wurzel steht etwas
			if(data.equals(root.getData())) {
				//keine doppelten Elemente zulaessig
				System.out.println("Wert schon vorhanden");
			}else {
				//Wert noch nicht enthalten
				//Wo muss ich den Wert einordnen?
				if(data.hashCode() < root.getData().hashCode()) {
					//Wert muss in den linken Teilbaum
					MyBaum<E> left = new MyBaum<E>(root.getLeftTree());
					left.insert(data);
					root.setLeftTree(left.root);
				}
				
				if(data.hashCode() > root.getData().hashCode()) {
					//Wert muss in den rechten Teilbaum
					MyBaum<E> right = new MyBaum<E>(root.getRightTree());
					right.insert(data);
					root.setRightTree(right.root);
				}
			}
		}
	}
	
	public Node<E> find(E data){
		if(root == null) {
			return null;
		}else {
			if(root.getData().hashCode() < data.hashCode()) {
				//im rechten Teilbaum weiter suchen
				MyBaum<E> right = new MyBaum<E>(root.getRightTree());
				return right.find(data);
			}else {
				if(root.getData().hashCode() > data.hashCode()) {
					//im linken Teilbaum weiter suchen
					MyBaum<E> left = new MyBaum<E>(root.getLeftTree());
					return left.find(data);
				}else {
					return root;//Wurzelelement ist das gesuchte Element
				}
			}
		}
	}
}
