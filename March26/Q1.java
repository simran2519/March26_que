package March26;//1.Problem statement
//        Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.

//        You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.

//        Example :
//        Input: arr = [2, 1, 5, 6, 2, 3], k = 2
//
//        Output: 11
//
//        Explanation:
//        First painter can paint boards 1 to 3 in 8 units of time and the second painter can paint boards 4-6 in 11 units of time. Thus both painters will paint all the boards in max(8,11) = 11 units of time. It can be shown that all the boards can't be painted in less than 11 units of time.
//
//
//        Detailed explanation ( Input/output format, Notes, Images )
//        Sample Input 1 :
//        4 2
//        10 20 30 40

//        Sample Output 1 :
//        60
//
//
//        Explanation For Sample Input 1 :
//        In this test case, we can divide the first 3 boards for one painter and the last board for the second painter.
//
//
//        Sample Input 2 :
//        2 2
//        48 90
//
//
//        Sample Output 2 :
//        90
//
//
//        Expected Time Complexity:
//        Try to do this in O(n*log(n)).
//
//
//        Constraints :
//        1 <= n <= 10^5
//        1 <= k <= n
//        1 <= arr[i] <= 10^9
//
//        Time Limit: 1 sec.
import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 6, 2, 3};
        int k1 = 2;
        System.out.println(minTimeToPaint(arr1, k1)); // Output: 11

        int[] arr2 = {10, 20, 30, 40};
        int k2 = 2;
        System.out.println(minTimeToPaint(arr2, k2)); // Output: 60

        int[] arr3 = {48, 90};
        int k3 = 2;
        System.out.println(minTimeToPaint(arr3, k3)); // Output: 90
    }

    public static int minTimeToPaint(int[] boards, int k) {
        long low = Arrays.stream(boards).max().getAsInt(); // Minimum time taken by one painter
        long high = Arrays.stream(boards).sum(); // Maximum time taken by all painters

        while (low < high) {
            long mid = low + (high - low) / 2;
            int requiredPainters = getRequiredPainters(boards, mid);
            if (requiredPainters <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    private static int getRequiredPainters(int[] boards, long time) {
        int painters = 1;
        long currentSum = 0;
        for (int board : boards) {
            currentSum += board;
            if (currentSum > time) {
                painters++;
                currentSum = board;
            }
        }
        return painters;
    }
}


