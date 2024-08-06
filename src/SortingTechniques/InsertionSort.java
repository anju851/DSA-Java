package SortingTechniques;

// builds up the sorted array by gradually adding elements in sorted order in the left half
// therefore increasing the length of the left half but in sorted order.
// Time Complexity: O(N^2)
public class InsertionSort {
	static void sorting(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int j=i-1;
			int key = arr[i];
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	public static void main(String[] args) {
		int arr[] = {5,3,4,1,2};
		sorting(arr);
		System.out.println("Sorted array using insertionSort: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
