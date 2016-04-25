import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Test {
	
	public static void main(String[] args) {
		ArrayList<LinkedList<Tuple<Integer,Integer>>> list = new ArrayList<LinkedList<Tuple<Integer,Integer>>>(Collections.nCopies(10, new LinkedList<Tuple<Integer,Integer>>(new Tuple<Integer,Integer>(0,0))));
		list.add(0,new LinkedList<Tuple<Integer,Integer>>(new Tuple(1,1)));
		list.get(0).printList2();
		list.get(0).add(new Tuple<Integer,Integer>(2,1));
		list.get(2).add(new Tuple<Integer,Integer>(5,1));
		list.get(0).printList2();
		list.get(2).printList2();
		list.get(0).add(new Tuple<Integer,Integer>(44,1));
		list.get(2).add(new Tuple<Integer,Integer>(33,1));
		System.out.println("/////////////////////////////");
		list.get(0).printList2();
		list.get(2).printList2();
	}
	
}
