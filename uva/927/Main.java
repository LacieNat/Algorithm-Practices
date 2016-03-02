import java.util.*;
import java.io.*;

public class Main {
	public static int tc;
	public static int k;
	public static int d;
	public static ArrayList<Integer> coeff;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.parseInt(st.nextToken());
		coeff = new ArrayList<Integer>();
		
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			coeff.clear();
			st.nextToken();
			while(st.hasMoreTokens()) {
				coeff.add(Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			int n = 0;
			int count = 0;

			while(count<k) {
				n++;
				count += n*d;			
			}

			pw.println(compute(n));
		}

		pw.close();
	}
	public static long compute(int n) {
		long a = 0;
		
		for(int i=0; i<coeff.size(); i++) {
			a+= ((long) coeff.get(i))*Math.pow(n, i);
		}

		return a;
	}
	
}