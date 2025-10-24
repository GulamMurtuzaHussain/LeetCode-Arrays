import java.util.Arrays;
class Solution {
  public boolean isArithmetic(List<Integer> L) {
        if (L.size() < 2) return true;
        int eq = L.get(1) - L.get(0);

        for (int i = 1; i < L.size(); i++) {
            if (L.get(i) - L.get(i - 1) != eq) return false;
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            // extract subarray
            List<Integer> temp = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                temp.add(nums[j]);
            }

            // sort
            Collections.sort(temp);

            // check arithmetic
            ans.add(isArithmetic(temp));
        }

        return ans;
    }
}


/*
   public boolean is_arithematic(List<Integer> L){
        int eq = L.get(1) - L.get(0);

        for(int i=0;i<L.size()-1;i++){
            if(L.get(i+1) - L.get(i) != eq) return false;
        }
        return true;
    }

    public List<Integer> reversed_sorted(List<Integer> L){
        int left = 0, right = L.size()-1;

        while(left < right){
            int temp = L.get(left);
            L.set(left,L.get(right));
            L.set(right,temp);
            left++; right--;
        }
        return L;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        HashMap<Integer,List<Integer>> sequences = new HashMap<>();

        for(int i=0;i<l.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=l[i];j<=r[i];j++){
                temp.add(nums[j]);
            }
            sequences.put(i,temp);
        }

        List<Boolean> ans = new ArrayList<>();
        int a = 0;
        for(int i=0;i<l.length;i++){
            List<Integer> temp = sequences.get(i);
            Collections.sort(temp);
            if(is_arithematic(temp)){
                ans.add(true); continue;
            }
            else if(is_arithematic(temp = reversed_sorted(sequences.get(i)))){
                ans.add(true); continue;
            }
            else ans.add(false);
        }
        return ans;
    }
    */1630. Arithmetic Subarrays
