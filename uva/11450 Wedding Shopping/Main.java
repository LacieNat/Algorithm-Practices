import java.util.*;
import java.io.*;

public class Main {
	private static boolean[][] memo;
	public static int tc;
	public static int budget;
	public static int numGarments;
	public static int[][] prices;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		tc = Integer.parseInt(br.readLine());

		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			budget = Integer.parseInt(st.nextToken());
			numGarments = Integer.parseInt(st.nextToken());
	        prices = new int[20][21];		

			for(int j=0; j<numGarments; j++) {
				st = new StringTokenizer(br.readLine());	
				int index = 0;
				while(st.hasMoreTokens()) {
					prices[j][index] = Integer.parseInt(st.nextToken());
					index++;
				}
			}
			
			memo = new boolean[20][201];

			for(int k=0; k<numGarments; k++) {
				int size = prices[k][0];
				
				if(k==0) {
					for(int j=1; j<=size; j++) {
						if(budget-prices[k][j]>=0)
							memo[k][budget-prices[k][j]] = true;
					}
				} else {
					for(int h=0; h<201; h++) {
						for(int g=1; g<=size; g++) {
							if(memo[k-1][h] && h-prices[k][g]>=0) {
								memo[k][h-prices[k][g]] = true;
							}
						}
					}
				}
			}
			
			int ans = -1;
			for(int k=0; k<201; k++) {
				if (memo[numGarments-1][k]) {
					ans = budget-k;
					break;
				}
			}

			if(ans==-1)
				pw.println("no solution");
			else
				pw.println(ans);
		
		}

		pw.close();
	}
}