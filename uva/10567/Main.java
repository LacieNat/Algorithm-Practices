import java.util.*;
import java.io.*;

public class Main {
	public static String s;
	public static int q;
	public static String patt;
	public static int lastIndex, firstIndex;
	public static HashMap<Character, ArrayList<Integer>> ht;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        ht = new HashMap<>();

		char[] cArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		for(int i=0; i<cArr.length; i++) {
			ht.put(cArr[i], new ArrayList<Integer>());
		}

		s = br.readLine();
		q = Integer.parseInt(br.readLine());

		for(int i=0; i<s.length(); i++) {
			ht.get(s.charAt(i)).add(i);
		}

		for(int i=0; i<q; i++) {
			lastIndex = -1;
			patt = br.readLine();
			solve(pw);
		}
		pw.close();
	}

	public static void solve(PrintWriter pw) throws IOException {
		for(int i=0; i<patt.length(); i++) {
			char curr = patt.charAt(i);
			ArrayList<Integer> arr = ht.get(curr);
			int lo = 0, hi = arr.size()-1, found=-1;
			int mid;

			while(lo<=hi) {
				mid = (lo+hi)/2;

				if(arr.get(mid)<=lastIndex) {
					lo = mid+1;
				} else {
					hi = mid-1;
					found = arr.get(mid);
				}
			}
			if (found == -1) {
				pw.println("Not matched");
				return;
			} else {
				if(i==0)
					firstIndex = found;
				lastIndex = found;
			}
		}

		pw.println("Matched " + firstIndex + " " + lastIndex);
	}
}
