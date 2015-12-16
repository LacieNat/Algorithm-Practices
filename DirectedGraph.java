/*
 * Directed Graph can be implemented with adjacency list or adjacency matrix
 * 
 * Adjacency list comprises an array or list of vertices, 
 * where each vertex vi stores a list of all the vertices vj for which there is an edge (vi, vj) element of E
 * Space Complexity: O(V + E)
 * 
 * Adjacency matrix is a two dimensional array, where Aij is non-zero when there is an edge(vi, vj) element of E
 * Space Complexity: O(V^2)
 * 
 * Some terms:
 * Directed Acyclic Graph(DAG)
 * Directed graph that has no cycle
 * 
 * For this particular class, adjacency list is used
 */

import java.util.Vector;
import java.util.HashMap;
public class DirectedGraph {
	public class IntegerPair {
		public int neighbor;
		public int weight;
		
		public IntegerPair(int neighbor, int weight) {
			this.neighbor = neighbor;
			this.weight = weight;
		}
		
		public IntegerPair(int neighbor) {
			this.neighbor = neighbor;
			this.weight = 1;
		}
	}
	
	public HashMap<Integer, Vector<IntegerPair>> list;
	
	public static void main(String[] args) {
		DirectedGraph dg = new DirectedGraph();
		HashMap<Integer, Vector<IntegerPair>> list = dg.list;
		
		
	}
	
	public DirectedGraph() {
		list = new HashMap<Integer, Vector<IntegerPair>>();
	}
	
	public boolean isPathExist(int v1, int v2) {
		
		return true;
	}
}


