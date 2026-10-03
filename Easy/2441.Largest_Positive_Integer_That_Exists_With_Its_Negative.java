class Solution {
    public int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // for(int n : nums){
        //     if(n<0) map.put(-n, map.getOrDefault(-n,0)+1);
        //     else map.put(n,map.getOrDefault(n,0)+1);
        // }
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        int max = -1;
        for(int n : map.keySet()){
            if(map.containsKey(-n) && n > max) max = n;
        }

        return max;
    }
}
