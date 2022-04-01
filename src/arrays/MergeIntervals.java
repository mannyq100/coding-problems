package arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] mergedIntervals = mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] interval : mergedIntervals) {
            System.out.println("Merged Interval " + interval[0] + "->" + interval[1]);
        }

    }

    static int[][] mergeIntervals(int[][] arr) {
        LinkedList<int[]> result = new LinkedList<>();

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : arr) {
            if (result.isEmpty() || result.getLast()[1] < interval[1]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }

        }
        return result.toArray(new int[result.size()][]);
    }
}
