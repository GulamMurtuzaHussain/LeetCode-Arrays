class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> distinct = new ArrayList<>();
        HashSet<Integer> temp = new HashSet<>();
        int no_elements = 0;

        while(no_elements < nums.length){
            for(int i=0;i<nums.length;i++){
                if(nums[i] != -1 && !temp.contains(nums[i]))
                { temp.add(nums[i]); nums[i] = -1; }
            }
            distinct.add(new ArrayList<>(temp));
            no_elements += temp.size(); temp.clear();
        }
        return distinct;
    }
}

/*
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> distinct = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int no_elements = 0;
        boolean[] visited = new boolean[nums.length];
        while(no_elements < nums.length)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(!visited[i] && !temp.contains(nums[i]))
                {
                    temp.add(nums[i]); no_elements++; visited[i] = true;
                }
            }
            distinct.add(new ArrayList<>(temp));
            temp.clear();
        }
        return distinct;
    }
*/


/*
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);
            if (result.size() <= count) {
                result.add(new ArrayList<>());
            }
            result.get(count).add(num);
            freq.put(num, count + 1);
        }

        return result;
    }
}
*/
