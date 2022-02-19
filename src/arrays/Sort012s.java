package arrays;

import java.util.Arrays;

public class Sort012s {
    public static void main(String args[]) {
        int[] arr = new int[]{2,1,1,0,1,2,1,2,0,0,1};
        //sort(arr);
        moveZerosToEnd(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void sort(int[] arr){
        int l = 0, r = arr.length-1, mid = 0;

        while(mid <= r){

            if(arr[mid] == 0){
                swap(arr, mid, l);
                l++;
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, mid, r);
                r--;
            }
            else{
                mid++;
            }
        }
    }


    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void moveZerosToEnd(int[] arr){
        int r = 0, end = arr.length-1;

        while(r <= end){
            if(arr[r] == 0){
                swap(arr, r, end);
                end--;
            }else{
                r++;
            }
        }
    }

}
