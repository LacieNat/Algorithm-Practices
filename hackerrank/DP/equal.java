import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            final short N = Short.parseShort(br.readLine());
            final short[] A = new short[N];
            String[] input = br.readLine().split(" ");
            for(short i = 0; i < N; ++i){
                A[i] = Short.parseShort(input[i]);
            }
            input = null;
            
            // if number of colleagues is less than 2, then there is no need for equal distribution
            if(N < 2){
                sb.append("0\n");
                continue;
            }
            
            //find the minimum number of chocolates in the array
            int minVal = A[0];
            for(int i = 1; i < N; ++i){
                if (A[i] < minVal){
                    minVal = A[i];
                }
            }
            
            // find the min for f(min) to f(min-4)
            int minCount = Integer.MAX_VALUE;
            for(int i = 0; i <= 5; ++i){
                int count = 0;
                for(short j = 0; j < N; ++j){
                    short V = (short)(A[j] - (minVal - i));
                    count += V/5 + (V %= 5)/2 + (V & 1);
                }
                if (count < minCount){
                    minCount = count;
                }
            }
            
            sb.append(minCount+ "\n");
        }
        System.out.print(sb);
    }
}