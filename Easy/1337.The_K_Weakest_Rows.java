import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];

        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] == 1) count++;
            }
            soldiers[i] = count;
         }

        Integer[] indices = new Integer[mat.length];
        for(int i=0;i<mat.length;i++){
            indices[i] = i;
        }

        Arrays.sort(indices,(a,b) -> {
            if(soldiers[a] != soldiers[b]) return soldiers[a] - soldiers[b];
            else return a- b;
        });
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = indices[i];
        }
        return result;
    }
}

// 👇 Breakdown of if-else:
// 🔹 if (soldiers[a] != soldiers[b])
// Comparing two rows a and b by their strength (i.e., number of soldiers in the row).

// If they're different, we want the row with fewer soldiers to come first.

// 👉 return soldiers[a] - soldiers[b];
// This tells the sort:

// Negative result → a comes before b

// Positive result → b comes before a

// Zero → move to else condition

// So it sorts by ascending soldier count (i.e., weakest rows first).

/*
     for (int i = 0; i < indices.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < indices.length; j++) {
                if (soldiers[indices[j]] < soldiers[indices[minIndex]] || 
                   (soldiers[indices[j]] == soldiers[indices[minIndex]] && indices[j] < indices[minIndex])) {
                    minIndex = j;
                }
            }
            // Swap indices
            int temp = indices[i];
            indices[i] = indices[minIndex];
            indices[minIndex] = temp;
        }
*/
