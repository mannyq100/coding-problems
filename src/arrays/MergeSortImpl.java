package arrays;

import java.util.Arrays;

public class MergeSortImpl {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 1, 0, 10, 6, 3};
        mergeSort(arr, 7);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void mergeSort(int[] arr, int n) {
        if (arr.length < 2) return;

        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int j = mid; j < n; j++) {
            rightArr[j - mid] = arr[j];
        }

        mergeSort(leftArr, mid);
        mergeSort(rightArr, n - mid);
        merge(leftArr, rightArr, arr);
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
