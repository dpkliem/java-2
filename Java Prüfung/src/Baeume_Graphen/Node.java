package baum;

public class Node <E>{
	
	private E data;//zur Speicherung der Daten
	//Achtung: bei bspw. binaeren Suchbaeumen -> Unterstuetzung von compareTo
	
	private Node<E> leftTree; //linken Teilbaum
	private Node<E> rightTree; //rechten Teilbaum
	
	public Node(E data) {
		this.data = data;
		leftTree = null;
		rightTree = null;
		//erzeugt nur ein Blatt
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Node<E> leftTree) {
		this.leftTree = leftTree;
	}

	public Node<E> getRightTree() {
		return rightTree;
	}

	public void setRightTree(Node<E> rightTree) {
		this.rightTree = rightTree;
	}
	
	public String toString() {
		return "Inhalt: " +data;
	}

}
