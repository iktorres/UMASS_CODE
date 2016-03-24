package data_structs_sorting;

@SuppressWarnings("unchecked")
public class Vector<E> {

	//An array of generic objects
	private E[] table = (E[])new Object[7000000];
	
	//Intermediate array for copying contents of the
	//original array when size must be doubled for table
	private E[] kline;
	
	/*
	 * Default constructor for Vector
	 */
	public Vector() {
		
	}
	
	/*
	 * Constructor for Vector
	 * 
	 * @param array: array to be copied into Vector
	 * 
	 */
	public Vector(E[] array) {
		initVector(array);
	}
	
	/*
	 * Used to get the contents of the array at the desired index
	 * 
	 * @param index: index of desired element
	 * 
	 */
	public E get(int index) {
		
		//If an index is trying to be accessed outside the bounds of the array
		//throw an IndexOutOfBoundsException
		if(index >= this.table.length)
			throw new IndexOutOfBoundsException("Index out of Bounds");
		
		//Return the contents of the array at the desired index
		return this.table[index];
	}
	
	/*
	 * Used to set the contents of the array at the desired index
	 * with an object E
	 * 
	 * @param index: index of desired array location
	 * 
	 * @param obj  : object used to initialize location of the array
	 * 
	 */
	public void set(int index,E obj) {
		
		//If the index is beyond the scope of the array double the size
		//of the Vector
		if(index >= this.table.length) {
			this.dArray();
		}
		
		//Initialize the location of the array at the given index with the
		//desired object
		this.table[index] = obj;
	}
	
	/*
	 * Used to get the size of the Vector
	 * 
	 * @return size
	 * 
	 */
	public int size() {
		return this.table.length;
	}
	
	/*
	 * Return the indexOf the desired object
	 * 
	 * @param obj: object of type E to be found
	 * 
	 */
	public int indexOf(E obj) {
		
		//Establish the length of the array
		int length = this.table.length;
		
		//Iterate through the array
		for(int i = 0; i < length; i++) {
			
			//If the desired object is found return the index
			if(this.table[i] == obj) {
				return i;
			}
		}
		
		//If the object is not found return -1
		return -1;
	}
	
	/*
	 * Used to initialize the array of Vector
	 * 
	 * This method cannot be accessed by anything
	 * outside of this class since there is no
	 * reason to do so
	 * 
	 */
	private void initVector(E[] array) {
		int length = array.length;
		int tlength= table.length;
		int klength= kline.length;
		if(length <= tlength) {
			for(int i = 0; i < length; i++) {
				table[i] = array[i];
			}
		}else {
			int count = 0;
			this.kline = (E[])new Object[table.length+array.length];
			for(int i = 0; i < tlength; i++) {
				kline[i] = table[i];
			}
			for(int i = tlength; i < klength; i++) {
				kline[i] = array[count];
				count++;
			}
			this.table = this.kline;
		}
	}
	
	/*
	 * Used to double the size of the array in Vector
	 * 
	 * This method cannot be accessed by anything
	 * outside of this class since there is no
	 * reason to do so
	 * 
	 */
	private void dArray() {
		int length = this.table.length;
		kline = (E[])new Object[length*2];
		for(int i = 0; i < length; i++) {
			kline[i] = table[i];
		}
		table = kline;
	}
	
}
