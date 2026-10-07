class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) map.put(n, map.getOrDefault(n,0)+1);
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        // or removed <> and .reversed()
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){ 
            res[i] = list.get(i).getKey(); // and add list.size()-1-i
        }
        
        return res;
    }
}
