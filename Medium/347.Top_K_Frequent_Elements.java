class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) map.put(n, map.getOrDefault(n,0)+1);
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        // or removed <> and .reversed()

        /*
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(new int[] {entry.getValue(), entry.getKey()});
            if(heap.size() > k) heap.poll();
        }
        */
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){ 
            res[i] = list.get(i).getKey(); // and add list.size()-1-i
              // res[i] = heap.poll()[1];
        }
        
        return res;
    }
}
