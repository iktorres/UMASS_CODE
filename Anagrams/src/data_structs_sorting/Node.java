package data_structs_sorting;

public class Node<E> {
	private E element    = null;
	//private Node<E> current = null;
	private Node<E> next    = null;
	
	public Node() {
		//this.current = this;
		//this.next = null;
	}
	
	public Node(E element) {
		this.element = element;
		//this.current = this;
		this.next    = null;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public E getElement() {
		return this.element;
	}
	
	public void setNext(Node<E> node) {
		this.next = node;
	}
	
	/*public void setCurrent(Node<E> node) {
		this.current = node;
	}*/
	
	/*public Node<E> getCurrent() {
		return this.current;
	}*/
	
	public Node<E> getNext() {
		return this.next;
	}
}
