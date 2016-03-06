
import java.io.*;
import java.util.*;
import java.lang.Math.*; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();

        int n = Integer.parseInt(st.nextToken());
        int max; 
        int[] courses = new int[5];
        while(n!=0) {
            max = Integer.MIN_VALUE;
            hm.clear();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++) {
                    courses[j] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(courses);
                long hc = getHashCode(courses);
                int value = 0;

                if(hm.containsKey(hc)) {
                    value = hm.get(hc);
                }
                hm.put(hc, ++value);
                if(value>max) {
                    max = value;
                }
            }
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int count = 0;
            for(Integer e: hm.values()) {
                if (e == max) {
                    count+=max;
                }
            }

            pw.println(count);
        }
        pw.close();
    }

    public static long getHashCode(int[] arr) {
        long hc = 0;
        int p = 0;
        for(int i=arr.length-1; i>=0; i--) {
                hc += arr[i]*Math.pow(10, p);
                p+=3;
        }
        return hc;
    }
}