import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        // for(int i=0;i<arr.length/2;i++){
        //     int temp = arr[i];
        //     arr[i] = arr[arr.length - 1 - i];
        //     arr[arr.length-1-i] = temp;
        // }

        for(int i=0;i<arr.length;i++){
            int low = 0, high = arr.length - 1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(arr[mid] * 2 == arr[i] && mid == i) break;
                if(arr[mid] * 2 == arr[i]) return true;
                else if(arr[mid] * 2 > arr[i]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return false;
    }
    /*
         // Create value-index pairs
        int[][] pairs = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            pairs[i][0] = arr[i];  // value
            pairs[i][1] = i;       // original index
        }
    
        // Sort pairs by value
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
    
        for (int i = 0; i < pairs.length; i++) {
            int target = 2 * pairs[i][0];
            int index = binarySearch(pairs, target);
            if (index != -1 && pairs[index][1] != pairs[i][1]) {
                return true;
            }
        }
        return false;
    }
    
    private int binarySearch(int[][] pairs, int target) {
        int low = 0, high = pairs.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pairs[mid][0] == target) {
                return mid;
            } else if (pairs[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    */
}

/*
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
*/
