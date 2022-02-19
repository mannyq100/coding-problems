package arrays;

public class KadaneAlgorithm {
    public static void main(String args[]) {

        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int maxSum = maxSubArray(arr);

        System.out.println(maxSum);
    }

    static int maxSubArray(int[] arr){
        int maxSum = arr[0];
        int runningSum = 0;

        for(int i = 0; i < arr.length; i++){

            runningSum += arr[i];

            if(runningSum >= maxSum){
                maxSum = runningSum;
            }
            if(runningSum < 0){
                runningSum = 0;
            }
        }
        return maxSum;
    }
}

