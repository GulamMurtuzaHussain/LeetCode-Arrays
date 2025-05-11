
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left_sum = new int[nums.length];
        int[] right_sum = new int[nums.length];

        left_sum[0] = 0;
        for(int i=1;i<nums.length;i++){
            left_sum[i] = nums[i-1]+left_sum[i-1];
        }

        right_sum[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            right_sum[i] = nums[i+1] + right_sum[i+1];
        }

        int[] diff = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            diff[i] = Math.abs(left_sum[i] - right_sum[i]);
        }
        return diff;
    }
}
