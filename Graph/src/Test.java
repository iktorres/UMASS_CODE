import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Test {
	
	public static void main(String[] args) {
		ArrayList<LinkedList<Tuple<Integer,Integer>>> graph = new ArrayList<LinkedList<Tuple<Integer,Integer>>>();
		graph.add(new LinkedList<Tuple<Integer,Integer>>());
		graph.add(new LinkedList<Tuple<Integer,Integer>>());
		graph.add(new LinkedList<Tuple<Integer,Integer>>());
		graph.add(new LinkedList<Tuple<Integer,Integer>>());
		graph.get(0).add(new Tuple<Integer,Integer>(1,0));
		graph.get(0).add(new Tuple<Integer,Integer>(2,0));
		graph.get(0).add(new Tuple<Integer,Integer>(3,0));
		graph.get(0).add(new Tuple<Integer,Integer>(4,0));
		System.out.println(graph.get(0).contains(new Tuple<Integer,Integer>(2,0)));
	}
	
}
