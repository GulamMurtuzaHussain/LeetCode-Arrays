class Solution {
    public int[] twoSum(int[] nums, int target) {
        // this problem has 4 approaches 1. Nested Loops 2. Sort + 2 pointers 3. HashMap 2 passes 4. HashMap 1 pass
        
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i; ans[1] = j; break;
                }
            }
        }
        return ans;
    }
}
 
// 2 Pointers
        // int[][] A = new int[nums.length][2];
        // for(int i=0;i<nums.length;i++){
        //     A[i][0] = nums[i];
        //     A[i][1] = i;
        // }

        // Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

        // int left = 0, right = nums.length-1;

        // while(left < right){
        //     int curr = A[left][0] + A[right][0];
        //     if(curr == target){
        //         return new int[]{Math.min(A[left][1], A[right][1]), Math.max(A[left][1],A[right][1])};
        //     }
        //     else if(curr < target ) left++;
        //     else right--;
        // }
        // return new int[0];



  // HashMap 2 passes
        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],i);
        // }

        // for(int i=0;i<nums.length;i++){
        //     int diff = target - nums[i];
        //     if(map.containsKey(diff) && map.get(diff) != i) 
        //         return new int[]{i,map.get(diff)};
        // }

        // return new int[0];


        // HashMap 1 pass
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i=0;i<nums.length;i++){
        //     int diff = target - nums[i];

        //     if(map.containsKey(diff)) return new int[]{map.get(diff),i};

        //     map.put(nums[i],i);
        // }

        // return new int[0];
