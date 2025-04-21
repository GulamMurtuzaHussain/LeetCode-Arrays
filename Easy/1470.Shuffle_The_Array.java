class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i=0,j=n;
        int[] ans = new int[nums.length];
        int k=0;
        for(j=n;j<nums.length;j++){
            ans[k++] = nums[i++];
            ans[k++] = nums[j];
        }
        return ans;
    }
}
