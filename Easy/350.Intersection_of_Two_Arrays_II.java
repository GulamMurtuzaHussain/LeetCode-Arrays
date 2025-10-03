import java.util.Arrays;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        
        int[] visited = new int[nums2.length];
        int v = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            int low = 0,high = nums2.length-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums2[mid] == nums1[i]){
                    ans.add(nums1[i]);
                    nums2[mid] = -1; Arrays.sort(nums2);
                    break;
                }
                else if(nums2[mid] > nums1[i] ) high = mid - 1;
                else if(nums2[mid]<nums1[i]) low = mid + 1;
            }
        }
        int[] answer = ans.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
