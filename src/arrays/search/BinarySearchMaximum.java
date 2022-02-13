package arrays.search;

/**
 * One array of integers is given as an input ,which is initially increasing
 * and then decreasing or it can be only increasing or decreasing , you need
 * to find the maximum value in the array in O(Log n) Time complexity and O(1) Space Complexity
 */

public class BinarySearchMaximum {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 15, 17, 25, 35, 50, 41, 29, 23, 8, 1};
        int maxNum = findMax(arr, 0, arr.length);
        System.out.println("Maximum number in array is: " + maxNum);
    }


    static int findMax(int[] arr, int start, int end) {
        if (start == end) return arr[start];

        if (end == start + 1) {
            return arr[start] > arr[end] ? arr[start] : arr[end];
        }

        int mid = (start + end) / 2;
        int midElement = arr[mid];

        // left side is less and right side is less
        if (arr[mid - 1] < midElement && arr[mid + 1] < midElement) {
            return midElement;
        }
        // left side is less and right side is more
        if (arr[mid - 1] < midElement && arr[mid + 1] > midElement) {
            return findMax(arr, mid + 1, end - 1);
        } else {
            //left side is more and right side is less
            return findMax(arr, start, mid - 1);
        }
    }
}
