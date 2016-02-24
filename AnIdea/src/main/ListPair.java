package main;


import java.util.ArrayList;

public class ListPair<E,R> {
	
	/**
	 * 
	 */
	
	private E string;
	private R index;
	

	public ListPair(E string, R index) {
		this.string = string;
		this.index = index;
	}
	
	public E getLeft() {
		return this.string;
	}
	
	public R getRight() {
		return this.index;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<ListPair> sortListPair(ArrayList<ListPair> myList) {
		ListPair<String,Integer> temp = new ListPair<String,Integer>("",0);
		for(int i = 0; i < myList.size(); i++) {
			for(int j = 1+i; j < myList.size(); j++) {
				int first = (int) myList.get(i).getRight();
				int second = (int) myList.get(j).getRight();
			
				if(first < second) {
					//System.out.println("first-> " + first + " , " + "second-> " + second);
					temp = myList.get(i);
					myList.set(i, myList.get(j));
					myList.set(j, temp);
				}
				
			}
			
		}
		return myList;
	}
	
	public String toString() {
		return (((String) getLeft() + " , " + getRight()));
	}
	
	
//	public static void main(String[] args) {
//		ListPair<String,Integer> temp = new ListPair<String,Integer>("",0);
//		
//		ListPair<String,Integer> myListPair = new ListPair<String,Integer>("one",1);
//		ListPair<String,Integer> myListPair2 = new ListPair<String,Integer>("three",3);
//		ListPair<String,Integer> myListPair3 = new ListPair<String,Integer>("two",2);
//		ListPair<String,Integer> myListPair4 = new ListPair<String,Integer>("five",5);
//		
//		ArrayList<ListPair> myArrayListPair = new ArrayList<ListPair>();
//		
//		myArrayListPair.add(myListPair);
//		myArrayListPair.add(myListPair2);
//		myArrayListPair.add(myListPair3);
//		myArrayListPair.add(myListPair4);
//		
//		System.out.println(myListPair.getLeft());
//		System.out.println(myListPair.getRight());
//		
//		
//		//System.out.println("My List -> " + myArrayListPair.get(0).getLeft() + " , " + myArrayListPair.get(0).getRight());
//		
//		for(int i = 0; i < myArrayListPair.size(); i++) {
//			for(int j = 1+i; j < myArrayListPair.size(); j++) {
//				int first = (int) myArrayListPair.get(i).getRight();
//				int second = (int) myArrayListPair.get(j).getRight();
//			
//				if(first < second) {
//					System.out.println("first-> " + first + " , " + "second-> " + second);
//					temp = myArrayListPair.get(i);
//					myArrayListPair.set(i, myArrayListPair.get(j));
//					myArrayListPair.set(j, temp);
//				}
//				
//			}
//			
//		}
//		for(int i = 0; i < myArrayListPair.size(); i++) {
//			System.out.println(myArrayListPair.get(i));
//		}
//	}

}
