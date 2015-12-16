import java.util.ArrayList;
import java.util.Arrays;
public class Sort {
	
	public static void main(String[] args) {
		int arr[] = {0,2,3,4,1,85,23,41,53};
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			arrList.add(arr[i]);
		}
		
		//Bubble Test
		int sortedArr[] = bubble(arr);
		printArr(sortedArr);
		
		sortedArr = selection(arr);
		printArr(sortedArr);
		
		ArrayList<Integer> sortedArrList = quick(arrList);
		printArr(sortedArrList);
		
		int a[] = new int[10];
		a[0] = 1;
		a[1] = 2;
		a[2] = 4;
		a[3] = 5;
		a[4] = 6;
		int b[] = {3, 7, 8, 9, 10};
		
		printArr(merge91(a, b, 4));
		
	}
	
	public static int[] merge91(int[] a, int[] b, int aLast) {
		int i=aLast;
		int j=b.length-1;
		while(i>=0 && j>=0) {
			if(a[i]<b[j]) {
				for(int k=aLast+1; k>i; k--) {
					a[k] = a[k-1];
				}
				aLast++;
				a[i+1] = b[j];
				j--;
			}
			
			else if(a[i]>b[j]) {
				i--;
			}
		}
		
		return a;
	}
	
	/*
	 * Bucket Sort
	 * Mainly useful when input is uniformly distributed over a range.
	 */
	public static void bucket(int[] arr) {
		
	}
	
	public static void printArr(int[] sortedArr) {
		for(int i=0; i<sortedArr.length; i++) {
			System.out.print(sortedArr[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArr(ArrayList<Integer> sortedArr) {
		for(int i=0; i<sortedArr.size(); i++) {
			System.out.print(sortedArr.get(i) + " ");
		}
		System.out.println();
	}
	
	/*
	 * Bubble sort
	 * Worst case: O(n^2)
	 * Best case: O(n)
	 * Average case: O(n^2)
	 * Worst case space : O(1) auxiliary
	 * 
	 * Bubble sort has a significant performance advantage over other sorting algorithms when sorting information that's stored on tape, 
	 * with limited random access memory to store the information that's being sorted.
	 * 
	 * Has the ability to detect that the list is already sorted
	 */
	public static int[] bubble(int[] arr) {
		int swap = 0;
		
		for(int i=0; i<arr.length; i++) {
			swap = 0;
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap++;
				}
			}
			
			if(swap == 0) {
				break;
			}
		}
		
		return arr;
	}
	
	
	/*
	 * QuickSort
	 * Worst case: O(n^2) 
	 * Best case: O(nlogn) for simple partition and O(n) for three way partition and equal keys
	 * Average case: O(nlogn)
	 * 
	 * pseudocode:
	 * quicksort(A, lo, hi)
			  if lo < hi
			    p = partition(A, lo, hi)
			    quicksort(A, lo, p - 1)
			    quicksort(A, p + 1, hi)
			
			partition(A, lo, hi)
			    pivot = A[hi]
			    i = lo //place for swapping
			    for j = lo to hi - 1
			        if A[j] <= pivot
			            swap A[i] with A[j]
			            i = i + 1
			    swap A[i] with A[hi]
			    return i
	 * 
	 * not the most accurate representation:
	 */
	public static ArrayList<Integer> quick(ArrayList<Integer> arr) {
		if(arr.size() <= 0) {
			return new ArrayList<Integer>();
		}
		if(arr.size() == 1) {
			return arr;
		}
		Integer partition = arr.get(0);
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i) < partition) {
				left.add(arr.get(i));
			} else if(arr.get(i) > partition){
				right.add(arr.get(i));
			}
		}
		
		left.add(partition);
		
		ArrayList<Integer> sortedLeft = quick(left);
		ArrayList<Integer> sortedRight = quick(right);

		sortedLeft.addAll(sortedRight);
		
		return sortedLeft;
	}
	
	/*
	 * Selection sort
	 * Worst case: O(n^2)
	 * Best case: O(n^2)
	 * Average case: O(n^2)
	 * Worst case space : O(n) total, O(1) auxiliary
	 * 
	 * 
	 */
	public static int[] selection(int[] arr) {
		if(arr.length== 0) {
			return new int[0];
		}
		int length = arr.length;
		int index = 0;
		
		for(int j=0; j<length; j++) {
			int minIndex = j;
			
			for(int i=index+1; i<length; i++) {
				if(arr[i] < arr[minIndex]) {
					minIndex = i;
				}
			}
			
			int temp = arr[index];
			arr[index] = arr[minIndex];
			arr[minIndex] = temp;
			index++;
		}
		return arr;
	}
}
