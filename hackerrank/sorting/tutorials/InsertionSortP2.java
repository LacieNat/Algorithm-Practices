import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] ar)
    {       
        for(int i=1; i<ar.length; i++) {
            int v = ar[i];
            for(int j=i-1; j>=0; j--) {
                if(ar[j] > v) {
                    ar[j+1] = ar[j];
                }
                
                else {
                    ar[j+1] = v;
                    break;
                }
            }
            
            if(ar[0] > v) {
                ar[0] = v;
            }
            
            printArray(ar);
        }
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}