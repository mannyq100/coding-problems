package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]) {

        int[] arr = new int[]{2, 7, 11, 15};
        int[] result = twoSumsAnx(arr,9);

        Arrays.stream(result).forEach(System.out::println);
    }

    static int[] twoSum(int[] arr, int target){
        int[] nums = new int[]{-1,-1};

        if(arr.length < 2) return nums;

        Arrays.sort(arr);

        int i = 0, j = arr.length-1;
        while(i < j){
            if(arr[i] + arr[j] == target){
                nums[0] = arr[i];
                nums[1] = arr[j];
                return nums;
            }else if(arr[i] + arr[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return nums;
    }

    static int[] twoSumsAnx(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        for(int j = 0; j < arr.length; j++){
            int numToFind = target - arr[j];

            if(map.containsKey(numToFind) && j != map.get(numToFind)){
                return new int[]{arr[j], numToFind};
            }
        }
        return new int[]{-1,-1};
    }
}
