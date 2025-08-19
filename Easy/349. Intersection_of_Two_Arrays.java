import java.util.Arrays;
class Solution {
// solved using BS
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
      
        List<Integer> temp = new ArrayList<>();

        for(int i=0;i<nums1.length;i++){
            if(i>0 && nums1[i]==nums1[i-1]) continue;
            int low = 0,high = nums2.length -1;
            while(low<=high){
                int mid = (low+high) / 2;
                if(nums2[mid] == nums1[i]){
                    temp.add(nums2[mid]); break;
                }
                else if(nums2[mid] > nums1[i]) high = mid - 1;
                else low = mid + 1;
            }
        }
        int[] intersection = new int[temp.size()];
        for(int i=0;i<temp.size();i++){ // or use stream.
            intersection[i] = temp.get(i);
        }
        return intersection;
    }
}
