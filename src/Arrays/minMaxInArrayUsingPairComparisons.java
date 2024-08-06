package Arrays;

public class minMaxInArrayUsingPairComparisons {
	
	static class Pairs {
		int min;
		int max;
		
		@Override
		public String toString(){
			return "{" +
					"min: " +
					min + ", max: " +
					max + '}' ;
		}
	}
	
	static Pairs getMinMax(int arr[]) {
		Pairs minmaxpair = new Pairs();
		int i=0;
		
		if(arr.length%2 ==0) {
			if(arr[0] > arr[1]) {
				minmaxpair.min = arr[1];
				minmaxpair.max = arr[0];
			}else {
				minmaxpair.min = arr[0];
				minmaxpair.max = arr[1];
			}
			i=2;
		}else {
			minmaxpair.min = arr[0];
			minmaxpair.max = arr[1];
			i=1;
		}
		// less than length-1, since we will iterate till second last
		// item in the array as it is taken in pair by i and i+1
		while(i< arr.length-1) {
			if(arr[i] < arr[i+1]) {
				if( arr[i] < minmaxpair.min) minmaxpair.min = arr[i];
				if( arr[i+1] > minmaxpair.max) minmaxpair.max = arr[i+1];
			}else {
				if( arr[i+1] < minmaxpair.min) minmaxpair.min = arr[i+1];
				if( arr[i] > minmaxpair.max) minmaxpair.max = arr[i];
			}
			i+=2;
		}
	return minmaxpair;
	}
	
	public static void main(String args[]) {
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		Pairs minmaxPair = getMinMax(arr);
		System.out.println("min value min-max pair found as : " + minmaxPair.min);
		System.out.println("max value min-max pair found as : " + minmaxPair.max);
		System.out.println("min-max pair found as: "+ minmaxPair);
	}
}
