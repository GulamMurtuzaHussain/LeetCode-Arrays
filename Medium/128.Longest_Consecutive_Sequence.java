class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums); 

        int len = 1 , max = 0;
        for(int i=1;i<nums.length;i++){ 
            if(nums[i-1] == nums[i]) continue;
            if(nums[i-1] + 1 == nums[i]) len++;
            else{
                if( len > max) max = len;
                len = 1;
            }
        }

        if(len > max) return len;
        return max;
    }
}
