import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int distance = 0;
        for(int i=0;i<arr1.length;i++){
            int is_Invalid = InvalidElement(arr1[i],arr2,d);
            if(is_Invalid == 0) distance++;
        }
        return distance;
    }

    static int InvalidElement(int arr1,int[] arr2,int d){
        int low = 0, high = arr2.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(Math.abs(arr2[mid] - arr1) <= d) return 1;
            else if(arr2[mid] > arr1) high = mid - 1;
            else low = mid + 1;
        }
        return 0;
    }
}

/* PREVIOUS
Arrays.sort(arr2); // Sort arr2 for binary search
        int count = 0;

        for (int num : arr1) {
            if (isFarEnough(num, arr2, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isFarEnough(int target, int[] arr2, int d) {
        int low = 0, high = arr2.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int diff = Math.abs(target - arr2[mid]);

            if (diff <= d) {
                return false; // Found a close enough element
            }

            if (arr2[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return true; // All elements are at distance > d
    }
    */
