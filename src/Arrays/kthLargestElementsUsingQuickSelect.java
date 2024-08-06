/*
 * Quickselect Algorithm
Quickselect is a selection algorithm to find the k-th smallest (or largest) element
 in an unordered list. It is related to the quicksort sorting algorithm. Here is an
 implementation of the Quickselect algorithm to find the k-th largest element
 
 Explanation:
Quickselect:

The quickselect method recursively selects the k-th smallest element in the array.
It starts by choosing a random pivot, partitions the array around the pivot, and then recurses into the side of the array that contains the k-th smallest element.
Partition:

The partition method rearranges the array such that all elements less than the pivot are to its left, and all elements greater than the pivot are to its right.
It returns the final position of the pivot element.
Swapping:

The swap method exchanges elements at two indices in the array.
Finding k-th Largest:

Since the k-th largest element is the (n - k)-th smallest element, we call quickselect with k = nums.length - k.
This approach generally has an average time complexity of 
𝑂(𝑛)
O(n), although the worst-case time complexity is 
𝑂(𝑛2)
O(n2). However, with a random pivot, the average case performance is very good, making it more efficient in practice compared to the heap-based solution
 */

package Arrays;

import java.util.Random;

public class kthLargestElementsUsingQuickSelect {
	private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickselect(nums, left, pivotIndex - 1, k);
        } else {
            return quickselect(nums, pivotIndex + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        kthLargestElementsUsingQuickSelect obj = new kthLargestElementsUsingQuickSelect();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;
        System.out.println(obj.findKthLargest(nums, k)); // Output: 5
    }
}
