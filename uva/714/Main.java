import java.io.*;
import java.util.*;

public class Main {
	public static int tc, m, k;
	public static long[] pages;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.parseInt(st.nextToken());

		while(tc!=0) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			pages = new long[m];
			long sum = 0;
			for(int i=0; i<m; i++) {
				long p = Long.parseLong(st.nextToken());
				pages[i] = p;
				sum+=p;
			}
			
			long mid = binarySearch(1, sum);
			int[] start = new int[k];
			Arrays.fill(start, -1);

			sum = 0;
			int curr = k-1;

			for(int i=m-1; i>=0; i--) {
				if(sum+pages[i]>mid) {
					start[curr] = i+1;
					sum = 0;
					curr--;
				}
				sum+=pages[i];
			}

			start[curr] = 0;

			int top = 0;
			for(int i=0; i<start.length; i++) {
				if(start[i]==-1) {
					start[i] = top++;
				}
			}
			for(int i=0; i<start.length-1; i++) {
				if(start[i]>= start[i+1]) {
					start[i+1] += (start[i]-start[i+1]+1);
				}
			}

			StringBuilder out = new StringBuilder();
            for (int i = 0; i < start.length; i++) {
                int next = m;
                if (i + 1 < start.length)
                    next = start[i + 1];
                for (int j = start[i]; j < next; j++) {
                    out.append(pages[j] + " ");
                }
                out.append("/ ");
            }
            
            pw.println(out.substring(0,out.length()-3));
            tc--;
		}
		pw.close();
                
	}

	public static long binarySearch(long lo, long hi) {

		while(hi > lo) {
			long mid = (hi+lo)/2;
			long sum = 0;
			int j = 0;

			for(int i=0; i<m && j<k; i++) {
				while(pages[i] + sum > mid && j<k) {
					sum = 0;
					j++;
				}
				sum+=pages[i];
			}

			if(j>=k)
				lo = mid+1;
			else
				hi = mid;
		}

		return hi;
	}
}
