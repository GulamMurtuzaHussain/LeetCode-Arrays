class Solution {
    public int[] minOperations(String boxes) {
      List<Integer> ones = new ArrayList<>();
      for(int i=0;i<boxes.length();i++){
        if(boxes.charAt(i) == '1') ones.add(i);
      }

      int[] ans = new int[boxes.length()];
      for(int i=0;i<boxes.length();i++){
        int sum = 0;
        for(int j=0;j<ones.size();j++){ 
            sum += Math.abs(i-ones.get(j));
        }
        ans[i] = sum;
      }
      return ans;
    }
}
