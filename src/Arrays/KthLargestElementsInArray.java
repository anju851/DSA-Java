package Arrays;

import java.util.PriorityQueue;

public class KthLargestElementsInArray {
	// Function to find k largest array element
    static void kLargest(int a[], int n, int k)
    {
        // Implementation using
        // a Priority Queue 
    	// Time Complexity: O(N * log(K))
    	//Auxiliary Space: O(K)
        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>();

        for (int i = 0; i < n; ++i) {

            // Insert elements into
            // the priority queue
            pq.add(a[i]);

            // If size of the priority
            // queue exceeds k
            if (pq.size() > k) {
                System.out.println(pq.poll());
            }
        }

        // Print the k largest element
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.poll();
        }
        System.out.println();
    }
    // Driver Code
    public static void main(String[] args)
    {
        int a[]
            = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int n = a.length;
        int k = 3;
        System.out.print(k + " largest elements are : ");
        // Function Call
        kLargest(a, n, k);
    }
}
