import java.util.Collections;
import java.util.Arrays;

/* BINARY SEARCH APPROACH

        double left = 0.0, right = 1.0;
        int numerator = 0, denominator = 1;
        int n = arr.length;

        while (true) {
            double mid = (left + right) / 2;
            int count = 0;
            double maxFraction = 0.0;

            int i = 0;
            numerator = 0;
            denominator = 1;

            for (int j = 1; j < n; j++) {
                // move i to the largest index such that arr[i]/arr[j] <= mid
                while (i < j && arr[i] <= mid * arr[j]) {
                    i++;
                }
                if (i == 0)
                    continue;
                count += i;

                double currentFraction = (double) arr[i - 1] / arr[j];
                if (currentFraction > maxFraction) {
                    maxFraction = currentFraction;
                    numerator = arr[i - 1];
                    denominator = arr[j];
                }
            } 

            if (count == k) {
                return new int[] { numerator, denominator };
            } else if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    
*/

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

      int totalPairs = arr.length * (arr.length - 1) / 2;
double[][] array = new double[totalPairs][3];
int a = 0;

for(int i = 0; i < arr.length; i++) {
    for(int j = i + 1; j < arr.length; j++) {
        array[a][0] = (double) arr[i]/(double) arr[j];
        array[a][1] = arr[i];
        array[a][2] = arr[j];
        a++;
    }
}

Arrays.sort(array,Comparator.comparingDouble(x -> x[0]));
// for(int i=0;i<a;i++){
//     for(int j=1;j<3;j++){
//         System.out.print(array[i][j] + "/");
//     }
//     System.out.print("  ");
// }
if(totalPairs <=1){
return new int[]{(int)array[0][1], (int)array[0][2]};    
}
// System.out.println((int)array[k][1] + " " +(int)array[k][2]);
return new int[]{(int)array[k-1][1], (int)array[k-1][2]};
    }
}

/*
🏆 Leaderboard Analogy (Detailed)
Imagine you have:

A list of players and their scores.

You want to find the k-th highest score.

But:

You don’t want to sort all scores because maybe there are too many.

Instead, you use a guessing + counting approach.

🌟 Step 1: Make a cutoff guess
You guess a cutoff score, let’s call it mid_score.

Example:

Maybe mid_score = 80.

🌟 Step 2: Count how many players scored ≤ mid_score
You go through the list and count:

Player A → 75 → yes (≤ 80)

Player B → 85 → no (> 80)

Player C → 80 → yes (≤ 80)

Let’s say total count = 10 players scored ≤ 80.

🌟 Step 3: Compare count to k
If count < k → it means the k-th highest score is above 80.

If count ≥ k → it means the k-th highest score is at most 80 (maybe exactly 80).

So:

You adjust your search:

Not enough players below → raise the cutoff (search higher).

Enough players below → lower the cutoff (search lower but track the best so far).

🌟 Step 4: Track the top scorer under cutoff
Even when the count is ≥ k, you don’t just stop —
you track the highest scorer ≤ cutoff.

Why?
Because after binary search, you need to return the actual k-th highest score,
not just the cutoff number.


🧩 Why can’t we just stop when count = k?
Because:

Multiple fractions can cluster near the cutoff.

You don’t know exactly which fraction is the k-th without tracking the biggest one under the current guess.

The binary search narrows how many are below a threshold,
but you need the actual fraction value when you’re done.

6
*/

/*
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<List<Integer>> fractions = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[j]);
                fractions.add(new ArrayList<>(temp));
            }
        }
        /*for (int i = 0; i < fractions.size(); i++) {
            for (int j = i + 1; j < fractions.size(); j++) {
                double a = (double) fractions.get(i).get(0) / fractions.get(i).get(1);
                double b = (double) fractions.get(j).get(0) / fractions.get(j).get(1);
                if (a > b) {
                    int temp_1 = fractions.get(i).get(0);
                    int temp_2 = fractions.get(i).get(1);
                    fractions.get(i).set(0, fractions.get(j).get(0));
                    fractions.get(i).set(1, fractions.get(j).get(1));
                    fractions.get(j).set(0, temp_1);
                    fractions.get(j).set(1, temp_2);
                }
            }
        }
        fractions.sort((f1, f2) -> Double.compare(
                (double) f1.get(0) / f1.get(1),
                (double) f2.get(0) / f2.get(1)));
        int[] ans = new int[2];
        ans[0] = fractions.get(k - 1).get(0);
        ans[1] = fractions.get(k - 1).get(1);
        return ans;
    }
*/
