/*
 * To solve the problem of finding the duplicate number \( A \) and the missing number \( B \) in a read-only array of \( n \) integers from 1 to \( n \) where each integer appears exactly once except for \( A \) which appears twice and \( B \) which is missing, we can use mathematical equations based on sums and sums of squares. This approach runs in linear time complexity and uses constant extra space.

Here's a step-by-step approach to achieve this:

1. Calculate the expected sum and the sum of squares for the first \( n \) natural numbers.
2. Calculate the actual sum and the sum of squares of the given array.
3. Use these sums to derive the equations needed to find \( A \) and \( B \).

The expected sum of the first \( n \) natural numbers is given by:
\[ S_n = \frac{n(n + 1)}{2} \]

The expected sum of squares of the first \( n \) natural numbers is given by:
\[ S_{n^2} = \frac{n(n + 1)(2n + 1)}{6} \]

Let:
- `sumActual` be the sum of the array.
- `sumSquaresActual` be the sum of squares of the array.

From the problem, we have:
\[ A - B = sumActual - S_n \]
\[ A^2 - B^2 = sumSquaresActual - S_{n^2} \]
\[ (A + B)(A - B) = sumSquaresActual - S_{n^2} \]

Using the above equations, we can solve for \( A \) and \( B \).


### Explanation:
1. **Initialization**:
   - `sumN` and `sumNSq` are the expected sum and sum of squares for numbers from 1 to \( n \).
   - `sum` and `sumSq` are the actual sum and sum of squares of the given array.

2. **Calculations**:
   - `diff` is the difference between the actual sum and the expected sum, which equals \( A - B \).
   - `sumDiff` is derived from the difference of the actual and expected sum of squares divided by `diff`, giving \( A + B \).

3. **Finding \( A \) and \( B \)**:
   - By solving the system of equations using `diff` and `sumDiff`, we can find the values of \( A \) (duplicate) and \( B \) (missing).

This approach ensures linear runtime complexity \( O(n) \) and constant space complexity \( O(1) \), adhering to the problem constraints.
 * 
 */


package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingDuplicateUsingFormulas {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long n = A.size();
        long sumN = (n * (n + 1)) / 2;
        long sumNSq = (n * (n + 1) * (2 * n + 1)) / 6;
        long sum = 0;
        long sumSq = 0;

        for (int num : A) {
            sum += num;
            sumSq += (long) num * num;
        }

        long diff = sum - sumN; // A - B
        long sumDiff = (sumSq - sumNSq) / diff; // A + B

        int duplicate = (int) ((diff + sumDiff) / 2);
        int missing = (int) (sumDiff - duplicate);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(duplicate);
        result.add(missing);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 5, 3));
        ArrayList<Integer> result = repeatedNumber(list);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
