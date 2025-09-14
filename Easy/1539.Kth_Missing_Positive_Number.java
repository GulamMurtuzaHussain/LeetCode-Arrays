class Solution {
    public int findKthPositive(int[] arr, int k) {
        int miss_count = 0;
        for(int i=1;i<=arr[arr.length-1];i++){
            int low = 0, high = arr.length-1;
            int flag = 0;
            while(low<=high){
                int mid = (low+high)/2;
                if(arr[mid] == i){
                    flag = 1;
                    break;
                }
                else if(arr[mid] > i) high = mid -1;
                else low = mid + 1;
            }
            if(flag == 0 && miss_count<k) miss_count++;
            if(miss_count == k) return i;
        }
        return arr[arr.length-1]+(k - miss_count);

        /*
        Code behavior

        Outer loop:
            Runs from i = 1 to arr[arr.length-1].
            → That’s roughly O(max(arr)) iterations, but since arr is sorted and ends at arr[n-1],  
            let’s treat it as O(n + k) in the worst-case reasoning (because you stop early once k 
            missing numbers are found).

        Inner loop:
        Each iteration does a binary search in arr.
            → Cost = O(log n).

        Total time complexity
                    O((arr[n-1])⋅logn)

        But since you don’t actually go all the way to arr[n-1] (you stop after finding k missing 
        numbers), a tighter bound is:
                    O((n+k)⋅logn)

        👉 If k is small compared to n, then it feels like O(n log n).
        👉 If k is large (close to arr[n-1]), then it’s closer to O(arr[n-1] · log n).
        */
    }

}

/*
           int missingCount = 0;
        int max = arr[arr.length - 1];
        int ans = -1; // this will store our answer
        
        for (int i = 1; i >=0 ; i++) {
            boolean isPresent = false;
            // Check if i is present in arr
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                missingCount++;
                if (missingCount == k) {
                    ans = i;
                    break;
                }
            }
        }
        
        return ans;

/*
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;    // How many missing numbers found
        int i = 1;               // Start checking from 1
        int arrIndex = 0;        // Pointer for arr

        while (true) {
            if (arrIndex < arr.length && arr[arrIndex] == i) {
                arrIndex++;  // i is present in arr, move forward
            } else {
                missingCount++;  // i is missing
                if (missingCount == k) {
                    return i;    // Found the k-th missing number
                }
            }
            i++;
        }
    }
}
*/
