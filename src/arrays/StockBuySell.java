package arrays;

public class StockBuySell {

    public static void main(String args[]) {

        System.out.println(maxProfit(new int[]{98,178,250,300,40,540,690}));
    }

    static int maxProfit(int[] arr){
        if(arr.length == 0) return 0;
        int buy = 0;
        int sell = 0;

        int localMinima = arr[0];
        int localMaxima = arr[0];

        int i = 0;
        while(i < arr.length-1){

            if(arr[i] < arr[i+1]){
                localMinima = arr[i];

                while((i < arr.length-1) && (arr[i+1] > arr[i])){
                    localMaxima = arr[i+1];
                    i++;
                }
            }

            buy += localMinima;
            sell += localMaxima;
            i++;

        }
        return sell - buy;
    }
}
