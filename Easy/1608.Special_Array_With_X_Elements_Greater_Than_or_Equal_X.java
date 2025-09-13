import java.util.Arrays;
class Solution {

    static int LowestIndexGreater(int[] nums, int val){
        int low =0, high = nums.length-1;

        int ind = nums.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] >= val){
              high = mid -1;
              ind = mid;  
            }
            else low = mid + 1;
        }
        return ind;
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int greater = -1;
        if(nums[nums.length - 1] == 0) return -1;
        for(int i=1;i<=nums.length;i++){
            int first_ind = LowestIndexGreater(nums,i);
            int total_greater = nums.length- first_ind;
            if(total_greater == i) greater = total_greater;
        }
        return greater;
    }


















    //     //GPT
    //             Arrays.sort(nums);
    //     int n = nums.length;
    //     int low = 0, high = n;

    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         // Find number of elements >= mid
    //         int idx = firstGreaterEqual(nums, mid);
    //         int count = n - idx;

    //         if (count == mid) {
    //             return mid;
    //         } else if (count > mid) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return -1;
    // }

    // // Helper method: Finds the index of first element >= target using binary search
    // private int firstGreaterEqual(int[] nums, int target) {
    //     int low = 0, high = nums.length - 1;
    //     int ans = nums.length; // default to end of array
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (nums[mid] >= target) {
    //             ans = mid;
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return ans;
    // }
}

/*
        Arrays.sort(nums);

        int spl_ele = -1;
        for(int i=0;i<=nums.length;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]>=i) count++;
            }
            if(count == i) spl_ele = i;
        }
        return spl_ele;

*/
