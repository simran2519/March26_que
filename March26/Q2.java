//2.Problem statement
//        You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
//
//
//
//        Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
//
//
//
//        Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.
//
//
//
//        Example:
//        Input: 'arr' = [1, 1, 4, 5]
//
//        Output: 3
//
//        Explanation: The possible ways are:
//        [1, 4]
//        [1, 4]
//        [5]
//        Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Sample Input 1 :
//        4 5
//        1 4 4 5
//
//
//        Sample Output 1 :
//        3
//
//
//        Explanation For Sample Output 1:
//        The possible ways are:
//        [1, 4]
//        [1, 4]
//        [5]
//        Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
//
//
//        Sample Input 2 :
//        3 2
//        1 1 1
//
//
//        Sample Output 2 :
//        3
//
//
//        Explanation For Sample Output 1:
//        There are three 1 present in the array. Answer is the number of ways to choose any two of them.
//
//
//        Sample Input 3 :
//        3 40
//        2 34 5
//
//
//        Sample Output 3 :
//        0
//
//
//        Expected time complexity :
//        The expected time complexity is O('n' * 'k').
//
//
//        Constraints:
//        1 <= 'n' <= 100
//        0 <= 'arr[i]' <= 1000
//        1 <= 'k' <= 1000
//
//        Time limit: 1 sec
package March26;
public class Q2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 4, 5};
        int k1 = 5;
        System.out.println(numberOfWays(arr1, k1)); // Output: 3

        int[] arr2 = {1, 1, 1};
        int k2 = 2;
        System.out.println(numberOfWays(arr2, k2)); // Output: 3

        int[] arr3 = {2, 34, 5};
        int k3 = 40;
        System.out.println(numberOfWays(arr3, k3)); // Output: 0
    }

    public static int numberOfWays(int[] arr, int k) {
        int n = arr.length;
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - arr[i - 1]]) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}

