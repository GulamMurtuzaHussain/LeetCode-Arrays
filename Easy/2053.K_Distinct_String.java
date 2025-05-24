import java.util.*;

public class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each string
        for (String str : arr) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }

        // Step 2: Traverse the array to keep order and find k-th distinct
        int count = 0;
        for (String str : arr) {
            if (freq.get(str) == 1) {
                count++;
                if (count == k) {
                    return str;
                }
            }
        }

        return "";
    }
}
