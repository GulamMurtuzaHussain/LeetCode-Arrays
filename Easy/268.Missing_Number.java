import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int missing = 0;
        for(int i=0;i<=nums.length;i++){
            int flag = 0;
            int low = 0, high = nums.length - 1;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid] == i){
                    flag = 1 ; break;
                }
                if(nums[mid] > i) high = mid - 1 ;
                if(nums[mid] < i) low = mid + 1 ;
            }
            if(flag == 0){
                missing = i;
                break;
            }
        }
        return missing;
    }
}

/*  MINE 

        int missing = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i+1 >= nums.length && nums[i] != nums.length){
                missing = nums.length; break;
            }
            else if(i+1 < nums.length && nums[i+1] != nums[i]+1 ){
                missing = nums[i]+1; break;
            } 
        }
        return missing;

*/

/* GPT O(n)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
*/

