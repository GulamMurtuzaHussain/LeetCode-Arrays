class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int common = -1;
        for(int i=0;i<nums1.length;i++){
            int low = 0, high = nums2.length-1;
            while(low<=high){
                int mid = (low + high)/2;
                if(nums2[mid] == nums1[i]){
                    return nums1[i];
                }
                else if(nums2[mid] > nums1[i]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return common;
    }
}
