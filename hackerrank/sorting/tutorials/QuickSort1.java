import java.util.*;
public class Solution {
       
          static void partition(int[] ar) {
              int p = ar[0];
              ArrayList<Integer> less = new ArrayList<>();
              ArrayList<Integer> eq = new ArrayList<>();
              ArrayList<Integer> more = new ArrayList<>();
              
              for(int i=1; i<ar.length; i++) {
                  if(ar[i]<p)
                      less.add(ar[i]);
                  
                  else if(ar[i]>p)
                      more.add(ar[i]);
                      
                  else
                      eq.add(ar[i]);
              }
              
              printArrList(less);
              printArrList(eq);
              System.out.print(p + " ");
              printArrList(more);
                    
       } 
    
    static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    
    static void printArrList(ArrayList<Integer> ar) {
        for(int i=0; i<ar.size(); i++) {
            System.out.print(ar.get(i) + " ");
        }
    }
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
       }    
   }