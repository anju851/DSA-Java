package SortingTechniques;

// In this sorting technique, we take the reference of a value at targeted index and then
// find out the smallest element in the array from the target index till the length of the array
// and then place the smallest element found at the targeted index by swapping the indexes of
// the smallest element and the target index

// TC :  O(n^2)
public class SelectionSort {
	
	static void swapping(int[] arr, int a, int b) {
		int temp=arr[b];
		arr[b]=arr[a];
		arr[a]=temp;
	}
	
	//In Java, when you pass an array to a method, you are passing a reference
	// to the original array, not a copy. This means any modifications to the
	// array within the method will affect the original array. Therefore, 
	// you do not need to return the array from the sorting method since the
	// original array itself is getting modified
	static void sorting(int[] arr) {
		
			for(int i=0; i<arr.length;i++) {
				int minPos=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minPos] > arr[j]) {
					minPos=j;
				}	
			}
			// The condition if (i != minPos) in the selection sort algorithm 
			// is used to avoid unnecessary swaps, The condition if (i != minPos)
			//in the selection sort algorithm is used to avoid unnecessary swaps
			if(i!=minPos) {
				swapping(arr,i,minPos);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {5,3,4,1,2};
		sorting(arr);
		System.out.println("Sorted array: ");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
