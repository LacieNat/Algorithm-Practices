import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);
        int term = 2;
        
        while(term<n) {
            BigInteger btemp = new BigInteger(bb.toString());
            bb = bb.pow(2).add(ba);
            ba = btemp;
            term++;
        }
        
        System.out.println(bb.toString());
    }
}