package SortingTechniques;

import java.util.Arrays;

public class MergeSort {
	
	static int[] merge(int left[],int right[]) {
		int resultArr[]=new int[left.length+right.length];
		int i=0,j=0,k=0;
		while( i <left.length && j<right.length ) {
			if(left[i] <= right[j]) {  // Use <= to handle duplicate elements
				resultArr[k]=left[i];
				k++;
				i++;
			}
			else{
				resultArr[k]=right[j];
				k++;
				j++;
			}
		}
		while(i <left.length) {
			resultArr[k]=left[i];
			k++;
			i++;
		}
		while(j <right.length) {
			resultArr[k]=right[j];
			k++;
			j++;
		}
		return resultArr;
	}
	
	static int[] sort(int arr[], int start, int end) {
		if(start >= end) { return Arrays.copyOfRange(arr, start, end + 1); }
		int mid = start + (end - start) / 2;
		int left[] = sort(arr,start,mid);
		int right[] = sort(arr, mid+1,end);
		return merge(left,right);
	}
	
	public static void main(String[] args) {
		int[] arr = {20,6,10,5,40,1};
		int sortedArray[] = sort(arr,0,arr.length-1);
		System.out.println("sorted array: ");
		for(int i=0; i<sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}

}
