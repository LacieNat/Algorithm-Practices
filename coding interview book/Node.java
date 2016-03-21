import java.util.Queue;
import java.util.LinkedList;
//TREE IMPLEMENTATION
public class Node {
	public int data;
	public Node leftChild;
	public Node rightChild;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(4);
		Node n2 = new Node(2);
		Node n3 = new Node(7);
		Node n4 = new Node(1);
		Node n5 = new Node(3);
		Node n6 = new Node(6);
		Node n7 = new Node(8);
		
		n3.leftChild = n6;
		n3.rightChild = n7;
		n2.leftChild = n4;
		n2.rightChild = n5;
		n1.leftChild = n2;
		n1.rightChild = n3;
		
		insert(5, n1);
		insert(9, n1);
		
		inOrderTraversal(n1);
		System.out.println();
		preOrderTraversal(n1);
		System.out.println();
		postOrderTraversal(n1);
		System.out.println();
		levelOrderTraversal(n1);
		
	}
	
	//insert function for binary search tree
	public static void insert(int val, Node n) {
		
		if(val > n.data) {
			if(n.rightChild == null) {
				n.rightChild = new Node(val);
				return;
			} else {
				insert(val, n.rightChild);
			}
		}
		
		if(val < n.data) {
			if(n.leftChild == null) {
				n.leftChild = new Node(val);
				return;
			} else {
				insert(val, n.leftChild);
			}
		}
	}
	
	public static void levelOrderTraversal(Node n) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(n);
		levelOrderTraversalHelper(q);
	}
	
	//Use a queue to implement level order
	public static void levelOrderTraversalHelper(Queue<Node> q) {
		if(q.isEmpty()) {
			return;
		}
		Node n = q.poll();
		System.out.print(n.data);
		
		if(n.leftChild!=null) {
			q.offer(n.leftChild);
		}
		
		if(n.rightChild!=null) {
			q.offer(n.rightChild);
		}
		
		levelOrderTraversalHelper(q);
	}
	
	//traverse left subtree
	//visit the root
	//traverse the right subtree
	//in binary search trees in order traversal gives non-decreasing order
	public static void inOrderTraversal(Node n) {
		if(n.leftChild == null && n.rightChild == null ) {
			System.out.print(n.data);
			return;
		}
		
		if(n.leftChild !=null) {
			inOrderTraversal(n.leftChild);
		}
		
		System.out.print(n.data);
		
		if(n.rightChild!=null) {
			inOrderTraversal(n.rightChild);
		}
	}
	
	//traverse left subtree
	//traverse right subtree
	//visit the root
	//used to delete the tree
	public static void postOrderTraversal(Node n) {
		if(n.leftChild == null && n.rightChild == null) {
			System.out.print(n.data);
			return;
		}
		
		if(n.leftChild != null) {
			postOrderTraversal(n.leftChild);
		}
		
		if(n.rightChild != null ) {
			postOrderTraversal(n.rightChild);
		}

		System.out.print(n.data);
	}
	
	//visit the root
	//traverse left subtree
	//traverse right subtree
	//used to get prefix expression on of an expression tree
	public static void preOrderTraversal(Node n) {
		if(n.leftChild == null && n.rightChild == null) {
			System.out.print(n.data);
			return;
		}
		
		System.out.print(n.data);
		
		if(n.leftChild != null) {
			preOrderTraversal(n.leftChild);
		}
		
		if(n.rightChild != null ) {
			preOrderTraversal(n.rightChild);
		}
	}
}
