class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0,high = letters.length-1;
        int mid = 0, prev_ind = 0;
        while(low<=high){
            mid = (low+high)/2;
            if(letters[mid] > target){
                prev_ind = mid; high = mid - 1;
            }
            else if(letters[mid] <= target) low = mid + 1;
        }
        
            return letters[prev_ind];
    }
}
