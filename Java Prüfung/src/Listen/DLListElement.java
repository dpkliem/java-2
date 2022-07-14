package Listen;

public class DLListElement <E> {
	
	private E data = null;//Speicherobjekt
	
	private DLListElement<E> next = null; //Nachfolger
	
	private DLListElement<E> prev = null; //Vorgaenger
	
	public DLListElement(E data, DLListElement<E> prev, DLListElement<E> next)
		throws IllegalArgumentException{
		if(data == null) {
			throw new IllegalArgumentException("keine Daten");
			//darf nur verwendet werden, wenn auch Daten vorhanden sind
		}
		this.data = data;
		this.prev = prev;
		this.next = next;
		
	}
	
	public DLListElement() {
		//fuer die Initialisierung der Liste beim Start
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public DLListElement<E> getNext() {
		return next;
	}

	public void setNext(DLListElement<E> next) {
		this.next = next;
	}

	public DLListElement<E> getPrev() {
		return prev;
	}

	public void setPrev(DLListElement<E> prev) {
		this.prev = prev;
	}
	
	

}
