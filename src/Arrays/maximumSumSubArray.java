package Arrays;
import java.util.*;

public class maximumSumSubArray {
	
	//using kadane's algorithm
	static int[] maximumSum(int arr[]) {
		int max_sum_soFar=Integer.MIN_VALUE;
		int max_end =0;
		int start=0, end=0;
		
		// if array length is 0
        if(arr.length ==0) return new int[] {};

        // array contains only negative values inside it, return the highest negative value as sum
        if(Arrays.stream(arr).allMatch(value -> value < 0)){
             int largestNegative = Integer.MIN_VALUE;
             for (int i : arr) {
                if (i > largestNegative) {
                    largestNegative = i;
                }
            }
            return new int[] {largestNegative};
        }
		
		for(int i=0;i<arr.length;i++) {
			max_end+=arr[i];
			// if max_end sum is less than 0 then update its value to 0 
			//and update the start index of the subarray to next index of the array
			if(max_end <0) {
				max_end=0;
				start=i+1;
			}
			//if max_end is greater then update the max_sum_soFar
			//and the end index of the subarray
			if(max_end > max_sum_soFar) { 
				max_sum_soFar=max_end;
				end=i;
			}
		}
		return new int[] {start,end};
	}
	
	public static void main(String args[]) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		int arr2[] = {-4,-10};
		int indices[] = maximumSum(arr);
		for(int i=indices[0]; i<=indices[1]; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n " + Arrays.toString(maximumSum(arr2)));
	}

}
