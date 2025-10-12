class Solution {
    public int[] pivotArray(int[] nums, int pivot) 
    {
        int[] answer = new int[nums.length];
        int a = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) answer[a++] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot) answer[a++] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot) answer[a++] = nums[i];
        }
        return answer;
    }   
}
