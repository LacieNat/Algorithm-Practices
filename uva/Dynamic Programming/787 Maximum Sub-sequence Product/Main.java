import java.util.*;
import java.math.*;
import java.io.*;

public class Main {

	static BigInteger[][] dp = new BigInteger[100][100];
	static boolean[][] isTraversed = new boolean[100][100];
	static int[] arr = new int[100]; 

	private static BigInteger maxPdt(int i, int j) {
	
		if(isTraversed[i][j]) return dp[i][j];
		isTraversed[i][j] = true;
		if(i==j) {
			dp[i][j] = new BigInteger(Integer.toString(arr[i]));
			return dp[i][j];
		}

		if(i>j) {
			dp[i][j] = maxPdt(j, i);
			return dp[i][j];
		}

		dp[i][j] = maxPdt(i, j-1).multiply(maxPdt(j,j));
		return dp[i][j];

	}

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String s;
		while((s = br.readLine())!=null) {
			for(boolean row[]: isTraversed) Arrays.fill(row, false);
			
			String[] strarr = s.split(" ");

			for(int i=0; i<strarr.length-1; i++) {
				
				arr[i] = Integer.parseInt(strarr[i]);
				//pw.print(arr[i]);
			}

			for(int i=0; i<strarr.length-1; i++) {
				for(int j=i; j<strarr.length-1; j++) {
					if(!isTraversed[i][j]) maxPdt(i, j);
				}
			}
			
			BigInteger res = dp[0][0];
			//pw.println(res.toString());
			for(int j=0; j<strarr.length-1; j++) {
				for(int k=j; k<strarr.length-1; k++) {
					res = dp[j][k].max(res);
					//pw.print(dp[j][k].toString());
				}
				//pw.println();
			}
			//pw.println();
			pw.println(res.toString());

			
		}

		pw.close();
	}


}
