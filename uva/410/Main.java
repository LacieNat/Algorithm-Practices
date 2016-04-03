import java.io.*;
import java.util.*;


//STATION BALANCE
public class Main {
	public static int c,s,count;
	public static int[] specArr;
    public static int[][] chambers;
	public static double avg; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw  = new PrintWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer st;
		count = 1;
		while(input != null) {
			st = new StringTokenizer(input);
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			specArr = new int[c*2];
			chambers = new int[c][2];
			int sumOfSpec = 0;

			for(int i=0; i<s; i++){
				specArr[i] = Integer.parseInt(st.nextToken());
				sumOfSpec+=specArr[i];
			}

			avg = ((double) sumOfSpec)/c;

			if(s<=c) {
				for(int i=0; i<s; i++) {
					chambers[i][0] = specArr[i];
				}
			} else {
				Arrays.sort(specArr);
				for(int i=0; i<c; i++) {
					chambers[i][0] = specArr[(2*c-1)-i];
					chambers[i][1] = specArr[i];
				}
			}

			printResults(pw);

			input = br.readLine();
			// if(input!=null) {
			 	pw.println();
			// }
			count++;
		}

		pw.close();
	}

	public static double imb() {
		double imbalance=0;
		for(int i=0; i<chambers.length; i++) {
			int sum = 0;
			for(int j=0; j<2; j++) {
				sum+=chambers[i][j];
			}
			imbalance += Math.abs(sum-avg);
		}
		return imbalance;
	}

	public static void printResults(PrintWriter pw) throws IOException {
		pw.println("Set #" + count);
		for(int i=0; i<chambers.length; i++) {
			pw.print(" "+ i + ":");
			for(int j=0; j<2; j++) {
				if(chambers[i][j]!=0)
				pw.print(" " + chambers[i][j]);
			}
			pw.println();
		}
		pw.printf("IMBALANCE = %.5f", imb());
		pw.println();
	}
}