class Solution {
    public long continuousSubarrays(int[] nums) {
        List<Integer> Max = new ArrayList<>();
        List<Integer> Min = new ArrayList<>();

        int left = 0, right = 0;
        long count = 0;

        while (right < nums.length) {
            // Maintain Max list in decreasing order
            while (Max.size() > 0 && Max.get(Max.size() - 1) < nums[right])
                Max.remove(Max.size() - 1);
            Max.add(nums[right]);

            // Maintain Min list in increasing order
            while (Min.size() > 0 && Min.get(Min.size() - 1) > nums[right])
                Min.remove(Min.size() - 1);
            Min.add(nums[right]);

            // Shrink window if invalid
            while (Max.get(0) - Min.get(0) > 2) {
                if (nums[left] == Max.get(0))
                    Max.remove(0);
                if (nums[left] == Min.get(0))
                    Min.remove(0);
                left++;
            }

            // Count all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }
}


/*
        int left = 0, right = nums.length-1;
        int count = nums.length;

        while(left<right){
            int max = nums[left], min = nums[left];
            int i=left+1;
            while(i<=right){
                if(nums[i]>max) max = nums[i];
                else if(nums[i]<min) min = nums[i];
                if(max-min > 2) break;
                i++;
                count++;
            }
            left++;
        }
        return count;
*/
