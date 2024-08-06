package Arrays;
import java.util.*;

// User function Template for Java

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    //By default, Java's toString() method for objects like Pair 
    // does not provide a meaningful representation of the key and value,
    // which can result to garbage values so it is important to always
    // override toString() for an object to be printed correctly.
    
    @Override
    public String toString() {
    	return "Pair{" + 
				"Key=" + key 
				+ ", Value=" + value
				+ '}';
    }
}

//Java users need to return result in Pair class
//For Example -> return new Pair(minimum,maximum)
class Solution {
    public Pair<Long, Long> getMinMax(int[] arr) {
        
        //way1: using sorting,  TC: O(nlogn) as we are using a sorting algo, space: O(1)
//         Arrays.sort(arr);
//         return new Pair(arr[0], arr[arr.length-1]);
        
        //way2: Bruteforce approach,  TC: O(n), space: O(1)
        int letMin = Integer.MAX_VALUE;
       for(int i=0;i<arr.length;i++){
           if(arr[i]<letMin)
              letMin = arr[i];
        }
        
         int letMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>letMax)
                letMax = arr[i];
        }
        
        return new Pair(letMin, letMax);
        
    	
    }
}

public class MinMaxInArrayUsingMinimumComparisons {
	public static void main(String[] args) {
		
		System.out.println("Hello world !!");
		
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        Solution sol = new Solution();
        System.out.println(sol.getMinMax(arr));
		
		
	}
}
