package arrays.search;

/**
 * find upperbound index and lowerbound index of target in a sorted array
 */
public class BinarySearchUpperLower {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6, 7, 7, 8, 8, 10,12};
        int upperBound = findUpperBound(arr, 0, arr.length - 1, 8);
        int lowerBound = findLowerBound(arr, 0, arr.length - 1, 8);

        System.out.println("Searching for: 8 Lowerbound index is: " + lowerBound + " Upperbound index is: " + upperBound);
    }

    private static int findLowerBound(int[] arr, int start, int end, int value) {
        if (arr[start] == value) return start;

        if (start == end) return -1;

        int mid = (start + end) / 2;

        if (value <= arr[mid]) {
            return findLowerBound(arr, start, mid, value);
        } else {
            return findLowerBound(arr, mid + 1, end, value);
        }
    }

    private static int findUpperBound(int[] arr, int start, int end, int value) {
        if (arr[end] == value) return end;

        if (start == end) return -1;

        int mid = (start + end) / 2;

        if (value <= arr[mid] && arr[mid+1] != arr[mid]) {
            return findUpperBound(arr, start, mid, value);
        } else {
            return findUpperBound(arr, mid + 1, end, value);
        }
    }
}
