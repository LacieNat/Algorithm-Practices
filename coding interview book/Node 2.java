import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
public class Node {
	public int data;
	public ArrayList<Node> children;
	
	public static void main(String args[]) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		n1.children.add(n10);
		
		n3.children.add(n5);
		
		n4.children.add(n6);
		n4.children.add(n9);
		
		n6.children.add(n7);
		n6.children.add(n8);
		
		n10.children.add(n11);
		
		//System.out.println(depthFirstSearch(n1, 11));
		//System.out.println(breadthFirstSearch(n1, 20));
		System.out.println(isBalanced(n1));
	}
	
	public Node(int data) {
		this.data = data;
		children = new ArrayList<Node>();
	}
	
	public boolean addChild(Node c) {
		//arraylist add returns boolean value
		return children.add(c);
	}
	
	public static boolean breadthFirstSearch(Node n, int data) {
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean> ();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(n);
		hm.put(n.data, true);
		if(n.data == data) {
			return true;
		}
		
		return bfsHelper(data, hm, q);

	}
	//O(|V| + |E|)
	public static boolean bfsHelper(int data, HashMap<Integer, Boolean> hm, Queue<Node> q) {
		
		if(q.isEmpty()) {
			return false;
		}
		
		Node curr = q.poll();
		System.out.print(curr.data);
		ArrayList<Node> children = curr.children;
		
		for(Node child: children) {
			if(child.data == data) {
				return true;
			}
			if(!hm.containsKey(child.data)){
				q.offer(child);	
			}
		}
		
		return bfsHelper(data, hm, q);
	}
	
	//ASSUMPTION: all nodes are distinct
	//This method uses recursion
	//Method 2: can be implemented using a stack
	//O(|V| + |E|)
	public static boolean depthFirstSearch(Node n, int data) {
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
	
		return dfsHelper(n, data, hm);
	}
	
	public static boolean dfsHelper(Node n, int data, HashMap<Integer, Boolean> hm) {
		ArrayList<Node> children = n.children;
		boolean flag = false;
		for(Node child: children) {
			if(flag) {
				return true;
			}
			
			System.out.print(child.data);
			
			if(hm.containsKey(child.data)) {
				continue;
			}else if(child.data == data){
				return true;
			} else {
				hm.put(child.data, true);
				flag = dfsHelper(child, data, hm);
			}
		}
		
		return flag;
	}
	
	//Assuming distinct data and no loop
	//If tree is binary, do max(leftsubtreeheight,rightsubtreeheight) - min(leftsubtreeheight, rightsubtreeheight) 
	public static boolean isBalanced(Node n) {
		ArrayList<Integer> minAndMax = new ArrayList<Integer>();
		minAndMax.add(Integer.MAX_VALUE);
		minAndMax.add(Integer.MIN_VALUE);
		
		isBalancedHelper(n, minAndMax, 1);
		return minAndMax.get(1) - minAndMax.get(0) < 2;
	}
	
	public static ArrayList<Integer> isBalancedHelper(Node n, ArrayList<Integer> minAndMax, int curr) {


		if(n.children.isEmpty()) {
			System.out.println(n.data + " " + curr);
			if(curr<minAndMax.get(0)) {
				minAndMax.set(0, curr);
			} else if(curr > minAndMax.get(1)) {
				minAndMax.set(1, curr);
			}
			
		} else {
			ArrayList<Node> children = n.children;
			curr = curr+1;
			for(Node child: children) {
				
				isBalancedHelper(child, minAndMax, curr);
			}
		}
		
		return minAndMax;
	}
}
