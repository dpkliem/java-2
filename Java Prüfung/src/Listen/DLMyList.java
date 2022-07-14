package Listen;

import java.util.NoSuchElementException;

public class DLMyList <E>{

	private DLListElement<E> entry;
	//wird als Startpunkt fuer die Datenhaltung gebraucht
	
	private int size;
	
	public DLMyList() {
		//entry = new DLListElement<E>(null, entry, entry);
		//-> Hinweis: Fehlermeldung bei data == null
		
		entry = new DLListElement<E>();
		entry.setNext(entry);
		entry.setPrev(entry);
		//Vorgaenger und NAchfolger von entry ist entry selbst
		size = 0;
	}
	
	private void add(E data, DLListElement<E> current) {
		DLListElement<E> newElement = new DLListElement<E>(data, current.getPrev(), current);
		newElement.getPrev().setNext(newElement);
		newElement.getNext().setPrev(newElement);
		size++;
	}
	
	public void addStart(E data) {
		add(data, entry.getNext());
	}
	public void addEnde(E data) {
		add(data, entry);
	}
	
	private E remove(DLListElement<E> current) throws NoSuchElementException{
		if(current == entry) {//hier wirklich auf den Speicherbereich bezogen
			throw new NoSuchElementException();
		}
		E data = current.getData();
		current.getPrev().setNext(current.getNext());
		current.getNext().setPrev(current.getPrev());
		current.setPrev(null);
		current.setNext(null);
		current.setData(null);
		size--;
		return data;
	}
	
	public E removeStart() {
		return remove(entry.getNext());
	}
	
	public E removeEnde() {
		return remove(entry.getPrev());
	}
	
	public String toString() {
		String erg = "[";
		
		for(DLListElement<E> current = entry.getNext(); current != entry; current = current.getNext()) {
			erg += current.getData() == this ? "Liste selbst" : current.getData().toString();
			if(current.getNext() != entry) {
				erg += ", ";
			}
		}
		erg += "]";
		return erg;
	}
	
	public int size() {
		return size;
	}
	
	
	
	
	
	
	
}
