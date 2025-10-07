class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}

/*
       int pos = 0;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]>target){
                pos = mid ; high = mid - 1;
            }
            else low = mid + 1;
        }
        if(pos !=0) return pos;
        else if(target < nums[0]) return 0;
        else return nums.length;
        */
