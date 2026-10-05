class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(map.containsKey(n)) map.get(n).add(i);
            else map.put(n, new ArrayList<>(List.of(i)));
        }

        int max = 0, lowest = 999999;
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            // System.out.println(String.valueOf(list));
            // System.out.println("list size : " + list.size());
            // System.out.println("list size = " + list.size() + ", max = " + max);
            if(list.size() >= max){
                int l = list.get(0);
                int h = list.get(list.size()-1);
                // System.out.println(l + " " + h + " length :" + (h-l+1));
                if(((h-l)+1) < lowest) lowest = ((h-l)+1);
                if(list.size() > max) lowest = (h-l+1);
                max = list.size();  
            }
        }

        return lowest;
    }
}
