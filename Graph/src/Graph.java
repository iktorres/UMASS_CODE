import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	
	private ArrayList<LinkedList<Tuple<Integer,Integer>>> graph = new ArrayList<LinkedList<Tuple<Integer,Integer>>>();
	public Graph() {
		
	}
	
	public void initializeSize(int size) {
		this.graph.add(0,(new LinkedList<Tuple<Integer,Integer>>()));
		for(int i = 1; i < size + 1; i++) {
			this.graph.add(new LinkedList<Tuple<Integer,Integer>>(new Tuple<Integer,Integer>(i,0)));
		}
	}
	
	public int getSize() {
		return this.graph.size();
	}
	
	public void initialize(Scanner wiz) {
		int row      = 0;
		int col      = 0;
		String line  = wiz.nextLine();
		String arr[] = null;
		int size = Integer.parseInt(line.trim());
		initializeSize(size);
		
		while(wiz.hasNextLine()) {
			line = wiz.nextLine();
			arr  = line.split(" ");
			row  = Integer.parseInt(arr[0].trim());
			col  = Integer.parseInt(arr[1].trim());
			//System.out.println("(row,col) -> (" + row + " , " + col + ")");
			graph.get(row).add(new Tuple<Integer,Integer>(col,2));
		}
		for(int i = 1; i < this.graph.size(); i++) {
			for(int j = 1; j < this.graph.get(i).size(); j++) {
				if(!(this.graph.get(this.graph.get(i).get(j).getLeft()).contains(new Tuple<Integer,Integer>(i,2))))
					this.graph.get(this.graph.get(i).get(j).getLeft()).add(new Tuple<Integer,Integer>(i,2));
			}
		}
	}
	
	public boolean color() {
		this.graph.get(1).get(0).setRight(0);
		int temp  = 0;
		int temp2 = 0;
		int temp3 = 0;
		int comp1 = 0;
		for(int i = 1; i < this.graph.size(); i++) {
			temp = this.graph.get(i).get(0).getRight();
			for(int k = 1; k < this.graph.get(i).size(); k++) {
				if(temp == 0)
					this.graph.get(i).get(k).setRight(1);
				else
					this.graph.get(i).get(k).setRight(0);
				temp2 = this.graph.get(i).get(k).getRight();
				temp3 = this.graph.get(i).get(k).getLeft();
				this.graph.get(temp3).get(0).setRight(temp2);
			}
		}
		for(int i = 0; i < this.graph.size(); i++) {
			for(int j = 0; j < this.graph.get(i).size(); j++) {
				comp1 = this.graph.get(i).get(j).getLeft();
				if(this.graph.get(comp1).get(0).getRight() != this.graph.get(i).get(j).getRight()) {
					cycle(comp1);
					return false;
				}
			}
		}
		return true;
	}
	
	public void cycle(int fail) {
		System.out.println(fail);
	}
	
	public void printGraph() {
		for(int i = 0; i < graph.size(); i++) {
			System.out.print(i + " :-> ");
			graph.get(i).printList2();
		}
	}
	
	public static void main(String[] args) {
		try {
			//File file   = new File("./src/smallgraph");
			//File file = new File("./src/fail.txt");
			//File file   = new File("./src/pass.txt");
			File file   = new File("./src/fail2.txt");
			Scanner wiz = new Scanner(file);
			Graph minen = new Graph();
			minen.initialize(wiz);
			System.out.println("Eval -> " + minen.color());
			minen.printGraph();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
