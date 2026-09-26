class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        int count = 0;
        for(int n: nums){
            int diff = n + k;
            if(map.containsKey(diff)) count += map.get(diff);
        }

        return count;
    }
}
