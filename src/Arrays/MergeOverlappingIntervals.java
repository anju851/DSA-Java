/* Given a set of time intervals in any order, our task is to merge
 * all overlapping intervals into one and output the result which should
 * have only mutually exclusive intervals.
 * 
 * Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
	Output: {{1, 4}, {6, 8}, {9, 10}}
	Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].
	
	Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
	Output: {{1, 9}} 
 */

package Arrays;

import java.util.*;

public class MergeOverlappingIntervals {

    static void mergeIntervals(int arr[][]) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // Sort intervals based on the starting time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        /* or sorting can be done in below way as well
         * // sort the intervals in increasing order of start
        // time
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2)
            {
                return i1.start - i2.start;
            }
        });
         */

        Stack<int[]> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int[] peek = stack.peek();
            if (arr[i][0] <= peek[1]) {
                // Merge intervals
                stack.pop();
                stack.push(new int[] {peek[0], Math.max(peek[1], arr[i][1])});
            } else {
                stack.push(arr[i]);
            }
        }

        // Print merged intervals
        // new stack is created to push and print the result so as to maintain the array input series
        // without which the stack when poped to print merged intervals would give resultant intervals in reverse order
        Stack<int[]> resultStack = new Stack<>();
        while (!stack.isEmpty()) {
            resultStack.push(stack.pop());
        }
        
        while (!resultStack.isEmpty()) {
            System.out.println(Arrays.toString(resultStack.pop()));
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        mergeIntervals(arr);
    }
}
