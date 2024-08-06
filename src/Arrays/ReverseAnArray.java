package Arrays;
import java.util.*;

/* In Java, if you try to print an array directly using System.out.println(arrayName);,
 *  it will not print the elements of the array. Instead, it will print the array's
 *   memory address or hash code, which looks like "garbage value.
 *   
 *   ways to print array items without looping
 *   a. Use Arrays.toString() converts the array to a readable string.
 *   	int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
 *   b. Use Arrays.stream() and Collectors.joining()
 *   	int[] array = {1, 2, 3, 4, 5};
        String arrayString = Arrays.stream(array)
                                   .mapToObj(String::valueOf)
                                   .collect(Collectors.joining(", "));
        System.out.println(arrayString);
    c. Use Arrays.deepToString() for Multidimensional Arrays
    	int[][] array = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(Arrays.deepToString(array));
 */

public class ReverseAnArray {
	
	//way 1 using reverse mathod  TC: O(n)
	static int[] reverse(int []arr) {
		// return arr.reverse(); // we dont have reverse() method for java array type so we cant use this method directly 
		int temp;
		int length = arr.length;
		for(int i=0;i<length/2;i++) {
			temp = arr[length-1-i];
			arr[length-1-i]=arr[i];
			arr[i]= temp;
		}
		for(int i=0;i<length;i++)
			System.out.println(arr[i]);
		return arr;
	}
	
	//way 2: using a new array TC: O(n)
	int[] reverseUsingNewArray(int[] arr) {
		int length = arr.length;
		int[] reverseArray= new int[length] ;
			for(int i=0; i<length; i++) {
				reverseArray[i]=arr[length-1-i];
			}
		return reverseArray;
	}
	
	//way3: using stack operation TC: O(n)
	int[] reverseUsingStack(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int length = arr.length;
		
		for(int i=0; i< length; i++) {
			stack.push(arr[i]);
		}
		int i=0;
		while(!stack.isEmpty()) {
			arr[i]=stack.pop();
			i++;
		}
		return arr;
	}
	
	//way4: using reverse Recursion method
	static void reverseArrayUsingRecursion(int arr[], int start, int end) {
		if(start>=end) return;
		
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
		
		reverseArrayUsingRecursion(arr, start+1, end-1);
	}
	
	void printReverseArray(int arr[]) {
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		int arr2[] = {9, 5, 6, 10, 87};
		int arr3[] = {5, 12, 16, 20, 18};
		int arr4[] = {52, 112, 106, 200, 180};
		
		ReverseAnArray obj = new ReverseAnArray();
		
		System.out.println("the reversed array using reverse() is: " + Arrays.toString(reverse(arr)));
		System.out.println("the reversed array using reverseUsingNewArray() is: " + Arrays.toString(obj.reverseUsingNewArray(arr2)));
		System.out.println("the reversed array using reverseUsingNewArray() is: " + Arrays.toString(obj.reverseUsingStack(arr3)));
		
		reverseArrayUsingRecursion(arr4,0,4);
		obj.printReverseArray(arr4);
		
		
	}

}
