import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        quicksort(arr, 0, arr.length-1);
    }
    
    public static void quicksort(int[] arr, int lo, int hi) {
        
        if(lo<hi) {
            int mid = partition(arr, lo, hi);
            
            quicksort(arr, lo, mid-1);
            quicksort(arr, mid, hi);
        }
    }
    
    public static int partition(int[] arr, int lo, int hi) {
        int p = arr[hi];
        int less = lo;
        
        for(int i=lo; i<hi; i++) {
            if(arr[i]<=p) {
                swap(arr,i,less);
                less++;
            }
        }
        
        swap(arr, hi, less);
        printArr(arr);
        return less;
    }
    
    public static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}