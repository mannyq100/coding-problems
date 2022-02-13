package arrays.search;

/**
 * We rotate an ascending order sorted array at some point unknown to user.
 * So for instance, 3 4 5 6 7 might become 5 6 7 3 4.
 * Modify binary search algorithm to find an element in the rotated array in O(log n) time and O(1) Space complexity
 */
public class BinarySearchRotated {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        int num = findNumber(arr, 0, arr.length - 1, 1);
        System.out.println(num);
    }

    private static int findNumber(int[] arr, int start, int end, int value) {

        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (value == arr[mid]) return arr[mid];

        if (arr[start] <= arr[mid]) {
            if (value >= arr[start] && value <= arr[end]) {
                return findNumber(arr, start, mid, value);
            }
            return findNumber(arr, mid + 1, end, value);
        } else {
            if (value >= arr[mid + 1] && value <= arr[end]) {
                return findNumber(arr, mid + 1, end, value);
            }
            return findNumber(arr, start, mid, value);
        }
    }
}
