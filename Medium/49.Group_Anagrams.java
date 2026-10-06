class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       // Neet's solution using freq
       HashMap<String, List<String>> map = new HashMap<>();
       for(String s : strs){
           int[] count = new int[26];
           for(char c : s.toCharArray()) count[c - 'a']++;
           String key = Arrays.toString(count);
           map.putIfAbsent(key, new ArrayList<>());
           map.get(key).add(s);
       }
       return new ArrayList<>(map.values());
    }
}


/*
 // My approach after topics in NeetCode
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            if(!map.containsKey(st)){
                map.put(st, new ArrayList<>(List.of(i)));
            }
            else map.get(st).add(i);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String K : map.keySet()){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<map.get(K).size();i++){
                int ind = map.get(K).get(i);
                temp.add(strs[ind]);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
 */

/*
// Neet's solution using sorting
       HashMap<String, List<String>> map = new HashMap<>();
       for(String s : strs){
           char[] arr = s.toCharArray();
           Arrays.sort(arr);
           String temp = new String(arr);
           map.putIfAbsent(temp, new ArrayList<>());
           map.get(temp).add(s);
       }
       return new ArrayList<>(map.values()); 
*/49. Group Anagrams
