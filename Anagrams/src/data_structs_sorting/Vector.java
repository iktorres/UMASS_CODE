package data_structs_sorting;

@SuppressWarnings("unchecked")
public class Vector<E> {

	private E[] table = (E[])new Object[7000000];
	private E[] kline;
	public Vector() {
		
	}
	
	public Vector(E[] array) {
		initVector(array);
	}
	
	public E get(int index) {
		if(index >= this.table.length)
			throw new IndexOutOfBoundsException("Index out of Bounds");
		return this.table[index];
	}
	
	public void set(int index,E obj) {
		if(index >= this.table.length) {
			this.dArray();
		}
		this.table[index] = obj;
	}
	
	public int size() {
		return this.table.length;
	}
	
	public int indexOf(E obj) {
		int length = this.table.length;
		for(int i = 0; i < length; i++) {
			if(this.table[i] == obj) {
				return i;
			}
		}
		return -1;
	}
	
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
	
	private void dArray() {
		int length = this.table.length;
		kline = (E[])new Object[length*2];
		for(int i = 0; i < length; i++) {
			kline[i] = table[i];
		}
		table = kline;
	}
	
}
