package SortingTechniques;

//In this sorting technique , we bubble up the highest elements to the end of the array in every loop
// and keep on decreasing the scope of the array length for looping
// TC:  O(n^2)
public class BubbleSort {
	//three pointers important to note in this code
	//1. Array Index Out of Bounds: The inner loop condition j < arr.length - i will cause 
		// an ArrayIndexOutOfBoundsException because when j is equal to arr.length - i - 1,
		// j + 1 will be equal to arr.length, which is out of bounds.that's why j will loop till j<arr.length-i-1
	//2. Loop Bounds: The outer loop runs for arr.length iterations, which is unnecessary.
		// It should run arr.length - 1 times.
	//3. optimized Bubble Sort: To improve efficiency, if no elements are swapped during an iteration, the array is already sorted, and you can break out of the loop early.
	
	void swapping(int arr[], int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	void sorting(int[] arr) {
		 boolean swapped;
		for(int i=0;i<arr.length-1;i++) {
			swapped=false;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					swapping(arr,j,j+1);
					swapped=true;
				}
			}
			 // If no two elements were swapped in the inner loop, the array is sorted
			if(!swapped) break;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {5,3,4,1,2};
		BubbleSort bsort = new BubbleSort();
		bsort.sorting(arr);
		System.out.println("Sorted array: ");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
