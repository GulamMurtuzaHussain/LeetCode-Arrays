class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // MINE
        Collections.sort(nums);
        int pairs = 0;
        for(int i=0;i<nums.size();i++){
            int low=i, high = nums.size()-1, mid=(low+high)/2, index = 0;
            while(low<=high){
                mid = (low+high)/2;
                if(nums.get(i) + nums.get(mid) < target){
                    index = mid - i;
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
                
            }
            pairs += index;
        }
        return pairs;
    }
}

/* MINE
        int pairs = 0;
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(i) + nums.get(j) < target) pairs++;
            }
        }
        return pairs;
    }
/


/* GPT
Collections.sort(nums); // sort the list first
int i = 0, j = nums.size() - 1;
int count = 0;

while (i < j) {
    if (nums.get(i) + nums.get(j) < target) {
        count += (j - i); // all pairs from i to j work
        i++;
    } else {
        j--;
    }
}
return count;

*/
