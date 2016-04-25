

public class Node<E> {
	
	//Contents of the Node
	private E element       = null;
	
	//Pointer to the next Node
	private Node<E> next    = null;
	
	/*
	 * Default Node constructor
	 */
	public Node() {
		
	}
	
	/*
	 * Node constructor
	 * 
	 * @param element: content to be input into Node
	 * 
	 */
	public Node(E element) {
		this.element = element;
		this.next    = null;
	}
	
	/*
	 * Setter for the Node
	 */
	public void setElement(E element) {
		this.element = element;
	}
	
	/*
	 * Getter for the contents of Node
	 * 
	 * @return element
	 * 
	 */
	public E getElement() {
		return this.element;
	}
	
	/*
	 * Setter for the next Node
	 * 
	 * @param node: Node to be the next Node after the current node
	 * 
	 */
	public void setNext(Node<E> node) {
		this.next = node;
	}
	
	/*
	 * Getter for the next Node
	 * 
	 * @return next
	 * 
	 */
	public Node<E> getNext() {
		return this.next;
	}
}
