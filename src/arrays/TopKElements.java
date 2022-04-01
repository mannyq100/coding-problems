package arrays;

import java.util.*;

public class TopKElements {
    public static void main(String args[]) {

        System.out.println(findKlargest(new int[]{2,3,4,5,2,1,7,40},3));

        System.out.println("-----------------------");

        var topFrequent = findTopKElements(new int[]{2,2,4,6,8,3,6,2},2);
        topFrequent.stream().forEach(el -> System.out.println(el+" "));
    }

    // find the Kth largest element in array
    static int findKlargest(int[] arr, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i < k; i++){
            minHeap.add(arr[i]);
        }

        for(int j = k; j < arr.length; j++){

            int num = arr[j];

            if(minHeap.peek() < num){
                minHeap.poll();
                minHeap.add(num);
            }

        }

        return minHeap.peek();
    }

    // find top K frequent elements in Array
    static List<Integer> findTopKElements(int[] arr, int k){
        List<Integer> result = new ArrayList<>();

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int el: arr){
            frequencyMap.put(el, frequencyMap.getOrDefault(el,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((entry1, entry2) -> entry1.getValue() - entry2.getValue());

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            minHeap.add(entry);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        Iterator<Map.Entry<Integer, Integer>> itr = minHeap.iterator();
        while(itr.hasNext()){

            result.add(itr.next().getKey());
        }
        return result;
    }
        }

