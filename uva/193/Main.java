import java.util.*;
import java.io.*;

//Graph Coloring
public class Main {
	public static boolean[][] graph;
	public static int tc,v,e, minWhite;
	public static int[] chosen, color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.parseInt(st.nextToken());

		while(tc>0) {
			st = new StringTokenizer(br.readLine());
			minWhite = v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			build(br);
			color = new int[v+1];
			chosen = new int[v+1];

			dfs(1, 0);
			pw.println(v-minWhite);
			printChosen(pw);
			tc--;
		}
		pw.close();
	}

	public static void build(BufferedReader br)throws IOException {
		graph = new boolean[v+1][v+1];

		for(int i=0; i<e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = graph[to][from] = true;
		}
	}


	public static void dfs(int index, int white) {
		if(index>v) {
			if (white<minWhite) {
				minWhite = white;
				chosen = color.clone();
			}
		} else {
			boolean colorBlack = true;
			for(int i=0; i<graph.length; i++) {
				if(graph[index][i]) {
					colorBlack = colorBlack && color[i]!=2;
				}
			}

			if(colorBlack) {
				color[index] = 2;
				dfs(index+1, white);
			}
			color[index] = 1;
			dfs(index+1, white+1);
			color[index] = 0;
		}
	}

	public static void printChosen(PrintWriter pw) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<chosen.length; i++) {
			if(chosen[i] == 2){
				sb.append(i+" ");
			}
		}
		pw.println(sb.substring(0, sb.length()-1));
	}
}