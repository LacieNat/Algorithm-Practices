import java.util.*;
import java.io.*;


public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		int[] coins = new int[1000];

		for(int i=0; i<tc; i++) {
			int numC = Integer.parseInt(br.readLine());
			int sum = 0;
			int count = 1;
			st = new StringTokenizer(br.readLine());

			for(int j=0; j<numC; j++) {
				coins[j] = Integer.parseInt(st.nextToken());
			}
		
			for(int j=0; j<numC-1; j++) {
				int curr = coins[j];
				if(sum+curr < coins[j+1]) {sum+=curr; count++;}	
			}
			

			pw.println(count);
		}
		
		pw.close();
	}
	
}
