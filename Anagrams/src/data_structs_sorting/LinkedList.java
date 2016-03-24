package data_structs_sorting;

//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;

public class LinkedList<E> {
	
	//Initialize as the head of the LinkedList<E>
	private Node<E> head;
	private Node<E> last;
	
	//Size of the LinkedList<E>
	private int     size = 0;
	
	public LinkedList() {
		
	}
	
	/*
	 * LinkedList<E> constructor
	 * 
	 * @param element : element of type E
	 */
	public LinkedList(E element) {
		this.head = new Node<E>(element);
		this.last = this.head;
		this.size = 1;
	}
	
	/*
	 * Add an element to the end of the LinkedList<E>
	 * thought it could be used like this, but was too
	 * slow!
	 * 
	 * @param  element : element of type E to add
	 * 
	 * @return void
	 */
	public void addSlow(E element) {
		Node<E> temp = this.head;
		Node<E> temp2= null;
		int limit    = this.size - 1;
		int count    = 0;
		if(limit < 0) {
			temp2 = this.head;
			this.head = new Node<E>(element);
			this.head.setNext(temp2);
			this.size++;
			return;
		}
		while(count < limit) {
			temp = temp.getNext();
			count++;
		}
		temp.setNext(new Node<E>(element));
		this.size++;
	}
	
	/*
	 * Add an element to the end of the LinkedList<E>
	 * 
	 * @param  element : element of type E to add
	 * 
	 * @return void
	 */
	public void add(E element) {
		if(this.size == 0) {
			this.head = new Node<E>(element);
			this.head.setNext(this.last);
			this.last = this.head;
		}else {
			this.last.setNext(new Node<E>(element));
			this.last = this.last.getNext();
		}
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
		Node<E> temp = this.head;
		Node<E> temp2= null;
		int count = 0;
		if(index < 0) {
			System.err.println("Can't add to list with negative index!");
			return;
		}
		
		if(index == 0) {
			temp2 = this.head;
			this.head = new Node<E>(element);
			this.head.setNext(temp2);
			this.size++;
			return;
		}
		
		while(count < index - 1) {
			temp = temp.getNext();
			count++;
		}
		temp2 = temp.getNext();
		temp.setNext(new Node<E>(element));
		temp.getNext().setNext(temp2);
		this.size++;
	}
	
	public int size() {
		return this.size;
	}
	
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
		/*Node<E> temp = this.head;
		int count = 0;
		int limit = this.size - 1;
		while(count < limit) {
			if(temp.getElement() == element) {
				return true;
			}
			temp = temp.getNext();
			count++;
		}*/
		//return false;
	}
	
	public E get(int index) {
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}
		if(index == 0) {
			return this.head.getElement();
		}
		Node<E> temp = this.head;
		int count = 0;
		int limit = this.size - 1;
		while(count < limit) {
			if(count == index) {
				return temp.getElement();
			}
			temp = temp.getNext();
			count++;
		}
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
		Node<E> temp = this.head;
		int count = 0;
		int limit = this.size;
		while(count < limit) {
			if(temp.getElement() == element) {
				return count;
			}
			temp = temp.getNext();
			count++;
		}
		return -1;
	}
	
	public int lastIndexOf(E element) {
		Node<E> temp = this.head;
		int count = 0;
		int limit = this.size;
		int index = -1;
		while(count < limit) {
			if(temp.getElement() == element) {
				index = count;
			}
			temp = temp.getNext();
			count++;
		}
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
		Node<E> temp = this.head;
		Node<E> temp2= null;
		Node<E> ret  = null;
		int count = 0;
		int limit = this.size - 1;
		
		if(index == 0) {
			ret = this.head;
			this.head = this.head.getNext();
			this.size--;
			return ret;
		}
		
		while(count < limit) {
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
	 * @return void
	 */
	public void printList(FileWriter printer) {
		//FileWriter printer = null;
		try {
			//printer = new FileWriter(".\\src\\output\\"+file,true);
			for(int i = 0; i < this.size; i++) {
				printer.write(this.get(i).toString() + " -> ");
			}
			printer.write("\n");
			printer.flush();
			//printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printList2() {
		for(int i = 0; i < this.size; i++) {
			System.out.print(this.get(i).toString() + " -> ");
		}
		System.out.println();
	}
	
	//Debugging main method
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
