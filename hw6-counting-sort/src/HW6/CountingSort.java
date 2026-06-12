/**
 * Samantha Bryan
 * I pledge my honor that I have abided by the Stevens Honor System
 */
package HW6;
/**
 * Imports the Arrays library for Java
 */
import java.util.Arrays;

/**
 * Initiates a class CountingSort
 */
public class CountingSort {
    /**
     * A method sort(int[] A) that sorts an array from 0....n
     * @param A
     * @return a sorted array
     */
    public static int[] sort(int[] A){
        int k = maxValue(A);
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[k + 1];

        if(A.length == 1){
            return A;
        }
        for(int j = 0; j < n; j++) {
            C[A[j]] += 1;
        }

        for(int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }

        for(int j = n - 1; j >= 0; j--){
            B[C[A[j]] - 1] = A[j];
            C[A[j]] -= 1;
        }
        return B;
    }

    /**
     * A helper method that returns the maximum value in A[]
     * @param A
     * @return the maximum
     */
    public static int maxValue(int[] A){
        int m = 0;
        for(int i = 0; i<A.length; i++){
            if (A[i] > m){
                m = A[i];
            }
        }
        return m;
    }
}
