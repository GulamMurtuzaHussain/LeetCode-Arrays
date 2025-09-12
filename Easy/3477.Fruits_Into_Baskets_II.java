class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int[] used = new int[baskets.length];
        int u = 0;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<baskets.length;j++){
                if(used[j] == 0 && baskets[j]>= fruits[i]){
                    used[j] = 1;
                    count++;
                    break;
                }
            }
        }
        return baskets.length-count;
    }
}
