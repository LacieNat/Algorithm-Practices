import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		ArrayList<Integer> perm = new ArrayList<Integer>();
		String[] arr;

		int n = Integer.parseInt(st.nextToken());
		while(n!=0) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            perm.clear();
            while(st.hasMoreTokens()) {
                perm.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            arr = new String[perm.size()];
            int i = 0;
            while(st.hasMoreTokens()) {
                arr[perm.get(i)-1] = st.nextToken();
                i++;
            }

            for(int j=0; j<perm.size(); j++) {
                pw.println(arr[j]);
  
            }
            n--;
            if (n!=0)
                pw.println();
        }
        pw.close();
	}
}