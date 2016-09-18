import java.util.*;
import java.io.*;

public class Main {
	
	public static class Graph {
		ArrayList<ArrayList<Integer>> edges;
		boolean[] vertices;
		boolean[] traversed;
		int[] trees;

		public Graph() {
			edges = new ArrayList<ArrayList<Integer>>();
			vertices = new boolean[26];
			traversed = new boolean[26];

			for(int i=0; i<26; i++) {
				edges.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int src, int dst) {
			edges.get(src).add(dst);
			edges.get(dst).add(src);
		}

		public void addVertice(int v) {
			vertices[v] = true;
		}

		public int[] findTreesAndAcorns() {
			trees = new int[26];
			
			int count = 0;
			for(int i=0; i<26; i++) {
				
				if(trees[i]==0 && vertices[i]) {
					count++;
					dfs(i, count);
					trees[i] = count;
				}
			}

			int[] ans = new int[2];
			int max = -1;
			
			for(int i=0; i<26; i++) {
				if (edges.get(i).size() == 0 && vertices[i]) {
					ans[1]++;
				}

				if(trees[i]>max) {
					max = trees[i];
				}
			}

			ans[0] = max - ans[1];

			return ans;
		}

		public void dfs(int v, int mark) {
			ArrayList<Integer> adj = edges.get(v);
			traversed[v] = true;

			for(int i=0; i<adj.size(); i++) {
				int adjv = adj.get(i);
				
				if(!traversed[adjv]) {
					trees[adjv] = mark;
					dfs(adjv, mark);
				}
			}
		}
		
		public void printVertices() {
			System.out.println("PRINTING VERTICES");

			for(int i=0; i<vertices.length; i++) {
				System.out.print(vertices[i] + " ");
			}
			System.out.println();
		}

		public void printEdges() {
			for(int i=0; i<edges.size(); i++) {
				if(vertices[i]) {
					System.out.print(i+ ": ");
					ArrayList<Integer> a = edges.get(i);
					for(int j=0; j<a.size(); j++) {
						System.out.print(a.get(j));
					}
					System.out.println();
				}
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String e;
		StringTokenizer st;

		for(int i=0; i<n; i++) {
			Graph g = new Graph();
			
			while((e = br.readLine()).charAt(0) != '*') {
				g.addEdge(e.charAt(1)-'A', e.charAt(3)-'A');
			}
			
			st = new StringTokenizer(br.readLine(), ",");
			
			while(st.hasMoreTokens()) {
				g.addVertice(st.nextToken().charAt(0)-'A');
			}
						
			int[] ans = g.findTreesAndAcorns();

			pw.println("There are " + ans[0] + " tree(s) and " + ans[1] + " acorn(s).");			
		}

		pw.close();
	}
}
