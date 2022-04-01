package arrays;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] rotatedArr = rotateMatrix(arr);

        for(int[] row : rotatedArr){
            Arrays.stream(row).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static int[][] rotateMatrix(int[][] arr) {
        int N = arr.length;

        for (int i = 0; i < N; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
               arr[j][i] = temp;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < (N/2); j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][N-1-j];
                arr[i][N-1-j] = temp;
            }
        }
        return arr;
    }

}
