class Solution {
    public boolean findSubarrays(int[] nums) {
        if(nums.length == 2) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        int prev = 0 , curr = 1;

        while(curr < nums.length){
            int sum = nums[prev] + nums[curr];
            map.put(sum, map.getOrDefault(sum,0)+1 );
            prev = curr; curr++;
        }

        for(int key : map.keySet()){
            if(map.get(key) > 1) return true;
        }

        return false;
    }

}
