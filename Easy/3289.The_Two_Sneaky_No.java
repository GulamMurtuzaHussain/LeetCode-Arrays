class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        List<Integer> sneaky = new ArrayList<>();
        for(int i=0;i<=100;i++){
            if(freq[i]>1) sneaky.add(i);
        }
        int[] ans = new int[sneaky.size()];
        int k =0 ;
        for(int i=0;i<sneaky.size();i++){
            ans[k++] = sneaky.get(i);
        }
        return ans;
    }
}
