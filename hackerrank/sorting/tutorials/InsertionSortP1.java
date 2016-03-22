import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    

    public static void insertIntoSorted(int[] ar) {
        
        int v = ar[ar.length-1];
        for(int i=ar.length-2; i>=0; i--) {
            if(ar[i] > v) {
                ar[i+1] = ar[i];
                printArr(ar);
            } else {
                ar[i+1] = v;
                printArr(ar);
                break;
            }
        }
        
        if(ar[0]>v) {
            ar[0] = v;
            printArr(ar);
        }
    }
    
    public static void printArr(int[] ar) {
        for(int i=0; i<ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}