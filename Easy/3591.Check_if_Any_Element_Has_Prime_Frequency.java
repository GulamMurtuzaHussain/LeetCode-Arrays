class Solution {

    public boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i == 0 && i != n) return false;
        }

        return true;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n , map.getOrDefault(n,0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > 1 && isPrime(map.get(key))) return true;
        }
        return false;
    }
}
