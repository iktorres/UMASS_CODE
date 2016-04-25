

//Import library for writing to a File
import java.io.FileWriter;
//Import library for handling IOException
import java.io.IOException;

public class LinkedList<E> extends Object{
	
	//Initialize as the head Node of the LinkedList
	private Node<E> head;
	
	//Initialize as the last Node of the LinkedList
	private Node<E> last;
	
	//Size of the LinkedList
	private int     size = 0;
	
	/*
	 * Default LinkedList constructor
	 * 
	 * @param element : element of type E
	 */
	public LinkedList() {
		
	}
	
	/*
	 * LinkedList constructor
	 * 
	 * @param element : element of type E
	 */
	public LinkedList(E element) {
		//Set the element of type E to be the
		//head of the LinkedList
		this.head = new Node<E>(element);
		
		//Set the last element to be the head
		//upon initialization to prevent
		//a NullPointerException
		this.last = this.head;
		
		//Initialize the size to be 1
		this.size = 1;
	}
	
	/*
	 * Add an element to the end of the LinkedList<E>
	 * 
	 * @param  element : element of type E to add
	 * 
	 * @return void
	 */
	public void add(E element) {
		//If the LinkedList has no elements
		if(this.size == 0) {
			//Initialize the head Node to be the new element
			this.head = new Node<E>(element);
			
			//The last Node is set as the next Node of head
			this.head.setNext(this.last);
			
			//Also, make the last Node the head Node
			//in order to give last access to head
			//for now
			this.last = this.head;
		}else {
			//If the size is greater than 0 set last's next
			//Node to be the new element
			this.last.setNext(new Node<E>(element));
			
			//Make sure the last Node gets set to be the new
			//Node
			this.last = this.last.getNext();
		}
		
		//Increase the size of the LinkedList
		this.size++;
	}
	
	/*
	 * Add an element to any index > 0
	 * 
	 * @param index  : location of the element
	 * 
	 * @param element: element of type E to add
	 * 
	 * @return void
	 */
	public void add(int index, E element) {
		//Establish a pointer to the head Node
		Node<E> temp = this.head;
		
		//A temporary Node used to get the rest of
		//the list when inserting a Node in the middle
		//of the LinkedList
		Node<E> temp2= null;
		
		//A counter used to keep track of the current
		//location in the LinkedList
		int count = 0;
		
		//If the add call is used in a negative context
		if(index < 0) {
			System.err.println("Can't add to list with negative index!");
			return;
		}
		
		//If the index is 0, then add new element to the head of the
		//LinkedList and make sure the rest of the list is intact
		if(index == 0) {
			temp2 = this.head;
			this.head = new Node<E>(element);
			this.head.setNext(temp2);
			this.size++;
			return;
		}
		
		//Iterate through the LinkedList and stop before reaching the
		//index
		while(count < index - 1) {
			temp = temp.getNext();
			count++;
		}
		
		//Make sure to keep the elements behind the index by initializing
		//temp2 to be the rest of the LinkedList
		temp2 = temp.getNext();
		
		//Set the node of the desired index to be the new element Node
		temp.setNext(new Node<E>(element));
		
		//Set the node after the new element Node to be the rest of the
		//LinkedList
		temp.getNext().setNext(temp2);
		
		//Increase the size of the LinkedList
		this.size++;
	}
	
	/*
	 * A getter for the size of the LinkedList
	 * @return size
	 */
	public int size() {
		return this.size;
	}
	
	/*
	 * Clears the LinkedList
	 * @return void
	 */
	public void clear() {
		this.head = null;
	}
	
	/*
	 * Finds out if the element exists in the LinkedList
	 * 
	 * @param element : element in question in the list
	 * 
	 * @return boolean
	 */
	public boolean contains(E element) {
		return (lastIndexOf(element) >= 0)?true:false;
	}
	
	/*
	 * Returns the element in the LinkedList at position
	 * index
	 * 
	 * @param index : position of interest in the LinkedList
	 * 
	 * @return element
	 */
	public E get(int index) {
		
		//If the desired index is beyond the scope of the LinkedList
		//or it is negative throw an IndexOutOfBoundsException
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}
		
		//If the desired index is 0 return the head of the LinkedList
		if(index == 0) {
			return this.head.getElement();
		}
		
		//Establish a pointer to the head of the LinkedList
		Node<E> temp = this.head;
		
		//A counter used to keep track of the current
		//location in the LinkedList
		int count = 0;
		
		//Establish a limit to the iterator it must not access elements
		//beyond the scope of the LinkedList
		int limit = this.size - 1;
		
		//Iterate through the LinkedList
		while(count < limit) {
			
			//If the desired index has been reached return the element
			//of the desired index
			if(count == index) {
				return temp.getElement();
			}
			
			//If the condition is not satisfied continue iterating
			temp = temp.getNext();
			
			//Increase the counter
			count++;
		}
		
		//If the desired index is at the end of the LinkedList
		//return the last element
		return temp.getElement();
	}
	
	/*
	 * Finds the index of the element of type E
	 * 
	 * @param element : element of type E
	 * 
	 * @return index
	 */
	public int indexOf(E element) {
		
		//Establish a pointer to the head of the LinkedList
		Node<E> temp = this.head;
		
		//A counter used to keep track of the current
		//location in the LinkedList
		int count = 0;
		
		//Establish a limit to the iterator it must not access elements
		//beyond the scope of the LinkedList
		int limit = this.size;
		
		//Iterate through the LinkedList
		while(count < limit) {
			
			//If the desired element in the LinkedList is reached
			//return the index of that element
			if(temp.getElement() == element) {
				return count;
			}
			
			//If the condition is not satisfied continue iterating
			temp = temp.getNext();
			
			//Increase the counter
			count++;
		}
		
		//Return -1 the desired element is not found
		return -1;
	}
	
	/*
	 * Finds the last index of the element of type E
	 * 
	 * @param element : element of type E
	 * 
	 * @return index
	 */
	public int lastIndexOf(E element) {
		
		//Establish a pointer to the head of the LinkedList
		Node<E> temp = this.head;
		
		//A counter used to keep track of the current
		//location in the LinkedList
		int count = 0;
		
		//Establish a limit to the iterator it must not access elements
		//beyond the scope of the LinkedList
		int limit = this.size;
		
		//Initialize the index to be -1 in case the element is not found
		int index = -1;
		
		//Iterate though the LinkedList
		while(count < limit) {
			
			//If the desired element in the LinkedList is reached
			//return the index of that element
			if(temp.getElement() == element) {
				index = count;
			}
			
			//If the condition is not satisfied continue iterating
			temp = temp.getNext();
			
			//Increase the counter
			count++;
		}
		
		//Return the index
		return index;
	}
	
	/*
	 * Removes node from the list at index
	 * 
	 * @param index : index of the node
	 * 
	 * @return boolean
	 */
	public Node<E> remove(int index) {
		
		//Establish a pointer to the head Node
		Node<E> temp = this.head;
		
		//A temporary Node used to get the rest of
		//the list when inserting a Node in the middle
		//of the LinkedList
		Node<E> temp2= null;
		
		//Node to be returned at desired index
		Node<E> ret  = null;
		
		//A counter used to keep track of the current
		//location in the LinkedList
		int count = 0;
		
		//Establish a limit to the iterator it must not access elements
		//beyond the scope of the LinkedList
		int limit = this.size - 1;
		
		//If the desired index is 0 return the head of the LinkedList
		//make sure the rest of the LinkedList is not removed
		if(index == 0) {
			ret = this.head;
			this.head = this.head.getNext();
			this.size--;
			return ret;
		}
		
		//Iterate through the LinkedList
		while(count < limit) {
			
			//If the desired index is reached grab the Node
			//at the index of interest and make sure the rest
			//of the LinkedList is not removed
			if(count == index) {
				ret = temp;
				temp2 = temp.getNext().getNext();
				temp.setNext(temp2);
				this.size--;
				return temp;
			}
			temp = temp.getNext();
			count++;
		}
		
		//If the count has reached the limit return the last element
		//of the LinkedList
		if(count == limit) {
			ret = temp;
			temp.setNext(null);
			this.size--;
			return ret;
		}
		return null;
	}
	
	/*
	 * Removes the instance of the element of type E
	 * 
	 * @param element : element to be removed if it is contained
	 * 
	 * @return boolean
	 */
	public Node<E> remove(E element) {
		int index = indexOf(element);
		return (index == -1) ? null:remove(index);
	}
	
	/*
	 * Print the elements of the LinkedList
	 * 
	 * @param printer : FileWriter used to print
	 * to a file
	 * 
	 * @return void
	 */
	public void printList(FileWriter printer) {
		try {
			
			//Iterate through the LinkedList
			for(int i = 0; i < this.size; i++) {
				
				//Write to the FileWriter buffer the contents of the
				//current Node along with an arrow to show the two elements
				//are joined together
				printer.write(this.get(i).toString() + " -> ");
			}
			
			//Make sure a new line character is written to a file in order
			//to ensure a new print is on another line
			printer.write("\n");
			
			//Flush the buffer to the file
			printer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Print the elements of the LinkedList
	 * to Standard output
	 * @return void
	 */
	public void printList2() {
		
		//Iterate through the LinkedList
		for(int i = 0; i < this.size; i++) {
			
			//Print the contents of the current Node to Standard
			//output
			System.out.print(this.get(i).toString() + " -> ");
		}
		
		//Make sure a new line character is written to a file in order
		//to ensure a new print is on another line
		System.out.println();
	}
	
	//Debugging main method: This was only used to debug LinkedList
//	public static void main(String[] args) {
//		
//		LinkedList<String> llist= new LinkedList<String>();
//		System.out.println("Size -> " + llist.size());
//		llist.add("Hello");
//		System.out.println(llist.get(0));
//		System.out.println("Size -> " + llist.size());
//		llist.remove(0);
//		System.out.println("Size -> " + llist.size());
//		llist.add("World");
//		llist.add("My");
//		llist.add("Name");
//		llist.add("Is");
//		llist.add("Ian");
//		llist.printList();
//		LinkedList<String> list = new LinkedList<String>("Brooo");
//		
//		llist.add("New");
//		llist.add("Linked");
//		llist.add("List");
//		
//		llist.printList();
//		
//		System.out.println("Removed Element -> " + llist.remove(0).getElement());
//		System.out.println();
//		llist.printList();
//		
//		/*list.add("Hello");
//		list.add("World");
//		list.add(0,"Yo!");
//		//list.printList();
//		list.add("Bro");
//		
//		list.printList();
//		
//		System.out.println("\n");
//		
//		System.out.println(list.get(1));
//		System.out.println(list.get(list.indexOf("World")));
//		System.out.println(list.get(5));*/
//		
//		/*System.out.println("Index of Bro -> " + list.indexOf("Bro"));
//		
//		list.remove("Bro");
//		
//		list.printList();
//		
//		System.out.println("Index of Yo! -> " + list.indexOf("Yo!"));
//		
//		list.remove("Yo!");
//		
//		list.printList();*/
//		
//		/*System.out.println(list.contains("Hello"));
//		System.out.println(list.contains("Ian"));
//		
//		list.printList();
//		
//		System.out.println(list.indexOf("Hello"));
//		
//		System.out.println(list.remove(1));
//		
//		//System.out.println();
//		
//		list.printList();
//		
//		System.out.println(list.remove("Bro"));
//		
//		list.printList();*/
//		
//	}

}
