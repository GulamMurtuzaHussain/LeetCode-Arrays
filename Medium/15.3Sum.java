import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        int first = 0 ,sec = 0 , thr = nums.length-1;
    for(int i=0;i<nums.length;i++){     
        if(i>0 && nums[i] == nums[i-1]) continue; 
        first = i; sec= first+1; thr = nums.length-1;
        while(sec<thr){
            int sum= nums[first] + nums[sec] + nums[thr];
            if(sum == 0){
                List<Integer> triplets = new ArrayList<>();
                triplets.add(nums[first]);
                triplets.add(nums[sec]);
                triplets.add(nums[thr]);
                answer.add(triplets);
                while(sec<thr && nums[sec]==nums[sec+1]) sec++;
                while(sec<thr && nums[thr]==nums[thr-1]) thr--;
                sec++; thr--;
            }
            else if(sum<0){ sec++; }
            else thr--;
        }
    }


        return answer;
    }
}
