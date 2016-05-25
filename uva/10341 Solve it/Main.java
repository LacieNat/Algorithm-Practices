import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {

	public static int p,q,r,s,t,u;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String str;

		while((str=br.readLine())!=null) {
			st = new StringTokenizer(str);
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());

			double ans = search(0,1);
			if(ans!=-2) pw.println(String.format("%1$.4f", ans));
			else pw.println("No solution");
			
		}

		pw.close();
	}

	public static double calculateWithX(double x) {
		return p*Math.pow(Math.E, -x) + q*Math.sin(x) + r*Math.cos(x) + s*Math.tan(x) + t*x*x + u;
	}

	public static double search(double localMin, double localMax) {
		if (localMin>=localMax) {
			return -2;
		}
		double mid = (localMax+localMin)/2;
		double ans = Double.parseDouble(String.format("%1$.6f",calculateWithX(mid)));
		//System.out.println(ans);
		//double ans = calculateWithX(mid);
		if(ans == 0) return mid;
		else if(ans>0) return search(mid, localMax);
		else return search(localMin, mid);
	}
}
