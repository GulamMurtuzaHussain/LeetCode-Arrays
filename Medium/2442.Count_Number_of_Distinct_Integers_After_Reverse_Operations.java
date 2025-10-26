class Solution {
    public static int reverse_digits(int num){
        int reversed = 0;
        while(num>0){
            int rem = num % 10;
            reversed = (reversed*10) + rem;
            num /= 10;
        }
        return reversed;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            unique.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            int reversed = reverse_digits(nums[i]);
            unique.add(reversed);
        }

        return unique.size();
    }
}
