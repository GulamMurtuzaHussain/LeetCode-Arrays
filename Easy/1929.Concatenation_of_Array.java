class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] array = new int[2*length];
 
        int j=0;
        for(int i=0;i<length;i++){
            array[j++] = nums[i];
        }
        for(int i=0;i<length;i++){
            array[j++] = nums[i];
        }
        return array;
    }
}
