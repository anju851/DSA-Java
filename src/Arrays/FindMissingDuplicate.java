package Arrays;

import java.util.*;

public class FindMissingDuplicate {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        int[] arr = new int[n];

        // Copy elements from List to array
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }

        // Swapping logic to place numbers at their correct positions
        // the duplicated value will ultimately be placed at the index
        //where the missing value would reside
        for (int i = 0; i < n; i++) {
            while (arr[i] != arr[arr[i] - 1]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("array after swapping: ");
    	for(int i=0;i<n;i++) {
    		System.out.println(arr[i]);
    	}
    	

        // Find the duplicate and missing number
    	// since the duplicated value will ultimately be placed at the index
        // where the missing value would reside, so duplicated value = value at that index 
    	// and missing value equal to the index
        int duplicate = -1, missing = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                duplicate = arr[i];
                missing = i + 1;
                break;
            }
        }

        // Return result as ArrayList
        return new ArrayList<>(Arrays.asList(duplicate, missing));
    }

    public static void main(String[] args) {
        FindMissingDuplicate obj = new FindMissingDuplicate();
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 1, 5, 2));
        ArrayList<Integer> arrlist = obj.repeatedNumber(list);
        System.out.println();
        // Print results
        for (int i : arrlist) {
            System.out.println(i);
        }
    }
}
